package avro2s.benchmarks

import org.apache.avro.Schema
import org.apache.avro.specific.SpecificRecord

import scala.io.Source

/**
 * Resolves a named shape to a Workload for a given arm.
 *
 * An arm is just a package of generated models. "current" is the working tree's output, compiled
 * by the build. "baseline" is another revision's output, dropped in by scripts/compare-benchmarks.sh;
 * when that script has not run, the baseline package is absent and the arm reports unavailable
 * rather than failing to compile.
 */
object Workloads {
  val currentArm = "current"
  val baselineArm = "baseline"

  private val modelNamespace = "avro2s.benchmarks.models"
  private val baselineNamespace = "avro2s.benchmarks.baseline"

  /** Shape name -> (schema resource directory, generated record name). */
  private val shapes: Map[String, (String, String)] = Map(
    "primitives" -> ("default", "Primitives"),
    "strings" -> ("default", "Strings"),
    "bytes" -> ("default", "Bytes"),
    "identityArrays" -> ("default", "IdentityArrays"),
    "convertingArrays" -> ("default", "ConvertingArrays"),
    "maps" -> ("default", "Maps"),
    "unions" -> ("default", "Unions"),
    "javaEnums" -> ("default", "JavaEnums"),
    "wideRecord" -> ("default", "WideRecord"),
    "logicalTypes" -> ("logical", "LogicalTypes"),
    "scalaEnums" -> ("scala-enums", "ScalaEnums")
  )

  val names: List[String] = shapes.keys.toList.sorted

  def namespaceFor(arm: String): String = arm match {
    case `currentArm` => modelNamespace
    case `baselineArm` => baselineNamespace
    case other => sys.error(s"Unknown benchmark arm: $other")
  }

  def available(arm: String): Boolean =
    names.forall(shape => recordClass(arm, shape).isDefined)

  def apply(arm: String, shape: String, size: Int = Workload.defaultSize): Workload = {
    val namespace = namespaceFor(arm)
    val clazz = recordClass(arm, shape).getOrElse {
      sys.error(
        s"No generated model for arm '$arm'. Run scripts/compare-benchmarks.sh to generate the " +
          s"baseline arm, or restrict the run to -p arm=$currentArm."
      )
    }
    new Workload(s"$arm/$shape", clazz, schemaFor(shape, namespace), size)
  }

  private def recordClass(arm: String, shape: String): Option[Class[_ <: SpecificRecord]] = {
    val (_, record) = shapes(shape)
    try Some(Class.forName(s"${namespaceFor(arm)}.$record").asSubclass(classOf[SpecificRecord]))
    catch { case _: ClassNotFoundException => None }
  }

  // The schema is read from the same resource the models were generated from, with the namespace
  // rewritten exactly as GenerateBenchmarkModels rewrites it, so each arm's reader resolves its
  // own classes. Only the namespace differs; the wire layout is identical across arms.
  private def schemaFor(shape: String, namespace: String): Schema = {
    val (directory, record) = shapes(shape)
    val resource = s"/avro/$directory/$record.avsc"
    val stream = Option(getClass.getResourceAsStream(resource))
      .getOrElse(sys.error(s"Missing benchmark schema resource: $resource"))
    val json = try Source.fromInputStream(stream, "UTF-8").mkString finally stream.close()
    new Schema.Parser().parse(json.replace(s""""$modelNamespace"""", s""""$namespace""""))
  }
}

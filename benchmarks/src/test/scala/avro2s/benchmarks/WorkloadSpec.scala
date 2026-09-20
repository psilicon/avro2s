package avro2s.benchmarks

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * The guard suite. Benchmarks only report numbers; nothing in a JMH run asserts the generated
 * code is correct. This runs with the ordinary test task so a shape cannot silently start
 * measuring broken output.
 */
class WorkloadSpec extends AnyWordSpec with Matchers {
  private val sizes = List(0, 1, 16, 256)

  "every benchmark shape" should {
    Workloads.names.foreach { shape =>
      s"round-trip '$shape' through the generated model at every benchmarked size" in {
        sizes.foreach { size =>
          withClue(s"shape $shape at size $size: ") {
            Workloads(Workloads.currentArm, shape, size).verify()
          }
        }
      }
    }

    "cover every schema in the benchmark resources" in {
      val resources = new java.io.File("benchmarks/src/main/resources/avro")
      // Run from the repository root by sbt; skip rather than fail if invoked elsewhere.
      if (resources.isDirectory) {
        val schemaNames = resources.listFiles().toList
          .filter(_.isDirectory)
          .flatMap(directory => Option(directory.listFiles()).toList.flatten)
          .filter(_.getName.endsWith(".avsc"))
          .map(_.getName.stripSuffix(".avsc"))
          .sorted
        val covered = Workloads.names.map(shape => Workloads(Workloads.currentArm, shape).schema.getName).sorted
        covered should contain theSameElementsAs schemaNames
      }
    }
  }

  "the current arm" should {
    "expose a generated model for every shape" in {
      Workloads.available(Workloads.currentArm) shouldBe true
    }
  }
}

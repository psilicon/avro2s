package avro2s.generator.specific

import avro2s.error.Error.SchemaError
import avro2s.generator.logical.LogicalTypes.LogicalTypeConverter
import org.apache.avro.Schema
import org.apache.avro.Schema.Type._

import scala.jdk.CollectionConverters._

/**
 * Rejects unions that avro2s cannot generate correct code for.
 *
 * Avro keeps union branches apart by type name, but avro2s maps each branch to a Scala type, and a
 * logical type can collapse two branches onto one: `time-millis` is an int and `time-micros` is a
 * long, so Avro accepts them in the same union, yet both become `java.time.LocalTime`.
 *
 * Generating for such a union produces two identical, indistinguishable branch cases. Reads stay
 * correct - the decoder resolves the branch itself - but writes cannot: `GenericData.resolveUnion`
 * picks a branch by the datum's class, so every value is encoded as whichever branch was declared
 * first. That is silent, and worse than truncation. A consumer whose schema carries only the other
 * branch decodes the payload through the wrong conversion, and Avro's int-to-long promotion means it
 * does so without complaint - a `time-millis` of 20:35:34.567 read back as 00:01:14.134567.
 *
 * Generating nothing is the honest option, and costs the user little: with logical types disabled
 * the same branches map to `Int` and `Long`, which are distinct and round-trip correctly.
 */
private[avro2s] object UnionValidator {
  def validate(schema: Schema, ltc: LogicalTypeConverter): Unit =
    if (schema.getType == RECORD)
      schema.getFields.asScala.foreach(field => check(field.schema(), s"${schema.getFullName}.${field.name}", ltc))

  private def check(schema: Schema, path: String, ltc: LogicalTypeConverter): Unit =
    schema.getType match {
      case ARRAY => check(schema.getElementType, s"$path[]", ltc)
      case MAP => check(schema.getValueType, s"$path{}", ltc)
      case UNION =>
        val branches = schema.getTypes.asScala.toList
        branches.groupBy(scalaTypeOf(_, ltc)).toList.sortBy(_._1).foreach {
          case (scalaType, colliding) if colliding.size > 1 => throw SchemaError(message(path, scalaType, colliding))
          case _ => ()
        }
        // A branch is never itself a union, but it can be an array or map holding one.
        branches.foreach(check(_, path, ltc))
      // Named types are compiled in their own right, so they are validated on their own pass. Not
      // descending into them here is also what keeps a recursive schema from recursing forever.
      case _ => ()
    }

  /**
   * With logical types disabled the converter is empty, so this is the Avro type name for every
   * branch - and Avro has already rejected duplicates of those. The check then cannot fire, which is
   * exactly right: only a logical type can map two branches onto a single Scala type.
   */
  private def scalaTypeOf(branch: Schema, ltc: LogicalTypeConverter): String =
    ltc.getType(branch, branch.getFullName)

  private def message(path: String, scalaType: String, colliding: List[Schema]): String =
    s"Union at $path has ${colliding.size} branches that all generate $scalaType: " +
      colliding.map(describe).mkString(", ") + ". avro2s cannot tell them apart when writing, so " +
      "values would be silently encoded as whichever branch comes first. Generate this schema with " +
      "logical types disabled to map the branches to distinct Scala types instead."

  private def describe(branch: Schema): String =
    Option(branch.getLogicalType)
      .map(logicalType => s"${branch.getType.getName} (${logicalType.getName})")
      .getOrElse(branch.getType.getName)
}

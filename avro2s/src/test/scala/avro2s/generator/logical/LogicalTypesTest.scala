package avro2s.generator.logical

import avro2s.test.spec.md5
import org.apache.avro.Schema
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class LogicalTypesTest extends AnyFunSuite with Matchers {
  
  // TODO: remove these tests
  
  test("LogicalTypesTest") {
    val schemaString =
      """{
        |  "type": "record",
        |  "name": "DecimalExample",
        |  "fields":[
        |    {
        |      "name":"decimalField",
        |      "type":{
        |        "type":"bytes",
        |        "logicalType": "decimal",
        |        "precision":4,
        |        "scale":2
        |      }
        |    }
        |  ]
        |}""".stripMargin

    val decimalFieldSchema: Schema = new Schema.Parser().parse(schemaString).getField("decimalField").schema()
    val logicalType = decimalFieldSchema.getLogicalType
    val precision = logicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal].getPrecision
    val scale = logicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal].getScale
    
    logicalType.getName shouldEqual "decimal"
    precision shouldEqual 4
    scale shouldEqual 2
    
    val hex = 0x12345678
    val bigDecimal = BigDecimal(hex, scale)
    val bigDP = bigDecimal.underlying().precision()
    bigDecimal.toString() shouldEqual "3054198.96"
    bigDP shouldEqual 9
    hex.toString shouldBe "305419896"
    bigDecimal.underlying().unscaledValue().toByteArray shouldEqual Array[Byte](18, 52, 86, 120)
    bigDecimal.underlying().unscaledValue().toByteArray shouldEqual Array[Byte](0x12, 0x34, 0x56, 0x78)
    BigDecimal("305419896") shouldBe BigDecimal(hex, 0)
  }
  
  test("fixed schema test (get the fixed size from a fixed schema)") {
    val schemaString =
      """{
        |  "type": "record",
        |  "name": "FixedExample",
        |  "fields":[
        |    {
        |      "name":"fixedField",
        |      "type":{
        |        "type":"fixed",
        |        "name":"Fixed",
        |        "size":16
        |      }
        |    }
        |  ]
        |}""".stripMargin
        
    val fixedFieldSchema: Schema = new Schema.Parser().parse(schemaString).getField("fixedField").schema()
    val fixedSize = fixedFieldSchema.getFixedSize
  }
  
  test("fixed bytes") {
    val fixed = md5(Array[Byte](0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15))
    
    val bigInt = new java.math.BigInteger(fixed.bytes)
    val bigDecimal = BigDecimal(bigInt, 5)
    
    bigInt.toString shouldEqual "5233100606242806050955395731361295"
    bigDecimal.toString shouldEqual "52331006062428060509553957313.61295"
    
    bigDecimal.underlying().scale() shouldEqual 5
  }
}

/** GENERATED CODE */

package avro2s.test.logical

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class ComplexLogicalTypes(var _map: Map[String, java.util.UUID], var _map_fixed: Map[String, BigDecimal], var _map_bytes: Map[String, BigDecimal], var _array: List[java.time.LocalDate], var _array_fixed: List[BigDecimal], var _array_bytes: List[BigDecimal], var _union: Int :+: java.time.Instant :+: CNil, var _union_fixed: BigDecimal :+: java.time.Instant :+: CNil, var _union_bytes: BigDecimal :+: java.time.Instant :+: CNil, var _option: Option[java.util.UUID], var _option_fixed: Option[BigDecimal], var _option_bytes: Option[BigDecimal], var _map_union: Map[String, Int :+: java.time.Instant :+: CNil], var _map_union_fixed: Map[String, Int :+: BigDecimal :+: CNil], var _map_union_bytes: Map[String, Int :+: BigDecimal :+: CNil], var _map_array: Map[String, List[java.time.LocalDate]], var _map_array_fixed: Map[String, List[BigDecimal]], var _union_map: Int :+: Map[String, java.util.UUID] :+: CNil, var _union_map_fixed: Int :+: Map[String, BigDecimal] :+: CNil, var _union_map_bytes: Int :+: Map[String, BigDecimal] :+: CNil, var _union_array: Int :+: List[java.time.LocalDate] :+: CNil, var _union_array_fixed: Int :+: List[BigDecimal] :+: CNil, var _union_array_bytes: Int :+: List[BigDecimal] :+: CNil, var _array_map: List[Map[String, java.util.UUID]], var _array_map_fixed: List[Map[String, BigDecimal]], var _array_map_bytes: List[Map[String, BigDecimal]], var _array_union: List[Int :+: java.time.Instant :+: CNil], var _array_union_fixed: List[Int :+: BigDecimal :+: CNil], var _array_union_bytes: List[Int :+: BigDecimal :+: CNil], var _map_option_fixed: Map[String, Option[BigDecimal]], var _map_option_bytes: Map[String, Option[BigDecimal]], var _array_option_fixed: List[Option[BigDecimal]], var _array_option_bytes: List[Option[BigDecimal]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Map.empty, Map.empty, Map.empty, List.empty, List.empty, List.empty, Inl(0), Inl(BigDecimal(0)), Inl(BigDecimal(0)), None, None, None, Map.empty, Map.empty, Map.empty, Map.empty, Map.empty, Inl(0), Inl(0), Inl(0), Inl(0), Inl(0), Inl(0), List.empty, List.empty, List.empty, List.empty, List.empty, List.empty, Map.empty, Map.empty, List.empty, List.empty)

  override def getSchema: org.apache.avro.Schema = ComplexLogicalTypes.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map.foreach { kvp =>
          val key = kvp._1
          val value = {
            {kvp._2.toString}
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 1 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = kvp._2.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 2 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_bytes.foreach { kvp =>
          val key = kvp._1
          val value = {
            {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = kvp._2.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 3 => _array match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              {x.toEpochDay}.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 4 => _array_fixed match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 5 => _array_bytes match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { bytes =>
              {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = bytes.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
            }
          }.toBuffer).asJava
        }
      case 6 => _union match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.toEpochMilli}.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 7 => _union_fixed match {
        case Inl(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => {x.toEpochMilli}.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 8 => _union_bytes match {
        case Inl(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
        case Inr(Inl(x)) => {x.toEpochMilli}.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 9 => _option match {
        case None => null
        case Some(x) => {x.toString}.asInstanceOf[AnyRef]
      }
      case 10 => _option_fixed match {
        case None => null
        case Some(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
      }
      case 11 => _option_bytes match {
        case None => null
        case Some(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
      }
      case 12 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_union.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => {x.toEpochMilli}.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 13 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_union_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 14 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_union_bytes.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
              case _ => throw new AvroRuntimeException("Invalid value")
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 15 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_array.foreach { kvp =>
          val key = kvp._1
          val value = {
            scala.jdk.CollectionConverters.BufferHasAsJava({
              kvp._2.map { x =>
                {x.toEpochDay}.asInstanceOf[AnyRef]
              }
            }.toBuffer).asJava
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 16 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_array_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            scala.jdk.CollectionConverters.BufferHasAsJava({
              kvp._2.map { x =>
                {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
              }
            }.toBuffer).asJava
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 17 => _union_map match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              {kvp._2.toString}
            }
            map.put(key, value)
          }
          map
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 18 => _union_map_fixed match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = kvp._2.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}
            }
            map.put(key, value)
          }
          map
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 19 => _union_map_bytes match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = kvp._2.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
            }
            map.put(key, value)
          }
          map
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 20 => _union_array match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>{x.toEpochDay}.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 21 => _union_array_fixed match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>{val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 22 => _union_array_bytes match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>{val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 23 => _array_map match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { m =>
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
              m.foreach { kvp =>
                val key = kvp._1
                val value = {
                  {kvp._2.toString}
                }
                map.put(key, value)
              }
              map
            }
          }.toBuffer).asJava
        }
      case 24 => _array_map_fixed match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { m =>
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
              m.foreach { kvp =>
                val key = kvp._1
                val value = {
                  {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = kvp._2.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}
                }
                map.put(key, value)
              }
              map
            }
          }.toBuffer).asJava
        }
      case 25 => _array_map_bytes match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { m =>
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
              m.foreach { kvp =>
                val key = kvp._1
                val value = {
                  {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = kvp._2.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
                }
                map.put(key, value)
              }
              map
            }
          }.toBuffer).asJava
        }
      case 26 => _array_union match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => {x.toEpochMilli}.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
            }
          }.toBuffer).asJava
        }
      case 27 => _array_union_fixed match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
              case _ => throw new AvroRuntimeException("Invalid value")
            }
          }.toBuffer).asJava
        }
      case 28 => _array_union_bytes match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Inl(x) => x.asInstanceOf[AnyRef]
              case Inr(Inl(x)) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
              case _ => throw new AvroRuntimeException("Invalid value")
            }
          }.toBuffer).asJava
        }
      case 29 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_option_fixed.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case None => null
              case Some(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 30 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        _map_option_bytes.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2 match {
              case None => null
              case Some(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
            }
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 31 => _array_option_fixed match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val bigDecimal = x.bigDecimal.setScale(scale); LogicalTypes.decimalConversion.toFixed(bigDecimal, schema, decimalType)}.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 32 => _array_option_bytes match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case None => null
              case Some(x) => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; val scale = decimalType.getScale(); val scaledValue = x.setScale(scale); val bigDecimal = scaledValue.bigDecimal; LogicalTypes.decimalConversion.toBytes(bigDecimal, schema, decimalType)}
            }
          }.toBuffer).asJava
        }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._map = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                {java.util.UUID.fromString(value.toString)}
              })
            }
          }
        }
      }
      case 1 => this._map_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(value.asInstanceOf[avro2s.test.logical.FixedDecimal].asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}
              })
            }
          }
        }
      }
      case 2 => this._map_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case buffer: java.nio.ByteBuffer => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(buffer, schema, decimalType))}
                }
              })
            }
          }
        }
      }
      case 3 => this._array = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              {java.time.LocalDate.ofEpochDay(value.asInstanceOf[Int])}
            }).toList
          }
      }
      case 4 => this._array_fixed = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(value.asInstanceOf[avro2s.test.logical.FixedDecimal].asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}
            }).toList
          }
      }
      case 5 => this._array_bytes = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case buffer: java.nio.ByteBuffer => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(buffer, schema, decimalType))}
              }
            }).toList
          }
      }
      case 6 => value match {
        case x: Int => this._union = Coproduct[Int :+: java.time.Instant :+: CNil](x)
        case x: Long => this._union = Coproduct[Int :+: java.time.Instant :+: CNil]({java.time.Instant.ofEpochMilli(x)})
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 7 => value match {
        case x: avro2s.test.logical.FixedDecimal => this._union_fixed = Coproduct[BigDecimal :+: java.time.Instant :+: CNil]({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(x.asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))})
        case x: Long => this._union_fixed = Coproduct[BigDecimal :+: java.time.Instant :+: CNil]({java.time.Instant.ofEpochMilli(x)})
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 8 => value match {
        case x: java.nio.ByteBuffer => this._union_bytes = Coproduct[BigDecimal :+: java.time.Instant :+: CNil]({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(x, schema, decimalType))})
        case x: Long => this._union_bytes = Coproduct[BigDecimal :+: java.time.Instant :+: CNil]({java.time.Instant.ofEpochMilli(x)})
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 9 => value match {
        case null => this._option = None
        case x => this._option = Some({java.util.UUID.fromString(x.toString)}.asInstanceOf[java.util.UUID])
      }
      case 10 => value match {
        case null => this._option_fixed = None
        case x: avro2s.test.logical.FixedDecimal => this._option_fixed = Some({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(x.asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))})
      }
      case 11 => value match {
        case null => this._option_bytes = None
        case x: java.nio.ByteBuffer => this._option_bytes = Some({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(x, schema, decimalType))})
      }
      case 12 => this._map_union = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: Int => Coproduct[Int :+: java.time.Instant :+: CNil](x)
                  case x: Long => Coproduct[Int :+: java.time.Instant :+: CNil]({java.time.Instant.ofEpochMilli(x)})
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
      case 13 => this._map_union_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: Int => Coproduct[Int :+: BigDecimal :+: CNil](x)
                  case x: avro2s.test.logical.FixedDecimal => Coproduct[Int :+: BigDecimal :+: CNil]({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(x.asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))})
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
      case 14 => this._map_union_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case x: Int => Coproduct[Int :+: BigDecimal :+: CNil](x)
                  case x: java.nio.ByteBuffer => Coproduct[Int :+: BigDecimal :+: CNil]({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(x, schema, decimalType))})
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              })
            }
          }
        }
      }
      case 15 => this._map_array = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case array: java.util.List[_] =>
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      {java.time.LocalDate.ofEpochDay(value.asInstanceOf[Int])}
                    }).toList
                  }
              })
            }
          }
        }
      }
      case 16 => this._map_array_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case array: java.util.List[_] =>
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(value.asInstanceOf[avro2s.test.logical.FixedDecimal].asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}
                    }).toList
                  }
              })
            }
          }
        }
      }
      case 17 => value match {
        case x: Int => this._union_map = Coproduct[Int :+: Map[String, java.util.UUID] :+: CNil](x)
        case map: java.util.Map[_,_] => this._union_map = Coproduct[Int :+: Map[String, java.util.UUID] :+: CNil]({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              {java.util.UUID.fromString(value.toString)}
            })
          }
        })
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 18 => value match {
        case x: Int => this._union_map_fixed = Coproduct[Int :+: Map[String, BigDecimal] :+: CNil](x)
        case map: java.util.Map[_,_] => this._union_map_fixed = Coproduct[Int :+: Map[String, BigDecimal] :+: CNil]({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(value.asInstanceOf[avro2s.test.logical.FixedDecimal].asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}
            })
          }
        })
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 19 => value match {
        case x: Int => this._union_map_bytes = Coproduct[Int :+: Map[String, BigDecimal] :+: CNil](x)
        case map: java.util.Map[_,_] => this._union_map_bytes = Coproduct[Int :+: Map[String, BigDecimal] :+: CNil]({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case buffer: java.nio.ByteBuffer => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(buffer, schema, decimalType))}
              }
            })
          }
        })
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 20 => value match {
        case x: Int => this._union_array = Coproduct[Int :+: List[java.time.LocalDate] :+: CNil](x)
        case x: java.util.List[_] => this._union_array = Coproduct[Int :+: List[java.time.LocalDate] :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                {java.time.LocalDate.ofEpochDay(value.asInstanceOf[Int])}
              }).toList
            }
        }.toList)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 21 => value match {
        case x: Int => this._union_array_fixed = Coproduct[Int :+: List[BigDecimal] :+: CNil](x)
        case x: java.util.List[_] => this._union_array_fixed = Coproduct[Int :+: List[BigDecimal] :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(value.asInstanceOf[avro2s.test.logical.FixedDecimal].asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}
              }).toList
            }
        }.toList)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 22 => value match {
        case x: Int => this._union_array_bytes = Coproduct[Int :+: List[BigDecimal] :+: CNil](x)
        case x: java.util.List[_] => this._union_array_bytes = Coproduct[Int :+: List[BigDecimal] :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case buffer: java.nio.ByteBuffer => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(buffer, schema, decimalType))}
                }
              }).toList
            }
        }.toList)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 23 => this._array_map = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case map: java.util.Map[_,_] => {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      {java.util.UUID.fromString(value.toString)}
                    })
                  }
                }
              }
            }).toList
          }
      }
      case 24 => this._array_map_fixed = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case map: java.util.Map[_,_] => {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(value.asInstanceOf[avro2s.test.logical.FixedDecimal].asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}
                    })
                  }
                }
              }
            }).toList
          }
      }
      case 25 => this._array_map_bytes = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case map: java.util.Map[_,_] => {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value match {
                        case buffer: java.nio.ByteBuffer => {val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(buffer, schema, decimalType))}
                      }
                    })
                  }
                }
              }
            }).toList
          }
      }
      case 26 => this._array_union = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: Int => Coproduct[Int :+: java.time.Instant :+: CNil](x)
                case x: Long => Coproduct[Int :+: java.time.Instant :+: CNil]({java.time.Instant.ofEpochMilli(x)})
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            }).toList
          }
      }
      case 27 => this._array_union_fixed = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: Int => Coproduct[Int :+: BigDecimal :+: CNil](x)
                case x: avro2s.test.logical.FixedDecimal => Coproduct[Int :+: BigDecimal :+: CNil]({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(x.asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))})
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            }).toList
          }
      }
      case 28 => this._array_union_bytes = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case x: Int => Coproduct[Int :+: BigDecimal :+: CNil](x)
                case x: java.nio.ByteBuffer => Coproduct[Int :+: BigDecimal :+: CNil]({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(x, schema, decimalType))})
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            }).toList
          }
      }
      case 29 => this._map_option_fixed = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x => Some({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(x.asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}.asInstanceOf[BigDecimal])
                }
              })
            }
          }
        }
      }
      case 30 => this._map_option_bytes = {
        value match {
          case map: java.util.Map[_,_] => {
            scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
              val key = kvp._1.toString
              val value = kvp._2
              (key, {
                value match {
                  case null => None
                  case x => Some({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(x.asInstanceOf[java.nio.ByteBuffer], schema, decimalType))}.asInstanceOf[BigDecimal])
                }
              })
            }
          }
        }
      }
      case 31 => this._array_option_fixed = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x => Some({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromFixed(x.asInstanceOf[avro2s.test.logical.FixedDecimal], schema, decimalType))}.asInstanceOf[BigDecimal])
              }
            }).toList
          }
      }
      case 32 => this._array_option_bytes = {
        value match {
          case array: java.util.List[_] =>
            scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
              value match {
                case null => None
                case x => Some({val schema = getSchema.getFields.get(field$).schema(); val decimalType = schema.getLogicalType.asInstanceOf[org.apache.avro.LogicalTypes.Decimal]; BigDecimal(LogicalTypes.decimalConversion.fromBytes(x.asInstanceOf[java.nio.ByteBuffer], schema, decimalType))}.asInstanceOf[BigDecimal])
              }
            }).toList
          }
      }
    }
  }
}

object ComplexLogicalTypes {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"ComplexLogicalTypes","namespace":"avro2s.test.logical","fields":[{"name":"_map","type":{"type":"map","values":{"type":"string","logicalType":"uuid"}}},{"name":"_map_fixed","type":{"type":"map","values":{"type":"fixed","name":"FixedDecimal","size":2,"logicalType":"decimal","precision":4,"scale":2}}},{"name":"_map_bytes","type":{"type":"map","values":{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}}},{"name":"_array","type":{"type":"array","items":{"type":"int","logicalType":"date"}}},{"name":"_array_fixed","type":{"type":"array","items":"FixedDecimal"}},{"name":"_array_bytes","type":{"type":"array","items":{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}}},{"name":"_union","type":["int",{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_union_fixed","type":["FixedDecimal",{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_union_bytes","type":[{"type":"bytes","logicalType":"decimal","precision":4,"scale":2},{"type":"long","logicalType":"timestamp-millis"}]},{"name":"_option","type":["null",{"type":"string","logicalType":"uuid"}]},{"name":"_option_fixed","type":["null","FixedDecimal"]},{"name":"_option_bytes","type":["null",{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}]},{"name":"_map_union","type":{"type":"map","values":["int",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_map_union_fixed","type":{"type":"map","values":["int","FixedDecimal"]}},{"name":"_map_union_bytes","type":{"type":"map","values":["int",{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}]}},{"name":"_map_array","type":{"type":"map","values":{"type":"array","items":{"type":"int","logicalType":"date"}}}},{"name":"_map_array_fixed","type":{"type":"map","values":{"type":"array","items":"FixedDecimal"}}},{"name":"_union_map","type":["int",{"type":"map","values":{"type":"string","logicalType":"uuid"}}]},{"name":"_union_map_fixed","type":["int",{"type":"map","values":"FixedDecimal"}]},{"name":"_union_map_bytes","type":["int",{"type":"map","values":{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}}]},{"name":"_union_array","type":["int",{"type":"array","items":{"type":"int","logicalType":"date"}}]},{"name":"_union_array_fixed","type":["int",{"type":"array","items":"FixedDecimal"}]},{"name":"_union_array_bytes","type":["int",{"type":"array","items":{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}}]},{"name":"_array_map","type":{"type":"array","items":{"type":"map","values":{"type":"string","logicalType":"uuid"}}}},{"name":"_array_map_fixed","type":{"type":"array","items":{"type":"map","values":"FixedDecimal"}}},{"name":"_array_map_bytes","type":{"type":"array","items":{"type":"map","values":{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}}}},{"name":"_array_union","type":{"type":"array","items":["int",{"type":"long","logicalType":"timestamp-millis"}]}},{"name":"_array_union_fixed","type":{"type":"array","items":["int","FixedDecimal"]}},{"name":"_array_union_bytes","type":{"type":"array","items":["int",{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}]}},{"name":"_map_option_fixed","type":{"type":"map","values":["null","FixedDecimal"]}},{"name":"_map_option_bytes","type":{"type":"map","values":["null",{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}]}},{"name":"_array_option_fixed","type":{"type":"array","items":["null","FixedDecimal"]}},{"name":"_array_option_bytes","type":{"type":"array","items":["null",{"type":"bytes","logicalType":"decimal","precision":4,"scale":2}]}}]}""")
  val decimalConversion = new org.apache.avro.Conversions.DecimalConversion
}
/** GENERATED CODE */

package avro2s.test.unions

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class Unions(var _union_of_map_of_union: String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil, var _union_of_map_of_option: String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil, var _union_of_array_of_option: String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil, var _union_of_array_of_union: String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil, var _union_of_array_of_array: String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil, var _union_of_records: String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil, var _union_of_enum: String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil, var _union_of_fixed: String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil, var _union_of_string: String :+: Long :+: scala.Null :+: CNil, var _union_of_int: Int :+: String :+: CNil, var _union_of_long: Long :+: String :+: CNil, var _union_of_float: Float :+: String :+: CNil, var _union_of_double: Double :+: String :+: CNil, var _union_of_boolean: Boolean :+: String :+: CNil, var _union_of_bytes: Array[Byte] :+: String :+: CNil, var _optional_record: Option[avro2s.test.unions.Record3], var _optional_enum: Option[avro2s.test.unions.Enum2], var _optional_fixed: Option[avro2s.test.unions.Fixed2], var _optional_string: Option[String], var _optional_int: Option[Int], var _optional_long: Option[Long], var _optional_float: Option[Float], var _optional_double: Option[Double], var _optional_boolean: Option[Boolean], var _optional_bytes: Option[Array[Byte]], var _optional_map: Option[Map[String, String]], var _optional_array: Option[List[String]], var _optional_map_of_array: Option[Map[String, List[String]]], var _optional_array_of_map: Option[List[Map[String, String]]], var _optional_map_of_map: Option[Map[String, Map[String, String]]], var _optional_array_of_array: Option[List[List[String]]], var _optional_map_of_union: Option[Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]], var _optional_array_of_union: Option[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(0), Inl(0), Inl(0), Inl(0), Inl(false), Inl(Array[Byte]()), None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

  override def getSchema: org.apache.avro.Schema = Unions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _union_of_map_of_union match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
              kvp._2.foreach { kvp =>
                val key = kvp._1
                val value = {
                  kvp._2 match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                }
                map.put(key, value)
              }
              map
            }
            map.put(key, value)
          }
          map
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 1 => _union_of_map_of_option match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2 match {
                case None => null
                case Some(x) => x.asInstanceOf[AnyRef]
              }
            }
            map.put(key, value)
          }
          map
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 2 => _union_of_array_of_option match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case None => null
          case Some(x) => x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 3 => _union_of_array_of_union match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case Inl(x) => x.asInstanceOf[AnyRef]
          case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inr(Inl(x))))) =>
          java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inr(Inr(Inl(x)))))) => x.asInstanceOf[AnyRef]
          case _ => throw new AvroRuntimeException("Invalid value")
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 4 => _union_of_array_of_array match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case Inl(x) => x.asInstanceOf[AnyRef]
          case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
          case _ => throw new AvroRuntimeException("Invalid value")
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 5 => _union_of_records match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inr(Inl(x)))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 6 => _union_of_enum match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 7 => _union_of_fixed match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 8 => _union_of_string match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 9 => _union_of_int match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 10 => _union_of_long match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 11 => _union_of_float match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 12 => _union_of_double match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 13 => _union_of_boolean match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 14 => _union_of_bytes match {
        case Inl(x) =>
        java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 15 => _optional_record match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 16 => _optional_enum match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 17 => _optional_fixed match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 18 => _optional_string match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 19 => _optional_int match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 20 => _optional_long match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 21 => _optional_float match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 22 => _optional_double match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 23 => _optional_boolean match {
        case None => null
        case Some(x) => x.asInstanceOf[AnyRef]
      }
      case 24 => _optional_bytes match {
        case None => null
        case Some(x) =>
        java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
      }
      case 25 => _optional_map match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2
            }
            map.put(key, value)
          }
          map
      }
      case 26 => _optional_array match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 27 => _optional_map_of_array match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              scala.jdk.CollectionConverters.BufferHasAsJava({
                kvp._2.map { x =>
                  x.asInstanceOf[AnyRef]
                }
              }.toBuffer).asJava
            }
            map.put(key, value)
          }
          map
      }
      case 28 => _optional_array_of_map match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2
            }
            map.put(key, value)
          }
          map
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 29 => _optional_map_of_map match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
              kvp._2.foreach { kvp =>
                val key = kvp._1
                val value = {
                  kvp._2
                }
                map.put(key, value)
              }
              map
            }
            map.put(key, value)
          }
          map
      }
      case 30 => _optional_array_of_array match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map { x =>x.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case 31 => _optional_map_of_union match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2 match {
                case Inl(x) => x.asInstanceOf[AnyRef]
                case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            }
            map.put(key, value)
          }
          map
      }
      case 32 => _optional_array_of_union match {
        case None => null
        case Some(x) =>
        scala.jdk.CollectionConverters.BufferHasAsJava({
          x.map {
          case Inl(x) => x.asInstanceOf[AnyRef]
          case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
          case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
          case _ => throw new AvroRuntimeException("Invalid value")
          }
        }.toBuffer).asJava.asInstanceOf[AnyRef]
      }
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_map_of_union = Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_map_of_union = Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_map_of_union = Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
        case map: java.util.Map[_,_] => this._union_of_map_of_union = Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil]({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case map: java.util.Map[_,_] => {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value match {
                        case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                        case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case _ => throw new AvroRuntimeException("Invalid value")
                      }
                    })
                  }
                }
              }
            })
          }
        })
        case x @ null => this._union_of_map_of_union = Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 1 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_map_of_option = Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_map_of_option = Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_map_of_option = Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x)
        case map: java.util.Map[_,_] => this._union_of_map_of_option = Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil]({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case null => None
                case x: org.apache.avro.util.Utf8 => Some(x.toString)
              }
            })
          }
        })
        case x @ null => this._union_of_map_of_option = Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 2 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_array_of_option = Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_array_of_option = Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_array_of_option = Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x)
        case x: java.util.List[_] => this._union_of_array_of_option = Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case null => None
                  case x: org.apache.avro.util.Utf8 => Some(x.toString)
                }
              }).toList
            }
        }.toList)
        case x @ null => this._union_of_array_of_option = Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 3 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_array_of_union = Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_array_of_union = Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_array_of_union = Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x)
        case x: java.util.List[_] => this._union_of_array_of_union = Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil](x.toString)
                  case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil](x)
                  case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil](x)
                  case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil](x)
                  case x: java.nio.ByteBuffer => Coproduct[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil](x.array())
                  case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil](x)
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              }).toList
            }
        }.toList)
        case x @ null => this._union_of_array_of_union = Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 4 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_array_of_array = Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_array_of_array = Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_array_of_array = Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
        case x: java.util.List[_] => this._union_of_array_of_array = Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil]({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case array: java.util.List[_] =>
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      value match {
                        case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                        case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                        case _ => throw new AvroRuntimeException("Invalid value")
                      }
                    }).toList
                  }
              }).toList
            }
        }.toList)
        case x @ null => this._union_of_array_of_array = Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 5 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_records = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_records = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_records = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
        case x: avro2s.test.unions.Record1 => this._union_of_records = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
        case x: avro2s.test.unions.Record2 => this._union_of_records = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
        case x @ null => this._union_of_records = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 6 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_enum = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_enum = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_enum = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
        case x: avro2s.test.unions.Enum1 => this._union_of_enum = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
        case x @ null => this._union_of_enum = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 7 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_fixed = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_fixed = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
        case x: Boolean => this._union_of_fixed = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
        case x: avro2s.test.unions.Fixed1 => this._union_of_fixed = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
        case x @ null => this._union_of_fixed = Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 8 => value match {
        case x: org.apache.avro.util.Utf8 => this._union_of_string = Coproduct[String :+: Long :+: scala.Null :+: CNil](x.toString)
        case x: Long => this._union_of_string = Coproduct[String :+: Long :+: scala.Null :+: CNil](x)
        case x @ null => this._union_of_string = Coproduct[String :+: Long :+: scala.Null :+: CNil](x)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 9 => value match {
        case x: Int => this._union_of_int = Coproduct[Int :+: String :+: CNil](x)
        case x: org.apache.avro.util.Utf8 => this._union_of_int = Coproduct[Int :+: String :+: CNil](x.toString)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 10 => value match {
        case x: Long => this._union_of_long = Coproduct[Long :+: String :+: CNil](x)
        case x: org.apache.avro.util.Utf8 => this._union_of_long = Coproduct[Long :+: String :+: CNil](x.toString)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 11 => value match {
        case x: Float => this._union_of_float = Coproduct[Float :+: String :+: CNil](x)
        case x: org.apache.avro.util.Utf8 => this._union_of_float = Coproduct[Float :+: String :+: CNil](x.toString)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 12 => value match {
        case x: Double => this._union_of_double = Coproduct[Double :+: String :+: CNil](x)
        case x: org.apache.avro.util.Utf8 => this._union_of_double = Coproduct[Double :+: String :+: CNil](x.toString)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 13 => value match {
        case x: Boolean => this._union_of_boolean = Coproduct[Boolean :+: String :+: CNil](x)
        case x: org.apache.avro.util.Utf8 => this._union_of_boolean = Coproduct[Boolean :+: String :+: CNil](x.toString)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 14 => value match {
        case x: java.nio.ByteBuffer => this._union_of_bytes = Coproduct[Array[Byte] :+: String :+: CNil](x.array())
        case x: org.apache.avro.util.Utf8 => this._union_of_bytes = Coproduct[Array[Byte] :+: String :+: CNil](x.toString)
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 15 => value match {
        case null => this._optional_record = None
        case x: avro2s.test.unions.Record3 => this._optional_record = Some(x)
      }
      case 16 => value match {
        case null => this._optional_enum = None
        case x: avro2s.test.unions.Enum2 => this._optional_enum = Some(x)
      }
      case 17 => value match {
        case null => this._optional_fixed = None
        case x: avro2s.test.unions.Fixed2 => this._optional_fixed = Some(x)
      }
      case 18 => value match {
        case null => this._optional_string = None
        case x: org.apache.avro.util.Utf8 => this._optional_string = Some(x.toString)
      }
      case 19 => value match {
        case null => this._optional_int = None
        case x: Int => this._optional_int = Some(x)
      }
      case 20 => value match {
        case null => this._optional_long = None
        case x: Long => this._optional_long = Some(x)
      }
      case 21 => value match {
        case null => this._optional_float = None
        case x: Float => this._optional_float = Some(x)
      }
      case 22 => value match {
        case null => this._optional_double = None
        case x: Double => this._optional_double = Some(x)
      }
      case 23 => value match {
        case null => this._optional_boolean = None
        case x: Boolean => this._optional_boolean = Some(x)
      }
      case 24 => value match {
        case null => this._optional_bytes = None
        case x: java.nio.ByteBuffer => this._optional_bytes = Some(x.array())
      }
      case 25 => value match {
        case null => this._optional_map = None
        case map: java.util.Map[_,_] => this._optional_map = Some({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.toString
            })
          }
        })
      }
      case 26 => value match {
        case null => this._optional_array = None
        case x: java.util.List[_] => this._optional_array = Some({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value.toString
              }).toList
            }
        }.toList)
      }
      case 27 => value match {
        case null => this._optional_map_of_array = None
        case map: java.util.Map[_,_] => this._optional_map_of_array = Some({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case array: java.util.List[_] =>
                  scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                    value.toString
                  }).toList
                }
            })
          }
        })
      }
      case 28 => value match {
        case null => this._optional_array_of_map = None
        case x: java.util.List[_] => this._optional_array_of_map = Some({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case map: java.util.Map[_,_] => {
                    scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                      val key = kvp._1.toString
                      val value = kvp._2
                      (key, {
                        value.toString
                      })
                    }
                  }
                }
              }).toList
            }
        }.toList)
      }
      case 29 => value match {
        case null => this._optional_map_of_map = None
        case map: java.util.Map[_,_] => this._optional_map_of_map = Some({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case map: java.util.Map[_,_] => {
                  scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
                    val key = kvp._1.toString
                    val value = kvp._2
                    (key, {
                      value.toString
                    })
                  }
                }
              }
            })
          }
        })
      }
      case 30 => value match {
        case null => this._optional_array_of_array = None
        case x: java.util.List[_] => this._optional_array_of_array = Some({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case array: java.util.List[_] =>
                    scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                      value.toString
                    }).toList
                  }
              }).toList
            }
        }.toList)
      }
      case 31 => value match {
        case null => this._optional_map_of_union = None
        case map: java.util.Map[_,_] => this._optional_map_of_union = Some({
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value match {
                case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                case _ => throw new AvroRuntimeException("Invalid value")
              }
            })
          }
        })
      }
      case 32 => value match {
        case null => this._optional_array_of_union = None
        case x: java.util.List[_] => this._optional_array_of_union = Some({
          x match {
            case array: java.util.List[_] =>
              scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                value match {
                  case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                  case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                  case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                  case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                  case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                  case _ => throw new AvroRuntimeException("Invalid value")
                }
              }).toList
            }
        }.toList)
      }
    }
  }
}

object Unions {
  val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Unions","namespace":"avro2s.test.unions","fields":[{"name":"_union_of_map_of_union","type":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_map_of_option","type":["string","long","boolean",{"type":"map","values":["null","string"]},"null"]},{"name":"_union_of_array_of_option","type":["string","long","boolean",{"type":"array","items":["null","string"]},"null"]},{"name":"_union_of_array_of_union","type":["string","long","boolean",{"type":"array","items":["string","long","boolean","double","bytes","null"]},"null"]},{"name":"_union_of_array_of_array","type":["string","long","boolean",{"type":"array","items":{"type":"array","items":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_records","type":["string","long","boolean",{"type":"record","name":"Record1","fields":[{"name":"field1","type":"string"}]},{"type":"record","name":"Record2","fields":[{"name":"field2","type":"long"}]},"null"]},{"name":"_union_of_enum","type":["string","long","boolean",{"type":"enum","name":"Enum1","symbols":["sym1","sym2"]},"null"]},{"name":"_union_of_fixed","type":["string","long","boolean",{"type":"fixed","name":"Fixed1","size":1},"null"]},{"name":"_union_of_string","type":["string","long","null"]},{"name":"_union_of_int","type":["int","string"]},{"name":"_union_of_long","type":["long","string"]},{"name":"_union_of_float","type":["float","string"]},{"name":"_union_of_double","type":["double","string"]},{"name":"_union_of_boolean","type":["boolean","string"]},{"name":"_union_of_bytes","type":["bytes","string"]},{"name":"_optional_record","type":["null",{"type":"record","name":"Record3","fields":[{"name":"field3","type":"string"}]}]},{"name":"_optional_enum","type":["null",{"type":"enum","name":"Enum2","symbols":["sym3","sym4"]}]},{"name":"_optional_fixed","type":["null",{"type":"fixed","name":"Fixed2","size":1}]},{"name":"_optional_string","type":["null","string"]},{"name":"_optional_int","type":["null","int"]},{"name":"_optional_long","type":["null","long"]},{"name":"_optional_float","type":["null","float"]},{"name":"_optional_double","type":["null","double"]},{"name":"_optional_boolean","type":["null","boolean"]},{"name":"_optional_bytes","type":["null","bytes"]},{"name":"_optional_map","type":["null",{"type":"map","values":"string"}]},{"name":"_optional_array","type":["null",{"type":"array","items":"string"}]},{"name":"_optional_map_of_array","type":["null",{"type":"map","values":{"type":"array","items":"string"}}]},{"name":"_optional_array_of_map","type":["null",{"type":"array","items":{"type":"map","values":"string"}}]},{"name":"_optional_map_of_map","type":["null",{"type":"map","values":{"type":"map","values":"string"}}]},{"name":"_optional_array_of_array","type":["null",{"type":"array","items":{"type":"array","items":"string"}}]},{"name":"_optional_map_of_union","type":["null",{"type":"map","values":["string","long","boolean","double","null"]}]},{"name":"_optional_array_of_union","type":["null",{"type":"array","items":["string","long","boolean","double","null"]}]}]}""")
}
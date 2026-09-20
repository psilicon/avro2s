/** GENERATED CODE */

package avro2s.test.unions

import org.apache.avro.AvroRuntimeException

import scala.annotation.switch
import shapeless.{:+:, CNil, Coproduct, Inl, Inr}

case class Unions(var _union_of_map_of_union: String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil, var _union_of_map_of_option: String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil, var _union_of_array_of_option: String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil, var _union_of_array_of_union: String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil, var _union_of_array_of_array: String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil, var _union_of_records: String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil, var _union_of_enum: String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil, var _union_of_fixed: String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil, var _union_of_string: String :+: Long :+: scala.Null :+: CNil, var _union_of_int: Int :+: String :+: CNil, var _union_of_long: Long :+: String :+: CNil, var _union_of_float: Float :+: String :+: CNil, var _union_of_double: Double :+: String :+: CNil, var _union_of_boolean: Boolean :+: String :+: CNil, var _union_of_bytes: Array[Byte] :+: String :+: CNil, var _optional_record: Option[avro2s.test.unions.Record3], var _optional_enum: Option[avro2s.test.unions.Enum2], var _optional_fixed: Option[avro2s.test.unions.Fixed2], var _optional_string: Option[String], var _optional_int: Option[Int], var _optional_long: Option[Long], var _optional_float: Option[Float], var _optional_double: Option[Double], var _optional_boolean: Option[Boolean], var _optional_bytes: Option[Array[Byte]], var _optional_map: Option[Map[String, String]], var _optional_array: Option[List[String]], var _optional_map_of_array: Option[Map[String, List[String]]], var _optional_array_of_map: Option[List[Map[String, String]]], var _optional_map_of_map: Option[Map[String, Map[String, String]]], var _optional_array_of_array: Option[List[List[String]]], var _optional_map_of_union: Option[Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]], var _optional_array_of_union: Option[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(""), Inl(0), Inl(0), Inl(0), Inl(0), Inl(false), Inl(_root_.scala.Array.emptyByteArray), None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None)

  override def getSchema: org.apache.avro.Schema = Unions.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _union_of_map_of_union match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
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
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
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
          {
            def toJavaArray$(input$: List[Option[String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case None => null
                    case Some(x) => x.asInstanceOf[AnyRef]
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 3 => _union_of_array_of_union match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
          {
            def toJavaArray$(input$: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inr(Inl(x))))) =>
                    java.nio.ByteBuffer.wrap(x).asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inr(Inr(Inl(x)))))) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
        case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
        case _ => throw new AvroRuntimeException("Invalid value")
      }
      case 4 => _union_of_array_of_array match {
        case Inl(x) => x.asInstanceOf[AnyRef]
        case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
        case Inr(Inr(Inr(Inl(x)))) =>
          {
            def toJavaArray$(input$: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {
                    def toJavaArray$(input$: List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]): java.util.ArrayList[AnyRef] = {
                      var remaining$ = input$
                      val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
                      while (remaining$.nonEmpty) {
                        val element$ = remaining$.head
                        result$.add({
                          element$ match {
                            case Inl(x) => x.asInstanceOf[AnyRef]
                            case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                            case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                            case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                            case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
                            case _ => throw new AvroRuntimeException("Invalid value")
                          }
                        })
                        remaining$ = remaining$.tail
                      }
                      result$
                    }
                    toJavaArray$(element$)
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
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
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              kvp._2.asInstanceOf[AnyRef]
            }
            map.put(key, value)
          }
          map
      }
      case 26 => _optional_array match {
        case None => null
        case Some(x) =>
          {
            def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](input$.size)
              while (remaining$.nonEmpty) {
                result$.add(remaining$.head)
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x.asInstanceOf[List[AnyRef]])
          }
      }
      case 27 => _optional_map_of_array match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              {
                def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
                  var remaining$ = input$
                  val result$ = new java.util.ArrayList[AnyRef](input$.size)
                  while (remaining$.nonEmpty) {
                    result$.add(remaining$.head)
                    remaining$ = remaining$.tail
                  }
                  result$
                }
                toJavaArray$(kvp._2.asInstanceOf[List[AnyRef]])
              }
            }
            map.put(key, value)
          }
          map
      }
      case 28 => _optional_array_of_map match {
        case None => null
        case Some(x) =>
          {
            def toJavaArray$(input$: List[Map[String, String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = element$.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
                  element$.foreach { kvp =>
                    val key = kvp._1
                    val value = {
                      kvp._2.asInstanceOf[AnyRef]
                    }
                    map.put(key, value)
                  }
                  map
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
      }
      case 29 => _optional_map_of_map match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
          x.foreach { kvp =>
            val key = kvp._1
            val value = {
              val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = kvp._2.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
              kvp._2.foreach { kvp =>
                val key = kvp._1
                val value = {
                  kvp._2.asInstanceOf[AnyRef]
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
          {
            def toJavaArray$(input$: List[List[String]]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  {
                    def toJavaArray$(input$: List[AnyRef]): java.util.ArrayList[AnyRef] = {
                      var remaining$ = input$
                      val result$ = new java.util.ArrayList[AnyRef](input$.size)
                      while (remaining$.nonEmpty) {
                        result$.add(remaining$.head)
                        remaining$ = remaining$.tail
                      }
                      result$
                    }
                    toJavaArray$(element$.asInstanceOf[List[AnyRef]])
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
      }
      case 31 => _optional_map_of_union match {
        case None => null
        case Some(x) =>
          val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = x.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
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
          {
            def toJavaArray$(input$: List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]): java.util.ArrayList[AnyRef] = {
              var remaining$ = input$
              val result$ = new java.util.ArrayList[AnyRef](remaining$.size)
              while (remaining$.nonEmpty) {
                val element$ = remaining$.head
                result$.add({
                  element$ match {
                    case Inl(x) => x.asInstanceOf[AnyRef]
                    case Inr(Inl(x)) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inl(x))) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inl(x)))) => x.asInstanceOf[AnyRef]
                    case Inr(Inr(Inr(Inr(Inl(x))))) => x.asInstanceOf[AnyRef]
                    case _ => throw new AvroRuntimeException("Invalid value")
                  }
                })
                remaining$ = remaining$.tail
              }
              result$
            }
            toJavaArray$(x)
          }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._union_of_map_of_union = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
          case map: java.util.Map[_,_] => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil]{
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case map: java.util.Map[_,_] => {
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil] else {
                        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                          val key = kvp._1.toString
                          val value = kvp._2
                          (key, {
                            value match {
                              case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                              case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                              case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                            }
                          })
                        }.toMap
                      }
                    }
                  }
                })
              }.toMap
            }
          }
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: Map[String, Map[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 1 => this._union_of_map_of_option = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x)
          case map: java.util.Map[_,_] => Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil]{
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Option[String]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case null => None
                    case x: org.apache.avro.util.Utf8 => Some(x.toString)
                  }
                })
              }.toMap
            }
          }
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: Map[String, Option[String]] :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this._union_of_array_of_option = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x)
          case x: java.util.List[_] => Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil]({
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
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: List[Option[String]] :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 3 => this._union_of_array_of_union = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x)
          case x: java.util.List[_] => Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil]({
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
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                }).toList
              }
          }.toList)
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: List[String :+: Long :+: Boolean :+: Double :+: Array[Byte] :+: scala.Null :+: CNil] :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 4 => this._union_of_array_of_array = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
          case x: java.util.List[_] => Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil]({
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
                          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                        }
                      }).toList
                    }
                }).toList
              }
          }.toList)
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: List[List[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil]] :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 5 => this._union_of_records = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
          case x: avro2s.test.unions.Record1 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
          case x: avro2s.test.unions.Record2 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Record1 :+: avro2s.test.unions.Record2 :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 6 => this._union_of_enum = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
          case x: avro2s.test.unions.Enum1 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Enum1 :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this._union_of_fixed = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
          case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
          case x: avro2s.test.unions.Fixed1 => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
          case x @ null => Coproduct[String :+: Long :+: Boolean :+: avro2s.test.unions.Fixed1 :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 8 => this._union_of_string = {
        value match {
          case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: scala.Null :+: CNil](x.toString)
          case x: Long => Coproduct[String :+: Long :+: scala.Null :+: CNil](x)
          case x @ null => Coproduct[String :+: Long :+: scala.Null :+: CNil](x)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 9 => this._union_of_int = {
        value match {
          case x: Int => Coproduct[Int :+: String :+: CNil](x)
          case x: org.apache.avro.util.Utf8 => Coproduct[Int :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 10 => this._union_of_long = {
        value match {
          case x: Long => Coproduct[Long :+: String :+: CNil](x)
          case x: org.apache.avro.util.Utf8 => Coproduct[Long :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 11 => this._union_of_float = {
        value match {
          case x: Float => Coproduct[Float :+: String :+: CNil](x)
          case x: org.apache.avro.util.Utf8 => Coproduct[Float :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 12 => this._union_of_double = {
        value match {
          case x: Double => Coproduct[Double :+: String :+: CNil](x)
          case x: org.apache.avro.util.Utf8 => Coproduct[Double :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 13 => this._union_of_boolean = {
        value match {
          case x: Boolean => Coproduct[Boolean :+: String :+: CNil](x)
          case x: org.apache.avro.util.Utf8 => Coproduct[Boolean :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 14 => this._union_of_bytes = {
        value match {
          case x: java.nio.ByteBuffer => Coproduct[Array[Byte] :+: String :+: CNil](x.array())
          case x: org.apache.avro.util.Utf8 => Coproduct[Array[Byte] :+: String :+: CNil](x.toString)
          case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 15 => this._optional_record = {
        value match {
          case null => None
          case x: avro2s.test.unions.Record3 => Some(x)
        }
      }
      case 16 => this._optional_enum = {
        value match {
          case null => None
          case x: avro2s.test.unions.Enum2 => Some(x)
        }
      }
      case 17 => this._optional_fixed = {
        value match {
          case null => None
          case x: avro2s.test.unions.Fixed2 => Some(x)
        }
      }
      case 18 => this._optional_string = {
        value match {
          case null => None
          case x: org.apache.avro.util.Utf8 => Some(x.toString)
        }
      }
      case 19 => this._optional_int = {
        value match {
          case null => None
          case x: Int => Some(x)
        }
      }
      case 20 => this._optional_long = {
        value match {
          case null => None
          case x: Long => Some(x)
        }
      }
      case 21 => this._optional_float = {
        value match {
          case null => None
          case x: Float => Some(x)
        }
      }
      case 22 => this._optional_double = {
        value match {
          case null => None
          case x: Double => Some(x)
        }
      }
      case 23 => this._optional_boolean = {
        value match {
          case null => None
          case x: Boolean => Some(x)
        }
      }
      case 24 => this._optional_bytes = {
        value match {
          case null => None
          case x: java.nio.ByteBuffer => Some(x.array())
        }
      }
      case 25 => this._optional_map = {
        value match {
          case null => None
          case map: java.util.Map[_,_] => Some{
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value.toString
                })
              }.toMap
            }
          }
        }
      }
      case 26 => this._optional_array = {
        value match {
          case null => None
          case x: java.util.List[_] => Some({
            x match {
              case array: java.util.List[_] =>
                scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                  value.toString
                }).toList
              }
          }.toList)
        }
      }
      case 27 => this._optional_map_of_array = {
        value match {
          case null => None
          case map: java.util.Map[_,_] => Some{
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, List[String]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
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
              }.toMap
            }
          }
        }
      }
      case 28 => this._optional_array_of_map = {
        value match {
          case null => None
          case x: java.util.List[_] => Some({
            x match {
              case array: java.util.List[_] =>
                scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                  value match {
                    case map: java.util.Map[_,_] => {
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                          val key = kvp._1.toString
                          val value = kvp._2
                          (key, {
                            value.toString
                          })
                        }.toMap
                      }
                    }
                  }
                }).toList
              }
          }.toList)
        }
      }
      case 29 => this._optional_map_of_map = {
        value match {
          case null => None
          case map: java.util.Map[_,_] => Some{
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, Map[String, String]] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case map: java.util.Map[_,_] => {
                      if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String] else {
                        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                          val key = kvp._1.toString
                          val value = kvp._2
                          (key, {
                            value.toString
                          })
                        }.toMap
                      }
                    }
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 30 => this._optional_array_of_array = {
        value match {
          case null => None
          case x: java.util.List[_] => Some({
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
      }
      case 31 => this._optional_map_of_union = {
        value match {
          case null => None
          case map: java.util.Map[_,_] => Some{
            if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil] else {
              scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
                val key = kvp._1.toString
                val value = kvp._2
                (key, {
                  value match {
                    case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                    case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                })
              }.toMap
            }
          }
        }
      }
      case 32 => this._optional_array_of_union = {
        value match {
          case null => None
          case x: java.util.List[_] => Some({
            x match {
              case array: java.util.List[_] =>
                scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
                  value match {
                    case x: org.apache.avro.util.Utf8 => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x.toString)
                    case x: Long => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case x: Boolean => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case x: Double => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case x @ null => Coproduct[String :+: Long :+: Boolean :+: Double :+: scala.Null :+: CNil](x)
                    case _ => throw new AvroRuntimeException("Unexpected type: " + value.getClass.getName)
                  }
                }).toList
              }
          }.toList)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Unions {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Unions","namespace":"avro2s.test.unions","fields":[{"name":"_union_of_map_of_union","type":["string","long","boolean",{"type":"map","values":{"type":"map","values":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_map_of_option","type":["string","long","boolean",{"type":"map","values":["null","string"]},"null"]},{"name":"_union_of_array_of_option","type":["string","long","boolean",{"type":"array","items":["null","string"]},"null"]},{"name":"_union_of_array_of_union","type":["string","long","boolean",{"type":"array","items":["string","long","boolean","double","bytes","null"]},"null"]},{"name":"_union_of_array_of_array","type":["string","long","boolean",{"type":"array","items":{"type":"array","items":["string","long","boolean","double","null"]}},"null"]},{"name":"_union_of_records","type":["string","long","boolean",{"type":"record","name":"Record1","fields":[{"name":"field1","type":"string"}]},{"type":"record","name":"Record2","fields":[{"name":"field2","type":"long"}]},"null"]},{"name":"_union_of_enum","type":["string","long","boolean",{"type":"enum","name":"Enum1","symbols":["sym1","sym2"]},"null"]},{"name":"_union_of_fixed","type":["string","long","boolean",{"type":"fixed","name":"Fixed1","size":1},"null"]},{"name":"_union_of_string","type":["string","long","null"]},{"name":"_union_of_int","type":["int","string"]},{"name":"_union_of_long","type":["long","string"]},{"name":"_union_of_float","type":["float","string"]},{"name":"_union_of_double","type":["double","string"]},{"name":"_union_of_boolean","type":["boolean","string"]},{"name":"_union_of_bytes","type":["bytes","string"]},{"name":"_optional_record","type":["null",{"type":"record","name":"Record3","fields":[{"name":"field3","type":"string"}]}]},{"name":"_optional_enum","type":["null",{"type":"enum","name":"Enum2","symbols":["sym3","sym4"]}]},{"name":"_optional_fixed","type":["null",{"type":"fixed","name":"Fixed2","size":1}]},{"name":"_optional_string","type":["null","string"]},{"name":"_optional_int","type":["null","int"]},{"name":"_optional_long","type":["null","long"]},{"name":"_optional_float","type":["null","float"]},{"name":"_optional_double","type":["null","double"]},{"name":"_optional_boolean","type":["null","boolean"]},{"name":"_optional_bytes","type":["null","bytes"]},{"name":"_optional_map","type":["null",{"type":"map","values":"string"}]},{"name":"_optional_array","type":["null",{"type":"array","items":"string"}]},{"name":"_optional_map_of_array","type":["null",{"type":"map","values":{"type":"array","items":"string"}}]},{"name":"_optional_array_of_map","type":["null",{"type":"array","items":{"type":"map","values":"string"}}]},{"name":"_optional_map_of_map","type":["null",{"type":"map","values":{"type":"map","values":"string"}}]},{"name":"_optional_array_of_array","type":["null",{"type":"array","items":{"type":"array","items":"string"}}]},{"name":"_optional_map_of_union","type":["null",{"type":"map","values":["string","long","boolean","double","null"]}]},{"name":"_optional_array_of_union","type":["null",{"type":"array","items":["string","long","boolean","double","null"]}]}]}""")
}
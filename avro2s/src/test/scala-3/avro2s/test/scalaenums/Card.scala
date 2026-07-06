/** GENERATED CODE */

package avro2s.test.scalaenums

import scala.annotation.switch

case class Card(var suit: avro2s.test.scalaenums.Suit, var trump: Option[avro2s.test.scalaenums.Suit], var history: List[avro2s.test.scalaenums.Suit], var byPlayer: Map[String, avro2s.test.scalaenums.Suit], var maybeHistory: List[Option[avro2s.test.scalaenums.Suit]], var kw: avro2s.test.scalaenums.Kw, var maybeKw: Option[avro2s.test.scalaenums.Kw], var cp: Option[avro2s.test.scalaenums.Suit | String]) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(null, None, List.empty, Map.empty, List.empty, null, None, None)

  override def getSchema: org.apache.avro.Schema = Card.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => (if (suit == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Suit.SCHEMA$, suit.toString)).asInstanceOf[AnyRef]
      case 1 => trump match {
        case Some(x: avro2s.test.scalaenums.Suit) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 2 => history match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map { x =>
              (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]
        byPlayer.foreach { kvp =>
          val key = kvp._1
          val value = {
            (if (kvp._2 == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Suit.SCHEMA$, kvp._2.toString)).asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => maybeHistory match {
        case array =>
          scala.jdk.CollectionConverters.BufferHasAsJava({
            array.map {
              case Some(x: avro2s.test.scalaenums.Suit) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
              case None => null.asInstanceOf[AnyRef]
            }
          }.toBuffer).asJava
        }
      case 5 => (if (kw == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Kw.SCHEMA$, kw.toString)).asInstanceOf[AnyRef]
      case 6 => maybeKw match {
        case Some(x: avro2s.test.scalaenums.Kw) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Kw.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case 7 => cp match {
        case Some(x: avro2s.test.scalaenums.Suit) => (if (x == null) null else new org.apache.avro.generic.GenericData.EnumSymbol(avro2s.test.scalaenums.Suit.SCHEMA$, x.toString)).asInstanceOf[AnyRef]
        case Some(x: String) => x.asInstanceOf[AnyRef]
        case None => null.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this.suit = {
        value match { case x: avro2s.test.scalaenums.Suit => x; case x => avro2s.test.scalaenums.Suit.valueOf(x.toString) }
      }
      case 1 => this.trump = {
        value match {
          case null => None
          case x: avro2s.test.scalaenums.Suit => Option(x.asInstanceOf[avro2s.test.scalaenums.Suit])
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Suit" => Option(avro2s.test.scalaenums.Suit.valueOf(x.toString).asInstanceOf[avro2s.test.scalaenums.Suit])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 2 => this.history = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match { case x: avro2s.test.scalaenums.Suit => x; case x => avro2s.test.scalaenums.Suit.valueOf(x.toString) }
        }).toList
      }
      case 3 => this.byPlayer = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.toMap map { kvp =>
          val key = kvp._1.toString
          val value = kvp._2
          (key, {
            value match { case x: avro2s.test.scalaenums.Suit => x; case x => avro2s.test.scalaenums.Suit.valueOf(x.toString) }
          })
        }
      }
      case 4 => this.maybeHistory = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value match {
            case null => None
            case x: avro2s.test.scalaenums.Suit => Option(x.asInstanceOf[avro2s.test.scalaenums.Suit])
            case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Suit" => Option(avro2s.test.scalaenums.Suit.valueOf(x.toString).asInstanceOf[avro2s.test.scalaenums.Suit])
            case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
          }
        }).toList
      }
      case 5 => this.kw = {
        value match { case x: avro2s.test.scalaenums.Kw => x; case x => avro2s.test.scalaenums.Kw.valueOf(x.toString) }
      }
      case 6 => this.maybeKw = {
        value match {
          case null => None
          case x: avro2s.test.scalaenums.Kw => Option(x.asInstanceOf[avro2s.test.scalaenums.Kw])
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Kw" => Option(avro2s.test.scalaenums.Kw.valueOf(x.toString).asInstanceOf[avro2s.test.scalaenums.Kw])
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case 7 => this.cp = {
        value match {
          case null => None
          case x: avro2s.test.scalaenums.Suit => Option(x.asInstanceOf[avro2s.test.scalaenums.Suit | String])
          case x: org.apache.avro.generic.GenericEnumSymbol[_] if x.getSchema.getFullName == "avro2s.test.scalaenums.Suit" => Option(avro2s.test.scalaenums.Suit.valueOf(x.toString).asInstanceOf[avro2s.test.scalaenums.Suit | String])
          case x: org.apache.avro.util.Utf8 => Option(x.toString)
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
}

object Card {
  @scala.annotation.static val SCHEMA$: org.apache.avro.Schema = new org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Card","namespace":"avro2s.test.scalaenums","fields":[{"name":"suit","type":{"type":"enum","name":"Suit","symbols":["SPADES","HEARTS","DIAMONDS","CLUBS"]}},{"name":"trump","type":["null","Suit"],"default":null},{"name":"history","type":{"type":"array","items":"Suit"}},{"name":"byPlayer","type":{"type":"map","values":"Suit"}},{"name":"maybeHistory","type":{"type":"array","items":["null","Suit"]}},{"name":"kw","type":{"type":"enum","name":"Kw","symbols":["new","type","given","NORMAL"]}},{"name":"maybeKw","type":["null","Kw"],"default":null},{"name":"cp","type":["null","Suit","string"],"default":null}]}""")
}
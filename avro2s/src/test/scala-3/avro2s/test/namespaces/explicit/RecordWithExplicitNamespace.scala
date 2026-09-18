/** GENERATED CODE */

package avro2s.test.namespaces.explicit

import scala.annotation.switch

case class RecordWithExplicitNamespace(var _string: String, var _record_with_namespace_inherited_from_direct_parent: avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, var _array_of_records: List[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray], var _map_of_records: Map[String, avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap], var _union_of_records: avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion | String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", new avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent(), List.empty, Map.empty, new avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion())

  override def getSchema: org.apache.avro.Schema = RecordWithExplicitNamespace.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case 1 => _record_with_namespace_inherited_from_direct_parent.asInstanceOf[AnyRef]
      case 2 => _array_of_records match {
        case array =>
          if (array.isEmpty) new java.util.ArrayList[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray](0) else new java.util.ArrayList[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray](scala.jdk.CollectionConverters.SeqHasAsJava(array).asJava)
        }
      case 3 => {
        val map: java.util.HashMap[String, Any] = new java.util.HashMap[String, Any]({ val size$ = _map_of_records.size; if (size$ <= 12) 16 else _root_.scala.math.ceil(size$ / 0.75d).toInt })
        _map_of_records.foreach { kvp =>
          val key = kvp._1
          val value = {
            kvp._2.asInstanceOf[AnyRef]
          }
          map.put(key, value)
        }
        map
      }.asInstanceOf[AnyRef]
      case 4 => _union_of_records match {
        case x: avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion => x.asInstanceOf[AnyRef]
        case x: String => x.asInstanceOf[AnyRef]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = {
        value.toString.asInstanceOf[String]
      }
      case 1 => this._record_with_namespace_inherited_from_direct_parent = {
        value.asInstanceOf[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent]
      }
      case 2 => this._array_of_records = {
        val array = value.asInstanceOf[java.util.List[?]]
        scala.jdk.CollectionConverters.IteratorHasAsScala(array.iterator).asScala.map({ value =>
          value.asInstanceOf[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray]
        }).toList
      }
      case 3 => this._map_of_records = {
        val map = value.asInstanceOf[java.util.Map[?,?]]
        if (map.isEmpty) _root_.scala.collection.immutable.Map.empty[String, avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap] else {
          scala.jdk.CollectionConverters.MapHasAsScala(map).asScala.iterator.map { kvp =>
            val key = kvp._1.toString
            val value = kvp._2
            (key, {
              value.asInstanceOf[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap]
            })
          }.toMap
        }
      }
      case 4 => this._union_of_records = {
        value match {
          case x: avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion => x.asInstanceOf[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion | String]
          case x: org.apache.avro.util.Utf8 => x.toString
          case _ => throw new org.apache.avro.AvroRuntimeException("Unexpected type: " + value.getClass.getName)
        }
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_string`, out$)
    encode$2(value$.`_record_with_namespace_inherited_from_direct_parent`, out$)
    encode$6(value$.`_array_of_records`, out$)
    encode$9(value$.`_map_of_records`, out$)
    encode$12(value$.`_union_of_records`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace): _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$1(in$)
      value$.`_record_with_namespace_inherited_from_direct_parent` = decode$2(in$, value$.`_record_with_namespace_inherited_from_direct_parent`)
      value$.`_array_of_records` = decode$6(in$)
      value$.`_map_of_records` = decode$9(in$)
      value$.`_union_of_records` = decode$12(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$1(in$)
          case 1 => value$.`_record_with_namespace_inherited_from_direct_parent` = decode$2(in$, value$.`_record_with_namespace_inherited_from_direct_parent`)
          case 2 => value$.`_array_of_records` = decode$6(in$)
          case 3 => value$.`_map_of_records` = decode$9(in$)
          case 4 => value$.`_union_of_records` = decode$12(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$2(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$3(value$.`_string`, out$)
    encode$4(value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`, out$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent() else reuse$
    decodeRecord$2(result$, in$)
    result$
  }

  private def decodeRecord$2(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$3(in$)
      value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent` = decode$4(in$, value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$3(in$)
          case 1 => value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent` = decode$4(in$, value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$3(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$4(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$5(value$.`_string`, out$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent() else reuse$
    decodeRecord$4(result$, in$)
    result$
  }

  private def decodeRecord$4(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$5(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$5(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$5(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$6(value$: _root_.scala.List[_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$7(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$7(in$, null)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$7(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$8(value$.`_string`, out$)
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray() else reuse$
    decodeRecord$7(result$, in$)
    result$
  }

  private def decodeRecord$7(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$8(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$8(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$8(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$9(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$10(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$10(in$, null)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$10(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$11(value$.`_string`, out$)
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap() else reuse$
    decodeRecord$10(result$, in$)
    result$
  }

  private def decodeRecord$10(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$11(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$11(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$11(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$12(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion @unchecked) =>
        out$.writeIndex(0)
        encode$13(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$15(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$13(in$, null)
      case 1 => decode$15(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$13(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$14(value$.`_string`, out$)
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion() else reuse$
    decodeRecord$13(result$, in$)
    result$
  }

  private def decodeRecord$13(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$14(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$14(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$14(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$15(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }
}

object RecordWithExplicitNamespace {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordWithExplicitNamespace","namespace":"avro2s.test.namespaces.explicit","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_direct_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromDirectParent","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_indirect_non_top_level_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectNonTopLevelParent","fields":[{"name":"_string","type":"string"}]}}]}},{"name":"_array_of_records","type":{"type":"array","items":{"type":"record","name":"RecordWithNamespaceInheritedViaArray","fields":[{"name":"_string","type":"string"}]}}},{"name":"_map_of_records","type":{"type":"map","values":{"type":"record","name":"RecordWithNamespaceInheritedViaMap","fields":[{"name":"_string","type":"string"}]}}},{"name":"_union_of_records","type":[{"type":"record","name":"RecordWithNamespaceInheritedViaUnion","fields":[{"name":"_string","type":"string"}]},"string"]}]}""")
}
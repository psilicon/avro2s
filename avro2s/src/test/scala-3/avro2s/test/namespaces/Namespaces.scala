/** GENERATED CODE */

package avro2s.test.namespaces

import scala.annotation.switch

case class Namespaces(var _record_with_explicit_namespace: avro2s.test.namespaces.explicit.RecordWithExplicitNamespace, var _record_with_inherited_namespace: avro2s.test.namespaces.RecordWithInheritedNamespace) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(new avro2s.test.namespaces.explicit.RecordWithExplicitNamespace(), new avro2s.test.namespaces.RecordWithInheritedNamespace())

  override def getSchema: org.apache.avro.Schema = Namespaces.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _record_with_explicit_namespace.asInstanceOf[AnyRef]
      case 1 => _record_with_inherited_namespace.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._record_with_explicit_namespace = {
        value.asInstanceOf[avro2s.test.namespaces.explicit.RecordWithExplicitNamespace]
      }
      case 1 => this._record_with_inherited_namespace = {
        value.asInstanceOf[avro2s.test.namespaces.RecordWithInheritedNamespace]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.namespaces.Namespaces, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_record_with_explicit_namespace`, out$)
    encode$17(value$.`_record_with_inherited_namespace`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.Namespaces): _root_.avro2s.test.namespaces.Namespaces = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.Namespaces() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.namespaces.Namespaces, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_record_with_explicit_namespace` = decode$1(in$, value$.`_record_with_explicit_namespace`)
      value$.`_record_with_inherited_namespace` = decode$17(in$, value$.`_record_with_inherited_namespace`)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_record_with_explicit_namespace` = decode$1(in$, value$.`_record_with_explicit_namespace`)
          case 1 => value$.`_record_with_inherited_namespace` = decode$17(in$, value$.`_record_with_inherited_namespace`)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$1(value$: _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$2(value$.`_string`, out$)
    encode$3(value$.`_record_with_namespace_inherited_from_direct_parent`, out$)
    encode$7(value$.`_array_of_records`, out$)
    encode$10(value$.`_map_of_records`, out$)
    encode$13(value$.`_union_of_records`, out$)
  }

  private def decode$1(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace): _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace() else reuse$
    decodeRecord$1(result$, in$)
    result$
  }

  private def decodeRecord$1(value$: _root_.avro2s.test.namespaces.explicit.RecordWithExplicitNamespace, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$2(in$)
      value$.`_record_with_namespace_inherited_from_direct_parent` = decode$3(in$, value$.`_record_with_namespace_inherited_from_direct_parent`)
      value$.`_array_of_records` = decode$7(in$)
      value$.`_map_of_records` = decode$10(in$)
      value$.`_union_of_records` = decode$13(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$2(in$)
          case 1 => value$.`_record_with_namespace_inherited_from_direct_parent` = decode$3(in$, value$.`_record_with_namespace_inherited_from_direct_parent`)
          case 2 => value$.`_array_of_records` = decode$7(in$)
          case 3 => value$.`_map_of_records` = decode$10(in$)
          case 4 => value$.`_union_of_records` = decode$13(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$2(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$3(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$4(value$.`_string`, out$)
    encode$5(value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`, out$)
  }

  private def decode$3(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent() else reuse$
    decodeRecord$3(result$, in$)
    result$
  }

  private def decodeRecord$3(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$4(in$)
      value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent` = decode$5(in$, value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$4(in$)
          case 1 => value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent` = decode$5(in$, value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$4(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$4(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$5(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$6(value$.`_string`, out$)
  }

  private def decode$5(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent() else reuse$
    decodeRecord$5(result$, in$)
    result$
  }

  private def decodeRecord$5(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$6(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$6(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$6(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$6(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$7(value$: _root_.scala.List[_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeArrayStart()
    out$.setItemCount(value$.size.toLong)
    var remaining$ = value$
    while (remaining$.nonEmpty) {
      out$.startItem()
      encode$8(remaining$.head, out$)
      remaining$ = remaining$.tail
    }
    out$.writeArrayEnd()
  }

  private def decode$7(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.List[_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray] = {
    var count$ = in$.readArrayStart()
    if (count$ == 0L) _root_.scala.Nil else {
      val result$ = _root_.scala.List.newBuilder[_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray]
      while (count$ != 0L) {
        while (count$ > 0L) {
          result$ += decode$8(in$, null)
          count$ -= 1L
        }
        count$ = in$.arrayNext()
      }
      result$.result()
    }
  }

  private def encode$8(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$9(value$.`_string`, out$)
  }

  private def decode$8(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray() else reuse$
    decodeRecord$8(result$, in$)
    result$
  }

  private def decodeRecord$8(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaArray, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$9(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$9(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$9(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$9(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$10(value$: _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap], out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeMapStart()
    out$.setItemCount(value$.size.toLong)
    val entries$ = value$.iterator
    while (entries$.hasNext) {
      val entry$ = entries$.next()
      out$.startItem()
      out$.writeString(entry$._1)
      encode$11(entry$._2, out$)
    }
    out$.writeMapEnd()
  }

  private def decode$10(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.scala.collection.immutable.Map[_root_.java.lang.String, _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap] = {
    var count$ = in$.readMapStart()
    if (count$ == 0L) _root_.scala.collection.immutable.Map.empty else {
      val result$ = _root_.scala.collection.immutable.Map.newBuilder[_root_.java.lang.String, _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap]
      while (count$ != 0L) {
        while (count$ > 0L) {
          val key$ = in$.readString()
          result$ += ((key$, decode$11(in$, null)))
          count$ -= 1L
        }
        count$ = in$.mapNext()
      }
      result$.result()
    }
  }

  private def encode$11(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$12(value$.`_string`, out$)
  }

  private def decode$11(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap() else reuse$
    decodeRecord$11(result$, in$)
    result$
  }

  private def decodeRecord$11(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaMap, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$12(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$12(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$12(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$12(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$13(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion | _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    (value$: Any) match {
      case branch$: (_root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion @unchecked) =>
        out$.writeIndex(0)
        encode$14(branch$, out$)
      case branch$: (_root_.java.lang.String @unchecked) =>
        out$.writeIndex(1)
        encode$16(branch$, out$)
      case _ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union value")
    }
  }

  private def decode$13(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion | _root_.java.lang.String = {
    in$.readIndex() match {
      case 0 => decode$14(in$, null)
      case 1 => decode$16(in$)
      case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid union index: " + index$)
    }
  }

  private def encode$14(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$15(value$.`_string`, out$)
  }

  private def decode$14(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion() else reuse$
    decodeRecord$14(result$, in$)
    result$
  }

  private def decodeRecord$14(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedViaUnion, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$15(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$15(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$15(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$15(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$16(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$16(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$17(value$: _root_.avro2s.test.namespaces.RecordWithInheritedNamespace, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$18(value$.`_string`, out$)
    encode$19(value$.`_record_with_namespace_inherited_from_indirect_parent`, out$)
  }

  private def decode$17(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.RecordWithInheritedNamespace): _root_.avro2s.test.namespaces.RecordWithInheritedNamespace = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.RecordWithInheritedNamespace() else reuse$
    decodeRecord$17(result$, in$)
    result$
  }

  private def decodeRecord$17(value$: _root_.avro2s.test.namespaces.RecordWithInheritedNamespace, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$18(in$)
      value$.`_record_with_namespace_inherited_from_indirect_parent` = decode$19(in$, value$.`_record_with_namespace_inherited_from_indirect_parent`)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$18(in$)
          case 1 => value$.`_record_with_namespace_inherited_from_indirect_parent` = decode$19(in$, value$.`_record_with_namespace_inherited_from_indirect_parent`)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$18(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$18(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }

  private def encode$19(value$: _root_.avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$20(value$.`_string`, out$)
  }

  private def decode$19(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent): _root_.avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent() else reuse$
    decodeRecord$19(result$, in$)
    result$
  }

  private def decodeRecord$19(value$: _root_.avro2s.test.namespaces.RecordWithNamespaceInheritedFromIndirectParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$20(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$20(in$)
          case index$ => throw new _root_.org.apache.avro.AvroTypeException("Invalid field index: " + index$)
        }
        i$ += 1
      }
    }
  }

  private def encode$20(value$: _root_.java.lang.String, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    out$.writeString(value$)
  }

  private def decode$20(in$: _root_.org.apache.avro.io.ResolvingDecoder): _root_.java.lang.String = {
    in$.readString()
  }
}

object Namespaces {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"Namespaces","namespace":"avro2s.test.namespaces","fields":[{"name":"_record_with_explicit_namespace","type":{"type":"record","name":"RecordWithExplicitNamespace","namespace":"avro2s.test.namespaces.explicit","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_direct_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromDirectParent","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_indirect_non_top_level_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectNonTopLevelParent","fields":[{"name":"_string","type":"string"}]}}]}},{"name":"_array_of_records","type":{"type":"array","items":{"type":"record","name":"RecordWithNamespaceInheritedViaArray","fields":[{"name":"_string","type":"string"}]}}},{"name":"_map_of_records","type":{"type":"map","values":{"type":"record","name":"RecordWithNamespaceInheritedViaMap","fields":[{"name":"_string","type":"string"}]}}},{"name":"_union_of_records","type":[{"type":"record","name":"RecordWithNamespaceInheritedViaUnion","fields":[{"name":"_string","type":"string"}]},"string"]}]}},{"name":"_record_with_inherited_namespace","type":{"type":"record","name":"RecordWithInheritedNamespace","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_indirect_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectParent","fields":[{"name":"_string","type":"string"}]}}]}}]}""")
}
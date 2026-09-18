/** GENERATED CODE */

package avro2s.test.namespaces.explicit

import scala.annotation.switch

case class RecordWithNamespaceInheritedFromDirectParent(var _string: String, var _record_with_namespace_inherited_from_indirect_non_top_level_parent: avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", new avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent())

  override def getSchema: org.apache.avro.Schema = RecordWithNamespaceInheritedFromDirectParent.SCHEMA$

  override def get(field$: Int): AnyRef = {
    (field$: @switch) match {
      case 0 => _string.asInstanceOf[AnyRef]
      case 1 => _record_with_namespace_inherited_from_indirect_non_top_level_parent.asInstanceOf[AnyRef]
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override def put(field$: Int, value: Any): Unit = {
    (field$: @switch) match {
      case 0 => this._string = {
        value.toString.asInstanceOf[String]
      }
      case 1 => this._record_with_namespace_inherited_from_indirect_non_top_level_parent = {
        value.asInstanceOf[avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent]
      }
      case _ => throw new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }

  override protected def hasCustomCoders(): Boolean = true
  override def customEncode(out$: _root_.org.apache.avro.io.Encoder): Unit = encode$0(this, out$)
  override def customDecode(in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = decodeRecord$0(this, in$)

  private def encode$0(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$1(value$.`_string`, out$)
    encode$2(value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`, out$)
  }

  private def decode$0(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent() else reuse$
    decodeRecord$0(result$, in$)
    result$
  }

  private def decodeRecord$0(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromDirectParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$1(in$)
      value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent` = decode$2(in$, value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$1(in$)
          case 1 => value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent` = decode$2(in$, value$.`_record_with_namespace_inherited_from_indirect_non_top_level_parent`)
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

  private def encode$2(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, out$: _root_.org.apache.avro.io.Encoder): Unit = {
    encode$3(value$.`_string`, out$)
  }

  private def decode$2(in$: _root_.org.apache.avro.io.ResolvingDecoder, reuse$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent): _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent = {
    val result$ = if (reuse$ == null) new _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent() else reuse$
    decodeRecord$2(result$, in$)
    result$
  }

  private def decodeRecord$2(value$: _root_.avro2s.test.namespaces.explicit.RecordWithNamespaceInheritedFromIndirectNonTopLevelParent, in$: _root_.org.apache.avro.io.ResolvingDecoder): Unit = {
    val order$ = in$.readFieldOrderIfDiff()
    if (order$ == null) {
      value$.`_string` = decode$3(in$)
    } else {
      var i$ = 0
      while (i$ < order$.length) {
        (order$(i$).pos(): @_root_.scala.annotation.switch) match {
          case 0 => value$.`_string` = decode$3(in$)
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
}

object RecordWithNamespaceInheritedFromDirectParent {
  val SCHEMA$: org.apache.avro.Schema = new _root_.org.apache.avro.Schema.Parser().parse("""{"type":"record","name":"RecordWithNamespaceInheritedFromDirectParent","namespace":"avro2s.test.namespaces.explicit","fields":[{"name":"_string","type":"string"},{"name":"_record_with_namespace_inherited_from_indirect_non_top_level_parent","type":{"type":"record","name":"RecordWithNamespaceInheritedFromIndirectNonTopLevelParent","fields":[{"name":"_string","type":"string"}]}}]}""")
}
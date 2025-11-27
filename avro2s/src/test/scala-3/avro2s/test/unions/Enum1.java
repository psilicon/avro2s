/** GENERATED CODE */

package avro2s.test.unions;

public enum Enum1 implements org.apache.avro.generic.GenericEnumSymbol<Enum1> {
  sym1, sym2;

  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Enum1\",\"namespace\":\"avro2s.test.unions\",\"symbols\":[\"sym1\",\"sym2\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
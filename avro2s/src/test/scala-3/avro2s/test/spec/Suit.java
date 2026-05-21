/** GENERATED CODE */

package avro2s.test.spec;

public enum Suit implements org.apache.avro.generic.GenericEnumSymbol<Suit> {
  SPADES, HEARTS, DIAMONDS, CLUBS;

  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.SchemaParser().parse("{\"type\":\"enum\",\"name\":\"Suit\",\"namespace\":\"avro2s.test.spec\",\"symbols\":[\"SPADES\",\"HEARTS\",\"DIAMONDS\",\"CLUBS\"]}").mainSchema();
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
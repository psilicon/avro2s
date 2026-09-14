/** GENERATED CODE */

package avro2s.test.docs;

/**
 * Available states.
 */
public enum DocumentedEnum implements org.apache.avro.generic.GenericEnumSymbol<DocumentedEnum> {
  ON, OFF;

  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"DocumentedEnum\",\"namespace\":\"avro2s.test.docs\",\"doc\":\"Available states.\",\"symbols\":[\"ON\",\"OFF\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
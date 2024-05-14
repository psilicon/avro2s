# Testing

#### Testing strategy:
 - Generate source code from Avro schema files
 - Incorporate this source code into the test code
 - Test that the generator produces the expected source code (in case of regressions)
 - Test that the generated source code serializes and deserializes as intended

#### Ease of use:
 - `test/scala/RegenerateTestCode.scala` can be run to auto generate the source code under test from the schemas in `test/resources/input/...`
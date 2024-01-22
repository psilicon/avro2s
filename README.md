# Avro2s

Avro2s (Avro to Scala) is an avro schema to scala case class converter. It generates case classes that extend Avro's Java types such as SpecificRecordBase, SpecificFixed, GenericEnumSymbol, etc. This ensures compatibility with community tooling such as [Confluent Schema Registry](https://github.com/confluentinc/schema-registry).

Avro2s is essentially a rewrite of [avrohugger](https://github.com/julianpeeters/avrohugger). The reasons for the rewrite are:
 - Support for Union types
 - Easier maintainability by removing the use of, and dependency on, [treehugger](https://github.com/eed3si9n/treehugger), which is no longer maintained
 - The ability to start supporting Scala 3 going forward (yet to be implemented)

Features:
 - Scala 2.13 support
 - Support for all Avro types

Roadmap:
 - Logical Types
 - Scala 3 support

Thanks to:
 - Everyone who contributed to [avrohugger](https://github.com/julianpeeters/avrohugger), from which this code is adapted.
 - [ScalaPB](https://github.com/scalapb/ScalaPB), for inspiration on how to simplify the code generation process, and for the `FunctionalPrinter` class used to do this.
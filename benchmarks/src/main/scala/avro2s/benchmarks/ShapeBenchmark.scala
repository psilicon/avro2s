package avro2s.benchmarks

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._

/**
 * Shared shape of every benchmark: one generated record, measured four ways.
 *
 * get and put isolate the generated conversion code. encode and decode measure it in the place
 * it actually runs, driven by Avro's specific writer and reader.
 *
 * JMH forks each benchmark/parameter combination separately, so a fork comparing arms only ever
 * loads one arm's class at these call sites. That keeps the SpecificRecord dispatch monomorphic
 * and stops one arm's presence from de-optimising the other.
 */
@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
abstract class ShapeBenchmark {
  // Literals: annotation arguments must be constants. Workloads holds the same two names.
  @Param(Array("current", "baseline"))
  var arm: String = Workloads.currentArm

  protected def shape: String

  protected def size: Int = Workload.defaultSize

  private var workload: Workload = null

  @Setup(Level.Trial)
  def setup(): Unit = {
    workload = Workloads(arm, shape, size)
    // Never publish a number for code that does not round-trip.
    workload.verify()
  }

  @Benchmark def get(): AnyRef = workload.get()
  @Benchmark def put(): Any = workload.put()
  @Benchmark def encode(): Int = workload.encode()
  @Benchmark def decode(): Any = workload.decode()
}

class PrimitivesBenchmark extends ShapeBenchmark { protected val shape = "primitives" }
class UnionsBenchmark extends ShapeBenchmark { protected val shape = "unions" }
class JavaEnumsBenchmark extends ShapeBenchmark { protected val shape = "javaEnums" }
class ScalaEnumsBenchmark extends ShapeBenchmark { protected val shape = "scalaEnums" }
class LogicalTypesBenchmark extends ShapeBenchmark { protected val shape = "logicalTypes" }
class WideRecordBenchmark extends ShapeBenchmark { protected val shape = "wideRecord" }

/** Sized shapes: collection length and payload size dominate these, so they sweep it. */
abstract class SizedShapeBenchmark extends ShapeBenchmark {
  @Param(Array("0", "4", "16", "256"))
  var collectionSize: Int = Workload.defaultSize

  override protected def size: Int = collectionSize
}

class IdentityArraysBenchmark extends SizedShapeBenchmark { protected val shape = "identityArrays" }
class ConvertingArraysBenchmark extends SizedShapeBenchmark { protected val shape = "convertingArrays" }
class MapsBenchmark extends SizedShapeBenchmark { protected val shape = "maps" }
class StringsBenchmark extends SizedShapeBenchmark { protected val shape = "strings" }
class BytesBenchmark extends SizedShapeBenchmark { protected val shape = "bytes" }

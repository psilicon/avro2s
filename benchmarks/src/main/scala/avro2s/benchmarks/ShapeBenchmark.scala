package avro2s.benchmarks

import java.util.concurrent.TimeUnit
import org.openjdk.jmh.annotations._

/**
 * Shared shape of every benchmark: one generated record, written and read.
 *
 * These are whole operations through Avro's specific writer and reader, which is where the
 * generated get and put actually run. Measuring get and put on their own was tried and dropped:
 * with the results unused, the JIT can eliminate allocations that a real write cannot, so the
 * isolated numbers understated the work and did not reconcile with the write they belong to.
 *
 * JMH forks each benchmark/parameter combination separately, so a fork comparing arms only ever
 * loads one arm's class at these call sites. That keeps the SpecificRecord dispatch monomorphic
 * and stops one arm's presence from de-optimising the other.
 */
@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
// A fixed heap matters more than it looks: without it each fork sizes its heap adaptively, so at
// high allocation rates GC frequency differs between forks. That is a per-fork systematic offset,
// and the error bars - computed within a fork - cannot see it.
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(value = 2, jvmArgs = Array("-Xms2g", "-Xmx2g"))
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

  @Benchmark def write(): Int = workload.write()
  @Benchmark def read(): Any = workload.read()
}

class PrimitivesBenchmark extends ShapeBenchmark { protected val shape = "primitives" }
class UnionsBenchmark extends ShapeBenchmark { protected val shape = "unions" }
class JavaEnumsBenchmark extends ShapeBenchmark { protected val shape = "javaEnums" }
class ScalaEnumsBenchmark extends ShapeBenchmark { protected val shape = "scalaEnums" }
class LogicalTypesBenchmark extends ShapeBenchmark { protected val shape = "logicalTypes" }
class WideRecordBenchmark extends ShapeBenchmark { protected val shape = "wideRecord" }

/** Sized shapes: collection length and payload size dominate these, so they sweep it. */
abstract class SizedShapeBenchmark extends ShapeBenchmark {
  // 64 rather than 256 as the top of the sweep. At 256 the slowest shapes run a few hundred
  // operations per second, so a short warmup leaves them below C2's compile threshold and each
  // fork measures a different compilation tier - which showed up as reproducible-looking
  // differences of over 10% on code that had not changed. Pass --sizes to reach further.
  @Param(Array("0", "4", "16", "64"))
  var collectionSize: Int = Workload.defaultSize

  override protected def size: Int = collectionSize
}

class IdentityArraysBenchmark extends SizedShapeBenchmark { protected val shape = "identityArrays" }
class ConvertingArraysBenchmark extends SizedShapeBenchmark { protected val shape = "convertingArrays" }
class MapsBenchmark extends SizedShapeBenchmark { protected val shape = "maps" }
class StringsBenchmark extends SizedShapeBenchmark { protected val shape = "strings" }
class BytesBenchmark extends SizedShapeBenchmark { protected val shape = "bytes" }

class ElementLongBenchmark extends SizedShapeBenchmark { protected val shape = "elementLong" }
class ElementBytesBenchmark extends SizedShapeBenchmark { protected val shape = "elementBytes" }
class ElementFixedBenchmark extends SizedShapeBenchmark { protected val shape = "elementFixed" }
class ElementInstantBenchmark extends SizedShapeBenchmark { protected val shape = "elementInstant" }
class ElementNanosBenchmark extends SizedShapeBenchmark { protected val shape = "elementNanos" }
class ElementBigDecimalBenchmark extends SizedShapeBenchmark { protected val shape = "elementBigDecimal" }
class ElementDecimalBytesBenchmark extends SizedShapeBenchmark { protected val shape = "elementDecimalBytes" }
class ElementDecimalFixedBenchmark extends SizedShapeBenchmark { protected val shape = "elementDecimalFixed" }
class ElementDurationBenchmark extends SizedShapeBenchmark { protected val shape = "elementDuration" }
class ElementDecimalMapBenchmark extends SizedShapeBenchmark { protected val shape = "elementDecimalMap" }

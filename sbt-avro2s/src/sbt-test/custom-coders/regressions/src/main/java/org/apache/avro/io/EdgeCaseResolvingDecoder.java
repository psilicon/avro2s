package org.apache.avro.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.avro.Schema;

/** Test-only adapter: ResolvingDecoder's schema constructor is package-private. */
public final class EdgeCaseResolvingDecoder extends ResolvingDecoder {
  private final String shape;
  private final boolean invalidIndex;

  public EdgeCaseResolvingDecoder(Schema schema, byte[] bytes, String shape, boolean invalidIndex)
      throws IOException {
    super(schema, schema, DecoderFactory.get().binaryDecoder(bytes, null));
    this.shape = shape;
    this.invalidIndex = invalidIndex;
  }

  @Override
  public ByteBuffer readBytes(ByteBuffer reuse) throws IOException {
    ByteBuffer original = super.readBytes(reuse);
    byte[] bytes = new byte[original.remaining()];
    original.get(bytes);
    switch (shape) {
      case "exact": return ByteBuffer.wrap(bytes);
      case "offset": {
        ByteBuffer padded = ByteBuffer.allocate(bytes.length + 4);
        padded.position(2);
        padded.put(bytes);
        padded.flip();
        padded.position(2);
        return padded.slice(); // Nonzero arrayOffset, zero position.
      }
      case "position": {
        ByteBuffer padded = ByteBuffer.allocate(bytes.length + 4);
        padded.position(2);
        padded.put(bytes);
        padded.flip();
        padded.position(2);
        return padded;
      }
      case "capacity": {
        ByteBuffer padded = ByteBuffer.allocate(bytes.length + 4);
        padded.put(bytes);
        padded.flip();
        return padded;
      }
      case "readonly": return ByteBuffer.wrap(bytes).asReadOnlyBuffer();
      case "direct": {
        ByteBuffer direct = ByteBuffer.allocateDirect(bytes.length);
        direct.put(bytes);
        direct.flip();
        return direct;
      }
      default: throw new AssertionError("Unknown buffer shape: " + shape);
    }
  }

  @Override
  public int readIndex() throws IOException {
    int index = super.readIndex();
    return invalidIndex ? 42 : index;
  }
}

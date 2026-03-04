/**
 * Compresses a string using gzip.
 * Uses the native `CompressionStream` API (Node.js 18+ and modern browsers),
 * with a fallback to Node.js `zlib` for Node.js 14/16.
 */
export async function compress(data: string): Promise<Uint8Array> {
  if (typeof CompressionStream !== 'undefined') {
    const cs = new CompressionStream('gzip');
    const writer = cs.writable.getWriter();
    writer.write(new TextEncoder().encode(data));
    writer.close();

    const chunks: Uint8Array[] = [];
    const reader = cs.readable.getReader();

    while (true) {
      const { done, value } = await reader.read();
      if (done) break;
      if (value) chunks.push(value);
    }

    const totalLength = chunks.reduce((sum, chunk) => sum + chunk.length, 0);
    const result = new Uint8Array(totalLength);
    let offset = 0;
    for (const chunk of chunks) {
      result.set(chunk, offset);
      offset += chunk.length;
    }

    return result;
  }

  // Fallback for Node.js < 18
  const { promisify } = await import('util');
  const { gzip } = await import('zlib');
  return promisify(gzip)(data);
}

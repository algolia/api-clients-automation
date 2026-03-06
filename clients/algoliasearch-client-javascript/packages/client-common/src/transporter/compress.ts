// Minimal types for CompressionStream (available in modern browsers, not in @types/node)
interface CompressionStream {
  readonly writable: { getWriter(): { write(v: Uint8Array): void; close(): void } };
  readonly readable: { getReader(): { read(): Promise<{ done: boolean; value: Uint8Array }> } };
}
declare const CompressionStream: { new (format: string): CompressionStream };

// __BROWSER__ is replaced at build time by tsup (true for browser, false for Node).
// Falls back to false (Node path) when not set, e.g. during tests.
declare const __BROWSER__: boolean | undefined;

export const COMPRESSION_THRESHOLD = 750;

/**
 * Compresses a string using gzip.
 * Uses node:zlib on Node.js and CompressionStream on browsers.
 * Works on all Node.js versions and modern browsers with no additional dependencies.
 */
export async function compress(data: string): Promise<Uint8Array> {
  // Node.js path: zlib (eliminated in browser builds via if (false) dead-code removal)
  if (typeof __BROWSER__ === 'undefined' || !__BROWSER__) {
    const { gzip } = await import('node:zlib');
    return new Promise((resolve, reject) => {
      gzip(Buffer.from(data), (err, result) => {
        if (err) reject(err);
        else resolve(new Uint8Array(result));
      });
    });
  }

  // Browser path: CompressionStream Web API
  const stream = new CompressionStream('gzip');
  const writer = stream.writable.getWriter();
  writer.write(new TextEncoder().encode(data));
  writer.close();

  const chunks: Uint8Array[] = [];
  const reader = stream.readable.getReader();
  while (true) {
    const { done, value } = await reader.read();
    if (done) break;
    chunks.push(value);
  }

  const total = chunks.reduce((n, c) => n + c.length, 0);
  const result = new Uint8Array(total);
  let offset = 0;
  for (const chunk of chunks) {
    result.set(chunk, offset);
    offset += chunk.length;
  }
  return result;
}

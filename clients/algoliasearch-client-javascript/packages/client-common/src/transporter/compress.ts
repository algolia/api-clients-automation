import { gzip } from 'fflate';

/**
 * Compresses a string using gzip via fflate.
 * Works on all Node.js versions and browsers with no native API requirements.
 */
export function compress(data: string): Promise<Uint8Array> {
  return new Promise((resolve, reject) => {
    gzip(new TextEncoder().encode(data), (err, result) => {
      if (err) reject(err);
      else resolve(result);
    });
  });
}

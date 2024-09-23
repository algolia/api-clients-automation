import type { Server } from 'http';
import zlib from 'node:zlib';

import crc32 from 'crc/crc32';
import type { Express } from 'express';

import { setupServer } from './index.ts';
import { retryHandler } from './timeout.ts';

function addRoutes(app: Express): void {
  app.get('/1/test/retry/:lang', retryHandler(0, 'ok test server response'));

  app.post('/1/test/gzip', (req, res) => {
    let rawBody = Buffer.from([]);

    req.on('data', (data) => {
      rawBody = Buffer.concat([rawBody, data]);
    });

    req.on('error', (err) => {
      res.json({ message: `500 Internal Server Error: ${err}` });
    });

    req.on('end', () => {
      try {
        const isGzip = req.headers['content-encoding'] === 'gzip';
        if (!isGzip) {
          res.json({ message: 'content-encoding header is not gzip' });
          return;
        }

        const hasGzipMagicNumber = rawBody.subarray(0, 2).toString('hex') === '1f8b';
        if (!hasGzipMagicNumber) {
          res.json({ message: 'gzip magic number is not present' });
          return;
        }

        // Extract the stored checksum from the last 8-4 bytes of the gzip file
        const storedChecksum = rawBody.subarray(-8, -4).readUInt32LE().toString(16);

        // Extract the stored length from the last 4 bytes of the gzip file
        const storedLength = rawBody.subarray(-4).readUInt32LE().toString(16);

        // Decompress the request body
        zlib.unzip(rawBody, (err, decompressedData) => {
          if (err) {
            res.json({ message: `error decompressing request body: ${err}` });
            return;
          }

          const decompressedBody = String.fromCharCode(...decompressedData.toJSON().data);
          const decompressedJSON = JSON.parse(decompressedBody);

          // Compute checksum for the decompressed data
          const computedChecksum = crc32(decompressedBody).toString(16);

          if (computedChecksum !== storedChecksum) {
            res.json({ message: 'checksum mismatch', storedChecksum, computedChecksum });
            return;
          }

          if (decompressedBody.length !== parseInt(storedLength, 16)) {
            res.json({
              message: 'length mismatch',
              storedLength,
              decompressedLength: decompressedBody.length,
            });
            return;
          }

          if (decompressedJSON.message !== 'this is a compressed body') {
            res.json({ message: 'invalid decompressed body', body: decompressedJSON });
            return;
          }

          res.json({ message: 'ok compression test server response', body: decompressedJSON });
        });
      } catch (e) {
        res.json({ message: '500 Internal Server Error', error: e });
      }
    });
  });
}

export function gzipServer(): Promise<Server> {
  return setupServer('gzip', 6678, addRoutes);
}

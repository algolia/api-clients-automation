import type { Server } from 'http';
import zlib from 'zlib';

import crc32 from 'crc/crc32';
import express from 'express';

import { createSpinner } from '../spinners';

let timeoutCounter = 0;

async function timeoutServer(): Promise<Server> {
  const spinner = createSpinner('starting tiemout test server');
  const app = express();
  const port = 6677;
  app.get('/1/test/retry', (req, res) => {
    // this is safe because js is single threaded
    timeoutCounter++;
    // wait for 7.5 seconds, the default read timeout is 5 seconds + 2s of connection timeout
    setTimeout(() => {
      res.json({ message: 'timeout test server response' });
    }, 7500);
  });

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(port, () => {
      spinner.text = `timeout test server listening at http://localhost:${port}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed('timeout test server closed');
  });

  return server;
}

async function okServer(): Promise<Server> {
  const spinner = createSpinner('starting ok test server');
  const app = express();
  const port = 6678;
  app.get('/1/test/retry', (req, res) => {
    res.json({ message: 'ok test server response' });
  });

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

          res.json({ message: 'ok compression test server response', body: decompressedJSON });
        });
      } catch (e) {
        res.json({ message: '500 Internal Server Error', error: e });
      }
    });
  });

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(port, () => {
      spinner.text = `ok test server listening at http://localhost:${port}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed('ok test server closed');
  });

  return server;
}

export async function startTestServer(): Promise<() => Promise<void>> {
  const server1 = await timeoutServer();
  const server2 = await okServer();

  return async () => {
    await Promise.all([
      new Promise<void>((resolve) => {
        server1.close(() => {
          resolve();
        });
      }),
      new Promise<void>((resolve) => {
        server2.close(() => {
          resolve();
        });
      }),
    ]);
  };
}

export function getTimeoutCounter(): number {
  return timeoutCounter;
}

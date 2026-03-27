import type { Server } from 'http';

import zlib from 'node:zlib';

import type { Express } from 'express';

import { setupServer } from './index.ts';

const RESPONSE_BODY = {
  message: 'ok decompression test server response',
  data: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
};

function addRoutes(app: Express): void {
  app.get('/1/test/gzip-response', (req, res) => {
    const acceptEncoding = req.headers['accept-encoding'] || '';
    if (!acceptEncoding.includes('gzip')) {
      res.status(400).json({ message: 'client did not send accept-encoding: gzip' });
      return;
    }

    const body = JSON.stringify(RESPONSE_BODY);
    zlib.gzip(Buffer.from(body, 'utf-8'), (err, compressed) => {
      if (err) {
        res.status(500).json({ message: `error compressing response: ${err}` });
        return;
      }

      res.writeHead(200, {
        'Content-Type': 'application/json',
        'Content-Encoding': 'gzip',
      });
      res.end(compressed);
    });
  });
}

export function gzipResponseServer(): Promise<Server> {
  return setupServer('gzipResponse', 6691, addRoutes);
}

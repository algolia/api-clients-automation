import type { Server } from 'http';

import type express from 'express';

import { setupServer } from '.';

let timeoutCounter = 0;

export function getTimeoutCounter(): number {
  return timeoutCounter;
}

function addRoutes(app: express.Express): void {
  app.get('/1/test/retry', (req, res) => {
    // this is safe because js is single threaded
    timeoutCounter++;
    // wait for 7.5 seconds, the default read timeout is 5 seconds + 2s of connection timeout
    setTimeout(() => {
      res.json({ message: 'timeout test server response' });
    }, 7500);
  });
}

export function timeoutServer(): Promise<Server> {
  return setupServer('timeout', 6677, addRoutes);
}

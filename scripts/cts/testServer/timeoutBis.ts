import type { Server } from 'http';

import type express from 'express';

import { retryHandler } from './timeout';

import { setupServer } from '.';

function addRoutes(app: express.Express): void {
  // this endpoint is also defined in the gzip server but without the timeout
  app.get('/1/test/retry/:lang', retryHandler(20000, 'timeout bis test server response'));
}

export function timeoutServerBis(): Promise<Server> {
  return setupServer('timeoutBis', 6677, addRoutes);
}

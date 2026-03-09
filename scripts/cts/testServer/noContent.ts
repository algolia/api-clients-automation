import type { Server } from 'http';

import type express from 'express';

import { setupServer } from './index.ts';

function addRoutes(app: express.Express): void {
  app.all('/1/test/no-content', (_req, res) => {
    res.status(204).end();
  });
}

export function noContentServer(): Promise<Server> {
  return setupServer('noContent', 6691, addRoutes);
}

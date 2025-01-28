import type { Server } from 'http';

import type { Express, Request, Response } from 'express';

import { setupServer } from './index.ts';

// Checks that the client sends a different API key after the first request.
function addRoutes(app: Express): void {
  app.post('/1/indexes/:indexName/batch', (req: Request, res: Response) => {
    res.json({
      taskID: 333,
      objectIDs: ['1', '2'],
    });
  });
  app.get('/1/indexes/:indexName/task/:taskID', (req, res) => {
    res.json({
      status: 'published',
    });
  });
}

export function algoliaMockServer(): Promise<Server> {
  return setupServer('algoliaMock', 6686, addRoutes);
}

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
  app.post('/1/indexes/:indexName/query', (req, res) => {
    res.json({
      hits: [],
      page: 0,
      nbHits: 0,
      nbPages: 0,
      hitsPerPage: 20,
      exhaustiveNbHits: true,
      exhaustiveTypo: true,
      exhaustive: {
        nbHits: true,
        typo: true,
      },
      query: '',
      params: '',
      index: 'playlists',
      renderingContent: {},
      processingTimeMS: 0,
    });
  });

  app.get('/1/runs/:runID/events/:eventID', (req, res) => {
    res.json({
      eventID: req.params.eventID,
      runID: req.params.runID,
      status: null,
      type: 'log',
      batchSize: 100,
      data: null,
      publishedAt: '2023-10-03T12:00:00Z',
    });
  });
}

export function algoliaMockServer(): Promise<Server> {
  return setupServer('algoliaMock', 6686, addRoutes);
}

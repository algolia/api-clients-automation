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

  app.get('/1/indexes/:indexName/settings', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_unknownField_(.*)$/)?.[1] as string;
    let unknown = {};
    if (lang !== 'javascript' && lang !== 'python') {
      // js and python just put the response in a map, there is no strict parsing.
      unknown = {
        unknownFieldNameThatWillNeverBeAddedToTheSpecIHope: 'hello',
      };
    }

    res.json({
      minWordSizefor1Typo: 12,
      minWordSizefor2Typos: 13,
      hitsPerPage: 14,
      ...unknown,
    });
  });

  app.get('/1/indexes/:indexName/rules/:objectID', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_unknownFieldNested_(.*)$/)?.[1] as string;
    let unknown = {};
    if (lang !== 'javascript' && lang !== 'python') {
      unknown = {
        unknownFieldNameThatWillNeverBeAddedToTheSpecIHope: 'hello',
      };
    }

    res.json({
      objectID: req.params.objectID,
      consequence: {
        promote: [
          {
            objectID: '1',
            position: 10,
            ...unknown,
          },
        ],
      },
    });
  });
}

export function algoliaMockServer(): Promise<Server> {
  return setupServer('algoliaMock', 6686, addRoutes);
}

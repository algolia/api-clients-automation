import type { Server } from 'http';

import { expect } from 'chai';
import express from 'express';
import type { Express } from 'express';

import { setupServer } from './index.ts';

const chunkWrapperState: Record<string, any> = {};

export function assertChunkWrapperValid(expectedCount: number): void {
  if (Object.values(chunkWrapperState).length !== expectedCount) {
    throw new Error('unexpected number of call to chunkWrapper');
  }
  for (const [lang, state] of Object.entries(chunkWrapperState)) {
    let numberOfTestSuites = 1;

    if (lang === 'python') {
      numberOfTestSuites = 2;
    }

    expect(state).to.deep.equal({
      saveObjects: Number(numberOfTestSuites),
      partialUpdateObjects: 2 * numberOfTestSuites,
      deleteObjects: Number(numberOfTestSuites),
    });
  }
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.post('/1/indexes/:indexName/batch', (req, res) => {
    const match = req.params.indexName.match(/^cts_e2e_(\w+)_(.*)$/);
    const helper = match?.[1] as string;
    const lang = match?.[2] as string;

    if (!chunkWrapperState[lang]) {
      chunkWrapperState[lang] = {};
    }

    if (req.headers['x-algolia-api-key'] === 'wrong-api-key') {
      res.status(403).json({ message: 'Invalid Application-ID or API key', status: 403 });
      return;
    }
    chunkWrapperState[lang][helper] = (chunkWrapperState[lang][helper] ?? 0) + 1;
    switch (helper) {
      case 'saveObjects':
        expect(req.body).to.deep.equal({
          requests: [
            { action: 'addObject', body: { objectID: '1', name: 'Adam' } },
            { action: 'addObject', body: { objectID: '2', name: 'Benoit' } },
          ],
        });

        res.json({
          taskID: 333,
          objectIDs: req.body.requests.map((r) => r.body.objectID),
        });

        break;
      case 'partialUpdateObjects':
        if (req.body.requests[0].body.objectID === '1') {
          expect(req.body).to.deep.equal({
            requests: [
              { action: 'partialUpdateObject', body: { objectID: '1', name: 'Adam' } },
              { action: 'partialUpdateObject', body: { objectID: '2', name: 'Benoit' } },
            ],
          });

          res.json({
            taskID: 444,
            objectIDs: req.body.requests.map((r) => r.body.objectID),
          });
        } else {
          expect(req.body).to.deep.equal({
            requests: [
              { action: 'partialUpdateObjectNoCreate', body: { objectID: '3', name: 'Cyril' } },
              { action: 'partialUpdateObjectNoCreate', body: { objectID: '4', name: 'David' } },
            ],
          });

          res.json({
            taskID: 555,
            objectIDs: req.body.requests.map((r) => r.body.objectID),
          });
        }
        break;
      case 'deleteObjects':
        expect(req.body).to.deep.equal({
          requests: [
            { action: 'deleteObject', body: { objectID: '1' } },
            { action: 'deleteObject', body: { objectID: '2' } },
          ],
        });

        res.json({
          taskID: 666,
          objectIDs: req.body.requests.map((r) => r.body.objectID),
        });
        break;
      default:
        throw new Error('unknown helper');
    }
  });
}

export function chunkWrapperServer(): Promise<Server> {
  return setupServer('chunkWrapper', 6680, addRoutes);
}

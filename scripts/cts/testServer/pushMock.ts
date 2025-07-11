import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const pushMockState: Record<string, any> = {};

export function assertPushMockValid(expectedCount: number): void {
  if (Object.values(pushMockState).length !== expectedCount) {
    throw new Error('unexpected number of call to pushMock');
  }
  for (const [lang, state] of Object.entries(pushMockState)) {
    let numberOfTestSuites = 1;

    if (lang === 'python') {
      numberOfTestSuites = 2;
    }

    expect(state).to.deep.equal({
      saveObjectsWithTransformation: Number(numberOfTestSuites),
      partialUpdateObjectsWithTransformation: Number(numberOfTestSuites),
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

  app.post('/1/push/:indexName', (req, res) => {
    const match = req.params.indexName.match(/^cts_e2e_(\w+)_(.*)$/);
    const helper = match?.[1] as string;
    const lang = match?.[2] as string;

    if (!pushMockState[lang]) {
      pushMockState[lang] = {};
    }

    pushMockState[lang][helper] = (pushMockState[lang][helper] ?? 0) + 1;
    switch (helper) {
      case 'saveObjectsWithTransformation':
        expect(req.body).to.deep.equal({
          action: 'addObject',
          records: [
            { objectID: '1', name: 'Adam' },
            { objectID: '2', name: 'Benoit' },
          ],
        });

        res.json({
          runID: 'b1b7a982-524c-40d2-bb7f-48aab075abda',
          eventID: '113b2068-6337-4c85-b5c2-e7b213d82925',
          message: 'OK',
          createdAt: '2022-05-12T06:24:30.049Z',
        });

        break;
      case 'partialUpdateObjectsWithTransformation':
        expect(req.body).to.deep.equal({
          action: 'partialUpdateObject',
          records: [
            { objectID: '1', name: 'Adam' },
            { objectID: '2', name: 'Benoit' },
          ],
        });

        res.json({
          runID: 'b1b7a982-524c-40d2-bb7f-48aab075abda',
          eventID: '113b2068-6337-4c85-b5c2-e7b213d82925',
          message: 'OK',
          createdAt: '2022-05-12T06:24:30.049Z',
        });
        break;
      default:
        throw new Error('unknown helper');
    }
  });
}

export function pushMockServer(): Promise<Server> {
  return setupServer('pushMock', 6689, addRoutes);
}

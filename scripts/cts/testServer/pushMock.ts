import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const pushMockState: Record<
  string,
  {
    retriedEvents: boolean;
    retriedHosts: boolean;
    saveObjectsWithTransformation: number;
    partialUpdateObjectsWithTransformation: number;
  }
> = {};

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
      retriedHosts: true,
      retriedEvents: true,
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
      // simulate a retry at the hosts level
      pushMockState[lang] = {
        retriedHosts: true,
        retriedEvents: false,
        saveObjectsWithTransformation: 0,
        partialUpdateObjectsWithTransformation: 0,
      };

      res.status(500).json({ message: 'error test server response' });
      return;
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
          runID: `b1b7a982-524c-40d2-bb7f-48aab075abda_${lang}`,
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
          runID: `b1b7a982-524c-40d2-bb7f-48aab075abda_${lang}`,
          eventID: '113b2068-6337-4c85-b5c2-e7b213d82925',
          message: 'OK',
          createdAt: '2022-05-12T06:24:30.049Z',
        });
        break;
      default:
        throw new Error('unknown helper');
    }
  });

  app.get('/1/runs/:runID/events/:eventID', (req, res) => {
    const lang = req.params.runID.match(/^b1b7a982-524c-40d2-bb7f-48aab075abda_(.*)$/)?.[1] as string;

    if (pushMockState[lang] && !pushMockState[lang]?.retriedEvents) {
      pushMockState[lang].retriedEvents = true;
      res.status(404).json({ message: 'error test server response' });

      return;
    }

    res.json({
      status: 'succeeded',
      eventID: req.params.eventID,
      runID: req.params.runID,
      type: 'fetch',
      batchSize: 1,
      publishedAt: '2022-05-12T06:24:30.049Z',
    });
  });
}

export function pushMockServerRetriedOnce(): Promise<Server> {
  return setupServer('pushMockRetriedOnce', 6689, addRoutes);
}

export function pushMockServer(): Promise<Server> {
  return setupServer('pushMock', 6688, addRoutes);
}

import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const chunkedPushWaitState: Record<string, { pushCount: number; getEventCount: number; polledEventIDs: Set<string> }> =
  {};

// every pushed task must be polled exactly once; a poll cursor that over-advances polls fewer.
export function assertValidChunkedPushWait(expectedCount: number): void {
  expect(Object.keys(chunkedPushWaitState)).to.have.length(expectedCount);
  for (const lang in chunkedPushWaitState) {
    // at least 3 (25 objects / batchSize 10), not exactly: python runs the scenario twice (sync + async)
    expect(chunkedPushWaitState[lang].pushCount, `pushCount for ${lang}`).to.be.at.least(3);
    expect(chunkedPushWaitState[lang].getEventCount, `getEventCount for ${lang}`).to.equal(
      chunkedPushWaitState[lang].pushCount,
    );
    // distinct events polled == events pushed: rules out polling one task twice while skipping another
    expect(chunkedPushWaitState[lang].polledEventIDs.size, `distinct polled eventIDs for ${lang}`).to.equal(
      chunkedPushWaitState[lang].pushCount,
    );
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
    const lang = req.params.indexName.match(/^cts_e2e_chunked_push_wait_(.*)$/)?.[1] as string;
    expect(lang, `unexpected index name ${req.params.indexName}`).to.not.equal(undefined);
    expect(req.body.action).to.equal('addObject');

    if (!chunkedPushWaitState[lang]) {
      chunkedPushWaitState[lang] = { pushCount: 0, getEventCount: 0, polledEventIDs: new Set() };
    }
    chunkedPushWaitState[lang].pushCount++;

    res.json({
      runID: `b1b7a982-524c-40d2-bb7f-48aab075abda_${lang}`,
      // a distinct eventID per push so the client polls a distinct task each time
      eventID: `113b2068-6337-4c85-b5c2-e7b213d8292${chunkedPushWaitState[lang].pushCount}`,
      message: 'OK',
      createdAt: '2022-05-12T06:24:30.049Z',
    });
  });

  app.get('/1/runs/:runID/events/:eventID', (req, res) => {
    const lang = req.params.runID.match(/^b1b7a982-524c-40d2-bb7f-48aab075abda_(.*)$/)?.[1] as string;
    expect(chunkedPushWaitState, `getEvent before any push for ${lang}`).to.include.keys(lang);

    chunkedPushWaitState[lang].getEventCount++;
    chunkedPushWaitState[lang].polledEventIDs.add(req.params.eventID);

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

export function chunkedPushWaitServer(): Promise<Server> {
  return setupServer('chunkedPushWaitServer', 6693, addRoutes);
}

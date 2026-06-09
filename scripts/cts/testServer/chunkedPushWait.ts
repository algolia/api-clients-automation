import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

// Per-language counters for the chunkedPush "waitForTasks" flow.
// `pushCount`     = number of `push` requests the client made (one per batch).
// `getEventCount` = number of `getEvent` polls the client made (must be one per pushed task).
const chunkedPushWaitState: Record<string, { pushCount: number; getEventCount: number }> = {};

// This test drives `saveObjectsWithTransformation` with batchSize=10 over 25 objects and
// `waitForTasks: true`, which produces 3 batches (10/10/5) and a poll window of 1
// (`waitBatchSize = batchSize / 10`). A correct helper polls `getEvent` exactly once per pushed
// task (getEventCount === pushCount === 3). A helper whose poll cursor over-advances on non-push
// iterations polls fewer tasks (getEventCount < pushCount), and a strongly-typed one that slices
// past the end of its response list crashes instead — so this assertion fails for buggy clients.
export function assertValidChunkedPushWait(expectedCount: number): void {
  expect(Object.keys(chunkedPushWaitState)).to.have.length(expectedCount);
  for (const lang in chunkedPushWaitState) {
    // 25 objects at batchSize 10 => 3 batches per client variant. A language may run this twice
    // (sync + async), so pushCount is a positive multiple of 3; we only require the triggering
    // scenario ran at least once. The discriminator is the invariant below: every pushed task
    // must be polled exactly once. A client whose poll cursor over-advances polls fewer.
    expect(chunkedPushWaitState[lang].pushCount, `pushCount for ${lang}`).to.be.at.least(3);
    expect(chunkedPushWaitState[lang].getEventCount, `getEventCount for ${lang}`).to.equal(
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
      chunkedPushWaitState[lang] = { pushCount: 0, getEventCount: 0 };
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
  // simulates the ingestion `push` + `getEvent` endpoints to verify that the chunkedPush helper
  // polls every pushed task when waitForTasks is true. See assertValidChunkedPushWait for details.
  return setupServer('chunkedPushWaitServer', 6692, addRoutes);
}

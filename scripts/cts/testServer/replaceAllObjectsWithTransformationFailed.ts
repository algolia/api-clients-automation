import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const INDEX_PREFIX = 'cts_e2e_replace_all_objects_with_transformation_failed_';

const raowtFailedState: Record<
  string,
  {
    tmpIndexNames: string[];
    deletedIndexNames: string[];
    pushCount: number;
    getEventCount: number;
    moveCount: number;
  }
> = {};

// the push events fail, so the tmp index must be deleted and never moved over the production index.
export function assertValidReplaceAllObjectsWithTransformationFailed(expectedCount: number): void {
  expect(Object.keys(raowtFailedState)).to.have.length(expectedCount);
  for (const lang in raowtFailedState) {
    const state = raowtFailedState[lang];
    expect(state.moveCount, `moveCount for ${lang}`).to.equal(0);
    expect(state.tmpIndexNames.length, `tmp indices created for ${lang}`).to.be.at.least(1);
    expect(state.pushCount, `pushCount for ${lang}`).to.equal(state.tmpIndexNames.length);
    expect(state.getEventCount, `getEventCount for ${lang}`).to.equal(state.pushCount);
    expect(state.deletedIndexNames, `deleted indices for ${lang}`).to.deep.equal(state.tmpIndexNames);
  }
}

function langFromIndexName(indexName: string): string {
  const lang = indexName.match(new RegExp(`^${INDEX_PREFIX}(.*?)(_tmp_\\d+)?$`))?.[1];
  expect(lang, `unexpected index name ${indexName}`).to.not.equal(undefined);

  return lang as string;
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.post('/1/indexes/:indexName/operation', (req, res) => {
    const lang = langFromIndexName(req.params.indexName);

    if (req.body.operation === 'move') {
      raowtFailedState[lang].moveCount++;
      res.status(400).json({ message: 'the tmp index must not be moved when ingestion failed', status: 400 });

      return;
    }

    expect(req.body.operation).to.equal('copy');
    expect(req.params.indexName).to.equal(`${INDEX_PREFIX}${lang}`);
    expect(req.body.destination).to.match(new RegExp(`^${INDEX_PREFIX}${lang}_tmp_\\d+$`));

    if (!raowtFailedState[lang]) {
      raowtFailedState[lang] = {
        tmpIndexNames: [],
        deletedIndexNames: [],
        pushCount: 0,
        getEventCount: 0,
        moveCount: 0,
      };
    }
    raowtFailedState[lang].tmpIndexNames.push(req.body.destination);

    res.json({ taskID: 123, updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.post('/1/push/:indexName', (req, res) => {
    const lang = langFromIndexName(req.params.indexName);
    expect(raowtFailedState).to.include.keys(lang);
    expect(req.params.indexName).to.equal(raowtFailedState[lang].tmpIndexNames.at(-1));
    expect(req.query.referenceIndexName).to.equal(`${INDEX_PREFIX}${lang}`);

    raowtFailedState[lang].pushCount++;

    res.json({
      runID: `b1b7a982-524c-40d2-bb7f-48aab075abda_${lang}`,
      eventID: '113b2068-6337-4c85-b5c2-e7b213d82921',
      message: 'OK',
      createdAt: '2022-05-12T06:24:30.049Z',
    });
  });

  app.get('/1/runs/:runID/events/:eventID', (req, res) => {
    const lang = req.params.runID.match(/^b1b7a982-524c-40d2-bb7f-48aab075abda_(.*)$/)?.[1] as string;
    expect(raowtFailedState).to.include.keys(lang);

    raowtFailedState[lang].getEventCount++;

    res.json({
      status: 'failed',
      eventID: req.params.eventID,
      runID: req.params.runID,
      type: 'record',
      batchSize: 1,
      data: { message: 'unretryable error from the destination' },
      publishedAt: '2022-05-12T06:24:30.049Z',
    });
  });

  app.get('/1/indexes/:indexName/task/:taskID', (_req, res) => {
    res.json({ status: 'published', updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.delete('/1/indexes/:indexName', (req, res) => {
    const lang = langFromIndexName(req.params.indexName);
    expect(raowtFailedState).to.include.keys(lang);
    raowtFailedState[lang].deletedIndexNames.push(req.params.indexName);

    res.json({ taskID: 456, deletedAt: '2021-01-01T00:00:00.000Z' });
  });
}

export function replaceAllObjectsWithTransformationFailedServer(): Promise<Server> {
  return setupServer('replaceAllObjectsWithTransformationFailed', 6699, addRoutes);
}

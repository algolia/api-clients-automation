import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const REQUEST_ID_FORMAT = /^[0-9A-Za-z]{11}$/;

const retryState: Record<string, string[]> = {};
const freshState: Record<string, string[]> = {};
const helperState: Record<string, string[]> = {};
const smokeState: Record<string, string[]> = {};

function observedRequestId(req: express.Request): string {
  return (req.headers['request-id'] as string) ?? (req.query['x-algolia-request-id'] as string) ?? '';
}

function record(state: Record<string, string[]>, key: string, req: express.Request): void {
  if (!state[key]) {
    state[key] = [];
  }

  state[key].push(observedRequestId(req));
}

export function assertValidRequestIds(expectedCount: number): void {
  expect(Object.keys(retryState)).to.have.length(expectedCount);
  expect(Object.keys(freshState)).to.have.length(expectedCount);
  expect(Object.keys(helperState)).to.have.length(expectedCount);
  // recommend and composition each run one smoke test per language
  expect(Object.keys(smokeState)).to.have.length(2 * expectedCount);

  for (const [lang, ids] of Object.entries(retryState)) {
    // python has sync and async tests
    const suites = lang === 'python' ? 2 : 1;

    expect(ids).to.have.length(3 * suites);
    for (let i = 0; i < suites; i++) {
      const attempts = ids.slice(3 * i, 3 * i + 3);
      expect(attempts[0]).to.match(REQUEST_ID_FORMAT);
      expect(new Set(attempts).size).to.equal(1, `every retry of one ${lang} call must reuse the same Request-ID`);
    }
    expect(new Set(ids).size).to.equal(suites, `each ${lang} test suite must mint its own Request-ID`);
  }

  for (const [lang, ids] of Object.entries(freshState)) {
    const suites = lang === 'python' ? 2 : 1;

    expect(ids).to.have.length(2 * suites);
    for (const id of ids) {
      expect(id).to.match(REQUEST_ID_FORMAT);
    }
    expect(new Set(ids).size).to.equal(ids.length, `each ${lang} call must mint a fresh Request-ID`);
  }

  for (const [lang, ids] of Object.entries(helperState)) {
    const suites = lang === 'python' ? 2 : 1;

    // one chunkedBatch call = 2 batch requests + 2 task polls
    expect(ids).to.have.length(4 * suites);
    for (let i = 0; i < suites; i++) {
      const helperRun = ids.slice(4 * i, 4 * i + 4);
      expect(helperRun[0]).to.match(REQUEST_ID_FORMAT);
      expect(new Set(helperRun).size).to.equal(1, `every request of one ${lang} helper call must share one Request-ID`);
    }
  }

  for (const [key, ids] of Object.entries(smokeState)) {
    for (const id of ids) {
      expect(id).to.match(REQUEST_ID_FORMAT, `the ${key} client must send a well-formed Request-ID`);
    }
  }
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.post('/1/test/request-id/retry/:lang', (req, res) => {
    const lang = req.params.lang;
    record(retryState, lang, req);

    if (retryState[lang].length % 3 !== 0) {
      res.status(500).json({ message: 'request-id retry test' });
      return;
    }

    res.status(200).json({ status: 'ok' });
  });

  app.get('/1/test/request-id/fresh/:lang', (req, res) => {
    record(freshState, req.params.lang, req);
    res.status(200).json({ status: 'ok' });
  });

  app.get('/1/test/request-id/caller/:lang', (req, res) => {
    res.status(200).json({ requestId: observedRequestId(req) });
  });

  app.get('/1/test/request-id/smoke/:client/:lang', (req, res) => {
    record(smokeState, `${req.params.client}:${req.params.lang}`, req);
    res.status(200).json({ status: 'ok' });
  });

  app.get('/1/test/request-id/error/:lang', (req, res) => {
    res.setHeader('Correlation-ID', 'CtsFixedCorrelationId');
    res.status(400).json({ message: 'request-id error test' });
  });

  app.post('/1/indexes/:indexName/batch', (req, res) => {
    record(helperState, req.params.indexName.replace('cts_request_id_', ''), req);
    res.json({
      taskID: 42,
      objectIDs: req.body.requests.map((request) => request.body.objectID),
    });
  });

  app.get('/1/indexes/:indexName/task/42', (req, res) => {
    record(helperState, req.params.indexName.replace('cts_request_id_', ''), req);
    res.json({ status: 'published', updatedAt: '2021-01-01T00:00:00.000Z' });
  });
}

export function requestIdServer(): Promise<Server> {
  return setupServer('requestId', 6694, addRoutes);
}

export function requestIdServerBis(): Promise<Server> {
  return setupServer('requestIdBis', 6695, addRoutes);
}

export function requestIdServerTer(): Promise<Server> {
  return setupServer('requestIdTer', 6696, addRoutes);
}

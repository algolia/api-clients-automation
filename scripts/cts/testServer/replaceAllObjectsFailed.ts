import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from '.';

const raoState: Record<
  string,
  {
    tmpIndexName: string;
    successful: boolean;
  }
> = {};

export function assertValidReplaceAllObjectsFailed(expectedCount: number): void {
  const count = Object.values(raoState).filter((s) => s.successful).length;
  if (count !== expectedCount) {
    throw new Error(`Expected ${expectedCount} call to replaceAllObjectsFailed, got ${count} instead.`);
  }
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.post('/1/indexes/:indexName/operation', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_replace_all_objects_too_big_(.*)$/)?.[1] as string;
    raoState[lang] = {
      tmpIndexName: req.body.destination,
      successful: false,
    };

    res.json({ taskID: 123, updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.post('/1/indexes/:indexName/batch', (_req, res) => {
    res.status(400).json({ message: 'Record is too big', status: 400 });
  });

  app.delete('/1/indexes/:indexName', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_replace_all_objects_too_big_(.*)_tmp/)?.[1] as string;
    expect(raoState[lang].tmpIndexName).to.equal(req.params.indexName);
    raoState[lang].successful = true;

    res.json({ taskID: 456, deletedAt: '2021-01-01T00:00:00.000Z' });
  });
}

export function replaceAllObjectsServerFailed(): Promise<Server> {
  // this server is used to simulate the responses for the replaceAllObjects method, with cleanup
  return setupServer('replaceAllObjectsFailed', 6684, addRoutes);
}

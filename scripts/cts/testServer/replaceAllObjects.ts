import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const raoState: Record<
  string,
  {
    copyCount: number;
    batchCount: number;
    waitTaskCount: number;
    tmpIndexName: string;
    waitingForFinalWaitTask: boolean;
    successful: boolean;
  }
> = {};

export function assertValidReplaceAllObjects(expectedCount: number): void {
  const count = Object.values(raoState).filter((s) => s.successful).length;
  if (count !== expectedCount) {
    throw new Error(`Expected ${expectedCount} call to replaceAllObjects, got ${count} instead.`);
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
    expect(req.params.indexName).to.match(/^cts_e2e_replace_all_objects_(.*)$/);

    switch (req.body.operation) {
      case 'copy': {
        expect(req.params.indexName).to.not.include('tmp');
        expect(req.body.destination).to.include('tmp');
        expect(req.body.scope).to.deep.equal(['settings', 'rules', 'synonyms']);

        const lang = req.params.indexName.replace('cts_e2e_replace_all_objects_', '');
        if (!raoState[lang] || raoState[lang].successful) {
          raoState[lang] = {
            copyCount: 1,
            batchCount: 0,
            waitTaskCount: 0,
            tmpIndexName: req.body.destination,
            waitingForFinalWaitTask: false,
            successful: false,
          };
        } else {
          raoState[lang].copyCount++;
        }

        res.json({ taskID: 123 + raoState[lang].copyCount, updatedAt: '2021-01-01T00:00:00.000Z' });
        break;
      }
      case 'move': {
        const lang = req.body.destination.replace('cts_e2e_replace_all_objects_', '');
        expect(raoState).to.include.keys(lang);
        expect(raoState[lang]).to.deep.equal({
          copyCount: 2,
          batchCount: 10,
          waitTaskCount: 6,
          tmpIndexName: req.params.indexName,
          waitingForFinalWaitTask: false,
          successful: false,
        });

        expect(req.body.scope).to.equal(undefined);

        raoState[lang].waitingForFinalWaitTask = true;

        res.json({ taskID: 777, updatedAt: '2021-01-01T00:00:00.000Z' });

        break;
      }
      default:
        res.status(400).json({
          message: `invalid operation: ${req.body.operation}, body: ${JSON.stringify(req.body)}`,
        });
    }
  });

  app.post('/1/indexes/:indexName/batch', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_replace_all_objects_(.*)_tmp_\d+$/)?.[1] as string;
    expect(raoState).to.include.keys(lang);
    expect(req.body.requests.every((r) => r.action === 'addObject')).to.equal(true);

    raoState[lang].batchCount += req.body.requests.length;

    res.json({
      taskID: 124 + raoState[lang].batchCount,
      objectIDs: req.body.requests.map((r) => r.body.objectID),
    });
  });

  app.get('/1/indexes/:indexName/task/:taskID', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_replace_all_objects_(.*)_tmp_\d+$/)?.[1] as string;
    expect(raoState).to.include.keys(lang);

    raoState[lang].waitTaskCount++;
    if (raoState[lang].waitingForFinalWaitTask) {
      expect(req.params.taskID).to.equal('777');
      expect(raoState[lang].waitTaskCount).to.equal(7);

      raoState[lang].successful = true;
    }

    res.json({ status: 'published', updatedAt: '2021-01-01T00:00:00.000Z' });
  });
}

export function replaceAllObjectsServer(): Promise<Server> {
  // this server is used to simulate the responses for the replaceAllObjects method,
  // and uses a state machine to determine if the logic is correct.
  return setupServer('replaceAllObjects', 6679, addRoutes);
}

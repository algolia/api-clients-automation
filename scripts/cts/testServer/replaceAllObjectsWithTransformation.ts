import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const raoState: Record<
  string,
  {
    copyCount: number;
    pushCount: number;
    tmpIndexName: string;
    waitTaskCount: number;
    waitingForFinalWaitTask: boolean;
    successful: boolean;
  }
> = {};

export function assertValidReplaceAllObjectsWithTransformation(expectedCount: number): void {
  expect(Object.keys(raoState)).to.have.length(expectedCount);
  for (const lang in raoState) {
    expect(raoState[lang].successful).to.equal(true);
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
    expect(req.params.indexName).to.match(/^cts_e2e_replace_all_objects_with_transformation_(.*)$/);

    switch (req.body.operation) {
      case 'copy': {
        expect(req.params.indexName).to.not.include('tmp');
        expect(req.body.destination).to.include('tmp');
        expect(req.body.scope).to.deep.equal(['settings', 'rules', 'synonyms']);

        const lang = req.params.indexName.replace('cts_e2e_replace_all_objects_with_transformation_', '');
        if (!raoState[lang] || raoState[lang].successful) {
          raoState[lang] = {
            copyCount: 1,
            pushCount: 0,
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
        const lang = req.body.destination.replace('cts_e2e_replace_all_objects_with_transformation_', '');
        expect(raoState).to.include.keys(lang);
        expect(raoState[lang]).to.deep.equal({
          copyCount: 2,
          pushCount: 10,
          waitTaskCount: 2,
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

  app.post('/1/push/:indexName', (req, res) => {
    const lang = req.params.indexName.match(
      /^cts_e2e_replace_all_objects_with_transformation_(.*)_tmp_\d+$/,
    )?.[1] as string;
    expect(raoState).to.include.keys(lang);
    expect(req.body.action === 'addObject').to.equal(true);

    raoState[lang].pushCount += req.body.records.length;

    res.json({
      runID: 'b1b7a982-524c-40d2-bb7f-48aab075abda',
      eventID: `113b2068-6337-4c85-b5c2-e7b213d8292${raoState[lang].pushCount}`,
      message: 'OK',
      createdAt: '2022-05-12T06:24:30.049Z',
    });
  });

  app.get('/1/runs/:runID/events/:eventID', (req, res) => {
    res.json({ status: 'finished' });
  });

  app.get('/1/indexes/:indexName/task/:taskID', (req, res) => {
    const lang = req.params.indexName.match(
      /^cts_e2e_replace_all_objects_with_transformation_(.*)_tmp_\d+$/,
    )?.[1] as string;
    expect(raoState).to.include.keys(lang);

    raoState[lang].waitTaskCount++;
    if (raoState[lang].waitingForFinalWaitTask) {
      expect(req.params.taskID).to.equal('777');
      expect(raoState[lang].waitTaskCount).to.equal(3);

      raoState[lang].successful = true;
    }

    res.json({ status: 'published', updatedAt: '2021-01-01T00:00:00.000Z' });
  });
}

export function replaceAllObjectsWithTransformationServer(): Promise<Server> {
  // this server is used to simulate the responses for the replaceAllObjectsWithTransformationServer method,
  // and uses a state machine to determine if the logic is correct.
  return setupServer('replaceAllObjectsWithTransformationServer', 6690, addRoutes);
}

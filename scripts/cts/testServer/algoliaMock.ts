import type { Server } from 'http';

import express from 'express';
import type { Express } from 'express';

import { setupServer } from '.';

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

export function numberOfSuccessfulReplaceAllObjectsCalls(): number {
  return Object.values(raoState).filter((s) => s.successful).length;
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  const assert = (condition: boolean, message: string): void => {
    if (!condition) {
      throw new Error(message);
    }
  };

  app.post('/1/indexes/:indexName/operation', (req, res) => {
    assert(
      req.params.indexName.startsWith('cts_e2e_replace_all_objects_'),
      `invalid index name: ${req.params.indexName}, it should start with cts_e2e_replace_all_objects_`,
    );

    switch (req.body.operation) {
      case 'copy': {
        assert(
          !req.params.indexName.includes('tmp') && req.body.destination.includes('tmp'),
          `invalid copy operation, index name: ${req.params.indexName}`,
        );
        assert(
          req.body.scope?.length === 3,
          `invalid scope length: ${req.body.scope?.length}, expected 3`,
        );

        const lang = req.params.indexName.replace('cts_e2e_replace_all_objects_', '');
        if (!raoState[lang]) {
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
        assert(raoState[lang] !== undefined, `invalid move operation, language ${lang} not found`);
        assert(
          raoState[lang].copyCount === 2,
          `invalid copy count: ${raoState[lang].copyCount}, expected 2`,
        );
        assert(
          raoState[lang].tmpIndexName === req.params.indexName,
          `invalid tmp name, got ${req.params.indexName}, expected ${raoState[lang].tmpIndexName}`,
        );
        assert(req.body.scope === undefined, 'scope should be undefined');
        assert(
          raoState[lang].batchCount === 10,
          `invalid batch count: ${raoState[lang].batchCount}, expected 10`,
        );
        assert(
          raoState[lang].waitTaskCount === 6,
          `invalid waitTask count: ${raoState[lang].waitTaskCount}, expected 6`,
        );

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
    const lang = req.params.indexName.match(
      /cts_e2e_replace_all_objects_(.*)_tmp_\d+/,
    )?.[1] as string;
    assert(
      raoState[lang] !== undefined,
      `language ${lang} not found for index ${req.params.indexName}`,
    );
    assert(
      req.body.requests.every((r) => r.body.objectID),
      `invalid action: ${req.body.requests[0].action}, expected addObject`,
    );

    raoState[lang].batchCount += req.body.requests.length;

    res.json({
      taskID: 124 + raoState[lang].batchCount,
      objectIDs: req.body.requests.map((r) => r.body.objectID),
    });
  });

  app.get('/1/indexes/:indexName/task/:taskID', (req, res) => {
    const lang = req.params.indexName.match(
      /cts_e2e_replace_all_objects_(.*)_tmp_\d+/,
    )?.[1] as string;
    assert(
      raoState[lang] !== undefined,
      `language ${lang} not found for index ${req.params.indexName}`,
    );

    raoState[lang].waitTaskCount++;
    if (raoState[lang].waitingForFinalWaitTask) {
      assert(req.params.taskID === '777', `invalid taskID: ${req.params.taskID}, expected 777`);
      assert(
        raoState[lang].waitTaskCount === 7,
        `invalid waitTask count: ${raoState[lang].waitTaskCount}, expected 7`,
      );

      raoState[lang].successful = true;
    }

    res.json({ status: 'published', updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  // fallback route
  app.use((req, res) => {
    // eslint-disable-next-line no-console
    console.log('fallback route', req.method, req.url);
    res.status(404).json({ message: 'not found' });
  });

  app.use((err, req, res, _) => {
    // eslint-disable-next-line no-console
    console.error(err.message);
    res.status(500).send({ message: err.message });
  });
}

export function algoliaMockServer(): Promise<Server> {
  // this server is used to simulate the responses for the replaceAllObjects method,
  // and uses a state machine to determine if the logic is correct.
  return setupServer('algolia mock', 6679, addRoutes);
}

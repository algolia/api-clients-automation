import type { Server } from 'http';
import zlib from 'zlib';

import crc32 from 'crc/crc32';
import express from 'express';

import { createSpinner } from '../spinners';

let timeoutCounter = 0;

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

async function timeoutServer(): Promise<Server> {
  const spinner = createSpinner('starting timeout test server');
  const app = express();
  const port = 6677;
  app.get('/1/test/retry', (req, res) => {
    // this is safe because js is single threaded
    timeoutCounter++;
    // wait for 7.5 seconds, the default read timeout is 5 seconds + 2s of connection timeout
    setTimeout(() => {
      res.json({ message: 'timeout test server response' });
    }, 7500);
  });

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(port, () => {
      spinner.text = `timeout test server listening at http://localhost:${port}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed('timeout test server closed');
  });

  return server;
}

async function okServer(): Promise<Server> {
  const spinner = createSpinner('starting ok test server');
  const app = express();
  const port = 6678;
  app.get('/1/test/retry', (req, res) => {
    res.json({ message: 'ok test server response' });
  });

  app.post('/1/test/gzip', (req, res) => {
    let rawBody = Buffer.from([]);

    req.on('data', (data) => {
      rawBody = Buffer.concat([rawBody, data]);
    });

    req.on('error', (err) => {
      res.json({ message: `500 Internal Server Error: ${err}` });
    });

    req.on('end', () => {
      try {
        const isGzip = req.headers['content-encoding'] === 'gzip';
        if (!isGzip) {
          res.json({ message: 'content-encoding header is not gzip' });
          return;
        }

        const hasGzipMagicNumber = rawBody.subarray(0, 2).toString('hex') === '1f8b';
        if (!hasGzipMagicNumber) {
          res.json({ message: 'gzip magic number is not present' });
          return;
        }

        // Extract the stored checksum from the last 8-4 bytes of the gzip file
        const storedChecksum = rawBody.subarray(-8, -4).readUInt32LE().toString(16);

        // Extract the stored length from the last 4 bytes of the gzip file
        const storedLength = rawBody.subarray(-4).readUInt32LE().toString(16);

        // Decompress the request body
        zlib.unzip(rawBody, (err, decompressedData) => {
          if (err) {
            res.json({ message: `error decompressing request body: ${err}` });
            return;
          }

          const decompressedBody = String.fromCharCode(...decompressedData.toJSON().data);
          const decompressedJSON = JSON.parse(decompressedBody);

          // Compute checksum for the decompressed data
          const computedChecksum = crc32(decompressedBody).toString(16);

          if (computedChecksum !== storedChecksum) {
            res.json({ message: 'checksum mismatch', storedChecksum, computedChecksum });
            return;
          }

          if (decompressedBody.length !== parseInt(storedLength, 16)) {
            res.json({
              message: 'length mismatch',
              storedLength,
              decompressedLength: decompressedBody.length,
            });
            return;
          }

          if (decompressedJSON.message !== 'this is a compressed body') {
            res.json({ message: 'invalid decompressed body', body: decompressedJSON });
            return;
          }

          res.json({ message: 'ok compression test server response', body: decompressedJSON });
        });
      } catch (e) {
        res.json({ message: '500 Internal Server Error', error: e });
      }
    });
  });

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(port, () => {
      spinner.text = `ok test server listening at http://localhost:${port}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed('ok test server closed');
  });

  return server;
}

async function algoliaMockServer(): Promise<Server> {
  // this server is used to simulate the responses for the replaceAllObjects method,
  // and uses a state machine to determine if the logic is correct.
  const spinner = createSpinner('starting algolia mock server');
  const app = express();
  const port = 6679;

  app.use(express.urlencoded({ extended: true }));
  app.use(express.json());

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

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(port, () => {
      spinner.text = `algolia mock server listening at http://localhost:${port}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed('algolia mock server closed');
  });

  return server;
}

export async function startTestServer(): Promise<() => Promise<void>> {
  const servers = await Promise.all([timeoutServer(), okServer(), algoliaMockServer()]);

  return async () => {
    await Promise.all(
      servers.map(
        (server) =>
          new Promise<void>((resolve) => {
            server.close(() => resolve());
          }),
      ),
    );
  };
}

export function getTimeoutCounter(): number {
  return timeoutCounter;
}

export function numberOfSuccessfulReplaceAllObjectsCalls(): number {
  return Object.values(raoState).filter((s) => s.successful).length;
}

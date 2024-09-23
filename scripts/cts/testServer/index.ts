import type { Server } from 'http';

import express from 'express';
import type { Express } from 'express';

import { createSpinner } from '../../spinners.ts';
import type { CTSType } from '../runCts.ts';

import { apiKeyServer } from './apiKey.ts';
import { benchmarkServer } from './benchmark.ts';
import { chunkWrapperServer } from './chunkWrapper.ts';
import { gzipServer } from './gzip.ts';
import { replaceAllObjectsServer } from './replaceAllObjects.ts';
import { timeoutServer } from './timeout.ts';
import { timeoutServerBis } from './timeoutBis.ts';
import { waitForApiKeyServer } from './waitFor.ts';

export async function startTestServer(suites: Record<CTSType, boolean>): Promise<() => Promise<void>> {
  const toStart: Array<Promise<Server>> = [];
  if (suites.client) {
    toStart.push(
      timeoutServer(),
      gzipServer(),
      timeoutServerBis(),
      replaceAllObjectsServer(),
      chunkWrapperServer(),
      waitForApiKeyServer(),
      apiKeyServer(),
    );
  }
  if (suites.benchmark) {
    toStart.push(benchmarkServer());
  }
  if (toStart.length === 0) {
    return async () => {};
  }

  const servers = await Promise.all(toStart);

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

export async function setupServer(name: string, port: number, addRoutes: (app: Express) => void): Promise<Server> {
  const spinner = createSpinner(`starting ${name} test server`);
  const app = express();

  addRoutes(app);

  // 404 handler
  app.use((req, res) => {
    // eslint-disable-next-line no-console
    console.error('endpoint not implemented for', req.method, req.url);
    res.status(404).json({ message: 'not found' });
  });

  // catch all error handler
  app.use((err, _req, res, _) => {
    // eslint-disable-next-line no-console
    console.error(err.message);
    res.status(500).send({ message: err.message });
  });

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(port, () => {
      spinner.text = `${name} test server listening at http://localhost:${port}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed(`${name} test server closed`);
  });

  return server;
}

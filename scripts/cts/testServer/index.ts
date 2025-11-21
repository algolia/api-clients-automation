import type { Server } from 'http';

import type { Express } from 'express';
import express from 'express';

import { createSpinner } from '../../spinners.ts';
import type { CTSType } from '../runCts.ts';

import { expect } from 'chai';
import { accountCopyIndexServer } from './accountCopyIndex.ts';
import { algoliaMockServer } from './algoliaMock.ts';
import { apiKeyServer } from './apiKey.ts';
import { benchmarkServer } from './benchmark.ts';
import { chunkWrapperServer } from './chunkWrapper.ts';
import { errorServer, errorServerRetriedOnce, errorServerRetriedTwice, neverCalledServer } from './error.ts';
import { gzipServer } from './gzip.ts';
import { pushMockServer, pushMockServerRetriedOnce } from './pushMock.ts';
import { replaceAllObjectsServer } from './replaceAllObjects.ts';
import { replaceAllObjectsServerFailed } from './replaceAllObjectsFailed.ts';
import { replaceAllObjectsScopesServer } from './replaceAllObjectsScopes.ts';
import { replaceAllObjectsWithTransformationServer } from './replaceAllObjectsWithTransformation.ts';
import { successServer } from './success.ts';
import { timeoutServer } from './timeout.ts';
import { timeoutServerBis } from './timeoutBis.ts';
import { waitForApiKeyServer } from './waitFor.ts';

export async function startTestServer(suites: Record<CTSType, boolean>): Promise<() => Promise<void>> {
  const toStart: Array<Promise<Server>> = [];
  if (suites.client) {
    toStart.push(
      timeoutServer(),
      errorServer(),
      errorServerRetriedOnce(),
      errorServerRetriedTwice(),
      neverCalledServer(),
      successServer(),
      gzipServer(),
      timeoutServerBis(),
      accountCopyIndexServer(),
      replaceAllObjectsServer(),
      replaceAllObjectsServerFailed(),
      replaceAllObjectsScopesServer(),
      chunkWrapperServer(),
      waitForApiKeyServer(),
      apiKeyServer(),
      algoliaMockServer(),
      pushMockServer(),
      pushMockServerRetriedOnce(),
      replaceAllObjectsWithTransformationServer(),
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
  app.use((req, _) => {
    console.error(`[PORT ${port}] endpoint not implemented for`, req.method, req.url);
    expect.fail('endpoint not implemented');
  });

  // catch all error handler
  app.use((err, _req, _res, _) => {
    console.error(err.message);
    expect.fail(err.message);
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

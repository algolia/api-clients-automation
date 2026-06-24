import type { Server } from 'http';
import { readFileSync } from 'node:fs';
import path from 'node:path';

import type { Express } from 'express';
import express from 'express';

import { createSpinner } from '../../spinners.ts';
import type { CTSType } from '../runCts.ts';

import { expect } from 'chai';
import { accountCopyIndexServer } from './accountCopyIndex.ts';
import { algoliaMockServer } from './algoliaMock.ts';
import { apiKeyServer } from './apiKey.ts';
import { benchmarkServer } from './benchmark.ts';
import { chunkedPushWaitServer } from './chunkedPushWait.ts';
import { chunkWrapperServer } from './chunkWrapper.ts';
import { errorServer, errorServerRetriedOnce, errorServerRetriedTwice, neverCalledServer } from './error.ts';
import { gzipServer } from './gzip.ts';
import { gzipResponseServer } from './gzipResponse.ts';
import { noContentServer } from './noContent.ts';
import { pushMockServer, pushMockServerRetriedOnce } from './pushMock.ts';
import { replaceAllObjectsServer } from './replaceAllObjects.ts';
import { replaceAllObjectsServerFailed } from './replaceAllObjectsFailed.ts';
import { replaceAllObjectsScopesServer } from './replaceAllObjectsScopes.ts';
import { replaceAllObjectsWithTransformationServer } from './replaceAllObjectsWithTransformation.ts';
import { successServer } from './success.ts';
import { timeoutServer } from './timeout.ts';
import { timeoutServerBis } from './timeoutBis.ts';
import { waitForApiKeyServer } from './waitFor.ts';

// SYNC: CTS_PORT_OFFSET is computed by scripts/docker/setup.sh (slot × PORTS_PER_SLOT).
//       The env var is the single runtime input for port offset — inside Docker it's injected
//       by docker-compose.yml; on the host we fall back to reading .env.docker.
function getPortOffset(): number {
  const envOffset = process.env.CTS_PORT_OFFSET;
  if (envOffset) return parseInt(envOffset, 10) || 0;

  // Host-side fallback: read the pre-computed offset from .env.docker at the repo root.
  try {
    const root = path.resolve(import.meta.dirname, '../../..');
    const envDocker = readFileSync(path.join(root, '.env.docker'), 'utf8');
    const match = envDocker.match(/^CTS_PORT_OFFSET=(\d+)$/m);
    if (match) return parseInt(match[1], 10);
  } catch {}
  return 0;
}

const PORT_OFFSET = getPortOffset();

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
      gzipResponseServer(),
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
      chunkedPushWaitServer(),
      noContentServer(),
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

const SERVER_PATH_PREFIXES = ['/agent-studio'];

export async function setupServer(name: string, port: number, addRoutes: (app: Express) => void): Promise<Server> {
  const actualPort = port + PORT_OFFSET;
  const spinner = createSpinner(`starting ${name} test server`);
  const app = express();

  app.use((req, _res, next) => {
    for (const prefix of SERVER_PATH_PREFIXES) {
      if (req.url.startsWith(prefix)) {
        req.url = req.url.slice(prefix.length) || '/';
        break;
      }
    }
    next();
  });

  addRoutes(app);

  // 404 handler
  app.use((req, _) => {
    console.error(`[PORT ${actualPort}] endpoint not implemented for`, req.method, req.url);
    expect.fail('endpoint not implemented');
  });

  // catch all error handler
  app.use((err, _req, _res, _) => {
    console.error(err.message);
    expect.fail(err.message);
  });

  const server = await new Promise<Server>((resolve) => {
    const s = app.listen(actualPort, () => {
      spinner.text = `${name} test server listening at http://localhost:${actualPort}`;
      resolve(s);
    });
  });

  server.addListener('close', () => {
    spinner.succeed(`${name} test server closed`);
  });

  return server;
}

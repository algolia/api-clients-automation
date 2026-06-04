import type { Server } from 'http';
import { readFileSync } from 'node:fs';

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

// SYNC: must match scripts/docker/slot.sh PORTS_PER_SLOT and generators TestsClient.java PORTS_PER_SLOT
const PORTS_PER_SLOT = 21;

function getPortOffset(): number {
  try {
    const slot = parseInt(readFileSync('.apic-worktree-slot', 'utf8').trim(), 10);
    if (isNaN(slot)) {
      console.warn('[worktree] .apic-worktree-slot exists but contains invalid value, defaulting to slot 0');
      return 0;
    }
    return slot * PORTS_PER_SLOT;
  } catch (e: unknown) {
    if (e instanceof Error && 'code' in e && (e as NodeJS.ErrnoException).code === 'ENOENT') {
      return 0;
    }
    console.warn(`[worktree] Could not read .apic-worktree-slot: ${e instanceof Error ? e.message : e}, defaulting to slot 0`);
    return 0;
  }
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

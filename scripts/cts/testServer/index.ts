import type { Server } from 'http';

import express from 'express';
import type { Express } from 'express';

import { createSpinner } from '../../spinners';

import { algoliaMockServer } from './algoliaMock';
import { gzipServer } from './gzip';
import { timeoutServer } from './timeout';

export async function startTestServer(): Promise<() => Promise<void>> {
  const servers = await Promise.all([timeoutServer(), gzipServer(), algoliaMockServer()]);

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

export async function setupServer(
  name: string,
  port: number,
  addRoutes: (app: Express) => void,
): Promise<Server> {
  const spinner = createSpinner(`starting ${name} test server`);
  const app = express();

  addRoutes(app);

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

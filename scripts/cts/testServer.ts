import type { Server } from 'http';

import express from 'express';

import { createSpinner } from '../spinners';

let timeoutCounter = 0;

async function timeoutServer(): Promise<Server> {
  const spinner = createSpinner('starting tiemout test server');
  const app = express();
  const port = 6677;
  app.get('/1/test', (req, res) => {
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
  app.get('/1/test', (req, res) => {
    res.json({ message: 'ok test server response' });
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

export async function startTestServer(): Promise<() => Promise<void>> {
  const server1 = await timeoutServer();
  const server2 = await okServer();

  return async () => {
    await Promise.all([
      new Promise<void>((resolve) => {
        server1.close(() => {
          resolve();
        });
      }),
      new Promise<void>((resolve) => {
        server2.close(() => {
          resolve();
        });
      }),
    ]);
  };
}

export function getTimeoutCounter(): number {
  return timeoutCounter;
}

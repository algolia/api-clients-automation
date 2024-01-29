import type { Server } from 'http';

import express from 'express';

import { createSpinner } from '../spinners';

let timeoutCounter = 0;

function timeoutServer(): Server {
  const spinner = createSpinner('starting tiemout test server');
  const app = express();
  const port = 6677;
  app.get('/1/test', (req, res) => {
    timeoutCounter++;
    // wait for 3 seconds before responding
    setTimeout(() => {
      res.send({ message: 'timeout test server response' });
    }, 3000);
  });

  const server = app.listen(port, () => {
    spinner.text = `timeout test server listening at http://localhost:${port}`;
  });

  server.addListener('close', () => {
    spinner.succeed('timeout test server closed');
  });

  return server;
}

function okServer(): Server {
  const spinner = createSpinner('starting ok test server');
  const app = express();
  const port = 6678;
  app.get('/1/test', (req, res) => {
    res.send({ message: 'ok test server response' });
  });

  const server = app.listen(port, () => {
    spinner.text = `ok test server listening at http://localhost:${port}`;
  });

  server.addListener('close', () => {
    spinner.succeed('ok test server closed');
  });

  return server;
}

export function startTestServer(): () => Promise<void> {
  const server1 = timeoutServer();
  const server2 = okServer();

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

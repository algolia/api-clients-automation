import type { Server } from 'http';

import { expect } from 'chai';
import type express from 'express';

import { setupServer } from './index.ts';

const successState: Record<string, number> = {};

export function assertSuccessServerCalled(expectedCount: number): void {
  // Verify that the success server was called the expected number of times per language
  if (Object.keys(successState).length !== expectedCount) {
    throw new Error(`Expected ${expectedCount} language(s) to test the success server`);
  }

  for (const [lang, callCount] of Object.entries(successState)) {
    // python has sync and async tests, each making 2 requests
    if (lang === 'python') {
      expect(callCount).to.equal(
        4,
        `Success server was called ${callCount} times for ${lang}, expected 4 (2 sync + 2 async)`,
      );
      continue;
    }

    // Each test makes 2 consecutive requests, both should hit this server
    expect(callCount).to.equal(2, `Success server was called ${callCount} times for ${lang}, expected 2`);
  }
}

function addRoutes(app: express.Express): void {
  app.get('/1/test/calling/:lang', (req, res) => {
    const lang = req.params.lang;
    if (!successState[lang]) {
      successState[lang] = 0;
    }

    successState[lang]++;

    res.status(200).json({
      message: 'success server response',
    });
  });
}

export function successServer(): Promise<Server> {
  return setupServer('success', 6675, addRoutes);
}

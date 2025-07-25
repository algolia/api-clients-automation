import type { Server } from 'http';

import { expect } from 'chai';
import type express from 'express';

import { setupServer } from './index.ts';

const errorState: Record<string, { errorCount: number; maxError: number }> = {};

export function assertValidErrors(expectedCount: number): void {
  // assert that the retry strategy uses the correct timings, by checking the time between each request, and how long each request took before being timed out
  // there should be no delay between requests, only an increase in error.
  if (Object.keys(errorState).length !== expectedCount) {
    throw new Error(`Expected ${expectedCount} error(s)`);
  }

  for (const [lang, state] of Object.entries(errorState)) {
    // python has sync and async tests
    if (lang === 'python') {
      expect(state.errorCount).to.equal(state.maxError * 2);

      return;
    }

    expect(state.errorCount).to.equal(state.maxError);
  }
}

function addRoutes(app: express.Express): void {
  app.post('/1/test/error/:lang', (req, res) => {
    const lang = req.params.lang;
    if (!errorState[lang]) {
      errorState[lang] = {
        errorCount: 0,
        maxError: 3,
      };
    }

    errorState[lang].errorCount++;

    if (errorState[lang].errorCount % errorState[lang].maxError !== 0) {
      res.status(500).json({ message: 'error test server response' });
      return;
    }

    res.status(200).json({ status: 'ok' });
  });
}

export function errorServer(): Promise<Server> {
  return setupServer('error', 6671, addRoutes);
}

export function errorServerRetriedOnce(): Promise<Server> {
  return setupServer('errorRetriedOnce', 6672, addRoutes);
}

export function errorServerRetriedTwice(): Promise<Server> {
  return setupServer('errorRetriedTwice', 6673, addRoutes);
}

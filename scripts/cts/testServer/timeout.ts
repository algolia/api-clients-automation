import type { Server } from 'http';

import { expect } from 'chai';
import type express from 'express';

import { setupServer } from '.';

const timeoutState: Record<string, { timestamp: number[]; duration: number[] }> = {};

export function assertValidTimeouts(expectedCount: number): void {
  // assert that the retry strategy uses the correct timings, by checking the time between each request, and how long each request took before being timed out
  // there should be no delay between requests, only an increase in timeout.
  if (Object.keys(timeoutState).length !== expectedCount) {
    throw new Error(`Expected ${expectedCount} timeout(s)`);
  }

  for (const [lang, state] of Object.entries(timeoutState)) {
    expect(state.timestamp.length).to.equal(3);
    expect(state.duration.length).to.equal(3);
    expect(state.timestamp[1] - state.timestamp[0]).to.be.closeTo(state.duration[0], 100);
    expect(state.timestamp[2] - state.timestamp[1]).to.be.closeTo(state.duration[1], 100);

    // languages are not consistent yet for the delay between requests
    switch (lang) {
      case 'javascript':
        expect(state.duration[0] * 4).to.be.closeTo(state.duration[1], 200);
        break;
      case 'php':
        expect(state.duration[0] * 2).to.be.closeTo(state.duration[1], 200);
        break;
      case 'swift':
        expect(state.duration[0]).to.be.closeTo(state.duration[1], 800);
        break;
      default:
        // the delay should be the same, because the `retryCount` is per host instead of global
        expect(state.duration[0]).to.be.closeTo(state.duration[1], 100);
        break;
    }
  }
}

export function retryHandler(after: number, message: string): express.RequestHandler {
  return (req, res) => {
    const timeout = setTimeout(() => {
      res.json({ message });
    }, after);

    const lang = req.params.lang;
    const startTime = Date.now();
    if (!timeoutState[lang]) {
      timeoutState[lang] = {
        timestamp: [],
        duration: [],
      };
    }

    timeoutState[lang].timestamp.push(startTime);

    req.on('close', () => {
      const endTime = Date.now();
      const duration = endTime - startTime;
      timeoutState[lang].duration.push(duration);

      clearTimeout(timeout);
      res.end();
    });
  };
}

function addRoutes(app: express.Express): void {
  // this endpoint is also defined in the gzip server but without the timeout
  app.get('/1/test/retry/:lang', retryHandler(20000, 'timeout test server response'));

  app.get('/1/test/error/:lang', () => {
    // no response, just hang
  });
}

export function timeoutServer(): Promise<Server> {
  return setupServer('timeout', 6676, addRoutes);
}

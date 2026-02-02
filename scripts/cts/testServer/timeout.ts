import type { Server } from 'http';

import { expect } from 'chai';
import type express from 'express';

import { setupServer } from './index.ts';

const timeoutState: Record<string, { timestamp: number[]; duration: number[]; hangCount: number }> = {};

export function assertValidTimeouts(expectedCount: number): void {
  // assert that the retry strategy uses the correct timings, by checking the time between each request, and how long each request took before being timed out
  // there should be no delay between requests, only an increase in timeout.
  if (Object.keys(timeoutState).length !== expectedCount) {
    throw new Error(`Expected ${expectedCount} timeout(s)`);
  }

  for (const [lang, state] of Object.entries(timeoutState)) {
    let numberOfTestSuites = 1;

    // python has sync and async tests
    if (lang === 'python') {
      numberOfTestSuites = 2;
    }

    expect(state.hangCount).to.equal(Number(numberOfTestSuites));
    expect(state.timestamp.length).to.equal(3 * numberOfTestSuites);
    expect(state.duration.length).to.equal(3 * numberOfTestSuites);

    for (let i = 0; i < numberOfTestSuites; i++) {
      expect(state.timestamp[3 * i + 1] - state.timestamp[3 * i]).to.be.closeTo(state.duration[3 * i], 400);
      expect(state.timestamp[3 * i + 2] - state.timestamp[3 * i + 1]).to.be.closeTo(state.duration[3 * i + 1], 400);

      // languages are not consistent yet for the delay between requests
      switch (lang) {
        case 'csharp':
        case 'swift':
          // csharp and swift clocks are worse than my childhood mickey mouse watch
          expect(state.duration[3 * i]).to.be.closeTo(state.duration[3 * i + 1], 1500);
          break;
        case 'javascript':
          expect(state.duration[3 * i] * 4).to.be.closeTo(state.duration[3 * i + 1], 300);
          break;
        default:
          // the delay should be the same, because the `retryCount` is per host instead of global
          expect(state.duration[3 * i]).to.be.closeTo(state.duration[3 * i + 1], 300);
          break;
      }
    }
  }
}

export function retryHandler(after: number, message: string): express.RequestHandler {
  return (req, res) => {
    const timeout = setTimeout(() => {
      res.json({ message });
    }, after);

    const lang = req.params.lang as string;
    const startTime = Date.now();
    if (!timeoutState[lang]) {
      timeoutState[lang] = {
        timestamp: [],
        duration: [],
        hangCount: 0,
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

  app.get('/1/test/hang/:lang', (req) => {
    const lang = req.params.lang;
    if (!timeoutState[lang]) {
      timeoutState[lang] = {
        timestamp: [],
        duration: [],
        hangCount: 0,
      };
    }

    timeoutState[lang].hangCount++;

    // no response, just hang
  });

  app.get('/1/html-error', (req, res) => {
    res.setHeader('Content-Type', 'text/html');
    res.status(429).send('<html><body>429 Too Many Requests</body></html>');
  });

  app.get('/1/long-wait', (req, res) => {
    setTimeout(() => {
      res.json({ message: 'OK' });
    }, 8000);
  });

  app.get('/1/test/instant', (req, res) => {
    res.json({ success: true });
  });
}

export function timeoutServer(): Promise<Server> {
  return setupServer('timeout', 6676, addRoutes);
}

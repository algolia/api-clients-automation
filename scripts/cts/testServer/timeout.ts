import type { Server } from 'http';

import type express from 'express';

import { setupServer } from '.';

const timeoutState: Record<string, { timestamp: number[]; duration: number[] }> = {};

export function assertValidTimeouts(expectedCount: number): void {
  // assert that the retry strategy uses the correct timings, by checking the time between each request, and how long each request took before being timeouted
  // there should be no delay between requests, only an increase in timeout.
  if (Object.keys(timeoutState).length !== expectedCount) {
    throw new Error(`Expected ${expectedCount} timeout(s)`);
  }

  for (const [lang, state] of Object.entries(timeoutState)) {
    if (state.timestamp.length !== 3 || state.duration.length !== 3) {
      throw new Error(`Expected 3 requests for ${lang}, got ${state.timestamp.length}`);
    }

    let delay = state.timestamp[1] - state.timestamp[0];
    if (Math.abs(delay - state.duration[0]) > 100) {
      throw new Error(`Expected no delay between requests for ${lang}, got ${delay}ms`);
    }

    delay = state.timestamp[2] - state.timestamp[1];
    if (Math.abs(delay - state.duration[1]) > 100) {
      throw new Error(`Expected no delay between requests for ${lang}, got ${delay}ms`);
    }

    // for languages other than JS, the delay should be the same, because the `retryCount` is per host instead of global
    if (lang !== 'JavaScript') {
      if (Math.abs(state.duration[0] - state.duration[1]) > 100) {
        throw new Error(
          `Expected the same delay between requests for ${lang}, got ${state.duration[0]}ms and ${state.duration[1]}ms`,
        );
      }
    } else if (Math.abs(state.duration[0] * 4 - state.duration[1]) > 200) {
      throw new Error(
        `Expected increasing delay between requests for ${lang}, got ${state.duration[0]}ms and ${state.duration[1]}ms`,
      );
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
}

export function timeoutServer(): Promise<Server> {
  return setupServer('timeout', 6677, addRoutes);
}

import type { Server } from 'http';

import { expect } from 'chai';
import type express from 'express';

import { setupServer } from './index.ts';

type LangState = {
  retryAfterCalls: number;
  retryAfterTimestamps: number[];
  missingHeaderCalls: number;
  missingHeaderTimestamps: number[];
  invalidHeaderCalls: number;
  invalidHeaderTimestamps: number[];
  exhaustedCalls: number;
  zeroRetriesCalls: number;
};

const state: Record<string, LangState> = {};
const neverCalledState: Record<string, number> = {};

function langState(lang: string): LangState {
  if (!state[lang]) {
    state[lang] = {
      retryAfterCalls: 0,
      retryAfterTimestamps: [],
      missingHeaderCalls: 0,
      missingHeaderTimestamps: [],
      invalidHeaderCalls: 0,
      invalidHeaderTimestamps: [],
      exhaustedCalls: 0,
      zeroRetriesCalls: 0,
    };
  }
  return state[lang];
}

function assertDelay(timestamps: number[], expectedMs: number): void {
  expect(timestamps.length).to.be.at.least(2);

  for (let i = 0; i + 1 < timestamps.length; i += 2) {
    expect(timestamps[i + 1] - timestamps[i]).to.be.closeTo(expectedMs, 400);
  }
}

// Languages that implement 429 wait-and-retry. Append yours when the port lands.
const RATE_LIMIT_LANGUAGES = ['javascript', 'php'];

// Languages whose client CTS suite is emitted more than once, so every mock
// route is hit once per mode (python: async + sync, see TestsClient's `withSyncTests`).
const DOUBLE_RUN_LANGUAGES = ['python'];

export function rateLimitRuns(languages: string[]): Record<string, number> {
  return Object.fromEntries(
    languages
      .filter((lang) => RATE_LIMIT_LANGUAGES.includes(lang))
      .map((lang) => [lang, DOUBLE_RUN_LANGUAGES.includes(lang) ? 2 : 1]),
  );
}

export function assertValidRateLimitRetries(runs: Record<string, number>): void {
  if (Object.keys(runs).length > 0) {
    expect(Object.keys(state).length, 'rate-limit mock was never hit').to.be.at.least(1);
  }

  for (const [lang, langState] of Object.entries(state)) {
    const runCount = runs[lang] ?? 1;

    // 2s proves Retry-After was parsed: the fallback wait for a missing header is 1s.
    expect(langState.retryAfterCalls, `${lang} retry-after calls`).to.equal(2 * runCount);
    assertDelay(langState.retryAfterTimestamps, 2000);

    expect(langState.missingHeaderCalls, `${lang} missing-header calls`).to.equal(2 * runCount);
    assertDelay(langState.missingHeaderTimestamps, 1000);

    expect(langState.invalidHeaderCalls, `${lang} invalid-header calls`).to.equal(2 * runCount);
    assertDelay(langState.invalidHeaderTimestamps, 1000);

    expect(langState.exhaustedCalls, `${lang} exhausted calls`).to.equal(4 * runCount);
    expect(langState.zeroRetriesCalls, `${lang} zero-retries calls`).to.equal(1 * runCount);
  }

  for (const [lang, callCount] of Object.entries(neverCalledState)) {
    expect(callCount).to.equal(0, `rate-limit never-called host was hit ${callCount} times for ${lang}`);
  }
}

function addRoutes(app: express.Express): void {
  app.get('/1/test/rate-limit/retry-after/:lang', (req, res) => {
    const current = langState(req.params.lang);
    current.retryAfterCalls++;
    current.retryAfterTimestamps.push(Date.now());

    if (current.retryAfterCalls % 2 === 1) {
      res.setHeader('Retry-After', '2');
      res.status(429).json({ message: 'Too many requests' });
      return;
    }

    res.status(200).json({ message: 'ok rate limit retry' });
  });

  app.get('/1/test/rate-limit/missing-header/:lang', (req, res) => {
    const current = langState(req.params.lang);
    current.missingHeaderCalls++;
    current.missingHeaderTimestamps.push(Date.now());

    if (current.missingHeaderCalls % 2 === 1) {
      res.status(429).json({ message: 'Too many requests' });
      return;
    }

    res.status(200).json({ message: 'ok rate limit retry' });
  });

  app.get('/1/test/rate-limit/invalid-header/:lang', (req, res) => {
    const current = langState(req.params.lang);
    current.invalidHeaderCalls++;
    current.invalidHeaderTimestamps.push(Date.now());

    if (current.invalidHeaderCalls % 2 === 1) {
      res.setHeader('Retry-After', '0');
      res.status(429).json({ message: 'Too many requests' });
      return;
    }

    res.status(200).json({ message: 'ok rate limit retry' });
  });

  app.get('/1/test/rate-limit/exhausted/:lang', (req, res) => {
    langState(req.params.lang).exhaustedCalls++;
    res.setHeader('Retry-After', '1');
    res.status(429).json({ message: 'Too many requests' });
  });

  app.get('/1/test/rate-limit/zero-retries/:lang', (req, res) => {
    langState(req.params.lang).zeroRetriesCalls++;
    res.setHeader('Retry-After', '1');
    res.status(429).json({ message: 'Too many requests' });
  });
}

function addNeverCalledRoutes(app: express.Express): void {
  app.use((req, res) => {
    const lang = typeof req.params.lang === 'string' ? req.params.lang : req.path;
    neverCalledState[lang] = (neverCalledState[lang] ?? 0) + 1;
    res.status(200).json({ message: 'should never be called' });
  });
}

export function rateLimitServer(): Promise<Server> {
  return setupServer('rateLimit', 6697, addRoutes);
}

export function rateLimitNeverCalledServer(): Promise<Server> {
  return setupServer('rateLimitNeverCalled', 6698, addNeverCalledRoutes);
}

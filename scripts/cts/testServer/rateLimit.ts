import type { Server } from 'http';

import { expect } from 'chai';
import type express from 'express';

import { setupServer } from './index.ts';

type LangState = {
  retryAfterCalls: number;
  retryAfterTimestamps: number[];
  missingHeaderCalls: number;
  missingHeaderTimestamps: number[];
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
      exhaustedCalls: 0,
      zeroRetriesCalls: 0,
    };
  }
  return state[lang];
}

function assertDelay(timestamps: number[], expectedMs: number): void {
  expect(timestamps.length).to.be.at.least(2);
  expect(timestamps[1] - timestamps[0]).to.be.closeTo(expectedMs, 400);
}

export function assertValidRateLimitRetries(implemented: boolean): void {
  // Languages that wait on 429 (JS, Go, Swift, C#) must actually hit the mock.
  if (implemented) {
    expect(Object.keys(state).length, 'rate-limit mock was never hit').to.be.at.least(1);
  }

  for (const [lang, langState] of Object.entries(state)) {
    // 2s proves Retry-After was parsed: the fallback wait for a missing header is 1s.
    expect(langState.retryAfterCalls, `${lang} retry-after calls`).to.equal(2);
    assertDelay(langState.retryAfterTimestamps, 2000);

    expect(langState.missingHeaderCalls, `${lang} missing-header calls`).to.equal(2);
    assertDelay(langState.missingHeaderTimestamps, 1000);

    expect(langState.exhaustedCalls, `${lang} exhausted calls`).to.equal(4);
    expect(langState.zeroRetriesCalls, `${lang} zero-retries calls`).to.equal(1);
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

    if (current.retryAfterCalls === 1) {
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

    if (current.missingHeaderCalls === 1) {
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

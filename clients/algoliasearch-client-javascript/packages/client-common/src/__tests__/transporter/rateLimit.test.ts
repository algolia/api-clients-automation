import { afterEach, beforeEach, describe, expect, test, vi } from 'vitest';

import { createNullCache } from '../../cache';
import { createNullLogger } from '../../logger';
import { createTransporter } from '../../transporter';
import { isRateLimited, parseRetryAfterMs } from '../../transporter/responses';
import type { AlgoliaAgent, Host, Response } from '../../types';

const algoliaAgent: AlgoliaAgent = {
  value: 'test',
  add: () => algoliaAgent,
};

function host(url: string): Host {
  return { url, accept: 'readWrite', protocol: 'http' };
}

function json(status: number, body: unknown, headers?: Record<string, string>): Response {
  return {
    status,
    content: JSON.stringify(body),
    isTimedOut: false,
    headers,
  };
}

function makeTransporter(
  send: (url: string) => Promise<Response> | Response,
  options: { maxRateLimitRetries?: number } = {},
) {
  return createTransporter({
    hosts: [host('host-a.example'), host('host-b.example')],
    hostsCache: createNullCache(),
    baseHeaders: {},
    baseQueryParameters: {},
    algoliaAgent,
    logger: createNullLogger(),
    timeouts: { connect: 1000, read: 2000, write: 3000 },
    requester: {
      send: async (request) => send(request.url),
    },
    requestsCache: createNullCache(),
    responsesCache: createNullCache(),
    ...options,
  });
}

const request = { method: 'GET' as const, path: '/1/test', queryParameters: {}, headers: {} };

describe('parseRetryAfterMs', () => {
  test('honors a positive integer number of seconds', () => {
    expect(parseRetryAfterMs({ 'retry-after': '2' })).toBe(2000);
  });

  test('falls back to 1s when missing, 0, HTTP-date, or junk', () => {
    expect(parseRetryAfterMs(undefined)).toBe(1000);
    expect(parseRetryAfterMs({})).toBe(1000);
    expect(parseRetryAfterMs({ 'retry-after': '0' })).toBe(1000);
    expect(parseRetryAfterMs({ 'retry-after': '' })).toBe(1000);
    expect(parseRetryAfterMs({ 'retry-after': '120abc' })).toBe(1000);
    expect(parseRetryAfterMs({ 'retry-after': 'Wed, 21 Oct 2015 07:28:00 GMT' })).toBe(1000);
  });
});

describe('isRateLimited', () => {
  test('is only 429', () => {
    expect(isRateLimited({ status: 429 })).toBe(true);
    expect(isRateLimited({ status: 400 })).toBe(false);
    expect(isRateLimited({ status: 500 })).toBe(false);
  });
});

describe('transporter rate-limit retries', () => {
  beforeEach(() => {
    vi.useFakeTimers();
  });

  afterEach(() => {
    vi.useRealTimers();
  });

  test('waits Retry-After then succeeds on the same host', async () => {
    const calls: string[] = [];
    const transporter = makeTransporter((url) => {
      calls.push(url);
      if (calls.length === 1) {
        return json(429, { message: 'Too many requests' }, { 'retry-after': '2' });
      }
      return json(200, { message: 'ok' });
    });

    const pending = transporter.request<{ message: string }>(request);
    await vi.advanceTimersByTimeAsync(2000);
    await expect(pending).resolves.toEqual({ message: 'ok' });
    expect(calls).toHaveLength(2);
    expect(calls.every((url) => url.includes('host-a.example'))).toBe(true);
  });

  test('missing Retry-After waits 1s', async () => {
    const calls: number[] = [];
    const transporter = makeTransporter(() => {
      calls.push(Date.now());
      if (calls.length === 1) {
        return json(429, { message: 'Too many requests' });
      }
      return json(200, { message: 'ok' });
    });

    const pending = transporter.request(request);
    await vi.advanceTimersByTimeAsync(1000);
    await expect(pending).resolves.toEqual({ message: 'ok' });
    expect(calls).toHaveLength(2);
  });

  test('maxRateLimitRetries 0 fails on the first 429', async () => {
    let calls = 0;
    const transporter = makeTransporter(
      () => {
        calls++;
        return json(429, { message: 'Too many requests' }, { 'retry-after': '1' });
      },
      { maxRateLimitRetries: 0 },
    );

    await expect(transporter.request(request)).rejects.toMatchObject({
      name: 'ApiError',
      status: 429,
      message: 'Too many requests',
    });
    expect(calls).toBe(1);
  });

  test('exhausts maxRateLimitRetries then returns the 429', async () => {
    let calls = 0;
    const transporter = makeTransporter(() => {
      calls++;
      return json(429, { message: 'Too many requests' }, { 'retry-after': '1' });
    });

    const pending = transporter.request(request);

    for (let i = 0; i < 3; i++) {
      await vi.advanceTimersByTimeAsync(1000);
    }

    await expect(pending).rejects.toMatchObject({ name: 'ApiError', status: 429 });
    expect(calls).toBe(4);
  });

  test('does not fail over to another host on 429', async () => {
    const calls: string[] = [];
    const transporter = makeTransporter((url) => {
      calls.push(url);
      if (calls.length === 1) {
        return json(429, { message: 'Too many requests' }, { 'retry-after': '1' });
      }
      return json(200, { message: 'ok' });
    });

    const pending = transporter.request(request);
    await vi.advanceTimersByTimeAsync(1000);
    await pending;
    expect(calls.filter((url) => url.includes('host-b.example'))).toHaveLength(0);
  });

  test('still fails over to the next host on 5xx', async () => {
    const calls: string[] = [];
    const transporter = makeTransporter((url) => {
      calls.push(url);
      if (url.includes('host-a.example')) {
        return json(500, { message: 'error' });
      }
      return json(200, { message: 'ok' });
    });

    await expect(transporter.request(request)).resolves.toEqual({ message: 'ok' });
    expect(calls.some((url) => url.includes('host-a.example'))).toBe(true);
    expect(calls.some((url) => url.includes('host-b.example'))).toBe(true);
  });
});

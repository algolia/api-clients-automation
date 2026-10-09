import { describe, expect, test } from 'vitest';

import { stackFrameWithoutCredentials, stackTraceWithoutCredentials } from '../transporter';
import type { Host, Response, StackFrame } from '../types';

const CREDENTIAL_MASK = '*****';

const host: Host = { url: 'foo-dsn.algolia.net', accept: 'readWrite', protocol: 'https' };

const response: Response = {
  content: '{"message":"timeout"}',
  isTimedOut: true,
  status: 0,
  headers: { 'x-algolia-correlation-id': 'cid-1' },
};

function makeFrame(overrides: Partial<StackFrame['request']> = {}): StackFrame {
  return {
    request: {
      method: 'POST',
      url: 'https://foo-dsn.algolia.net/1/indexes/bar/query',
      connectTimeout: 2000,
      responseTimeout: 5000,
      headers: {
        'x-algolia-application-id': 'APPID',
        'content-type': 'application/json',
      },
      data: '{"query":"shoes"}',
      ...overrides,
    },
    response,
    host,
    triesLeft: 2,
  };
}

describe('stackFrameWithoutCredentials', () => {
  test('masks the x-algolia-api-key header', () => {
    const frame = makeFrame({
      headers: {
        'x-algolia-application-id': 'APPID',
        'x-algolia-api-key': 'SECRET_KEY',
        'content-type': 'application/json',
      },
    });

    expect(stackFrameWithoutCredentials(frame).request.headers['x-algolia-api-key']).toBe(CREDENTIAL_MASK);
  });

  test('masks apiKey in a string JSON body', () => {
    const frame = makeFrame({
      data: JSON.stringify({ query: 'shoes', apiKey: 'SECRET_KEY' }),
    });

    const data = stackFrameWithoutCredentials(frame).request.data;

    expect(typeof data).toBe('string');
    expect(JSON.parse(data as string)).toEqual({ query: 'shoes', apiKey: CREDENTIAL_MASK });
  });

  test('masks x-algolia-api-key in the request URL', () => {
    const frame = makeFrame({
      url: 'https://foo-dsn.algolia.net/1/indexes/bar/query?x-algolia-api-key=SECRET_KEY&query=shoes',
    });

    expect(stackFrameWithoutCredentials(frame).request.url).toBe(
      `https://foo-dsn.algolia.net/1/indexes/bar/query?x-algolia-api-key=${CREDENTIAL_MASK}&query=shoes`,
    );
  });

  test('leaves a gzip Uint8Array body untouched', () => {
    const gzipBody = new Uint8Array([0x1f, 0x8b, 0x08, 0x00, 0x61, 0x70, 0x69, 0x4b, 0x65, 0x79]);
    const frame = makeFrame({ data: gzipBody });

    expect(stackFrameWithoutCredentials(frame).request.data).toBe(gzipBody);
  });

  test('leaves the rest of the frame unchanged', () => {
    const frame = makeFrame({
      headers: {
        'x-algolia-application-id': 'APPID',
        'x-algolia-api-key': 'SECRET_KEY',
        'content-type': 'application/json',
      },
      url: 'https://foo-dsn.algolia.net/1/indexes/bar/query?x-algolia-api-key=SECRET_KEY&foo=bar',
      data: JSON.stringify({ query: 'shoes', apiKey: 'SECRET_KEY' }),
    });

    const redacted = stackFrameWithoutCredentials(frame);

    expect(redacted.host).toBe(host);
    expect(redacted.response).toBe(response);
    expect(redacted.triesLeft).toBe(2);
    expect(redacted.request.method).toBe('POST');
    expect(redacted.request.connectTimeout).toBe(2000);
    expect(redacted.request.responseTimeout).toBe(5000);
    expect(redacted.request.headers['x-algolia-application-id']).toBe('APPID');
    expect(redacted.request.headers['content-type']).toBe('application/json');
    expect(redacted.request.url).toContain('foo=bar');
    expect(JSON.parse(redacted.request.data as string).query).toBe('shoes');
  });

  test('leaves an invalid JSON string body as-is', () => {
    const invalid = '{not-json';
    const frame = makeFrame({ data: invalid });

    expect(stackFrameWithoutCredentials(frame).request.data).toBe(invalid);
  });
});

describe('stackTraceWithoutCredentials', () => {
  test('redacts every frame', () => {
    const frames = [
      makeFrame({
        headers: { 'x-algolia-api-key': 'SECRET_A' },
      }),
      makeFrame({
        url: 'https://foo-dsn.algolia.net/1/indexes/*/queries?x-algolia-api-key=SECRET_B',
      }),
    ];

    const redacted = stackTraceWithoutCredentials(frames);

    expect(redacted).toHaveLength(2);
    expect(redacted[0].request.headers['x-algolia-api-key']).toBe(CREDENTIAL_MASK);
    expect(redacted[1].request.url).toBe(
      `https://foo-dsn.algolia.net/1/indexes/*/queries?x-algolia-api-key=${CREDENTIAL_MASK}`,
    );
  });
});

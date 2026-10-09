import { describe, expect, test } from 'vitest';

import { createAuth } from '../createAuth';

const appId = 'app-id';
const apiKey = 'api-key';

const credentials = {
  'x-algolia-api-key': apiKey,
  'x-algolia-application-id': appId,
};

describe('createAuth', () => {
  test('defaults to WithinHeaders when authMode is omitted', () => {
    const auth = createAuth(appId, apiKey);

    expect(auth.headers()).toEqual(credentials);
    expect(auth.queryParameters()).toEqual({});
    expect(auth.bodyParameters()).toEqual({});
  });

  test('WithinHeaders puts credentials in headers only', () => {
    const auth = createAuth(appId, apiKey, 'WithinHeaders');

    expect(auth.headers()).toEqual(credentials);
    expect(auth.queryParameters()).toEqual({});
    expect(auth.bodyParameters()).toEqual({});
  });

  test('WithinQueryParameters puts credentials in query parameters only', () => {
    const auth = createAuth(appId, apiKey, 'WithinQueryParameters');

    expect(auth.headers()).toEqual({});
    expect(auth.queryParameters()).toEqual(credentials);
    expect(auth.bodyParameters()).toEqual({});
  });

  test('WithinBody puts apiKey in the body and application-id in query parameters', () => {
    const auth = createAuth(appId, apiKey, 'WithinBody');

    expect(auth.headers()).toEqual({});
    expect(auth.queryParameters()).toEqual({
      'x-algolia-application-id': appId,
    });
    expect(auth.bodyParameters()).toEqual({ apiKey });
  });
});

import type { AuthMode, Headers, QueryParameters } from './types';

export function createAuth(
  appId: string,
  apiKey: string,
  authMode: AuthMode = 'WithinHeaders',
): {
  readonly headers: () => Headers;
  readonly queryParameters: () => QueryParameters;
  readonly bodyParameters: () => Headers;
} {
  const credentials = {
    'x-algolia-api-key': apiKey,
    'x-algolia-application-id': appId,
  };

  return {
    headers(): Headers {
      return authMode === 'WithinHeaders' ? credentials : {};
    },

    queryParameters(): QueryParameters {
      if (authMode === 'WithinQueryParameters') {
        return credentials;
      }

      if (authMode === 'WithinBody') {
        return { 'x-algolia-application-id': appId };
      }

      return {};
    },

    bodyParameters(): Headers {
      return authMode === 'WithinBody' ? { apiKey } : {};
    },
  };
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { ClientOptions } from '@algolia/client-common';
import {
  createMemoryCache,
  createFallbackableCache,
  createBrowserLocalStorageCache,
  DEFAULT_CONNECT_TIMEOUT_BROWSER,
  DEFAULT_READ_TIMEOUT_BROWSER,
  DEFAULT_WRITE_TIMEOUT_BROWSER,
} from '@algolia/client-common';
import { createXhrRequester } from '@algolia/requester-browser-xhr';

import { createUsageClient, apiClientVersion } from '../src/usageClient';

export type UsageClient = ReturnType<typeof createUsageClient>;

export { apiClientVersion } from '../src/usageClient';
export * from '../model';

export function usageClient(appId: string, apiKey: string, options?: ClientOptions): UsageClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  return createUsageClient({
    appId,
    apiKey,
    timeouts: {
      connect: DEFAULT_CONNECT_TIMEOUT_BROWSER,
      read: DEFAULT_READ_TIMEOUT_BROWSER,
      write: DEFAULT_WRITE_TIMEOUT_BROWSER,
    },
    requester: createXhrRequester(),
    algoliaAgents: [{ segment: 'Browser' }],
    authMode: 'WithinQueryParameters',
    responsesCache: createMemoryCache(),
    requestsCache: createMemoryCache({ serializable: false }),
    hostsCache: createFallbackableCache({
      caches: [createBrowserLocalStorageCache({ key: `${apiClientVersion}-${appId}` }), createMemoryCache()],
    }),
    ...options,
  });
}

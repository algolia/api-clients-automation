// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import { createXhrRequester } from '@algolia/requester-browser-xhr';

import {
  createBrowserLocalStorageCache,
  createFallbackableCache,
  createMemoryCache,
  createNullLogger,
} from '@algolia/client-common';

import type { ClientOptions } from '@algolia/client-common';

import { apiClientVersion, createInsightsClient } from '../src/insightsClient';

import type { Region } from '../src/insightsClient';
import { REGIONS } from '../src/insightsClient';

export type { Region, RegionOptions } from '../src/insightsClient';

export { apiClientVersion } from '../src/insightsClient';

export * from '../model';

export function insightsClient(
  appId: string,
  apiKey: string,
  region?: Region | undefined,
  options?: ClientOptions | undefined,
): InsightsClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  if (region && (typeof region !== 'string' || !REGIONS.includes(region))) {
    throw new Error(`\`region\` must be one of the following: ${REGIONS.join(', ')}`);
  }

  return createInsightsClient({
    appId,
    apiKey,
    region,
    timeouts: {
      connect: 1000,
      read: 2000,
      write: 30000,
    },
    logger: createNullLogger(),
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

export type InsightsClient = ReturnType<typeof createInsightsClient>;

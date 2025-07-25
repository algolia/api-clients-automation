// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import { createXhrRequester } from '@algolia/requester-browser-xhr';

import {
  createBrowserLocalStorageCache,
  createFallbackableCache,
  createMemoryCache,
  createNullLogger,
} from '@algolia/client-common';

import type { ClientOptions } from '@algolia/client-common';

import { apiClientVersion, createIngestionClient } from '../src/ingestionClient';

import type { Region } from '../src/ingestionClient';
import { REGIONS } from '../src/ingestionClient';

export type { Region, RegionOptions } from '../src/ingestionClient';

export { apiClientVersion, isOnDemandTrigger, isScheduleTrigger, isSubscriptionTrigger } from '../src/ingestionClient';

export * from '../model';

export function ingestionClient(
  appId: string,
  apiKey: string,
  region: Region,
  options?: ClientOptions | undefined,
): IngestionClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  if (!region || (region && (typeof region !== 'string' || !REGIONS.includes(region)))) {
    throw new Error(`\`region\` is required and must be one of the following: ${REGIONS.join(', ')}`);
  }

  return createIngestionClient({
    appId,
    apiKey,
    region,
    timeouts: {
      connect: 25000,
      read: 25000,
      write: 25000,
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

export type IngestionClient = ReturnType<typeof createIngestionClient>;

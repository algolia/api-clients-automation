// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import { createXhrRequester } from '@algolia/requester-browser-xhr';

import {
  createBrowserLocalStorageCache,
  createFallbackableCache,
  createMemoryCache,
  createNullLogger,
} from '@algolia/client-common';

import type { ClientOptions } from '@algolia/client-common';

import { apiClientVersion, createAbtestingClient } from '../src/abtestingClient';

import type { Region } from '../src/abtestingClient';
import { REGIONS } from '../src/abtestingClient';

export type { Region, RegionOptions } from '../src/abtestingClient';

export { apiClientVersion } from '../src/abtestingClient';

export * from '../model';

export function abtestingClient(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: ClientOptions,
): AbtestingClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  if (region && (typeof region !== 'string' || !REGIONS.includes(region))) {
    throw new Error(`\`region\` must be one of the following: ${REGIONS.join(', ')}`);
  }

  return createAbtestingClient({
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

export type AbtestingClient = ReturnType<typeof createAbtestingClient>;

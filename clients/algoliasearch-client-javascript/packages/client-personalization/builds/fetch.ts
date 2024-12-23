// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type PersonalizationClient = ReturnType<typeof createPersonalizationClient>;

import { createMemoryCache, createNullCache, createNullLogger } from '@algolia/client-common';
import { createFetchRequester } from '@algolia/requester-fetch';

import type { ClientOptions } from '@algolia/client-common';

import { createPersonalizationClient } from '../src/personalizationClient';

import type { Region } from '../src/personalizationClient';
import { REGIONS } from '../src/personalizationClient';

export type { Region, RegionOptions } from '../src/personalizationClient';

export { apiClientVersion } from '../src/personalizationClient';

export * from '../model';

export function personalizationClient(
  appId: string,
  apiKey: string,
  region: Region,
  options?: ClientOptions,
): PersonalizationClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  if (!region || (region && (typeof region !== 'string' || !REGIONS.includes(region)))) {
    throw new Error(`\`region\` is required and must be one of the following: ${REGIONS.join(', ')}`);
  }

  return {
    ...createPersonalizationClient({
      appId,
      apiKey,
      region,
      timeouts: {
        connect: 2000,
        read: 5000,
        write: 30000,
      },
      logger: createNullLogger(),
      requester: createFetchRequester(),
      algoliaAgents: [{ segment: 'Fetch' }],
      responsesCache: createNullCache(),
      requestsCache: createNullCache(),
      hostsCache: createMemoryCache(),
      ...options,
    }),
  };
}

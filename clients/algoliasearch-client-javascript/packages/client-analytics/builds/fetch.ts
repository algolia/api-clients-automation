// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type AnalyticsClient = ReturnType<typeof createAnalyticsClient>;

import { createMemoryCache, createNullCache, createNullLogger } from '@algolia/client-common';
import { createFetchRequester } from '@algolia/requester-fetch';

import type { ClientOptions } from '@algolia/client-common';

import { createAnalyticsClient } from '../src/analyticsClient';

import type { Region } from '../src/analyticsClient';
import { REGIONS } from '../src/analyticsClient';

export type { Region, RegionOptions } from '../src/analyticsClient';

export { apiClientVersion } from '../src/analyticsClient';

export * from '../model';

export function analyticsClient(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: ClientOptions,
): AnalyticsClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  if (region && (typeof region !== 'string' || !REGIONS.includes(region))) {
    throw new Error(`\`region\` must be one of the following: ${REGIONS.join(', ')}`);
  }

  return {
    ...createAnalyticsClient({
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

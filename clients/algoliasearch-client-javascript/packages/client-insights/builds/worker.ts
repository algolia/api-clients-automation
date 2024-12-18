// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type InsightsClient = ReturnType<typeof createInsightsClient>;

import { createMemoryCache, createNullCache, createNullLogger } from '@algolia/client-common';
import { createFetchRequester } from '@algolia/requester-fetch';

import type { ClientOptions } from '@algolia/client-common';

import { createInsightsClient } from '../src/insightsClient';

import type { Region } from '../src/insightsClient';
import { REGIONS } from '../src/insightsClient';

export type { Region, RegionOptions } from '../src/insightsClient';

export { apiClientVersion } from '../src/insightsClient';

export * from '../model';

export function insightsClient(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: ClientOptions,
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

  return {
    ...createInsightsClient({
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
      algoliaAgents: [{ segment: 'Worker' }],
      responsesCache: createNullCache(),
      requestsCache: createNullCache(),
      hostsCache: createMemoryCache(),
      ...options,
    }),
  };
}
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type MonitoringClient = ReturnType<typeof createMonitoringClient>;

import { createMemoryCache, createNullCache, createNullLogger } from '@algolia/client-common';
import { createFetchRequester } from '@algolia/requester-fetch';

import type { ClientOptions } from '@algolia/client-common';

import { createMonitoringClient } from '../src/monitoringClient';

export { apiClientVersion } from '../src/monitoringClient';

export * from '../model';

export function monitoringClient(appId: string, apiKey: string, options?: ClientOptions): MonitoringClient {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  return {
    ...createMonitoringClient({
      appId,
      apiKey,
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

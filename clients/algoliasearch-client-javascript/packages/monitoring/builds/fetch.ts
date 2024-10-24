// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type MonitoringClient = ReturnType<typeof createMonitoringClient>;

import {
  createMemoryCache,
  createNullCache,
  createNullLogger,
  DEFAULT_CONNECT_TIMEOUT_NODE,
  DEFAULT_READ_TIMEOUT_NODE,
  DEFAULT_WRITE_TIMEOUT_NODE,
} from '@algolia/client-common';
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
        connect: DEFAULT_CONNECT_TIMEOUT_NODE,
        read: DEFAULT_READ_TIMEOUT_NODE,
        write: DEFAULT_WRITE_TIMEOUT_NODE,
      },
      logger: createNullLogger(),
      algoliaAgents: [{ segment: 'Fetch' }],
      requester: createFetchRequester(),
      responsesCache: createNullCache(),
      requestsCache: createNullCache(),
      hostsCache: createMemoryCache(),
      ...options,
    }),
  };
}

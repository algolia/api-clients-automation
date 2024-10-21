// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type AbtestingClient = ReturnType<typeof createAbtestingClient>;

import { createHttpRequester } from '@algolia/requester-node-http';

import {
  ClientOptions,
  createMemoryCache,
  createNullCache,
  createNullLogger,
  DEFAULT_CONNECT_TIMEOUT_NODE,
  DEFAULT_READ_TIMEOUT_NODE,
  DEFAULT_WRITE_TIMEOUT_NODE,
} from '@algolia/client-common';

import { createAbtestingClient } from '../src/abtestingClient';

import { Region, REGIONS } from '../src/abtestingClient';

export * from '../model';
export { apiClientVersion, Region, RegionOptions } from '../src/abtestingClient';

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

  return {
    ...createAbtestingClient({
      appId,
      apiKey,
      region,
      timeouts: {
        connect: DEFAULT_CONNECT_TIMEOUT_NODE,
        read: DEFAULT_READ_TIMEOUT_NODE,
        write: DEFAULT_WRITE_TIMEOUT_NODE,
      },
      logger: createNullLogger(),
      requester: createHttpRequester(),
      algoliaAgents: [{ segment: 'Node.js', version: process.versions.node }],
      responsesCache: createNullCache(),
      requestsCache: createNullCache(),
      hostsCache: createMemoryCache(),
      ...options,
    }),
  };
}

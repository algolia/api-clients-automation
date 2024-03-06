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

import type { Region } from '../src/analyticsClient';
import {
  createAnalyticsClient,
  apiClientVersion,
  REGIONS,
} from '../src/analyticsClient';

export { apiClientVersion, Region } from '../src/analyticsClient';
export * from '../model';

/**
 * The client type.
 */
export type AnalyticsClient = ReturnType<typeof analyticsClient>;

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function analyticsClient(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: ClientOptions
) {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  if (region && (typeof region !== 'string' || !REGIONS.includes(region))) {
    throw new Error(
      `\`region\` must be one of the following: ${REGIONS.join(', ')}`
    );
  }

  return createAnalyticsClient({
    appId,
    apiKey,
    region,
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
      caches: [
        createBrowserLocalStorageCache({ key: `${apiClientVersion}-${appId}` }),
        createMemoryCache(),
      ],
    }),
    ...options,
  });
}

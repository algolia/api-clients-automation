import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { XhrRequester } from '@algolia/requester-browser-xhr';

import { createSearchApi, version } from './src/searchApi';
import type { SearchApi } from './src/searchApi';

export * from './src/searchApi';
export * from '@algolia/client-common';

export function searchApi(
  appId: string,
  apiKey: string,
  options?: { requester?: Requester; hosts?: Host[] }
): SearchApi {
  if (!appId) {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey) {
    throw new Error('`apiKey` is missing.');
  }

  return createSearchApi({
    appId,
    apiKey,

    timeouts: {
      connect: 1,
      read: 2,
      write: 30,
    },
    requester: options?.requester ?? new XhrRequester(),
    userAgent: createUserAgent(version)
      .add({ segment: 'Search', version })
      .add({ segment: 'Browser' }),
    authMode: 'WithinQueryParameters',
    ...options,
  });
}

import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { HttpRequester } from '@algolia/requester-node-http';

import { createSearchApi, version } from './src/searchApi';

export * from './src/searchApi';
export * from '@algolia/client-common';

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function searchApi(
  appId: string,
  apiKey: string,
  options?: { requester?: Requester; hosts?: Host[] }
) {
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
    requester: options?.requester ?? new HttpRequester(),
    userAgent: createUserAgent(version)
      .add({ segment: 'Search', version })
      .add({ segment: 'Node.js', version: process.versions.node }),
    ...options,
  });
}

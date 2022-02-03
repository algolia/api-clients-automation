import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { HttpRequester } from '@algolia/requester-node-http';

import { createAbtestingApi, version } from './src/abtestingApi';
import type { Region } from './src/abtestingApi';

export * from './src/abtestingApi';
export * from '@algolia/client-common';

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function abtestingApi(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: { requester?: Requester; hosts?: Host[] }
) {
  if (!appId) {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey) {
    throw new Error('`apiKey` is missing.');
  }

  return createAbtestingApi({
    appId,
    apiKey,
    region,
    timeouts: {
      connect: 1,
      read: 2,
      write: 30,
    },
    requester: options?.requester ?? new HttpRequester(),
    userAgent: createUserAgent(version)
      .add({ segment: 'Abtesting', version })
      .add({ segment: 'Node.js', version: process.versions.node }),
    ...options,
  });
}

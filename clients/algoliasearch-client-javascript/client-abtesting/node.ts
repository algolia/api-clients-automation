import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { HttpRequester } from '@algolia/requester-node-http';

import { createAbtestingApi, version } from './src/abtestingApi';
import type { AbtestingApi, Region } from './src/abtestingApi';

export * from './src/abtestingApi';
export * from '@algolia/client-common';

export function abtestingApi(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: { requester?: Requester; hosts?: Host[] }
): AbtestingApi {
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

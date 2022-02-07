import type { Host, Requester } from '@algolia/client-common';
import { HttpRequester } from '@algolia/requester-node-http';

import { createPersonalizationApi } from './src/personalizationApi';
import type { PersonalizationApi, Region } from './src/personalizationApi';

export * from './src/personalizationApi';
export * from '@algolia/client-common';

export function personalizationApi(
  appId: string,
  apiKey: string,
  region: Region,
  options?: { requester?: Requester; hosts?: Host[] }
): PersonalizationApi {
  if (!appId) {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey) {
    throw new Error('`apiKey` is missing.');
  }

  if (!region) {
    throw new Error('`region` is missing.');
  }

  return createPersonalizationApi({
    appId,
    apiKey,
    region,
    timeouts: {
      connect: 1,
      read: 2,
      write: 30,
    },
    requester: options?.requester ?? new HttpRequester(),
    userAgents: [{ segment: 'Node.js', version: process.versions.node }],
    ...options,
  });
}

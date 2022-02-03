import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { XhrRequester } from '@algolia/requester-browser-xhr';

import { createSourcesApi, version } from './src/sourcesApi';
import type { Region } from './src/sourcesApi';

export * from './src/sourcesApi';
export * from '@algolia/client-common';

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function sourcesApi(
  appId: string,
  apiKey: string,
  region: Region,
  options?: { requester?: Requester; hosts?: Host[] }
) {
  if (!appId) {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey) {
    throw new Error('`apiKey` is missing.');
  }

  if (!region) {
    throw new Error('`region` is missing.');
  }

  return createSourcesApi({
    appId,
    apiKey,
    region,
    timeouts: {
      connect: 1,
      read: 2,
      write: 30,
    },
    requester: options?.requester ?? new XhrRequester(),
    userAgent: createUserAgent(version)
      .add({ segment: 'Sources', version })
      .add({ segment: 'Browser' }),
    authMode: 'WithinQueryParameters',
    ...options,
  });
}

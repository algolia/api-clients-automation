import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { XhrRequester } from '@algolia/requester-browser-xhr';

import { createRecommendApi, version } from './src/recommendApi';

export * from './src/recommendApi';
export * from '@algolia/client-common';

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function recommendApi(
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

  return createRecommendApi({
    appId,
    apiKey,

    timeouts: {
      connect: 1,
      read: 2,
      write: 30,
    },
    requester: options?.requester ?? new XhrRequester(),
    userAgent: createUserAgent(version)
      .add({ segment: 'Recommend', version })
      .add({ segment: 'Browser' }),
    authMode: 'WithinQueryParameters',
    ...options,
  });
}

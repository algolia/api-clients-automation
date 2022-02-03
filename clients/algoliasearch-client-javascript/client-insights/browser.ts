import type { Host, Requester } from '@algolia/client-common';
import { createUserAgent } from '@algolia/client-common';
import { XhrRequester } from '@algolia/requester-browser-xhr';

import { createInsightsApi, version } from './src/insightsApi';
import type { InsightsApi, Region } from './src/insightsApi';

export * from './src/insightsApi';
export * from '@algolia/client-common';

export function insightsApi(
  appId: string,
  apiKey: string,
  region?: Region,
  options?: { requester?: Requester; hosts?: Host[] }
): InsightsApi {
  if (!appId) {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey) {
    throw new Error('`apiKey` is missing.');
  }

  return createInsightsApi({
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
      .add({ segment: 'Insights', version })
      .add({ segment: 'Browser' }),
    authMode: 'WithinQueryParameters',
    ...options,
  });
}

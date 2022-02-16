import type { Host, Requester } from '@algolia/client-common';
import { XhrRequester } from '@algolia/requester-browser-xhr';

import { createCrawlerApi } from '../src/crawlerApi';
import type { CrawlerApi } from '../src/crawlerApi';

export * from '../src/crawlerApi';

export function crawlerApi(
  appId: string,
  apiKey: string,
  options?: { requester?: Requester; hosts?: Host[] }
): CrawlerApi {
  if (!appId) {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey) {
    throw new Error('`apiKey` is missing.');
  }

  return createCrawlerApi({
    appId,
    apiKey,
    timeouts: {
      connect: 1,
      read: 2,
      write: 30,
    },
    requester: options?.requester ?? new XhrRequester(),
    userAgents: [{ segment: 'Browser' }],
    authMode: 'WithinQueryParameters',
    ...options,
  });
}

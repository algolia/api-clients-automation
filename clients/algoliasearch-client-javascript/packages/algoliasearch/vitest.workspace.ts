import { defineWorkersConfig } from '@cloudflare/vitest-pool-workers/config';

export default defineWorkersConfig([
  {
    resolve: {
      alias: {
        '@algolia/client-search': '../../client-search/builds/node',
      },
    },
    test: {
      include: ['__tests__/algoliasearch.node.test.ts'],
      name: 'node',
      environment: 'node',
    },
  },
  {
    resolve: {
      alias: {
        '@algolia/client-search': '../../client-search/builds/browser',
      },
    },
    test: {
      include: ['__tests__/algoliasearch.browser.test.ts', '__tests__/algoliasearch.common.test.ts'],
      name: 'jsdom',
      environment: 'jsdom',
    },
  },
  {
    resolve: {
      alias: {
        '@algolia/client-search': '../../client-search/builds/fetch',
      },
    },
    test: {
      include: ['__tests__/algoliasearch.fetch.test.ts'],
      name: 'miniflare fetch',
      poolOptions: {
        workers: {},
      },
    },
  },
  {
    resolve: {
      alias: {
        '@algolia/client-search': '../../client-search/builds/worker',
      },
    },
    test: {
      include: ['__tests__/algoliasearch.worker.test.ts'],
      name: 'miniflare worker',
      poolOptions: {
        workers: {},
      },
    },
  },
]);

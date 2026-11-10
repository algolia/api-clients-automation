import { builtinModules } from 'node:module';

import { cloudflareTest } from '@cloudflare/vitest-pool-workers';
import type { Plugin } from 'vitest/config';
import { defineConfig } from 'vitest/config';

const compatibilityDate = '2026-04-08';

// Vitest 4 mistakes a bare builtin id (e.g. `stream`) for one of its own files when the id starts with the tail of its
// install path past `root`, which happens when yarn hoists vitest to the monorepo root. The `node:` prefix avoids that.
const prefixNodeBuiltins: Plugin = {
  name: 'prefix-node-builtins',
  config: () => ({
    resolve: {
      alias: [
        {
          find: new RegExp(`^(${builtinModules.filter((name) => !name.startsWith('_')).join('|')})$`),
          replacement: 'node:$1',
        },
      ],
    },
  }),
};

export default defineConfig({
  test: {
    projects: [
      {
        plugins: [prefixNodeBuiltins],
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
        plugins: [prefixNodeBuiltins],
        resolve: {
          alias: {
            '@algolia/abtesting': '../../abtesting/builds/browser',
            '@algolia/client-abtesting': '../../client-abtesting/builds/browser',
            '@algolia/client-analytics': '../../client-analytics/builds/browser',
            '@algolia/client-insights': '../../client-insights/builds/browser',
            '@algolia/client-personalization': '../../client-personalization/builds/browser',
            '@algolia/client-query-suggestions': '../../client-query-suggestions/builds/browser',
            '@algolia/client-search': '../../client-search/builds/browser',
            '@algolia/ingestion': '../../ingestion/builds/browser',
            '@algolia/monitoring': '../../monitoring/builds/browser',
            '@algolia/recommend': '../../recommend/builds/browser',
          },
        },
        test: {
          include: ['__tests__/algoliasearch.browser.test.ts', '__tests__/algoliasearch.common.test.ts'],
          name: 'jsdom',
          environment: 'jsdom',
        },
      },
      {
        plugins: [prefixNodeBuiltins, cloudflareTest({ miniflare: { compatibilityDate } })],
        resolve: {
          alias: {
            '@algolia/client-search': '../../client-search/builds/fetch',
          },
        },
        test: {
          include: ['__tests__/algoliasearch.fetch.test.ts'],
          name: 'miniflare fetch',
        },
      },
      {
        plugins: [prefixNodeBuiltins, cloudflareTest({ miniflare: { compatibilityDate } })],
        resolve: {
          alias: {
            '@algolia/client-search': '../../client-search/builds/worker',
          },
        },
        test: {
          include: ['__tests__/algoliasearch.worker.test.ts'],
          name: 'miniflare worker',
        },
      },
    ],
  },
});

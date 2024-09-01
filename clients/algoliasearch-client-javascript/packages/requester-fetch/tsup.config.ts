import path from 'path';

import type { Options } from 'tsup';
import { defineConfig } from 'tsup';

const baseConfig: Options = {
  clean: true,
  sourcemap: true,
  splitting: false,
  tsconfig: path.resolve(__dirname, 'tsconfig.json'),
};

const baseNodeOptions: Options = {
  ...baseConfig,
  platform: 'node',
  target: 'node14',
  external: ['@algolia/client-common'],
  entry: { 'requester.fetch.node': 'index.ts' },
  dts: { entry: { 'requester.fetch.node': 'index.ts' } },
};

const baseBrowserOptions: Options = {
  ...baseConfig,
  name: 'browser esm',
  platform: 'browser',
  minify: true,
  format: ['esm'],
  target: ['chrome109', 'safari15.6', 'firefox115', 'edge126'],
  external: ['dom', '@algolia/client-common'],
  entry: { 'requester.fetch.browser': 'index.ts' },
  dts: { entry: { 'requester.fetch.browser': 'index.ts' } },
  globalName: 'requesterfetch',
};

const nodeConfigs: Options[] = [
  {
    ...baseNodeOptions,
    format: 'cjs',
    name: 'node cjs',
  },
  {
    ...baseNodeOptions,
    format: 'esm',
    name: 'node esm',
  },
];

const browserConfigs: Options[] = [baseBrowserOptions];

export default defineConfig([...nodeConfigs, ...browserConfigs]);

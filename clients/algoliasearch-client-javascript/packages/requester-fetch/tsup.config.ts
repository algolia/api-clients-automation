import path from 'path';

import type { Options } from 'tsup';
import { defineConfig } from 'tsup';

const baseBrowserOptions: Options = {
  clean: true,
  sourcemap: true,
  splitting: false,
  tsconfig: path.resolve(__dirname, 'tsconfig.json'),
  platform: 'browser',
  minify: true,
  format: ['esm'],
  target: ['chrome109', 'safari15.6', 'firefox115', 'edge126'],
  globalName: 'requesterfetch',
  entry: { 'requester.fetch': 'index.ts' },
  dts: { entry: { 'requester.fetch': 'index.ts' } },
  external: ['dom', '@algolia/client-common'],
};

export default defineConfig(baseBrowserOptions);

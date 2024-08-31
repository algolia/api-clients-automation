import path from 'path';

import type { Options } from 'tsup';
import { defineConfig } from 'tsup';

const baseConfig: Options = {
  clean: true,
  dts: true,
  sourcemap: true,
  splitting: false,
  tsconfig: path.resolve(__dirname, 'tsconfig.json'),
};

const nodeConfigs: Options[] = [
  {
    ...baseConfig,
    platform: 'browser',
    format: 'esm',
    target: ['chrome109', 'safari15.6', 'firefox115', 'edge126'],
    external: ['dom'],
    entry: {
      'requester-fetch.esm.browser': 'index.ts',
    },
  },
];

export default defineConfig(nodeConfigs);

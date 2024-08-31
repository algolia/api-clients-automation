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
    platform: 'node',
    format: 'cjs',
    target: 'node14',
    entry: {
      'requester-node-http': 'index.ts',
    },
  },
  {
    ...baseConfig,
    platform: 'node',
    format: 'esm',
    target: 'node14',
    entry: {
      'requester-node-http.esm.node': 'index.ts',
    },
  },
];

export default defineConfig(nodeConfigs);

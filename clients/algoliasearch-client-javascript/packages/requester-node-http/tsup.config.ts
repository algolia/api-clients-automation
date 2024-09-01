import path from 'path';

import type { Options } from 'tsup';
import { defineConfig } from 'tsup';

const baseNodeOptions: Options = {
  clean: true,
  sourcemap: true,
  splitting: false,
  tsconfig: path.resolve(__dirname, 'tsconfig.json'),
  platform: 'node',
  target: 'node14',
  dts: { entry: { 'requester.http': 'index.ts' } },
  external: ['@algolia/client-common'],
};

export default defineConfig([
  {
    ...baseNodeOptions,
    format: 'cjs',
    entry: { 'requester.http': 'index.ts' },
  },
  {
    ...baseNodeOptions,
    format: 'esm',
    entry: { 'requester.http.esm': 'index.ts' },
  },
]);

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
  dts: { entry: { common: 'index.ts' } },
};

export default defineConfig([
  {
    ...baseNodeOptions,
    format: 'cjs',
    entry: { common: 'index.ts' },
  },
  {
    ...baseNodeOptions,
    format: 'esm',
    entry: { 'common.esm': 'index.ts' },
  },
]);

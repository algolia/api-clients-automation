import { defineConfig } from 'tsup';

import { getBaseNodeOptions } from '../../base.tsup.config';

import pkg from './package.json' with { type: 'json' };

export default defineConfig([
  {
    ...getBaseNodeOptions(pkg),
    format: 'cjs',
    dts: { entry: { common: 'index.ts' } },
    entry: { common: 'index.ts' },
  },
  {
    ...getBaseNodeOptions(pkg),
    format: 'esm',
    dts: { entry: { common: 'index.ts' } },
    entry: { 'common.esm': 'index.ts' },
  },
]);

import { defineConfig } from 'tsup';

import { getBaseNodeOptions } from '../../base.tsup.config';

import pkg from './package.json' with { type: 'json' };

export default defineConfig([
  {
    ...getBaseNodeOptions(pkg),
    format: 'cjs',
    entry: { 'requester.http': 'index.ts' },
    dts: { entry: { 'requester.http': 'index.ts' } },
  },
  {
    ...getBaseNodeOptions(pkg),
    format: 'esm',
    entry: { 'requester.http': 'index.ts' },
    dts: { entry: { 'requester.http': 'index.ts' } },
  },
]);

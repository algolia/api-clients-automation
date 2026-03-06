import { defineConfig } from 'tsup';

import { getBaseBrowserOptions, getBaseNodeOptions } from '../../base.tsup.config';

import pkg from './package.json' with { type: 'json' };

export default defineConfig([
  {
    ...getBaseNodeOptions(pkg, __dirname),
    format: 'cjs',
    dts: { entry: { common: 'src/index.ts' } },
    entry: { common: 'src/index.ts' },
    define: { __BROWSER__: 'false' },
  },
  {
    ...getBaseNodeOptions(pkg, __dirname),
    format: 'esm',
    dts: { entry: { common: 'src/index.ts' } },
    entry: { common: 'src/index.ts' },
    define: { __BROWSER__: 'false' },
  },
  {
    ...getBaseBrowserOptions(pkg, __dirname),
    dts: { entry: { 'common.browser': 'src/index.ts' } },
    entry: { 'common.browser': 'src/index.ts' },
    define: { __BROWSER__: 'true' },
    esbuildOptions(options) {
      options.minifySyntax = true;
    },
  },
]);

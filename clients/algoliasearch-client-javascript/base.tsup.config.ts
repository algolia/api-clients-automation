import path from 'path';

import type { Options } from 'tsup';

type PKG = {
  dependencies?: Record<string, string>;
  name: string;
};

export const baseConfig: Options = {
  clean: true,
  sourcemap: true,
  splitting: false,
  tsconfig: path.resolve(__dirname, 'tsconfig.json'),
};

export function getDependencies(pkg: PKG): string[] {
  return Object.keys(pkg.dependencies || {}) || [];
}

export function getBaseNodeOptions(pkg: PKG): Options {
  return {
    ...baseConfig,
    platform: 'node',
    target: 'node14',
    external: [...getDependencies(pkg), 'node:crypto'],
  };
}

export function getBaseBrowserOptions(pkg: PKG): Options {
  return {
    ...baseConfig,
    platform: 'browser',
    format: ['esm'],
    target: ['chrome109', 'safari15.6', 'firefox115', 'edge126'],
    external: [...getDependencies(pkg), 'dom'],
  };
}

import path from 'path';

import type { Options } from 'tsup';

type PKG = {
  dependencies?: Record<string, string>;
  name: string;
};

export function getBaseConfig(cwd: string): Options {
  return {
    clean: true,
    sourcemap: true,
    splitting: false,
    tsconfig: path.resolve(cwd, 'tsconfig.json'),
  };
}

export function getDependencies(pkg: PKG): string[] {
  return Object.keys(pkg.dependencies || {}) || [];
}

export function getBaseNodeOptions(pkg: PKG, cwd: string): Options {
  return {
    ...getBaseConfig(cwd),
    platform: 'node',
    target: 'node14',
    external: [...getDependencies(pkg), 'node:crypto'],
  };
}

export function getBaseBrowserOptions(pkg: PKG, cwd: string): Options {
  return {
    ...getBaseConfig(cwd),
    platform: 'browser',
    format: ['esm'],
    target: ['chrome109', 'safari15.6', 'firefox115', 'edge126'],
    external: [...getDependencies(pkg), 'dom'],
  };
}

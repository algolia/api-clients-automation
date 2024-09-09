/* eslint-disable no-case-declarations */
import path from 'path';

import type { Options } from 'tsup';

type PKG = {
  dependencies?: Record<string, string>;
  name: string;
};

type Requester = 'fetch' | 'http' | 'xhr';

export function getBaseConfig(cwd: string): Options {
  return {
    clean: true,
    sourcemap: true,
    splitting: false,
    tsconfig: path.resolve(cwd, 'tsconfig.json'),
  };
}

export function getDependencies(pkg: PKG, requester: Requester): string[] {
  const deps = Object.keys(pkg.dependencies || {}) || [];

  if (pkg.name !== 'algoliasearch') {
    return deps;
  }

  switch (requester) {
    case 'http':
      return deps.filter((dep) => dep !== '@algolia/requester-browser-xhr');
    case 'xhr':
      return deps.filter((dep) => dep !== '@algolia/requester-node-http');
    case 'fetch':
      const fetchDeps = deps.filter(
        (dep) => dep !== '@algolia/requester-browser-xhr' && dep !== '@algolia/requester-node-http',
      );
      fetchDeps.push('@algolia/requester-fetch');
      return fetchDeps;
    default:
      throw new Error('unknown requester', requester);
  }
}

export function getBaseNodeOptions(pkg: PKG, cwd: string, requester: Requester = 'http'): Options {
  return {
    ...getBaseConfig(cwd),
    platform: 'node',
    target: 'node14',
    external: [...getDependencies(pkg, requester), 'node:crypto'],
  };
}

export function getBaseBrowserOptions(pkg: PKG, cwd: string, requester: Requester = 'xhr'): Options {
  return {
    ...getBaseConfig(cwd),
    platform: 'browser',
    format: ['esm'],
    target: ['chrome109', 'safari15.6', 'firefox115', 'edge126'],
    external: [...getDependencies(pkg, requester), 'dom'],
  };
}

import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { Cache } from '../cache.js';
import { exists, run, toAbsolutePath } from '../common.js';
import { createSpinner } from '../spinners.js';
import type { Spec } from '../types.js';

import { bundleSpecsForClient, bundleSpecsForDoc, lintCommon } from './format.js';
import type { BaseBuildSpecsOptions } from './types.js';

const ALGOLIASEARCH_LITE_OPERATIONS = ['search', 'customPost', 'getRecommendations'];

/**
 * Creates a lite search spec with the `ALGOLIASEARCH_LITE_OPERATIONS` methods
 * from the `search` spec.
 */
async function buildLiteSpec({
  spec,
  bundledPath,
  docs,
  useCache,
}: {
  spec: string;
  bundledPath: string;
  docs: boolean;
  useCache: boolean;
}): Promise<void> {
  await buildSpec({ spec: 'recommend', outputFormat: 'yml', docs, useCache });

  const base = yaml.load(await fsp.readFile(toAbsolutePath(bundledPath), 'utf8')) as Spec;
  const recommend = yaml.load(
    await fsp.readFile(toAbsolutePath(bundledPath.replace('algoliasearch', 'recommend')), 'utf8'),
  ) as Spec;
  base.paths = { ...base.paths, ...recommend.paths };
  base.components.schemas = { ...base.components.schemas, ...recommend.components.schemas };

  const lite = { ...base, paths: {} };

  for (const [path, operations] of Object.entries(base.paths)) {
    for (const [, operation] of Object.entries(operations)) {
      if (ALGOLIASEARCH_LITE_OPERATIONS.includes(operation.operationId)) {
        lite.paths[path] = { post: operation };

        break;
      }
    }
  }

  await fsp.writeFile(bundledPath, yaml.dump(lite));

  // remove unused components for the outputted light spec
  await run(`yarn openapi bundle ${bundledPath} -o ${bundledPath} --ext yml --remove-unused-components`);

  await bundleSpecsForClient(bundledPath, spec);
}

/**
 * Build spec file.
 */
async function buildSpec({
  spec,
  outputFormat,
  docs,
  useCache,
}: BaseBuildSpecsOptions & { spec: string }): Promise<void> {
  const isLiteSpec = spec === 'algoliasearch';

  if (docs && isLiteSpec) {
    return;
  }

  // In case of lite we use a the `search` spec as a base because only its bundled form exists.
  const specBase = isLiteSpec ? 'search' : spec;
  const logSuffix = docs ? 'doc spec' : 'spec';
  const basePath = docs ? 'docs/' : 'specs/';
  const deps = isLiteSpec ? ['search', 'recommend'] : [spec];
  const cache = new Cache({
    folder: toAbsolutePath(basePath),
    generatedFiles: [`bundled/${spec}.yml`],
    filesToCache: [...deps, 'common'],
    cacheFile: toAbsolutePath(`${basePath}/dist/${spec}.cache`),
  });

  const spinner = createSpinner(`starting '${spec}' ${logSuffix}`);

  if (useCache) {
    spinner.text = `checking cache for '${specBase}'`;

    if (await cache.isValid()) {
      spinner.succeed(`job skipped, cache found for '${specBase}'`);
      return;
    }

    spinner.text = `cache not found for '${specBase}'`;
  }

  // First linting the base
  spinner.text = `linting '${spec}' ${logSuffix}`;
  await run(`yarn specs:fix specs/${specBase}`);

  // Then bundle the file
  const bundledPath = toAbsolutePath(`${basePath}/bundled/${spec}.${outputFormat}`);
  await run(`yarn openapi bundle specs/${specBase}/spec.yml -o ${bundledPath} --ext ${outputFormat}`);

  if (!(await exists(bundledPath))) {
    throw new Error(`Bundled file not found ${bundledPath}.`);
  }

  // Add the correct tags to be able to generate the proper client
  if (!isLiteSpec) {
    docs ? await bundleSpecsForDoc(bundledPath, spec) : await bundleSpecsForClient(bundledPath, spec);
  } else {
    await buildLiteSpec({
      spec,
      bundledPath: toAbsolutePath(bundledPath),
      docs,
      useCache,
    });
  }

  spinner.text = `validating '${spec}' ${logSuffix}`;
  await run(`yarn openapi lint ${bundledPath}`);

  spinner.text = `linting '${spec}' ${logSuffix}`;
  await run(`yarn specs:fix ${basePath}/bundled/${spec}.${outputFormat}`);

  if (useCache) {
    spinner.text = `storing '${spec}' ${logSuffix}`;
    await cache.store();
  }

  spinner.succeed(`building complete for '${spec}' ${logSuffix}`);
}

export async function buildSpecs({
  clients,
  outputFormat,
  docs,
  useCache,
}: BaseBuildSpecsOptions & { clients: string[] }): Promise<void> {
  await fsp.mkdir(toAbsolutePath('specs/dist'), { recursive: true });

  await lintCommon(useCache);

  // the `lite` spec will build the `recommend` spec, so we remove it from the list
  // to prevent concurrent builds
  if (clients.includes('algoliasearch') && !docs) {
    clients = clients.filter((client) => client !== 'recommend');
  }

  await Promise.all(clients.map((client) => buildSpec({ spec: client, outputFormat, docs, useCache })));
}

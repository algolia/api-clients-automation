import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { Cache } from '../cache.ts';
import { run, toAbsolutePath } from '../common.ts';
import { createSpinner } from '../spinners.ts';
import type { Spec } from '../types.ts';

import { lintCommon, transformBundle } from './format.ts';
import type { BaseBuildSpecsOptions } from './types.ts';

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

  await transformBundle({
    bundledPath,
    clientName: spec,
    // Lite does not need documentation because it's just a subset
    docs: false,
  });
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
  const isAlgoliasearch = spec === 'algoliasearch';

  if (docs && isAlgoliasearch) {
    return;
  }

  // In case of lite we use a the `search` spec as a base because only its bundled form exists.
  const specBase = isAlgoliasearch ? 'search' : spec;
  const deps = isAlgoliasearch ? ['search', 'recommend'] : [spec];
  const logSuffix = docs ? 'doc spec' : 'spec';
  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: [docs ? `bundled/${spec}.doc.yml` : `bundled/${spec}.yml`],
    filesToCache: [...deps, 'common'],
    cacheFile: toAbsolutePath(`specs/dist/${spec}.${docs ? 'doc.' : ''}cache`),
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
  await run(`yarn specs:fix ${specBase}`);

  // Then bundle the file
  const bundledPath = `specs/bundled/${spec}.${docs ? 'doc.' : ''}${outputFormat}`;
  await run(`yarn openapi bundle specs/${specBase}/spec.yml -o ${bundledPath} --ext ${outputFormat}`);

  // Add the correct tags to be able to generate the proper client
  if (!isAlgoliasearch) {
    await transformBundle({
      bundledPath: toAbsolutePath(bundledPath),
      clientName: spec,
      docs,
    });
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
  await run(`yarn specs:fix bundled/${spec}.${docs ? 'doc.' : ''}${outputFormat}`);

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

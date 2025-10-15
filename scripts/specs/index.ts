import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { Cache } from '../cache.ts';
import { exists, GENERATORS, run, toAbsolutePath } from '../common.ts';
import { createSpinner } from '../spinners.ts';
import type { Spec } from '../types.ts';

import { getSnippetFile } from '../config.ts';
import { bundleSpecsForClient, bundleSpecsForDoc, lintCommon } from './format.ts';
import type { BaseBuildSpecsOptions } from './types.ts';

const ALGOLIASEARCH_LITE_OPERATIONS = ['search', 'customPost', 'getRecommendations'];

/**
 * Creates a lite search spec with the `ALGOLIASEARCH_LITE_OPERATIONS` methods
 * from the `search` spec.
 */
async function buildLiteSpec({
  spec,
  bundledPath,
  outputFormat,
  docs,
  useCache,
}: BaseBuildSpecsOptions & {
  spec: string;
  bundledPath: string;
}): Promise<void> {
  await buildSpec({ spec: 'recommend', outputFormat: outputFormat, docs, useCache });

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
  await run(`yarn redocly bundle ${bundledPath} -o ${bundledPath} --ext ${outputFormat} --remove-unused-components`);

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
  const logSuffix = `${outputFormat} ${docs ? 'doc spec' : 'spec'}`;
  const basePath = docs ? 'docs' : 'specs';
  const deps = isLiteSpec ? ['specs/search', 'specs/recommend'] : [`specs/${spec}`];
  const generatedFile = `${basePath}/bundled/${spec}.${outputFormat}`;

  const generatedFiles = [generatedFile];
  if (docs && outputFormat === 'yml') {
    for (const gen of Object.values(GENERATORS)) {
      if (gen.client === spec) {
        deps.push(getSnippetFile(gen));
      }
    }

    generatedFiles.push(`docs/bundled/${spec}-snippets.json`);
  }

  const cache = new Cache({
    folder: toAbsolutePath('.'),
    generatedFiles,
    dependsOn: [...deps, 'specs/common'],
    cacheFile: toAbsolutePath(`specs/dist/${spec}-${basePath}-${outputFormat}.cache`),
  });

  const spinner = createSpinner(`starting '${spec}' ${logSuffix}`);

  if (useCache) {
    spinner.text = `checking cache for '${specBase}' ${logSuffix}`;

    if (await cache.hit()) {
      spinner.succeed(`job skipped, cache found for '${specBase}' ${logSuffix}`);
      return;
    }

    spinner.text = `cache not found for '${specBase}' ${logSuffix}`;
  }

  // First linting the base
  spinner.text = `linting '${spec}' ${logSuffix}`;
  await run(`yarn specs:fix specs/${specBase}`);

  // Then bundle the file
  const bundledPath = toAbsolutePath(generatedFile);
  await run(`yarn redocly bundle specs/${specBase}/spec.yml -o ${bundledPath} --ext ${outputFormat} `);

  if (!(await exists(bundledPath))) {
    throw new Error(`Bundled file not found ${bundledPath}.`);
  }

  // Add the correct tags to be able to generate the proper client
  if (isLiteSpec) {
    await buildLiteSpec({
      spec,
      bundledPath: toAbsolutePath(bundledPath),
      outputFormat,
      docs,
      useCache,
    });
  } else if (outputFormat === 'yml') {
    docs ? await bundleSpecsForDoc(bundledPath, spec) : await bundleSpecsForClient(bundledPath, spec);
  }

  spinner.text = `validating '${spec}' ${logSuffix}`;
  await run(`yarn redocly lint ${bundledPath}`);

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

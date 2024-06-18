import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { Cache } from '../cache.js';
import { run, toAbsolutePath } from '../common.js';
import { createSpinner } from '../spinners.js';
import type { Spec } from '../types.js';

import { lintCommon, transformBundle } from './format.js';
import type { BaseBuildSpecsOptions } from './types.js';

const ALGOLIASEARCH_LITE_OPERATIONS = ['search', 'customPost'];

/**
 * Creates a lite search spec with the `ALGOLIASEARCH_LITE_OPERATIONS` methods
 * from the `search` spec.
 */
async function buildLiteSpec({
  spec,
  bundledPath,
}: {
  spec: string;
  bundledPath: string;
}): Promise<void> {
  const parsed = yaml.load(await fsp.readFile(toAbsolutePath(bundledPath), 'utf8')) as Spec;

  // Filter methods.
  parsed.paths = Object.entries(parsed.paths).reduce(
    (acc, [path, operations]) => {
      for (const [, operation] of Object.entries(operations)) {
        if (ALGOLIASEARCH_LITE_OPERATIONS.includes(operation.operationId)) {
          return { ...acc, [path]: { post: operation } };
        }
      }

      return acc;
    },
    {} as Spec['paths'],
  );

  await fsp.writeFile(bundledPath, yaml.dump(parsed));

  // remove unused components for the outputted light spec
  await run(
    `yarn openapi bundle ${bundledPath} -o ${bundledPath} --ext yml --remove-unused-components`,
  );

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
  const logSuffix = docs ? 'doc spec' : 'spec';
  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: [docs ? `bundled/${spec}.doc.yml` : `bundled/${spec}.yml`],
    filesToCache: [specBase, 'common'],
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
  await run(
    `yarn openapi bundle specs/${specBase}/spec.yml -o ${bundledPath} --ext ${outputFormat}`,
  );

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

  await Promise.all(
    clients.map((client) => buildSpec({ spec: client, outputFormat, docs, useCache })),
  );
}

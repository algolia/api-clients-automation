import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { Cache } from './cache.js';
import { exists, run, toAbsolutePath } from './common.js';
import type { Spinner } from './spinners.js';
import { createSpinner } from './spinners.js';
import type { Spec } from './types.js';

const ALGOLIASEARCH_LITE_OPERATIONS = ['search', 'customPost'];

/**
 * This function will transform properties in the bundle depending on the context.
 * E.g:
 * - Check tags definition
 * - Add name of the client in tags
 * - Remove unecessary punctuation for documentation
 * - etc...
 */
async function transformBundle({
  bundledPath,
  withDoc,
  withHelpers,
  clientName,
  alias,
}: {
  bundledPath: string;
  withDoc: boolean;
  withHelpers: boolean;
  clientName: string;
  alias?: string;
}): Promise<void> {
  if (!(await exists(bundledPath))) {
    throw new Error(`Bundled file not found ${bundledPath}.`);
  }

  const bundledSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;

  let bundledDocSpec: Spec | undefined;
  if (withDoc) {
    bundledDocSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;
  }
  const tagsDefinitions = bundledSpec.tags;

  for (const [pathKey, pathMethods] of Object.entries(bundledSpec.paths)) {
    for (const [method, specMethod] of Object.entries(pathMethods)) {
      // In the main bundle we need to have only the clientName
      // because open-api-generator will use this to determine the name of the client
      specMethod.tags = [clientName];

      if (!withHelpers && specMethod['x-helper']) {
        delete bundledSpec.paths[pathKey];
        delete bundledDocSpec?.paths[pathKey];
        break;
      }

      // Doc special cases
      if (!withDoc || !bundledDocSpec) {
        continue;
      }

      const docMethod = bundledDocSpec.paths[pathKey][method];
      if (!docMethod.tags) {
        continue;
      }

      // Checks that specified tags are well defined at root level
      for (const tag of docMethod.tags) {
        if (tag === clientName) {
          throw new Error(
            `Tag name "${tag}" must be different from client name ${clientName} in operation ${specMethod.operationId}`
          );
        }
        if (alias && tag === alias) {
          throw new Error(`Tag name "${tag} must be different from alias ${alias}`);
        }

        const tagExists = tagsDefinitions ? tagsDefinitions.find((t) => t.name === tag) : null;
        if (!tagExists) {
          throw new Error(
            `Tag "${tag}" in "client[${clientName}] -> operation[${specMethod.operationId}]" is not defined`
          );
        }
      }
    }
  }

  await fsp.writeFile(
    bundledPath,
    yaml.dump(bundledSpec, {
      noRefs: true,
    })
  );

  if (withDoc) {
    const pathToDocFile = toAbsolutePath(`specs/bundled/${clientName}.doc.yml`);

    await fsp.writeFile(pathToDocFile, yaml.dump(bundledDocSpec, { noRefs: true }));
  }
}

async function lintCommon(useCache: boolean): Promise<void> {
  const spinner = createSpinner('linting common spec');

  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: [],
    filesToCache: ['common'],
    cacheFile: toAbsolutePath('specs/dist/common.cache'),
  });

  if (useCache && (await cache.isValid())) {
    spinner.succeed("job skipped, cache found for 'common' spec");
    return;
  }

  await run(`yarn specs:lint common`);

  if (useCache) {
    spinner.text = 'storing common spec cache';
    await cache.store();
  }

  spinner.succeed();
}

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
    {} as Spec['paths']
  );

  await fsp.writeFile(bundledPath, yaml.dump(parsed));

  await transformBundle({
    bundledPath,
    clientName: spec,
    // Lite does not need documentation because it's just a subset
    withDoc: false,
    withHelpers: false,
  });
}

/* eslint-disable no-param-reassign */
async function buildSpecWithHelpers(useCache: boolean, spinner: Spinner): Promise<void> {
  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: ['bundled/search.helpers.yml'],
    filesToCache: ['search', 'common'],
    cacheFile: toAbsolutePath('specs/dist/search.helpers.cache'),
  });

  if (useCache) {
    spinner.text = `checking cache for 'search with helpers'`;

    if (await cache.isValid()) {
      spinner.succeed(`job skipped, cache found for 'search with helpers'`);
      return;
    }

    spinner.text = `cache not found for 'search with helpers'`;
  }

  const bundledPath = `specs/bundled/search.helpers.yml`;
  await run(`yarn openapi bundle specs/search/spec.yml -o ${bundledPath} --ext yml`);

  await transformBundle({
    bundledPath: toAbsolutePath(bundledPath),
    clientName: 'search',
    withDoc: false,
    withHelpers: true,
  });

  spinner.text = `linting 'search with helpers' bundled spec`;
  await run('yarn specs:fix bundled/search.helpers.yml');

  if (useCache) {
    spinner.text = `storing 'seach with helpers' spec cache`;
    await cache.store();
  }
}
/* eslint-enable no-param-reassign */

/**
 * Build spec file.
 */
async function buildSpec(spec: string, outputFormat: string, useCache: boolean): Promise<void> {
  const isAlgoliasearch = spec === 'algoliasearch';
  // In case of lite we use a the `search` spec as a base because only its bundled form exists.
  const specBase = isAlgoliasearch ? 'search' : spec;
  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: [
      `bundled/${spec}.yml`,
      ...(isAlgoliasearch ? [] : [`bundled/${spec}.doc.yml`, `bundled/${spec}.json`]),
    ],
    filesToCache: [specBase, 'common'],
    cacheFile: toAbsolutePath(`specs/dist/${spec}.cache`),
  });

  const spinner = createSpinner(`starting '${spec}' spec`);

  if (useCache) {
    spinner.text = `checking cache for '${specBase}'`;

    if (await cache.isValid()) {
      spinner.succeed(`job skipped, cache found for '${specBase}'`);
      return;
    }

    spinner.text = `cache not found for '${specBase}'`;
  }

  // First linting the base
  spinner.text = `linting '${spec}' spec`;
  await run(`yarn specs:fix ${specBase}`);

  // Then bundle the file
  const bundledPath = `specs/bundled/${spec}.${outputFormat}`;
  await run(
    `yarn openapi bundle specs/${specBase}/spec.yml -o ${bundledPath} --ext ${outputFormat}`
  );

  // Add the correct tags to be able to generate the proper client
  if (!isAlgoliasearch) {
    await transformBundle({
      bundledPath: toAbsolutePath(bundledPath),
      clientName: spec,
      withDoc: true,
      withHelpers: false,
    });
  } else {
    await buildLiteSpec({
      spec,
      bundledPath: toAbsolutePath(bundledPath),
    });
  }

  spinner.text = `validating '${spec}' bundled spec`;
  await run(`yarn openapi lint ${bundledPath}`);

  spinner.text = `linting '${spec}' bundled spec`;
  await run(`yarn specs:fix bundled/${spec}.${outputFormat}`);

  if (!isAlgoliasearch) {
    spinner.text = `linting '${spec}' doc spec`;
    await run(`yarn specs:fix bundled/${spec}.doc.yml`);
    await run(
      `yarn openapi bundle specs/bundled/${spec}.doc.yml --output specs/bundled/${spec}.json --format json --ext json --dereferenced`
    );
  }

  if (useCache) {
    spinner.text = `storing '${spec}' spec cache`;
    await cache.store();
  }

  if (spec === 'search') {
    await buildSpecWithHelpers(useCache, spinner);
  }

  spinner.succeed(`building complete for '${spec}' spec`);
}

export async function buildSpecs(
  clients: string[],
  outputFormat: 'json' | 'yml',
  useCache: boolean
): Promise<void> {
  await fsp.mkdir(toAbsolutePath('specs/dist'), { recursive: true });

  await lintCommon(useCache);

  await Promise.all(clients.map((client) => buildSpec(client, outputFormat, useCache)));
}

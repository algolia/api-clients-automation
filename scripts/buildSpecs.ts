import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { checkForCache, exists, run, toAbsolutePath } from './common';
import { createSpinner } from './oraLog';
import type { Spec } from './types';

const ALGOLIASEARCH_LITE_OPERATIONS = [
  'search',
  'multipleQueries',
  'searchForFacetValues',
  'post',
];

async function propagateTagsToOperations({
  bundledPath,
  clientName,
  alias,
}: {
  bundledPath: string;
  clientName: string;
  alias?: string;
}): Promise<void> {
  if (!(await exists(bundledPath))) {
    throw new Error(`Bundled file not found ${bundledPath}.`);
  }

  const pathToDoc = bundledPath.replace('.yml', '.doc.yml');

  const bundledSpec = yaml.load(
    await fsp.readFile(bundledPath, 'utf8')
  ) as Spec;
  const bundledDocSpec = yaml.load(
    await fsp.readFile(bundledPath, 'utf8')
  ) as Spec;
  const tagsDefinitions = bundledSpec.tags;

  for (const [pathKey, pathMethods] of Object.entries(bundledSpec.paths)) {
    for (const [method, specMethod] of Object.entries(pathMethods)) {
      // In the main bundle we need to only have the clientName before open-api generator will use this to determine the name of the client
      specMethod.tags = [clientName];

      if (!bundledDocSpec.paths[pathKey][method].tags) {
        continue;
      }

      // Checks that specified tags are well defined at root level
      for (const tag of bundledDocSpec.paths[pathKey][method].tags) {
        if (tag === clientName || (alias && tag === alias)) {
          return;
        }

        const tagExists = tagsDefinitions
          ? tagsDefinitions.find((t) => t.name === tag)
          : null;
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
  await fsp.writeFile(
    pathToDoc,
    yaml.dump(bundledDocSpec, {
      noRefs: true,
    })
  );
}

async function lintCommon(verbose: boolean, useCache: boolean): Promise<void> {
  let hash = '';
  const cacheFile = toAbsolutePath(`specs/dist/common.cache`);
  if (useCache) {
    const { cacheExists, hash: newCache } = await checkForCache(
      {
        job: 'common specs',
        folder: toAbsolutePath('specs/'),
        generatedFiles: [],
        filesToCache: ['common'],
        cacheFile,
      },
      verbose
    );

    if (cacheExists) {
      return;
    }

    hash = newCache;
  }

  const spinner = createSpinner('linting common spec', verbose).start();
  await run(`yarn specs:lint common`, { verbose });

  if (hash) {
    spinner.text = `storing common spec cache`;
    await fsp.writeFile(cacheFile, hash);
  }

  spinner.succeed();
}

/**
 * Creates a lite search spec with the `ALGOLIASEARCH_LITE_OPERATIONS` methods
 * from the `search` spec.
 */
async function buildLiteSpec(
  spec: string,
  bundledPath: string,
  outputFormat: string,
  verbose: boolean
): Promise<void> {
  const parsed = yaml.load(
    await fsp.readFile(toAbsolutePath(bundledPath), 'utf8')
  ) as Spec;

  parsed.paths = Object.entries(parsed.paths).reduce(
    (acc, [path, operations]) => {
      for (const [method, operation] of Object.entries(operations)) {
        if (
          method === 'post' &&
          ALGOLIASEARCH_LITE_OPERATIONS.includes(operation.operationId)
        ) {
          return { ...acc, [path]: { post: operation } };
        }
      }

      return acc;
    },
    {} as Spec['paths']
  );

  const liteBundledPath = `specs/bundled/${spec}.${outputFormat}`;
  await fsp.writeFile(toAbsolutePath(liteBundledPath), yaml.dump(parsed));

  await propagateTagsToOperations({
    bundledPath: toAbsolutePath(liteBundledPath),
    clientName: spec,
  });

  await run(`yarn specs:fix bundled/${spec}.${outputFormat}`, {
    verbose,
  });
}

async function buildSpec(
  spec: string,
  outputFormat: string,
  verbose: boolean,
  useCache: boolean
): Promise<void> {
  const shouldBundleLiteSpec = spec === 'algoliasearch-lite';
  const client = shouldBundleLiteSpec ? 'search' : spec;
  const cacheFile = toAbsolutePath(`specs/dist/${client}.cache`);
  let hash = '';

  createSpinner(`'${client}' spec`, verbose).start().info();

  if (useCache) {
    const generatedFiles = [
      `bundled/${client}.yml`,
      `bundled/${client}.doc.yml`,
    ];

    if (shouldBundleLiteSpec) {
      generatedFiles.push(`bundled/${spec}.yml`);
    }

    const { cacheExists, hash: newCache } = await checkForCache(
      {
        job: `'${client}' specs`,
        folder: toAbsolutePath('specs/'),
        generatedFiles,
        filesToCache: [client, 'common'],
        cacheFile,
      },
      verbose
    );

    if (cacheExists) {
      return;
    }

    hash = newCache;
  }

  const spinner = createSpinner(`building ${client} spec`, verbose).start();
  const bundledPath = `specs/bundled/${client}.${outputFormat}`;
  await run(
    `yarn openapi bundle specs/${client}/spec.yml -o ${bundledPath} --ext ${outputFormat}`,
    { verbose }
  );

  await propagateTagsToOperations({
    bundledPath: toAbsolutePath(bundledPath),
    clientName: spec,
    alias: client,
  });

  spinner.text = `linting ${client} spec`;
  await run(`yarn specs:fix ${client}`, { verbose });

  spinner.text = `validating ${client} spec`;
  await run(`yarn openapi lint specs/bundled/${client}.${outputFormat}`, {
    verbose,
  });

  spinner.text = `linting '${client}' bundled spec`;
  await run(`yarn specs:fix bundled/${client}.${outputFormat}`, { verbose });

  if (shouldBundleLiteSpec) {
    spinner.text = `Building and linting '${spec}' spec`;
    await buildLiteSpec(spec, bundledPath, outputFormat, verbose);
  }

  if (hash) {
    spinner.text = `storing ${client} spec cache`;
    await fsp.writeFile(cacheFile, hash);
  }

  spinner.succeed(`building complete for '${client}' spec`);
}

export async function buildSpecs(
  clients: string[],
  outputFormat: 'json' | 'yml',
  verbose: boolean,
  useCache: boolean
): Promise<void> {
  await fsp.mkdir(toAbsolutePath('specs/dist'), { recursive: true });

  await lintCommon(verbose, useCache);

  await Promise.all(
    clients.map((client) => buildSpec(client, outputFormat, verbose, useCache))
  );
}

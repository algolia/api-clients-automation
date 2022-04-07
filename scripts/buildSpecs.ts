import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { checkForCache, exists, run, toAbsolutePath } from './common';
import { createSpinner } from './oraLog';
import type { Spec } from './pre-gen/setHostsOptions';

const SEARCH_LITE_PATHS = [
  'search',
  'multipleQueries',
  'searchForFacetValues',
  'post',
];

async function propagateTagsToOperations(
  bundledPath: string,
  client: string
): Promise<boolean> {
  if (!(await exists(bundledPath))) {
    throw new Error(`Bundled file not found ${bundledPath}.`);
  }

  const bundledSpec = yaml.load(
    await fsp.readFile(bundledPath, 'utf8')
  ) as Spec;

  if (bundledSpec.tags.length === 0) {
    throw new Error(
      `No tags defined for ${bundledPath}, tags are required to properly generate a client.`
    );
  }

  const tagsName =
    client === 'search_lite'
      ? ['algoliasearchLite']
      : bundledSpec.tags.map((tag) => tag.name);

  for (const pathMethods of Object.values(bundledSpec.paths)) {
    for (const specMethod of Object.values(pathMethods)) {
      specMethod.tags = tagsName;
    }
  }

  await fsp.writeFile(
    bundledPath,
    yaml.dump(bundledSpec, {
      noRefs: true,
    })
  );

  return true;
}

async function buildSpec(
  client: string,
  outputFormat: string,
  verbose: boolean,
  useCache: boolean
): Promise<void> {
  createSpinner(`'${client}' spec`, verbose).start().info();
  const cacheFile = toAbsolutePath(`specs/dist/${client}.cache`);
  let hash = '';

  if (useCache) {
    const { cacheExists, hash: newCache } = await checkForCache(
      {
        job: `'${client}' specs`,
        folder: toAbsolutePath('specs/'),
        generatedFiles: [`bundled/${client}.yml`],
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

  if (
    (await propagateTagsToOperations(toAbsolutePath(bundledPath), client)) ===
    false
  ) {
    spinner.fail();
    throw new Error(
      `Unable to propage tags to operations for \`${client}\` spec.`
    );
  }

  spinner.text = `linting ${client} spec`;
  await run(`yarn specs:lint ${client}`, { verbose });

  spinner.text = `validating ${client} spec`;
  await run(`yarn openapi lint specs/bundled/${client}.${outputFormat}`, {
    verbose,
  });

  spinner.text = `linting '${client}' bundled spec`;
  await run(`yarn specs:fix bundled/${client}.${outputFormat}`, { verbose });

  if (hash) {
    spinner.text = `storing ${client} spec cache`;
    await fsp.writeFile(cacheFile, hash);
  }

  // We create a lite bundled spec to generate the algoliasearch/lite client
  // for JavaScript
  if (client === 'search') {
    const liteClient = 'search_lite';
    const searchSpec = yaml.load(
      await fsp.readFile(toAbsolutePath(bundledPath), 'utf8')
    ) as Spec;

    searchSpec.paths = Object.entries(searchSpec.paths).reduce(
      (acc, [path, operations]) => {
        for (const [method, operation] of Object.entries(operations)) {
          if (
            method === 'post' &&
            SEARCH_LITE_PATHS.includes(operation.operationId)
          ) {
            return { ...acc, [path]: { post: operation } };
          }
        }

        return acc;
      },
      {} as Spec['paths']
    );

    const liteBundledPath = `specs/bundled/${liteClient}.${outputFormat}`;
    await fsp.writeFile(toAbsolutePath(liteBundledPath), yaml.dump(searchSpec));

    if (
      (await propagateTagsToOperations(
        toAbsolutePath(liteBundledPath),
        liteClient
      )) === false
    ) {
      spinner.fail();
      throw new Error(
        `Unable to propage tags to operations for \`${liteClient}\` spec.`
      );
    }

    spinner.text = `linting '${liteClient}' bundled spec`;
    await run(`yarn specs:fix bundled/${liteClient}.${outputFormat}`, {
      verbose,
    });
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

  await Promise.all(
    clients.map((client) => buildSpec(client, outputFormat, verbose, useCache))
  );
}

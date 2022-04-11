import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { checkForCache, exists, run, toAbsolutePath } from './common';
import { createSpinner } from './oraLog';
import type { Spec } from './pre-gen/setHostsOptions';

const ALGOLIASEARCHLITE_OPERATIONS = [
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

  for (const pathMethods of Object.values(bundledSpec.paths)) {
    for (const specMethod of Object.values(pathMethods)) {
      specMethod.tags = [client];
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
  spec: string,
  outputFormat: string,
  verbose: boolean,
  useCache: boolean
): Promise<void> {
  const shouldBundleLiteSpec = spec === 'algoliasearchLite';
  const client = shouldBundleLiteSpec ? 'search' : spec;
  const cacheFile = toAbsolutePath(`specs/dist/${client}.cache`);
  let hash = '';

  createSpinner(`'${client}' spec`, verbose).start().info();

  if (useCache) {
    const generatedFiles = [`bundled/${client}.yml`];

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

  if (!(await propagateTagsToOperations(toAbsolutePath(bundledPath), client))) {
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

  // This part creates an algoliasearchLite bundled spec based on the search spec
  // which allow us to generated a JavaScript lite client.
  if (shouldBundleLiteSpec) {
    const searchSpec = yaml.load(
      await fsp.readFile(toAbsolutePath(bundledPath), 'utf8')
    ) as Spec;

    searchSpec.paths = Object.entries(searchSpec.paths).reduce(
      (acc, [path, operations]) => {
        for (const [method, operation] of Object.entries(operations)) {
          if (
            method === 'post' &&
            ALGOLIASEARCHLITE_OPERATIONS.includes(operation.operationId)
          ) {
            return { ...acc, [path]: { post: operation } };
          }
        }

        return acc;
      },
      {} as Spec['paths']
    );

    const liteBundledPath = `specs/bundled/${spec}.${outputFormat}`;
    await fsp.writeFile(toAbsolutePath(liteBundledPath), yaml.dump(searchSpec));

    if (
      !(await propagateTagsToOperations(toAbsolutePath(liteBundledPath), spec))
    ) {
      spinner.fail();
      throw new Error(
        `Unable to propage tags to operations for \`${spec}\` spec.`
      );
    }

    spinner.text = `linting '${spec}' bundled spec`;
    await run(`yarn specs:fix bundled/${spec}.${outputFormat}`, {
      verbose,
    });
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

  await Promise.all(
    clients.map((client) => buildSpec(client, outputFormat, verbose, useCache))
  );
}

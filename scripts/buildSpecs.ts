import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { Cache } from './cache.js';
import { GENERATORS, capitalize, createClientName, exists, run, toAbsolutePath } from './common.js';
import { createSpinner } from './spinners.js';
import type { CodeSamples, Language, SnippetSamples, Spec } from './types.js';

const ALGOLIASEARCH_LITE_OPERATIONS = ['search', 'customPost', 'getRecommendations'];

function mapLanguageToCodeSampleSupporter(language: Language): CodeSamples['lang'] {
  switch (language) {
    case 'csharp':
      return 'CSharp';
    case 'javascript':
      return 'JavaScript';
    case 'php':
      return 'PHP';
    default:
      return capitalize(language) as CodeSamples['lang'];
  }
}

// For a given `clientName`, reads the matching snippet file for every available clients and builds an hashmap of snippets per operationId per language.
async function transformSnippetsToCodeSamples(clientName: string): Promise<SnippetSamples> {
  const snippetSamples = Object.values(GENERATORS).reduce(
    (prev, curr) => ({ ...prev, [curr.language]: {} }),
    {} as SnippetSamples,
  );

  for (const gen of Object.values(GENERATORS)) {
    if (gen.client !== clientName) {
      continue;
    }

    // find snippets for each operationId in the current gen.language + clientName combo
    const snippetFileContent = await fsp.readFile(
      toAbsolutePath(
        `snippets/${gen.language}/${gen.snippets.outputFolder}/${createClientName(clientName, gen.language)}${gen.snippets.extension}`,
      ),
      'utf8',
    );

    // iterate over every matches (operationId) and store it in the hashmap for later use
    for (const match of snippetFileContent.matchAll(/>SEPARATOR (.+)\n([\s\S]*?)SEPARATOR</g)) {
      const lines: string[] = match[0].split('\n').slice(1, -1);
      if (!lines.length) {
        throw new Error(`No snippet found for ${gen.language} ${gen.client}`);
      }

      if (!snippetSamples[gen.language]) {
        snippetSamples[gen.language] = {};
      }

      snippetSamples[gen.language][match[1]] = '';

      const indent = lines[0].length - lines[0].trim().length;
      // skip first and last lines because they contain the SEPARATOR or operationId
      lines.forEach((line) => {
        // best effort to determine how far the snippet is indented so we
        // can have every snippets in the documentation on the far left
        // without impacting the formatting
        snippetSamples[gen.language][match[1]] += `${line.slice(indent).replaceAll(/\t/g, '  ')}\n`;
      });
    }
  }

  return snippetSamples;
}

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
  docs,
  clientName,
  alias,
}: {
  bundledPath: string;
  docs: boolean;
  clientName: string;
  alias?: string;
}): Promise<void> {
  if (!(await exists(bundledPath))) {
    throw new Error(`Bundled file not found ${bundledPath}.`);
  }

  const bundledSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;
  const tagsDefinitions = bundledSpec.tags;
  const snippetSamples = !docs ? {} : await transformSnippetsToCodeSamples(clientName);

  for (const [pathKey, pathMethods] of Object.entries(bundledSpec.paths)) {
    for (const [method, specMethod] of Object.entries(pathMethods)) {
      if (!docs) {
        // In the main bundle we need to have only the clientName
        // because open-api-generator will use this to determine the name of the client
        specMethod.tags = [clientName];
        continue;
      }

      if (specMethod['x-helper']) {
        delete bundledSpec.paths[pathKey];
        break;
      }

      // Populate the x-codeSamples property with the snippets we retrieved in `transformSnippetsToCodeSamples`
      for (const gen of Object.values(GENERATORS)) {
        if (gen.client !== clientName) {
          continue;
        }

        if (!specMethod['x-codeSamples']) {
          specMethod['x-codeSamples'] = [];
        }

        specMethod['x-codeSamples'].push({
          lang: mapLanguageToCodeSampleSupporter(gen.language),
          source: snippetSamples[gen.language][specMethod.operationId],
        });
      }

      if (!bundledSpec.paths[pathKey][method].tags) {
        continue;
      }

      // Checks that specified tags are well defined at root level
      for (const tag of bundledSpec.paths[pathKey][method].tags) {
        if (tag === clientName) {
          throw new Error(
            `Tag name "${tag}" must be different from client name ${clientName} in operation ${specMethod.operationId}`,
          );
        }

        if (alias && tag === alias) {
          throw new Error(
            `Tag name "${tag} for operation ${specMethod.operationId} must be different from alias ${alias}`,
          );
        }

        const tagExists = tagsDefinitions ? tagsDefinitions.find((t) => t.name === tag) : null;
        if (!tagExists) {
          throw new Error(
            `Tag "${tag}" in "client[${clientName}] -> operation[${specMethod.operationId}]" is not defined`,
          );
        }
      }
    }
  }

  await fsp.writeFile(
    docs ? toAbsolutePath(`specs/bundled/${clientName}.doc.yml`) : bundledPath,
    yaml.dump(bundledSpec, { noRefs: true }),
  );
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
    spinner.text = `checking cache for '${spec}'`;

    if (await cache.isValid()) {
      spinner.succeed(`job skipped, cache found for '${spec}'`);
      return;
    }

    spinner.text = `cache not found for '${spec}'`;
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

type BaseBuildSpecsOptions = {
  outputFormat: 'json' | 'yml';
  docs: boolean;
  useCache: boolean;
};

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
  if (clients.includes('algoliasearch')) {
    // eslint-disable-next-line no-param-reassign
    clients = clients.filter((client) => client !== 'recommend');
  }

  await Promise.all(
    clients.map((client) => buildSpec({ spec: client, outputFormat, docs, useCache })),
  );
}

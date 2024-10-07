import fsp from 'fs/promises';

import oas2har from '@har-sdk/oas';
import { HarRequest, HTTPSnippet } from 'httpsnippet';
import yaml from 'js-yaml';

import { Cache } from '../cache.js';
import { GENERATORS, exists, run, toAbsolutePath } from '../common.js';
import { createSpinner } from '../spinners.js';
import type { Spec } from '../types.js';

import { getCodeSampleLabel, transformSnippetsToCodeSamples, transformCodeSamplesToGuideMethods } from './snippets.js';
import type { SnippetSamples } from './types.js';

export async function lintCommon(useCache: boolean): Promise<void> {
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

  await run('yarn specs:lint common');

  if (useCache) {
    spinner.text = 'storing common spec cache';
    await cache.store();
  }

  spinner.succeed();
}

/*
 * This function will transform properties in the bundle depending on the context.
 * E.g:
 * - Check tags definition
 * - Add name of the client in tags
 * - Remove unecessary punctuation for documentation
 * - etc...
 */
export async function transformBundle({
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
  const harRequests = await oas2har.oas2har(bundledSpec as any, { includeVendorExamples: true });
  const tagsDefinitions = bundledSpec.tags;
  const snippetSamples = docs ? await transformSnippetsToCodeSamples(clientName) : ({} as SnippetSamples);

  if (docs) {
    const snippets = transformCodeSamplesToGuideMethods(JSON.parse(JSON.stringify(snippetSamples)));
    await fsp.writeFile(toAbsolutePath(`guides/${clientName}-snippets.json`), snippets);
  }

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

        if (snippetSamples[gen.language][specMethod.operationId]) {
          specMethod['x-codeSamples'].push({
            lang: gen.language,
            label: getCodeSampleLabel(gen.language),
            source: Object.values(snippetSamples[gen.language][specMethod.operationId])[0],
          });
        }
      }

      // skip custom path for cURL
      if (pathKey !== '/{path}') {
        const harRequest = harRequests.find((baseHarRequest) =>
          baseHarRequest.url.includes(pathKey.replace('{indexName}', 'ALGOLIA_INDEX_NAME')),
        );

        if (!harRequest?.headers) {
          break;
        }

        for (const harRequestHeader of harRequest.headers) {
          if (harRequestHeader.name === bundledSpec.components.securitySchemes.appId.name) {
            harRequestHeader.value = 'ALGOLIA_APPLICATION_ID';
          }

          if (harRequestHeader.name === bundledSpec.components.securitySchemes.apiKey.name) {
            harRequestHeader.value = 'ALGOLIA_API_KEY';
          }
        }

        specMethod['x-codeSamples'].push({
          lang: 'cURL',
          label: 'curl',
          source: new HTTPSnippet(harRequest as HarRequest).convert('shell', 'curl', { indent: '\t' }),
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

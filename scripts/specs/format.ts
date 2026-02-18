import fsp from 'fs/promises';

import oas2har from '@har-sdk/oas';
import type { HarRequest } from '@readme/httpsnippet';
import { HTTPSnippet } from '@readme/httpsnippet';
import yaml from 'js-yaml';

import { Cache } from '../cache.ts';
import { GENERATORS, run, toAbsolutePath } from '../common.ts';
import { createSpinner } from '../spinners.ts';
import type { Spec } from '../types.ts';

import { getCodeSampleLabel, transformGeneratedSnippetsToCodeSamples } from './snippets.ts';

export async function lintCommon(useCache: boolean): Promise<void> {
  const spinner = createSpinner('linting common spec');

  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: [],
    dependencies: ['common'],
    cacheFile: toAbsolutePath('specs/dist/common.cache'),
  });

  if (useCache && (await cache.hit())) {
    spinner.succeed("job skipped, cache found for 'common' spec");
    return;
  }

  await run('yarn specs:lint specs/common');

  if (useCache) {
    spinner.text = 'storing common spec cache';
    await cache.store();
  }

  spinner.succeed();
}

export async function bundleSpecsForClient(bundledPath: string, clientName: string): Promise<void> {
  const bundledSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;

  Object.values(bundledSpec.paths).forEach((pathMethods) => {
    Object.values(pathMethods).forEach((specMethod) => (specMethod.tags = [clientName]));
  });

  await fsp.writeFile(bundledPath, yaml.dump(bundledSpec, { noRefs: true }));
}

export async function bundleSpecsForDoc(bundledPath: string, clientName: string): Promise<void> {
  const bundledSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;
  const harRequests = await oas2har.oas2har(bundledSpec as any, { includeVendorExamples: true });
  const tagsDefinitions = bundledSpec.tags;
  const codeSamples = await transformGeneratedSnippetsToCodeSamples(clientName);

  for (const [pathKey, pathMethods] of Object.entries(bundledSpec.paths)) {
    for (const [method, specMethod] of Object.entries(pathMethods)) {
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

        if (codeSamples[gen.language][specMethod.operationId]) {
          specMethod['x-codeSamples'].push({
            lang: gen.language,
            label: getCodeSampleLabel(gen.language),
            source: Object.values(codeSamples[gen.language][specMethod.operationId])[0],
          });
        }
      }

      // skip custom path for cURL
      if (pathKey !== '/{path}' && specMethod['x-codeSamples']) {
        const harRequest = harRequests.find((baseHarRequest) => {
          // the url also has the query parameters, so we need to check if it ends with the path
          // all the variables are also replaced by the example in the spec, so we need to check with a regex.
          const urlRegex = new RegExp(
            `${pathKey
              .replace('{indexName}', 'ALGOLIA_INDEX_NAME')
              .replace('*', '\\*')
              .replace(/\{.*?\}/g, '.*?')}($|\\?)`,
          );
          return (
            baseHarRequest.url.match(urlRegex) !== null && baseHarRequest.method.toLowerCase() === method.toLowerCase()
          );
        });
        if (!harRequest) {
          throw new Error(`Could not find a the correct HAR request for ${method} ${pathKey}`);
        }

        if (!harRequest?.headers) {
          break;
        }

        for (const harRequestHeader of harRequest.headers) {
          if (harRequestHeader.name === bundledSpec.components.securitySchemes.appId?.name) {
            harRequestHeader.value = 'ALGOLIA_APPLICATION_ID';
          }

          if (harRequestHeader.name === bundledSpec.components.securitySchemes.apiKey?.name) {
            harRequestHeader.value = 'ALGOLIA_API_KEY';
          }
        }

        const curlSnippet = new HTTPSnippet(harRequest as HarRequest).convert('shell', 'curl');

        specMethod['x-codeSamples'].push({
          lang: 'cURL',
          label: 'curl',
          source: curlSnippet ? curlSnippet[0] : '',
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

        const tagExists = tagsDefinitions ? tagsDefinitions.find((t) => t.name === tag) : null;
        if (!tagExists) {
          throw new Error(
            `Tag "${tag}" in "client[${clientName}] -> operation[${specMethod.operationId}]" is not defined`,
          );
        }
      }
    }
  }

  await fsp.writeFile(toAbsolutePath(`docs/bundled/${clientName}.yml`), yaml.dump(bundledSpec, { noRefs: true }));
}

import { writeFile } from 'fs/promises';

import clientsConfig from '../../config/clients.config.json';
import openapitools from '../../config/openapitools.json';
import { toAbsolutePath } from '../common';
import type { Generator } from '../types';

const AVAILABLE_CUSTOM_GEN = Object.entries(clientsConfig).reduce(
  (clients, [lang, clientOptions]) => {
    if (clientOptions.customGenerator) {
      return [...new Set([...clients, lang])];
    }

    return clients;
  },
  [] as string[]
);

/**
 * Create openapitools.json file with default options for all generators.
 *
 * Defaults options are used to
 * - Set config path.
 */
export async function generateOpenapitools(
  generators: Generator[]
): Promise<void> {
  const result = {};
  for (const { key, client, language, ...rest } of generators) {
    result[key] = {
      config: '#{cwd}/openapitools.json',
      gitHost: 'algolia',
      gitUserId: 'algolia',
      glob: `specs/bundled/${client}.yml`,
      templateDir: `#{cwd}/templates/${language}/`,
      generatorName: AVAILABLE_CUSTOM_GEN.includes(language)
        ? `algolia-${language}`
        : rest.generatorName,
      ...rest,
      output: `#{cwd}/${rest.output}`,
    };
  }
  await writeFile(
    toAbsolutePath('openapitools.json'),
    JSON.stringify(
      {
        'generator-cli': {
          version: openapitools['generator-cli'].version,
          generators: result,
        },
      },
      null,
      2
    ).concat('\n')
  );
}

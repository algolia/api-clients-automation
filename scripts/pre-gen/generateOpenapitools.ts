import { writeFile } from 'fs/promises';

import clientsConfig from '../../config/clients.config.json' assert { type: 'json' };
import { toAbsolutePath } from '../common.js';
import { getClientsConfigField } from '../config.js';
import type { Generator } from '../types.js';

const AVAILABLE_CUSTOM_GEN = Object.values(clientsConfig)
  .map((gen) => ('customGenerator' in gen ? gen.customGenerator : null))
  .filter(Boolean);

const baseOpenapitoolsConfig = {
  'generator-cli': {
    version: '7.2.0',
  },
};

/**
 * Create an on the fly openapitools.json file with default options for all generators.
 *
 * Defaults options are used to
 * - Set config path.
 */
export async function generateOpenapitools(generators: Generator[]): Promise<void> {
  const result = {};
  for (const { key, client, language, additionalProperties, ...rest } of generators) {
    const templateDir =
      language === 'javascript'
        ? `#{cwd}/templates/${language}/clients`
        : `#{cwd}/templates/${language}/`;

    result[key] = {
      config: '#{cwd}/openapitools.json',
      gitHost: 'github.com',
      gitUserId: 'algolia',
      gitRepoId: getClientsConfigField(language, 'gitRepoId'),
      glob: `specs/bundled/${client}.yml`,
      templateDir,
      generatorName: AVAILABLE_CUSTOM_GEN.includes(`algolia-${language}`)
        ? `algolia-${language}`
        : rest.generatorName,
      ...rest,
      output: `#{cwd}/${rest.output}`,
      additionalProperties: {
        client,
        ...additionalProperties,
      },
    };
  }
  await writeFile(
    toAbsolutePath('openapitools.json'),
    JSON.stringify(
      {
        'generator-cli': {
          version: baseOpenapitoolsConfig['generator-cli'].version,
          generators: result,
        },
      },
      null,
      2
    ).concat('\n')
  );
}

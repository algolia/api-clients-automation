import { writeFile } from 'fs/promises';

import { toAbsolutePath } from '../common.ts';
import { getClientsConfigField } from '../config.ts';
import type { Generator, GeneratorMode } from '../types.ts';

/**
 * Create an on the fly openapitools.json file with default options for all generators.
 *
 * Defaults options are used to
 * - Set config path.
 */
export async function generateOpenapitools(
  gens: Generator[],
  mode: GeneratorMode,
  additionalProperties = {},
): Promise<void> {
  const generators = {};
  for (const { key, client, language, ...rest } of gens) {
    const templateDir =
      language === 'javascript' ? `#{cwd}/templates/${language}/clients` : `#{cwd}/templates/${language}/`;

    generators[key] = {
      config: '#{cwd}/openapitools.json',
      gitHost: 'github.com',
      gitUserId: 'algolia',
      gitRepoId: getClientsConfigField(language, 'gitRepoId'),
      glob: `specs/bundled/${client}.yml`,
      templateDir,
      generatorName: `algolia-${mode === 'client' ? language : 'cts'}`,
      output: `#{cwd}/${mode === 'client' ? rest.output : ''}`,
      additionalProperties: {
        language,
        client,
        mode,
        ...additionalProperties,
      },
      skipValidateSpec: true,
      'openapi-normalizer': {
        // if this is set to true, it causes a breaking change on PlatformWithNone, this can be removed in the next major
        SIMPLIFY_ONEOF_ANYOF_ENUM: false,
      },
    };
  }

  await writeFile(
    toAbsolutePath('openapitools.json'),
    JSON.stringify(
      {
        'generator-cli': {
          version: '7.16.0',
          generators,
        },
      },
      null,
      2,
    ).concat('\n'),
  );
}

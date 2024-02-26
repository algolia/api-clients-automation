import { writeFile } from 'fs/promises';

import { toAbsolutePath } from '../common.js';
import { getClientsConfigField } from '../config.js';
import type { Generator, GeneratorMode } from '../types.js';

/**
 * Create an on the fly openapitools.json file with default options for all generators.
 *
 * Defaults options are used to
 * - Set config path.
 */
export async function generateOpenapitools(gens: Generator[], mode: GeneratorMode): Promise<void> {
  const generators = {};
  for (const { key, client, language, ...rest } of gens) {
    const templateDir =
      language === 'javascript'
        ? `#{cwd}/templates/${language}/clients`
        : `#{cwd}/templates/${language}/`;

    generators[key] = {
      config: '#{cwd}/openapitools.json',
      gitHost: 'github.com',
      gitUserId: 'algolia',
      gitRepoId: getClientsConfigField(language, 'gitRepoId'),
      glob: `specs/bundled/${client}.yml`,
      templateDir,
      generatorName: `algolia-${mode !== 'client' ? 'cts' : language}`,
      output: `#{cwd}/${mode === 'client' ? rest.output : ''}`,
      additionalProperties: {
        language,
        client,
        mode,
      },
    };
  }

  await writeFile(
    toAbsolutePath('openapitools.json'),
    JSON.stringify(
      {
        'generator-cli': {
          version: '7.3.0',
          generators,
        },
      },
      null,
      2,
    ).concat('\n'),
  );
}

/* eslint-disable no-case-declarations */
import { CI, run } from './common';
import { getClientsConfigField, getLanguageFolder } from './config';
import { createSpinner } from './oraLog';
import type { Generator, Language } from './types';

/**
 * Build client for a language at the same time, for those who live in the same folder.
 */
async function buildClient(
  language: Language,
  gens: Generator[],
  { verbose, skipUtils }: { verbose: boolean; skipUtils: boolean }
): Promise<void> {
  const cwd = getLanguageFolder(language);
  const spinner = createSpinner(`building '${language}'`, verbose).start();
  switch (language) {
    case 'java':
      await run(`./gradle/gradlew --no-daemon -p ${cwd} assemble`, {
        verbose,
      });
      break;
    case 'php':
      break;
    case 'javascript':
      if (!CI && !skipUtils) {
        spinner.text = "building 'JavaScript' utils";

        await run('yarn build:utils', {
          verbose: true,
          cwd,
        });
      }

      spinner.text = "building 'JavaScript' clients";

      const npmNamespace = getClientsConfigField('javascript', 'npmNamespace');
      const toRun = gens
        .map(({ additionalProperties: { packageName } }) =>
          packageName === 'algoliasearch'
            ? packageName
            : `${npmNamespace}/${packageName}`
        )
        .join(',');

      await run(`yarn build:many '{${toRun}}'`, {
        verbose: true,
        cwd,
      });

      break;
    default:
  }
  spinner.succeed();
}

export async function buildClients(
  generators: Generator[],
  options: { verbose: boolean; skipUtils: boolean }
): Promise<void> {
  const langs = [...new Set(generators.map((gen) => gen.language))];
  const generatorsMap = generators.reduce((map, gen) => {
    if (!(gen.language in map)) {
      // eslint-disable-next-line no-param-reassign
      map[gen.language] = [];
    }

    map[gen.language].push(gen);

    return map;
  }, {} as Record<Language, Generator[]>);

  await Promise.all(
    langs.map((lang) => buildClient(lang, generatorsMap[lang], options))
  );
}

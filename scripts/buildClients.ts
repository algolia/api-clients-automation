/* eslint-disable no-case-declarations */
import { run } from './common.js';
import { getClientsConfigField, getLanguageFolder } from './config.js';
import { createSpinner } from './spinners.js';
import type { Generator, Language } from './types.js';

/**
 * Build client for a language at the same time, for those who live in the same folder.
 */
async function buildClient(language: Language, gens: Generator[]): Promise<void> {
  const cwd = getLanguageFolder(language);
  const spinner = createSpinner(`building '${language}'`);
  switch (language) {
    case 'csharp':
      await run('dotnet build --configuration Release', { cwd, language });
      break;
    case 'javascript':
      const npmNamespace = getClientsConfigField('javascript', 'npmNamespace');
      const packageNames = gens.map(({ additionalProperties: { packageName } }) =>
        packageName === 'algoliasearch' ? packageName : `${npmNamespace}/${packageName}`
      );

      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', { cwd });
      await run(`yarn build:many '{${packageNames.join(',')},}'`, { cwd });

      break;
    case 'java':
    case 'kotlin':
      await run(`./gradle/gradlew --no-daemon -p ${cwd} assemble`, { language });
      break;
    case 'python':
      await run('poetry build', { cwd, language });
      break;
    case 'scala':
      await run(`sbt --batch -Dsbt.server.forcestart=true +compile`, { cwd, language });
      break;
    case 'swift':
      await run(`swift build`, { cwd, language });
      break;
    default:
  }
  spinner.succeed();
}

export async function buildClients(generators: Generator[]): Promise<void> {
  const langs = [...new Set(generators.map((gen) => gen.language))];
  const generatorsMap = generators.reduce(
    (map, gen) => {
      if (!(gen.language in map)) {
        // eslint-disable-next-line no-param-reassign
        map[gen.language] = [];
      }

      map[gen.language].push(gen);

      return map;
    },
    {} as Record<Language, Generator[]>
  );

  await Promise.all(langs.map((lang) => buildClient(lang, generatorsMap[lang])));
}

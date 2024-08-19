import { run } from './common.js';
import { getLanguageFolder } from './config.js';
import { createSpinner } from './spinners.js';
import type { Generator, Language } from './types.js';

/**
 * Build code for a specific language.
 */
async function buildLanguage(
  language: Language,
  gens: Generator[],
  playground: boolean,
): Promise<void> {
  const cwd = playground ? `playground/${language}` : getLanguageFolder(language);
  const spinner = createSpinner(`building ${playground ? 'playground' : 'client'} '${language}'`);
  switch (language) {
    case 'csharp':
      await run('dotnet build --configuration Release', { cwd, language });
      break;
    case 'javascript':
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', { cwd });
      if (!playground) {
        const packageNames = gens.map(({ additionalProperties: { packageName } }) =>
          packageName === 'algoliasearch' ? packageName : `@algolia/${packageName}`,
        );
        await run(`yarn build:many '{${packageNames.join(',')},}'`, { cwd });
      }

      break;
    case 'java':
    case 'kotlin':
      await run(`./gradle/gradlew -p ${cwd} assemble`, { language });
      break;
    case 'python':
      await run('poetry build', { cwd, language });
      break;
    case 'scala':
      await run('sbt --batch -Dsbt.server.forcestart=true +compile', { cwd, language });
      break;
    case 'swift':
      // make this work in the playground
      if (!playground) {
        await run('swift build -Xswiftc -suppress-warnings', { cwd, language });
      }
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
        map[gen.language] = [];
      }

      map[gen.language].push(gen);

      return map;
    },
    {} as Record<Language, Generator[]>,
  );

  await Promise.all(langs.map((lang) => buildLanguage(lang, generatorsMap[lang], false)));
}

export async function buildPlaygrounds(languages: Language[]): Promise<void> {
  await Promise.all(languages.map((lang) => buildLanguage(lang, [], true)));
}

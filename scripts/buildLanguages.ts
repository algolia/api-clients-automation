import { existsSync } from 'node:fs';

import { run, toAbsolutePath } from './common.js';
import { getLanguageFolder } from './config.js';
import { createSpinner } from './spinners.js';
import type { Generator, Language } from './types.js';

type BuildType = 'client' | 'guides' | 'playground' | 'snippets';

/**
 * Build code for a specific language.
 */
async function buildLanguage(language: Language, gens: Generator[], buildType: BuildType): Promise<void> {
  const cwd = buildType === 'client' ? getLanguageFolder(language) : `./${buildType}/${language}`;
  const spinner = createSpinner(`building ${buildType} for '${language}'`);
  switch (language) {
    case 'csharp':
      await run('dotnet build --configuration Release', { cwd, language });
      break;
    case 'dart':
      if (buildType !== 'snippets') {
        // fix the snippets at some point
        await run('dart pub get && dart analyze', { cwd, language });
      }
      break;
    case 'go':
      await run('go build ./...', { cwd, language });
      break;
    case 'javascript':
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', { cwd, language });
      if (buildType === 'client') {
        const packageNames = gens.map(({ additionalProperties: { packageName } }) =>
          packageName === 'algoliasearch' ? packageName : `@algolia/${packageName}`,
        );
        await run(`yarn build:many '{${packageNames.join(',')},}'`, { cwd, language });
      } else if (buildType === 'playground') {
        await run('yarn build', { cwd: `${cwd}/node`, language });
      } else {
        await run('yarn tsc --noEmit', { cwd, language });
      }

      break;
    case 'java':
    case 'kotlin':
      await run(`./gradle/gradlew -p ${cwd} assemble`, { language });
      break;
    case 'php':
      // await runComposerInstall();
      // await run(
      //   `clients/algoliasearch-client-php/vendor/bin/phpstan analyse --memory-limit 512M -c clients/algoliasearch-client-php/phpstan.neon ${cwd}`,
      //   { language },
      // );
      break;
    case 'python':
      // there is no type checking for the playground or snippets
      if (buildType === 'client') {
        await run('poetry build', { cwd, language });
      }
      break;
    case 'scala':
      await run('sbt --batch -Dsbt.server.forcestart=true +compile', { cwd, language });
      break;
    case 'swift':
      // make this work in the playground
      if (buildType === 'client') {
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

  await Promise.all(langs.map((lang) => buildLanguage(lang, generatorsMap[lang], 'client')));
}

export async function buildPlaygrounds(languages: Language[]): Promise<void> {
  await Promise.all(languages.map((lang) => buildLanguage(lang, [], 'playground')));
}

export async function buildSnippets(languages: Language[]): Promise<void> {
  await Promise.all(languages.map((lang) => buildLanguage(lang, [], 'snippets')));
}

export async function buildGuides(languages: Language[]): Promise<void> {
  await Promise.all(
    languages.map((lang) => {
      if (!existsSync(toAbsolutePath(`guides/${lang}`))) {
        return Promise.resolve();
      }

      return buildLanguage(lang, [], 'guides');
    }),
  );
}

import { existsSync } from 'node:fs';

import { createClientName, run, toAbsolutePath } from './common.js';
import { getLanguageFolder } from './config.js';
import { createSpinner } from './spinners.js';
import type { Generator, Language } from './types.js';

type BuildType = 'client' | 'guides' | 'playground' | 'snippets';

function getFolder(buildType: BuildType, language: Language): string {
  switch (buildType) {
    case 'client':
      return getLanguageFolder(language);
    case 'guides':
      return `docs/guides/${language}`;
    case 'playground':
      return `playground/${language}`;
    case 'snippets':
      return `docs/snippets/${language}`;
    default:
      throw new Error(`Unknown build type: ${buildType}`);
  }
}

/**
 * Build code for a specific language.
 */
async function buildLanguage(language: Language, gens: Generator[], buildType: BuildType): Promise<void> {
  if (!gens || gens.length === 0) {
    return;
  }

  const cwd = getFolder(buildType, language);
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
      await run('go build -o /dev/null ./...', { cwd, language });
      break;
    case 'javascript':
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', { cwd, language });
      if (buildType === 'client') {
        const packageNames = gens.map(({ additionalProperties: { packageName } }) =>
          packageName === 'algoliasearch' ? packageName : `@algolia/${packageName}`,
        );
        await run(`yarn build:many '{${packageNames.join(',')},}'`, { cwd, language });
        break;
      }

      let fileNames = '';

      if (buildType !== 'guides') {
        fileNames = gens.reduce((prev, curr) => `${prev} ${createClientName(curr.client, curr.language)}.ts`, '');
      } else if (!fileNames.includes('search')) {
        // only search is needed for guides right now, if it's not being built, no need to validate guides
        break;
      }

      await run(`yarn tsc ${fileNames} --noEmit`, {
        cwd: buildType === 'playground' ? `${cwd}/node` : `${cwd}/src`,
        language,
      });

      break;
    case 'java':
    case 'kotlin':
      await run(
        `./gradle/gradlew -p ${cwd} ${buildType === 'client' || buildType === 'playground' ? 'assemble' : 'build'}`,
        { language },
      );
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
      if (buildType !== 'playground') {
        await run('swift build -Xswiftc -suppress-warnings', { cwd, language });
      }
      break;
    default:
  }
  spinner.succeed();
}

export async function buildLanguages(generators: Generator[], scope: BuildType): Promise<void> {
  const langs = [...new Set(generators.map((gen) => gen.language))];
  const generatorsMap = generators.reduce(
    (map, gen) => {
      // TODO: remove this when guides are mandatory and implemented in every clients
      if (scope === 'guides' && !existsSync(toAbsolutePath(`docs/guides/${gen.language}`))) {
        return map;
      }

      if (!(gen.language in map)) {
        map[gen.language] = [];
      }

      map[gen.language].push(gen);

      return map;
    },
    {} as Record<Language, Generator[]>,
  );

  await Promise.all(langs.map((lang) => buildLanguage(lang, generatorsMap[lang], scope)));
}

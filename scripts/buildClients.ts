import { run } from './common';
import { getLanguageFolder } from './config';
import { createSpinner } from './oraLog';
import type { Generator } from './types';

async function buildPerClient(
  { language, key, additionalProperties: { packageName } }: Generator,
  verbose: boolean
): Promise<void> {
  const spinner = createSpinner(`building ${key}`, verbose).start();
  switch (language) {
    case 'javascript':
      await run(`yarn workspace ${packageName} clean`, { verbose });
      await run(
        `yarn workspace algoliasearch-client-javascript build ${packageName}`,
        { verbose }
      );
      break;
    default:
  }
  spinner.succeed();
}

async function buildAllClients(
  language: string,
  verbose: boolean
): Promise<void> {
  const spinner = createSpinner(`building ${language}`, verbose).start();
  switch (language) {
    case 'java':
      await run(
        `./gradle/gradlew --no-daemon -p ${getLanguageFolder(
          language
        )} assemble`,
        {
          verbose,
        }
      );
      break;
    case 'php':
      break;
    default:
  }
  spinner.succeed();
}

export async function buildClients(
  generators: Generator[],
  verbose: boolean
): Promise<void> {
  for (const gen of generators) {
    // we should detect this from the config file, for example `isMutliBuild`
    if (gen.language === 'javascript') {
      await buildPerClient(gen, verbose);
    }
  }

  // for other languages, we can mutualize the build
  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    if (lang !== 'javascript') {
      await buildAllClients(lang, verbose);
    }
  }
}

import { run } from './common';
import { getLanguageFolder } from './config';
import { createSpinner } from './oraLog';
import type { Generator } from './types';

const multiBuildLanguage = new Set(['javascript']);

/**
 * Build JavaScript utils packages used in generated clients.
 */
export async function buildJSClientUtils(
  verbose: boolean,
  client?: string
): Promise<void> {
  if (!client || client === 'all') {
    const spinner = createSpinner('building JavaScript utils', verbose).start();
    await run('yarn workspace algoliasearch-client-javascript clean:utils', {
      verbose,
    });
    await run('yarn workspace algoliasearch-client-javascript build:utils', {
      verbose,
    });

    spinner.succeed();
    return;
  }

  const spinner = createSpinner(
    `building JavaScript ${client} utils`,
    verbose
  ).start();

  await run(`yarn workspace @algolia/${client} clean`, { verbose });
  await run(`yarn workspace algoliasearch-client-javascript build ${client}`, {
    verbose,
  });

  spinner.succeed();
}

/**
 * Build only a specific client for one language, used by javascript for example.
 */
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

/**
 * Build all client for a language at the same time, for those who live in the same folder.
 */
async function buildAllClients(
  language: string,
  verbose: boolean
): Promise<void> {
  const spinner = createSpinner(`building '${language}'`, verbose).start();
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
  const langs = [...new Set(generators.map((gen) => gen.language))];

  await Promise.all([
    Promise.all(
      generators
        .filter(({ language }) => multiBuildLanguage.has(language))
        .map((gen) => buildPerClient(gen, verbose))
    ),
    Promise.all(
      langs
        .filter((lang) => !multiBuildLanguage.has(lang))
        .map((lang) => buildAllClients(lang, verbose))
    ),
  ]);
}

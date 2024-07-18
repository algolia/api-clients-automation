import fsp from 'fs/promises';

import { exists, isVerbose, run, runComposerInstall, toAbsolutePath } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { createSpinner } from '../spinners.js';
import type { Language } from '../types.js';

import { startTestServer } from './testServer';
import { assertChunkWrapperValid } from './testServer/chunkWrapper.js';
import { assertValidReplaceAllObjects } from './testServer/replaceAllObjects.js';
import { assertValidTimeouts } from './testServer/timeout.js';
import { assertValidWaitForApiKey } from './testServer/waitForApiKey.js';

async function runCtsOne(
  language: Language,
  excludeE2E: boolean,
  excludeUnit: boolean,
): Promise<void> {
  const cwd = `tests/output/${language}`;

  const folders: string[] = [];
  if (!excludeE2E) {
    // check if the folder has files
    const e2eFolder = toAbsolutePath(
      `tests/output/${language}/${getTestOutputFolder(language)}/e2e`,
    );
    if (
      (await exists(e2eFolder)) &&
      (await fsp.readdir(e2eFolder)).filter((f) => f !== '__init__.py' && f !== '__pycache__')
        .length > 0
    )
      folders.push('e2e');
  }
  if (!excludeUnit) {
    folders.push('client', 'requests');
  }

  const spinner = createSpinner(`running cts for '${language}' in folder(s) ${folders.join(', ')}`);

  if (folders.length === 0) {
    spinner.succeed(`skipping '${language}' because all tests are excluded`);
    return;
  }

  const filter = (mapper: (f: string) => string): string => folders.map(mapper).join(' ');

  switch (language) {
    case 'csharp':
      await run(
        `dotnet test /clp:ErrorsOnly --filter 'Algolia.Search.Tests${folders.map((f) => `|Algolia.Search.${f}`).join('')}'`,
        { cwd, language },
      );
      break;
    case 'dart':
      await run(`dart test ${filter((f) => `test/${f}`)}`, {
        cwd,
        language,
      });
      break;
    case 'go':
      await run(
        `go test -race -count 1 ${isVerbose() ? '-v' : ''} ${filter((f) => `gotests/tests/${f}/...`)}`,
        {
          cwd,
          language,
        },
      );
      break;
    case 'java':
      await run(
        `./gradle/gradlew -p tests/output/java test --rerun ${filter((f) => `--tests 'com.algolia.${f}*'`)}`,
        { language },
      );
      break;
    case 'javascript':
      await run(
        `YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install && yarn test ${filter((f) => `dist/${f}`)}`,
        {
          cwd,
        },
      );
      break;
    case 'kotlin':
      await run('./gradle/gradlew -p tests/output/kotlin allTests', { language });
      break;
    case 'php':
      await runComposerInstall();
      await run(
        `php ./clients/algoliasearch-client-php/vendor/bin/phpunit --testdox --fail-on-warning ${filter((f) => `${cwd}/src/${f}`)}`,
        {
          language,
        },
      );
      break;
    case 'python':
      await run(
        `poetry lock --no-update && poetry install --sync && poetry run pytest -vv ${filter((f) => `tests/${f}`)}`,
        {
          cwd,
          language,
        },
      );
      break;
    case 'ruby':
      await run(`bundle install && bundle exec rake ${filter((f) => `test:${f}`)} --trace`, {
        cwd,
        language,
      });
      break;
    case 'scala':
      await run(`sbt 'testOnly ${filter((f) => `algoliasearch.${f}.*`)}'`, {
        cwd,
        language,
      });
      break;
    case 'swift':
      await run(
        `swift test -Xswiftc -suppress-warnings -v --parallel ${filter((f) => `--filter ${f}.*`)}`,
        {
          cwd,
          language,
        },
      );
      break;
    default:
      spinner.warn(`skipping unknown language '${language}' to run the CTS`);
      return;
  }
  spinner.succeed();
}

// the clients option is only used to determine if we need to start the test server, it will run the tests for all clients anyway.
export async function runCts(
  languages: Language[],
  clients: string[],
  excludeE2E: boolean,
  excludeUnit: boolean,
): Promise<void> {
  const useTestServer = !excludeUnit && (clients.includes('search') || clients.includes('all'));
  let close: () => Promise<void> = async () => {};
  if (useTestServer) {
    close = await startTestServer();
  }
  for (const lang of languages) {
    await runCtsOne(lang, excludeE2E, excludeUnit);
  }

  if (useTestServer) {
    await close();

    const skip = (lang: Language): number => (languages.includes(lang) ? 1 : 0);

    assertValidTimeouts(languages.length);
    assertChunkWrapperValid(languages.length - skip('dart') - skip('scala'));
    assertValidReplaceAllObjects(languages.length - skip('dart') - skip('scala'));
    assertValidWaitForApiKey(languages.length - skip('dart') - skip('scala'));
  }
}

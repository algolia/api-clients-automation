import { isVerbose, run, runComposerInstall } from '../common.js';
import { createSpinner } from '../spinners.js';
import type { Language } from '../types.js';

import { startTestServer } from './testServer';
import { assertChunkWrapperValid } from './testServer/chunkWrapper.js';
import { assertValidReplaceAllObjects } from './testServer/replaceAllObjects.js';
import { assertValidTimeouts } from './testServer/timeout.js';

async function runCtsOne(
  language: Language,
  excludeE2E: boolean,
  excludeUnit: boolean,
): Promise<void> {
  const cwd = `tests/output/${language}`;

  const folders: string[] = [];
  if (language !== 'dart' && language !== 'kotlin' && !excludeE2E) {
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

  switch (language) {
    case 'csharp':
      await run('dotnet test /clp:ErrorsOnly', { cwd, language });
      break;
    case 'dart':
      await run(`dart test ${folders.map((f) => `test/${f}`).join(' ')}`, {
        cwd,
        language,
      });
      break;
    case 'go':
      await run(
        `go test -race -count 1 ${isVerbose() ? '-v' : ''} ${folders.map((f) => `gotests/tests/${f}/...`).join(' ')}`,
        {
          cwd,
          language,
        },
      );
      break;
    case 'java':
      await run(
        `./gradle/gradlew -p tests/output/java test --rerun ${folders.map((f) => `--tests 'com.algolia.${f}*'`).join(' ')}`,
        { language },
      );
      break;
    case 'javascript':
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install && yarn test', {
        cwd,
      });
      break;
    case 'kotlin':
      await run('./gradle/gradlew -p tests/output/kotlin allTests', { language });
      break;
    case 'php':
      await runComposerInstall();
      await run(
        `php ./clients/algoliasearch-client-php/vendor/bin/phpunit --testdox --fail-on-warning ${folders.map((f) => `${cwd}/src/${f}`).join(' ')}`,
        {
          language,
        },
      );
      break;
    case 'python':
      await run(
        `poetry lock --no-update && poetry install --sync && poetry run pytest -vv ${folders.map((f) => `tests/${f}`).join(' ')}`,
        {
          cwd,
          language,
        },
      );
      break;
    case 'ruby':
      await run(`bundle install && bundle exec rake test --trace ${folders.join(' ')}`, {
        cwd,
        language,
      });
      break;
    case 'scala':
      await run(`sbt testonly ${folders.map((f) => `algoliasearch.${f}`).join(' ')}`, {
        cwd,
        language,
      });
      break;
    case 'swift':
      await run('swift test -Xswiftc -suppress-warnings -q --parallel', {
        cwd,
        language,
      });
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
  }
}

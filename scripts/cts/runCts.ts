import * as fsp from 'fs/promises';

import { run, runComposerInstall, toAbsolutePath } from '../common.js';
import { createSpinner } from '../spinners.js';
import type { Language } from '../types.js';

import { getTimeoutCounter, startTestServer } from './testServer.js';

async function runCtsOne(language: string): Promise<void> {
  const spinner = createSpinner(`running cts for '${language}'`);
  const cwd = `tests/output/${language}`;
  switch (language) {
    case 'csharp':
      await run('dotnet test /clp:ErrorsOnly', { cwd, language });
      break;
    case 'dart':
      await run('dart test', { cwd, language });
      break;
    case 'go':
      await run('go test -race -count 1 ./...', {
        cwd,
        language,
      });
      break;
    case 'java':
      // I guess this is a bug from gradle and can be removed once it's fixed, it doesn't affect the cache.
      await fsp.rm(toAbsolutePath('tests/output/java/.gradle'), { recursive: true, force: true });
      await run('./gradle/gradlew --no-daemon -p tests/output/java test', { language });
      break;
    case 'javascript':
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install && yarn test', {
        cwd,
      });
      break;

    case 'kotlin':
      await run('./gradle/gradlew --no-daemon -p tests/output/kotlin allTests', { language });
      break;
    case 'php': {
      await runComposerInstall();
      await run(`php ./clients/algoliasearch-client-php/vendor/bin/phpunit ${cwd}`, {
        language,
      });
      break;
    }
    case 'python':
      await run('poetry lock --no-update && poetry install --sync && poetry run pytest -vv', {
        cwd,
        language,
      });
      break;
    case 'ruby':
      await run(`bundle install && bundle exec rake test --trace`, {
        cwd,
        language,
      });
      break;
    case 'scala':
      await run('sbt test', { cwd, language });
      break;
    case 'swift':
      await run('rm -rf .build && swift test -Xswiftc -suppress-warnings -q --parallel', {
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
export async function runCts(languages: Language[], clients: string[]): Promise<void> {
  const useTestServer = clients.includes('search') || clients.includes('all');
  let close: () => Promise<void> = async () => {};
  if (useTestServer) {
    close = await startTestServer();
  }
  for (const lang of languages) {
    await runCtsOne(lang);
  }

  if (useTestServer) {
    await close();

    if (languages.length !== getTimeoutCounter()) {
      throw new Error(
        `Expected ${languages.length} timeout(s), got ${getTimeoutCounter()} instead.`,
      );
    }
  }
}

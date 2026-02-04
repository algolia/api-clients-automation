import fsp from 'fs/promises';

import { exists, isVerbose, run, runComposerInstall, toAbsolutePath } from '../common.ts';
import { getSwiftBuildFolder, getTestOutputFolder } from '../config.ts';
import { createSpinner } from '../spinners.ts';
import type { Language } from '../types.ts';

import { assertValidAccountCopyIndex } from './testServer/accountCopyIndex.ts';
import { printBenchmarkReport } from './testServer/benchmark.ts';
import { assertChunkWrapperValid } from './testServer/chunkWrapper.ts';
import { assertNeverCalledServerWasNotCalled, assertValidErrors } from './testServer/error.ts';
import { startTestServer } from './testServer/index.ts';
import { assertPushMockValid } from './testServer/pushMock.ts';
import { assertValidReplaceAllObjects } from './testServer/replaceAllObjects.ts';
import { assertValidReplaceAllObjectsFailed } from './testServer/replaceAllObjectsFailed.ts';
import { assertValidReplaceAllObjectsScopes } from './testServer/replaceAllObjectsScopes.ts';
import { assertValidReplaceAllObjectsWithTransformation } from './testServer/replaceAllObjectsWithTransformation.ts';
import { assertSuccessServerCalled } from './testServer/success.ts';
import { assertValidTimeouts } from './testServer/timeout.ts';
import { assertValidWaitForApiKey } from './testServer/waitFor.ts';

export type CTSType = 'benchmark' | 'client' | 'e2e' | 'requests';

async function buildFilter(language: Language, suites: Record<CTSType, boolean>): Promise<CTSType[]> {
  const folders: CTSType[] = [];
  for (const [suite, include] of Object.entries(suites)) {
    // check if the folder has files in it
    const folder = toAbsolutePath(`tests/output/${language}/${getTestOutputFolder(language)}/${suite}`);
    if (
      include &&
      (await exists(folder)) &&
      (await fsp.readdir(folder)).filter((f) => f !== '__init__.py' && f !== '__pycache__').length > 0
    ) {
      folders.push(suite as CTSType);
    }
  }

  return folders;
}

async function runCtsOne(language: Language, suites: Record<CTSType, boolean>): Promise<void> {
  const cwd = `tests/output/${language}`;
  const folders = await buildFilter(language, suites);
  const spinner = createSpinner(`running cts for '${language}' in folder(s) ${folders.join(', ')}`);

  if (folders.length === 0) {
    spinner.succeed(`skipping '${language}' because all tests are excluded`);
    return;
  }

  const filter = (mapper: (f: string) => string): string => folders.map(mapper).join(' ');

  switch (language) {
    case 'csharp':
      await run(
        `dotnet test src/Algolia.Search.Tests.csproj /clp:ErrorsOnly --filter 'Algolia.Search.Tests${folders.map((f) => `|Algolia.Search.${f}`).join('')}'`,
        { cwd, language },
      );
      // run manual timeout tests
      if (suites.client) {
        await run(
          'dotnet test /clp:ErrorsOnly ../../../clients/algoliasearch-client-csharp/algoliasearch/Algolia.Search.csproj --filter "FullyQualifiedName~TimeoutIntegration"',
          { cwd, language },
        );
      }
      break;
    case 'dart':
      await run(`dart test ${filter((f) => `test/${f}`)}`, {
        cwd,
        language,
      });
      break;
    case 'go':
      await run(
        `go test ${suites.benchmark ? '' : '-race'} -count 1 ${isVerbose() ? '-v' : ''} ${filter((f) => `gotests/tests/${f}/...`)}`,
        {
          cwd,
          language,
        },
      );
      break;
    case 'java':
      await run(`./gradle/gradlew -p tests/output/java test --rerun ${filter((f) => `--tests 'com.algolia.${f}*'`)}`, {
        language,
      });
      break;
    case 'javascript':
      await run(`YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install && yarn test ${filter((f) => `src/${f}`)}`, {
        cwd,
        language,
      });
      break;
    case 'kotlin':
      await run(`./gradle/gradlew -p tests/output/kotlin jvmTest ${filter((f) => `--tests 'com.algolia.${f}*'`)}`, {
        language,
      });
      break;
    case 'php':
      await runComposerInstall();
      await run(
        `php ./clients/algoliasearch-client-php/vendor/bin/phpunit --testdox --fail-on-warning ${filter((f) => `${cwd}/src/${f}`)}`,
        {
          language,
        },
      );
      // run manual timeout tests
      if (suites.client) {
        await run(
          'php ./clients/algoliasearch-client-php/vendor/bin/phpunit --testdox --fail-on-warning ./clients/algoliasearch-client-php/tests/TimeoutIntegrationTest.php',
          {
            language,
          },
        );
      }
      break;
    case 'python':
      await run(`poetry lock && poetry sync && poetry run pytest -vv ${filter((f) => `tests/${f}`)}`, {
        cwd,
        language,
      });
      // run manual timeout tests
      if (suites.client) {
        await run(
          'poetry run pytest -vv ../../../clients/algoliasearch-client-python/algoliasearch/tests/test_timeout_integration.py',
          {
            cwd,
            language,
          },
        );
      }
      break;
    case 'ruby':
      await run(`bundle install && bundle exec rake ${filter((f) => `test:${f}`)} --trace`, {
        cwd,
        language,
      });
      // run manual timeout tests
      if (suites.client) {
        await run(
          'bundle exec ruby -Ilib ../../../clients/algoliasearch-client-ruby/lib/algolia/tests/timeout_integration_test.rb',
          {
            cwd,
            language,
          },
        );
      }
      break;
    case 'scala':
      await run(`sbt 'testOnly ${filter((f) => `algoliasearch.${f}.*`)}'`, {
        cwd,
        language,
      });
      break;
    case 'swift':
      await run(
        `swift test -Xswiftc -suppress-warnings --build-path ${getSwiftBuildFolder()} --parallel ${filter((f) => `--filter "${f}.*"`)}`,
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
  suites: Record<CTSType, boolean>,
): Promise<void> {
  const withBenchmarkServer =
    suites.benchmark && (clients.includes('search') || clients.includes('all') || languages.includes('swift'));
  const withClientServer = suites.client;
  const closeTestServer = await startTestServer({
    ...suites,
    benchmark: withBenchmarkServer,
    client: withClientServer,
  });

  for (const lang of languages) {
    await runCtsOne(lang, suites);
  }

  await closeTestServer();

  if (withClientServer && (clients.includes('search') || clients.includes('all') || process.platform === 'darwin')) {
    // the macos swift CI also runs the clients tests
    const skip = (lang: Language): number => (languages.includes(lang) ? 1 : 0);
    const only = skip;

    assertValidErrors(languages.length);
    assertValidTimeouts(languages.length);
    assertNeverCalledServerWasNotCalled();
    assertSuccessServerCalled(languages.length);
    assertChunkWrapperValid(languages.length - skip('dart'));
    assertValidReplaceAllObjects(languages.length - skip('dart'));
    assertValidReplaceAllObjectsWithTransformation(
      only('javascript') + only('go') + only('python') + only('java') + only('php') + only('csharp'),
    );
    assertValidAccountCopyIndex(only('javascript'));
    assertValidReplaceAllObjectsFailed(languages.length - skip('dart'));
    assertValidReplaceAllObjectsScopes(languages.length - skip('dart'));
    assertValidWaitForApiKey(languages.length - skip('dart'));
    assertPushMockValid(only('javascript') + only('go') + only('python') + only('java') + only('php') + only('csharp'));
  }
  if (withBenchmarkServer) {
    printBenchmarkReport();
  }
}

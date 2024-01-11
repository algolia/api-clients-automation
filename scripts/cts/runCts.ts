import { run, runComposerInstall } from '../common.js';
import { createSpinner } from '../spinners.js';

async function runCtsOne(language: string): Promise<void> {
  const spinner = createSpinner(`running cts for '${language}'`);
  switch (language) {
    case 'javascript':
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install && yarn test', {
        cwd: 'tests/output/javascript',
      });
      break;
    case 'java':
      await run('./gradle/gradlew --no-daemon -p tests/output/java test', { language });
      break;
    case 'php': {
      await runComposerInstall();
      await run(`php ./clients/algoliasearch-client-php/vendor/bin/phpunit tests/output/php`, {
        language,
      });
      break;
    }
    case 'kotlin':
      await run('./gradle/gradlew --no-daemon -p tests/output/kotlin allTests', { language });
      break;
    case 'go':
      await run('go test -count 1 ./...', {
        cwd: 'tests/output/go',
        language,
      });
      break;
    case 'dart':
      await run('dart test', { cwd: 'tests/output/dart', language });
      break;
    case 'python':
      await run('poetry lock --no-update && poetry install --sync && poetry run pytest -vv', {
        cwd: 'tests/output/python',
        language,
      });
      break;
    case 'ruby':
      await run(`bundle install && bundle exec rake test --trace`, {
        cwd: 'tests/output/ruby',
        language,
      });
      break;
    case 'scala':
      await run('sbt test', { cwd: 'tests/output/scala', language });
      break;
    case 'csharp':
      await run('dotnet test', { cwd: 'tests/output/csharp', language });
      break;
    default:
      spinner.warn(`skipping unknown language '${language}' to run the CTS`);
      return;
  }
  spinner.succeed();
}

export async function runCts(languages: string[]): Promise<void> {
  for (const lang of languages) {
    await runCtsOne(lang);
  }
}

import { run, runComposerInstall } from '../common.js';
import { createSpinner } from '../spinners.js';

async function runCtsOne(language: string): Promise<void> {
  const spinner = createSpinner(`running cts for '${language}'`);
  const cwd = `tests/output/${language}`;
  switch (language) {
    case 'csharp':
      await run('dotnet test', { cwd, language });
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

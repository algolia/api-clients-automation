import type { AllLanguage } from './cli/utils.js';
import { createClientName, run, runComposerInstall } from './common.js';

export async function playground({
  language,
  client,
}: {
  language: AllLanguage;
  client: string;
}): Promise<void> {
  switch (language) {
    case 'go':
      await run(`go run . --client ${client}`, { cwd: 'playground/go', language });
      break;
    case 'javascript':
      await run(`yarn workspace javascript-playground start:${client}`);
      break;
    case 'java':
      await run(
        `./gradle/gradlew -p playground/java -PmainClass=com.algolia.playground.${createClientName(
          client,
          'java'
        )} run`,
        { language }
      );
      break;
    case 'kotlin':
      await run(
        `./gradle/gradlew -p playground/kotlin -PmainClass=com.algolia.playground.${createClientName(
          client,
          'kotlin'
        )}Kt run`,
        { language }
      );
      break;
    case 'php':
      await runComposerInstall();
      await run(`php ${client}.php`, { cwd: 'playground/php/src', language });
      break;
    case 'python':
      await run(`poetry install --sync && poetry run ${client}`, {
        cwd: 'playground/python',
        language,
      });
      break;
    case 'ruby':
      await run(`bundle install && bundle exec ruby ${client}.rb`, {
        cwd: 'playground/ruby',
        language,
      });
      break;
    case 'csharp':
      await run(`dotnet run --property WarningLevel=0 --project Playground ${client}`, {
        cwd: 'playground/csharp',
        language,
      });
      break;
    case 'scala':
      // run scala playground
      break;
    default:
  }
}

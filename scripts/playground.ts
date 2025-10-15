import type { AllLanguage } from './cli/utils.ts';
import { createClientName, run, runComposerInstall, toAbsolutePath } from './common.ts';
import { getLanguageFolder } from './config.ts';

export async function playground({ language, client }: { language: AllLanguage; client: string }): Promise<void> {
  switch (language) {
    case 'go':
      await run(`go run . --client ${client}`, { cwd: 'playground/go', language });
      break;
    case 'dart':
      await run(`dart pub get && dart run lib/${client}.dart`, {
        cwd: 'playground/dart',
        language,
      });
      break;
    case 'javascript':
      await run(`yarn workspace javascript-playground start ${client}`, { language });
      break;
    case 'java':
      await run(
        `./gradle/gradlew -p playground/java -PmainClass=com.algolia.playground.${createClientName(
          client,
          'java',
        )} run`,
        { language },
      );
      break;
    case 'kotlin':
      await run(`./gradle/gradlew -p playground/kotlin run -Pclient=${createClientName(client, 'kotlin')}`, {
        language,
      });
      break;
    case 'php':
      await runComposerInstall();
      await run(`php ${client}.php`, { cwd: 'playground/php/src', language });
      break;
    case 'python':
      await run(`poetry lock && poetry sync && poetry run ${client}`, {
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
      // Scala needs a whitespace in the shell command to know which class it must execute
      await run(`sbt \\"runMain ${createClientName(client, 'scala')}\\"`, { cwd: 'playground/scala', language });
      break;
    case 'swift':
      const buildFolder = toAbsolutePath(getLanguageFolder(language) + '/.build');
      await run(`swift run --build-path ${buildFolder} ${client}-playground`, { cwd: 'playground/swift', language });
      break;
    default:
  }
}

import { run, runComposerInstall } from './common.js';
import { createSpinner } from './spinners.js';

export async function formatter(language: string, cwd: string): Promise<void> {
  const spinner = createSpinner(`running formatter for '${language}' in '${cwd}'`);
  switch (language) {
    case 'csharp':
      if (cwd.includes('tests') || cwd.includes('snippets')) {
        await run('dotnet format --no-restore && dotnet tool restore && dotnet dotnet-csharpier .', {
          cwd,
          language,
        });
      } else {
        await run('dotnet format', { cwd, language });
      }
      break;
    case 'dart':
      if (cwd.includes('tests') || cwd.includes('snippets')) {
        await run('dart pub get && dart fix --apply && dart format .', {
          cwd,
          language,
        });
      } else {
        await run('dart pub get && melos bs && melos build --no-select && melos lint', {
          cwd,
          language,
        });
      }
      break;
    case 'go':
      await run('goimports -w . && golangci-lint run --fix', { cwd, language });
      break;
    case 'java':
      await run(
        'find . -path ./.gradle -prune -o -type f -name "*.java" | xargs java --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED -jar /tmp/java-formatter.jar -r && yarn prettier --no-error-on-unmatched-pattern --write **/*.java',
        { cwd, language },
      );
      break;
    case 'javascript':
      await run(`yarn eslint --ext=ts,json ${cwd} --fix --no-error-on-unmatched-pattern`, { language });
      break;
    case 'kotlin':
      await run(`./gradle/gradlew -p ${cwd} spotlessApply`, { language });
      break;
    case 'php':
      await runComposerInstall();
      await run(
        `php clients/algoliasearch-client-php/vendor/bin/php-cs-fixer fix ${cwd} --rules=@PhpCsFixer --using-cache=no --allow-risky=yes`,
        { language },
      );
      break;
    case 'python':
      await run(
        'poetry lock --no-update && poetry install --sync && pip freeze > requirements.txt && poetry run ruff check --fix --unsafe-fixes && poetry run ruff format',
        { cwd, language },
      );
      if (!cwd.includes('tests')) {
        await run('poetry run pyright', { cwd, language });
      }
      break;
    case 'ruby':
      await run('bundle install', { cwd, language });
      await run('rubyfmt -i -- .', { cwd, language });
      break;
    case 'scala':
      await run('sbt -Dsbt.server.forcestart=true scalafmtAll scalafmtSbt', {
        cwd,
        language,
      });
      break;
    case 'swift':
      await run('swiftformat .', { cwd, language });
      break;
    default:
      spinner.warn(`no formatter for '${language}'`);
      return;
  }
  spinner.succeed();
}

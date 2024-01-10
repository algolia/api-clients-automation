import { run, runComposerInstall } from './common.js';
import { createSpinner } from './spinners.js';

export async function formatter(language: string, folder: string): Promise<void> {
  const spinner = createSpinner(`running formatter for '${language}' in '${folder}'`);
  switch (language) {
    case 'javascript':
      await run('yarn && yarn eslint --ext=ts,json . --fix --no-error-on-unmatched-pattern', {
        cwd: folder,
      });
      break;
    case 'java':
      await run(`find ${folder} -type f -name "*.java" | xargs java --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED \
        -jar /tmp/java-formatter.jar -r \
        && yarn prettier --no-error-on-unmatched-pattern --write ${folder}/**/*.java`);
      break;
    case 'php':
      await runComposerInstall();
      await run(
        `PHP_CS_FIXER_IGNORE_ENV=1 php clients/algoliasearch-client-php/vendor/bin/php-cs-fixer fix ${folder} --verbose --rules=@PhpCsFixer --using-cache=no --allow-risky=yes`
      );
      break;
    case 'go':
      await run('goimports -w . && golangci-lint run --fix', { cwd: folder });
      break;
    case 'kotlin':
      await run(`./gradle/gradlew -p ${folder} spotlessApply`);
      break;
    case 'csharp':
      await run('dotnet format', { cwd: folder });
      break;
    case 'dart':
      if (folder.includes('tests')) {
        await run('dart pub get && dart fix --apply && dart format .', { cwd: folder });
      } else {
        await run('dart pub get && melos bs && melos build --no-select && melos lint', {
          cwd: folder,
        });
      }
      break;
    case 'python':
      await run(
        'poetry lock --no-update && poetry install --sync && pip freeze > requirements.txt && poetry run autopep8 -r --in-place --aggressive . && poetry run autoflake -r --remove-unused-variables --remove-all-unused-imports --in-place . && poetry run isort . && poetry run black . && poetry run flake8 --ignore=E501,W503 .',
        { cwd: folder }
      );
      break;
    case 'ruby':
      await run('bundle install && bundle exec rubocop -a --fail-level W', { cwd: folder });
      break;
    case 'scala':
      await run('sbt -Dsbt.server.forcestart=true scalafmtAll scalafmtSbt', { cwd: folder });
      break;
    default:
      spinner.warn(`no formatter for '${language}'`);
      return;
  }
  spinner.succeed();
}

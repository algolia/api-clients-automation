import { CI, run, runComposerUpdate } from './common';
import { createSpinner } from './oraLog';

export async function formatter(
  language: string,
  folder: string,
  verbose = false
): Promise<void> {
  const spinner = createSpinner(
    { text: `formatting '${language}'`, indent: 4 },
    verbose
  ).start();
  switch (language) {
    case 'javascript':
      await run(
        `yarn eslint --ext=ts,json ${folder} --fix --no-error-on-unmatched-pattern`,
        { verbose }
      );
      break;
    case 'java':
      await run(
        `find ${folder} -type f -name "*.java" | xargs java --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED \
        --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED \
        -jar /tmp/java-formatter.jar -r \
        && yarn prettier --write ${folder}`,
        { verbose }
      );
      break;
    case 'php':
      await runComposerUpdate(verbose);
      await run(
        `yarn run prettier ${folder} --write \
            && PHP_CS_FIXER_IGNORE_ENV=1 ${
              CI ? 'php' : 'php8'
            } clients/algoliasearch-client-php/vendor/bin/php-cs-fixer fix ${folder} --using-cache=no --allow-risky=yes`,
        { verbose }
      );
      break;
    case 'go':
      await run(`go fmt ./...`, { verbose, cwd: folder });
      break;
    default:
      return;
  }
  spinner.succeed();
}

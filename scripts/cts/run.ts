import { CI, run } from '../common';

export async function runCts(
  language: string,
  verbose: boolean
): Promise<void> {
  switch (language) {
    case 'javascript':
      await run('yarn workspace javascript-tests test', { verbose });
      break;
    case 'java':
      await run('./gradle/gradlew --no-daemon -p tests/output/java test', {
        verbose,
      });
      break;
    case 'php': {
      let php = 'php8';
      if (CI) php = 'php';

      await run(
        `${php} ./clients/algoliasearch-client-php/vendor/bin/phpunit ./`,
        { verbose }
      );
      break;
    }
    default:
    // echo "Skipping unknown language $LANGUAGE to run the CTS"
  }
}

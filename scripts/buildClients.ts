import { run } from './common';
import { createSpinner } from './oraLog';
import type { Generator } from './types';

async function buildClient(
  { language, additionalProperties: { packageName } }: Generator,
  verbose: boolean
): Promise<void> {
  const spinner = createSpinner(`building ${language}`, verbose).start();
  switch (language) {
    case 'javascript':
      await run(`yarn workspace ${packageName} clean`, { verbose });
      await run(
        `yarn workspace algoliasearch-client-javascript build ${packageName}`,
        { verbose }
      );
      break;
    case 'java':
      await run(
        `./gradle/gradlew --no-daemon -p clients/${packageName} assemble`,
        {
          verbose,
        }
      );
      break;
    case 'php':
      break;
    default:
  }
  spinner.succeed();
}

export async function buildClients(
  generators: Generator[],
  verbose: boolean
): Promise<void> {
  for (const gen of generators) {
    await buildClient(gen, verbose);
  }
}

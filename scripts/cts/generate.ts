import { getTestOutputFolder } from '../config';
import { formatter } from '../formatter';
import { createSpinner } from '../oraLog';
import type { Generator } from '../types';

import { generateRequestsTests } from './methods/requests/generate';

async function ctsGenerate(
  generator: Generator,
  verbose: boolean
): Promise<void> {
  const { language, key } = generator;
  const spinner = createSpinner(`generating cts for ${key}`, verbose).start();
  switch (language) {
    case 'javascript':
      await generateRequestsTests(generator);
      break;
    case 'java':
      break;
    case 'php':
      break;
    default:
  }
  spinner.succeed();
}

export async function ctsGenerateMany(
  generators: Generator[],
  verbose: boolean
): Promise<void> {
  for (const gen of generators) {
    await ctsGenerate(gen, verbose);
  }

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    await formatter(lang, getTestOutputFolder(lang), verbose);
  }
}

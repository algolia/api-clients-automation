import { buildSpecs } from '../buildSpecs';
import { buildCustomGenerators, CI, run, toAbsolutePath } from '../common';
import { getTestOutputFolder } from '../config';
import { formatter } from '../formatter';
import { createSpinner } from '../oraLog';
import { generateOpenapitools } from '../pre-gen';
import type { Generator } from '../types';

async function ctsGenerate(gen: Generator, verbose: boolean): Promise<void> {
  const spinner = createSpinner(
    `generating CTS for ${gen.key}`,
    verbose
  ).start();
  await run(
    `yarn openapi-generator-cli --custom-generator=generators/build/libs/algolia-java-openapi-generator-1.0.0.jar generate \
     -g algolia-cts -i specs/bundled/${gen.client}.yml --additional-properties="language=${gen.language},client=${gen.client}"`,
    { verbose }
  );
  spinner.succeed();
}

export async function ctsGenerateMany(
  generators: Generator[],
  verbose: boolean
): Promise<void> {
  if (!CI) {
    const clients = [...new Set(generators.map((gen) => gen.client))];
    await buildSpecs(clients, 'yml', verbose, true);
  }

  await generateOpenapitools(generators);
  await buildCustomGenerators(verbose);

  for (const gen of generators) {
    if (!getTestOutputFolder(gen.language)) {
      continue;
    }
    // Remove this once we have CTS for ingestion
    if (gen.key === 'javascript-ingestion') {
      continue;
    }
    await ctsGenerate(gen, verbose);
  }

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    if (!getTestOutputFolder(lang)) {
      continue;
    }
    await formatter(lang, toAbsolutePath(`tests/output/${lang}`), verbose);
  }
}

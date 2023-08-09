import { buildSpecs } from '../buildSpecs.js';
import { buildCustomGenerators, CI, run } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { generateOpenapitools } from '../pre-gen/index.js';
import { createSpinner } from '../spinners.js';
import type { Generator } from '../types.js';

async function csGenerate(gen: Generator): Promise<void> {
  const spinner = createSpinner(`generating CS for ${gen.key}`);

  await run(
    `yarn openapi-generator-cli --custom-generator=generators/build/libs/algolia-java-openapi-generator-1.0.0.jar generate \
     -g algolia-cs -i specs/bundled/${gen.client}.yml --additional-properties="language=${gen.language},client=${gen.client}"`
  );
  spinner.succeed();
}

export async function csGenerateMany(generators: Generator[]): Promise<void> {
  if (!CI) {
    const clients = [...new Set(generators.map((gen) => gen.client))];
    await buildSpecs(clients, 'yml', true);
  }

  await generateOpenapitools(generators);
  await buildCustomGenerators();

  for (const gen of generators) {
    if (!getTestOutputFolder(gen.language)) {
      continue;
    }
    await csGenerate(gen);
  }
}

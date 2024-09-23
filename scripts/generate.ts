import { callGenerator, setupAndGen } from './common.ts';
import { getLanguageFolder } from './config.ts';
import { formatter } from './formatter.ts';
import { removeExistingCodegen } from './pre-gen/index.ts';
import type { Generator } from './types.ts';

async function preGen(gen: Generator): Promise<void> {
  await removeExistingCodegen(gen);
}

export async function generate(generators: Generator[]): Promise<void> {
  await setupAndGen(generators, 'client', async (gen) => {
    await preGen(gen);
    await callGenerator(gen);
  });

  for (const lang of [...new Set(generators.map((gen) => gen.language))]) {
    await formatter(lang, getLanguageFolder(lang));
  }
}

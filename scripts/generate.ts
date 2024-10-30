import { callGenerator, run, setupAndGen } from './common.js';
import { getLanguageFolder } from './config.js';
import { formatter } from './formatter.js';
import { removeExistingCodegen } from './pre-gen/index.js';
import type { Generator } from './types.js';

async function preGen(gen: Generator): Promise<void> {
  await removeExistingCodegen(gen);
}

export async function generate(generators: Generator[]): Promise<void> {
  await setupAndGen(generators, 'client', async (gen) => {
    await preGen(gen);
    await callGenerator(gen);
  });

  for (const lang of [...new Set(generators.map((gen) => gen.language))]) {
    await run(`sudo chmod 777 -R ${getLanguageFolder(lang)}`);
    await formatter(lang, getLanguageFolder(lang));
  }
}

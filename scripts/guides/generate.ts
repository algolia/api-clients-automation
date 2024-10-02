import { existsSync } from 'node:fs';

import { callGenerator, run, setupAndGen, toAbsolutePath } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { formatter } from '../formatter.js';
import type { Generator } from '../types.js';

export async function guidesGenerateMany(generators: Generator[]): Promise<void> {
  generators = generators.filter((gen) => existsSync(toAbsolutePath(`templates/${gen.language}/guides/${gen.client}`)));

  await setupAndGen(generators, 'guides', async (gen) => {
    if (getTestOutputFolder(gen.language)) {
      await callGenerator(gen);
    }
  });

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    const guidesPath = `guides/${lang}`;
    if (!getTestOutputFolder(lang)) {
      continue;
    }

    if (lang === 'javascript') {
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', {
        cwd: 'guides/javascript',
      });
    }

    if (lang === 'go') {
      await run('go mod tidy', {
        cwd: 'guides/go',
        language: 'go',
      });
    }

    await formatter(lang, guidesPath);
  }
}

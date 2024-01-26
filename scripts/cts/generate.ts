import { callCTSGenerator, run, setupAndGen } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { formatter } from '../formatter.js';
import type { Generator } from '../types.js';

export async function ctsGenerateMany(generators: Generator[]): Promise<void> {
  await setupAndGen(generators, async (gen) => {
    if (getTestOutputFolder(gen.language)) {
      await callCTSGenerator(gen, 'tests');
    }
  });

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    if (!getTestOutputFolder(lang)) {
      continue;
    }

    if (lang === 'javascript') {
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', {
        cwd: 'tests/output/javascript',
      });
    }

    if (lang === 'go') {
      await run('go mod tidy', {
        cwd: 'tests/output/go',
        language: 'go',
      });
    }

    await formatter(lang, `tests/output/${lang}`);
  }
}

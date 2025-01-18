import { callGenerator, run, setupAndGen } from '../common.ts';
import { getTestOutputFolder } from '../config.ts';
import { formatter } from '../formatter.ts';
import type { Generator } from '../types.ts';

export async function ctsGenerateMany(generators: Generator[], languageVersion = ''): Promise<void> {
  await setupAndGen(
    generators,
    'tests',
    async (gen) => {
      if (getTestOutputFolder(gen.language)) {
        await callGenerator(gen);
      }
    },
    {
      languageVersion,
    },
  );

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

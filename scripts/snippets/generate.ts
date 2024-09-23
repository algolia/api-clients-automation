import { callGenerator, exists, run, setupAndGen, toAbsolutePath } from '../common.ts';
import { getTestOutputFolder } from '../config.ts';
import { formatter } from '../formatter.ts';
import type { Generator } from '../types.ts';

export async function snippetsGenerateMany(generators: Generator[]): Promise<void> {
  await setupAndGen(generators, 'snippets', async (gen) => {
    if (getTestOutputFolder(gen.language)) {
      await callGenerator(gen);
    }
  });

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    if (!getTestOutputFolder(lang)) {
      continue;
    }

    if (lang === 'javascript') {
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', {
        cwd: 'snippets/javascript',
      });
    }

    if (lang === 'go') {
      await run('go mod tidy', {
        cwd: 'snippets/go',
        language: 'go',
      });
    }

    const snippetsPath = `snippets/${lang}`;
    if (await exists(toAbsolutePath(snippetsPath))) {
      await formatter(lang, snippetsPath);
    }
  }
}

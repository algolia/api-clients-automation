import { callCTSGenerator, exists, run, setupAndGen, toAbsolutePath } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { formatter } from '../formatter.js';
import type { Generator } from '../types.js';

export async function snippetsGenerateMany(generators: Generator[]): Promise<void> {
  await setupAndGen(generators, async (gen) => {
    if (getTestOutputFolder(gen.language)) {
      await callCTSGenerator(gen, 'snippets');
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

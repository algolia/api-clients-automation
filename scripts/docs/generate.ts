import { callGenerator, exists, run, setupAndGen, toAbsolutePath } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { formatter } from '../formatter.js';
import type { Generator } from '../types.js';

export async function docsGenerateMany(generators: Generator[], scope: 'guides' | 'snippets'): Promise<void> {
  await setupAndGen(generators, scope, async (gen) => {
    if (getTestOutputFolder(gen.language)) {
      await callGenerator(gen);
    }
  });

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    if (!getTestOutputFolder(lang)) {
      continue;
    }

    const docsPath = `docs/${scope}/${lang}`;

    if (lang === 'javascript') {
      await run('YARN_ENABLE_IMMUTABLE_INSTALLS=false yarn install', {
        cwd: docsPath,
      });
    }

    if (lang === 'go') {
      await run('go mod tidy', {
        cwd: docsPath,
        language: 'go',
      });
    }

    if (await exists(toAbsolutePath(docsPath))) {
      await formatter(lang, docsPath);
    }
  }
}

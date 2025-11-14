import { callGenerator, exists, isWSL, run, setupAndGen, toAbsolutePath } from '../common.ts';
import { getTestOutputFolder } from '../config.ts';
import { formatter } from '../formatter.ts';
import type { Generator } from '../types.ts';

export async function docsGenerateMany(
  generators: Generator[],
  scope: 'guides' | 'snippets',
  withDebugger: boolean,
  languageVersion = '',
): Promise<void> {
  await setupAndGen(
    generators,
    scope,
    async (gen) => {
      if (getTestOutputFolder(gen.language)) {
        await callGenerator(gen, withDebugger);
      }
    },
    { languageVersion },
  );

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
      if (isWSL()) {
        await run(`sudo chmod 777 -R ${docsPath}`);
      }
      await formatter(lang, docsPath);
    }
  }
}

import { run, setupAndGen } from './common.js';
import { getLanguageFolder } from './config.js';
import { formatter } from './formatter.js';
import { removeExistingCodegen } from './pre-gen/index.js';
import { createSpinner } from './spinners.js';
import type { Generator } from './types.js';

async function preGen(gen: Generator): Promise<void> {
  await removeExistingCodegen(gen);
}

export async function generate(generators: Generator[]): Promise<void> {
  await setupAndGen(generators, async (gen) => {
    const spinner = createSpinner(`pre-gen ${gen.key}`);
    await preGen(gen);

    spinner.text = `generating ${gen.key}`;
    await run(
      `yarn openapi-generator-cli --custom-generator=generators/build/libs/algolia-java-openapi-generator-1.0.0.jar generate --generator-key ${gen.key}`,
      { language: 'java' },
    );

    spinner.succeed();
  });

  for (const lang of [...new Set(generators.map((gen) => gen.language))]) {
    let folder = getLanguageFolder(lang);

    // We have scoped output folder for JavaScript which allow us to
    // avoid linting the whole client, only the part that changed
    if (lang === 'javascript') {
      folder = generators.reduce((folders, gen) => {
        if (gen.language === 'javascript') {
          return `${folders} ${gen.output}`;
        }

        return folders;
      }, '');
    }

    await formatter(lang, folder);
  }
}

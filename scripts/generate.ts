import { buildSpecs } from './buildSpecs';
import { CI, getLanguageFolder, run, runIfExists } from './common';
import { formatter } from './formatter';
import { createSpinner } from './oraLog';
import { setHostsOptions } from './pre-gen/setHostsOptions';
import type { Generator } from './types';

async function preGen(
  { language, client, key, output }: Generator,
  verbose?: boolean
): Promise<void> {
  const folder = output.replace('#{cwd}/', '');
  await runIfExists(`./scripts/pre-gen/${language}.sh`, `${folder} ${key}`, {
    verbose,
  });

  await setHostsOptions({ client, key });
}

async function generateClient(
  { key }: Generator,
  verbose?: boolean
): Promise<void> {
  await run(`yarn openapi-generator-cli generate --generator-key ${key}`, {
    verbose,
  });
}

async function postGen(
  { language, key, output }: Generator,
  verbose?: boolean
): Promise<void> {
  const folder = output.replace('#{cwd}/', '');
  await runIfExists(`./scripts/post-gen/${language}.sh`, `${folder} ${key}`, {
    verbose,
  });
}

export async function generate(
  generators: Generator[],
  verbose: boolean
): Promise<void> {
  if (!CI) {
    const clients = [...new Set(generators.map((gen) => gen.client))];
    await buildSpecs(clients, 'yml', verbose, true);
  }

  for (const gen of generators) {
    const spinner = createSpinner(`pre-gen ${gen.key}`, verbose).start();
    await preGen(gen, verbose);

    spinner.text = `generation ${gen.key}`;
    await generateClient(gen, verbose);

    spinner.text = `post-gen ${gen.key}`;
    await postGen(gen, verbose);

    spinner.succeed();
  }

  const langs = [...new Set(generators.map((gen) => gen.language))];
  for (const lang of langs) {
    const spinner = createSpinner(`formatting ${lang}`, verbose).start();
    await formatter(lang, getLanguageFolder(lang), verbose);

    spinner.succeed();
  }
}

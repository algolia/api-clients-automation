import fsp from 'fs/promises';

import { hashElement } from 'folder-hash';

import { exists, run, toAbsolutePath } from './common';
import { createSpinner } from './oraLog';

async function buildSpec(
  client: string,
  outputFormat: string,
  verbose: boolean,
  useCache: boolean
): Promise<void> {
  const cacheFile = toAbsolutePath(`specs/dist/${client}.cache`);
  if (useCache) {
    // check if file and cache exist
    const spinner = createSpinner(
      `checking cache for ${client}`,
      verbose
    ).start();
    if (await exists(toAbsolutePath(`specs/bundled/${client}.yml`))) {
      const hash = (await hashElement(toAbsolutePath(`specs/${client}`))).hash;
      // compare with stored cache
      if (await exists(cacheFile)) {
        const storedHash = (await fsp.readFile(cacheFile)).toString();
        if (storedHash === hash) {
          spinner.succeed(
            `skipped building ${client} spec because the files did not change`
          );
          return;
        }
      }
    }

    spinner.info(`cache not found for ${client} spec`);
  }

  const spinner = createSpinner(`linting ${client} spec`, verbose).start();
  await run(`yarn specs:lint ${client}`, { verbose });

  spinner.text = `building ${client} spec`;
  await run(
    `yarn openapi bundle specs/${client}/spec.yml -o specs/bundled/${client}.${outputFormat} --ext ${outputFormat}`,
    { verbose }
  );

  spinner.text = `validate ${client} spec`;
  await run(`yarn openapi lint specs/bundled/${client}.${outputFormat}`, {
    verbose,
  });

  spinner.text = `storing ${client} cache`;
  const hash = (await hashElement(toAbsolutePath(`specs/${client}`))).hash;
  await fsp.writeFile(cacheFile, hash);

  spinner.succeed();
}

export async function buildSpecs(
  clients: string[],
  outputFormat: 'json' | 'yml',
  verbose: boolean,
  useCache: boolean
): Promise<void> {
  await fsp.mkdir(toAbsolutePath('specs/dist'), { recursive: true });

  for (const client of clients) {
    await buildSpec(client, outputFormat, verbose, useCache);
  }
}

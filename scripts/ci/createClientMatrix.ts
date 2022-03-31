/* eslint-disable no-console */
import { GENERATORS, run } from '../common';
import type { Language } from '../types';

import type { BaseCreateMatrix, Client, Matrix } from './types';

type CreateClientMatrix = BaseCreateMatrix & {
  language: Language;
};

export async function createClientMatrix({
  language,
  baseChanged,
  baseBranch,
}: CreateClientMatrix): Promise<void> {
  const matrix: Matrix<Client> = { client: [] };

  for (const [generatorKey, generatorOptions] of Object.entries(GENERATORS)) {
    if (
      generatorKey.startsWith(`${language}-`) === false ||
      // `algoliasearch` is an aggregation of clients
      generatorOptions.client === 'algoliasearch'
    ) {
      continue;
    }

    const folder = generatorOptions.output.replace('#{cwd}', '');
    const specChanges = await run(
      `git diff --shortstat ${baseBranch}..HEAD -- specs/${generatorOptions.client} | wc -l | tr -d ' '`
    );
    const clientChanges = await run(
      `git diff --shortstat ${baseBranch}..HEAD -- ${folder} | wc -l | tr -d ' '`
    );

    if (clientChanges === '0' && specChanges === '0' && baseChanged === false) {
      continue;
    }

    const matchedGenerator: Client = {
      name: generatorOptions.client,
      folder,
    };

    if (language === 'php') {
      matchedGenerator.config =
        generatorOptions.additionalProperties.configClassname;
      matchedGenerator.api =
        generatorOptions.additionalProperties.configClassname.replace(
          'Config',
          'Api'
        );
    }

    matrix.client.push(matchedGenerator);
  }

  // client cannot be empty or the matrix will fail
  console.log(
    matrix.client.length === 0
      ? '{"client":["no-run"]}'
      : JSON.stringify(matrix)
  );
}

const args = process.argv.slice(2);

if (require.main === module) {
  if (args.length !== 3) {
    throw new Error(
      'Incorrect number of parameters. Usage: `yarn workspace scripts createClientMatrix LANGUAGE BASE_CHANGED BASE_BRANCH`'
    );
  }

  createClientMatrix({
    language: args[0] as Language,
    baseChanged: args[1] === 'true',
    baseBranch: args[2],
  });
}

/* eslint-disable no-console */
import { CLIENTS, run } from '../common';

import type { BaseCreateMatrix, Matrix } from './types';

export async function createSpecMatrix({
  baseChanged,
  baseBranch,
}: BaseCreateMatrix): Promise<void> {
  const matrix: Matrix<string> = { client: [] };

  for (const client of CLIENTS) {
    const specChanges = await run(
      `git diff --shortstat ${baseBranch}..HEAD -- specs/${client} | wc -l | tr -d ' '`
    );

    if (specChanges === '0' && baseChanged === false) {
      continue;
    }

    matrix.client.push(client);
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
  if (args.length !== 2) {
    throw new Error(
      'Incorrect number of parameters. Usage: `yarn workspace scripts createClientMatrix LANGUAGE BASE_CHANGED BASE_BRANCH`'
    );
  }

  createSpecMatrix({
    baseChanged: args[0] === 'true',
    baseBranch: args[1],
  });
}

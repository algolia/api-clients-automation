import { CLIENTS, GENERATORS } from '../common';
import type { Language } from '../types';

import { getNbGitDiff } from './utils';

type CreateMatrix = {
  baseChanged: boolean;
  baseBranch: string;
  language?: Language;
};

type BaseMatrix = {
  name: string;
  path: string;
};

type ClientMatrix = BaseMatrix & {
  spec: string;
  config?: string;
  api?: string;
};

type SpecMatrix = BaseMatrix & {
  bundledPath: string;
};

type Matrix<TMatrix> = {
  client: TMatrix[];
};

// This empty matrix is required by the CI, otherwise it throws
const EMPTY_MATRIX = JSON.stringify({ client: ['no-run'] });

async function getClientMatrix({
  language,
  baseBranch,
  baseChanged,
}: CreateMatrix): Promise<Matrix<ClientMatrix>> {
  const matrix: Matrix<ClientMatrix> = { client: [] };

  for (const {
    client,
    output,
    additionalProperties,
    ...options
  } of Object.values(GENERATORS)) {
    if (
      options.language !== language ||
      // `algoliasearch` is an aggregation of clients
      client === 'algoliasearch'
    ) {
      continue;
    }

    const specChanges = await getNbGitDiff({
      branch: baseBranch,
      path: `specs/${client}`,
    });
    const clientChanges = await getNbGitDiff({
      branch: baseBranch,
      path: output,
    });

    if (clientChanges === 0 && specChanges === 0 && !baseChanged) {
      continue;
    }

    const matchedGenerator: ClientMatrix = {
      name: client,
      path: output,
      spec: client === 'algoliasearchLite' ? 'search-lite' : client,
    };

    // Extra informations for the PHP matrix in order to properly scope the
    // GitHub action cache
    if (language === 'php') {
      matchedGenerator.config = additionalProperties.configClassname;
      matchedGenerator.api = additionalProperties.configClassname.replace(
        'Config',
        'Api'
      );
    }

    matrix.client.push(matchedGenerator);
  }

  return matrix;
}

async function getSpecMatrix({
  baseBranch,
  baseChanged,
}: CreateMatrix): Promise<Matrix<SpecMatrix>> {
  const matrix: Matrix<SpecMatrix> = { client: [] };

  for (const client of CLIENTS) {
    const specChanges = await getNbGitDiff({
      branch: baseBranch,
      path: `specs/${client}`,
    });

    if (specChanges === 0 && !baseChanged) {
      continue;
    }

    matrix.client.push({
      name: client,
      path: `specs/${client}`,
      bundledPath: `specs/bundled/${client}.yml`,
    });

    // We push an extra entry for the search-lite version
    if (client === 'search') {
      matrix.client.push({
        name: client,
        path: `specs/${client}`,
        bundledPath: `specs/bundled/${client}-lite.yml`,
      });
    }
  }

  return matrix;
}

/**
 * Creates a matrix for the CI jobs based on the files that changed.
 */
async function createMatrix(opts: CreateMatrix): Promise<void> {
  const matrix = opts.language
    ? await getClientMatrix(opts)
    : await getSpecMatrix(opts);

  // eslint-disable-next-line no-console
  console.log(
    matrix.client.length === 0 ? EMPTY_MATRIX : JSON.stringify(matrix)
  );
}

if (require.main === module) {
  const args = process.argv.slice(2);

  createMatrix({
    baseChanged: args[0] === 'true',
    baseBranch: args[1],
    language: args[2] as Language,
  });
}

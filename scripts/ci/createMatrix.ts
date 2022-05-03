import crypto from 'crypto';

import { hashElement } from 'folder-hash';

import { toAbsolutePath, CLIENTS, GENERATORS } from '../common';
import { getLanguageApiFolder, getLanguageModelFolder } from '../config';
import { camelize, createClientName } from '../cts/utils';

import type { CreateMatrix, ClientMatrix, SpecMatrix, Matrix } from './types';
import { getNbGitDiff } from './utils';

// This empty matrix is required by the CI, otherwise it throws
const EMPTY_MATRIX = JSON.stringify({ client: ['no-run'] });

/**
 * Compute a cache key to be used in the CI.
 *
 * The `paths` parameter is an array of string, that needs to be treated as dependencies.
 */
async function computeCacheKey(
  baseName: string,
  paths: string[]
): Promise<string> {
  let hash = '';

  for (const path of paths) {
    const pathHash = await hashElement(toAbsolutePath(path), {
      encoding: 'hex',
      files: {
        include: ['**'],
      },
    });

    hash += `-${pathHash}`;
  }

  // Files common to the cache key of every jobs
  const ghHash = await hashElement(toAbsolutePath('.github'), {
    encoding: 'hex',
    folders: { exclude: ['ISSUE_TEMPLATE'] },
    files: { include: ['*.yml', '.cache_version'] },
  });
  const scriptsHash = await hashElement(toAbsolutePath('scripts'), {
    encoding: 'hex',
    folders: { exclude: ['docker', '__tests__'] },
  });
  const configHash = await hashElement(toAbsolutePath('.'), {
    encoding: 'hex',
    folders: { include: ['config'] },
    files: { include: ['openapitools.json', 'clients.config.json'] },
  });

  return `${baseName}-${crypto
    .createHash('sha256')
    .update(`${ghHash}-${scriptsHash}-${configHash}-${hash}`)
    .digest('hex')}`;
}

async function getClientMatrix({
  baseBranch,
  baseChanged,
}: CreateMatrix): Promise<Matrix<ClientMatrix>> {
  const matrix: Matrix<ClientMatrix> = { client: [] };

  for (const { language, client, output } of Object.values(GENERATORS)) {
    // `algoliasearch` is an aggregation of generated clients.
    if (client === 'algoliasearch') {
      continue;
    }

    const bundledSpec = client === 'algoliasearch-lite' ? 'search' : client;
    const specChanges = await getNbGitDiff({
      branch: baseBranch,
      path: `specs/${bundledSpec}`,
    });
    const clientChanges = await getNbGitDiff({
      branch: baseBranch,
      path: output,
    });

    // No changes found, we don't put this job in the matrix
    if (clientChanges === 0 && specChanges === 0 && !baseChanged) {
      continue;
    }

    const clientName = createClientName(client, language);
    const pathToApi = `${output}/${getLanguageApiFolder(language)}`;
    const pathToModel = `${output}/${getLanguageModelFolder(language)}`;
    const bundledSpecPath = `specs/bundled/${bundledSpec}.yml`;

    const clientMatrix: ClientMatrix = {
      language,
      name: client,
      path: output,

      configName: `${clientName}Config`,
      apiName: `${clientName}Client`,

      capitalizedClientName: clientName,
      camelizedClientName: camelize(client),

      apiPath: pathToApi,
      modelPath: pathToModel,
      bundledSpecPath,

      shouldBuild: language !== 'php',
      storeFolder: language === 'javascript',

      cacheKey: await computeCacheKey(`client-${client}`, [
        bundledSpecPath,
        `templates/${language}`,
        `generators/src`,
      ]),
    };

    // While JavaScript have it's own package per client, other language have
    // API and models in folders common to all clients, so we scope it.
    switch (language) {
      case 'java':
        clientMatrix.apiPath = `${pathToApi}/${clientMatrix.apiName}.java`;
        clientMatrix.modelPath = `${pathToModel}/${clientMatrix.camelizedClientName}/`;
        break;
      case 'php':
        clientMatrix.apiPath = `${pathToApi}/${clientMatrix.apiName}.php`;
        clientMatrix.modelPath = `${pathToModel}/${clientMatrix.capitalizedClientName}/`;
        break;
      default:
        break;
    }

    matrix.client.push(clientMatrix);
  }

  return matrix;
}

async function getSpecMatrix({
  baseBranch,
  baseChanged,
}: CreateMatrix): Promise<Matrix<SpecMatrix>> {
  const matrix: Matrix<SpecMatrix> = { client: [] };

  for (const client of CLIENTS) {
    // The `algoliasearch-lite` spec is created by the `search` spec
    const bundledSpecName = client === 'algoliasearch-lite' ? 'search' : client;
    const specChanges = await getNbGitDiff({
      branch: baseBranch,
      path: `specs/${bundledSpecName}`,
    });

    // No changes found, we don't put this job in the matrix
    if (specChanges === 0 && !baseChanged) {
      continue;
    }

    const path = `specs/${bundledSpecName}`;

    matrix.client.push({
      name: client,
      path,
      bundledPath: `specs/bundled/${client}.yml`,
      cacheKey: await computeCacheKey(`spec-${client}`, ['specs/common', path]),
    });
  }

  return matrix;
}

/**
 * Creates a matrix for the CI jobs based on the files that changed.
 */
async function createMatrix(opts: CreateMatrix): Promise<void> {
  const matrix = opts.forClients
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
    forClients: args[2] === 'clients',
  });
}

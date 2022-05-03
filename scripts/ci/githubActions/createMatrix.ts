import { CLIENTS, GENERATORS } from '../../common';
import { getLanguageApiFolder, getLanguageModelFolder } from '../../config';
import { camelize, createClientName } from '../../cts/utils';
import { getNbGitDiff } from '../utils';

import { DEPENDENCIES } from './setRunVariables';
import type { CreateMatrix, ClientMatrix, SpecMatrix, Matrix } from './types';
import { computeCacheKey, isBaseChanged } from './utils';

// This empty matrix is required by the CI, otherwise it throws
const EMPTY_MATRIX = JSON.stringify({ client: ['no-run'] });

/**
 * List of dependencies based on the language, inherited from `./setRunVariables.ts` in a more dynamic form.
 */
const MATRIX_DEPENDENCIES = {
  common: {
    GITHUB_ACTIONS_CHANGED: DEPENDENCIES.GITHUB_ACTIONS_CHANGED,
    SCRIPTS_CHANGED: DEPENDENCIES.SCRIPTS_CHANGED,
    COMMON_SPECS_CHANGED: DEPENDENCIES.COMMON_SPECS_CHANGED,
  },
  clients: {
    common: {
      GENERATORS_CHANGED: DEPENDENCIES.GENERATORS_CHANGED,
    },
    javascript: {
      JS_UTILS_CHANGED: DEPENDENCIES.JS_UTILS_CHANGED,
      JS_TEMPLATE_CHANGED: DEPENDENCIES.JS_TEMPLATE_CHANGED,
    },
    php: {
      PHP_TEMPLATE_CHANGED: DEPENDENCIES.PHP_TEMPLATE_CHANGED,
    },
    java: {
      JAVA_TEMPLATE_CHANGED: DEPENDENCIES.JAVA_TEMPLATE_CHANGED,
    },
  },
};

async function getClientMatrix(
  baseBranch: string
): Promise<Matrix<ClientMatrix>> {
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
    const baseChanged = await isBaseChanged(baseBranch, {
      ...MATRIX_DEPENDENCIES.common,
      ...MATRIX_DEPENDENCIES.clients.common,
      ...MATRIX_DEPENDENCIES.clients[language],
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

async function getSpecMatrix(baseBranch: string): Promise<Matrix<SpecMatrix>> {
  const matrix: Matrix<SpecMatrix> = { client: [] };

  for (const client of CLIENTS) {
    // The `algoliasearch-lite` spec is created by the `search` spec
    const bundledSpecName = client === 'algoliasearch-lite' ? 'search' : client;
    const specChanges = await getNbGitDiff({
      branch: baseBranch,
      path: `specs/${bundledSpecName}`,
    });
    const baseChanged = await isBaseChanged(
      baseBranch,
      MATRIX_DEPENDENCIES.common
    );

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
    ? await getClientMatrix(opts.baseBranch)
    : await getSpecMatrix(opts.baseBranch);

  // eslint-disable-next-line no-console
  console.log(
    matrix.client.length === 0 ? EMPTY_MATRIX : JSON.stringify(matrix)
  );
}

if (require.main === module) {
  const args = process.argv.slice(2);

  createMatrix({
    baseBranch: args[0],
    forClients: args[1] === 'clients',
  });
}

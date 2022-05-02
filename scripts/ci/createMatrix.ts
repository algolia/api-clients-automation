import { CLIENTS, GENERATORS } from '../common';
import { getLanguageApiFolder, getLanguageModelFolder } from '../config';
import { camelize, createClientName } from '../cts/utils';

import { getNbGitDiff } from './utils';

type CreateMatrix = {
  /**
   * `baseChanged` is computed in `.github/actions/setup/action.yml`.
   */
  baseChanged: boolean;
  /**
   * The name of the branch of reference.
   */
  baseBranch: string;
  /**
   * `true` means we generated the matrix for the `clients` job, `false` for the specs.
   */
  forClients?: boolean;
};

type BaseMatrix = {
  /**
   * Name of the client.
   */
  name: string;
  /**
   * Path to the file/folder being handled.
   */
  path: string;
};

type ClientMatrix = BaseMatrix & {
  /**
   * The client language.
   */
  language: string;

  /**
   * The client name plus `Config` appended. With the casing corresponding to the language.
   */
  configName: string;
  /**
   * The client name plus `Client` appended. With the casing corresponding to the language.
   */
  apiName: string;

  /**
   * The capitalized name of the client.
   */
  capitalizedClientName: string;
  /**
   * The camelized name of the client.
   */
  camelizedClientName: string;

  /**
   * Path to the `API` file/folder of the client, based on the language.
   */
  apiPath: string;
  /**
   * Path to the `Model` file/folder of the client, based on the language.
   */
  modelPath: string;
  /**
   * Path to the bundled spec used to generated the client.
   */
  bundledSpecPath: string;

  /**
   * Wether to run the build action or not.
   *
   * E.g. It's false for `PHP` as it does not have a build process.
   */
  shouldBuild: boolean;

  /**
   * Wether to store the whole client folder or only the API/Model files.
   *
   * JavaScript outputs clients in their own folder, so we can store everything.
   *
   * PHP or Java will output generated files in a common `algoliasearch` API/Model folder,
   * so we only store the relevant files.
   */
  storeFolder: boolean;
};

type SpecMatrix = BaseMatrix & {
  /**
   * The path of the bundled spec file.
   */
  bundledPath: string;
};

type Matrix<TMatrix> = {
  client: TMatrix[];
};

// This empty matrix is required by the CI, otherwise it throws
const EMPTY_MATRIX = JSON.stringify({ client: ['no-run'] });

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
      bundledSpecPath: `specs/bundled/${bundledSpec}.yml`,

      shouldBuild: language !== 'php',
      storeFolder: language === 'javascript',
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
    const bundledSpec = client === 'algoliasearch-lite' ? 'search' : client;
    const specChanges = await getNbGitDiff({
      branch: baseBranch,
      path: `specs/${bundledSpec}`,
    });

    // No changes found, we don't put this job in the matrix
    if (specChanges === 0 && !baseChanged) {
      continue;
    }

    matrix.client.push({
      name: client,
      path: `specs/${bundledSpec}`,
      bundledPath: `specs/bundled/${client}.yml`,
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

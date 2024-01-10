/* eslint-disable no-case-declarations */
import * as core from '@actions/core';

import { CLIENTS, createClientName, GENERATORS, LANGUAGES } from '../../common.js';
import {
  getClientsConfigField,
  getLanguageFolder,
  getTestExtension,
  getTestOutputFolder,
} from '../../config.js';

import { getVersionFileForLanguage, COMMON_DEPENDENCIES, DEPENDENCIES } from './setRunVariables.js';
import type { ClientMatrix, CreateMatrix, Matrix, SpecMatrix, ToRunMatrix } from './types.js';
import { computeCacheKey, isBaseChanged } from './utils.js';

// This empty matrix is required by the CI, otherwise it throws
const EMPTY_MATRIX = { client: ['no-run'] };

async function createClientMatrix(baseBranch: string): Promise<void> {
  const matrix: Record<string, ToRunMatrix> = {};
  const commonDependenciesChanged = await isBaseChanged(baseBranch, COMMON_DEPENDENCIES);

  // iterate over every generators to see what changed
  for (const { language, client, output } of Object.values(GENERATORS)) {
    const bundledSpec = client === 'algoliasearch' ? 'search' : client;

    if (!commonDependenciesChanged) {
      const key = `${language.toUpperCase()}_CLIENT_CHANGED`;
      const languageDependencies = {
        [key]: DEPENDENCIES[key],
      };

      // We will check if dependencies have changed for each clients of each languages:
      //   - language specific dependencies
      //   - common dependencies of every clients
      //   - output of the client
      //   - specs that generated the client
      const dependenciesChanged = await isBaseChanged(baseBranch, {
        ...languageDependencies,
        output: [output],
        specs: [`specs/${bundledSpec}`],
      });

      // No changes found, we don't put this job in the matrix
      if (!dependenciesChanged) {
        continue;
      }
    }

    // if this language is not yet in the matrix, we initialize it with the client-specific files
    if (!(language in matrix)) {
      const cacheToCompute: string[] = [getVersionFileForLanguage(language)];

      for (const [, dependency] of Object.entries(COMMON_DEPENDENCIES)) {
        cacheToCompute.push(...dependency);
      }

      matrix[language] = {
        path: getLanguageFolder(language),
        toRun: [],
        cacheToCompute,
      };
    }

    matrix[language].toRun.push(client);
    matrix[language].cacheToCompute.push(`specs/${bundledSpec}`);
  }

  const clientMatrix: Matrix<ClientMatrix> = {
    client: [],
  };

  // Now that we've built a map of what changed, we can create the matrix for the CI
  for (const language of LANGUAGES) {
    if (!matrix[language] || matrix[language].toRun.length === 0) {
      continue;
    }

    const testsRootFolder = `tests/output/${language}`;
    const testsOutputBase = `${testsRootFolder}/${getTestOutputFolder(language)}`;
    // We delete tests to ensure the CI only run tests against what changed.
    const testsToDelete = `${testsOutputBase}/client ${testsOutputBase}/requests`;

    // We only store tests of clients that ran during this job, the rest stay as is
    let testsToStore = matrix[language].toRun
      .map((client) => {
        const clientName = createClientName(client, language);
        const extension = getTestExtension(language);

        return `${testsOutputBase}/client/${clientName}${extension} ${testsOutputBase}/requests/${clientName}${extension}`;
      })
      .join(' ');

    const snippetsToStore = `snippets/${language}`;

    const toRun = matrix[language].toRun.join(' ');
    let buildCommand = `yarn cli build clients ${language} ${toRun}`;

    // some clients have specific files required for testing
    switch (language) {
      case 'java':
        testsToStore = `${testsToStore} ${testsRootFolder}/build.gradle`;
        break;
      case 'go':
        testsToStore = `${testsToStore} ${testsOutputBase}/requests/common.go ${testsRootFolder}/go.sum ${testsRootFolder}/go.mod`;
        break;
      case 'javascript':
        const npmNamespace = getClientsConfigField('javascript', 'npmNamespace');
        const packageNames = matrix[language].toRun.map((client) => {
          const packageName = GENERATORS[`${language}-${client}`].additionalProperties.packageName;

          // `algoliasearch` is not preceded by `@algolia`
          return client === 'algoliasearch' ? packageName : `${npmNamespace}/${packageName}`;
        });

        buildCommand = `cd ${matrix[language].path} && yarn build:many '{${packageNames.join(
          ','
        )},}'`;

        testsToStore = `${testsToStore} ${testsRootFolder}/package.json`;
        break;
      case 'python':
        testsToStore = `${testsToStore} ${testsRootFolder}/poetry.lock`;
        break;
      case 'ruby':
        testsToStore = `${testsToStore} ${testsRootFolder}/Gemfile.lock`;
        break;
      default:
        break;
    }

    clientMatrix.client.push({
      language,
      path: matrix[language].path,
      toRun,
      buildCommand,
      cacheKey: await computeCacheKey(`clients-${language}`, matrix[language].cacheToCompute),
      testsRootFolder,
      testsToDelete,
      testsToStore,
      snippetsToStore,
    });
  }

  const javascriptData = clientMatrix.client.find((c) => c.language === 'javascript');
  if (javascriptData) {
    core.setOutput('JAVASCRIPT_DATA', JSON.stringify(javascriptData));
    core.setOutput('RUN_GEN_JAVASCRIPT', true);
    clientMatrix.client = clientMatrix.client.filter((c) => c.language !== 'javascript');
  }

  const shouldRun = clientMatrix.client.length > 0;

  core.setOutput('RUN_GEN', shouldRun);
  core.setOutput('GEN_MATRIX', JSON.stringify(shouldRun ? clientMatrix : EMPTY_MATRIX));
}

async function createSpecMatrix(): Promise<void> {
  const matrix: ToRunMatrix = {
    path: 'specs/bundled',
    toRun: [],
    cacheToCompute: ['specs/common'],
  };

  for (const client of CLIENTS) {
    // The `algoliasearch` spec is created by the `search` spec.
    const bundledSpecName = client === 'algoliasearch' ? 'search' : client;

    matrix.toRun.push(client);
    matrix.cacheToCompute.push(`specs/${bundledSpecName}`);
  }

  const ciMatrix: SpecMatrix = {
    bundledPath: matrix.path,
    toRun: matrix.toRun.join(' '),
    cacheKey: await computeCacheKey('specs', matrix.cacheToCompute),
  };

  core.setOutput('MATRIX', JSON.stringify(ciMatrix));
}

/**
 * Creates a matrix for the CI jobs based on the files that changed.
 */
async function createMatrix(opts: CreateMatrix): Promise<void> {
  if (opts.forClients) {
    return await createClientMatrix(opts.baseBranch);
  }

  return await createSpecMatrix();
}

if (import.meta.url.endsWith(process.argv[1])) {
  const args = process.argv.slice(2);

  createMatrix({
    baseBranch: args[0],
    forClients: args[1] === 'clients',
  });
}

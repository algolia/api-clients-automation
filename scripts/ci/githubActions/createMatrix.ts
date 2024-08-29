/* eslint-disable no-case-declarations */
import fsp from 'fs/promises';

import { setOutput } from '@actions/core';

import { CLIENTS, createClientName, exists, GENERATORS, LANGUAGES, toAbsolutePath } from '../../common.js';
import { getLanguageFolder, getTestExtension, getTestOutputFolder, getClientsConfigField } from '../../config.js';

import type { ClientMatrix, CreateMatrix, ToRunMatrix } from './types.js';
import { COMMON_DEPENDENCIES, DEPENDENCIES, isBaseChanged } from './utils.js';

// This empty matrix is required by the CI, otherwise it throws
const EMPTY_MATRIX = { client: ['no-run'] };

async function createClientMatrix(baseBranch: string): Promise<void> {
  const matrix: Record<string, ToRunMatrix> = {};
  // PRs have origin/* as a baseBranch, main is always running from a specific commit
  const commonDependenciesChanged =
    !baseBranch.startsWith('origin/') || (await isBaseChanged(baseBranch, COMMON_DEPENDENCIES));

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
      //   - specs that generated the client
      //   - output of the client
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

    // if no common has changed and the current language is therefore not yet in the matrix,
    // we initialize it with the client-specific files
    if (!(language in matrix)) {
      matrix[language] = {
        path: getLanguageFolder(language),
        toRun: [],
      };
    }

    matrix[language].toRun.push(client);
  }

  const clientMatrix: ClientMatrix = {
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
    let testsToDelete = `${testsOutputBase}/client ${testsOutputBase}/requests ${testsOutputBase}/e2e`;
    if (language !== 'swift') {
      // Swift requires the benchmark folder to have files in it
      testsToDelete += ` ${testsOutputBase}/benchmark`;
    }

    // We only store tests of clients that ran during this job, the rest stay as is
    let testsToStore = matrix[language].toRun
      .map((client) => {
        const clientName = createClientName(client, language);
        const extension = getTestExtension(language);

        return `${testsOutputBase}/client/${clientName}${extension} ${testsOutputBase}/requests/${clientName}${extension} ${testsOutputBase}/e2e/${clientName}${extension} ${testsOutputBase}/benchmark/${clientName}${extension} ${testsRootFolder}/benchmarkResult.json`;
      })
      .join(' ');

    const snippetsToStore = `snippets/${language}`;
    const toRun = matrix[language].toRun.join(' ');
    let buildCommand = `yarn cli build clients ${language} ${toRun}`;
    const versionFile = toAbsolutePath(`config/.${language}-version`);
    let version: string | undefined = undefined;
    if (await exists(versionFile)) {
      version = (await fsp.readFile(versionFile)).toString();
    }
    const isMainVersion = true;
    // some clients have specific files required for testing
    switch (language) {
      case 'csharp':
        testsToStore = `${testsToStore} ${testsRootFolder}/global.json`;
        break;
      case 'go':
        testsToStore = `${testsToStore} ${testsOutputBase}/echo.go ${testsRootFolder}/go.sum ${testsRootFolder}/go.mod`;
        break;
      case 'java':
        testsToStore = `${testsToStore} ${testsRootFolder}/build.gradle`;
        break;
      case 'javascript':
        const packageNames = matrix[language].toRun.map((client) => {
          const packageName = GENERATORS[`${language}-${client}`].additionalProperties.packageName;

          // `algoliasearch` is not preceded by `@algolia`
          return client === 'algoliasearch' ? packageName : `@algolia/${packageName}`;
        });

        buildCommand = `cd ${matrix[language].path} && yarn build:many '{${packageNames.join(',')},}'`;

        testsToStore = `${testsToStore} ${testsRootFolder}/package.json`;
        break;
      case 'python':
        testsToStore = `${testsToStore} ${testsRootFolder}/poetry.lock ${testsRootFolder}/requirements.txt`;
        break;
      case 'ruby':
        testsToStore = `${testsToStore} ${testsRootFolder}/Gemfile.lock`;
        break;
      case 'swift':
        testsToStore = `${testsToStore} ${testsRootFolder}/Package.swift`;
        break;
      case 'php':
        if (version) {
          version = version.substring(0, version.length - 2);
        }
        break;
      default:
        break;
    }

    clientMatrix.client.push({
      language,
      path: matrix[language].path,
      toRun,
      buildCommand,
      testsRootFolder,
      testsToDelete,
      testsToStore,
      snippetsToStore,
      version,
      isMainVersion,
    });
  }

  // If there are updates for the Swift client, we allow ourselves to run the CTS on macOS
  const swiftData = clientMatrix.client.find((c) => c.language === 'swift');
  if (swiftData) {
    setOutput('SWIFT_DATA', JSON.stringify(swiftData));
    setOutput('RUN_MACOS_SWIFT_CTS', true);
  }

  // If there are updates for the Kotlin client, we allow ourselves to run the build step on macOS
  const runKotlin = clientMatrix.client.find((c) => c.language === 'kotlin');
  if (runKotlin) {
    setOutput('RUN_MACOS_KOTLIN_BUILD', true);
  }

  const javascriptData = clientMatrix.client.find((c) => c.language === 'javascript');
  if (javascriptData) {
    setOutput('JAVASCRIPT_DATA', JSON.stringify(javascriptData));
    setOutput('RUN_GEN_JAVASCRIPT', true);
    clientMatrix.client = clientMatrix.client.filter((c) => c.language !== 'javascript');
  }

  // if python is there on a release commit, we want that every supported version runs
  const pythonData = clientMatrix.client.filter((c) => c.language === 'python');
  if (pythonData.length > 0) {
    const supportedPythonVersions: string[] = getClientsConfigField('python', 'supportedPythonVersions');
    supportedPythonVersions.forEach((supportedPythonVersion, idx) => {
      clientMatrix.client.push({
        ...pythonData[0],
        version: supportedPythonVersion,
        isMainVersion: idx === supportedPythonVersions.length - 1,
      });
    });
  }

  const shouldRun = clientMatrix.client.length > 0;

  setOutput('RUN_GEN', shouldRun);
  setOutput('GEN_MATRIX', JSON.stringify(shouldRun ? clientMatrix : EMPTY_MATRIX));
}

function createSpecMatrix(): void {
  setOutput(
    'MATRIX',
    JSON.stringify({
      bundledPath: 'specs/bundled',
      toRun: CLIENTS.join(' '),
    }),
  );
}

/**
 * Creates a matrix for the CI jobs based on the files that changed.
 */
async function createMatrix(opts: CreateMatrix): Promise<void> {
  if (opts.forClients) {
    return await createClientMatrix(opts.baseBranch);
  }

  return createSpecMatrix();
}

if (import.meta.url.endsWith(process.argv[1])) {
  const args = process.argv.slice(2);

  createMatrix({
    baseBranch: args[0],
    forClients: args[1] === 'clients',
  });
}

/* eslint-disable no-case-declarations */
import fsp from 'fs/promises';

import { setOutput } from '@actions/core';

import { CLIENTS, createClientName, exists, GENERATORS, LANGUAGES, toAbsolutePath } from '../../common.ts';
import { getLanguageFolder, getTestExtension, getTestOutputFolder, getClientsConfigField } from '../../config.ts';

import type { ClientMatrix, CreateMatrix, ToRunMatrix } from './types.ts';
import { COMMON_DEPENDENCIES, DEPENDENCIES, isBaseChanged } from './utils.ts';

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
    const toRun = matrix[language].toRun.join(' ');
    const versionFile = toAbsolutePath(
      language === 'javascript'
        ? '.nvmrc'
        : `config/.${language === 'kotlin' || language === 'scala' ? 'java' : language}-version`,
    );
    let version: string | undefined = undefined;
    if (await exists(versionFile)) {
      version = (await fsp.readFile(versionFile)).toString();
    }

    const languageMatrix = {
      language,
      path: matrix[language].path,
      toRun,
      buildCommand: `yarn cli build clients ${language} ${toRun}`,
      testsRootFolder,
      // We delete tests to ensure the CI only run tests against what changed.
      testsToDelete: `${testsOutputBase}/client ${testsOutputBase}/requests ${testsOutputBase}/e2e ${testsOutputBase}/benchmark`,
      testsToStore: matrix[language].toRun
        .map((client) => {
          const clientName = createClientName(client, language);
          const extension = getTestExtension(language);

          return `${testsOutputBase}/client/${clientName}${extension} ${testsOutputBase}/requests/${clientName}${extension} ${testsOutputBase}/e2e/${clientName}${extension} ${testsOutputBase}/benchmark/${clientName}${extension} ${testsRootFolder}/benchmarkResult.json`;
        })
        .join(' '),
      snippetsToStore: `snippets/${language}`,
      version,
      isMainVersion: true,
    };

    // language specific options
    switch (language) {
      case 'csharp':
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsRootFolder}/global.json`;
        break;
      case 'go':
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsOutputBase}/echo.go ${testsRootFolder}/go.sum ${testsRootFolder}/go.mod`;
        break;
      case 'java':
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsRootFolder}/build.gradle`;
        break;
      case 'javascript':
        const packageNames = matrix[language].toRun.map((client) => {
          const packageName = GENERATORS[`${language}-${client}`].additionalProperties.packageName;

          // `algoliasearch` is not preceded by `@algolia`
          return client === 'algoliasearch' ? packageName : `@algolia/${packageName}`;
        });

        languageMatrix.buildCommand = `cd ${matrix[language].path} && yarn build:many '{${packageNames.join(',')},}'`;
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsRootFolder}/package.json`;

        setOutput('JAVASCRIPT_DATA', JSON.stringify(languageMatrix));
        setOutput('RUN_GEN_JAVASCRIPT', true);

        // we don't store js in the clientMatrix, it's an other ci job
        continue;
      case 'kotlin':
        setOutput('KOTLIN_DATA', JSON.stringify(languageMatrix));
        setOutput('RUN_MACOS_KOTLIN_BUILD', true);
        break;
      case 'php':
        if (languageMatrix.version) {
          languageMatrix.version = languageMatrix.version.split('.').slice(0, -1).join('.');
        }
        break;
      case 'python':
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsRootFolder}/poetry.lock ${testsRootFolder}/requirements.txt`;
        break;
      case 'ruby':
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsRootFolder}/Gemfile.lock`;
        break;
      case 'swift':
        // Swift requires the benchmark folder to have files in it
        languageMatrix.testsToDelete = `${testsOutputBase}/client ${testsOutputBase}/requests ${testsOutputBase}/e2e`;
        languageMatrix.testsToStore = `${languageMatrix.testsToStore} ${testsRootFolder}/Package.swift`;
        setOutput('SWIFT_DATA', JSON.stringify(languageMatrix));
        setOutput('RUN_MACOS_SWIFT_CTS', true);
        break;
      default:
        break;
    }

    const supportedVersions: string[] = getClientsConfigField(language, 'supportedVersions', false);
    if (supportedVersions && supportedVersions.length > 0) {
      supportedVersions.forEach((supportedVersion, idx) => {
        clientMatrix.client.push({
          ...languageMatrix,
          version: supportedVersion,
          isMainVersion: idx === supportedVersions.length - 1,
        });
      });
    } else {
      clientMatrix.client.push(languageMatrix);
    }
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

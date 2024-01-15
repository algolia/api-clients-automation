import fsp from 'fs/promises';
import path from 'path';

import { Octokit } from '@octokit/rest';
import { execaCommand, execa } from 'execa';
import type { ExecaError } from 'execa';
import { hashElement } from 'folder-hash';
import { remove } from 'fs-extra';

import clientsConfig from '../config/clients.config.json' assert { type: 'json' };
import releaseConfig from '../config/release.config.json' assert { type: 'json' };

import { buildSpecs } from './buildSpecs';
import { getDockerImage } from './config';
import { generateOpenapitools } from './pre-gen';
import { getGitAuthor } from './release/common.js';
import { createSpinner } from './spinners.js';
import type {
  CheckForCache,
  CheckForCacheOptions,
  Generator,
  Language,
  RunOptions,
} from './types.js';

export const MAIN_BRANCH = releaseConfig.mainBranch;
export const OWNER = releaseConfig.owner;
export const REPO = releaseConfig.repo;
export const REPO_URL = `https://github.com/${OWNER}/${REPO}`;
export const TODAY = new Date().toISOString().split('T')[0];

export const CI = Boolean(process.env.CI);

// This script is run by `yarn workspace ...`, which means the current working directory is `./script`
const ROOT_DIR = path.resolve(process.cwd(), '..');

export const ROOT_ENV_PATH = path.resolve(ROOT_DIR, '.env');

// Build `GENERATORS` from the `clients.config.json` file
export const GENERATORS = Object.entries(clientsConfig).reduce(
  (current, [language, { clients, folder, ...gen }]) => {
    for (const client of clients) {
      let output = folder;
      let key = '';
      let clientName = '';

      if (typeof client !== 'string') {
        key = `${language}-${client.name}`;
        clientName = client.name;
        output = client.output;
      } else {
        key = `${language}-${client}`;
        clientName = client;
      }

      // eslint-disable-next-line no-param-reassign
      current[key] = {
        additionalProperties: {},
        ...gen,
        output,
        client: clientName,
        language: language as Language,
        key,
      };

      // guess the package name for js from the output folder variable
      if (language === 'javascript') {
        // eslint-disable-next-line no-param-reassign
        current[key].additionalProperties.packageName = output.substring(
          output.lastIndexOf('/') + 1
        );
      }
    }

    return current;
  },
  {} as Record<string, Generator>
);

export const LANGUAGES = [...new Set(Object.values(GENERATORS).map((gen) => gen.language))];

export const CLIENTS = [...new Set(Object.values(GENERATORS).map((gen) => gen.client))];

export async function run(
  command: string,
  { errorMessage, cwd, language }: RunOptions = {}
): Promise<string> {
  const realCwd = path.resolve(ROOT_DIR, cwd ?? '.');
  const dockerImage = getDockerImage(language);
  let wrappedCmd = command;
  if (dockerImage) {
    wrappedCmd = `docker exec ${dockerImage} bash -lc "cd ${cwd ?? '.'} && ${command}"`;
  }
  try {
    if (isVerbose()) {
      return (
        (
          await execaCommand(wrappedCmd, {
            stdout: 'inherit',
            stderr: 'inherit',
            stdin: 'inherit',
            all: true,
            shell: 'bash',
            cwd: dockerImage ? ROOT_DIR : realCwd,
          })
        ).all ?? ''
      );
    }
    return (
      (
        await execaCommand(wrappedCmd, {
          shell: 'bash',
          all: true,
          cwd: dockerImage ? ROOT_DIR : realCwd,
        })
      ).all ?? ''
    );
  } catch (err) {
    if (errorMessage) {
      throw new Error(`[ERROR] ${errorMessage}`);
    } else {
      // it's already logged in the verbose case
      if (!isVerbose()) {
        // eslint-disable-next-line no-console
        console.log((err as ExecaError).all);
      }
      throw new Error(`command failed: ${command}`);
    }
  }
}

export async function exists(ppath: string): Promise<boolean> {
  try {
    await fsp.stat(ppath);
    return true;
  } catch {
    return false;
  }
}

export function toAbsolutePath(ppath: string): string {
  return path.resolve(ROOT_DIR, ppath);
}

export async function gitCommit({
  message,
  coAuthors,
  cwd = ROOT_DIR,
}: {
  message: string;
  coAuthors?: string[];
  cwd?: string;
}): Promise<void> {
  const messageWithCoAuthors = coAuthors ? `${message}\n\n\n${coAuthors.join('\n')}` : message;

  await execa('git', ['commit', '-m', messageWithCoAuthors], { cwd });
}

export async function checkForCache({
  folder,
  generatedFiles,
  filesToCache,
  cacheFile,
}: CheckForCacheOptions): Promise<CheckForCache> {
  const cache: CheckForCache = {
    cacheExists: false,
    hash: '',
  };
  const generatedFilesExists = (
    await Promise.all(generatedFiles.map((generatedFile) => exists(`${folder}/${generatedFile}`)))
  ).every((exist) => exist);

  for (const fileToCache of filesToCache) {
    const fileHash = (await hashElement(`${folder}/${fileToCache}`)).hash;

    cache.hash = `${cache.hash}-${fileHash}`;
  }

  // We only skip if both the cache and the generated file exists
  if (generatedFilesExists && (await exists(cacheFile))) {
    const storedHash = (await fsp.readFile(cacheFile)).toString();
    if (storedHash === cache.hash) {
      return {
        cacheExists: true,
        hash: cache.hash,
      };
    }
  }

  return cache;
}

async function buildCustomGenerators(): Promise<void> {
  const spinner = createSpinner('building custom generators');

  const cacheFile = toAbsolutePath('generators/.cache');
  const { cacheExists, hash } = await checkForCache({
    folder: toAbsolutePath('generators/'),
    generatedFiles: ['build'],
    filesToCache: ['src', 'build.gradle', 'settings.gradle'],
    cacheFile,
  });

  if (cacheExists) {
    spinner.succeed('job skipped, cache found for custom generators');
    return;
  }

  await run('./gradle/gradlew --no-daemon -p generators assemble', { language: 'java' });

  if (hash) {
    spinner.text = 'storing custom generators cache';
    await fsp.writeFile(cacheFile, hash);
  }

  spinner.succeed();
}

export async function gitBranchExists(branchName: string): Promise<boolean> {
  return Boolean(await run(`git ls-remote --heads origin ${branchName}`));
}

export async function emptyDirExceptForDotGit(dir: string): Promise<void> {
  for (const file of await fsp.readdir(dir)) {
    if (file !== '.git') {
      await remove(path.resolve(dir, file));
    }
  }
}

export async function runComposerInstall(): Promise<void> {
  if (!CI) {
    await run('composer install && composer dump-autoload', {
      cwd: 'clients/algoliasearch-client-php',
      language: 'php',
    });
  }
}

export function ensureGitHubToken(): string {
  // use process.env here to mock with jest
  if (!process.env.GITHUB_TOKEN) {
    throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
  }
  return process.env.GITHUB_TOKEN.replaceAll('"', '');
}

export function getOctokit(): Octokit {
  const token = ensureGitHubToken();
  return new Octokit({
    auth: token,
  });
}

export function createClientName(client: string, language: string): string {
  switch (language) {
    case 'javascript':
      return camelize(client);
    case 'dart':
    case 'go':
      return client;
    case 'python':
    case 'ruby':
      return toSnakeCase(client);
    default:
      return capitalize(camelize(client));
  }
}

/**
 * Splits a string for a given `delimiter` (defaults to `-`) and capitalize each
 * parts except the first letter.
 *
 * `search-client` -> `searchClient`.
 */
function camelize(str: string, delimiter: string = '-'): string {
  return str
    .split(delimiter)
    .map((part, i) => (i === 0 ? part : capitalize(part)))
    .join('');
}

/**
 * Sets the first letter of the given string in capital.
 *
 * `searchClient` -> `SearchClient`.
 */
export function capitalize(str: string): string {
  return str.charAt(0).toUpperCase() + str.slice(1);
}

export function toSnakeCase(str: string): string {
  return (str.charAt(0).toLowerCase() + str.slice(1))
    .replace(/[A-Z]/g, (letter) => `_${letter}`)
    .replace(/(-|\s)/g, '_')
    .toLowerCase();
}

export async function configureGitHubAuthor(cwd?: string): Promise<void> {
  const { name, email } = getGitAuthor();

  await run(`git config user.name "${name}"`, { cwd });
  await run(`git config user.email "${email}"`, { cwd });
}

let verbose = false;
export function setVerbose(v: boolean): void {
  verbose = v;
}

export function isVerbose(): boolean {
  return verbose;
}

export async function callCTSGenerator(gen: Generator, mode: 'snippets' | 'tests'): Promise<void> {
  const spinner = createSpinner(
    `generating ${mode === 'tests' ? 'CTS' : 'code snippets'} for ${gen.key}`
  );

  await run(
    `yarn openapi-generator-cli --custom-generator=generators/build/libs/algolia-java-openapi-generator-1.0.0.jar generate \
     -g algolia-cts -i specs/bundled/${gen.client}.yml --additional-properties="language=${gen.language},client=${gen.client},mode=${mode}"`,
    { language: 'java' }
  );

  spinner.succeed();
}

export async function setupAndGen(
  generators: Generator[],
  fn: (gen: Generator) => Promise<void>
): Promise<void> {
  if (!CI) {
    const clients = [...new Set(generators.map((gen) => gen.client))];
    await buildSpecs(clients, 'yml', true);
  }

  await generateOpenapitools(generators);
  await buildCustomGenerators();

  for (const gen of generators) {
    await fn(gen);
  }
}

import fsp from 'fs/promises';
import path from 'path';

import execa from 'execa'; // https://github.com/sindresorhus/execa/tree/v5.1.1

import openapitools from '../openapitools.json';

import type { Generator, RunOptions } from './types';

export const CI = Boolean(process.env.CI);
export const DOCKER = Boolean(process.env.DOCKER);

// This script is run by `yarn workspace ...`, which means the current working directory is `./script`
export const ROOT_DIR = path.resolve(process.cwd(), '..');

export const GENERATORS = Object.fromEntries(
  Object.entries(openapitools['generator-cli'].generators).map(([key, gen]) => {
    return [key, { ...gen, ...splitGeneratorKey(key) }];
  })
);

export const LANGUAGES = [
  ...new Set(Object.values(GENERATORS).map((gen) => gen.language)),
];

export const CLIENTS = [
  ...new Set(Object.values(GENERATORS).map((gen) => gen.client)),
];

export const CLIENTS_JS = CLIENTS.concat([]);

export function splitGeneratorKey(key: string): Generator {
  const language = key.slice(0, key.indexOf('-'));
  const client = key.slice(key.indexOf('-') + 1);
  return { language, client, key };
}

export function createGeneratorKey({
  language,
  client,
}: Pick<Generator, 'client' | 'language'>): string {
  return `${language}-${client}`;
}

export async function run(
  command: string,
  { errorMessage, verbose, cwd = ROOT_DIR }: RunOptions = {}
): Promise<string> {
  try {
    if (verbose) {
      return (
        await execa.command(command, {
          stdout: 'inherit',
          shell: 'bash',
          cwd,
        })
      ).stdout;
    }
    return (await execa.command(command, { shell: 'bash', cwd })).stdout;
  } catch (err) {
    if (errorMessage) {
      throw new Error(`[ERROR] ${errorMessage}`);
    } else {
      throw err;
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

export function getAbsolutePath(ppath: string): string {
  return path.resolve(ROOT_DIR, ppath);
}

export async function runIfExists(
  scriptFile: string,
  args: string,
  opts: RunOptions = {}
): Promise<string> {
  if (await exists(getAbsolutePath(scriptFile))) {
    return await run(`${scriptFile} ${args}`, opts);
  }
  return '';
}

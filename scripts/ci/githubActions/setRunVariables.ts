/* eslint-disable no-console */
import * as core from '@actions/core';

import { LANGUAGES } from '../../common.js';
import { getLanguageFolder } from '../../config.js';
import type { Language } from '../../types.js';

import { isBaseChanged } from './utils.js';

export const COMMON_DEPENDENCIES = {
  GITHUB_ACTIONS_CHANGED: ['.github/actions', '.github/workflows'],
  SCRIPTS_CHANGED: [
    'scripts',
    'eslint',
    'yarn.lock',
    '.eslintrc.cjs',
    'config/generation.config.mjs',
    'config/clients.config.json',
    'config/release.config.json',
    'generators',
    'tests/CTS',
    '.nvmrc',
  ],
  COMMON_SPECS_CHANGED: ['specs/common'],
};

export function getVersionFileForLanguage(lang: Language): string {
  // js rely on the nvmrc of the repo
  if (lang === 'javascript') {
    return '.nvmrc';
  }

  // jvm lang rely on the same java version
  if (lang === 'kotlin' || lang === 'java' || lang === 'scala') {
    return 'config/.java-version';
  }

  return `config/.${lang}-version`;
}

/**
 * This dependency array is generated to match the "external" dependencies of a generated client.
 *
 * Those variables are used to determine if jobs should run, based on the changes
 * made in their respective dependencies.
 *
 * Negative paths should start with `:!`.
 *
 * The variable will be accessible in the CI via `steps.diff.outputs.<name>`.
 *
 * Variables starting by `LANGUAGENAME_` will be used in the `createMatrix` to determine
 * if a job should be added.
 */
export const DEPENDENCIES = LANGUAGES.reduce(
  (finalDependencies, lang) => {
    const key = `${lang.toUpperCase()}_CLIENT_CHANGED`;
    const langFolder = getLanguageFolder(lang);

    finalDependencies[key] = [
      ':!**node_modules',
      `templates/${lang}`,
      // language related files
      langFolder,
      getVersionFileForLanguage(lang),
      `:!${langFolder}/.github`,
      `:!${langFolder}/README.md`,
    ];

    return finalDependencies;
  },
  { ...COMMON_DEPENDENCIES } as Record<string, string[]>,
);

/**
 * Outputs variables used in the CI to determine if a job should run.
 */
async function setRunVariables({ originBranch }: { originBranch: string }): Promise<void> {
  console.log(`Checking diff between ${originBranch} and HEAD`);

  core.setOutput('ORIGIN_BRANCH', originBranch);

  await isBaseChanged(originBranch, DEPENDENCIES, true);
}

if (import.meta.url.endsWith(process.argv[1])) {
  const [originBranch] = process.argv.slice(2);

  if (!originBranch) {
    throw new Error(`Unable to retrieve the origin branch: ${JSON.stringify(originBranch)}`);
  }

  setRunVariables({ originBranch });
}

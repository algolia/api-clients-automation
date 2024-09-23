/* eslint-disable no-console */
import * as core from '@actions/core';

import { LANGUAGES } from '../../common.ts';
import { getLanguageFolder } from '../../config.ts';
import type { Language } from '../../types.ts';
import { getNbGitDiff } from '../utils.ts';

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
export const DEPENDENCIES = {
  ...LANGUAGES.reduce(
    (finalDependencies, lang) => {
      const key = `${lang.toUpperCase()}_CLIENT_CHANGED`;
      const langFolder = getLanguageFolder(lang);

      finalDependencies[key] = [
        ':!**node_modules',
        `templates/${lang}`,
        'templates/Bug_report.yml',
        'templates/issue.yml',
        'templates/LICENSE',
        // language related files
        langFolder,
        getVersionFileForLanguage(lang),
        `tests/output/${lang}`,
        `:!${langFolder}/.github`,
        `:!${langFolder}/README.md`,
      ];

      return finalDependencies;
    },
    { ...COMMON_DEPENDENCIES } as Record<string, string[]>,
  ),
  WEBSITE_CHANGED: ['website', 'scripts/website', 'package.json', 'netlify.toml'],
};

function getVersionFileForLanguage(lang: Language): string {
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
 * Determines if changes have been found in the `dependencies`, compared to the `baseBranch`.
 *
 * If `output` is true, it will set log the variable values for the CI.
 */
export async function isBaseChanged(
  baseBranch: string,
  dependencies: Record<string, string[]>,
  output?: boolean,
): Promise<boolean> {
  for (const [key, path] of Object.entries(dependencies)) {
    const diff = await getNbGitDiff({
      branch: baseBranch,
      path: path.join(' '),
    });

    if (output) {
      console.log(`Found ${diff} changes for '${key}'`);
      core.setOutput(key, diff);
    } else if (diff > 0) {
      return true;
    }
  }

  return false;
}

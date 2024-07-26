/* eslint-disable no-console */
import * as core from '@actions/core';

import type { Language } from '../../types.js';

import { DEPENDENCIES, isBaseChanged } from './utils.js';

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

/* eslint-disable no-console */
import * as core from '@actions/core';

import { DEPENDENCIES, isBaseChanged } from './utils.ts';

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

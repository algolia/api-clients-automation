/* eslint-disable no-console */
import * as core from '@actions/core';

import { getNbGitDiff } from '../utils.js';

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

import { run } from '../../common';

/**
 * Checks if a remote branch with the `branch` name exists.
 *
 * @param branch - The name of the branch to check on `origin`.
 * @returns Boolean.
 */
export async function branchExists(branch: string): Promise<boolean> {
  return Boolean(await run(`git ls-remote --heads origin ${branch}`));
}

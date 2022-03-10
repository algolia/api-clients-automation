/* eslint-disable no-console */
import { run } from '../../common';

/**
 * Deletes a branch for it's `generated/${headRef}` name on origin.
 *
 * @param headRef - The name of the branch to search for.
 */
export async function cleanGeneratedBranch(headRef?: string): Promise<void> {
  if (!process.env.HEAD_REF && !headRef) {
    throw new Error('Unable to run cleanup, HEAD_REF is missing.');
  }

  const generatedCodeBranch = `generated/${process.env.HEAD_REF || headRef}`;

  if (!(await run(`git ls-remote --heads origin ${generatedCodeBranch}`))) {
    console.log(`No branch named '${generatedCodeBranch}' was found.`);

    return;
  }

  // Delete previous generations to avoid conflicts and out of date code
  console.log(`Deleting generated branch: '${generatedCodeBranch}'`);

  await run(`git fetch origin ${generatedCodeBranch}`);
  await run(`git push -d origin ${generatedCodeBranch}`);
}

if (process.env.HEAD_REF) {
  cleanGeneratedBranch();
}

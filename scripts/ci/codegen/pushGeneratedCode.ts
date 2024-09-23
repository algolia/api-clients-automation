/* eslint-disable no-console */
import { setOutput } from '@actions/core';

import { configureGitHubAuthor, ensureGitHubToken, MAIN_BRANCH, run } from '../../common.ts';
import { getNbGitDiff } from '../utils.ts';

import text, { commitStartPrepareRelease } from './text.ts';

async function isUpToDate(baseBranch: string): Promise<boolean> {
  await run('git fetch origin');
  return (await run(`git pull origin ${baseBranch}`)).includes('Already up to date.');
}

/**
 * Push generated code for the current `JOB` and `CLIENT` on a `generated/` branch.
 */
export async function pushGeneratedCode(): Promise<void> {
  ensureGitHubToken();

  await configureGitHubAuthor();

  const baseBranch = await run('git branch --show-current');
  const isMainBranch = baseBranch === MAIN_BRANCH;
  const IS_RELEASE_COMMIT = (await run('git log -1 --format="%s"')).startsWith(commitStartPrepareRelease);
  console.log(`Checking codegen status on '${baseBranch}'.`);

  const nbDiff = await getNbGitDiff({
    branch: baseBranch,
    head: null,
  });

  if (nbDiff === 0) {
    console.log(`No generated code changes found for '${baseBranch}'.`);

    return;
  }

  console.log(`${nbDiff} changes found`);

  // determine generated branch name based on current branch
  const branchToPush = isMainBranch ? baseBranch : `generated/${baseBranch}`;

  if (!isMainBranch) {
    await run(`git push -d origin generated/${baseBranch} || true`);

    console.log(`Creating branch for generated code: '${branchToPush}'`);
    await run(`git checkout -b ${branchToPush}`);
  }

  if (!(await isUpToDate(baseBranch))) {
    console.log(
      `The branch '${baseBranch}' is not up to date with origin, stopping this task and letting the new job push generated code.`,
    );
    return;
  }

  const skipCi = isMainBranch ? '[skip ci]' : '';
  let message = await run(`git show -s ${baseBranch} --format="%s ${text.commitEndMessage} ${skipCi}"`);
  const authors = await run(
    `git show -s ${baseBranch} --format="

Co-authored-by: %an <%ae>
%(trailers:key=Co-authored-by)"`,
  );

  if (IS_RELEASE_COMMIT && isMainBranch) {
    console.log('Processing release commit');
    message = `${text.commitReleaseMessage} [skip ci]`;
  }

  message += authors;

  console.log(`Pushing code to generated branch: '${branchToPush}'`);
  await run('git add .');
  await run(`git commit -m "${message}"`);
  await run(`git push origin ${branchToPush}`);

  setOutput('GENERATED_COMMIT', await run('git rev-parse HEAD'));
}

if (import.meta.url.endsWith(process.argv[1])) {
  pushGeneratedCode();
}

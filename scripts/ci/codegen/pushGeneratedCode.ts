import { setOutput } from '@actions/core';

import { configureGitHubAuthor, ensureGitHubToken, MAIN_BRANCH, run } from '../../common.js';
import { getNbGitDiff } from '../utils.js';

import text, { commitStartPrepareRelease } from './text.js';

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
    await run(`git checkout -B ${branchToPush}`);
  }

  if (!(await isUpToDate(baseBranch))) {
    console.log(
      `The branch '${baseBranch}' is not up to date with origin, stopping this task and letting the new job push generated code.`,
    );
    return;
  }

  let skipCi = '';
  if (IS_RELEASE_COMMIT || isMainBranch) {
    console.log('Processing release commit');
    skipCi = '[skip ci]';
  }

  const commitMessage = await run(
    `git show -s ${baseBranch} --format="%s ${text.commitEndMessage} ${skipCi}

Co-authored-by: %an <%ae>
%(trailers:key=Co-authored-by)"`,
  );

  console.log(`Pushing code to generated branch: '${branchToPush}'`);
  await run('git add .');
  await run(`git commit -m "${commitMessage.replaceAll('"', '\\"')}"`);
  await run(`git push origin ${branchToPush}`);

  setOutput('GENERATED_COMMIT', await run('git rev-parse HEAD'));
}

if (import.meta.url.endsWith(process.argv[1])) {
  pushGeneratedCode();
}

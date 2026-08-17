import { setOutput } from '@actions/core';

import { assertSafeRef, configureGitHubAuthor, ensureGitHubToken, git, gitCommit, MAIN_BRANCH } from '../../common.ts';
import { getNbGitDiff } from '../utils.ts';

import text, { commitStartPrepareRelease } from './text.ts';

async function isUpToDate(baseBranch: string): Promise<boolean> {
  await git(['fetch', 'origin']);
  return (await git(['pull', 'origin', baseBranch])).includes('Already up to date.');
}

/**
 * Push generated code for the current `JOB` and `CLIENT` on a `generated/` branch.
 */
export async function pushGeneratedCode(): Promise<void> {
  ensureGitHubToken();

  await configureGitHubAuthor();

  const baseBranch = assertSafeRef(await git(['branch', '--show-current']));
  const isMainBranch = baseBranch === MAIN_BRANCH;
  const IS_RELEASE_COMMIT = (await git(['log', '-1', '--format=%s'])).startsWith(commitStartPrepareRelease);
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
    await git(['push', '-d', 'origin', `generated/${baseBranch}`], { allowFailure: true });

    console.log(`Creating branch for generated code: '${branchToPush}'`);
    await git(['checkout', '-B', branchToPush]);
  }

  if (!(await isUpToDate(baseBranch))) {
    console.log(
      `The branch '${baseBranch}' is not up to date with origin, stopping this task and letting the new job push generated code.`,
    );
    return;
  }

  const skipCi = isMainBranch ? '[skip ci]' : '';
  const subject = await git(['show', '-s', '--format=%s', '--end-of-options', baseBranch]);
  const authorLine = await git(['show', '-s', '--format=Co-authored-by: %an <%ae>', '--end-of-options', baseBranch]);
  const trailers = await git(['show', '-s', '--format=%(trailers:key=Co-authored-by)', '--end-of-options', baseBranch]);

  const coAuthors = [
    authorLine.trim(),
    ...trailers
      .split('\n')
      .map((coAuthor) => coAuthor.trim())
      .filter(Boolean),
  ];

  let message = [subject, text.commitEndMessage, skipCi].filter(Boolean).join(' ');

  if (IS_RELEASE_COMMIT && isMainBranch) {
    console.log('Processing release commit');
    message = `${text.commitReleaseMessage} [skip ci]`;
  }

  console.log(`Pushing code to generated branch: '${branchToPush}'`);
  await git(['add', '.']);
  await gitCommit({ message, coAuthors });
  await git(['push', 'origin', branchToPush]);

  setOutput('GENERATED_COMMIT', await git(['rev-parse', 'HEAD']));
}

if (import.meta.url.endsWith(process.argv[1])) {
  pushGeneratedCode();
}

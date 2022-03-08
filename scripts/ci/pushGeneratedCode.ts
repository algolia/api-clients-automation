/* eslint-disable no-console */
import { Octokit } from '@octokit/rest';

import { run } from '../common';

if (!process.env.GITHUB_TOKEN) {
  throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
}

if (!process.env.PR_NUMBER) {
  throw new Error('Environment variable `PR_NUMBER` does not exist.');
}

const FOLDERS_TO_CHECK = ['clients', 'specs/bundled'];
const REPOSITORY = 'algolia/api-clients-automation';
const REPOSITORY_URL = `https://github.com/${REPOSITORY}`;
const PR_NUMBER = parseInt(process.env.PR_NUMBER, 10);

const octokit = new Octokit({
  auth: `token ${process.env.GITHUB_TOKEN}`,
});

const baseOctokitConfig = {
  owner: 'algolia',
  repo: 'api-clients-automation',
  pull_number: PR_NUMBER,
};

async function addCommentToPullRequest({
  baseBranch,
  generatedCodeBranch,
}: {
  baseBranch: string;
  generatedCodeBranch: string;
}): Promise<void> {
  const baseCommit = await run(`git show ${baseBranch} -s --format=%H`);
  const generatedCommit = await run('git show -s --format=%H');

  try {
    const reviewComments = await octokit.rest.pulls.listReviewComments(
      baseOctokitConfig
    );
    const botReviewComment = reviewComments.data.filter(
      (comment) => comment.user.name === 'algolia-api-client-bot'
    );
    const commentBody = `Code for [commit ${baseCommit}](${REPOSITORY_URL}/pull/${PR_NUMBER}/commits/${baseCommit}) has been generated.

Browse the [generated commit](${REPOSITORY_URL}/commit/${generatedCommit}) on branch [${generatedCodeBranch}](${REPOSITORY_URL})/tree/${generatedCodeBranch}`;

    // If we already have a comment, we update its body.
    if (botReviewComment.length) {
      await octokit.rest.pulls.updateReviewComment({
        ...baseOctokitConfig,
        body: commentBody,
        comment_id: botReviewComment[0].id,
      });

      return;
    }

    // Otherwise, we create it.
    await octokit.rest.pulls.createReviewComment({
      ...baseOctokitConfig,
      body: commentBody,
    });
  } catch (e) {
    throw new Error(`Error with GitHub pulls API: ${e}`);
  }
}

async function pushGeneratedCode(): Promise<void> {
  console.log(await run('git status'));

  const generatedFolders = FOLDERS_TO_CHECK.join(' ');
  const statusChanges = await run(
    `git status --porcelain ${generatedFolders} | wc -l | tr -d ' '`
  );

  if (statusChanges === '0') {
    console.log(
      `No generated code changes found in folders '${generatedFolders}'.`
    );

    return;
  }

  const baseBranch = await run('git branch --show-current');
  const generatedCodeBranch = `generated_${baseBranch}`;

  // Creating branch if it does not exists
  if (
    !(await run(
      `git ls-remote --heads git@github.com:${REPOSITORY}.git ${generatedCodeBranch}`
    ))
  ) {
    console.log(`Creating new branch '${generatedCodeBranch}'`);

    await run(`git branch ${generatedCodeBranch}`);
  }

  const commitMessage =
    await run(`git show -s --format="Generated code for commit %H.

Co-authored-by: %an <%ae>"`);

  await run(`git checkout ${generatedCodeBranch}`);
  await run(`git add ${generatedFolders}`);
  await run(`git commit -m "${commitMessage}"`);
  await run(`git push origin ${generatedCodeBranch}`);

  await addCommentToPullRequest({
    baseBranch,
    generatedCodeBranch,
  });
}

pushGeneratedCode();

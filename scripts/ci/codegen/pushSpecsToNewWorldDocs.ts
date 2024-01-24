/* eslint-disable no-console */
import fsp from 'fs/promises';
import { resolve } from 'path';

import {
  emptyDirExceptForDotGit,
  gitCommit,
  run,
  toAbsolutePath,
  ensureGitHubToken,
  OWNER,
  configureGitHubAuthor,
  getOctokit,
  setVerbose,
} from '../../common.js';
import { getNbGitDiff } from '../utils.js';

import { commitStartRelease } from './text.js';

async function pushToNewWorld(): Promise<void> {
  const githubToken = ensureGitHubToken();

  const repository = 'new-world-docs';
  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  if (!lastCommitMessage.startsWith(commitStartRelease)) {
    return;
  }

  console.log(`Pushing generated specs to ${OWNER}/${repository}`);

  const targetBranch = 'feat/automated-update-from-api-clients-automation-repository';
  const githubURL = `https://${githubToken}:${githubToken}@github.com/${OWNER}/${repository}`;
  const tempGitDir = resolve(process.env.RUNNER_TEMP!, repository);
  await fsp.rm(tempGitDir, { force: true, recursive: true });
  await run(`git clone --depth 1 ${githubURL} ${tempGitDir}`);
  await run(`git checkout -B ${targetBranch}`);

  const dest = toAbsolutePath(`${tempGitDir}/apps/docs/public/specs`);
  await emptyDirExceptForDotGit(dest);
  await run(`cp ${toAbsolutePath('specs/bundled/*.json')} ${dest}`);

  if ((await getNbGitDiff({ head: null, cwd: tempGitDir })) === 0) {
    console.log(`❎ Skipping specs push because there is no change.`);

    return;
  }

  await configureGitHubAuthor(tempGitDir);

  const message = 'feat(specs): automatic update from api-clients-automation repository';
  await run('git add .', { cwd: tempGitDir });
  await gitCommit({
    message,
    coAuthors: [author, ...coAuthors],
    cwd: tempGitDir,
  });
  await run(`git push -f origin ${targetBranch}`, { cwd: tempGitDir });

  console.log(`Creating pull request on ${OWNER}/${repository}...`);
  const octokit = getOctokit();
  const { data } = await octokit.pulls.create({
    owner: OWNER,
    repo: repository,
    title: message,
    body: [
      'This PR is automatically created by https://github.com/algolia/api-clients-automation',
      'It contains the most up-to-date OpenAPI for the Algolia API clients.',
    ].join('\n\n'),
    base: 'main',
    head: targetBranch,
  });

  console.log(`Pull request created on ${OWNER}/${repository}`);
  console.log(`  > ${data.url}`);
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  pushToNewWorld();
}

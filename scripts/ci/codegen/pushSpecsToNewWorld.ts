/* eslint-disable no-console */
import fsp from 'fs/promises';
import { resolve } from 'path';

import {
  emptyDirExceptForDotGit,
  gitCommit,
  run,
  toAbsolutePath,
  ensureGitHubToken,
  configureGitHubAuthor,
  setVerbose,
} from '../../common.js';
import { getNbGitDiff } from '../utils.js';

import { commitStartRelease } from './text.js';

async function pushToNewWorld(): Promise<void> {
  const githubToken = ensureGitHubToken();

  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  if (!lastCommitMessage.startsWith(commitStartRelease)) {
    return;
  }

  console.log('Pushing generated specs to https://github.com/algolia/new-world-docs');

  const targetBranch = 'feat/automated-update-from-api-clients-automation-repository';
  const githubURL = `https://${githubToken}:${githubToken}@github.com/algolia/new-world-docs`;
  const tempGitDir = resolve(process.env.RUNNER_TEMP!, 'new-world-docs');
  await fsp.rm(tempGitDir, { force: true, recursive: true });
  await run(`git clone --depth 1 ${githubURL} ${tempGitDir}`);
  await run(`git checkout -B ${targetBranch}`);

  const dest = toAbsolutePath(`${tempGitDir}/apps/docs/public/specs`);
  await emptyDirExceptForDotGit(dest);
  await run(`cp ${toAbsolutePath('specs/bundled/*.json')} ${dest}`);

  if ((await getNbGitDiff({ head: null, cwd: tempGitDir })) === 0) {
    console.log(`❎ Skipping specs push because there is no change.`);
  } else {
    console.log(`✅ Push specs to the new-world-docs repository.`);
  }

  await configureGitHubAuthor(tempGitDir);

  await run('git add .', { cwd: tempGitDir });
  await gitCommit({
    message: 'feat(specs): automated update from api-clients-automation repository',
    coAuthors: [author, ...coAuthors],
    cwd: tempGitDir,
  });
  await run('git push -f', { cwd: tempGitDir });
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(true);
  pushToNewWorld();
}

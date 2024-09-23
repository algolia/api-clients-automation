/* eslint-disable no-console */
import fsp from 'fs/promises';
import { resolve } from 'path';

import {
  gitCommit,
  run,
  toAbsolutePath,
  ensureGitHubToken,
  OWNER,
  configureGitHubAuthor,
  getOctokit,
  setVerbose,
  gitBranchExists,
} from '../../common.ts';
import { getNbGitDiff } from '../utils.ts';

import { commitStartRelease } from './text.ts';

async function pushToAlgoliaDoc(): Promise<void> {
  const githubToken = ensureGitHubToken();

  const repository = 'doc';
  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  if (!process.env.DRY_RUN && !lastCommitMessage.startsWith(commitStartRelease)) {
    return;
  }

  console.log(`Pushing to ${OWNER}/${repository}`);

  const targetBranch = 'feat/automated-update-from-api-clients-automation-repository';
  const githubURL = `https://${githubToken}:${githubToken}@github.com/${OWNER}/${repository}`;
  const tempGitDir = resolve(process.env.RUNNER_TEMP! || toAbsolutePath('foo/local/test'), repository);
  await fsp.rm(tempGitDir, { force: true, recursive: true });
  await run(`git clone --depth 1 ${githubURL} ${tempGitDir}`);
  if (await gitBranchExists(targetBranch, tempGitDir)) {
    await run(`git fetch origin ${targetBranch}`, { cwd: tempGitDir });
    await run(`git push -d origin ${targetBranch}`, { cwd: tempGitDir });
  }
  await run(`git checkout -B ${targetBranch}`, { cwd: tempGitDir });

  const pathToSpecs = toAbsolutePath(`${tempGitDir}/app_data/api/specs`);
  await run(`rm -rf ${pathToSpecs}/* || true`);
  await run(`cp ${toAbsolutePath('specs/bundled/README.md')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('specs/major-breaking-changes-rename.json')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('specs/bundled/*.doc.yml')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('config/clients.config.json')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('snippets/guides/*.json')} ${pathToSpecs}`);
  // add block extension ban words like `analytics` so we use a different file name just so the doc dans render it
  await run(`mv ${pathToSpecs}/analytics.doc.yml ${pathToSpecs}/searchstats.doc.yml`);

  if ((await getNbGitDiff({ head: null, cwd: tempGitDir })) === 0) {
    console.log('❎ Skipping push docs because there is no change.');

    return;
  }

  await configureGitHubAuthor(tempGitDir);

  const message = 'feat: update specs and supported versions';
  await run('git add .', { cwd: tempGitDir });
  await gitCommit({
    message,
    coAuthors: [author, ...coAuthors],
    cwd: tempGitDir,
  });
  await run(`git push -f -u origin ${targetBranch}`, { cwd: tempGitDir });

  console.log(`Creating pull request on ${OWNER}/${repository}...`);
  const octokit = getOctokit();
  const { data } = await octokit.pulls.create({
    owner: OWNER,
    repo: repository,
    title: message,
    body: [
      'This PR is automatically created by https://github.com/algolia/api-clients-automation',
      'It contains the latest released OpenAPI specs, the release version support dates, and the generated code snippets.',
    ].join('\n\n'),
    base: 'master',
    head: targetBranch,
  });

  await octokit.issues.createComment({
    owner: OWNER,
    repo: repository,
    issue_number: data.number,
    body: [
      `[**Preview SLA changes&rarr;**](https://deploy-preview-${data.number}--algolia-docs.netlify.app/doc/libraries/supported-versions/)`,
    ].join('\n\n'),
  });

  console.log(`Pull request created on ${OWNER}/${repository}`);
  console.log(`  > ${data.url}`);
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  pushToAlgoliaDoc();
}

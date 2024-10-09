import fsp from 'fs/promises';
import { resolve } from 'path';

import {
  configureGitHubAuthor,
  ensureGitHubToken,
  exists,
  getOctokit,
  gitBranchExists,
  gitCommit,
  LANGUAGES,
  OWNER,
  run,
  setVerbose,
  toAbsolutePath,
} from '../../common.js';
import { getNbGitDiff } from '../utils.js';

import {} from 'fs';
import { getClientsConfigField } from '../../config.js';
import { commitStartRelease } from './text.js';

async function generateJSON(outputFile: string): Promise<void> {
  const guides = {};
  for (const language of LANGUAGES) {
    if (!(await exists(toAbsolutePath(`docs/guides/${language}`)))) {
      continue;
    }

    const pathToGuides = toAbsolutePath(
      `docs/guides/${language}/${getClientsConfigField(language, ['snippets', 'outputFolder'])}`,
    );
    const files = await fsp.readdir(pathToGuides);
    for (const file of files) {
      const extension = getClientsConfigField(language, ['snippets', 'extension']);
      if (!file.endsWith(extension)) {
        continue;
      }

      const guideName = file.replaceAll(extension, '');
      if (!guides[guideName]) {
        guides[guideName] = {};
      }

      guides[guideName][language] = (await fsp.readFile(`${pathToGuides}/${file}`, 'utf-8'))
        .replace('ALGOLIA_APPLICATION_ID', 'YourApplicationID')
        .replace('ALGOLIA_API_KEY', 'YourWriteAPIKey')
        .replace('<YOUR_INDEX_NAME>', 'movies_index');
    }
  }

  await fsp.writeFile(outputFile, JSON.stringify(guides, null, 2));
}

async function pushToAlgoliaWeb(): Promise<void> {
  const githubToken = ensureGitHubToken();

  const repository = 'AlgoliaWeb';
  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  if (!process.env.FORCE && !lastCommitMessage.startsWith(commitStartRelease)) {
    return;
  }

  const targetBranch = 'feat/automated-update-from-api-clients-automation-repository';
  const githubURL = `https://${githubToken}:${githubToken}@github.com/${OWNER}/${repository}`;
  const tempGitDir = resolve(process.env.RUNNER_TEMP! || toAbsolutePath('foo/local/test'), repository);
  await fsp.rm(tempGitDir, { force: true, recursive: true });
  await run(`git clone --depth 1 ${githubURL} ${tempGitDir}`);

  const outputFile = toAbsolutePath(`${tempGitDir}/_client/src/routes/launchpad/onboarding-snippets.json`);

  console.log(`Generating JSON output file from guides at path ${outputFile}`);

  await generateJSON(outputFile);

  console.log(`Pushing to ${OWNER}/${repository}`);
  if (await gitBranchExists(targetBranch, tempGitDir)) {
    await run(`git fetch origin ${targetBranch}`, { cwd: tempGitDir });
    await run(`git push -d origin ${targetBranch}`, { cwd: tempGitDir });
  }
  await run(`git checkout -B ${targetBranch}`, { cwd: tempGitDir });

  if ((await getNbGitDiff({ head: null, cwd: tempGitDir })) === 0) {
    console.log('❎ Skipping push to AlgoliaWeb because there is no change.');

    return;
  }

  await configureGitHubAuthor(tempGitDir);

  const message = 'feat: update generated guides';
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
      'It contains the latest generated guides.',
    ].join('\n\n'),
    base: 'develop',
    head: targetBranch,
  });

  console.log(`Pull request created on ${OWNER}/${repository}`);
  console.log(`  > ${data.url}`);
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  pushToAlgoliaWeb();
}

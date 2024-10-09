import fsp from 'fs/promises';

import { resolve } from 'path';

import {
  configureGitHubAuthor,
  ensureGitHubToken,
  getOctokit,
  gitBranchExists,
  gitCommit,
  OWNER,
  run,
  setVerbose,
  toAbsolutePath,
} from '../../common.js';
import { getNbGitDiff } from '../utils.js';

import { commitStartRelease } from './text.js';

const languageFiles = {
  csharp: 'guides/csharp/src/saveObjectsMovies.cs',
  go: 'guides/go/src/saveObjectsMovies.go',
  java: 'guides/java/src/test/java/com/algolia/saveObjectsMovies.java',
  javascript: 'guides/javascript/src/saveObjectsMovies.ts',
  kotlin: 'guides/kotlin/src/main/kotlin/com/algolia/snippets/saveObjectsMovies.kt',
  php: 'guides/php/src/saveObjectsMovies.php',
  python: 'guides/python/saveObjectsMovies.py',
  ruby: 'guides/ruby/saveObjectsMovies.rb',
  scala: 'guides/scala/src/main/scala/saveObjectsMovies.scala',
  swift: 'guides/swift/Sources/saveObjectsMovies.swift',
};
const generateJSON = async (outputFile: string): Promise<void> => {
  const filesPromises = Object.entries(languageFiles).map(async (p) => {
    const snippet = await fsp.readFile(toAbsolutePath(p[1]), 'utf-8');

    return [
      [p[0]],
      snippet
        .replace('ALGOLIA_APPLICATION_ID', 'YourApplicationID')
        .replace('ALGOLIA_API_KEY', 'YourWriteAPIKey')
        .replace('<YOUR_INDEX_NAME>', 'movies_index'),
    ];
  });

  const files = await Promise.all(filesPromises);

  await fsp.writeFile(outputFile, JSON.stringify(Object.fromEntries(files), null, 2));
};

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

  const pathToSnippets = toAbsolutePath(`${tempGitDir}/_client/src/routes/launchpad/onboarding-snippets.json`);

  await generateJSON(pathToSnippets);

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

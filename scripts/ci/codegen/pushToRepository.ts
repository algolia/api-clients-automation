import fsp from 'fs/promises';
import path, { resolve } from 'path';

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
import { GuidesToPush, pushToRepositoryConfiguration, RepositoryConfiguration, SpecsToPush } from './types.js';

import { getClientsConfigField } from '../../config.js';
import { commitStartRelease } from './text.js';

async function handleSpecFiles(spec: SpecsToPush, tempGitDir: string): Promise<void> {
  const pathToSpecs = toAbsolutePath(`${tempGitDir}/${spec.output}`);

  await run(`rm -rf ${pathToSpecs}/* || true`);
  await run(`cp ${toAbsolutePath('specs/bundled/README.md')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('specs/major-breaking-changes-rename.json')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('specs/bundled/*.doc.yml')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('config/clients.config.json')} ${pathToSpecs}`);
  await run(`cp ${toAbsolutePath('docs/bundled/*.json')} ${pathToSpecs}`);
  // adblock extensions ban words like `analytics` so we use a different file name just so the doc dans render it
  await run(`mv ${pathToSpecs}/analytics.doc.yml ${pathToSpecs}/searchstats.doc.yml`);
}

async function handleGuideFiles(guide: GuidesToPush, tempGitDir: string): Promise<void> {
  const guides = {};
  for (const language of LANGUAGES) {
    if (!(await exists(toAbsolutePath(`docs/guides/${language}`)))) {
      continue;
    }

    const extension = getClientsConfigField(language, ['snippets', 'extension']);
    const pathToGuides = toAbsolutePath(
      `docs/guides/${language}/${getClientsConfigField(language, ['snippets', 'outputFolder'])}`,
    );

    const files = await fsp.readdir(pathToGuides);
    for (const file of files.filter((file) => guide.names.some((guideName) => guideName === file.split('.')[0]))) {
      if (!file.endsWith(extension)) {
        continue;
      }

      const guideName = file.replaceAll(extension, '');
      if (!guides[guideName]) {
        guides[guideName] = {};
      }

      guides[guideName][language] = await fsp.readFile(`${pathToGuides}/${file}`, 'utf-8');

      if (guide.placeholderVariables) {
        for (const [k, v] of Object.entries(guide.placeholderVariables)) {
          guides[guideName][language] = guides[guideName][language].replace(k, v);
        }
      }
    }
  }

  const outputPath = toAbsolutePath(`${tempGitDir}/${guide.output}`);

  await fsp.mkdir(path.dirname(outputPath), { recursive: true });

  await fsp.writeFile(outputPath, JSON.stringify(guides, null, 2));
}

async function pushToRepository(repository: string, config: RepositoryConfiguration): Promise<void> {
  const githubToken = ensureGitHubToken();

  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  if (!process.env.FORCE && !lastCommitMessage.startsWith(commitStartRelease)) {
    return;
  }

  console.log(`Preparing push to ${OWNER}/${repository}`);

  const tempGitDir = resolve(process.env.RUNNER_TEMP! || toAbsolutePath('foo/local/test'), repository);
  await fsp.rm(tempGitDir, { force: true, recursive: true });

  const githubURL = `https://${githubToken}:${githubToken}@github.com/${OWNER}/${repository}`;
  await run(`git clone --depth 1 ${githubURL} ${tempGitDir}`);

  for (const task of config.tasks) {
    await run(`git checkout ${config.baseBranch}`, { cwd: tempGitDir });
    await run(`git pull origin ${config.baseBranch}`, { cwd: tempGitDir });

    if (await gitBranchExists(task.prBranch, tempGitDir)) {
      await run(`git fetch origin ${task.prBranch}`, { cwd: tempGitDir });
      await run(`git push -d origin ${task.prBranch}`, { cwd: tempGitDir });
    }
    await run(`git checkout -B ${task.prBranch}`, { cwd: tempGitDir });

    console.log(`Handling '${task.files.type}' file(s)`);

    if (task.files.type === 'specs') {
      await handleSpecFiles(task.files, tempGitDir);
    } else {
      await handleGuideFiles(task.files, tempGitDir);
    }

    if ((await getNbGitDiff({ head: null, cwd: tempGitDir })) === 0) {
      console.log(`❎ Skipping push to ${OWNER}/${repository} because there is no change.`);

      continue;
    }

    console.log(`Pushing to '${task.prBranch}`);

    await configureGitHubAuthor(tempGitDir);

    await run('git add .', { cwd: tempGitDir });
    await gitCommit({
      message: task.commitMessage,
      coAuthors: [author, ...coAuthors],
      cwd: tempGitDir,
    });

    if (process.env.DRYRUN) {
      console.log(`asked for a dry run, stopping before push and PR for '${repository}' on task '${task.prBranch}'`);

      continue;
    }

    await run(`git push -f -u origin ${task.prBranch}`, { cwd: tempGitDir });

    console.log(`Creating pull request on ${OWNER}/${repository}...`);
    const octokit = getOctokit();
    const { data } = await octokit.pulls.create({
      owner: OWNER,
      repo: repository,
      title: task.commitMessage,
      body: [
        'This PR is automatically created by https://github.com/algolia/api-clients-automation',
        'It contains the latest generated guides.',
      ].join('\n\n'),
      base: config.baseBranch,
      head: task.prBranch,
    });

    console.log(`Pull request created on ${OWNER}/${repository}`);
    console.log(`  > ${data.url}`);
  }
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  const repositories = process.argv.slice(2) as Array<string>;

  await Promise.allSettled(
    Object.entries(pushToRepositoryConfiguration).map(([name, config]) => {
      if (repositories.length === 0 || repositories.includes(name)) {
        return pushToRepository(name, config);
      }
    }),
  );
}

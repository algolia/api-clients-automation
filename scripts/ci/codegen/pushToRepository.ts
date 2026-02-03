import fsp from 'fs/promises';
import path, { resolve } from 'path';

import {
  CLIENTS,
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
} from '../../common.ts';
import { getNbGitDiff } from '../utils.ts';
import type { GuidesToPush, RepositoryConfiguration, SnippetsToPush, SpecsToPush } from './types.ts';
import { pushToRepositoryConfiguration } from './types.ts';

import { getClientsConfigField } from '../../config.ts';
import { commitStartRelease } from './text.ts';

async function handleSpecFiles(spec: SpecsToPush, tempGitDir: string): Promise<void> {
  const output = toAbsolutePath(`${tempGitDir}/${spec.output}`);

  if (!(await exists(output))) {
    await fsp.mkdir(output, { recursive: true });
  }

  if (spec.includeSnippets) {
    await run(`cp ${toAbsolutePath('docs/bundled/*-snippets.json')} ${output}`);
  }

  if (spec.includeSLA) {
    await run(`cp ${toAbsolutePath('specs/bundled/README.md')} ${output}`);
    await run(`cp ${toAbsolutePath('specs/major-breaking-changes-rename.json')} ${output}`);
    await run(`cp ${toAbsolutePath('config/clients.config.json')} ${output}`);
    await run(`cp ${toAbsolutePath('docs/versions-history-with-sla-and-support-policy.json')} ${output}`);
  }

  const clients = CLIENTS.filter((client) => spec.clients?.includes(client) ?? true);

  for (const client of clients) {
    const pathToBundledSpec = toAbsolutePath(`docs/bundled/${client}.${spec.ext}`);

    if (!(await exists(pathToBundledSpec))) {
      continue;
    }

    const outputFile = `${output}/${client}.${spec.ext}`;

    await run(`cp ${pathToBundledSpec} ${outputFile}`);

    if (spec.placeholderVariables) {
      let file = await fsp.readFile(outputFile, 'utf8');

      for (const [k, v] of Object.entries(spec.placeholderVariables)) {
        file = file.replaceAll(k, v);
      }

      await fsp.writeFile(outputFile, file);
    }
  }

  // adblock extensions ban words like `analytics` so we use a different file name just so the doc dans render it
  if (spec.ext === 'yml') {
    await run(`mv ${output}/analytics.yml ${output}/searchstats.yml`);
  }
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

    let files = await fsp.readdir(pathToGuides);

    if (guide.names) {
      files = files.filter((file) => guide.names?.some((guideName) => guideName === file.split('.')[0]));
    }

    for (const file of files) {
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

async function handleSnippetFiles(snippets: SnippetsToPush, tempGitDir: string): Promise<void> {
  const output = toAbsolutePath(`${tempGitDir}/${snippets.output}`);

  if (!(await exists(output))) {
    await fsp.mkdir(output, { recursive: true });
  }

  await run(`cp ${toAbsolutePath('docs/bundled/*-snippets.json')} ${output}`);
}

async function pushToRepository(repository: string, config: RepositoryConfiguration): Promise<void> {
  const token = ensureGitHubToken();

  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  if (!process.env.FORCE && !lastCommitMessage.startsWith(commitStartRelease)) {
    console.warn('FORCE not provided or not a commit release, skipping');

    return;
  }

  console.log(`Preparing push to ${OWNER}/${repository}`);

  const tempGitDir = resolve(process.env.RUNNER_TEMP! || toAbsolutePath('foo/local/test'), repository);

  console.info(`cleaning ${tempGitDir}`);

  await fsp.rm(tempGitDir, { force: true, recursive: true });

  console.info(`cloning ${OWNER}/${repository} in ${tempGitDir}`);

  await run(`gh repo clone ${OWNER}/${repository} ${tempGitDir}`);

  await configureGitHubAuthor(tempGitDir);

  await run(`git config --global url.https://${token}@github.com/.insteadOf https://github.com/`);

  for (const task of config.tasks) {
    console.log(`Handling '${task.files.type}' file(s)`);

    await run(`git checkout ${config.baseBranch}`, { cwd: tempGitDir });
    await run(`git pull origin ${config.baseBranch}`, { cwd: tempGitDir });
    await run(`git checkout -B ${task.prBranch}`, { cwd: tempGitDir });

    if (task.files.type === 'specs') {
      await handleSpecFiles(task.files, tempGitDir);
    } else if (task.files.type === 'guides') {
      await handleGuideFiles(task.files, tempGitDir);
    } else if (task.files.type === 'snippets') {
      await handleSnippetFiles(task.files, tempGitDir);
    }

    if (process.env.DRY_RUN) {
      console.log(`asked for a dry run, stopping before push and PR for '${repository}' on task '${task.prBranch}'`);

      continue;
    }

    if (await gitBranchExists(task.prBranch, tempGitDir)) {
      await run(`git fetch origin ${task.prBranch}`, { cwd: tempGitDir });
      await run(`git push -d origin ${task.prBranch}`, { cwd: tempGitDir });
    }

    if ((await getNbGitDiff({ head: null, cwd: tempGitDir })) === 0) {
      console.log(`❎ Skipping push to ${OWNER}/${repository} because there is no change.`);

      continue;
    }

    await run('git add .', { cwd: tempGitDir });
    await gitCommit({
      message: task.commitMessage,
      coAuthors: [author, ...coAuthors],
      cwd: tempGitDir,
    });

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

    await run(`gh --repo ${OWNER}/${repository} pr merge ${data.number} --squash --auto`);

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

/* eslint-disable no-console */
import { copy } from 'fs-extra';

import {
  emptyDirExceptForDotGit,
  gitBranchExists,
  gitCommit,
  LANGUAGES,
  run,
  toAbsolutePath,
  GENERATED_MAIN_BRANCH,
  REPO_URL,
} from '../../common';
import { getLanguageFolder } from '../../config';
import { cloneRepository, configureGitHubAuthor } from '../../release/common';
import { getNbGitDiff } from '../utils';

export function decideWhereToSpread(commitMessage: string): string[] {
  if (commitMessage.startsWith('chore: release')) {
    return [];
  }

  const result = commitMessage.match(/(.+)\((.+)\):/);
  if (!result) {
    // no scope
    return LANGUAGES;
  }

  const scope = result[2];
  return LANGUAGES.includes(scope) ? [scope] : LANGUAGES;
}

export function cleanUpCommitMessage(commitMessage: string): string {
  const result = commitMessage.match(/(.+)\s\(#(\d+)\)$/);
  if (!result) {
    return commitMessage;
  }

  return [result[1], `${REPO_URL}/pull/${result[2]}`].join('\n\n');
}

async function spreadGeneration(): Promise<void> {
  if (!process.env.GITHUB_TOKEN) {
    throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
  }

  if (!(await gitBranchExists(GENERATED_MAIN_BRANCH))) {
    console.log(
      `Skiping because the branch \`${GENERATED_MAIN_BRANCH}\` does not exist.`
    );
    return;
  }

  const lastCommitMessage = await run(`git log -1 --format="%s"`);
  const name = (await run(`git log -1 --format="%an"`)).trim();
  const email = (await run(`git log -1 --format="%ae"`)).trim();
  const commitMessage = cleanUpCommitMessage(lastCommitMessage);
  const langs = decideWhereToSpread(lastCommitMessage);

  await run(`git checkout ${GENERATED_MAIN_BRANCH}`);

  for (const lang of langs) {
    const { tempGitDir } = await cloneRepository({
      lang,
      githubToken: process.env.GITHUB_TOKEN,
      tempDir: process.env.RUNNER_TEMP!,
    });

    const clientPath = toAbsolutePath(getLanguageFolder(lang));
    await emptyDirExceptForDotGit(tempGitDir);
    await copy(clientPath, tempGitDir, { preserveTimestamps: true });

    if (
      (await getNbGitDiff({
        head: null,
        cwd: tempGitDir,
      })) === 0
    ) {
      console.log(`Skipping ${lang} repository, because there is no change.`);
      return;
    }

    await configureGitHubAuthor(tempGitDir);
    await run(`git add .`, { cwd: tempGitDir });
    await gitCommit({
      message: commitMessage,
      coauthor: { name, email },
      cwd: tempGitDir,
    });
    await run(`git push`, { cwd: tempGitDir });
    console.log(`Spread the generation to ${lang} repository.`);
  }
}

if (require.main === module) {
  spreadGeneration();
}

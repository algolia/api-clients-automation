/* eslint-disable no-console */
import { gitCommit, LANGUAGES, run } from '../../common';
import {
  cloneAndApplyGeneration,
  configureGitHubAuthor,
} from '../../release/common';

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
  const result = commitMessage.match(/(.+)\s\(#\d+\)$/);
  return result?.[1] ?? commitMessage;
}

async function spreadGeneration(headRef: string): Promise<void> {
  if (!process.env.GITHUB_TOKEN) {
    throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
  }

  const generatedCodeBranch = `generated/${headRef}`;

  if (!(await run(`git ls-remote --heads origin ${generatedCodeBranch}`))) {
    console.log(`No branch named '${generatedCodeBranch}' was found.`);
    return;
  }

  await run(`git checkout ${generatedCodeBranch}`);
  const lastCommitMessage = await run(`git log -1 --format="%s"`);
  const commitMessage = cleanUpCommitMessage(lastCommitMessage);
  const langs = decideWhereToSpread(lastCommitMessage);

  for (const lang of langs) {
    const { tempGitDir } = await cloneAndApplyGeneration({
      lang,
      githubToken: process.env.GITHUB_TOKEN,
      tempDir: process.env.RUNNER_TEMP!,
    });

    await configureGitHubAuthor(tempGitDir);
    await run(`git add .`, { cwd: tempGitDir });
    await gitCommit({ message: commitMessage, cwd: tempGitDir });
    await run(`git push`, { cwd: tempGitDir });
  }
}

if (require.main === module) {
  const args = process.argv.slice(2);

  if (!args || args.length === 0) {
    throw new Error(
      'The base branch should be passed as a cli parameter of the `spreadGeneration` script.'
    );
  }

  spreadGeneration(args[0]);
}

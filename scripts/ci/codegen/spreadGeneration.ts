import { gitCommit, LANGUAGES, run } from '../../common';
import {
  cloneAndApplyGeneration,
  configureGitHubAuthor,
} from '../../release/common';

const GENERATED_MAIN_BRANCH = `generated/main`;

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

async function spreadGeneration(): Promise<void> {
  if (!process.env.GITHUB_TOKEN) {
    throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
  }

  const lastCommitMessage = await run(`git log -1 --format="%s"`);
  const commitMessage = cleanUpCommitMessage(lastCommitMessage);
  const langs = decideWhereToSpread(lastCommitMessage);

  await run(`git checkout ${GENERATED_MAIN_BRANCH}`);

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
  spreadGeneration();
}

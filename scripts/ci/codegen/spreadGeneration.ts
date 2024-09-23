/* eslint-disable no-console */
import * as core from '@actions/core';
import { copy } from 'fs-extra';

import {
  emptyDirExceptForDotGit,
  gitCommit,
  LANGUAGES,
  run,
  toAbsolutePath,
  REPO_URL,
  ensureGitHubToken,
  configureGitHubAuthor,
  setVerbose,
} from '../../common.ts';
import { getLanguageFolder, getPackageVersionDefault } from '../../config.ts';
import { getNewReleasedTag } from '../../release/common.ts';
import type { Language } from '../../types.ts';
import { cloneRepository, getNbGitDiff } from '../utils.ts';

import text, { commitStartRelease } from './text.ts';

export function cleanUpCommitMessage(commitMessage: string, version: string): string {
  if (commitMessage.startsWith(commitStartRelease)) {
    return `chore: release ${version}`;
  }

  const prCommit = commitMessage.match(/(.+)\s\(#(\d+)\)/);

  if (!prCommit) {
    return commitMessage;
  }

  return [`${prCommit[1]} ${text.commitEndMessage}`, `${REPO_URL}/pull/${prCommit[2]}`].join('\n\n');
}

async function spreadGeneration(): Promise<void> {
  const githubToken = ensureGitHubToken();

  console.log('Starting spread generation script...');
  const lastCommitMessage = await run('git log -1 --format="%s"');
  const author = (await run('git log -1 --format="Co-authored-by: %an <%ae>"')).trim();
  const coAuthors = (await run('git log -1 --format="%(trailers:key=Co-authored-by)"'))
    .split('\n')
    .map((coAuthor) => coAuthor.trim())
    .filter(Boolean);

  const IS_RELEASE_COMMIT = lastCommitMessage.startsWith(commitStartRelease);
  console.log('Spreading code to the following repositories:', LANGUAGES.join(' | '));

  // At this point, we know the release will happen on at least one client
  // So we want to set the released tag at the monorepo level too.
  if (IS_RELEASE_COMMIT) {
    console.log('Creating new `released` tag for latest commit');
    await run(`git tag ${await getNewReleasedTag()}`);
    await run('git push --tags');
  }

  const pushed: Language[] = [];

  for (const lang of LANGUAGES) {
    try {
      const { tempGitDir } = await cloneRepository({
        lang,
        githubToken,
        tempDir: process.env.RUNNER_TEMP!,
      });

      const clientPath = toAbsolutePath(getLanguageFolder(lang));
      await emptyDirExceptForDotGit(tempGitDir);
      await copy(clientPath, tempGitDir, { preserveTimestamps: true });
      await run("find . -name  '.openapi-generator*' | xargs -I{} rm -rf {}");

      if (
        (await getNbGitDiff({
          head: null,
          cwd: tempGitDir,
        })) === 0
      ) {
        console.log(`❎ Skipping ${lang} repository, because there is no change.`);
        continue;
      } else {
        console.log(`✅ Spreading code to the ${lang} repository.`);
      }

      const version = getPackageVersionDefault(lang);
      const commitMessage = cleanUpCommitMessage(lastCommitMessage, version);

      await configureGitHubAuthor(tempGitDir);

      await run('git add .', { cwd: tempGitDir });
      await gitCommit({
        message: commitMessage,
        coAuthors: [author, ...coAuthors],
        cwd: tempGitDir,
      });
      await run('git push', { cwd: tempGitDir });

      // In case of a release commit, we also want to update tags on the clients repositories
      // ruby tag is already pushed by `rake release`
      if (IS_RELEASE_COMMIT && lang !== 'ruby') {
        // Go needs a 'v' prefix for tags.
        const tagVersion = lang === 'go' ? `v${version}` : version;

        console.log(`Processing release commit, creating new release tag ('${version}') for '${lang}' repository.`);

        // we always want to delete the tag in case it exists
        await run(`git tag -d ${tagVersion} || true`, { cwd: tempGitDir });
        await run(`git tag ${tagVersion} HEAD`, { cwd: tempGitDir });
        await run('git push --tags', { cwd: tempGitDir });
      }

      pushed.push(lang);

      console.log(`✅ Code generation successfully pushed to ${lang} repository.`);
    } catch (e) {
      console.error(`Release failed for language ${lang}: ${e}`);
    }
  }

  core.setOutput('PUSHED_LANGUAGES', pushed.join(' '));
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  spreadGeneration();
}

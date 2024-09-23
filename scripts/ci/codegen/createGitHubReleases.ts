/* eslint-disable no-console */

import { ensureGitHubToken, getOctokit, OWNER, run, setVerbose, toAbsolutePath } from '../../common.ts';
import { isPreRelease } from '../../release/sla.ts';
import type { Language } from '../../types.ts';
import { cloneRepository } from '../utils.ts';

import { commitStartRelease } from './text.ts';

async function createGitHubRelease(lang: Language): Promise<void> {
  // **Full Changelog**:

  const githubToken = ensureGitHubToken();

  // fetch all release tags for this lang
  const { tempGitDir } = await cloneRepository({
    lang,
    githubToken,
    tempDir: process.env.RUNNER_TEMP! || toAbsolutePath('foo/local/test'),
  });
  await run('git fetch --all --tags', { cwd: tempGitDir });

  let tags = (await run('git describe --abbrev=0 --tags $(git rev-list --tags) --always', { cwd: tempGitDir })).split(
    '\n',
  );

  if (tags.length === 0) {
    throw new Error(`unable to find tags for language ${lang}`);
  }

  const newVersion = tags[0];
  const isMajor = newVersion.endsWith('0.0');
  let previousVersion = '';

  // if we are not on the major, we create a release for the last version, otherwise we get every versions of the pre release
  if (!isMajor) {
    previousVersion = tags[1];
  } else {
    tags = tags.filter((tag) => tag.startsWith(newVersion) && isPreRelease(tag));
    previousVersion = tags[tags.length - 1];
  }

  const repository = `algoliasearch-client-${lang}`;
  const repositoryLink = `https://github.com/${OWNER}/${repository}`;
  const content = `
New ${isMajor ? '**major** ' : ''}version released!

→ [Browse the Algolia documentation](https://www.algolia.com/doc/libraries/${lang})
→ [Browse the changelog](${repositoryLink}/blob/main/CHANGELOG.md)
→ [Browse the commits](${repositoryLink}/compare/${previousVersion}...${newVersion})`;

  try {
    await getOctokit().repos.createRelease({
      owner: OWNER,
      repo: repository,
      tag_name: newVersion,
      name: newVersion,
      body: content,
    });

    console.log(`release for ${lang} created: ${repositoryLink}/releases/tag/${newVersion}`);
  } catch (e: any) {
    if (e.status === 422) {
      console.log(`release for ${lang} already exist: ${repositoryLink}/releases/tag/${newVersion}`);
    } else {
      throw new Error(e);
    }
  }
}

async function createGitHubReleases(languagesReleased: Language[]): Promise<void> {
  const lastCommitMessage = await run('git log -1 --format="%s"');

  if (!lastCommitMessage.startsWith(commitStartRelease)) {
    console.log('No release commit found, skipping release generation');

    return;
  }

  await Promise.all(
    languagesReleased.map(async (lang) => {
      console.log(`> creating GitHub release for ${lang}`);

      return await createGitHubRelease(lang);
    }),
  );
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  createGitHubReleases(process.argv.slice(2) as Language[]);
}

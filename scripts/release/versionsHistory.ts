/* eslint-disable no-console */
// @ts-nocheck this file is broken while the VersionsHistory is unclear
import fsp from 'fs/promises';

import semver from 'semver';

import { cloneRepository } from '../ci/utils.js';
import { ensureGitHubToken, LANGUAGES, run, toAbsolutePath } from '../common.js';
import type { Language } from '../types.js';

import { preReleaseRegExp } from './createReleasePR.js';
import type { Version, Versions } from './types.js';

export function isPreRelease(version: string): boolean {
  return (
    version.match(preReleaseRegExp) !== null ||
    semver.prerelease(version) !== null ||
    version.includes('beta') ||
    version.includes('alpha') ||
    version.startsWith('0') ||
    isNaN(parseInt(version.charAt(0), 10))
  );
}

// fetches the git tags on the given `lang` repository, throws if none.
async function getTags(lang: Language): Promise<string[]> {
  const githubToken = ensureGitHubToken();

  // fetch all release tags for this lang
  const { tempGitDir } = await cloneRepository({
    lang,
    githubToken,
    tempDir: process.env.RUNNER_TEMP! || toAbsolutePath('foo/local/test'),
  });
  await run('git fetch --all --tags', { cwd: tempGitDir });

  const tags = (
    await run("git for-each-ref --sort=creatordate --format '%(refname:short) %(creatordate)' refs/tags", {
      cwd: tempGitDir,
    })
  ).split('\n');

  if (tags.length === 0) {
    throw new Error(`unable to find tags for language ${lang}`);
  }

  return tags;
}

/*
 * udpates the release.config.json file for the given `lang` by generating an VersionsHistory policy map of every versions in a now-2years window.
 * the given `version` to release is added to the map once existing tags are computed.
 * any pre-release and non-semver tags are excluded
 */
export function generateLanguageVersionsHistory(
  tags: string[],
  lang: Language,
  version: Version,
): Record<string, { releaseDate: string }> {
  const versions: Record<string, { releaseDate: string }> = {};

  let prevTagVersion = '';

  for (const tag of tags) {
    // eslint-disable-next-line prefer-const
    let [tagVersion, tagReleaseDate] = tag.split(/(?<=^\S+)\s/);

    // edge case for go which tags version with a v prefix
    if (tagVersion.startsWith('v')) {
      tagVersion = tagVersion.replace(/^v/, '');
    }

    // we skip any form of pre-releases because they are not part of the VersionsHistory
    if (isPreRelease(tagVersion)) {
      continue;
    }

    versions[tagVersion] = {
      releaseDate: new Date(tagReleaseDate).toISOString().split('T')[0],
    };

    prevTagVersion = tagVersion;
  }

  // if there's no release planned, just skip this language
  if (version?.next && !isPreRelease(version?.next) && version?.next !== prevTagVersion) {
    versions[version.next] = {
      releaseDate: new Date().toISOString().split('T')[0],
    };
  }

  return versions;
}

export async function generateVersionsHistory(versions: Versions): Promise<void> {
  const versionsHistory = {};
  await Promise.all(
    LANGUAGES.map(async (lang) => {
      console.log(`> generating VersionsHistory for the ${lang} client`);

      const tags = await getTags(lang);

      versionsHistory[lang] = generateLanguageVersionsHistory(tags, lang, versions[lang]);
    }),
  );

  await fsp.writeFile(toAbsolutePath('config/versions.history.json'), JSON.stringify(versionsHistory, null, 2));
}
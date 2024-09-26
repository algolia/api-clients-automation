/* eslint-disable no-console */
// @ts-nocheck this file is broken while the VersionsHistory is unclear
import fsp from 'fs/promises';

import semver from 'semver';

import { cloneRepository } from '../ci/utils.js';
import { ensureGitHubToken, fullReleaseConfig, LANGUAGES, run, toAbsolutePath } from '../common.js';
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
export function generateLanguageVersionsHistory(tags: string[], lang: Language, version: Version): void {
  const start = new Date();

  if (!('versionsHistory' in fullReleaseConfig)) {
    fullReleaseConfig.versionsHistory = {};
  }

  // @ts-expect-error -- force reset our versionsHistory policy to remove outdated ones
  fullReleaseConfig.versionsHistory[lang] = {};

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

    const { major: tagMajor, minor: tagMinor } = getMajorMinor(lang, tagVersion);

    if (tagMajor === 0 && tagMinor === 0) {
      continue;
    }

    const releaseDate = new Date(tagReleaseDate);
    const deadline = new Date(releaseDate);
    deadline.setFullYear(releaseDate.getFullYear() + 3);

    if (releaseDate.getTime() > deadline.getTime()) {
      continue;
    }

    fullReleaseConfig.versionsHistory[lang][tagVersion] = {
      releaseDate: releaseDate.toISOString().split('T')[0],
    };

    prevTagVersion = tagVersion;
  }

  // if there's no release planned, just skip this language
  if (!version?.next || isPreRelease(version?.next) || version?.next === prevTagVersion) {
    return;
  }

  fullReleaseConfig.versionsHistory[lang][version.next] = {
    releaseDate: start.toISOString().split('T')[0],
  };
}

export async function generateVersionsHistory(versions: Versions): Promise<void> {
  await Promise.all(
    LANGUAGES.map(async (lang) => {
      console.log(`> generating VersionsHistory for the ${lang} client`);

      const tags = await getTags(lang);

      return generateLanguageVersionsHistory(tags, lang, versions[lang]);
    }),
  );

  await fsp.writeFile(toAbsolutePath('config/release.config.json'), JSON.stringify(fullReleaseConfig, null, 2));
}

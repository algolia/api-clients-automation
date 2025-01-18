import fsp from 'fs/promises';

import semver from 'semver';

import { cloneRepository } from '../ci/utils.ts';
import { ensureGitHubToken, LANGUAGES, run, toAbsolutePath } from '../common.ts';
import type { Language } from '../types.ts';

import { preReleaseRegExp } from './createReleasePR.ts';
import type { Version, Versions } from './types.ts';

// the date of the generated api clients release
const generatedReleaseDate = new Date('2024-08-14');
const slaEndDate = new Date(generatedReleaseDate.setFullYear(generatedReleaseDate.getFullYear() + 2));

type Status = 'eligible' | 'not eligible';

type Release = {
  releaseDate: string;
};

type Support = {
  supportStatus: Status;
  supportEndDate?: string;
};

type SLA = {
  slaStatus: Status;
  slaEndDate?: string;
};

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
  version: Version,
): Record<string, { releaseDate: string }> {
  const versionsHistory: Record<string, Release & SLA & Support> = {};

  let currentMajor = semver.major(version.current);
  let currentMajorMinor = semver.minor(version.current);
  let previousMajor = currentMajor > 1 ? currentMajor - 1 : undefined;
  let previousMajorMinor = 0;

  // first we go through every tags to build the version history and save the current major.minor and previous major.minor
  for (const tag of tags) {
    let [tagVersion, tagReleaseDate] = tag.split(/(?<=^\S+)\s/);

    // edge case for go which tags version with a v prefix
    if (tagVersion.startsWith('v')) {
      tagVersion = tagVersion.replace(/^v/, '');
    }

    // we skip any form of pre-releases because they are not part of the VersionsHistory
    if (isPreRelease(tagVersion) || !semver.valid(tagVersion)) {
      continue;
    }

    // find the latest minor of the previous major
    if (semver.major(tagVersion) === previousMajor && semver.minor(tagVersion) > previousMajorMinor) {
      previousMajorMinor = semver.minor(tagVersion);
    }

    // default everything to non eligible
    versionsHistory[tagVersion] = {
      slaStatus: 'not eligible',
      supportStatus: 'not eligible',
      releaseDate: new Date(tagReleaseDate).toISOString().split('T')[0],
    };
  }

  // then re-compute the current/previous major.minor based on the current release
  if (version?.next && !isPreRelease(version.next) && version.next !== version.current) {
    versionsHistory[version.next] = {
      releaseDate: new Date().toISOString().split('T')[0],
      slaStatus: 'eligible',
      supportStatus: 'eligible',
    };

    switch (version.releaseType) {
      // major shift left: previous=current, current=next
      case 'major':
        previousMajor = semver.major(version.current);
        previousMajorMinor = semver.minor(version.current);

        currentMajor = semver.major(version.next);
        currentMajorMinor = semver.minor(version.next);
        break;
      // minor overrides the current major.minor
      case 'minor':
        currentMajorMinor = semver.minor(version.next);
        break;
      // nothing changes for the rest
      default:
        break;
    }
  }

  // now we can compute the support and SLA policies:
  // previous major:
  // - SLA:     every versions with a 2 year deadline
  // - Support: every versions of the latest minor with a 2 year deadline
  // current major:
  // - SLA:     every versions
  // - Support: every versions of the latest minor
  Object.keys(versionsHistory).forEach((versionHistory) => {
    switch (semver.major(versionHistory)) {
      case previousMajor:
        versionsHistory[versionHistory].slaStatus = 'eligible';
        versionsHistory[versionHistory].slaEndDate = slaEndDate.toISOString().split('T')[0];

        if (semver.minor(versionHistory) === previousMajorMinor) {
          versionsHistory[versionHistory].supportStatus = 'eligible';
          versionsHistory[versionHistory].supportEndDate = slaEndDate.toISOString().split('T')[0];
        }
      case currentMajor:
        versionsHistory[versionHistory].slaStatus = 'eligible';

        if (semver.minor(versionHistory) === currentMajorMinor) {
          versionsHistory[versionHistory].supportStatus = 'eligible';
        }
    }
  });

  return versionsHistory;
}

export async function generateVersionsHistory(versions: Versions): Promise<void> {
  const versionsHistory = {};
  await Promise.all(
    LANGUAGES.map(async (lang) => {
      console.log(`> generating VersionsHistory for the ${lang} client`);

      const tags = await getTags(lang);

      if (versions[lang]) {
        versionsHistory[lang] = generateLanguageVersionsHistory(tags, versions[lang]);
      }
    }),
  );

  // sort by language
  const sortedVersionsHistory = Object.keys(versionsHistory)
    .sort()
    .reduce((acc, key) => {
      acc[key] = versionsHistory[key];
      return acc;
    }, {});

  await fsp.writeFile(
    toAbsolutePath('docs/versions-history-with-sla-and-support-policy.json'),
    JSON.stringify(sortedVersionsHistory, null, 2),
  );
}

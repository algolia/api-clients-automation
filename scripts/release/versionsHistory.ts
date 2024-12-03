import fsp from 'fs/promises';

import semver from 'semver';

import { cloneRepository } from '../ci/utils.js';
import { ensureGitHubToken, LANGUAGES, run, toAbsolutePath } from '../common.js';
import type { Language } from '../types.js';

import { preReleaseRegExp } from './createReleasePR.js';
import type { Version, Versions } from './types.js';

// the date of the generated api clients release
const generatedReleaseDate = new Date('2024-08-14');
const slaEndDate = new Date(generatedReleaseDate.setFullYear(generatedReleaseDate.getFullYear() + 2));

type Status = 'eligible' | 'not eligible' | 'replaced';

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

function getCurrentMajor(version: string): number {
  if (!version) {
    return 0;
  }

  const matches = version.match(/\d+/);

  if (!matches || matches.length === 0) {
    return 0;
  }

  return parseInt(matches[0], 10);
}

function getEligibility(currentMajor: number, previousMajor: number, version: string): SLA & Support {
  const versionMajor = getCurrentMajor(version);

  // for the current major we provide:
  // - SLA on every versions
  // - Support on the latest version (will be handled later in `generateLanguageVersionsHistory`)
  if (versionMajor == currentMajor) {
    return { slaStatus: 'eligible', supportStatus: 'not eligible' };
  }

  // for the previous major we provide:
  // - SLA on every versions, with a `replaced` mention indicatin there's an other available version
  // - Support on the latest version (will be handled later in `generateLanguageVersionsHistory`)
  if (versionMajor == previousMajor && slaEndDate >= new Date()) {
    return {
      slaStatus: 'replaced',
      slaEndDate: slaEndDate.toISOString().split('T')[0],
      supportStatus: 'not eligible',
    };
  }

  return { slaStatus: 'not eligible', supportStatus: 'not eligible' };
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
  const versions: Record<string, Release & SLA & Support> = {};

  const currentMajor = getCurrentMajor(version.current);
  const previousMajor = currentMajor - 1 || currentMajor;
  let latestPreviousMajorVersion = '';
  let previousTagVersion = '';

  for (const tag of tags) {
    let [tagVersion, tagReleaseDate] = tag.split(/(?<=^\S+)\s/);

    // edge case for go which tags version with a v prefix
    if (tagVersion.startsWith('v')) {
      tagVersion = tagVersion.replace(/^v/, '');
    }

    // we skip any form of pre-releases because they are not part of the VersionsHistory
    if (isPreRelease(tagVersion)) {
      continue;
    }

    // we keep track of the latest encountered previous major version, so we can set the support policy when the iterator is done
    if (getCurrentMajor(tagVersion) === previousMajor) {
      latestPreviousMajorVersion = tagVersion;
    }

    previousTagVersion = tagVersion;

    versions[tagVersion] = {
      ...getEligibility(currentMajor, previousMajor, tagVersion),
      releaseDate: new Date(tagReleaseDate).toISOString().split('T')[0],
    };
  }

  // only the latest previous major version and latest current version receives support
  if (
    latestPreviousMajorVersion &&
    (previousMajor !== currentMajor || (version.next && previousMajor !== getCurrentMajor(version?.next)))
  ) {
    versions[latestPreviousMajorVersion] = {
      ...versions[latestPreviousMajorVersion],
      supportStatus: 'eligible',
      supportEndDate: slaEndDate.toISOString().split('T')[0],
    };
  }

  // if there's no release planned, just skip this language
  if (version?.next && !isPreRelease(version.next)) {
    versions[version.next] = {
      releaseDate:
        version.next !== previousTagVersion
          ? new Date().toISOString().split('T')[0]
          : versions[version.next].releaseDate,
      slaStatus: 'eligible',
      supportStatus: 'eligible',
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

  await fsp.writeFile(toAbsolutePath('config/versions.history.json'), JSON.stringify(sortedVersionsHistory, null, 2));
}

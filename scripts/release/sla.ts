/* eslint-disable no-console */
import fsp from 'fs/promises';

import semver from 'semver';

import { cloneRepository } from '../ci/utils.js';
import { ensureGitHubToken, fullReleaseConfig, LANGUAGES, run, toAbsolutePath } from '../common.js';
import type { Language } from '../types.js';

import { preReleaseRegExp } from './createReleasePR.js';
import type { Versions } from './types.js';

function getMajorMinor(lang: Language, version: string): { major: number; minor: number } {
  const matches = version.match(/(\d+)\.(\d+)/);

  if (!matches || matches.length < 3) {
    throw new Error(`unable to parse version '${version}' for language '${lang}'`);
  }

  return { major: parseInt(matches[1], 10), minor: parseInt(matches[2], 10) };
}

// isPreRelease
function isPreRelease(version: string): boolean {
  return (
    version.match(preReleaseRegExp) !== null ||
    semver.prerelease(version) !== null ||
    version.includes('beta') ||
    version.includes('alpha') ||
    version.startsWith('0') ||
    isNaN(parseInt(version.charAt(0), 10))
  );
}

function setSupportStatus(lang: Language, version: string, status: 'active' | 'inactive'): void {
  if (status === 'inactive') {
    delete fullReleaseConfig.sla[lang][version].supportStart;
    delete fullReleaseConfig.sla[lang][version].supportEnd;
  }

  fullReleaseConfig.sla[lang][version].supportStatus = status;
}

// fetch the git tags for the given `lang`
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
    await run(
      "git for-each-ref --sort=creatordate --format '%(refname:short) %(creatordate)' refs/tags",
      { cwd: tempGitDir },
    )
  ).split('\n');

  if (tags.length === 0) {
    throw new Error(`unable to find tags for language ${lang}`);
  }

  return tags;
}

// updates the release.config.json in order to generate a map of version and SLA for every clients
export function generateLanguageSLA(tags: string[], lang: Language, versions: Versions): void {
  const start = new Date();

  // @ts-expect-error -- force reset our sla policy to remove outdated ones
  fullReleaseConfig.sla[lang] = {};

  let prevTagMajor = 0;
  let prevTagMinor = 0;
  let prevTagVersion = '';

  for (const tag of tags) {
    // eslint-disable-next-line prefer-const
    let [tagVersion, tagReleaseDate] = tag.split(/(?<=^\S+)\s/);

    // edge case for go which tags version with a v prefix
    if (tagVersion.startsWith('v')) {
      tagVersion = tagVersion.replace(/^v/, '');
    }

    // we skip any form of pre-releases because they are not part of the SLA
    if (isPreRelease(tagVersion)) {
      continue;
    }

    const releaseDate = new Date(tagReleaseDate);
    const deadline = new Date(releaseDate);
    deadline.setFullYear(releaseDate.getFullYear() + 2);

    if (start.getTime() > deadline.getTime()) {
      continue;
    }

    const { major: tagMajor, minor: tagMinor } = getMajorMinor(lang, tagVersion);

    fullReleaseConfig.sla[lang][tagVersion] = {
      releaseDate: releaseDate.toISOString().split('T')[0],
    };

    // the current tag version defines the maintenance policy of the previous one
    if (prevTagVersion !== '') {
      fullReleaseConfig.sla[lang][prevTagVersion] = {
        ...fullReleaseConfig.sla[lang][prevTagVersion],
        supportStart: releaseDate.toISOString().split('T')[0],
        supportEnd: deadline.toISOString().split('T')[0],
        supportStatus: 'maintenance',
      };

      // if the previous tag is on the same major.minor version, we don't support it
      if (tagMajor === prevTagMajor && tagMinor === prevTagMinor) {
        setSupportStatus(lang, prevTagVersion, 'inactive');
      }
    }

    prevTagMajor = tagMajor;
    prevTagMinor = tagMinor;
    prevTagVersion = tagVersion;
  }

  // if there's no release planned, or if the release is a pre-release, then the latest tagged version is the active one
  if (!versions[lang]?.next || isPreRelease(versions[lang]?.next)) {
    return setSupportStatus(lang, prevTagVersion, 'active');
  }

  const { major: nextMajor, minor: nextMinor } = getMajorMinor(lang, versions[lang].next);

  // if we release a new patch on the same major.minor version as the active one, we set it as inactive
  if (nextMajor === prevTagMajor && nextMinor === prevTagMinor) {
    return setSupportStatus(lang, prevTagVersion, 'inactive');
  }

  // if it's a new major or minor, it's just a new active version, the previous one is already in maintenance
  return setSupportStatus(lang, versions[lang].next, 'active');
}

export async function generateSLA(versions: Versions): Promise<void> {
  await Promise.all(
    LANGUAGES.map(async (lang) => {
      console.log(`> generating SLA for the ${lang} client`);

      const tags = await getTags(lang);

      return generateLanguageSLA(tags, lang, versions);
    }),
  );
  // await generateLanguageSLA('csharp', versions);

  await fsp.writeFile(
    toAbsolutePath('config/release.config.json'),
    JSON.stringify(fullReleaseConfig, null, 2),
  );
}

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

function isPreRelease(version: string): boolean {
  return (
    version.match(preReleaseRegExp) !== null ||
    semver.prerelease(version) !== null ||
    version.includes('beta') ||
    version.includes('alpha')
  );
}

// updates the release.config.json in order to generate a map of version and SLA for every clients
export async function generateLanguageSLA(lang: Language, versions: Versions): Promise<void> {
  const githubToken = ensureGitHubToken();
  const start = new Date();
  const end = new Date(new Date().setFullYear(start.getFullYear() + 2));

  console.log(`> generating SLA for the ${lang} client`);

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

  // @ts-expect-error -- force reset our sla policy to remove outdated ones
  fullReleaseConfig.sla[lang] = {};

  let prevTagMajor = 0;
  let prevTagMinor = 0;
  let activeVersion = '';

  for (const tag of tags) {
    // eslint-disable-next-line prefer-const
    let [tagVersion, tagReleaseDate] = tag.split(/(?<=^\S+)\s/);

    if (tagVersion.startsWith('v')) {
      tagVersion = tagVersion.replace(/^v/, '');
    }

    // we skip any form of pre-releases
    if (isPreRelease(tagVersion)) {
      continue;
    }

    const releaseDate = new Date(tagReleaseDate);
    const deadline = new Date(releaseDate);
    deadline.setFullYear(releaseDate.getFullYear() + 2);

    // if it's older than today, it's not supported anymore
    if (start.getTime() > deadline.getTime()) {
      continue;
    }

    const { major: tagMajor, minor: tagMinor } = getMajorMinor(lang, tagVersion);

    // we only want the last patch of the current major.minor
    if (tagMajor === prevTagMajor && tagMinor === prevTagMinor) {
      delete fullReleaseConfig.sla[lang][activeVersion];
    }

    fullReleaseConfig.sla[lang][tagVersion] = {
      start: releaseDate.toISOString().split('T')[0],
      end: deadline.toISOString().split('T')[0],
      status: 'maintenance',
    };
    prevTagMajor = tagMajor;
    prevTagMinor = tagMinor;
    activeVersion = tagVersion;
  }

  // if there's no release planned, or if the release is a pre-release, then the latest tagged version is the active one
  if (!versions[lang]?.next || isPreRelease(versions[lang]?.next)) {
    fullReleaseConfig.sla[lang][activeVersion].status = 'active';

    return;
  }

  const { major: nextMajor, minor: nextMinor } = getMajorMinor(lang, versions[lang].next);

  // if we are releasing the same major.minor version, we erase the current and only provide SLA for the latest patch
  if (nextMajor === prevTagMajor && nextMinor === prevTagMinor) {
    delete fullReleaseConfig.sla[lang][activeVersion];
  }

  // if it's a new major or minor, it's just a new active version
  fullReleaseConfig.sla[lang][versions[lang].next] = {
    start: start.toISOString().split('T')[0],
    end: end.toISOString().split('T')[0],
    status: 'active',
  };
}

export async function generateSLA(versions: Versions): Promise<void> {
  await Promise.all(LANGUAGES.map((lang) => generateLanguageSLA(lang, versions)));
  // generateLanguageSLA('javascript', versions);

  await fsp.writeFile(
    toAbsolutePath('config/release.config.json'),
    JSON.stringify(fullReleaseConfig, null, 2),
  );
}

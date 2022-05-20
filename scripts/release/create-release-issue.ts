/* eslint-disable no-console */
import chalk from 'chalk';
import dotenv from 'dotenv';
import semver from 'semver';

import {
  LANGUAGES,
  ROOT_ENV_PATH,
  run,
  MAIN_BRANCH,
  OWNER,
  REPO,
} from '../common';
import { getPackageVersionDefault } from '../config';
import type { Language } from '../types';

import { RELEASED_TAG, getOctokit } from './common';
import TEXT from './text';
import type {
  Versions,
  VersionsWithoutReleaseType,
  PassedCommit,
  Commit,
} from './types';

dotenv.config({ path: ROOT_ENV_PATH });

export function readVersions(): VersionsWithoutReleaseType {
  return Object.fromEntries(
    LANGUAGES.map((lang) => [lang, { current: getPackageVersionDefault(lang) }])
  );
}

export function getVersionChangesText(versions: Versions): string {
  return LANGUAGES.map((lang) => {
    const { current, releaseType, noCommit, skipRelease } = versions[lang];

    if (noCommit) {
      return `- ~${lang}: ${current} (${TEXT.noCommit})~`;
    }

    if (!current) {
      return `- ~${lang}: (${TEXT.currentVersionNotFound})~`;
    }

    const next = semver.inc(current, releaseType!);
    const checked = skipRelease ? ' ' : 'x';
    return [
      `- [${checked}] ${lang}: ${current} -> \`${releaseType}\` _(e.g. ${next})_`,
      skipRelease && TEXT.descriptionForSkippedLang,
    ]
      .filter(Boolean)
      .join('\n');
  }).join('\n');
}

export function getSkippedCommitsText({
  commitsWithoutLanguageScope,
  commitsWithUnknownLanguageScope,
}: {
  commitsWithoutLanguageScope: string[];
  commitsWithUnknownLanguageScope: string[];
}): string {
  if (
    commitsWithoutLanguageScope.length === 0 &&
    commitsWithUnknownLanguageScope.length === 0
  ) {
    return '_(None)_';
  }

  return `</p>
<p>${TEXT.skippedCommitsDesc}</p>

<details>
  <summary>
    <i>Commits without language scope:</i>
  </summary>

  ${commitsWithoutLanguageScope.map((commit) => `- ${commit}`).join('\n')}
</details>

<details>
  <summary>
    <i>Commits with unknown language scope:</i>
  </summary>

  ${commitsWithUnknownLanguageScope.map((commit) => `- ${commit}`).join('\n')}
</details>`;
}

export function parseCommit(commit: string): Commit {
  const LENGTH_SHA1 = 8;
  const hash = commit.slice(0, LENGTH_SHA1);
  let message = commit.slice(LENGTH_SHA1 + 1);
  let type = message.slice(0, message.indexOf(':'));
  const matchResult = type.match(/(.+)\((.+)\)/);
  if (!matchResult) {
    return {
      error: 'missing-language-scope',
    };
  }
  message = message.slice(message.indexOf(':') + 1).trim();
  type = matchResult[1];
  const lang = matchResult[2] as Language;
  // A spec commit should be added to every clients, as it mostly imply a client change.
  const allowedLanguages = [...LANGUAGES, 'specs'];

  if (!allowedLanguages.includes(lang)) {
    return { error: 'unknown-language-scope' };
  }

  return {
    hash,
    type, // `fix` | `feat` | `chore` | ...
    lang, // `specs` | `javascript` | `php` | `java` | ...
    message,
    raw: commit,
  };
}

/* eslint-disable no-param-reassign */
export function decideReleaseStrategy({
  versions,
  commits,
}: {
  versions: VersionsWithoutReleaseType;
  commits: PassedCommit[];
}): Versions {
  return Object.entries(versions).reduce(
    (versionsWithReleaseType: Versions, [lang, version]) => {
      const commitsPerLang = commits.filter(
        (commit) => commit.lang === lang || commit.lang === 'specs'
      );
      const currentVersion = versions[lang].current;

      if (commitsPerLang.length === 0) {
        versionsWithReleaseType[lang] = {
          ...version,
          noCommit: true,
          releaseType: null,
        };
        return versionsWithReleaseType;
      }

      if (semver.prerelease(currentVersion)) {
        // if version is like 0.1.2-beta.1, it increases to 0.1.2-beta.2, even if there's a breaking change.
        versionsWithReleaseType[lang] = {
          ...version,
          releaseType: 'prerelease',
        };
        return versionsWithReleaseType;
      }

      if (
        commitsPerLang.some((commit) =>
          commit.message.includes('BREAKING CHANGE')
        )
      ) {
        versionsWithReleaseType[lang] = {
          ...version,
          releaseType: 'major',
        };
        return versionsWithReleaseType;
      }

      const commitTypes = new Set(commitsPerLang.map(({ type }) => type));
      if (commitTypes.has('feat')) {
        versionsWithReleaseType[lang] = {
          ...version,
          releaseType: 'minor',
        };
        return versionsWithReleaseType;
      }

      versionsWithReleaseType[lang] = {
        ...version,
        releaseType: 'patch',
        ...(commitTypes.has('fix') ? undefined : { skipRelease: true }),
      };
      return versionsWithReleaseType;
    },
    {}
  );
}
/* eslint-enable no-param-reassign */

async function createReleaseIssue(): Promise<void> {
  if (!process.env.GITHUB_TOKEN) {
    throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
  }

  if ((await run('git rev-parse --abbrev-ref HEAD')) !== MAIN_BRANCH) {
    throw new Error(
      `You can run this script only from \`${MAIN_BRANCH}\` branch.`
    );
  }

  await run(`git rev-parse --verify refs/tags/${RELEASED_TAG}`, {
    errorMessage: '`released` tag is missing in this repository.',
  });

  console.log('Pulling from origin...');
  await run('git fetch origin');
  await run('git pull');

  const commitsWithUnknownLanguageScope: string[] = [];
  const commitsWithoutLanguageScope: string[] = [];

  // Remove the local tag, and fetch it from the remote.
  // We move the `released` tag as we release, so we need to make it up-to-date.
  await run(`git tag -d ${RELEASED_TAG}`);
  await run(
    `git fetch origin refs/tags/${RELEASED_TAG}:refs/tags/${RELEASED_TAG}`
  );

  // Reading commits since last release
  const latestCommits = (
    await run(`git log --oneline --abbrev=8 ${RELEASED_TAG}..${MAIN_BRANCH}`)
  )
    .split('\n')
    .filter(Boolean);

  if (latestCommits.length === 0) {
    console.log(
      chalk.bgYellow('[INFO]'),
      `Skipping release because no commit has been added since \`releated\` tag.`
    );
    // eslint-disable-next-line no-process-exit
    process.exit(0);
  }

  const validCommits = latestCommits
    .map((commitMessage) => {
      const commit = parseCommit(commitMessage);

      if ('error' in commit) {
        if (commit.error === 'missing-language-scope') {
          commitsWithoutLanguageScope.push(commitMessage);
          return undefined;
        }

        if (commit.error === 'unknown-language-scope') {
          commitsWithUnknownLanguageScope.push(commitMessage);
          return undefined;
        }
      }

      return commit;
    })
    .filter(Boolean) as PassedCommit[];

  const versions = decideReleaseStrategy({
    versions: readVersions(),
    commits: validCommits,
  });

  const versionChanges = getVersionChangesText(versions);

  const skippedCommits = getSkippedCommitsText({
    commitsWithoutLanguageScope,
    commitsWithUnknownLanguageScope,
  });

  const changelogs = LANGUAGES.filter(
    (lang) => !versions[lang].noCommit && versions[lang].current
  )
    .flatMap((lang) => {
      if (versions[lang].noCommit) {
        return [];
      }

      return [
        `### ${lang}`,
        ...validCommits
          .filter((commit) => commit.lang === lang)
          .map((commit) => `- ${commit.raw}`),
      ];
    })
    .join('\n');

  const body = [
    TEXT.header,
    TEXT.versionChangeHeader,
    versionChanges,
    TEXT.descriptionVersionChanges,
    TEXT.indenpendentVersioning,
    TEXT.changelogHeader,
    TEXT.changelogDescription,
    changelogs,
    TEXT.skippedCommitsHeader,
    skippedCommits,
    TEXT.approvalHeader,
    TEXT.approval,
  ].join('\n\n');

  const octokit = getOctokit(process.env.GITHUB_TOKEN);

  octokit.rest.issues
    .create({
      owner: OWNER,
      repo: REPO,
      title: `chore: release ${new Date().toISOString().split('T')[0]}`,
      body,
    })
    .then((result) => {
      const {
        data: { number, html_url: url },
      } = result;

      console.log('');
      console.log(`Release issue #${number} is ready for review.`);
      console.log(`  > ${url}`);
    })
    .catch((error) => {
      console.log('Unable to create the release issue');

      throw new Error(error);
    });
}

// JS version of `if __name__ == '__main__'`
if (require.main === module) {
  createReleaseIssue();
}

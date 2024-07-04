/* eslint-disable no-console */
import fsp from 'fs/promises';

import chalk from 'chalk';
import dotenv from 'dotenv';
import semver from 'semver';

import generationCommitText from '../ci/codegen/text.js';
import { getNbGitDiff } from '../ci/utils.js';
import {
  LANGUAGES,
  ROOT_ENV_PATH,
  run,
  MAIN_BRANCH,
  OWNER,
  REPO,
  getOctokit,
  ensureGitHubToken,
  TODAY,
  CI,
  gitBranchExists,
  setVerbose,
  configureGitHubAuthor,
  fullReleaseConfig,
  toAbsolutePath,
} from '../common.js';
import { getLanguageFolder, getPackageVersionDefault } from '../config.js';
import type { Language } from '../types.js';

import { getLastReleasedTag } from './common.js';
import TEXT from './text.js';
import type {
  Versions,
  VersionsBeforeBump,
  PassedCommit,
  Commit,
  Scope,
  Changelog,
} from './types.js';
import { updateAPIVersions } from './updateAPIVersions.js';

dotenv.config({ path: ROOT_ENV_PATH });

export const COMMON_SCOPES = ['specs', 'clients'];

// python pre-releases have a pattern like `X.Y.ZaN` for alpha or `X.Y.ZbN` for beta
// see https://peps.python.org/pep-0440/
// It also support ruby pre-releases like `X.Y.Z.alpha.N` for alpha or `X.Y.Z.beta.N` for beta
const preReleaseRegExp = new RegExp(/\d\.\d\.\d(\.?a(lpha\.)?\d+|\.?b(eta\.)?\d+)$/);

// Prevent fetching the same user multiple times
const fetchedUsers: Record<string, string> = {};

export function readVersions(): VersionsBeforeBump {
  return Object.fromEntries(
    LANGUAGES.map((lang) => [lang, { current: getPackageVersionDefault(lang) }]),
  );
}

export function getVersionChangesText(versions: Versions): string {
  return LANGUAGES.map((lang) => {
    const { current, releaseType, noCommit, skipRelease, next } = versions[lang];

    if (noCommit) {
      return `- ~${lang}: ${current} (${TEXT.noCommit})~`;
    }

    if (!current) {
      return `- ~${lang}: (${TEXT.currentVersionNotFound})~`;
    }

    if (skipRelease) {
      return [
        `- ~${lang}: ${current} -> **\`${releaseType}\` _(e.g. ${next})_**~`,
        TEXT.descriptionForSkippedLang,
      ].join('\n');
    }

    return `- ${lang}: ${current} -> **\`${releaseType}\` _(e.g. ${next})_**`;
  }).join('\n');
}

export function getSkippedCommitsText({
  commitsWithoutLanguageScope,
  commitsWithUnknownLanguageScope,
}: {
  commitsWithoutLanguageScope: string[];
  commitsWithUnknownLanguageScope: string[];
}): string {
  if (commitsWithoutLanguageScope.length === 0 && commitsWithUnknownLanguageScope.length === 0) {
    return '_(None)_';
  }

  // GitHub API restrict the size of a PR body, if we send too many commits
  // we might end up with 502 errors when trying to send the pull request
  // So we limit the size of the missed commits
  return `
<p>${TEXT.skippedCommitsDesc}</p>

<details>
  <summary>
    <i>Commits without language scope:</i>
  </summary>

  ${commitsWithoutLanguageScope
    .slice(0, 15)
    .map((commit) => `- ${commit}`)
    .join('\n')}
</details>

<details>
  <summary>
    <i>Commits with unknown language scope:</i>
  </summary>

  ${commitsWithUnknownLanguageScope
    .slice(0, 15)
    .map((commit) => `- ${commit}`)
    .join('\n')}
</details>`;
}

export async function parseCommit(commit: string): Promise<Commit> {
  const [hash, authorEmail, message] = commit.split('|');
  const commitScope = message.slice(0, message.indexOf(':'));
  const typeAndScope = commitScope.match(/(.+)\((.+)\)/);
  const prNumberMatch = message.match(/#(\d+)/);
  const prNumber = prNumberMatch ? parseInt(prNumberMatch[1], 10) : 0;
  let commitMessage = message;

  if (prNumber) {
    commitMessage = message.replace(`(#${prNumber})`, '').trim();
  }

  // We skip generation commits as they do not appear in changelogs
  if (message.toLocaleLowerCase().startsWith(generationCommitText.commitStartMessage)) {
    return {
      error: 'generation-commit',
    };
  }
  if (!typeAndScope) {
    return {
      error: 'missing-language-scope',
      message,
    };
  }

  const scope = typeAndScope[2] as Scope;
  if (![...LANGUAGES, ...COMMON_SCOPES].includes(scope)) {
    return { error: 'unknown-language-scope', message };
  }

  // Retrieve the author GitHub username if publicly available
  if (!fetchedUsers[authorEmail] && prNumber) {
    const octokit = getOctokit();
    const { data } = await octokit.pulls.get({
      owner: OWNER,
      repo: REPO,
      pull_number: prNumber,
    });

    if (data.user) {
      fetchedUsers[authorEmail] = `[@${data.user.login}](https://github.com/${data.user.login}/)`;
    }
  }

  return {
    hash,
    type: typeAndScope[1], // `fix` | `feat` | `chore` | ...
    scope, // `clients` | `specs` | `javascript` | `php` | `java` | ...
    message: commitMessage,
    prNumber,
    raw: commit,
    author: fetchedUsers[authorEmail],
  };
}

/**
 * Returns the next version of the client.
 */
export function getNextVersion(current: string, releaseType: semver.ReleaseType | null): string {
  if (releaseType === null) {
    return current;
  }

  let nextVersion: string | null = current;

  const preReleaseVersion = current.match(preReleaseRegExp);
  if (preReleaseVersion?.length) {
    if (releaseType === 'major') {
      nextVersion = current.replace(preReleaseVersion[1], '');
    } else {
      nextVersion = current.replace(/\d+$/, (match) => `${parseInt(match, 10) + 1}`);
    }
  } else if (current.endsWith('-SNAPSHOT')) {
    // snapshots should not be bumped
    nextVersion = current;
  } else {
    nextVersion = semver.inc(current, releaseType);
  }

  if (!nextVersion) {
    throw new Error(`Unable to bump version: '${current}' with release type: '${releaseType}'`);
  }

  console.log(`    > Next version is '${nextVersion}', release type: '${releaseType}'`);

  return nextVersion;
}

export async function decideReleaseStrategy({
  versions,
  commits,
  languages,
  releaseType,
  dryRun,
}: {
  versions: VersionsBeforeBump;
  commits: PassedCommit[];
  languages: Language[];
  releaseType?: semver.ReleaseType;
  dryRun?: boolean;
}): Promise<Versions> {
  const versionsToPublish: Versions = {};

  for (const [lang, version] of Object.entries(versions)) {
    const currentVersion = versions[lang].current;

    if (!languages.includes(lang as Language)) {
      console.log(`${lang} is not in the given language list, skipping release`);

      versionsToPublish[lang] = {
        ...version,
        noCommit: true,
        releaseType: null,
        skipRelease: true,
        next: getNextVersion(currentVersion, null),
      };

      continue;
    }

    const commitsPerLang = commits.filter(
      (commit) => commit.scope === lang || COMMON_SCOPES.includes(commit.scope),
    );

    let nbGitDiff = await getNbGitDiff({
      branch: await getLastReleasedTag(),
      head: null,
      path: getLanguageFolder(lang as Language),
    });

    console.log(`Deciding next version bump for ${lang}.`);

    // we force the release for this language in this case if there was no commits
    if (dryRun || releaseType) {
      nbGitDiff = 1;
      commitsPerLang.length = 1;
    }

    if (nbGitDiff === 0 || commitsPerLang.length === 0) {
      versionsToPublish[lang] = {
        ...version,
        noCommit: true,
        releaseType: null,
        next: getNextVersion(currentVersion, null),
      };

      const msg =
        commitsPerLang.length === 0
          ? 'no commits found'
          : `no changes found in '${getLanguageFolder(lang as Language)}' in '${
              commitsPerLang.length
            }' commits`;

      console.log(`    > Skipping, ${msg}`);

      continue;
    }

    let langReleaseType: semver.ReleaseType = 'patch';
    let skipRelease = false;
    const commitTypes = new Set(commitsPerLang.map(({ type }) => type));

    switch (true) {
      case commitsPerLang.some((commit) => commit.message.includes('BREAKING CHANGE')):
        langReleaseType = 'major';
        break;
      case semver.prerelease(currentVersion) && !currentVersion.endsWith('-SNAPSHOT'):
        langReleaseType = 'prerelease';
        break;
      case commitTypes.has('feat'):
        langReleaseType = 'minor';
        break;
      case !commitTypes.has('fix'):
        skipRelease = true;
        break;
      default:
        langReleaseType = 'patch';
    }

    if (releaseType) {
      skipRelease = false;
      langReleaseType = releaseType;
    }

    versionsToPublish[lang] = {
      ...version,
      releaseType: langReleaseType,
      skipRelease,
      next: getNextVersion(currentVersion, langReleaseType),
    };
  }

  return versionsToPublish;
}

/**
 * Returns commits separated in categories used to compute the next release version.
 *
 * Gracefully exits if there is none.
 */
async function getCommits(force?: boolean): Promise<{
  validCommits: PassedCommit[];
  skippedCommits: string;
}> {
  // Reading commits since last release
  const latestCommits = (
    await run(`git log --pretty=format:"%h|%ae|%s" ${await getLastReleasedTag()}..${MAIN_BRANCH}`)
  )
    .split('\n')
    .filter(Boolean);

  const commitsWithoutLanguageScope: string[] = [];
  const commitsWithUnknownLanguageScope: string[] = [];
  const validCommits: PassedCommit[] = [];

  for (const commitMessage of latestCommits) {
    const commit = await parseCommit(commitMessage);

    if ('error' in commit) {
      if (commit.error === 'missing-language-scope') {
        commitsWithoutLanguageScope.push(commit.message);
      }

      if (commit.error === 'unknown-language-scope') {
        commitsWithUnknownLanguageScope.push(commit.message);
      }

      continue;
    }

    validCommits.push(commit);
  }

  if (!force && validCommits.length === 0) {
    console.log(
      chalk.black.bgYellow('[INFO]'),
      `Skipping release because no valid commit has been added since \`released\` tag.`,
    );
    // eslint-disable-next-line no-process-exit
    process.exit(0);
  }

  return {
    validCommits,
    skippedCommits: getSkippedCommitsText({
      commitsWithoutLanguageScope,
      commitsWithUnknownLanguageScope,
    }),
  };
}

/**
 * Ensure the release environment is correct before triggering.
 */
async function prepareGitEnvironment(): Promise<void> {
  ensureGitHubToken();

  if (CI) {
    await configureGitHubAuthor();
  }

  if ((await run('git rev-parse --abbrev-ref HEAD')) !== MAIN_BRANCH) {
    throw new Error(`You can run this script only from \`${MAIN_BRANCH}\` branch.`);
  }

  if (!process.env.FORCE && (await getNbGitDiff({ head: null })) !== 0) {
    throw new Error('Working directory is not clean. Commit all the changes first.');
  }

  await run(`git rev-parse --verify refs/tags/${await getLastReleasedTag()}`, {
    errorMessage: '`released` tag is missing in this repository.',
  });

  console.log('Pulling from origin...');
  await run('git fetch origin');
  await run('git fetch --tags --force');
  await run('git pull origin $(git branch --show-current)');
}

// updates the release.config.json file for the sla field, which contains a release history of start and end date support
// inspired by node: https://github.com/nodejs/Release/blob/main/schedule.json, following https://github.com/nodejs/release#release-schedule
export async function updateSLA(versions: Versions): Promise<void> {
  const start = new Date();
  const end = new Date(new Date().setMonth(new Date().getMonth() + 24));

  let queryStart = start;
  let queryEnd = end;

  for (const [lang, supportedVersions] of Object.entries(fullReleaseConfig.sla)) {
    const next = versions[lang].next;
    const current = versions[lang].current;

    // no ongoing release for this client, nothing changes
    if (!next || current === next) {
      continue;
    }

    // update the previously supported SLA version fields
    if (current in supportedVersions) {
      const nextMinor = next.match(/.+\.(.+)\..*/);
      const currentMinor = current.match(/.+\.(.+)\..*/);

      if (!currentMinor || !nextMinor) {
        throw new Error(`unable to determine minor versions: ${currentMinor}, ${nextMinor}`);
      }

      // if it's not a major release, and we are on the same minor, we remove the current
      // patch because we support SLA at minor level
      if (versions[lang].releaseType !== 'major' && currentMinor[1] === nextMinor[1]) {
        delete supportedVersions[current];
        // if it's a major or not the same minor, it means we release a new latest versions, so the
        // current SLA goes in maintenance mode
      } else {
        supportedVersions[current].status = 'maintenance';

        // any other release cases make the previous version enter in maintenance
        supportedVersions[current].start = start.toISOString().split('T')[0];
      }
    }

    // we don't support SLA for pre-releases, so we will:
    // - set them as `prerelease`
    // - not the set `lts` field, the gen script will set the as `unstable`
    const isPreRelease = next.match(preReleaseRegExp) !== null || semver.prerelease(next) !== null;

    supportedVersions[next] = {
      start: start.toISOString().split('T')[0],
      status: isPreRelease ? 'prerelease' : 'active',
      end: end.toISOString().split('T')[0],
    };

    // define the boundaries of the graph by searching for older and newest dates
    for (const [supportedVersion, dates] of Object.entries(supportedVersions)) {
      // delete maintenance versions that are not supported anymore
      if (dates.status === 'maintenance' && new Date(dates.end as string) < start) {
        delete supportedVersions[supportedVersion];

        continue;
      }

      const versionStart = new Date(dates.start);
      if (versionStart < queryStart) {
        queryStart = versionStart;
      }

      const versionEnd = new Date(dates.end);
      if (versionEnd > queryEnd) {
        queryEnd = versionEnd;
      }
    }
  }

  await fsp.writeFile(
    toAbsolutePath('config/release.config.json'),
    JSON.stringify(fullReleaseConfig, null, 2),
  );
}

export async function createReleasePR({
  languages,
  releaseType,
  dryRun,
}: {
  languages: Language[];
  releaseType?: semver.ReleaseType;
  dryRun?: boolean;
}): Promise<void> {
  if (!dryRun) {
    await prepareGitEnvironment();
  }

  console.log('Searching for commits since last release...');
  const { validCommits, skippedCommits } = await getCommits(releaseType !== undefined);

  const versions = await decideReleaseStrategy({
    versions: readVersions(),
    commits: validCommits,
    languages,
    releaseType,
  });

  await updateSLA(versions);

  const versionChanges = getVersionChangesText(versions);

  console.log(`Creating changelogs for languages: ${languages}...`);
  const changelog: Changelog = LANGUAGES.reduce((newChangelog, lang) => {
    if (versions[lang].noCommit) {
      return newChangelog;
    }

    const changelogCommits: string[] = [];
    for (const validCommit of validCommits) {
      if (validCommit.scope !== lang && !COMMON_SCOPES.includes(validCommit.scope)) {
        continue;
      }

      const changelogCommit = [
        `[${validCommit.hash}](https://github.com/${OWNER}/${REPO}/commit/${validCommit.hash})`,
        validCommit.message,
        validCommit.prNumber
          ? `([#${validCommit.prNumber}](https://github.com/${OWNER}/${REPO}/pull/${validCommit.prNumber}))`
          : undefined,
        validCommit.author ? `by ${validCommit.author}` : undefined,
      ]
        .filter(Boolean)
        .join(' ');

      changelogCommits.push(`- ${changelogCommit}`);
    }

    return {
      ...newChangelog,
      [lang]: changelogCommits.join('\n'),
    };
  }, {} as Changelog);

  console.log('Updating config files...');
  await updateAPIVersions(versions, changelog);

  if (dryRun) {
    console.log('  > asked for a dryrun, stopping here');

    return;
  }

  const headBranch = `chore/prepare-release-${TODAY}`;
  console.log(`Switching to branch: ${headBranch}`);
  if (await gitBranchExists(headBranch)) {
    await run(`git fetch origin ${headBranch}`);
    await run(`git push -d origin ${headBranch}`);
  }

  await run(`git checkout -B ${headBranch}`);

  setVerbose(true);
  console.log(`Pushing updated changes to: ${headBranch}`);
  const commitMessage = generationCommitText.commitPrepareReleaseMessage;
  await run('git add .');
  await run(`CI=true git commit -m "${commitMessage}"`);

  // cleanup all the changes to the generated files (the ones not commited because of the pre-commit hook)
  await run(`git checkout .`);

  await run(`git push origin ${headBranch}`);
  await run(`git checkout ${MAIN_BRANCH}`);

  console.log('Creating prepare release pull request...');
  const octokit = getOctokit();
  const { data } = await octokit.pulls.create({
    owner: OWNER,
    repo: REPO,
    title: generationCommitText.commitPrepareReleaseMessage,
    body: [
      TEXT.header,
      TEXT.summary,
      TEXT.versionChangeHeader,
      versionChanges,
      TEXT.skippedCommitsHeader,
      skippedCommits,
    ].join('\n\n'),
    base: 'main',
    head: headBranch,
  });

  console.log(`Release PR #${data.number} is ready for review.`);
  console.log(`  > ${data.html_url}`);
}

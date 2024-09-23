/* eslint-disable no-console */
import path from 'path';

import chalk from 'chalk';
import dotenv from 'dotenv';
import semver from 'semver';

import generationCommitText, { isGeneratedCommit } from '../ci/codegen/text.ts';
import { getNbGitDiff } from '../ci/utils.ts';
import {
  LANGUAGES,
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
  ROOT_DIR,
} from '../common.ts';
import { getPackageVersionDefault } from '../config.ts';
import type { Language } from '../types.ts';

import { getFileChanges, getLastReleasedTag } from './common.ts';
import { generateSLA } from './sla.ts';
import TEXT from './text.ts';
import type { Versions, ParsedCommit, Commit, Changelog, Scope, CommitType } from './types.ts';
import { updateAPIVersions } from './updateAPIVersions.ts';

dotenv.config({ path: path.resolve(ROOT_DIR, '.env') });

// python pre-releases have a pattern like `X.Y.ZaN` for alpha or `X.Y.ZbN` for beta
// see https://peps.python.org/pep-0440/
// It also support ruby pre-releases like `X.Y.Z.alpha.N` for alpha or `X.Y.Z.beta.N` for beta
export const preReleaseRegExp = new RegExp(/\d\.\d\.\d(\.?a(lpha\.)?\d+|\.?b(eta\.)?\d+)$/);

// Prevent fetching the same user multiple times
const fetchedUsers: Record<string, string> = {};

export function getVersionChangesText(versions: Versions): string {
  return LANGUAGES.map((lang) => {
    if (!versions[lang]) {
      return `- ~${lang}: ${getPackageVersionDefault(lang)} (no commit)~`;
    }

    const { current, releaseType, next } = versions[lang];

    return `- ${lang}: ${current} -> **\`${releaseType}\` _(e.g. ${next})_**`;
  }).join('\n');
}

export function getSkippedCommitsText({
  commitsWithoutLanguageScope,
}: {
  commitsWithoutLanguageScope: string[];
}): string {
  if (commitsWithoutLanguageScope.length === 0) {
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
</details>`;
}

export async function parseCommit(commit: string): Promise<Commit> {
  const [hash, authorEmail, message] = commit.split('|');
  const typeAndScope = message.match(/(.+?)(?:\((.+)\))?:/);
  const prNumberMatch = message.match(/#(\d+)/);
  const prNumber = prNumberMatch ? parseInt(prNumberMatch[1], 10) : 0;

  let commitType = typeAndScope ? typeAndScope[1] : 'fix'; // default to fix.
  if (!['feat', 'fix', 'chore'].includes(commitType)) {
    commitType = 'fix';
  }

  // get the scope of the commit by checking the changes.
  // any changes in the folder of a language will be scoped to that language
  const diff = await getFileChanges(hash);
  if (!diff) {
    // for empty commits, they will be filtered out later
    return {
      hash,
      type: commitType as CommitType,
      languages: [],
      scope: typeAndScope ? (typeAndScope[2] as Scope) : undefined,
      message: message.replace(`(#${prNumber})`, '').trim(),
      prNumber,
      author: fetchedUsers[authorEmail],
    };
  }

  const languageScopes = new Set();
  for (const change of diff.split('\n').map((line) => line.trim())) {
    if (change.startsWith('clients/')) {
      const lang = change.split('/')[1].replace('algoliasearch-client-', '') as Language;
      languageScopes.add(lang);
    }
  }

  // for generated commits, we just report the languages so that the changes are attributed to the correct language and commit
  if (isGeneratedCommit(message)) {
    return {
      generated: true,
      languages: [...languageScopes] as Language[],
      message,
    };
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
    type: commitType as CommitType, // `fix` | `feat` | `chore` | ..., default to `fix`
    languages: [...languageScopes] as Language[],
    scope: typeAndScope ? (typeAndScope[2] as Scope) : undefined, // `clients` | `specs` | `javascript` | `php` | `java` | ...
    message: message.replace(`(#${prNumber})`, '').trim(),
    prNumber,
    author: fetchedUsers[authorEmail],
  };
}

/**
 * Returns the next version of the client.
 */
export function getNextVersion(current: string, releaseType: semver.ReleaseType): string {
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

export function decideReleaseStrategy({
  commits,
  releaseType,
}: {
  commits: ParsedCommit[];
  releaseType?: semver.ReleaseType;
  dryRun?: boolean;
}): Versions {
  const versionsToPublish: Versions = {};

  for (const lang of LANGUAGES) {
    const currentVersion = getPackageVersionDefault(lang);
    const relevantCommits = commits.filter((commit) => commit.languages.includes(lang));

    console.log(`Deciding next version bump for ${lang}.`);

    if (relevantCommits.length === 0) {
      console.log(`    > Skipping, no commits found for ${lang}.`);

      continue;
    }

    let langReleaseType: semver.ReleaseType | null = null;
    const commitTypes = new Set(relevantCommits.map(({ type }) => type));

    switch (true) {
      case relevantCommits.some((commit) => commit.message.includes('BREAKING CHANGE')):
        langReleaseType = 'major';
        break;
      case semver.prerelease(currentVersion) && !currentVersion.endsWith('-SNAPSHOT'):
        langReleaseType = 'prerelease';
        break;
      case commitTypes.has('feat'):
        langReleaseType = 'minor';
        break;
      case commitTypes.has('fix') || commitTypes.has('chore'):
        langReleaseType = 'patch';
        break;
      default:
    }

    if (releaseType) {
      langReleaseType = releaseType;
    }

    if (!langReleaseType) {
      continue;
    }

    versionsToPublish[lang] = {
      current: currentVersion,
      releaseType: langReleaseType,
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
  validCommits: ParsedCommit[];
  skippedCommits: string;
}> {
  // Reading commits since last release
  const latestCommits = (
    await run(`git log --reverse --pretty=format:"%h|%ae|%s" ${await getLastReleasedTag()}..${MAIN_BRANCH}`)
  )
    .split('\n')
    .filter(Boolean);

  let validCommits: ParsedCommit[] = [];

  for (const commitMessage of latestCommits) {
    const commit = await parseCommit(commitMessage);

    if ('generated' in commit) {
      const originalCommit = validCommits.findIndex((c) => commit.message.includes(c.message));
      if (originalCommit !== -1) {
        validCommits[originalCommit].languages = [
          ...new Set([...validCommits[originalCommit].languages, ...commit.languages]),
        ];
      }

      continue;
    }

    validCommits.push(commit);
  }

  // redo a pass to filter out commits without language scope
  const commitsWithoutLanguageScope = validCommits
    .filter((commit) => commit.languages.length === 0)
    .map((commit) => commit.message);
  validCommits = validCommits.filter((commit) => commit.languages.length > 0);

  if (!force && validCommits.length === 0) {
    console.log(
      chalk.black.bgYellow('[INFO]'),
      'Skipping release because no valid commit has been added since `released` tag.',
    );
    // eslint-disable-next-line no-process-exit
    process.exit(0);
  }

  return {
    validCommits,
    skippedCommits: getSkippedCommitsText({
      commitsWithoutLanguageScope,
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

  if (!process.env.FORCE) {
    console.log('Pulling from origin...');
    await run('git fetch origin');
    await run('git fetch --tags --force');
    await run('git pull origin $(git branch --show-current)');
  }
}

export async function createReleasePR({
  releaseType,
  dryRun,
  breaking,
}: {
  releaseType?: semver.ReleaseType;
  dryRun?: boolean;
  breaking?: boolean;
}): Promise<void> {
  if (!dryRun) {
    await prepareGitEnvironment();
  }

  console.log('Searching for commits since last release...');
  const { validCommits, skippedCommits } = await getCommits(releaseType !== undefined);

  const versions = decideReleaseStrategy({ commits: validCommits, releaseType });

  // skip anything sla related for now
  if (process.env.SLA) {
    await generateSLA(versions);
  }

  const versionChanges = getVersionChangesText(versions);
  const languages = Object.keys(versions).join(', ');

  console.log(`Creating changelogs for languages: ${languages}...`);
  const changelog: Changelog = {};
  for (const lang of Object.keys(versions) as Language[]) {
    const changelogCommits: string[] = [];
    for (const validCommit of validCommits) {
      if (!validCommit.languages.includes(lang)) {
        continue;
      }

      // sometimes the scope of the commits is not set correctly and concerns another language, we can fix it.
      if (LANGUAGES.includes(validCommit.scope as Language) && validCommit.scope !== lang) {
        validCommit.message = validCommit.message.replace(`(${validCommit.scope}):`, '(clients):');
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

    changelog[lang] = changelogCommits.join('\n');
  }

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
  const commitMessage = `${generationCommitText.commitPrepareReleaseMessage}${breaking ? ' [skip-bc]' : ''}`;
  await run('git add .');
  await run(`CI=true git commit -m "${commitMessage}"`);

  // cleanup all the changes to the generated files (the ones not commited because of the pre-commit hook)
  await run('git checkout .');

  await run(`git push origin ${headBranch}`);
  await run(`git checkout ${MAIN_BRANCH}`);

  console.log('Creating prepare release pull request...');
  const octokit = getOctokit();
  const { data } = await octokit.pulls.create({
    owner: OWNER,
    repo: REPO,
    title: commitMessage,
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

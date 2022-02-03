#!/usr/bin/env node
/* eslint-disable no-console */
/* eslint-disable import/no-commonjs */
/* eslint-disable @typescript-eslint/no-var-requires */
const fs = require('fs');

const { Octokit } = require('@octokit/rest');
const dotenv = require('dotenv');
const execa = require('execa'); // https://github.com/sindresorhus/execa/tree/v5.1.1
const semver = require('semver');

const RELEASED_TAG = 'released';

const MAIN_BRANCH = 'main';

const OWNER = 'eunjae-lee'; // TODO: change this later
const REPO = 'api-clients-automation';

dotenv.config();

const LANG_NAME_ALIAS = {
  js: 'javascript',
};

function run(command) {
  const result = execa.commandSync(command);
  if (result.exitCode !== 0) {
    throw new Error(result.stderr);
  }
  return result.stdout;
}

function readVersions() {
  const versions = {};

  const generators = JSON.parse(
    fs.readFileSync('openapitools.json').toString()
  )['generator-cli'].generators;

  Object.keys(generators).forEach((generator) => {
    const lang = generator.split('-')[0];
    if (!versions[lang]) {
      versions[lang] = {
        current: generators[generator].additionalProperties.packageVersion,
        langName: lang,
        next: undefined,
      };
    }
  });
  return versions;
}

if (run('git rev-parse --abbrev-ref HEAD') !== MAIN_BRANCH) {
  throw new Error(
    `You can run this script only from \`${MAIN_BRANCH}\` branch.`
  );
}

if (run('git status --porcelain')) {
  throw new Error(
    'Working directory is not clean. Commit all the changes first.'
  );
}

// Reading versions from `openapitools.json`
const versions = readVersions();
const langs = Object.keys(versions); // ["javascript", "php", "java", ...]

// Reading commits since last release
console.log('Pulling from origin...');
run(`git pull origin ${MAIN_BRANCH}`);

console.log('Pushing to origin...');
run(`git push origin ${MAIN_BRANCH}`);

const header = [`## Summary`].join('\n');

const skippedCommits = [];
const latestCommits = run(`git log --oneline ${RELEASED_TAG}..${MAIN_BRANCH}`)
  .split('\n')
  .filter(Boolean)
  .map((commit) => {
    const hash = commit.slice(0, 7);
    let message = commit.slice(8);
    let type = message.slice(0, message.indexOf(':'));
    const matchResult = type.match(/(.+)\((.+)\)/);
    if (!matchResult) {
      skippedCommits.push(commit);
      // console.warn(`Skipping commit ${hash} due to lack of language scope:`);
      // console.warn(`  > ${message}`);
      return undefined;
    }
    message = message.slice(message.indexOf(':') + 2);
    type = matchResult[1];
    let lang = matchResult[2];
    lang = LANG_NAME_ALIAS[lang] || lang;

    return {
      hash,
      type, // e.g. `fix`
      lang, // e.g. `javascript`
      message,
      raw: commit,
    };
  })
  .filter(Boolean);

console.warn('Skipping these commits due to lack of language scope:');
console.log(skippedCommits.map((commit) => `  ${commit}`).join('\n'));

langs.forEach((lang) => {
  const commits = latestCommits.filter(
    (lastestCommit) => lastestCommit.lang === lang
  );
  const currentVersion = versions[lang].current;

  if (commits.length === 0) {
    versions[lang].next = currentVersion;
    versions[lang].noCommit = true;
    return;
  }

  if (semver.prerelease(currentVersion)) {
    // if version is like 0.1.2-beta.1, it increases to 0.1.2-beta.2, even if there's a breaking change.
    versions[lang].next = semver.inc(currentVersion, 'prerelease');
    return;
  }

  if (commits.some((commit) => commit.message.includes('BREAKING CHANGE'))) {
    versions[lang].next = semver.inc(currentVersion, 'major');
    return;
  }

  const commitTypes = new Set(commits.map(({ type }) => type));
  if (commitTypes.has('feat')) {
    versions[lang].next = semver.inc(currentVersion, 'minor');
    return;
  }

  versions[lang].next = semver.inc(currentVersion, 'patch');
  if (!commitTypes.has('fix')) {
    versions[lang].skipRelease = true;
  }
});

const versionChangeHeader = [`## Version Changes`].join('\n');

const versionChanges = langs
  .map((lang) => {
    const { current, next, noCommit, skipRelease, langName } = versions[lang];

    if (noCommit) {
      return `- ~${langName}: v${current} (no commit)~`;
    }

    if (!current) {
      return `- ~${langName}: (current version not found)~`;
    }

    const checked = skipRelease ? ' ' : 'x';
    return [
      `- [${checked}] ${langName}: v${current} -> v${next}`,
      skipRelease &&
        `  - No \`feat\` or \`fix\` commit, thus unchecked by default.`,
      `  - **Checked** → Update version, update ${langName} repository, and release the library.`,
      `  - **Unchecked** → Update ${langName} repository.`,
      `  - **Line removed** → Do nothing.`,
    ]
      .filter(Boolean)
      .join('\n');
  })
  .join('\n');

const changelogHeader = [
  `## CHANGELOG`,
  `Update the following lines. Once merged, it will be reflected to \`docs/changelogs/*.\``,
].join('\n');

const changelogs = langs
  .filter((lang) => !versions[lang].noCommit && versions[lang].current)
  .flatMap((lang) => {
    if (versions[lang].noCommit) {
      return [];
    }

    return [
      `### ${versions[lang].langName}`,
      ...latestCommits
        .filter((commit) => commit.lang === lang)
        .map((commit) => `- ${commit.raw}`),
    ];
  })
  .join('\n');

const approval = [
  `## Confirmation`,
  `To proceed this release, check the box below and close the issue.`,
  `To skip this release, just close the issue.`,
  `- [ ] Approved`,
].join('\n');

const body = [
  header,
  versionChangeHeader,
  versionChanges,
  changelogHeader,
  changelogs,
  approval,
].join('\n\n');

const octokit = new Octokit({
  auth: `token ${process.env.GITHUB_TOKEN}`,
});

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
  });

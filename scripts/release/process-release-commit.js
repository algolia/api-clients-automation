#!/usr/bin/env node
/* eslint-disable no-console */
/* eslint-disable no-process-exit */
/* eslint-disable import/no-commonjs */
/* eslint-disable @typescript-eslint/no-var-requires */
const fs = require('fs');

// eslint-disable-next-line import/order
const dotenv = require('dotenv');

dotenv.config();

const execa = require('execa');

const RELEASE_BRANCH = 'release';

function run(command) {
  const result = execa.commandSync(command);
  if (result.exitCode !== 0) {
    throw new Error(result.stderr);
  }
  return result.stdout;
}

function getMarkdownSection(markdown, title) {
  const levelIndicator = title.split(' ')[0]; // e.g. `##`
  const lines = markdown.slice(markdown.indexOf(title)).split('\n');
  let endIndex = lines.length;
  for (let i = 1; i < lines.length; i++) {
    if (lines[i].startsWith(`${levelIndicator} `)) {
      endIndex = i;
      break;
    }
  }
  return lines.slice(0, endIndex).join('\n');
}

if (run('git rev-parse --abbrev-ref HEAD') !== RELEASE_BRANCH) {
  throw new Error(
    `You can run this script only from \`${RELEASE_BRANCH}\` branch.`
  );
}

const lastCommit = run('git log --oneline -n 1').trim();
if (!lastCommit.slice(8).startsWith('chore: release')) {
  console.log("Quitting because the latest commit isn't a release commit.");
  process.exit(0);
}

const [, prNumber] = lastCommit.match(/\(#(\d+)\)$/);

const pullRequestBody = JSON.parse(
  execa.sync('curl', [
    '-H',
    `Authorization: token ${process.env.GITHUB_TOKEN}`,
    `https://api.github.com/repos/algolia/api-clients-automation/pulls/${prNumber}`,
  ]).stdout
).body;

// const pullRequestBody = `## Summary
// Once ready, squash and merge this PR to trigger a release.

// ## Version Changes

// - [x] javascript: v5.0.0 -> v5.0.1
//   * Uncheck if you want to skip it.
// - [ ] ~java: v4.0.0 (no commit)~

// ## CHANGELOG
// Update the following lines. Once merged, it will be reflected to \`docs/changelogs/*.\`

// ### javascript
// - 70369f5 fix(js): add version to user agent (#105)`;

const versionsToRelease = {};
getMarkdownSection(pullRequestBody, '## Version Changes')
  .split('\n')
  .forEach((line) => {
    const result = line.match(/- \[x\] (.+): v(.+) -> v(.+)/);
    if (!result) {
      return;
    }
    const [, lang, currentVersion, nextVersion] = result;
    versionsToRelease[lang] = {
      currentVersion,
      nextVersion,
    };
  });

const langsToUpdateRepo = getMarkdownSection(
  pullRequestBody,
  '## Version Changes'
)
  .split('\n')
  .map((line) => {
    const result = line.match(/- \[ \] (.+): v(.+) -> v(.+)/);
    return result?.[1];
  })
  .filter(Boolean);

const json = JSON.parse(fs.readFileSync('openapitools.json').toString());
Object.keys(json['generator-cli'].generators).forEach((client) => {
  const lang = client.split('-')[0];
  if (versionsToRelease[lang]) {
    json['generator-cli'].generators[
      client
    ].additionalProperties.packageVersion = versionsToRelease[lang].nextVersion;
  }
});
fs.writeFileSync('openapitools.json', JSON.stringify(json, null, 2));

Object.keys(versionsToRelease).forEach((lang) => {
  console.log(`Generating ${lang} client(s)...`);
  run(`yarn generate ${lang}`).pipe(process.stdout);
});

langsToUpdateRepo.forEach((lang) => {
  console.log(`Generating ${lang} client(s)...`);
  run(`yarn generate ${lang}`).pipe(process.stdout);
});

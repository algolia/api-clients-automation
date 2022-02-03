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

const { MAIN_BRANCH, OWNER, REPO } = require('./common');

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

const issueBody = JSON.parse(
  execa.sync('curl', [
    '-H',
    `Authorization: token ${process.env.GITHUB_TOKEN}`,
    `https://api.github.com/repos/${OWNER}/${REPO}/issues/${process.env.EVENT_NUMBER}`,
  ]).stdout
).body;

if (
  !getMarkdownSection(issueBody, '## Confirmation')
    .split('\n')
    .find((line) => line.startsWith('- [x] Approved'))
) {
  console.log('The issue was not approved.');
  process.exit(1);
}

const versionsToRelease = {};
getMarkdownSection(issueBody, '## Version Changes')
  .split('\n')
  .forEach((line) => {
    const result = line.match(/- \[x\] (.+): v(.+) -> v(.+)/);
    if (!result) {
      return;
    }
    const [, lang, current, next] = result;
    versionsToRelease[lang] = {
      current,
      next,
    };
  });

const langsToUpdateRepo = getMarkdownSection(issueBody, '## Version Changes')
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
    ].additionalProperties.packageVersion = versionsToRelease[lang].next;
  }
});
fs.writeFileSync('openapitools.json', JSON.stringify(json, null, 2));

new Set([...Object.keys(versionsToRelease), ...langsToUpdateRepo]).forEach(
  (lang) => {
    const filePath = `doc/changelogs/${lang}.md`;
    const header = versionsToRelease[lang]
      ? `## ${versionsToRelease[lang].next}`
      : `## ${new Date().toISOString().split('T')[0]}`;
    const newChangelog = getMarkdownSection(
      getMarkdownSection(issueBody, '## CHANGELOG'),
      `### ${lang}`
    );
    const existingContent = fs.readFileSync(filePath).toString();
    fs.writeFileSync(
      filePath,
      [header, newChangelog, existingContent].join('\n\n')
    );
  }
);

run('git config user.name "api-client-bot"');
run('git config user.email "bot@algolia.com"');
run('git add openapitools.json');
run('git add doc/changelogs/*');
execa.sync('git', ['commit', '-m', 'chore: update versions and changelogs']);
run(`git push origin ${MAIN_BRANCH}`);

Object.keys(versionsToRelease).forEach((lang) => {
  console.log(`Generating ${lang} client(s)...`);
  run(`yarn generate ${lang}`).pipe(process.stdout);
});

langsToUpdateRepo.forEach((lang) => {
  console.log(`Generating ${lang} client(s)...`);
  run(`yarn generate ${lang}`).pipe(process.stdout);
});

/* eslint-disable no-console */
import fs from 'fs';
import path from 'path';

import dotenv from 'dotenv';
import execa from 'execa';

import openapitools from '../../openapitools.json';

import type { Run } from './common';
import {
  MAIN_BRANCH,
  OWNER,
  REPO,
  run as runOriginal,
  getMarkdownSection,
} from './common';
import TEXT from './text';

// This script is run by `yarn workspace ...`, which means the current working directory is `./script`
const ROOT_DIR = path.resolve(process.cwd(), '..');

dotenv.config();

const run: Run = (command, options = {}) =>
  runOriginal(command, { cwd: ROOT_DIR, ...options });

if (!process.env.GITHUB_TOKEN) {
  throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
}

if (!process.env.EVENT_NUMBER) {
  throw new Error('Environment variable `EVENT_NUMBER` does not exist.');
}

const issueBody = JSON.parse(
  execa.sync('curl', [
    '-H',
    `Authorization: token ${process.env.GITHUB_TOKEN}`,
    `https://api.github.com/repos/${OWNER}/${REPO}/issues/${process.env.EVENT_NUMBER}`,
  ]).stdout
).body;

if (
  !getMarkdownSection(issueBody, TEXT.approvalHeader)
    .split('\n')
    .find((line) => line.startsWith(`- [x] ${TEXT.approved}`))
) {
  throw new Error('The issue was not approved.');
}

const versionsToRelease = {};
getMarkdownSection(issueBody, TEXT.versionChangeHeader)
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

const langsToUpdateRepo = getMarkdownSection(
  issueBody,
  TEXT.versionChangeHeader
)
  .split('\n')
  .map((line) => {
    const result = line.match(/- \[ \] (.+): v(.+) -> v(.+)/);
    return result?.[1];
  })
  .filter(Boolean); // e.g. ['javascript', 'php']

// update versions in `openapitools.json`
Object.keys(openapitools['generator-cli'].generators).forEach((client) => {
  const lang = client.split('-')[0];
  if (versionsToRelease[lang]) {
    openapitools['generator-cli'].generators[
      client
    ].additionalProperties.packageVersion = versionsToRelease[lang].next;
  }
});
fs.writeFileSync(
  path.resolve(ROOT_DIR, 'openapitools.json'),
  JSON.stringify(openapitools, null, 2)
);

// update changelogs
new Set([...Object.keys(versionsToRelease), ...langsToUpdateRepo]).forEach(
  (lang) => {
    const filePath = path.resolve(ROOT_DIR, `doc/changelogs/${lang}.md`);
    const header = versionsToRelease[lang!]
      ? `## ${versionsToRelease[lang!].next}`
      : `## ${new Date().toISOString().split('T')[0]}`;
    const newChangelog = getMarkdownSection(
      getMarkdownSection(issueBody, TEXT.changelogHeader),
      `### ${lang}`
    );
    const existingContent = fs.readFileSync(filePath).toString();
    fs.writeFileSync(
      filePath,
      [header, newChangelog, existingContent].join('\n\n')
    );
  }
);

// commit openapitools and changelogs
if (process.env.RELEASE_TEST !== 'true') {
  run('git config user.name "api-clients-bot"');
  run('git config user.email "bot@algolia.com"');
  run('git add openapitools.json');
  run('git add doc/changelogs/*');
  execa.sync('git', ['commit', '-m', TEXT.commitMessage]);
  run(`git push origin ${MAIN_BRANCH}`);
}

// generate clients to release
Object.keys(versionsToRelease).forEach((lang) => {
  console.log(`Generating ${lang} client(s)...`);
  // @ts-expect-error the library `execa` is not typed correctly
  run(`yarn generate ${lang}`).pipe(process.stdout);
});

// generate clients to just update the repos
langsToUpdateRepo.forEach((lang) => {
  console.log(`Generating ${lang} client(s)...`);
  // @ts-expect-error the library `execa` is not typed correctly
  run(`yarn generate ${lang}`).pipe(process.stdout);
});

const clientPath = path.resolve(
  ROOT_DIR,
  'clients/dummy-algoliasearch-client-javascript'
);
const runInClient: Run = (command, options = {}) =>
  runOriginal(command, {
    cwd: clientPath,
    ...options,
  });

runInClient(`git checkout next`);
run(
  `cp -r clients/algoliasearch-client-javascript/ clients/dummy-algoliasearch-client-javascript`
);
runInClient(`git add .`);
execa.sync('git', ['commit', '-m', 'chore: release test'], {
  cwd: clientPath,
});
runInClient(`git push origin next`);

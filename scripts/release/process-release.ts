/* eslint-disable no-console */
import fsp from 'fs/promises';

import dotenv from 'dotenv';
import execa from 'execa';

import clientsConfig from '../../clients.config.json';
import openapitools from '../../openapitools.json';
import releaseConfig from '../../release.config.json';
import { toAbsolutePath, run, exists, getGitHubUrl } from '../common';

import {
  RELEASED_TAG,
  OWNER,
  REPO,
  getMarkdownSection,
  getTargetBranch,
} from './common';
import TEXT from './text';

dotenv.config();

if (!process.env.GITHUB_TOKEN) {
  throw new Error('Environment variable `GITHUB_TOKEN` does not exist.');
}

if (!process.env.EVENT_NUMBER) {
  throw new Error('Environment variable `EVENT_NUMBER` does not exist.');
}

async function processRelease(): Promise<void> {
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

  const versionsToRelease: {
    [lang: string]: {
      current: string;
      next: string;
    };
  } = {};
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
    .filter(Boolean) as string[]; // e.g. ['javascript', 'php']

  // update versions in `openapitools.json`
  Object.keys(openapitools['generator-cli'].generators).forEach((client) => {
    const lang = client.split('-')[0];
    if (versionsToRelease[lang]) {
      openapitools['generator-cli'].generators[
        client
      ].additionalProperties.packageVersion = versionsToRelease[lang].next;
    }
  });
  await fsp.writeFile(
    toAbsolutePath('openapitools.json'),
    JSON.stringify(openapitools, null, 2)
  );

  await run(`git config user.name "${releaseConfig.gitAuthor.name}"`);
  await run(`git config user.email "${releaseConfig.gitAuthor.email}"`);

  // commit openapitools and changelogs
  await run('git add openapitools.json');

  const langsToReleaseOrUpdate = [
    ...Object.keys(versionsToRelease),
    ...langsToUpdateRepo,
  ];

  for (const lang of langsToReleaseOrUpdate) {
    const goal = versionsToRelease[lang] ? 'release' : 'update';

    // prepare the submodule
    const clientPath = toAbsolutePath(clientsConfig[lang].folder);
    const targetBranch = getTargetBranch(lang);
    await run(`git checkout ${targetBranch}`, { cwd: clientPath });
    await run(`git pull origin ${targetBranch}`, { cwd: clientPath });

    console.log(`Generating ${lang} client(s)...`);
    await run(`yarn cli generate ${lang}`);

    const dateStamp = new Date().toISOString().split('T')[0];
    const currentVersion = versionsToRelease[lang].current;
    const nextVersion = versionsToRelease[lang].next;

    // update changelog
    const changelogPath = toAbsolutePath(
      `${clientsConfig[lang].folder}/CHANGELOG.md`
    );
    const existingContent = (await exists(changelogPath))
      ? (await fsp.readFile(changelogPath)).toString()
      : '';
    const changelogHeader =
      goal === 'release'
        ? `## [v${nextVersion}](${getGitHubUrl(
            lang
          )}/compare/v${currentVersion}...v${nextVersion})`
        : `## ${dateStamp}`;
    const newChangelog = getMarkdownSection(
      getMarkdownSection(issueBody, TEXT.changelogHeader),
      `### ${lang}`
    );
    await fsp.writeFile(
      changelogPath,
      [changelogHeader, newChangelog, existingContent].join('\n\n')
    );

    // commit changelog and the generated client
    await run(`git config user.name "${releaseConfig.gitAuthor.name}"`, {
      cwd: clientPath,
    });
    await run(`git config user.email "${releaseConfig.gitAuthor.email}"`, {
      cwd: clientPath,
    });
    await run(`git add .`, { cwd: clientPath });
    if (goal === 'release') {
      await execa('git', ['commit', '-m', `chore: release ${nextVersion}`], {
        cwd: clientPath,
      });
      await execa('git', ['tag', `v${nextVersion}`], { cwd: clientPath });
    } else {
      await execa('git', ['commit', '-m', `chore: update repo ${dateStamp}`], {
        cwd: clientPath,
      });
    }

    // push the commit to the submodule
    await run(`git push origin ${targetBranch}`, { cwd: clientPath });
    if (goal === 'release') {
      await run('git push --tags', { cwd: clientPath });
    }

    // add the new reference of the submodule in the monorepo
    await run(`git add ${clientsConfig[lang].folder}`);
  }

  await execa('git', ['commit', '-m', TEXT.commitMessage]);
  await run(`git push`);

  // remove old `released` tag
  await run(`git tag -d ${RELEASED_TAG}`);
  await run(`git push --delete origin ${RELEASED_TAG}`);

  // create new `released` tag
  await run(`git tag released`);
  await run(`git push --tags`);
}

processRelease();

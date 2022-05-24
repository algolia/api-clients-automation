/* eslint-disable no-console */
import fsp from 'fs/promises';

import dotenv from 'dotenv';
import semver from 'semver';

import clientsConfig from '../../config/clients.config.json';
import openapiConfig from '../../config/openapitools.json';
import {
  ROOT_ENV_PATH,
  toAbsolutePath,
  run,
  exists,
  GENERATORS,
  LANGUAGES,
  MAIN_BRANCH,
  gitBranchExists,
} from '../common';
import {
  getClientsConfigField,
  getGitHubUrl,
  getLanguageFolder,
  getPackageVersionDefault,
} from '../config';
import type { Language } from '../types';

import { getMarkdownSection } from './common';
import TEXT from './text';
import type { VersionsToRelease, BeforeClientGenerationCommand } from './types';

dotenv.config({ path: ROOT_ENV_PATH });

const BEFORE_CLIENT_GENERATION: {
  [lang in Language]?: BeforeClientGenerationCommand;
} = {
  javascript: async ({ releaseType, dir }) => {
    await run(`yarn release:bump ${releaseType}`, { cwd: dir });
  },
};

/**
 * Bump each client version of the JavaScript client in openapitools.json.
 */
async function updateVersionForJavascript(
  versionsToRelease: VersionsToRelease
): Promise<void> {
  if (!versionsToRelease.javascript) {
    return;
  }

  // Sets the new version of the JavaScript client
  const jsVersion = versionsToRelease.javascript;
  Object.values(GENERATORS)
    .filter((gen) => gen.language === 'javascript')
    .forEach((gen) => {
      const additionalProperties = gen.additionalProperties;
      const newVersion = semver.inc(
        additionalProperties.packageVersion,
        jsVersion.releaseType
      );
      if (!newVersion) {
        throw new Error(
          `Failed to bump version ${additionalProperties.packageVersion} by ${jsVersion.releaseType}.`
        );
      }
      additionalProperties.packageVersion = newVersion;
    });

  await fsp.writeFile(
    toAbsolutePath('config/openapitools.json'),
    JSON.stringify(openapiConfig, null, 2)
  );

  // Sets the new version of the utils package
  const utilsPackageVersion = getClientsConfigField(
    'javascript',
    'utilsPackageVersion'
  );
  const nextUtilsPackageVersion = semver.inc(
    utilsPackageVersion,
    jsVersion.releaseType
  );

  if (!nextUtilsPackageVersion) {
    throw new Error(
      `Failed to bump version ${utilsPackageVersion} by ${jsVersion.releaseType}.`
    );
  }

  clientsConfig.javascript.utilsPackageVersion = nextUtilsPackageVersion;
  await fsp.writeFile(
    toAbsolutePath('config/clients.config.json'),
    JSON.stringify(clientsConfig, null, 2)
  );
}

async function updateConfigFiles(
  versionsToRelease: VersionsToRelease
): Promise<void> {
  await updateVersionForJavascript(versionsToRelease);

  // update the other versions in clients.config.json
  LANGUAGES.forEach((lang) => {
    if (lang === 'javascript' || !versionsToRelease[lang]) {
      return;
    }
    const releaseType = versionsToRelease[lang]!.releaseType;

    const newVersion = semver.inc(getPackageVersionDefault(lang), releaseType);
    if (!newVersion) {
      throw new Error(
        `Failed to bump version ${getPackageVersionDefault(
          lang
        )} by ${releaseType}.`
      );
    }
    clientsConfig[lang].packageVersion = newVersion;
  });
  await fsp.writeFile(
    toAbsolutePath('config/clients.config.json'),
    JSON.stringify(clientsConfig, null, 2)
  );
}

async function updateChangelog({
  lang,
  issueBody,
  current,
  next,
}: {
  lang: Language;
  issueBody: string;
  current: string;
  next: string;
}): Promise<void> {
  const changelogPath = toAbsolutePath(
    `${getLanguageFolder(lang)}/CHANGELOG.md`
  );
  const existingContent = (await exists(changelogPath))
    ? (await fsp.readFile(changelogPath)).toString()
    : '';
  const changelogHeader = `## [${next}](${getGitHubUrl(
    lang
  )}/compare/${current}...${next})`;
  const newChangelog = getMarkdownSection(
    getMarkdownSection(issueBody, TEXT.changelogHeader),
    `### ${lang}`
  );
  await fsp.writeFile(
    changelogPath,
    [changelogHeader, newChangelog, existingContent].join('\n\n')
  );
}

export function getVersionsToRelease(issueBody: string): VersionsToRelease {
  const versionsToRelease: VersionsToRelease = {};

  getMarkdownSection(issueBody, TEXT.versionChangeHeader)
    .split('\n')
    .forEach((line) => {
      const result = line.match(/- \[x\] (.+): (.+) -> `(.+)`/);
      if (!result) {
        return;
      }
      const [, lang, current, releaseType] = result;
      if (!['major', 'minor', 'patch', 'prerelease'].includes(releaseType)) {
        throw new Error(
          `\`${releaseType}\` is unknown release type. Allowed: major, minor, patch, prerelease`
        );
      }
      versionsToRelease[lang] = {
        current,
        releaseType,
      };
    });

  return versionsToRelease;
}

/**
 * Updates the changelogs and the config files containing versions of the API clients.
 *
 * @param issueBody - The issue body pushed to the PR, which is generated by `create-release-issue`.
 * @param headBranch - The branch to push the changes to.
 */
export async function processRelease(
  issueBody: string,
  headBranch: string
): Promise<void> {
  if (await gitBranchExists(headBranch)) {
    await run(`git fetch origin ${headBranch}`);
    await run(`git push -d origin ${headBranch}`);
  }

  await run(`git checkout -b ${headBranch}`);

  const versionsToRelease = getVersionsToRelease(issueBody);

  await updateConfigFiles(versionsToRelease);

  for (const [lang, { current, releaseType }] of Object.entries(
    versionsToRelease
  )) {
    /*
    About bumping versions of JS clients:

    There are generated clients in JS repo, and non-generated clients like `algoliasearch`, `client-common`, etc.
    Now that the versions of generated clients are updated in `openapitools.json`,
    the generation output will have correct new versions.
    
    However, we need to manually update versions of the non-generated (a.k.a. manually written) clients.
    In order to do that, we run `yarn release:bump <releaseType>` in this monorepo first.
    It will update the versions of the non-generated clients which exists in this monorepo.
    After that, we generate clients with new versions. And then, we copy all of them over to JS repository.
    */
    await BEFORE_CLIENT_GENERATION[lang]?.({
      releaseType,
      dir: toAbsolutePath(getLanguageFolder(lang as Language)),
    });

    const next = semver.inc(current, releaseType);
    await updateChangelog({
      lang: lang as Language,
      issueBody,
      current,
      next: next!,
    });
  }

  console.log(`Pushing updated configs to ${headBranch}`);
  await run(`git add .`, { verbose: true });
  await run(
    `CI=true git commit -m "${headBranch.replace('chore/', 'chore: ')}"`,
    { verbose: true }
  );
  await run(`git push origin ${headBranch}`, { verbose: true });
  await run(`git checkout ${MAIN_BRANCH}`, { verbose: true });
}

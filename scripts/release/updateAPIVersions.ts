import fsp from 'fs/promises';

import dotenv from 'dotenv';
import yaml from 'js-yaml';
import type { ReleaseType } from 'semver';

import clientsConfig from '../../config/clients.config.json' assert { type: 'json' };
import openapiConfig from '../../config/openapitools.json' assert { type: 'json' };
import {
  ROOT_ENV_PATH,
  toAbsolutePath,
  run,
  exists,
  GENERATORS,
  LANGUAGES,
  CI,
  setVerbose,
} from '../common.js';
import { getGitHubUrl, getLanguageFolder } from '../config.js';
import type { Language } from '../types.js';

import { writeJsonFile } from './common.js';
import type { Changelog, Versions, VersionsToRelease } from './types.js';

dotenv.config({ path: ROOT_ENV_PATH });

async function updateConfigFiles(
  versionsToRelease: VersionsToRelease
): Promise<void> {
  // update the other versions in clients.config.json
  for (const lang of LANGUAGES) {
    if (!versionsToRelease[lang]) {
      continue;
    }

    clientsConfig[lang].packageVersion = versionsToRelease[lang]!.next;
  }

  await writeJsonFile(
    toAbsolutePath('config/clients.config.json'),
    clientsConfig
  );
}

async function updateChangelog(
  lang: Language,
  changelog: string,
  current: string,
  next: string,
  changelogPath: string
): Promise<void> {
  let content = '';
  const changelogHeader = `## [${next}](${getGitHubUrl(
    lang
  )}/compare/${current}...${next})`;

  if (await exists(changelogPath)) {
    content = (await fsp.readFile(changelogPath)).toString();
  }

  await fsp.writeFile(
    changelogPath,
    [changelogHeader, changelog, content].join('\n\n')
  );
}

export function getVersionsToRelease(versions: Versions): VersionsToRelease {
  const versionsToRelease: VersionsToRelease = {};

  Object.entries(versions).forEach(
    ([lang, { noCommit, current, skipRelease, releaseType, next }]) => {
      if (noCommit || skipRelease || !current || !next) {
        return;
      }

      if (
        !releaseType ||
        !['major', 'minor', 'patch', 'prerelease'].includes(releaseType)
      ) {
        throw new Error(
          `\`${releaseType}\` is unknown release type. Allowed: major, minor, patch, prerelease`
        );
      }

      versionsToRelease[lang] = {
        current,
        releaseType,
        next,
      };
    }
  );

  return versionsToRelease;
}

/**
 * Updates the changelogs and the config files containing versions of the API clients.
 *
 * @param versions - A summary of the version changes, with their new version and release type.
 * @param changelog - The changelog of all the languages, which is generated by `createReleasePR`.
 */
export async function updateAPIVersions(
  versions: Versions,
  changelog: Changelog
): Promise<void> {
  const versionsToRelease = getVersionsToRelease(versions);

  await updateConfigFiles(versionsToRelease);

  for (const [lang, { current, releaseType, next }] of Object.entries(
    versionsToRelease
  )) {
    if (lang === 'dart') {
      await updateDartPackages(changelog[lang]!, releaseType);

      continue;
    }

    if (lang === 'javascript') {
      setVerbose(CI);
      await run(`yarn install && yarn release:bump ${releaseType}`, {
        cwd: getLanguageFolder(lang),
      });
    }

    await updateChangelog(
      lang as Language,
      changelog[lang],
      current,
      next,
      toAbsolutePath(`${getLanguageFolder(lang as Language)}/CHANGELOG.md`)
    );
  }
}

/**
 * Updates packages versions and generates the changelog.
 * Documentation: {@link https://melos.invertase.dev/commands/version | melos version}.
 */
async function updateDartPackages(
  changelog: string,
  releaseType: ReleaseType
): Promise<void> {
  await run('dart pub get', { cwd: getLanguageFolder('dart') });

  const packageNames = await Promise.all(
    Object.values(GENERATORS)
      .filter((gen) => gen.language === 'dart')
      .map(async (gen) => await getPubspecField(gen.output, 'name'))
  );
  const versionCommands = packageNames
    .map((packageName) => `-V ${packageName}:${releaseType}`)
    .join(' ');
  await run(
    `melos version ${versionCommands} --no-changelog --no-git-tag-version --yes`,
    { cwd: getLanguageFolder('dart') }
  );

  // Update packages configs based on generated versions
  for (const gen of Object.values(GENERATORS)) {
    if (gen.language !== 'dart') {
      continue;
    }

    const currentVersion = gen.additionalProperties.packageVersion;
    const packageName = await getPubspecField(gen.output, 'name');
    if (!packageName) {
      throw new Error(`Unable to find packageName for '${gen.packageName}'.`);
    }

    const newVersion = await getPubspecField(gen.output, 'version');
    if (!newVersion) {
      throw new Error(`Failed to bump '${gen.packageName}'.`);
    }
    gen.additionalProperties.packageVersion = newVersion;
    gen.additionalProperties.packageName = undefined;

    if (gen.client === 'algoliasearch') {
      clientsConfig.dart.packageVersion = newVersion;
    }

    await updateChangelog(
      'dart',
      changelog,
      currentVersion,
      newVersion,
      toAbsolutePath(`${gen.output}/CHANGELOG.md`)
    );
  }

  // update `openapitools.json` config file
  await writeJsonFile(
    toAbsolutePath('config/openapitools.json'),
    openapiConfig
  );

  // update `clients.config.json` file for the utils version
  await writeJsonFile(
    toAbsolutePath('config/clients.config.json'),
    clientsConfig
  );
}

/**
 * Get 'version' from pubspec.yaml file.
 */
async function getPubspecField(
  filePath: string,
  field: string
): Promise<string | undefined> {
  try {
    const fileContent = await fsp.readFile(
      toAbsolutePath(`${filePath}/pubspec.yaml`),
      'utf8'
    );
    const pubspec = yaml.load(fileContent) as Record<string, any>;

    return pubspec[field];
  } catch (error) {
    throw new Error(`Error reading the file: ${error}`);
  }
}

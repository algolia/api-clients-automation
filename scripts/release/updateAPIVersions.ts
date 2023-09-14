import fsp from 'fs/promises';

import dotenv from 'dotenv';
import yaml from 'js-yaml';

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

async function updateConfigFiles(versionsToRelease: VersionsToRelease): Promise<void> {
  // update the other versions in clients.config.json
  for (const lang of LANGUAGES) {
    if (!versionsToRelease[lang]) {
      continue;
    }

    clientsConfig[lang].packageVersion = versionsToRelease[lang]!.next;
  }

  await writeJsonFile(toAbsolutePath('config/clients.config.json'), clientsConfig);
}

async function updateChangelog(
  lang: Language,
  changelog: string,
  current: string,
  next: string,
  changelogPath: string
): Promise<void> {
  let content = '';
  const changelogHeader = `## [${next}](${getGitHubUrl(lang)}/compare/${current}...${next})`;

  if (await exists(changelogPath)) {
    content = (await fsp.readFile(changelogPath)).toString();
  }

  await fsp.writeFile(changelogPath, [changelogHeader, changelog, content].join('\n\n'));
}

export function getVersionsToRelease(versions: Versions): VersionsToRelease {
  const versionsToRelease: VersionsToRelease = {};

  Object.entries(versions).forEach(
    ([lang, { noCommit, current, skipRelease, releaseType, next }]) => {
      if (noCommit || skipRelease || !current || !next) {
        return;
      }

      if (!releaseType || !['major', 'minor', 'patch', 'prerelease'].includes(releaseType)) {
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
export async function updateAPIVersions(versions: Versions, changelog: Changelog): Promise<void> {
  const versionsToRelease = getVersionsToRelease(versions);

  await updateConfigFiles(versionsToRelease);

  for (const [lang, { current, releaseType, next }] of Object.entries(versionsToRelease)) {
    if (lang === 'dart') {
      await updateDartPackages(changelog[lang]!, next);

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
 */
async function updateDartPackages(changelog: string, nextVersion: string): Promise<void> {
  for (const gen of Object.values(GENERATORS)) {
    if (gen.language !== 'dart') {
      continue;
    }

    if (!nextVersion) {
      throw new Error(`Failed to bump '${gen.packageName}'.`);
    }

    let currentVersion = await getPubspecField(gen.output, 'version');

    // if there's no version then it mostly means it's a new client.
    if (!currentVersion) {
      currentVersion = '0.0.1';
    }

    await updateChangelog(
      'dart',
      changelog,
      currentVersion,
      nextVersion,
      toAbsolutePath(`${gen.output}/CHANGELOG.md`)
    );
  }

  // Version is sync'd on every clients so we set it once.
  clientsConfig.dart.packageVersion = nextVersion;

  // update `openapitools.json` config file.
  await writeJsonFile(toAbsolutePath('config/openapitools.json'), openapiConfig);

  // update `clients.config.json` file for the utils version.
  await writeJsonFile(toAbsolutePath('config/clients.config.json'), clientsConfig);

  const corePackagePath = 'clients/algoliasearch-client-dart/packages/client_core';

  // we've bumped generated clients but still need to do the manual ones.
  await bumpPubspecVersion(toAbsolutePath(`${corePackagePath}/pubspec.yaml`), nextVersion);

  // fetch the version from the pubspec file of the core package
  let currentCoreVersion = await getPubspecField(corePackagePath, 'version');
  if (!currentCoreVersion) {
    currentCoreVersion = '0.0.1';
  }

  // update the changelog for core package
  await updateChangelog(
    'dart',
    changelog,
    currentCoreVersion,
    nextVersion,
    toAbsolutePath(`${corePackagePath}/CHANGELOG.md`)
  );
}

/**
 * Get 'version' from pubspec.yaml file.
 */
async function getPubspecField(filePath: string, field: string): Promise<string | undefined> {
  try {
    const fileContent = await fsp.readFile(toAbsolutePath(`${filePath}/pubspec.yaml`), 'utf8');
    const pubspec = yaml.load(fileContent) as Record<string, any>;

    return pubspec[field];
  } catch (error) {
    throw new Error(`Error reading file ${filePath}: ${error}`);
  }
}

/**
 * Bump 'version' of the given pubspec.yaml file path.
 */
async function bumpPubspecVersion(filePath: string, nextVersion: string): Promise<void> {
  try {
    const fileContent = await fsp.readFile(toAbsolutePath(filePath), 'utf8');
    const pubspec = yaml.load(fileContent) as Record<string, any>;

    pubspec.version = nextVersion;

    await fsp.writeFile(filePath, yaml.dump(pubspec));
  } catch (error) {
    throw new Error(`Error writing file ${filePath}: ${error}`);
  }
}

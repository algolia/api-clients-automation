import fsp from 'fs/promises';

import yaml from 'js-yaml';

import clientsConfig from '../../config/clients.config.json' with { type: 'json' };
import { GENERATORS, toAbsolutePath } from '../common.ts';

import { writeJsonFile } from './common.ts';
import { updateChangelog } from './updateAPIVersions.ts';

/**
 * Updates packages versions and generates the changelog.
 */
export async function updateDartPackages(changelog: string, nextVersion: string): Promise<void> {
  for (const gen of Object.values(GENERATORS)) {
    if (gen.language !== 'dart') {
      continue;
    }

    if (!nextVersion) {
      throw new Error(`Failed to bump '${gen.client}'.`);
    }

    let currentVersion = await getPubspecField(gen.output, 'version');

    // if there's no version then it mostly means it's a new client.
    if (!currentVersion) {
      currentVersion = '0.0.1';
    }

    await updateChangelog('dart', changelog, currentVersion, nextVersion, toAbsolutePath(`${gen.output}/CHANGELOG.md`));
  }

  // Version is sync'd on every clients so we set it once.
  clientsConfig.dart.packageVersion = nextVersion;

  // update `clients.config.json` file for the utils version.
  await writeJsonFile(toAbsolutePath('config/clients.config.json'), clientsConfig);

  // Core client package path
  const corePackagePath = 'clients/algoliasearch-client-dart/packages/client_core';

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
    toAbsolutePath(`${corePackagePath}/CHANGELOG.md`),
  );

  // we've bumped generated clients but still need to do the manual ones.
  await bumpPubspecVersion(toAbsolutePath(`${corePackagePath}/pubspec.yaml`), nextVersion);
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

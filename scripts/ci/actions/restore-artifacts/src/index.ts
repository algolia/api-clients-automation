import type { Artifact, DownloadArtifactOptions, DownloadArtifactResponse, FindOptions } from '@actions/artifact';
import { DefaultArtifactClient } from '@actions/artifact';
import * as core from '@actions/core';
import { exec } from '@actions/exec';
import * as io from '@actions/io';

import type { Verification } from './checksums.ts';
import { parseExpectedChecksums, verifyChecksum, warnAboutUnverified } from './checksums.ts';

async function download(
  client: DefaultArtifactClient,
  artifactID: number,
  options?: DownloadArtifactOptions & FindOptions,
): Promise<DownloadArtifactResponse> {
  try {
    return await client.downloadArtifact(artifactID, options);
  } catch {
    try {
      return await client.downloadArtifact(artifactID, options);
    } catch {
      return await client.downloadArtifact(artifactID, options);
    }
  }
}

async function restoreSpecs(verification: Verification): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  const specArtifact = artifacts.artifacts.find((a) => a.name === 'specs');
  if (specArtifact === undefined) {
    throw new Error('No specs artifact found');
  }

  const res = await download(artifact, specArtifact.id);
  core.info(`Downloaded artifact to ${res.downloadPath}`);
  await verifyChecksum(verification, 'specs', 'specs-bundle.zip');
  await exec('unzip -q -o specs-bundle.zip');
  await io.rmRF('specs-bundle.zip');
}

async function extractLanguageArtifact(
  artifactClient: DefaultArtifactClient,
  languageArtifact: Artifact,
  languageName: string,
  verification: Verification,
): Promise<void> {
  await download(artifactClient, languageArtifact.id);
  await verifyChecksum(verification, `clients-${languageName}`, `clients-${languageName}.zip`);
  await io.rmRF(`clients/algoliasearch-client-${languageName}`);
  await io.rmRF(`docs/guides/${languageName}`);
  await io.rmRF(`docs/snippets/${languageName}`);
  await exec(`unzip -q -o clients-${languageName}.zip`);
  await io.rmRF(`clients-${languageName}.zip`);
}

async function restoreLanguage(language: string, verification: Verification): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  const langArtifact = artifacts.artifacts.find((a) => a.name === `clients-${language}`);
  if (langArtifact === undefined) {
    throw new Error(`No ${language} artifact found`);
  }

  await extractLanguageArtifact(artifact, langArtifact, language, verification);
}

async function restoreLanguages(verification: Verification): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  for (const arti of artifacts.artifacts.filter((a) => a.name.startsWith('clients-'))) {
    const language = arti.name.replace('clients-', '');

    await extractLanguageArtifact(artifact, arti, language, verification);
  }
}

async function run(): Promise<void> {
  try {
    const actionType = core.getInput('type');
    const verification: Verification = {
      checksums: parseExpectedChecksums(core.getMultilineInput('expected-checksums')),
      unverified: [],
    };
    if (actionType === 'specs') {
      await restoreSpecs(verification);
    } else if (actionType === 'all') {
      await restoreSpecs(verification);
      await restoreLanguages(verification);
    } else if (actionType === 'languages') {
      const languages = core.getMultilineInput('languages');
      await restoreSpecs(verification);
      for (const language of languages) {
        await restoreLanguage(language, verification);
      }
    } else {
      throw new Error(`Unknown type: ${actionType}`);
    }
    warnAboutUnverified(verification.unverified);
  } catch (error) {
    if (error instanceof Error) {
      core.setFailed(error.message);
    }
  }
}

run();

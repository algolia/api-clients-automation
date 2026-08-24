import { createHash } from 'node:crypto';
import { createReadStream } from 'node:fs';
import { isAbsolute } from 'node:path';

import type { Artifact, DownloadArtifactOptions, DownloadArtifactResponse, FindOptions } from '@actions/artifact';
import { DefaultArtifactClient } from '@actions/artifact';
import * as core from '@actions/core';
import { exec } from '@actions/exec';
import * as io from '@actions/io';

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

// lines are `<sha256> <artifact name>` coming from the producing jobs' outputs,
// artifacts without a line are restored unverified, a line that does not parse fails
function getExpectedChecksums(): Map<string, string> {
  const checksums = new Map<string, string>();
  for (const line of core.getMultilineInput('expected-checksums')) {
    const [sha, name] = line.trim().split(/\s+/);
    if (!sha || !name || !/^[0-9a-f]{64}$/.test(sha)) {
      throw new Error(
        `Malformed expected-checksums line '${line}', the producing job's checksum output is probably missing`,
      );
    }
    checksums.set(name, sha);
  }
  return checksums;
}

async function sha256(filePath: string): Promise<string> {
  return new Promise((resolve, reject) => {
    if (filePath.includes('..') || isAbsolute(filePath)) {
      reject(new Error('Invalid file path'));
      return;
    }
    const hash = createHash('sha256');
    createReadStream(filePath)
      .on('error', reject)
      .on('data', (chunk) => hash.update(chunk))
      .on('end', () => resolve(hash.digest('hex')));
  });
}

async function verifyChecksum(checksums: Map<string, string>, artifactName: string, filePath: string): Promise<void> {
  const expected = checksums.get(artifactName);
  if (expected === undefined) {
    core.warning(`No checksum provided for the '${artifactName}' artifact, restoring it unverified`);
    return;
  }
  const actual = await sha256(filePath);
  if (actual !== expected) {
    throw new Error(`Checksum mismatch for the '${artifactName}' artifact: expected ${expected}, got ${actual}`);
  }
  core.info(`Checksum verified for the '${artifactName}' artifact`);
}

async function restoreSpecs(checksums: Map<string, string>): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  const specArtifact = artifacts.artifacts.find((a) => a.name === 'specs');
  if (specArtifact === undefined) {
    throw new Error('No specs artifact found');
  }

  const res = await download(artifact, specArtifact.id);
  core.info(`Downloaded artifact to ${res.downloadPath}`);
  await verifyChecksum(checksums, 'specs', 'specs-bundle.zip');
  await exec('unzip -q -o specs-bundle.zip');
  await io.rmRF('specs-bundle.zip');
}

async function extractLanguageArtifact(
  artifactClient: DefaultArtifactClient,
  languageArtifact: Artifact,
  languageName: string,
  checksums: Map<string, string>,
): Promise<void> {
  await download(artifactClient, languageArtifact.id);
  await verifyChecksum(checksums, `clients-${languageName}`, `clients-${languageName}.zip`);
  await io.rmRF(`clients/algoliasearch-client-${languageName}`);
  await io.rmRF(`docs/guides/${languageName}`);
  await io.rmRF(`docs/snippets/${languageName}`);
  await exec(`unzip -q -o clients-${languageName}.zip`);
  await io.rmRF(`clients-${languageName}.zip`);
}

async function restoreLanguage(language: string, checksums: Map<string, string>): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  const langArtifact = artifacts.artifacts.find((a) => a.name === `clients-${language}`);
  if (langArtifact === undefined) {
    throw new Error(`No ${language} artifact found`);
  }

  await extractLanguageArtifact(artifact, langArtifact, language, checksums);
}

async function restoreLanguages(checksums: Map<string, string>): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  for (const arti of artifacts.artifacts.filter((a) => a.name.startsWith('clients-'))) {
    const language = arti.name.replace('clients-', '');

    await extractLanguageArtifact(artifact, arti, language, checksums);
  }
}

async function run(): Promise<void> {
  try {
    const actionType = core.getInput('type');
    const checksums = getExpectedChecksums();
    if (actionType === 'specs') {
      await restoreSpecs(checksums);
    } else if (actionType === 'all') {
      await restoreSpecs(checksums);
      await restoreLanguages(checksums);
    } else if (actionType === 'languages') {
      const languages = core.getMultilineInput('languages');
      await restoreSpecs(checksums);
      for (const language of languages) {
        await restoreLanguage(language, checksums);
      }
    } else {
      throw new Error(`Unknown type: ${actionType}`);
    }
  } catch (error) {
    if (error instanceof Error) {
      core.setFailed(error.message);
    }
  }
}

run();

import type {
  DownloadArtifactOptions,
  DownloadArtifactResponse,
  FindOptions,
} from '@actions/artifact';
import { DefaultArtifactClient } from '@actions/artifact';
import * as core from '@actions/core';
import { exec } from '@actions/exec';
import * as io from '@actions/io';

async function download(
  client: DefaultArtifactClient,
  artifactID: number,
  options?: DownloadArtifactOptions & FindOptions
): Promise<DownloadArtifactResponse> {
  try {
    return await client.downloadArtifact(artifactID, options);
  } catch (e1) {
    try {
      return await client.downloadArtifact(artifactID, options);
    } catch (e2) {
      return await client.downloadArtifact(artifactID, options);
    }
  }
}

async function restoreSpecs(): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  const specArtifact = artifacts.artifacts.find((a) => a.name === 'specs');
  if (specArtifact === undefined) {
    throw new Error('No specs artifact found');
  }

  const res = await download(artifact, specArtifact.id, { path: 'specs/bundled' });
  core.info(`Downloaded artifact to ${res.downloadPath}`);
}

async function restoreLanguages(): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  for (const arti of artifacts.artifacts.filter((a) => a.name.startsWith('clients-'))) {
    const language = arti.name.replace('clients-', '');
    await download(artifact, arti.id);
    await io.rmRF(`clients/algoliasearch-client-${language}`);
    await exec(`unzip -q -o clients-${language}.zip`);
    await io.rmRF(`clients-${language}.zip`);
  }
}

async function run(): Promise<void> {
  try {
    const actionType = core.getInput('type');
    if (actionType === 'specs') {
      await restoreSpecs();
    } else if (actionType === 'all') {
      await restoreSpecs();
      await restoreLanguages();
    } else {
      throw new Error(`Unknown type: ${actionType}`);
    }
  } catch (error) {
    if (error instanceof Error) core.setFailed(error.message);
  }
}

run();

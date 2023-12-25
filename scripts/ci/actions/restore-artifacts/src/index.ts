import { DefaultArtifactClient } from '@actions/artifact';
import * as core from '@actions/core';

async function restoreSpecs(): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();
  const specArtifact = artifacts.artifacts.find((a) => a.name === 'specs');
  if (specArtifact === undefined) {
    throw new Error('No specs artifact found');
  }

  const res = await artifact.downloadArtifact(specArtifact.id, { path: 'specs/bundled' });
  core.info(`Downloaded artifact to ${res.downloadPath}`);
}

async function run(): Promise<void> {
  try {
    const actionType = core.getInput('type');
    if (actionType === 'specs') {
      await restoreSpecs();
    } else if (actionType === 'all') {
      const languages = core.getInput('languages');

      await restoreSpecs();
      core.info(`languages: ${languages}`);
    } else {
      throw new Error(`Unknown type: ${actionType}`);
    }
  } catch (error) {
    if (error instanceof Error) core.setFailed(error.message);
  }
}

run();

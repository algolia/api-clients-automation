import { DefaultArtifactClient } from '@actions/artifact';
import * as core from '@actions/core';

async function restoreSpecs(): Promise<void> {
  const artifact = new DefaultArtifactClient();
  const artifacts = await artifact.listArtifacts();

  core.info(`artifacts: ${JSON.stringify(artifacts, null, 2)}`);
}

async function run(): Promise<void> {
  try {
    const actionType = core.getInput('type');
    if (actionType === 'restore') {
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

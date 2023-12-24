import { DefaultArtifactClient } from '@actions/artifact';
import * as core from '@actions/core';

async function run(): Promise<void> {
  try {
    const actionType = core.getInput('type');
    const languages = core.getInput('languages');

    core.info(`actionType: ${actionType}`);
    core.info(`languages: ${languages}`);

    const artifact = new DefaultArtifactClient();
    const artifacts = await artifact.listArtifacts();

    core.info(`artifacts: ${artifacts}`);

    core.setOutput('time', new Date().toTimeString());
  } catch (error) {
    if (error instanceof Error) core.setFailed(error.message);
  }
}

run();

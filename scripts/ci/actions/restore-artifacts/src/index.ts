import * as core from '@actions/core';

function run(): void {
  try {
    const actionType = core.getInput('type');
    const languages = core.getInput('languages');

    core.info(`actionType: ${actionType}`);
    core.info(`languages: ${languages}`);

    core.setOutput('time', new Date().toTimeString());
  } catch (error) {
    if (error instanceof Error) core.setFailed(error.message);
  }
}

run();

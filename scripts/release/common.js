/* eslint-disable no-console */
/* eslint-disable @typescript-eslint/no-var-requires */
/* eslint-disable import/no-commonjs */
const execa = require('execa'); // https://github.com/sindresorhus/execa/tree/v5.1.1
const config = require('../../config.json');
const openapitools = require('../../openapitools.json');

function run(command, errorMessage = undefined) {
  let result;
  try {
    result = execa.commandSync(command);
  } catch (err) {
    if (errorMessage) {
      console.error(`[ERROR] ${errorMessage}`);
      // eslint-disable-next-line no-process-exit
      process.exit(err.exitCode);
    } else {
      throw err;
    }
  }
  return result.stdout;
}

const LANGS = [
  ...new Set(
    Object.keys(openapitools['generator-cli'].generators).map(
      (key) => key.split('-')[0]
    )
  ),
];

module.exports = {
  RELEASED_TAG: config.release.releasedTag,
  MAIN_BRANCH: config.release.mainBranch,
  OWNER: config.release.owner,
  REPO: config.release.repo,
  LANGS,
  run,
};

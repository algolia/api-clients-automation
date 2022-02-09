/* eslint-disable no-console */
/* eslint-disable @typescript-eslint/no-var-requires */
/* eslint-disable import/no-commonjs */
const execa = require('execa'); // https://github.com/sindresorhus/execa/tree/v5.1.1

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

module.exports = {
  RELEASED_TAG: 'released',
  MAIN_BRANCH: 'main',
  OWNER: 'algolia',
  REPO: 'api-clients-automation',
  LANGS: ['javascript', 'php', 'java'],
  run,
};

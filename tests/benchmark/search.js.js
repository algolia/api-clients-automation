/* eslint-disable import/no-commonjs */
/* eslint-disable @typescript-eslint/no-var-requires */

const { execFileSync } = require('node:child_process');
// const util = require('util');

const benny = require('benny');

(async () => {
  const options = {
    minSamples: 1,
  };
  const env = {
    APP_ID: process.env.APP_ID,
    API_KEY: process.env.API_KEY,
  };

  await benny.suite(
    'search-js',

    benny.add(
      'v4',
      () => {
        const data = execFileSync(
          process.execPath,
          ['tests/search/js/v4/index.js'],
          {
            cwd: __dirname,
            env,
          }
        );
        const stdout = data.toString();
        if (!stdout.match('✅')) {
          throw new Error();
        }
      },
      options
    ),

    benny.add(
      'v5',
      () => {
        const data = execFileSync(
          process.execPath,
          ['tests/search/js/v5/index.js'],
          {
            cwd: __dirname,
            env,
          }
        );
        const stdout = data.toString();
        if (!stdout.match('✅')) {
          throw new Error();
        }
      },
      options
    ),

    benny.cycle(),

    benny.complete(),

    benny.save({
      file: 'search.js',
      format: 'json',
      details: true,
    })
  );
})();

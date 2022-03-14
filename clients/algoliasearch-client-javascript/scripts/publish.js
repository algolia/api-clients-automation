#!/usr/bin/env node
/* eslint-disable @typescript-eslint/no-var-requires */
/* eslint-disable import/no-commonjs */

const fs = require('fs');
const path = require('path');

const execa = require('execa');
const semver = require('semver');

async function publish() {
  await execa.command(
    `npm config set "registry.npmjs.org/:_authToken=${process.env.NPM_AUTH_TOKEN}"`,
    {
      shell: 'bash',
    }
  );
  // Read the local version of `algoliasearch/package.json`
  const { version } = JSON.parse(
    fs.readFileSync(
      path.resolve(__dirname, '..', 'packages', 'algoliasearch', 'package.json')
    )
  );
  // Get tag like `alpha`, `beta`, ...
  const tag = semver.prerelease(version) ? semver.prerelease(version)[0] : null;

  await execa.command(
    `lerna exec --no-bail npm publish --access public ${
      tag ? `--tag ${tag}` : ''
    }`,
    {
      shell: 'bash',
    }
  );
}

publish();

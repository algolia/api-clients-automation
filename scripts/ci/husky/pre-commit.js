#!/usr/bin/env node
/* eslint-disable import/no-commonjs */
/* eslint-disable @typescript-eslint/no-var-requires */
const execa = require('execa');
const micromatch = require('micromatch');

const GENERATED_FILE_PATTERNS = [
  // Ignore the roots and go down the tree by negating hand written files
  'clients/**/*',
  '!clients/README.md',
  '!clients/**/.openapi-generator-ignore',

  // Java
  '!clients/algoliasearch-client-java-2/algoliasearch-core/com/algolia/exceptions/*',
  '!clients/algoliasearch-client-java-2/algoliasearch-core/com/algolia/utils/*',
  'clients/algoliasearch-client-java-2/algoliasearch-core/com/algolia/utils/echo/EchoResponse.java',

  // JavaScript
  '!clients/algoliasearch-client-javascript/*',
  '!clients/algoliasearch-client-javascript/.github/**/*',
  '!clients/algoliasearch-client-javascript/.yarn/**/*',
  '!clients/algoliasearch-client-javascript/scripts/**/*',
  '!clients/algoliasearch-client-javascript/packages/algoliasearch/**/*',
  '!clients/algoliasearch-client-javascript/packages/requester-*/**/*',
  '!clients/algoliasearch-client-javascript/packages/client-common/**/*',

  // PHP
  '!clients/algoliasearch-client-php/lib/Configuration/*',
  'clients/algoliasearch-client-php/lib/*.php',
  'clients/algoliasearch-client-php/lib/Api/*',
  'clients/algoliasearch-client-php/lib/Configuration/Configuration.php',
];

const run = async (command, { cwd } = {}) => {
  return (
    (await execa.command(command, { shell: 'bash', all: true, cwd })).all ?? ''
  );
};

function createMemoizedMicromatchMatcher(patterns = []) {
  const exactMatchers = [];
  const positiveMatchers = [];
  const negativeMatchers = [];

  patterns.forEach((pattern) => {
    if (pattern.charCodeAt(0) === 33) {
      // Patterns starting with `!` are negated
      negativeMatchers.push(micromatch.matcher(pattern.slice(1)));
    } else if (!pattern.includes('*')) {
      exactMatchers.push(micromatch.matcher(pattern));
    } else {
      positiveMatchers.push(micromatch.matcher(pattern));
    }
  });

  return function matcher(str) {
    if (exactMatchers.some((match) => match(str))) {
      return true;
    }

    // As `some` returns false on empty array, test will always fail if we only
    // provide `negativeMatchers`. We fallback to `true` is it's the case.
    const hasPositiveMatchers =
      Boolean(positiveMatchers.length === 0 && negativeMatchers.length) ||
      positiveMatchers.some((match) => match(str));

    return hasPositiveMatchers && !negativeMatchers.some((match) => match(str));
  };
}

async function preCommit() {
  const stagedFiles = (await run(`git diff --name-only --cached`)).split('\n');
  const matcher = createMemoizedMicromatchMatcher(GENERATED_FILE_PATTERNS);
  if (stagedFiles.some((file) => matcher(file))) {
    const generatedFiles = stagedFiles.filter((file) => matcher(file));
    throw new Error(
      `You cannot include generated files in the commit. Please unstage the following:\n\n${generatedFiles
        .map((file) => `  - ${file}`)
        .join('\n')}`
    );
  }
}

if (require.main === module) {
  preCommit();
}

module.exports = {
  createMemoizedMicromatchMatcher,
};

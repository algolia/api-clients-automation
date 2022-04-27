/* eslint-disable no-console */
import { hashElement } from 'folder-hash';

import { getNbGitDiff } from './utils';

const JS_CLIENT_FOLDER = 'clients/algoliasearch-client-javascript';

/**
 * Exhaustive list of output variables to use in the CI.
 *
 * Those variables are used to determine if jobs should run, based on the changes
 * made in their respective `path`s.
 *
 * Negative paths should start with `:!`.
 *
 * The variable will be accessible in the CI via `steps.diff.outputs.<name>`.
 */
const VARIABLES_TO_CHECK: Array<{
  name: string;
  path: string[];
}> = [
  {
    name: 'GITHUB_ACTIONS_CHANGED',
    path: ['.github/actions', '.github/workflows', '.github/.cache_version'],
  },
  {
    name: 'SPECS_CHANGED',
    path: ['specs', ':!specs/bundled'],
  },
  {
    name: 'COMMON_SPECS_CHANGED',
    path: ['specs/common'],
  },
  {
    name: 'TESTS_CHANGED',
    path: ['tests'],
  },
  {
    name: 'SCRIPTS_CHANGED',
    path: ['scripts'],
  },
  {
    name: 'GENERATORS_CHANGED',
    path: ['generators'],
  },
  {
    name: 'JS_CLIENT_CHANGED',
    path: [
      JS_CLIENT_FOLDER,
      `:!${JS_CLIENT_FOLDER}/.github`,
      `:!${JS_CLIENT_FOLDER}/README.md`,
    ],
  },
  {
    name: 'JS_ALGOLIASEARCH_CHANGED',
    path: [
      `${JS_CLIENT_FOLDER}/packages/algoliasearch`,
      `${JS_CLIENT_FOLDER}/packages/client-search`,
      `${JS_CLIENT_FOLDER}/packages/client-analytics`,
      `${JS_CLIENT_FOLDER}/packages/client-personalization`,
    ],
  },
  {
    name: 'JS_COMMON_CHANGED',
    path: [
      `${JS_CLIENT_FOLDER}/packages/client-common`,
      `${JS_CLIENT_FOLDER}/packages/requester-browser-xhr`,
      `${JS_CLIENT_FOLDER}/packages/requester-node-http`,
    ],
  },
  {
    name: 'JS_COMMON_TESTS_CHANGED',
    path: [`${JS_CLIENT_FOLDER}/packages/client-common/src/__tests__`],
  },
  {
    name: 'JS_TEMPLATE_CHANGED',
    path: ['templates/javascript'],
  },
  {
    name: 'JAVA_CLIENT_CHANGED',
    path: ['clients/algoliasearch-client-java-2'],
  },
  {
    name: 'JAVA_TEMPLATE_CHANGED',
    path: ['templates/java'],
  },
  {
    name: 'PHP_CLIENT_CHANGED',
    path: ['clients/algoliasearch-client-php'],
  },
  {
    name: 'PHP_TEMPLATE_CHANGED',
    path: ['templates/php'],
  },
];

// simple hash to reduce the hash length
// reference: https://code-examples.net/en/q/7437cd
function hashCode(str: string): string {
  const p1 = 2654435761;
  const p2 = 1597334677;
  let h1 = 0xdeadbeef | 0;
  let h2 = 0x41c6ce57 | 0;
  for (let i = 0; i < str.length; i++) {
    const ch = str.charCodeAt(i);
    h1 = Math.imul(h1 + ch, p1);
    h2 = Math.imul(h2 + ch, p2);
  }
  h1 = Math.imul(h1 ^ (h1 >>> 16), p2);
  h2 = Math.imul(h2 ^ (h2 >>> 15), p1);
  return ((h2 & 2097151) * 4294967296 + h1).toString(16);
}

async function computeCommonHash(): Promise<string> {
  const hashGA = await hashElement('../.github', {
    encoding: 'hex',
    folders: { exclude: ['ISSUE_TEMPLATE'] },
    files: { include: ['*.yml', '.cache_version'] },
  });
  const hashScripts = await hashElement('../scripts', {
    encoding: 'hex',
    folders: { exclude: ['docker', '__tests__'] },
  });
  const hashConfig = await hashElement('../', {
    encoding: 'hex',
    folders: { include: ['config'] },
    files: { include: ['openapitools.json', 'clients.config.json'] },
  });

  return hashCode(`${hashGA.hash}-${hashScripts.hash}-${hashConfig.hash}`);
}

/**
 * Outputs variables used in the CI to determine if a job should run.
 */
async function setRunVariables({
  originBranch,
}: {
  originBranch: string;
}): Promise<void> {
  console.log(`Checking diff between ${originBranch} and HEAD`);

  for (const check of VARIABLES_TO_CHECK) {
    const diff = await getNbGitDiff({
      branch: originBranch,
      path: check.path.join(' '),
    });

    console.log(`Found ${diff} changes for '${check.name}'`);
    console.log(`::set-output name=${check.name}::${diff}`);
  }

  console.log(`::set-output name=COMMON_HASH::${await computeCommonHash()}`);

  console.log(`::set-output name=ORIGIN_BRANCH::${originBranch}`);
}

if (require.main === module) {
  const [originBranch] = process.argv.slice(2);

  if (!originBranch) {
    throw new Error(
      `Unable to retrieve the origin branch: ${JSON.stringify(originBranch)}`
    );
  }

  setRunVariables({ originBranch });
}

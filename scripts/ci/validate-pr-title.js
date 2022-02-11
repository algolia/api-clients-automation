#!/usr/bin/env node
/* eslint-disable no-console */
/* eslint-disable import/no-commonjs */
/* eslint-disable @typescript-eslint/no-var-requires */

const github = require('@actions/github');

const TYPES = [
  'feat',
  'fix',
  'docs',
  'style',
  'refactor',
  'perf',
  'test',
  'build',
  'ci',
  'chore',
  'revert',
];

const SCOPES = ['javascript', 'php', 'java', 'cts', 'spec', 'script'];

const STATUS_COMMENT_HEADER = `**Pull-Request / Valid Title**`;

const SUCCESS_COMMENT_BODY = `${STATUS_COMMENT_HEADER}

💯 All good`;

const FAILURE_COMMENT_BODY = `${STATUS_COMMENT_HEADER}

😱 The title is not valid. The title should follow the format: \`type(scope): message\`

* type
${TYPES.map((type) => `  * ${type}`).join('\n')}
  * asdfa
  * few
  * fsdf
* scope
${SCOPES.map((type) => `  * ${type}`).join('\n')}

To add new type or scope, edit \`scripts/ci/validate-pr-title.js\`.`;

const client = github.getOctokit(process.env.GITHUB_TOKEN);
const contextPullRequest = github.context.payload.pull_request;

if (!contextPullRequest) {
  throw new Error(
    "This action can only be invoked in `pull_request_target` or `pull_request` events. Otherwise the pull request can't be inferred."
  );
}

const owner = contextPullRequest.base.user.login;
const repo = contextPullRequest.base.repo.name;
const pullNumber = contextPullRequest.number;

function validateTitle(title) {
  const result = title.match(/(.+)\((.+)\): .+/);
  if (!result) {
    return false;
  }
  const [, type, scope] = result;
  return TYPES.includes(type) && SCOPES.includes(scope);
}

async function postValidationResult({ pullRequest, isValid }) {
  // https://docs.github.com/en/rest/reference/commits#create-a-commit-status
  await client.request('POST /repos/:owner/:repo/statuses/:sha', {
    owner,
    repo,
    sha: pullRequest.head.sha,
    state: isValid ? 'success' : 'failure',
    context: 'Pull-request / Validate title',
  });
}

async function getStatusComment({ contextPullRequest }) {
  // https://docs.github.com/en/rest/reference/issues#comments
  const { data: comments } = await client.request(
    'GET /repos/:owner/:repo/issues/:number/comments',
    {
      owner,
      repo,
      number: contextPullRequest.number,
    }
  );

  return comments.find((comment) =>
    comment.body.startsWith(STATUS_COMMENT_HEADER)
  );
}

async function postStatusComment({
  statusComment,
  contextPullRequest,
  isValid,
}) {
  if (statusComment) {
    // update the existing comment
    await client.request('PATCH /repos/:owner/:repo/issues/comments/:id', {
      owner,
      repo,
      id: statusComment.id,
      body: isValid ? SUCCESS_COMMENT_BODY : FAILURE_COMMENT_BODY,
    });
  } else {
    // or create a new comment
    await client.request('POST /repos/:owner/:repo/issues/:number/comments', {
      owner,
      repo,
      number: contextPullRequest.number,
      body: isValid ? SUCCESS_COMMENT_BODY : FAILURE_COMMENT_BODY,
    });
  }
}

async function main() {
  const { data: pullRequest } = await client.rest.pulls.get({
    owner,
    repo,
    pull_number: pullNumber,
  });

  const { title } = pullRequest;

  const isValid = validateTitle(title);
  await postValidationResult({ pullRequest, isValid });

  const statusComment = await getStatusComment({ contextPullRequest });
  await postStatusComment({ statusComment, contextPullRequest, isValid });
}

main();

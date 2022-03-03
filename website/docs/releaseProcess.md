---
title: Release process
---

# Release process

The most of the release process is automated.

## Part 1

You need `GITHUB_TOKEN` in your `.env` file. You can generate one from [Personal access token](https://github.com/settings/tokens/new).

```
GITHUB_TOKEN=<YOUR-PERSONAL-ACCESS-TOKEN>
```

Once it's prepared, you can run

```bash
yarn release
```

It will create [a release issue](https://github.com/algolia/api-clients-automation/issues/220).

Even this Part 1 can be automated later (with a cron job on GitHub Action, probably run every week).

## Part 2

You need to review the release issue, in two parts:

1. version changes
2. CHANGELOGs

Any changes applied in the issue will be taken into account by the release process.

You can click "Approved" to approve the release, and close it, which will trigger the Part 3.

For now, this monorepo is private, so we do not need any validation. But we need to do more work to check if this issue is created by the team, and if the issue is approved by the team, etc. One idea is, instead of checking "Approved" check-box, team member can leave a comment saying "Approved", and GitHub Action will be able to validate the approval in more secure way.

## Part 3

The [GitHub action release](https://github.com/algolia/api-clients-automation/blob/main/.github/workflows/process-release.yml) is triggered. It generates clients and push changes to the submodules. All the submodules will have new commits on their base branch (`next`).

This Part 3 runs conditionally according to what has been done in Part 2. Under "Version Changes" section of the release issue, if a language is checked, this Part 3 will creates a commit like `chore: release v<NEXT-VERSION>` in the submodule. If it is not checked, it will create a commit like `chore: update repo <DATE-STAMP>`.

Each language repository should have their own release process, and should run only when the latest commit starts with `chore: release`. By doing so, we have a way to just update the repository, for example READMEs, without having to release.

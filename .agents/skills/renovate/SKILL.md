---
name: renovate
description: Review, merge, and report on Renovate and Dependabot dependency update PRs targeting `chore/renovateBaseBranch`. Handles changelog analysis, CI verification, template-vs-generated detection, custom action builds, Dependabot cherry-picks, and structured reporting.
disable-model-invocation: true
allowed-tools: Bash(git status), Bash(git branch *), Bash(git diff *), Bash(git checkout *), Bash(git add *), Bash(git commit *), Bash(git push *), Bash(git pull *), Bash(git fetch *), Bash(git merge *), Bash(git rebase *), Bash(git cherry-pick *), Bash(git log *), Bash(yarn *), Bash(cat *), Bash(sed *), Bash(gh pr list *), Bash(gh pr view *), Bash(gh pr merge *), Bash(gh pr checks *), Bash(gh pr edit *), Bash(gh pr close *), Bash(gh run rerun *), Bash(gh run list *), Bash(gh run view *)
---

You are reviewing and merging dependency update PRs targeting `chore/renovateBaseBranch` in the `algolia/api-clients-automation` repository.

NEVER PUSH TO `main` OR MERGE ANY PRS DIRECTLY INTO `main`.

## Context

This is a multi-language API client generator (JavaScript, Python, Java, Go, Ruby, PHP, Kotlin, Scala, Swift, Dart, C#). Dependency updates come from two sources:

- **Renovate**: PRs targeting `chore/renovateBaseBranch` (the normal flow)
- **Dependabot**: PRs targeting `main` (need cherry-picking onto the base branch)

Generated client code lives in `clients/` and is produced from Mustache templates in `templates/`. Renovate sometimes updates generated files instead of templates — these changes get silently lost on next regeneration and the same PR will reappear the following week.

## 1. Sync the base branch

```
git fetch origin
git checkout chore/renovateBaseBranch
git merge origin/main
git push
```

## 2. List and categorize PRs

```
gh pr list --base chore/renovateBaseBranch --state open --json number,title,headRefName,statusCheckRollup,mergeable
```

Categorize into six buckets:

1. **Abandoned**: Title contains ` - abandoned`
2. **Ready to merge**: All CI checks have completed (`SUCCESS` or `SKIPPED`) — no `IN_PROGRESS`/`QUEUED`/`PENDING` checks — AND `mergeable` is `MERGEABLE`
3. **CI failing**: At least one non-skipped check has `conclusion: "FAILURE"`
4. **Conflicting**: `mergeable` is not `MERGEABLE`
5. **CI in progress**: At least one check has `status: "IN_PROGRESS"` or `status: "QUEUED"` or `status: "PENDING"` and none have `conclusion: "FAILURE"`
6. **Retried (awaiting CI)**: PRs that had flaky failures and were retried this run (tracked during step 5)

The `push_and_release` check only runs on pushes to `main` — it will always appear as `SKIPPED` on PRs. Ignore it. Many `client *` matrix entries will also be `SKIPPED` depending on which languages the dependency change affects — this is expected.

## 3. Close abandoned PRs

For each abandoned PR: `gh pr close <number> --delete-branch`. Add to the "Abandoned" report list.

## 4. Review and merge passing PRs

Process one PR at a time — merging changes the base, which can cause conflicts in remaining PRs.

For each PR:

**Step 4.1** — Read the PR body: `gh pr view <number> --json body -q '.body'`

**Step 4.2 — Breaking change detection gate.** Run ALL three checks below on the PR body. If **ANY** check triggers, the PR has breaking changes.

- **Check A — Package table (major version bump):** Renovate PRs include a package table. Two formats exist:
  - Format A: `| Package | Type | Update | Change |` — the "Update" column contains `major`, `minor`, or `patch`
  - Format B: `| Package | Change | Age | Adoption | Passing | Confidence |` — has NO "Update" column
  - Look for `| major |` in any table row. If found → **BREAKING**.

- **Check B — Release Notes content:** The PR body contains a `### Release Notes` section with one or more `<details><summary>...</summary>...</details>` blocks. Read the **FULL** content inside each `<details>` block carefully and look for **ANY** of these signals:
  - `### Breaking Changes` or `## Breaking Changes` headings
  - `💥` emoji (anywhere in the block)
  - `BREAKING CHANGE` or `BREAKING CHANGES` text (case-insensitive)
  - `deprecated` or `removed` keywords
  - If **ANY** signal is found in **ANY** `<details>` block → **BREAKING**.

- **Check C — Full body scan (safety net):** Scan the **ENTIRE** PR body (not just Release Notes) for:
  - `BREAKING CHANGE` or `BREAKING CHANGES` text
  - `💥` emoji
  - `| major |` text
  - If **ANY** signal is found → **BREAKING**.

**Step 4.3 — Template-vs-generated file detection.**

Get the list of changed files: `gh pr view <number> --json files -q '.files[].path'`

Check if ANY changed file is under `clients/` AND is NOT one of these lock files:

- `yarn.lock`, `poetry.lock`, `Gemfile.lock`, `go.sum`, `composer.lock`, `pubspec.lock`, `Package.resolved`

If such files exist AND no files under `templates/` were changed in the same PR → **TEMPLATE ISSUE**.

When a template issue is detected, map each affected generated file to its likely template source:

| Generated file pattern                                    | Likely template source                          |
| --------------------------------------------------------- | ----------------------------------------------- |
| `clients/algoliasearch-client-python/pyproject.toml`      | `templates/python/pyproject.mustache`           |
| `clients/algoliasearch-client-javascript/**/package.json` | `templates/javascript/clients/package.mustache` |
| `clients/algoliasearch-client-java/**/build.gradle`       | `templates/java/tests/build.mustache`           |
| `clients/algoliasearch-client-dart/pubspec.yaml`          | `templates/dart/pubspec.mustache`               |
| `clients/algoliasearch-client-csharp/**/*.csproj`         | `templates/csharp/*.mustache`                   |
| Other `clients/algoliasearch-client-<lang>/<file>`        | Check `templates/<lang>/` for `<stem>.mustache` |

**Step 4.4 — Scala version fix.**

If the PR updates the Scala version in `clients/algoliasearch-client-scala/build.sbt`, the Scala client supports both v2 and v3 via `crossScalaVersions`. The `scalaVersion` property MUST stay on the 2.x line (it is the default/primary version). Renovate may incorrectly bump `scalaVersion` to a 3.x version.

Check the diff: `gh pr diff <number> -- clients/algoliasearch-client-scala/build.sbt`

If the PR changes the `scalaVersion` line:

1. Checkout the branch: `git fetch origin <branch-name> && git checkout <branch-name>`
2. Revert the `scalaVersion` change (keep it at its current 2.x value)
3. If the PR is a Scala 3.x update: apply the new 3.x version to the `crossScalaVersions` sequence instead — update the `3.x.x` entry (e.g., `"3.6.3"` → `"3.7.0"`)
4. Commit: `git add clients/algoliasearch-client-scala/build.sbt && git commit -m "fix: update Scala 3.x in crossScalaVersions, keep scalaVersion on 2.x" && git push`
5. Do NOT wait for CI. Add to "CI In Progress" report list.

If the PR only updates the `crossScalaVersions` 3.x entry or the 2.x `scalaVersion`, no fix is needed — proceed normally.

**Step 4.5 — Known blocked updates.**

Close (do not merge) PRs that update these packages, and add them to the "Abandoned" report list with a note:

- **Dart `json_serializable`**: Updating `json_serializable` requires updating `json_annotation`, which in turn requires bumping the minimum Dart SDK version. This is a breaking change for customers on older Dart versions. Close the PR.
- **`@redocly/cli` beyond v2.27.0**: v2.27.1 introduces breaking changes (renaming components) that break our spec bundling. Pinned at v2.27.0 for now. Close the PR.

**Step 4.6 — Dart caret versioning.**

Dart dependencies in `clients/algoliasearch-client-dart/packages/client_core/pubspec.yaml` MUST use caret (`^`) versioning (e.g., `archive: ^4.0.9`, not `archive: 4.0.9`). Renovate may strip the caret when bumping versions. If a Dart PR changes a dependency version and the caret is missing, checkout the branch, restore the `^` prefix, commit, and push before merging.

**Step 4.7 — Decision:**

- If **ANY** breaking change check (A, B, or C) triggered → do **NOT** merge. Add to "⚠️ Breaking changes (needs human review)" list with a note of what was found (e.g., "major version bump", "Release Notes contain `### Breaking Changes`", "Release Notes contain `💥`").
- If **template issue** detected → do **NOT** merge. Add to "🔧 Template fix needed (needs human review)" list with the generated→template file mapping.
- If a PR triggers **both** → add to both lists, do **NOT** merge.
- If **NEITHER** triggered → merge: `gh pr merge <number> --squash --delete-branch`

**Step 4.8** — After each merge, re-check remaining PRs for new conflicts.

> ⚠️ A minor or patch version bump does NOT mean there are no breaking changes. Always check the Release Notes content inside `<details>` blocks.

## 5. Validate dependencies and Docker images

After merging PRs, ensure the base branch is in a healthy state before continuing.

```
git checkout chore/renovateBaseBranch
git pull origin chore/renovateBaseBranch
yarn
yarn docker:setup
```

If `yarn` fails, a merged PR likely introduced an invalid lockfile or an unpublishable dependency — add a note to the report under "❌ Failing CI (needs human attention)" and continue.

If `yarn docker:setup` fails, a Docker image may have been removed or renamed — add a note to the report and continue.

## 6. Handle failing PRs

For each failing PR, inspect failures: `gh pr checks <number>`

**Path 1 — Custom action build fix** (`setup` or `scripts` check fails):

The `setup` job includes a "check that custom actions are built" step. When a dependency update changes root `package.json` or `yarn.lock`, the built action bundles may become stale, causing this step to fail.

To confirm this is the cause, inspect the failed run's `setup` job logs:

1. Get run ID: `gh run list --branch <branch-name> --limit 1 --json databaseId -q '.[0].databaseId'`
2. View the setup job log: `gh run view <run-id> --log | grep -A 5 "check that custom actions are built"`
3. If the log shows a diff in any `scripts/ci/actions/*/builddir/index.cjs` file → this is a stale build. Proceed with the fix below.
4. If the failure is unrelated to custom action builds → add to "Failing" list instead (Path 3).

Fix:

1. `git fetch origin <branch-name> && git checkout <branch-name>`
2. `yarn`
3. `yarn workspace scripts build:actions`
4. Check if there are changes to commit: `git status`
5. If no changes were produced, the failure is unrelated to action builds — add to "Failing" list instead.
6. Stage only the built file: `git add scripts/ci/actions/*/builddir/index.cjs`
7. Verify that ONLY the built script file is staged: `git diff --cached --name-only` — if the only staged file(s) match `scripts/ci/actions/*/builddir/index.cjs`, commit with `--no-verify` to skip pre-commit hooks (they require a full dev environment). If other files are staged, do NOT use `--no-verify` — commit normally.
8. `git commit --no-verify -m "chore: rebuild custom actions after dependency update" && git push`
9. Do NOT wait for CI. Add to "CI In Progress" report list. The next skill run will pick up the results.

**Path 2 — Flaky CI retry** (failure in a client build/test job):

Retriable job names match the pattern `client *` — these are the language-specific build and test matrix jobs:

- `client javascript@*`
- `client <language>@*` (any language matrix entry: php, python, java, go, ruby, kotlin, scala, swift, dart, csharp)
- `client kotlin@* macos`
- `client swift@* linux`

Steps:

1. Get run ID: `gh run list --branch <branch-name> --limit 1 --json databaseId -q '.[0].databaseId'`
2. Rerun failed jobs: `gh run rerun <run-id> --failed`
3. Do NOT wait for CI to complete. Add to "Retried" report list. The next skill run will pick up the results.

**Path 3 — Give up**: If the failure is in `specs`, `codegen`, or `check_green`, or in `setup` for a reason other than stale custom action builds (see Path 1), or doesn't match any recovery path, add to "Failing" list. Do NOT retry infrastructure job failures — they indicate real issues.

## 7. Handle conflicting PRs

After merging PRs, some may have become conflicting. Rebase them onto the updated base branch.

```
git checkout chore/renovateBaseBranch
git pull origin chore/renovateBaseBranch
```

For each conflicting PR:

1. `git checkout <branch-name>`
2. `git rebase chore/renovateBaseBranch`
3. If conflicts occur and you can resolve them cleanly: resolve, `git add .`, `git rebase --continue`
4. If conflicts are too complex to resolve: `git rebase --abort`, add to "Failing" list
5. `git push --force-with-lease`
6. `git checkout chore/renovateBaseBranch`

Add successfully rebased PRs to "Rebased" list.

## 8. Handle Dependabot PRs

Dependabot PRs target `main` and cannot run CI properly (no access to repository secrets). Cherry-pick their changes onto the renovate base branch instead.

```
gh pr list --state open --json number,title,headRefName --limit 100
```

Filter for PRs with `headRefName` starting with `dependabot/`. For each:

1. Identify the commits: `gh pr view <number> --json commits -q '.commits[].oid'`
2. Ensure you're on the base branch: `git checkout chore/renovateBaseBranch`
3. Cherry-pick all commits in order: `git cherry-pick <sha1> [<sha2> ...]`
4. If cherry-pick succeeds: `git push`
5. Close the Dependabot PR with a comment: `gh pr close <number> --comment "Cherry-picked onto chore/renovateBaseBranch. CI will validate as part of the batch dependency update."`
6. If cherry-pick fails (conflicts): `git cherry-pick --abort`, add to "Failing" list with note "Dependabot cherry-pick conflict"

Do NOT use `--delete-branch` when closing Dependabot PRs — GitHub manages those branches.

## 9. Manual steps reminder

Print a reminder: after all PRs are processed, the human must merge `chore/renovateBaseBranch` into `main` via the parent PR.

## 10. Report

The report is a **status snapshot** of the current dependency update cycle on `chore/renovateBaseBranch`. Each skill run rebuilds the report to reflect the current cycle's state.

Find the parent PR: `gh pr list --head chore/renovateBaseBranch --state open --json number -q '.[0].number'`

Get the parent PR creation date (cycle boundary): `gh pr view <number> --json createdAt -q '.createdAt'`

**Gather the full branch state:**

1. All merged PRs (current cycle only): `gh pr list --base chore/renovateBaseBranch --state merged --json number,title,mergedAt` — filter to PRs where `mergedAt` is after the parent PR's `createdAt`. PRs merged before the parent PR was created belong to a previous cycle and must be excluded.
2. All closed (not merged) PRs (current cycle only): `gh pr list --base chore/renovateBaseBranch --state closed --json number,title,mergedAt,closedAt` — filter to those where `mergedAt` is empty (abandoned/closed without merge) AND `closedAt` is after the parent PR's `createdAt`.
3. All open PRs with their CI status: `gh pr list --base chore/renovateBaseBranch --state open --json number,title,headRefName,statusCheckRollup,mergeable`
4. Categorize open PRs using the same logic as step 2 (failing, in-progress, breaking, conflicting, etc.)
5. Supplement with runtime-tracked data from this run: retried PRs, rebased PRs, template issues, Dependabot cherry-picks.

> The report covers only the current dependency update cycle. PRs merged or closed before the parent PR was created belong to a previous cycle and are excluded.

**Write the report:**

1. `gh pr view <number> --json body -q '.body' > /tmp/pr-body.md`
2. Strip existing report: `sed -i '' '/<!-- SKILL_REPORT_START -->/,/<!-- SKILL_REPORT_END -->/d' /tmp/pr-body.md`
3. Append new report using `cat >> /tmp/pr-body.md << 'REPORT'` with the template below.
4. `gh pr edit <number> --body-file /tmp/pr-body.md`

If the parent PR body is empty, write the report as the entire body. Omit any section that has no items.

**Report template:**

```markdown
<!-- SKILL_REPORT_START -->

## 🤖 Branch status — `chore/renovateBaseBranch`

### ✅ Merged

- #<number> — <title>

### 🍒 Dependabot (cherry-picked)

- #<number> — <title>

### 🗑️ Abandoned (closed)

- #<number> — <title>

### ❌ Failing CI (needs human attention)

- #<number> — <title> — Failed: <check names>

### 🔁 Retried (flaky CI, awaiting re-run results)

- #<number> — <title> — Retried: <check names>

### ⏳ CI In Progress (awaiting completion)

- #<number> — <title>

### ⚠️ Breaking changes (needs human review)

- #<number> — <title> — <what was found>

### 🔧 Template fix needed (needs human review)

- #<number> — <title> — Generated: `<path>` → Template: `<path>`

### 🔄 Rebased (awaiting CI, next run will process)

- #<number> — <title>

### 📋 Manual steps remaining

- [ ] Merge `chore/renovateBaseBranch` into `main` via the parent PR
<!-- SKILL_REPORT_END -->
```

Print the parent PR URL to stdout when done.

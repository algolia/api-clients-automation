---
name: merge-renovate-prs
description: Re-trigger failed CI on Renovate dependency PRs, watch the runs to completion, auto-merge the green ones, and report the failures. Use after a Renovate batch when many renovate/* PRs failed CI from rate limiting or flaky external dependants, or when the user asks to retry, unblock, or merge renovate PRs.
disable-model-invocation: true
allowed-tools: Bash(gh *), Bash(git *), Read, Write
---

# Merge Renovate PRs

Renovate opens many `renovate/*` PRs at once. Their CIs run simultaneously and frequently fail from rate limiting by external dependants, not real regressions. This skill retries the failed CI jobs on a batch of Renovate PRs, waits for them to finish, **squash-merges** the green ones, and reports the rest.

Repository: `algolia/api-clients-automation`. The CI workflow is `Checks` (`.github/workflows/check.yml`); the gate job is **`check_green`**. A separate workflow validates the PR title (`pr-title.yml`).

## Defaults (decided — do not re-ask)

- **Selection**: the **oldest 5** open PRs whose head branch starts with `renovate/` (by `createdAt`, ascending).
- **Rerun scope**: only **failed** jobs (`gh run rerun --failed`).
- **Merge method**: **squash** (`gh pr merge --squash`).

If the user passed explicit PR numbers, act on those instead of selecting.

## Workflow

Copy this checklist and track progress:

```
- [ ] 1. Preflight (gh auth, repo)
- [ ] 2. Select the 5 PRs
- [ ] 3. Re-trigger failed jobs on all of them
- [ ] 4. Watch every PR's CI to completion
- [ ] 5. Squash-merge the green PRs
- [ ] 6. Report the failures
```

### 1. Preflight

Confirm the GitHub CLI is authenticated and resolve the repo:

```bash
gh auth status
gh repo view --json nameWithOwner -q .nameWithOwner
```

If `gh` is not authenticated, stop and tell the user to run `gh auth login`.

### 2. Select the 5 PRs

```bash
gh pr list --state open --limit 200 \
  --json number,title,headRefName,createdAt,url \
  --jq '[.[] | select(.headRefName | startswith("renovate/"))] | sort_by(.createdAt) | .[:5]'
```

If fewer than 5 match, act on all that match. If none match, stop and report "No open renovate/* PRs found."

Print the selected PRs (number, title, branch) before acting.

### 3. Re-trigger failed jobs

Do this for **all** selected PRs first (so their reruns proceed in parallel), then move to watching.

For each PR, find the latest `Checks` run on its head branch and rerun only the failed jobs:

```bash
# RUN_ID = latest check.yml run for the PR's head branch
RUN_ID=$(gh run list --branch "<headRefName>" --workflow check.yml \
  --limit 1 --json databaseId -q '.[0].databaseId')

gh run rerun "$RUN_ID" --failed
```

Notes:
- `--failed` reruns only the failed jobs from that run, minimizing CI load (the whole point — avoid re-hammering rate-limited dependants).
- If the latest run has **no failed jobs** (already passing or still running), skip the rerun for that PR and note it.
- If `gh run rerun` reports the run is too old to rerun, push an empty commit to retrigger only as a last resort, and note it: `gh pr comment` is **not** a retrigger. Prefer asking before pushing commits to a Renovate branch.
- The PR-title check (`pr-title.yml`) is a separate workflow; it rarely fails for Renovate. If it failed, surface it in the report rather than rerunning blindly.

### 4. Watch CI to completion

Watch each selected PR until all its checks finish. Run the watches and let them complete (they can run concurrently across PRs):

```bash
gh pr checks <number> --watch --fail-fast=false
```

`--watch` blocks until every check reaches a terminal state. Do **not** poll manually in a tight loop.

### 5. Determine green and merge

After watching, read the final check states per PR:

```bash
gh pr checks <number> --json name,state,bucket
```

Classify the PR:
- **GREEN**: every check's `bucket` is `pass` or `skipping`, and `check_green` is `pass`.
- **FAILED**: any check's `bucket` is `fail` (`FAILURE`, `CANCELLED`, `TIMED_OUT`, `ERROR`).
- **PENDING**: anything still `pending` after the watch (treat as FAILED for the report, noting it timed out).

Expected skips (not failures): `push_and_release` (always skips on PRs), `notification` (forks), language `client *` jobs for unaffected languages.

For each GREEN PR, squash-merge:

```bash
gh pr merge <number> --squash --delete-branch
```

If the merge is blocked (e.g. required approvals, out-of-date branch), do **not** force it. Record the block reason in the report and move on. Only use `--admin` or update-branch if the user explicitly asked to bypass protections.

### 6. Report

Always end with a single table summarizing every PR acted on.

```markdown
## Renovate PR batch — <N> PRs

| PR | Branch | Action | Result |
|----|--------|--------|--------|
| [#1234](url) | renovate/foo | reran 3 failed jobs | ✅ merged (squash) |
| [#1235](url) | renovate/bar | reran 1 failed job | ❌ failed |
| [#1236](url) | renovate/baz | already green | ✅ merged (squash) |
| [#1237](url) | renovate/qux | reran 2 failed jobs | ⏳ still pending (watch timed out) |
| [#1238](url) | renovate/quux | reran 1 failed job | 🚫 merge blocked (needs approval) |

### Failures

For each ❌/⏳ PR, list the failing check(s) and the reason:

- **#1235** `client go@1.24` — <1–3 line summary from the failed log>
- **#1237** `client swift@6 linux` — still running at watch timeout
```

For each failed check, pull a short reason from the failed logs:

```bash
# RUN_ID from the failed check's URL (.../runs/<RUN_ID>/...)
gh run view <RUN_ID> --log-failed
```

Summarize each failure in 1–3 lines. If a failure looks like rate limiting / a transient external dependant (timeouts, 429s, network resets) rather than a code regression, say so and suggest re-running the skill once limits reset.

## Notes

- Renovate PRs in this repo target the `chore/renovateBaseBranch` base, not `main` — `gh pr merge` targets each PR's own base automatically, so no special handling is needed.
- Keep CI load low: rerun only failed jobs, never the whole workflow, and never push commits to retrigger unless the user approves.
- Never edit generated client code to "fix" a Renovate failure — these PRs only bump dependencies; a real failure should be surfaced, not patched.

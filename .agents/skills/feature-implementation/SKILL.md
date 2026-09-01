---
name: feature-implementation
description: Implement a feature, bug fix, or language-parity fix: load the ticket, write a plan, implement, and open a draft PR. Use when asked to implement a Jira ticket, ship a feature, fix a bug, or port a change across API client languages.
---

You are the **orchestrator** for this repo's implementation procedure. You load the ticket, write an executable plan, drive it to done, and open a **draft** PR. You stop there: CI, review, and merge belong to later operators.

This skill is the local cut of [AI Procedures](https://algolia.atlassian.net/wiki/spaces/APIC/pages/7487881331) and [Feature Implementation](https://algolia.atlassian.net/wiki/spaces/APIC/pages/7487488118) — planning, creating, implementing, draft PR. The next operator should be able to read the plan ledger and know exactly what is done.

## Progress

Print this checklist and keep it current. Use emoji markers, never markdown checkboxes.

- ⏳ Resolve intent
- ⏳ Risk probe
- ⏳ Plan
- ⏳ Implement
- ⏳ Draft PR

Replace `⏳` with `✅` as each step completes. If you resume a plan, mark already-done steps `✅` immediately.

## 1. Resolve intent

Parse the user's message for a Jira key (`APIC-123`), a GitHub issue, a Confluence page, or a self-contained request.

- Jira: `getJiraIssue` with `cloudId` `algolia.atlassian.net` (or `getAccessibleAtlassianResources` first if that fails). Read summary, description, issue type, comments, and linked pages.
- GitHub: `gh issue view`.
- Confluence: `getConfluencePage` for any linked spec.

Classify **kind**: `feature` | `bug` | `parity`.

**Parity** is a bug or feature that already exists in one language (or in the spec) and must match in the others. Default language set is every client in `config/clients.config.json` unless the ticket names a subset.

**Resume:** if `.agents/plans/<slug>.md` already exists for this ticket, skip to the first incomplete step in that file. Do not redo a finished risk probe or rewrite an executable plan.

**Done when:** the ticket (or request) is loaded, kind is labeled, languages in scope are listed, and acceptance criteria are restated in one short paragraph. If the criteria cannot be restated without guessing, go to grilling in step 3 — do not invent them.

## 2. Risk probe

Read-only. Load [references/risk-probe.md](references/risk-probe.md). Dispatch **code scout** subagents in parallel for "where is X / how does Y work" questions; look facts up yourself.

Output a probe the planner can consume:

- Intent class (`feature` / `bug` / `parity`)
- Hidden ambiguity, scope traps, and likely file paths
- A `BREAKING:` heading **always**, even when the change is intentional or the answer is `None`

**Done when:** every ambiguity is labeled `ask` / `assume` / `defer`, the `BREAKING:` heading is present, and the planner has enough directives to write tasks with file paths and `verify:` commands.

## 3. Plan

Never implement in this step. Load [references/plan.md](references/plan.md). Survey the repo (specs, templates, generators, CTS, `config/generation.config.mjs`) and write one plan to `.agents/plans/<slug>.md`.

If you are on `main` (or another shared branch), create a feature branch from it before writing the plan — `feat/<slug>` or `fix/<slug>` from the ticket kind — so the plan and the code land on the same branch.

Each task has an ID, concrete file paths, a `verify:` command that actually runs, and `depends:` so independent tasks can run in parallel.

**Grill** when the plan is not yet executable: missing acceptance criteria, languages in scope unspecified for a non-spec change, breaking-vs-compatible unlabeled, or more than one valid design. Ask the whole frontier in one round (numbered questions, each with a recommended answer). Look up facts; only decisions go to the user. Wait for answers before writing the plan. If the ticket is already executable, write the plan and continue — do not stall for a second approval.

**Done when:** `.agents/plans/<slug>.md` exists, every task has `files`, `verify:`, and `depends:`, and `BREAKING:` is copied from the probe.

## 4. Implement

Load [references/repo-rules.md](references/repo-rules.md) before touching code. You are the **plan executor**: dispatch work in dependency waves, verify each result with that task's `verify:` command, and update the plan ledger. Stop only for a blocker the plan did not anticipate.

**Waves:** all tasks whose `depends:` are `done` run together. A wave is complete when every task in it has a passing `verify:` and a ledger line.

**Implementer** (per task, yourself or a subagent):

- One well-scoped coding task
- Read the surrounding code first
- Change the source of truth (spec, template, generator, or hand-written file in `generation.config.mjs`)
- Run the task's `verify:` command
- Report what changed and the verify outcome
- Leave the plan file to the executor
- Open a PR only when the executor reaches step 5

Small single-language, single-area work may be done in-process after the plan exists. Multi-language, spec+template+CTS, or independent tasks go to parallel implementers.

If the same task fails verification three times, stop and reason (architecture, root cause, one recommended path, confidence tagged). Do not loop a fourth time on the same approach.

**Done when:** every task is `done` or explicitly `deferred` with a reason in the ledger, and the stated `verify:` commands have passed.

## 5. Draft PR

Open a **draft** pull request. That is the hand-off.

1. `yarn cli format` on the languages and folders you touched, then commit with `type(scope): description` (`feat` / `fix` / `refactor` / `docs` / `chore`; scopes from the PR-title regex in `.github/workflows/pr-title.yml`).
2. Push the branch.
3. Fill `.github/PULL_REQUEST_TEMPLATE.md`: Jira ticket, change list, how it was tested. Link the plan path.
4. Title must match `pr-title.yml` (example: `fix(javascript): keep millisecond precision on timeouts`).
5. Create as **draft**:
   - Local: `gh pr create --draft --title "..." --body "..."`
   - Cloud Agent: `ManagePullRequest` with `action: create_pr` and `draft: true`

If a PR already exists on the branch, update it and keep it draft.

**Done when:** the draft PR URL is in your reply, the plan status is `done` (or `blocked` with the leftover named), and a later operator can start from that PR without re-planning.

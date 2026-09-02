---
name: api-clients-review
description: Review an API clients pull request against a six-rule checklist (test correctness, dead or obsolete surface, template output, config mutation, documentation quality, cross-language consistency) plus a general review. Use when asked to review a PR, run api-clients-review, or check API client changes before merge.
compatibility: Requires git and Python 3.9+. Needs the gh CLI (or origin) to load PR context.
---

# API clients PR review

You are reviewing a pull request in two passes: the custom checklist, then a general review pass. Within the checklist pass, stay strictly within the six rules. Do not propose stylistic or speculative changes outside that list, do not rewrite code that already meets the standard, and do not pad the report with generic praise.

Read the full PR diff first, then read enough surrounding files to judge each finding in context before flagging anything.

## When to use

Use this skill when the user asks to review an API clients PR, mentions api-clients-review, or wants a checklist review of client, template, CTS, or snippets changes.

## 0. Resolve the review target

Parse the **user's message** and the current git state. Do not assume slash-command argument injection or any other client-specific parameter channel.

- If the message contains a PR number (`1234`, `#1234`) or a PR URL, that is the target. Anything after it is additional instructions.
- If it does not, review the current branch's open PR.
- If the current branch has no PR, list open PRs and ask which one to review.

When the target is an explicit PR number or URL, the review runs in **remote mode**: the PR's diff is the only review scope — local working-tree changes are out of scope. When you need surrounding code, Read the files in this checkout if it matches the PR's branch; otherwise fetch and read `origin/<head-ref>:<path>`.

When the target is the current branch's PR, the review runs in **local mode** and also covers unpushed changes.

## Progress checklist

Track progress by printing the checklist in your response as you work. Use the emoji markers below — **never** use `- [ ]` / `- [x]` markdown checkboxes.

- ⏳ Read overlay review instructions (see below) — skip if none exist
- ⏳ Resolve review target (user message or current branch)
- ⏳ Collect PR context
- ⏳ Apply review rules (test correctness, dead/obsolete surface, template output, config mutation, documentation quality, cross-language consistency)
- ⏳ General review pass (correctness, conventions, performance, test coverage, security)
- ⏳ Save review

Replace the `⏳` with `✅` as each item completes.

## 1. Identify what changed

### Overlay instructions

If any of these files exist, read the first one that exists and apply it on top of this checklist. Absence is normal.

1. `.agents/review-instructions.md`
2. `.github/review-instructions.md`
3. `.github/claude-review-instructions.md`

### Collect context

From the repository root, run:

```sh
python3 .agents/skills/api-clients-review/scripts/collect_pr_context.py
python3 .agents/skills/api-clients-review/scripts/collect_pr_context.py 1234
python3 .agents/skills/api-clients-review/scripts/collect_pr_context.py https://github.com/org/repo/pull/1234
```

If the script is invoked from this skill folder, `scripts/collect_pr_context.py` is the same entry point.

Read the script output in full. It already:

- Resolves local vs remote mode
- Fetches PR metadata, the pushed diff, and existing review comments
- In local mode, merges `git diff HEAD` and `git diff --cached` (local wins when a file appears in both)
- Skips generated paths — see [generated-files.md](references/generated-files.md)

Do **not** review or flag findings in generated files. Do **not** flag missing regeneration — if a template changed but its generated output was not updated, that is expected and intentional.

Sources under `clients/<lang>/` that are materialized from `templates/` but committed by hand in the PR are in scope — review them as production code; only skip files matching the generated-file rules.

Categorize the remaining changed files: tests (CTS vs unit), production code, public API surface, documentation. Note the languages touched.

If there are no non-generated changes, stop and report "No changes to review."

Use existing review comments as context: still flag every issue caught by the checklist rules, but annotate findings that reviewers have already raised with *(raised by @reviewer — unresolved)* so the author knows they are independently confirmed. Only suppress a finding if it was raised AND already fixed in a subsequent commit.

## 2. Apply the checklist

Load [references/checklist.md](references/checklist.md) and apply all six rules to the non-generated diff.

## 3. General review pass

After the checklist, analyze the changes as a whole:

- An overview of what the PR does
- Code correctness
- Following project conventions
- Performance implications
- Test coverage
- Security considerations

Findings from this pass that are concrete and actionable go into the report's Blocking or Suggestions sections, tagged `(general)` to distinguish them from checklist findings. The overview goes into the report's Overview section. Do not let this pass duplicate checklist findings or drift into stylistic rewrites of code that already meets the standard.

## 4. Produce and save the report

The report must match [references/report.md](references/report.md) **verbatim** — same headings, same bullet format, same fallback lines. Do not add sections, prefaces, or summaries that are not in the template. Use `file:line` references for every finding.

Create `.agents/reviews/` if it does not exist. Save the report to both `/tmp/api-clients-review-{pr-number}.md` and `.agents/reviews/api-clients-review-{pr-number}.md` — do **not** post it as a PR comment. Print the full report text in your response so the user can read it directly.

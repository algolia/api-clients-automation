# Plan file

Write exactly one file: `.agents/plans/<slug>.md`. Slug is `apic-123-short-name` or, with no ticket, a short kebab name. Create `.agents/plans/` if it is missing.

Commit the plan with the implementation so the next operator can resume from the ledger.

## Template

```markdown
# <title>

- **Ticket:** APIC-123 (or none)
- **Kind:** feature | bug | parity
- **Languages:** javascript, python, … (or `all`)
- **Status:** planning | in-progress | done | blocked

## Goal

<one paragraph restating acceptance criteria>

## BREAKING:

None

## Directives

- <from the risk probe>

## Tasks

### T1 — <title>
- **files:** `specs/search/paths/….yml`, `templates/javascript/…`
- **depends:** none
- **verify:** `yarn cli build specs search`
- **status:** pending
- **notes:**

### T2 — <title>
- **files:** `tests/CTS/client/search/<op>.json`
- **depends:** T1
- **verify:** `yarn cli cts generate javascript && yarn cli cts run javascript`
- **status:** pending
- **notes:**

## Ledger

- <ISO date>: plan written
```

## Rules for tasks

- IDs are stable (`T1`, `T2`, …). Do not renumber in-flight.
- `files:` are repo paths the implementer will actually edit. Generated output (`clients/**` except hand-written paths, `specs/bundled/`, `tests/output/**/generated/**`) is not a task — it is a `verify:` side-effect of generating.
- `verify:` is a command that can fail. "Looks good" is not a verify.
- `depends:` is a list of task IDs, or `none`. Independent tasks in the same wave run in parallel.
- Parity work is usually: source-of-truth change → CTS covering the behavior → remaining languages via templates/generators, not by hand-editing each generated client.

## Ledger

The executor appends; it does not rewrite history.

```markdown
- 2026-09-01: T1 started
- 2026-09-01: T1 done — `yarn cli build specs search` passed
- 2026-09-01: T3 blocked — generator cache stale, needs restart
```

Status on the task and on the plan header stay in sync: `pending` → `in-progress` → `done` | `blocked` | `deferred`.

# api-clients-review

A PR review skill for coding agents. It reviews a pull request (the current branch's PR or a given PR number) in two passes: a custom six-rule checklist (test correctness, dead or obsolete surface, template output, config mutation, documentation quality, cross-language consistency) followed by a general review pass (correctness, conventions, performance, test coverage, security), then saves a structured report.

## Install

```sh
npx skills add algolia/api-clients-review
```

## Usage

```
/api-clients-review            # review the current branch's PR
/api-clients-review 1234       # review PR #1234
```

The full checklist lives in [SKILL.md](SKILL.md).

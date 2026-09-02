# Report template

The first line of the report MUST be the HTML marker exactly as shown — tooling that consumes the file uses it to find and replace its output.

```
<!-- type: api-clients-review -->
## PR Review

### Overview
<two to four sentences on what the PR does>

### Blocking
- `<file>:<line>` — <one-line description>. <why this fails the rule>.
…

### Suggestions
- `<file>:<line>` — <one-line description>.
…

### Looks good
<one or two sentences on what's solid>
```

If a single section has no findings, its body is exactly one line — `No blocking findings.` for Blocking, `No suggestions.` for Suggestions — do not omit the section.

If no findings under any rule or the general pass, the body is exactly:

```
<!-- type: api-clients-review -->
## PR Review

### Overview
<two to four sentences on what the PR does>

No issues found under the review checklist.
```

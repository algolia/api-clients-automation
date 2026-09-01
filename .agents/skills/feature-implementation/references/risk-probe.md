# Risk probe

Read-only. Produce directives for the planner, not code.

## Hunt

- **Ambiguity:** acceptance criteria that can be read two ways; unnamed languages; "works like X" with no X pointed at.
- **Scope traps:** a spec change that silently regenerates 11 clients; a helper that exists in some languages only; CTS JSON that must stay language-agnostic.
- **Source of truth:** spec (`specs/<api>/`) vs Mustache (`templates/<lang>/`) vs Java generator vs hand-written client file (negated path in `config/generation.config.mjs`). Editing a generated file is a scope trap.
- **Parity gaps:** the same method, option, error string, or retry path present in two or more languages and missing in others.
- **Breaks:** removed or renamed public surface, reordered parameters, non-nullable → nullable, changed defaults, dropped named parameters.

## Output shape

```markdown
## Intent
kind: feature | bug | parity
languages: …

## Directives
- …

## Ambiguity
- (ask) …
- (assume) … — because …
- (defer) …

## BREAKING:
None
```

or

```markdown
## BREAKING:
Intended. <what callers must change and why>
```

The `BREAKING:` heading is required even when the break is the point of the ticket.

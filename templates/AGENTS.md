# TEMPLATES KNOWLEDGE BASE

## OVERVIEW

Mustache templates for code generation. One directory per language + shared templates for tests/snippets/guides.

## STRUCTURE

```
templates/
├── {language}/           # Language-specific templates (structure varies per language)
│   ├── *.mustache        # Template files loaded by Java generators
│   ├── tests/            # CTS test templates (if applicable)
│   ├── snippets/         # Code example templates
│   └── guides/           # Full workflow guide templates
└── ... (java, javascript, python, go, ruby, php, kotlin, scala, swift, dart, csharp)
```

Each language has different templates based on its generator needs. Templates are loaded and configured in `generators/src/main/java/com/algolia/codegen/Algolia{Lang}Generator.java`.

## WHERE TO LOOK

| Task                                | Location                                     | Notes                                            |
| ----------------------------------- | -------------------------------------------- | ------------------------------------------------ |
| Find language templates             | `{lang}/`                                    | Browse directory - structure varies per language |
| Understand which templates are used | `generators/.../Algolia{Lang}Generator.java` | Check `supportingFiles()` and template config    |
| Change test output                  | `{lang}/tests/*.mustache`                    | CTS test templates                               |
| Add code snippets                   | `{lang}/snippets/*.mustache`                 | Documentation examples                           |
| Reusable fragments                  | `{lang}/**/partial_*.mustache`               | Included via `{{>partial_name}}`                 |

## CONVENTIONS

### Mustache Syntax

See [Mustache documentation](https://mustache.github.io/mustache.5.html) for full syntax reference.

```mustache
{{#operations}}              {{! Loop over operations }}
  {{#operation}}
    {{operationId}}          {{! Variable }}
    {{#hasParams}}...{{/hasParams}}  {{! Conditional }}
    {{>partial_name}}        {{! Include partial }}
  {{/operation}}
{{/operations}}
```

### Available Variables

From OpenAPI Generator + custom additions in `Algolia{Lang}Generator.java`:

- `operations`, `operation`, `operationId`
- `models`, `model`, `classname`
- `params`, `queryParams`, `pathParams`, `bodyParam`
- `hasOptionalParams`, `hasRequiredParams`
- `imports`, `packageName`

### Template Naming

- `api.mustache` - Main API client
- `model.mustache` - Model classes
- `partial_*.mustache` - Reusable fragments (included with `{{>partial_name}}`)
- `api_doc.mustache` - API documentation (if generated)

## ANTI-PATTERNS

- **NEVER** add complex logic in templates - put in Java generator
- **DO NOT** use language-specific syntax in shared templates
- **NEVER** hardcode API URLs or credentials
- **DO NOT** duplicate code - use partials

## NOTES

- Templates are cached - restart generator after changes
- Test template changes: `yarn cli generate {lang} --verbose`
- Mustache has no `else` - use `{{^condition}}` for negation

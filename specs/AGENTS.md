# SPECS KNOWLEDGE BASE

## OVERVIEW

OpenAPI 3.0.2 specifications for Algolia APIs. Modular structure bundled by Redocly for generation.

## STRUCTURE

```
specs/
├── bundled/              # Pre-built specs (output of yarn cli build specs)
│   ├── {api}.yml         # Bundled YAML specs
│   └── {api}.json        # JSON for documentation
├── common/               # Shared schemas and parameters
│   ├── schemas.yml       # Reusable model definitions
│   └── parameters.yml    # Reusable parameter definitions
├── search/               # Search API
│   ├── spec.yml          # Main spec file
│   ├── paths/            # Path definitions
│   └── common/           # Search-specific shared schemas
├── ingestion/            # Ingestion API
├── insights/             # Insights API
├── analytics/            # Analytics API
├── recommend/            # Recommend API
├── personalization/      # Personalization API
├── abtesting/            # A/B Testing API
├── monitoring/           # Monitoring API
├── query-suggestions/    # Query Suggestions API
└── composition/          # Composition API
```

## WHERE TO LOOK

| Task                 | Location                                           | Notes                        |
| -------------------- | -------------------------------------------------- | ---------------------------- |
| Add new endpoint     | `{api}/paths/{resource}.yml`                       | Create new path file         |
| Add new model        | `{api}/common/schemas.yml` or `common/schemas.yml` | Shared if used across APIs   |
| Add query parameter  | `{api}/common/parameters.yml`                      | Or inline in path            |
| Modify response      | `{api}/paths/{resource}.yml`                       | Under `responses:`           |
| Check bundled output | `bundled/{api}.yml`                                | After `yarn cli build specs` |

## CONVENTIONS

### Path File Structure

```yaml
# paths/search.yml
post:
  operationId: search
  summary: Search for records
  tags:
    - search
  parameters:
    - $ref: '../common/parameters.yml#/indexName'
  requestBody:
    required: true
    content:
      application/json:
        schema:
          $ref: '../common/schemas.yml#/SearchParams'
  responses:
    '200':
      description: OK
      content:
        application/json:
          schema:
            $ref: '../common/schemas.yml#/SearchResponse'
```

### Schema References

- Local: `$ref: './schemas.yml#/MySchema'`
- Parent common: `$ref: '../common/schemas.yml#/MySchema'`
- Root common: `$ref: '../../common/schemas.yml#/MySchema'`

### Naming

- **operationId**: camelCase (`searchSingleIndex`, `getTask`)
- **schemas**: PascalCase (`SearchParams`, `HitResponse`)
- **parameters**: camelCase (`indexName`, `objectID`)

## ANTI-PATTERNS

- **NEVER** edit `bundled/` directly - it's auto-generated
- **NEVER** duplicate schemas - use `$ref`
- **DO NOT** use `allOf` excessively - causes generation issues
- **DO NOT** omit `operationId` - required for client method names

## COMMANDS

```bash
yarn cli build specs                # Bundle all specs
yarn cli build specs search         # Bundle single spec
yarn cli build specs --skip-cache   # Force rebuild
yarn cli build specs --docs         # Include doc snippets
yarn specs:lint specs/search/       # Lint spec
yarn specs:fix specs/search/        # Auto-fix lint issues
```

## VALIDATION

Specs validated by:

1. **Redocly** (`redocly.yaml`) - Custom rules for Algolia conventions
2. **Custom ESLint plugin** (`eslint/`) - Additional spec validation
3. **OpenAPI Generator** - During generation

## NOTES

- Breaking changes: Update `major-breaking-changes-rename.json` for migration
- Docs build includes snippets: `yarn cli build specs --docs`
- JSON output for API explorer: `yarn cli build specs --json`

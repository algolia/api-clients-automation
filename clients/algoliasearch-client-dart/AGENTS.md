# DART CLIENT - AI AGENT INSTRUCTIONS

## ⚠️ CRITICAL: CHECK YOUR REPOSITORY FIRST

Before making ANY changes, verify you're in the correct repository:

```bash
git remote -v
```

- ✅ **CORRECT**: `origin .../algolia/api-clients-automation.git` → You may proceed
- ❌ **WRONG**: `origin .../algolia/algoliasearch-client-dart.git` → STOP! This is the PUBLIC repository

**If you're in `algoliasearch-client-dart`**: Do NOT make changes here. All changes must go through `api-clients-automation`. PRs and commits made directly to the public repo will be discarded on next release.

## ⚠️ BEFORE ANY EDIT: Check If File Is Generated

Before editing ANY file, verify it's hand-written by checking `config/generation.config.mjs`:

```javascript
// In generation.config.mjs - Dart uses inverse pattern (mostly hand-written)
'!clients/algoliasearch-client-dart/**',                        // Hand-written by default
'clients/algoliasearch-client-dart/packages/*/pubspec.yaml',    // Generated
'clients/algoliasearch-client-dart/packages/*/lib/src/api/**',  // Generated
'clients/algoliasearch-client-dart/packages/*/lib/src/model/**', // Generated
```

**Hand-written (safe to edit):**

- `packages/client_core/**` - Core transport, configuration
- `packages/*/lib/src/extension.dart` - Package extensions
- `packages/algoliasearch/lib/algoliasearch.dart` - Main export

**Generated (DO NOT EDIT):**

- `packages/*/lib/src/api/**` - API client classes
- `packages/*/lib/src/model/**` - API models
- `packages/*/pubspec.yaml` - Package configs
- `packages/*/lib/*.dart` (root lib files)
- `packages/client_core/lib/src/version.dart`

## Language Conventions

### Naming

- **Files**: `snake_case.dart`
- **Classes/Enums/Typedefs**: `PascalCase`
- **Functions/Variables**: `camelCase`
- **Constants**: `camelCase` or `lowerCamelCase`
- **Private**: `_leadingUnderscore`

### Formatting

- `dart format` (standard Dart formatter)
- Run: `yarn cli format dart clients/algoliasearch-client-dart`

### Dart Idioms

- Use `final` for immutable variables
- Prefer named parameters for clarity
- Use `async/await` for futures
- Null safety with `?` and `!`
- Extension methods for utilities

### Dependencies

- **HTTP**: `http` package or `dio`
- **JSON**: `json_serializable` / `built_value`
- **Build**: Pub with Melos (monorepo)

## Client Patterns

### Monorepo Structure

```
packages/
├── client_core/           # Core transport (hand-written)
├── client_search/         # Search API client
├── client_insights/       # Insights API client
├── client_recommend/      # Recommend API client
└── algoliasearch/         # Umbrella package
```

### Transport (client_core)

```dart
// Core transport in packages/client_core/
class AlgoliaTransport {
  Future<T> request<T>(
    String method,
    String path,
    Map<String, dynamic>? body,
    RequestOptions? options,
  );
}
```

### Async/Await

```dart
// All API methods are async
Future<SearchResponse> search(SearchParams params);

// Usage
final response = await client.search(params);

// Or with then
client.search(params).then((response) {
  // handle response
});
```

## Common Gotchas

### Null Safety

```dart
// Dart has sound null safety
String? nullable;      // Can be null
String nonNull = '';   // Cannot be null

// Use ?? for defaults
final value = nullable ?? 'default';

// Use ?. for safe access
final length = nullable?.length;

// Use ! only when certain (avoid if possible)
final sure = nullable!;  // Throws if null
```

### Async Context

```dart
// Can only await in async functions
Future<void> myFunction() async {
  final response = await client.search(params);
}

// Top-level requires main
void main() async {
  final response = await client.search(params);
}
```

### JSON Serialization

```dart
// Models use json_serializable
@JsonSerializable()
class SearchParams {
  final String query;

  @JsonKey(name: 'hitsPerPage')
  final int? hitsPerPage;

  factory SearchParams.fromJson(Map<String, dynamic> json) =>
      _$SearchParamsFromJson(json);
}
```

### Package Imports

```dart
// Import from package, not relative paths
import 'package:algoliasearch/algoliasearch.dart';

// For internal imports in same package
import 'src/model/search_params.dart';
```

### Melos Commands

```dart
// Melos manages the monorepo
// Run commands from root with melos
```

## Build & Test Commands

```bash
# From repo root (api-clients-automation)
yarn cli build clients dart                    # Build Dart client
yarn cli cts generate dart                     # Generate CTS tests
yarn cli cts run dart                          # Run CTS tests
yarn cli format dart clients/algoliasearch-client-dart

# From client directory (requires Dart SDK + Melos)
cd clients/algoliasearch-client-dart
melos bootstrap                                # Install dependencies
melos run test                                 # Run tests across packages
dart format .                                  # Format code
dart analyze                                   # Analyze code
```

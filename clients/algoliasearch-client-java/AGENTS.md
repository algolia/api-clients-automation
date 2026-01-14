# JAVA CLIENT - AI AGENT INSTRUCTIONS

## ⚠️ CRITICAL: CHECK YOUR REPOSITORY FIRST

Before making ANY changes, verify you're in the correct repository:

```bash
git remote -v
```

- ✅ **CORRECT**: `origin .../algolia/api-clients-automation.git` → You may proceed
- ❌ **WRONG**: `origin .../algolia/algoliasearch-client-java.git` → STOP! This is the PUBLIC repository

**If you're in `algoliasearch-client-java`**: Do NOT make changes here. All changes must go through `api-clients-automation`. PRs and commits made directly to the public repo will be discarded on next release.

## ⚠️ BEFORE ANY EDIT: Check If File Is Generated

Before editing ANY file, verify it's hand-written by checking `config/generation.config.mjs`:

```javascript
// In generation.config.mjs - patterns WITHOUT '!' are GENERATED (do not edit)
'clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/api/**',   // Generated
'clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/model/**', // Generated
// Everything else is hand-written by default (note the '!' pattern for Java)
```

**Hand-written (safe to edit):**

- `src/main/java/com/algolia/config/**` - Configuration classes
- `src/main/java/com/algolia/exceptions/**` - Exception hierarchy
- `src/main/java/com/algolia/internal/**` - HTTP requester, serialization
- `src/main/java/com/algolia/utils/**` - Utility classes
- `ApiClient.java` - Core client implementation

**Generated (DO NOT EDIT):**

- `src/main/java/com/algolia/api/**` - API client interfaces
- `src/main/java/com/algolia/model/**` - API models
- `BuildConfig.java` - Version info

## Language Conventions

### Naming

- **Files**: `PascalCase.java` matching class name
- **Variables/Methods**: `camelCase`
- **Classes/Interfaces**: `PascalCase`
- **Constants**: `UPPER_SNAKE_CASE`
- **Packages**: `lowercase`

### Formatting

- Google Java Format via Prettier plugin
- 140 char line width for Java
- Run: `yarn cli format java clients/algoliasearch-client-java`

### Java Patterns

- Java 8+ compatibility required
- Use `Optional<T>` for nullable returns
- Prefer immutable objects where possible
- Use builder pattern for complex objects

### Dependencies

- **HTTP**: OkHttp 4.x
- **JSON**: Jackson
- **Build**: Gradle
- **Annotations**: `javax.annotation.Nonnull`, `@Nullable`

## Client Patterns

### HTTP Requester Architecture

```java
// Core HTTP in internal/HttpRequester.java
public final class HttpRequester implements Requester {

  private final OkHttpClient httpClient;
  private final JsonSerializer serializer;

  // Uses OkHttp interceptors for:
  // - Header injection (HeaderInterceptor)
  // - Gzip compression (GzipRequestInterceptor)
  // - Logging (LogInterceptor)
}
```

### Retry Strategy

- Implemented via `RetryStrategy` class
- Host states tracked in `StatefulHost`
- Configurable timeouts per call type (read/write)
- Network errors trigger retry, 4xx errors do not

### Async Support

```java
// Sync version
SearchResponse response = client.search(params);

// Async version (returns CompletableFuture)
CompletableFuture<SearchResponse> future = client.searchAsync(params);
```

### Exception Hierarchy

```java
// com.algolia.exceptions
AlgoliaException                    // Base (RuntimeException)
├── AlgoliaApiException             // API error (4xx, 5xx)
├── AlgoliaClientException          // Client-side error
├── AlgoliaRetryException           // All retries exhausted
└── AlgoliaRuntimeException         // Unexpected runtime error
```

## Common Gotchas

### Resource Cleanup

```java
// Always close the client when done
SearchClient client = new SearchClient("APP_ID", "API_KEY");
try {
    // use client
} finally {
    client.close();
}

// Or use try-with-resources
try (SearchClient client = new SearchClient("APP_ID", "API_KEY")) {
    // use client
}
```

### Thread Safety

- Client instances are thread-safe
- Share single client across threads
- Don't create new client per request

### Type References for Generics

```java
// Use TypeReference for generic types
List<Hit> hits = client.search(params, new TypeReference<List<Hit>>() {});
```

### Null Safety

```java
// Use Optional for nullable returns
Optional<String> value = config.getOptionalParam();

// Check with @Nonnull/@Nullable annotations
public void method(@Nonnull String required, @Nullable String optional)
```

### Gradle vs Maven

- Project uses Gradle
- Check `build.gradle` for dependencies
- Use `./gradlew` wrapper for builds

## Build & Test Commands

```bash
# From repo root (api-clients-automation)
yarn cli build clients java                    # Build Java client
yarn cli cts generate java                     # Generate CTS tests
yarn cli cts run java                          # Run CTS tests
yarn cli playground java search                # Interactive playground
yarn cli format java clients/algoliasearch-client-java

# From client directory
cd clients/algoliasearch-client-java
./gradlew build                                # Build with Gradle
./gradlew test                                 # Run tests
./gradlew spotlessApply                        # Apply formatting
```

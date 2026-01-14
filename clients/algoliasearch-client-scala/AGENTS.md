# SCALA CLIENT - AI AGENT INSTRUCTIONS

## ⚠️ CRITICAL: CHECK YOUR REPOSITORY FIRST

Before making ANY changes, verify you're in the correct repository:

```bash
git remote -v
```

- ✅ **CORRECT**: `origin .../algolia/api-clients-automation.git` → You may proceed
- ❌ **WRONG**: `origin .../algolia/algoliasearch-client-scala.git` → STOP! This is the PUBLIC repository

**If you're in `algoliasearch-client-scala`**: Do NOT make changes here. All changes must go through `api-clients-automation`. PRs and commits made directly to the public repo will be discarded on next release.

## ⚠️ BEFORE ANY EDIT: Check If File Is Generated

Before editing ANY file, verify it's hand-written by checking `config/generation.config.mjs`:

```javascript
// In generation.config.mjs - patterns WITHOUT '!' are GENERATED (do not edit)
'clients/algoliasearch-client-scala/src/main/scala/algoliasearch/**',  // Generated
'!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/ApiClient.scala',   // Hand-written ✓
'!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/exception/**',      // Hand-written ✓
'!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/internal/**',       // Hand-written ✓
'!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/config/**',         // Hand-written ✓
'!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/extension/**',      // Hand-written ✓
```

**Hand-written (safe to edit):**

- `src/main/scala/algoliasearch/ApiClient.scala` - Core API client
- `src/main/scala/algoliasearch/exception/**` - Exception types
- `src/main/scala/algoliasearch/internal/**` - Internal utilities
- `src/main/scala/algoliasearch/config/**` - Configuration classes
- `src/main/scala/algoliasearch/extension/**` - Scala extensions

**Generated (DO NOT EDIT):**

- `src/main/scala/algoliasearch/api/**` - API trait definitions
- `src/main/scala/algoliasearch/{client}/**` - Client-specific models (search, insights, etc.)
- `version.sbt`

## Language Conventions

### Naming

- **Files**: `PascalCase.scala` matching class/object name
- **Classes/Traits/Objects**: `PascalCase`
- **Methods/Values**: `camelCase`
- **Constants**: `PascalCase` (Scala convention) or `UPPER_SNAKE_CASE`
- **Type parameters**: Single uppercase letter (`T`, `A`, `B`)

### Formatting

- Scalafmt (check `.scalafmt.conf` if present)
- Run: `yarn cli format scala clients/algoliasearch-client-scala`

### Scala Idioms

- Prefer `val` over `var` (immutability)
- Use case classes for data
- Pattern matching over if-else chains
- For-comprehensions for monadic operations
- Implicit conversions/classes for extensions

### Dependencies

- **HTTP**: sttp client
- **JSON**: json4s or circe
- **Build**: SBT
- **Futures**: scala.concurrent.Future

## Client Patterns

### API Client Architecture

```scala
// ApiClient.scala - base client
class ApiClient(config: ClientConfig) {
  // HTTP execution with retry logic
  def execute[T](request: Request[T]): Future[T]
}

// API traits mixed into clients
trait SearchApi { this: ApiClient =>
  def search(params: SearchParams): Future[SearchResponse]
}
```

### Configuration

```scala
// config/
case class ClientConfig(
  appId: String,
  apiKey: String,
  hosts: Seq[Host] = Seq.empty,
  readTimeout: Duration = 5.seconds,
  writeTimeout: Duration = 30.seconds
)
```

### Future-Based Async

```scala
// All API methods return Future
def search(params: SearchParams): Future[SearchResponse]

// Chain with map/flatMap
client.search(params)
  .map(_.hits)
  .flatMap(processHits)

// Or use for-comprehension
for {
  response <- client.search(params)
  processed <- processHits(response.hits)
} yield processed
```

## Common Gotchas

### Future Execution Context

```scala
// Always have implicit ExecutionContext in scope
import scala.concurrent.ExecutionContext.Implicits.global

// Or provide explicitly
implicit val ec: ExecutionContext = myExecutionContext
```

### Option Handling

```scala
// Use pattern matching or combinators
response.hits match {
  case Some(hits) => process(hits)
  case None => defaultValue
}

// Or use getOrElse
val hits = response.hits.getOrElse(Seq.empty)

// For chaining
response.hits.map(_.head).flatMap(_.objectId)
```

### Case Class Copies

```scala
// Immutable updates with copy
val updated = params.copy(hitsPerPage = Some(20))
```

### Implicit Conversions

```scala
// Extensions use implicits
implicit class SearchResponseOps(response: SearchResponse) {
  def firstHit: Option[Hit] = response.hits.flatMap(_.headOption)
}

// Import to use
import algoliasearch.extension._
response.firstHit
```

### Type Inference

```scala
// Scala infers types, but be explicit in public APIs
def search(params: SearchParams): Future[SearchResponse] // Explicit

// Local vals can use inference
val response = client.search(params) // Type inferred
```

## Build & Test Commands

```bash
# From repo root (api-clients-automation)
yarn cli build clients scala                   # Build Scala client
yarn cli cts generate scala                    # Generate CTS tests
yarn cli cts run scala                         # Run CTS tests
yarn cli playground scala search               # Interactive playground
yarn cli format scala clients/algoliasearch-client-scala

# From client directory
cd clients/algoliasearch-client-scala
sbt compile                                    # Compile
sbt test                                       # Run tests
sbt scalafmtAll                                # Format code
```

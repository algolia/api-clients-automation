# GENERATORS KNOWLEDGE BASE

## OVERVIEW

Custom Java-based OpenAPI Generator extensions. Built with Gradle, extends OpenAPI Generator 7.16.0.

## STRUCTURE

```
generators/
├── src/main/java/com/algolia/codegen/
│   ├── Algolia{Lang}Generator.java  # Language-specific generators
│   ├── cts/                          # CTS test generators
│   │   ├── AlgoliaCTSGenerator.java
│   │   └── tests/                    # Test generation logic
│   ├── utils/                        # Shared utilities
│   └── exceptions/                   # Custom exceptions
├── build.gradle                      # Gradle build config
└── settings.gradle
```

## WHERE TO LOOK

| Task                     | File                               | Notes                                 |
| ------------------------ | ---------------------------------- | ------------------------------------- |
| Change Java codegen      | `AlgoliaJavaGenerator.java`        | Extends `JavaClientCodegen`           |
| Change Go codegen        | `AlgoliaGoGenerator.java`          | Extends `GoClientCodegen`             |
| Change JS/TS codegen     | `AlgoliaJavascriptGenerator.java`  | Extends `TypeScriptNodeClientCodegen` |
| CTS test generation      | `cts/AlgoliaCTSGenerator.java`     | Generates tests from CTS specs        |
| Add model processing     | Look for `postProcessModels()`     | Override in generator                 |
| Add operation processing | Look for `postProcessOperations()` | Override in generator                 |

## CONVENTIONS

### Generator Class Structure

```java
public class Algolia{Lang}Generator extends {Lang}ClientCodegen {
    @Override
    public void processOpts() {
        super.processOpts();
        // Custom setup
    }

    @Override
    public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
        // Model transformations
    }

    @Override
    public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> models) {
        // Operation transformations
    }
}
```

### Build Commands

```bash
# From repo root
./gradlew -p generators build          # Build generators
./gradlew -p generators clean build    # Clean rebuild

# JAR output
generators/build/libs/algolia-java-openapi-generator-1.0.0.jar
```

## ANTI-PATTERNS

- **NEVER** modify base OpenAPI Generator classes - extend instead
- **DO NOT** add language-specific string formatting - use templates
- **NEVER** hardcode paths - use `additionalProperties` from config

## NOTES

- Generators auto-rebuild during `yarn cli generate` if source changed
- Debug mode: `yarn cli generate {lang} --debugger` (attach Java debugger)
- Generator names registered in `META-INF/services/org.openapitools.codegen.CodegenConfig`

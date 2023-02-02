# Algolia Kotlin API client BOM

Client [BOM][1] module, can be used to control the dependency versions of direct and transitive dependencies:

```groovy
dependencies {
    // import Kotlin API client BOM
    implementation platform('com.algolia:algoliasearch-client-kotlin-bom:3.0.0-SNAPSHOT')

    // define dependencies without versions
    implementation 'com.algolia:algoliasearch-client-kotlin'
    implementation 'io.ktor:ktor-client-okhttp'
}
```

[1]: https://docs.gradle.org/current/userguide/platforms.html#sub:bom_import

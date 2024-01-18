export const patterns = [
  // Ignore the roots and go down the tree by negating hand written files
  'specs/bundled/*.yml',

  'clients/**',
  'snippets/**',
  '!clients/README.md',
  '!clients/**/.openapi-generator-ignore',

  // C#
  '!snippets/csharp/**',
  'snippets/csharp/src/**.cs',
  'clients/algoliasearch-client-csharp/**',
  '!clients/algoliasearch-client-csharp/*',
  'clients/algoliasearch-client-csharp/global.json',
  '!clients/algoliasearch-client-csharp/algoliasearch/Clients/**',
  '!clients/algoliasearch-client-csharp/algoliasearch/Exceptions/**',
  '!clients/algoliasearch-client-csharp/algoliasearch/Serializer/**',
  '!clients/algoliasearch-client-csharp/algoliasearch/Utils/**',
  '!clients/algoliasearch-client-csharp/algoliasearch/Http/**',
  '!clients/algoliasearch-client-csharp/algoliasearch/Transport/**',
  '!clients/algoliasearch-client-csharp/algoliasearch/Models/**',
  'tests/output/csharp/global.json',

  // Dart
  '!snippets/dart/**',
  'snippets/dart/lib/**',
  '!clients/algoliasearch-client-dart/**',
  'clients/algoliasearch-client-dart/packages/*/pubspec.yaml',
  'clients/algoliasearch-client-dart/packages/*/lib/*.dart',
  'clients/algoliasearch-client-dart/packages/*/lib/src/*.dart',
  'clients/algoliasearch-client-dart/packages/client_core/pubspec.yaml',
  'clients/algoliasearch-client-dart/packages/*/lib/src/api/**',
  'clients/algoliasearch-client-dart/packages/*/lib/src/model/**',
  '!clients/algoliasearch-client-dart/packages/client_core/**',
  'clients/algoliasearch-client-dart/packages/client_core/lib/src/version.dart',
  '!clients/algoliasearch-client-dart/packages/*/lib/src/extension.dart',
  '!clients/algoliasearch-client-dart/packages/algoliasearch/lib/algoliasearch.dart',

  // GO
  'clients/algoliasearch-client-go/algolia/**',
  '!clients/algoliasearch-client-go/.github/**',
  '!clients/algoliasearch-client-go/*',
  '!clients/algoliasearch-client-go/algolia/transport/**',
  '!clients/algoliasearch-client-go/algolia/errs/**',
  '!clients/algoliasearch-client-go/algolia/call/*',
  '!clients/algoliasearch-client-go/algolia/compression/*',
  '!clients/algoliasearch-client-go/algolia/debug/*',
  '!clients/algoliasearch-client-go/algolia/utils/*',

  'tests/output/go/go.sum',

  // Java
  '!clients/algoliasearch-client-java/**',
  'clients/algoliasearch-client-java/gradle.properties',
  'clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/api/**',
  'clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/model/**',
  'clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/BuildConfig.java',

  'tests/output/java/build.gradle',

  // JavaScript
  '!snippets/javascript/*.json',
  '!clients/algoliasearch-client-javascript/*',
  '!clients/algoliasearch-client-javascript/.github/**',
  '!clients/algoliasearch-client-javascript/.yarn/**',
  '!clients/algoliasearch-client-javascript/scripts/**',
  '!clients/algoliasearch-client-javascript/tests/**',
  // the release process is allowed to push changes to this file, but in general we don't because those files are generated
  process.env.RELEASE ? '!clients/algoliasearch-client-javascript/packages/**/package.json' : 'clients/algoliasearch-client-javascript/packages/**/package.json',
  '!clients/algoliasearch-client-javascript/packages/requester-*/**',
  '!clients/algoliasearch-client-javascript/packages/client-common/**',
  '!clients/algoliasearch-client-javascript/packages/algoliasearch/__tests__/**',
  '!clients/algoliasearch-client-javascript/packages/algoliasearch/jest.config.cjs',
  '!clients/algoliasearch-client-javascript/packages/algoliasearch/babel.config.cjs',

  'tests/output/javascript/package.json',

  // Kotlin
  '!snippets/kotlin/**',
  'snippets/kotlin/src/**',
  '!clients/algoliasearch-client-kotlin/**',
  'clients/algoliasearch-client-kotlin/gradle.properties',
  'clients/algoliasearch-client-kotlin/client/README.md',
  'clients/algoliasearch-client-kotlin/client-bom/README.md',
  'clients/algoliasearch-client-kotlin/client/src/commonMain/kotlin/com/algolia/client/BuildConfig.kt',
  'clients/algoliasearch-client-kotlin/client/src/commonMain/kotlin/com/algolia/client/api/**',
  'clients/algoliasearch-client-kotlin/client/src/commonMain/kotlin/com/algolia/client/model/**',

  'tests/output/kotlin/src/commonTest/kotlin/com/algolia/client/**',
  'tests/output/kotlin/src/commonTest/kotlin/com/algolia/requests/**',

  // PHP
  '!clients/algoliasearch-client-php/**',
  'clients/algoliasearch-client-php/lib/Api/*',
  'clients/algoliasearch-client-php/lib/Model/**',
  'clients/algoliasearch-client-php/lib/Configuration/*',
  'clients/algoliasearch-client-php/lib/ApiException.php',
  'clients/algoliasearch-client-php/lib/ObjectSerializer.php',
  'clients/algoliasearch-client-php/lib/Algolia.php',
  'clients/algoliasearch-client-php/composer.json',

  // Python
  '!snippets/python/pyproject.toml',
  'clients/algoliasearch-client-python/**',
  '!clients/algoliasearch-client-python/algoliasearch/http/**',
  '!clients/algoliasearch-client-python/algoliasearch/py.typed',
  'clients/algoliasearch-client-python/algoliasearch/http/__init__.py',
  '!clients/algoliasearch-client-python/*',
  'clients/algoliasearch-client-python/pyproject.toml',
  'clients/algoliasearch-client-python/poetry.lock',
  'clients/algoliasearch-client-python/requirements.txt',
  'clients/algoliasearch-client-python/.gitignore',

  'tests/output/python/requirements.txt',

  // Ruby
  '!snippets/ruby/Gemfile',
  '!snippets/ruby/.rubocop.yml',
  '!clients/algoliasearch-client-ruby/**',
  'clients/algoliasearch-client-ruby/Gemfile.lock',
  'clients/algoliasearch-client-ruby/lib/algolia/**',
  '!clients/algoliasearch-client-ruby/lib/algolia/api_client.rb',
  '!clients/algoliasearch-client-ruby/lib/algolia/api_error.rb',
  '!clients/algoliasearch-client-ruby/lib/algolia/error.rb',
  '!clients/algoliasearch-client-ruby/lib/algolia/configuration.rb',
  '!clients/algoliasearch-client-ruby/lib/algolia/logger_helper.rb',
  '!clients/algoliasearch-client-ruby/lib/algolia/user_agent.rb',
  '!clients/algoliasearch-client-ruby/lib/algolia/transport/**',

  // Scala
  '!snippets/scala/**',
  'snippets/scala/src/**',
  '!clients/algoliasearch-client-scala/**',
  'clients/algoliasearch-client-scala/version.sbt',
  'clients/algoliasearch-client-scala/src/main/scala/algoliasearch/**',
  '!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/exception/**',
  '!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/internal/**',
  '!clients/algoliasearch-client-scala/src/main/scala/algoliasearch/config/**',

  // Swift
  'clients/algoliasearch-client-swift/**',
  '!clients/algoliasearch-client-swift/*',
  'clients/algoliasearch-client-swift/AlgoliaSearchClient.podspec',
  'clients/algoliasearch-client-swift/Package.swift',
  'clients/algoliasearch-client-swift/**/Sources/**',
  '!clients/algoliasearch-client-swift/Sources/Core/**',
  'clients/algoliasearch-client-swift/Sources/Core/Helpers/Version.swift',
];

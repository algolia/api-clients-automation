## [1.51.1](https://github.com/algolia/algoliasearch-client-dart/compare/1.51.0...1.51.1)

- [a676cd9cef](https://github.com/algolia/api-clients-automation/commit/a676cd9cef) fix(clients): bump replaceAllObjects default maxRetries from 100 to 800 ([#6580](https://github.com/algolia/api-clients-automation/pull/6580)) by [@Fluf22](https://github.com/Fluf22/)
- [a632f9fb75](https://github.com/algolia/api-clients-automation/commit/a632f9fb75) fix(specs): BREAKING CHANGE – allow null records in getObjects response ([#6582](https://github.com/algolia/api-clients-automation/pull/6582)) by [@Fluf22](https://github.com/Fluf22/)
  - The `getObjects` operation now returns a list of nullable objects, as the API can send back `null` records. The clients previously only allowed a list of objects, so the response type has been updated to allow `null` values.

## [1.51.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.50.1...1.51.0)

- [52ebd28f58](https://github.com/algolia/api-clients-automation/commit/52ebd28f58) feat(clients): release Agent Studio package updates ([#6573](https://github.com/algolia/api-clients-automation/pull/6573)) by [@Fluf22](https://github.com/Fluf22/)

## [0.1.0-beta.1](https://github.com/algolia/algoliasearch-client-dart/compare/0.1.0-beta.0...0.1.0-beta.1)

- [45b42dd36f](https://github.com/algolia/api-clients-automation/commit/45b42dd36f) fix(dart): add missing version tests and publish agent-studio ([#6500](https://github.com/algolia/api-clients-automation/pull/6500)) by [@Fluf22](https://github.com/Fluf22/)
- [7fcafa32bd](https://github.com/algolia/api-clients-automation/commit/7fcafa32bd) fix(dart): gate extension.dart export behind hasExtensions ([#6507](https://github.com/algolia/api-clients-automation/pull/6507)) by [@MarioAlexandruDan](https://github.com/MarioAlexandruDan/)
- [77ef74c404](https://github.com/algolia/api-clients-automation/commit/77ef74c404) guides: add transformationOptions setup guides for the search client ([#6483](https://github.com/algolia/api-clients-automation/pull/6483)) by [@MarioAlexandruDan](https://github.com/MarioAlexandruDan/)

## 0.1.0-beta.0

- [7f2ce8cd3a](https://github.com/algolia/api-clients-automation/commit/7f2ce8cd3a) feat(clients): Agent Studio v1 ([#6097](https://github.com/algolia/api-clients-automation/pull/6097)) by [@Fluf22](https://github.com/Fluf22/)


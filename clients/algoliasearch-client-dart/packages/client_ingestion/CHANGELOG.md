## [1.50.0](https://github.com/algolia/algoliasearch-client-dart/compare/1.49.2...1.50.0)

BREAKING CHANGES: this minor version includes breaking changes. See below for more details.

- [32ccb3b1e9](https://github.com/algolia/api-clients-automation/commit/32ccb3b1e9) feat(dart): add TransformationOptions for ingestion transporter configuration ([#6321](https://github.com/algolia/api-clients-automation/pull/6321)) by [@MarioAlexandruDan](https://github.com/MarioAlexandruDan/)
- [7f2ce8cd3a](https://github.com/algolia/api-clients-automation/commit/7f2ce8cd3a) feat(clients): Agent Studio v1 ([#6097](https://github.com/algolia/api-clients-automation/pull/6097)) by [@Fluf22](https://github.com/Fluf22/)
  - The `customRequest` method now returns `null` for API calls that respond with 204 No Content, where it previously returned an empty map `{}`. If you use `customRequest` with endpoints that return 204, update your code to handle nullable responses.


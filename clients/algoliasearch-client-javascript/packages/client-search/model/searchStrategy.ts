// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Strategy for multiple search queries:  - `none`. Run all queries. - `stopIfEnoughMatches`. Run the queries one by one, stopping as soon as a query matches at least the `hitsPerPage` number of results.
 */
export type SearchStrategy = 'none' | 'stopIfEnoughMatches';

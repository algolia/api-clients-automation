// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Determines how many records of a group are included in the search results.  Records with the same value for the `attributeForDistinct` attribute are considered a group. The `distinct` setting controls how many members of the group are returned. This is useful for [deduplication and grouping](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature).  The `distinct` setting is ignored if `attributeForDistinct` is not set.
 */
export type Distinct = boolean | number;

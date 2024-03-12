// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Determines if and how query words are interpreted as prefixes.  By default, only the last query word is treated as prefix (`prefixLast`). To turn off prefix search, use `prefixNone`. Avoid `prefixAll`, which treats all query words as prefixes. This might lead to counterintuitive results and makes your search slower.  For more information, see [Prefix searching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/prefix-searching/).
 */
export type QueryType = 'prefixAll' | 'prefixLast' | 'prefixNone';

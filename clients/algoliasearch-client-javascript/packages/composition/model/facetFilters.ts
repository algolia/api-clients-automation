// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Filter the search by facet values, so that only records with the same facet values are retrieved.  **Prefer using the `filters` parameter, which supports all filter types and combinations with boolean operators.**  - `[filter1, filter2]` is interpreted as `filter1 AND filter2`. - `[[filter1, filter2], filter3]` is interpreted as `filter1 OR filter2 AND filter3`. - `facet:-value` is interpreted as `NOT facet:value`.  While it\'s best to avoid attributes that start with a `-`, you can still filter them by escaping with a backslash: `facet:\\-value`.
 */
export type FacetFilters = Array<FacetFilters> | string;

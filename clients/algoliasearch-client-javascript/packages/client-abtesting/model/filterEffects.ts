// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { EmptySearchFilter } from './emptySearchFilter';
import type { OutliersFilter } from './outliersFilter';

/**
 * A/B test filter effects resulting from configuration settings.
 */
export type FilterEffects = {
  outliers?: OutliersFilter;

  emptySearch?: EmptySearchFilter;
};

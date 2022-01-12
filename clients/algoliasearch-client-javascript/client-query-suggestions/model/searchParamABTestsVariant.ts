import type { BaseABTestsVariant } from './baseABTestsVariant';
import type { SearchParamABTestsVariantAllOf } from './searchParamABTestsVariantAllOf';

export type SearchParamABTestsVariant = BaseABTestsVariant &
  SearchParamABTestsVariantAllOf;

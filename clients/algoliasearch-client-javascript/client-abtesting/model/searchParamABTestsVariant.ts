import type { BaseABTestsVariant } from './baseABTestsVariant';
import type { SearchParamsABTestsVariant } from './searchParamsABTestsVariant';

export type SearchParamABTestsVariant = BaseABTestsVariant &
  SearchParamsABTestsVariant;

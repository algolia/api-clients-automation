import { BaseSearchResponse } from './baseSearchResponse';
import { BaseSearchResponseFacetsStats } from './baseSearchResponseFacetsStats';
import { Record } from './record';
import { SearchResponseAllOf } from './searchResponseAllOf';

export type SearchResponse = BaseSearchResponse & SearchResponseAllOf;

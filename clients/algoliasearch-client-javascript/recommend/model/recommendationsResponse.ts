import { BaseSearchResponse } from './baseSearchResponse';
import { BaseSearchResponseFacetsStats } from './baseSearchResponseFacetsStats';
import { RecommendRecord } from './recommendRecord';
import { RecommendationsResponseAllOf } from './recommendationsResponseAllOf';

export type RecommendationsResponse = BaseSearchResponse & RecommendationsResponseAllOf;

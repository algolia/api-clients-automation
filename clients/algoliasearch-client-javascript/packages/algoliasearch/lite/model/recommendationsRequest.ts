// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { BoughtTogetherQuery } from './boughtTogetherQuery';

import type { LookingSimilarQuery } from './lookingSimilarQuery';

import type { RelatedQuery } from './relatedQuery';
import type { TrendingFacetsQuery } from './trendingFacetsQuery';
import type { TrendingItemsQuery } from './trendingItemsQuery';

export type RecommendationsRequest =
  | BoughtTogetherQuery
  | RelatedQuery
  | TrendingItemsQuery
  | TrendingFacetsQuery
  | LookingSimilarQuery;

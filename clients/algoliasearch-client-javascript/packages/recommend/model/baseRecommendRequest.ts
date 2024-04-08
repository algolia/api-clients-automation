// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { SearchParams } from './searchParams';

export type BaseRecommendRequest = {
  /**
   * Index name.
   */
  indexName: string;

  /**
   * Minimum score a recommendation must have to be included in the response.
   */
  threshold: number;

  /**
   * Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.
   */
  maxRecommendations?: number;

  queryParameters?: SearchParams;
};

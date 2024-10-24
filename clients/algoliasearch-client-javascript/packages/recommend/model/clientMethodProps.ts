// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { RecommendModels } from '../model/recommendModels';
import type { RecommendRule } from '../model/recommendRule';

import type { SearchRecommendRulesParams } from '../model/searchRecommendRulesParams';

import type { RecommendationsRequest } from './recommendationsRequest';

/**
 * Properties for the `batchRecommendRules` method.
 */
export type BatchRecommendRulesProps = {
  /**
   * Name of the index on which to perform the operation.
   */
  indexName: string;
  /**
   * [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
   */
  model: RecommendModels;
  recommendRule?: Array<RecommendRule>;
};

/**
 * Properties for the `customDelete` method.
 */
export type CustomDeleteProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
};

/**
 * Properties for the `customGet` method.
 */
export type CustomGetProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
};

/**
 * Properties for the `customPost` method.
 */
export type CustomPostProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, unknown>;
};

/**
 * Properties for the `customPut` method.
 */
export type CustomPutProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: { [key: string]: any };
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, unknown>;
};

/**
 * Properties for the `deleteRecommendRule` method.
 */
export type DeleteRecommendRuleProps = {
  /**
   * Name of the index on which to perform the operation.
   */
  indexName: string;
  /**
   * [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
   */
  model: RecommendModels;
  /**
   * Unique record identifier.
   */
  objectID: string;
};

/**
 * Properties for the `getRecommendRule` method.
 */
export type GetRecommendRuleProps = {
  /**
   * Name of the index on which to perform the operation.
   */
  indexName: string;
  /**
   * [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
   */
  model: RecommendModels;
  /**
   * Unique record identifier.
   */
  objectID: string;
};

/**
 * Properties for the `getRecommendStatus` method.
 */
export type GetRecommendStatusProps = {
  /**
   * Name of the index on which to perform the operation.
   */
  indexName: string;
  /**
   * [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
   */
  model: RecommendModels;
  /**
   * Unique task identifier.
   */
  taskID: number;
};

/**
 * Recommend method signature compatible with the `algoliasearch` v4 package. When using this signature, extra computation will be required to make it match the new signature.
 *
 * @deprecated This signature will be removed from the next major version, we recommend using the `GetRecommendationsParams` type for performances and future proof reasons.
 */
export type LegacyGetRecommendationsParams = RecommendationsRequest[];

/**
 * Properties for the `searchRecommendRules` method.
 */
export type SearchRecommendRulesProps = {
  /**
   * Name of the index on which to perform the operation.
   */
  indexName: string;
  /**
   * [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
   */
  model: RecommendModels;
  searchRecommendRulesParams?: SearchRecommendRulesParams;
};

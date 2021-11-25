import { BaseSearchParams } from './baseSearchParams';
import { IndexSettingsAsSearchParams } from './indexSettingsAsSearchParams';

export type RecommendationRequest = {
  /**
   * The Algolia index name
   */
  indexName: string;
  /**
   * Unique identifier of the object
   */
  objectID: string;
  /**
   * The recommendation model to use.
   */
  model: RecommendationRequest.ModelEnum;
  /**
   * The threshold to use when filtering recommendations by their score.
   */
  threshold: number;
  /**
   * The max number of recommendations to retrieve. If it’s set to 0, all the recommendations of the objectID may be returned.
   */
  maxRecommendations?: number;
  _queryParameters?: (BaseSearchParams & IndexSettingsAsSearchParams) | null;
  fallbackParameters?: (BaseSearchParams & IndexSettingsAsSearchParams) | null;
};

export namespace RecommendationRequest {
  export enum ModelEnum {
    RelatedProducts = 'related-products',
    BoughtTogether = 'bought-together',
  }
}

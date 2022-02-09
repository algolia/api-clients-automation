/**
 * Object with models and types to retrieve.
 */
export type ModelsTypesRequest = {
  /**
   * List with model types for which to retrieve predictions.
   */
  modelsToRetrieve?: ModelsTypesRequestModelsToRetrieve[];
  /**
   * List with types to be retrieved.
   */
  typesToRetrieve?: ModelsTypesRequestTypesToRetrieve[];
};

export type ModelsTypesRequestModelsToRetrieve =
  | 'affinities'
  | 'funnel_stage'
  | 'order_value';

export type ModelsTypesRequestTypesToRetrieve = 'properties' | 'segments';

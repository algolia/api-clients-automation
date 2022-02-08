export type InlineObject = {
  /**
   * List with model types for which to retrieve predictions.
   */
  modelsToRetrieve?: InlineObjectModelsToRetrieve[];
  /**
   * List with types to be retrieved.
   */
  typesToRetrieve?: InlineObjectTypesToRetrieve[];
};

export type InlineObjectModelsToRetrieve =
  | 'affinities'
  | 'funnel_stage'
  | 'order_value';

export type InlineObjectTypesToRetrieve = 'properties' | 'segments';

export type SetPersonalizationStrategy = {
  eventScoring?: Array<Array<Record<string, any>>>;
  facetScoring?: Array<Array<Record<string, any>>>;
  /**
   * The impact that personalization has on search results: a number between 0 (personalization disabled) and 100 (personalization fully enabled).
   */
  personalizationImpact?: number;
};

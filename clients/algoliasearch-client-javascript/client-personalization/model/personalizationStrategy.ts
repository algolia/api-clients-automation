import type { PersonalizationStrategyEventScoring } from './personalizationStrategyEventScoring';
import type { PersonalizationStrategyFacetScoring } from './personalizationStrategyFacetScoring';

export type PersonalizationStrategy = {
  /**
   * Scores associated with the events.
   */
  eventScoring?: PersonalizationStrategyEventScoring[];
  /**
   * Scores associated with the facets.
   */
  facetScoring?: PersonalizationStrategyFacetScoring[];
  /**
   * The impact that personalization has on search results: a number between 0 (personalization disabled) and 100 (personalization fully enabled).
   */
  personalizationImpact?: number;
};

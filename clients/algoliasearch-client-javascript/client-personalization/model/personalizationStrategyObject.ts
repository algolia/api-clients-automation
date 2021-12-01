import type { PersonalizationStrategyObjectEventScoring } from './personalizationStrategyObjectEventScoring';
import type { PersonalizationStrategyObjectFacetScoring } from './personalizationStrategyObjectFacetScoring';

export type PersonalizationStrategyObject = {
  /**
   * Scores associated with the events.
   */
  eventScoring: PersonalizationStrategyObjectEventScoring[];
  /**
   * Scores associated with the facets.
   */
  facetScoring: PersonalizationStrategyObjectFacetScoring[];
  /**
   * The impact that personalization has on search results: a number between 0 (personalization disabled) and 100 (personalization fully enabled).
   */
  personalizationImpact: number;
};

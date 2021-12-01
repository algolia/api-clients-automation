import type { SetPersonalizationStrategyObjectEventScoring } from './setPersonalizationStrategyObjectEventScoring';
import type { SetPersonalizationStrategyObjectFacetScoring } from './setPersonalizationStrategyObjectFacetScoring';

export type SetPersonalizationStrategyObject = {
  /**
   * Scores associated with the events.
   */
  eventScoring?: SetPersonalizationStrategyObjectEventScoring[];
  /**
   * Scores associated with the facets.
   */
  facetScoring?: SetPersonalizationStrategyObjectFacetScoring[];
  /**
   * The impact that personalization has on search results: a number between 0 (personalization disabled) and 100 (personalization fully enabled).
   */
  personalizationImpact?: number;
};

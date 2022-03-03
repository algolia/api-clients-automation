import type { GetSearchesNoResultsResponseSearches } from './getSearchesNoResultsResponseSearches';

export type GetTopSearchesResponseSimple = {
  /**
   * A list of top searches with their count.
   */
  searches: GetSearchesNoResultsResponseSearches[];
};

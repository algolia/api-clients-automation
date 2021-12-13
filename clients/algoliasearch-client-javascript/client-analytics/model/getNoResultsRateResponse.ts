import type { GetNoResultsRateResponseSearches } from './getNoResultsRateResponseSearches';

export type GetNoResultsRateResponse = {
  /**
   * A list of top searches with their count.
   */
  searches: GetNoResultsRateResponseSearches[];
};

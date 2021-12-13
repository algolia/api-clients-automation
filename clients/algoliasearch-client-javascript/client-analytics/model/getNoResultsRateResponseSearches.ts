export type GetNoResultsRateResponseSearches = {
  /**
   * The search query.
   */
  search: string;
  /**
   * The number of occurrences.
   */
  count: number;
  /**
   * The number of occurrences with filter.
   */
  withFilterCount: number;
};

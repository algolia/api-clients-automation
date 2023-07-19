// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type TopHitWithAnalytics = {
  /**
   * Hit.
   */
  hit: string;

  /**
   * Number of occurrences.
   */
  count: number;

  /**
   * [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
   */
  clickThroughRate: number;

  /**
   * [Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).
   */
  conversionRate: number;

  /**
   * Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.
   */
  trackedSearchCount: number;

  /**
   * Number of click events.
   */
  clickCount: number;

  /**
   * Number of converted clicks.
   */
  conversionCount: number;
};

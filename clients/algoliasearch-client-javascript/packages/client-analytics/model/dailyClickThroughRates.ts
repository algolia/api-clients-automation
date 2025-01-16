// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type DailyClickThroughRates = {
  /**
   * Click-through rate: calculated as the number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn\'t receive any search requests with `clickAnalytics` set to true.
   */
  rate: number | null;

  /**
   * Number of clicks associated with this search.
   */
  clickCount: number;

  /**
   * Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
   */
  trackedSearchCount: number;

  /**
   * Date in the format YYYY-MM-DD.
   */
  date: string;
};

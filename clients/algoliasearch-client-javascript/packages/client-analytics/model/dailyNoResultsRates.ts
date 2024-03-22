// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type DailyNoResultsRates = {
  /**
   * Date in the format YYYY-MM-DD.
   */
  date: string;

  /**
   * Number of searches without any results.
   */
  noResultCount: number;

  /**
   * Number of searches.
   */
  count: number;

  /**
   * No results rate, calculated as number of searches with zero results divided by the total number of searches.
   */
  rate: number;
};

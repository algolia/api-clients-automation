// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type Currency = {
  /**
   * Currency code.
   */
  currency?: string | undefined;

  /**
   * Revenue for this currency.
   */
  revenue?: number | undefined;

  /**
   * Mean for this currency.
   */
  mean?: number | undefined;

  /**
   * Standard deviation for this currency.
   */
  standardDeviation?: number | undefined;

  /**
   * The amount of revenue for this currency that was removed after capping purchase amounts to the 95th percentile.
   */
  winsorizedAmount?: number | undefined;
};

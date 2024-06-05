// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

export type AbTestsVariant = {
  /**
   * Index name of the A/B test variant (case-sensitive).
   */
  index: string;

  /**
   * Percentage of search requests each variant receives.
   */
  trafficPercentage: number;

  /**
   * Description for this variant.
   */
  description?: string;
};

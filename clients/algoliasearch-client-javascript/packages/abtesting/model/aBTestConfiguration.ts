// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { ErrorCorrectionType } from './errorCorrectionType';
import type { MetricsFilter } from './metricsFilter';
import type { MinimumDetectableEffect } from './minimumDetectableEffect';

/**
 * A/B test configuration.
 */
export type ABTestConfiguration = {
  minimumDetectableEffect?: MinimumDetectableEffect | undefined;

  /**
   * List of metric filters applied to the test population.
   */
  filters?: Array<MetricsFilter> | undefined;

  errorCorrection?: ErrorCorrectionType | undefined;
};

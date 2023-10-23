// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { ConversionEvent } from './conversionEvent';

export type ConvertedFilters = {
  /**
   * Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment\'s [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
   */
  eventName: string;

  eventType: ConversionEvent;

  /**
   * Name of the Algolia index.
   */
  index: string;

  /**
   * Facet filters.  Each facet filter string must be URL-encoded, such as, `discount:10%25`.
   */
  filters: string[];

  /**
   * Anonymous or pseudonymous user identifier.   > **Note**: Never include personally identifiable information in user tokens.
   */
  userToken: string;

  /**
   * Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.
   */
  timestamp?: number;

  /**
   * User token for authenticated users.
   */
  authenticatedUserToken?: string;
};

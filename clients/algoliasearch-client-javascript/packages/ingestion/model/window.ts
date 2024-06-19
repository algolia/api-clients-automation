// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Time window by which to filter the observability data.
 */
export type Window = {
  /**
   * Date in RFC 3339 format representing the oldest data in the time window.
   */
  startDate: string;

  /**
   * Date in RFC 3339 format representing the newest data in the time window.
   */
  endDate: string;
};

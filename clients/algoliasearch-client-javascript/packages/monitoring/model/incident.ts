// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { Status } from './status';

/**
 * Incident details.
 */
export type Incident = {
  /**
   * Description of the incident.
   */
  title?: string;

  status?: Status;
};

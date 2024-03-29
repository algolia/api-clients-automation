// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { EditType } from './editType';

export type Edit = {
  type?: EditType;

  /**
   * Text or patterns to remove from the query string.
   */
  delete?: string;

  /**
   * Text to be added in place of the deleted text inside the query string.
   */
  insert?: string;
};

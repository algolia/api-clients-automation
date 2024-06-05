// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { Action } from './action';

export type MultipleBatchRequest = {
  action: Action;

  /**
   * Operation arguments (varies with specified `action`).
   */
  body: Record<string, any>;

  /**
   * Index name (case-sensitive).
   */
  indexName: string;
};

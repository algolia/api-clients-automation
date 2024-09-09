// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { SourceInput } from './sourceInput';
import type { SourceType } from './sourceType';

export type SourceCreate = {
  type: SourceType;

  /**
   * Descriptive name of the source.
   */
  name: string;

  input?: SourceInput;

  /**
   * Universally unique identifier (UUID) of an authentication resource.
   */
  authenticationID?: string;
};

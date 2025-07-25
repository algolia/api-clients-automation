// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { AuthenticationCreate } from './authenticationCreate';
import type { TransformationInput } from './transformationInput';
import type { TransformationType } from './transformationType';

export type TransformationTry = {
  /**
   * It is deprecated. Use the `input` field with proper `type` instead to specify the transformation code.
   */
  code?: string | undefined;

  type?: TransformationType | undefined;

  input?: TransformationInput | undefined;

  /**
   * The record to apply the given code to.
   */
  sampleRecord: Record<string, unknown>;

  authentications?: Array<AuthenticationCreate> | undefined;
};

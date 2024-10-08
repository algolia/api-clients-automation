// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { MappingFormatSchema } from './mappingFormatSchema';
import type { MappingKitAction } from './mappingKitAction';

/**
 * Transformations to apply to the source, serialized as a JSON string.
 */
export type MappingInput = {
  format: MappingFormatSchema;

  actions: Array<MappingKitAction>;
};

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Describes how a field should be resolved by applying a set of directives.
 */
export type MappingFieldDirective = {
  /**
   * Destination field key.
   */
  fieldKey: string;

  /**
   * How the destination field should be resolved from the source.
   */
  value: { [key: string]: any };
};

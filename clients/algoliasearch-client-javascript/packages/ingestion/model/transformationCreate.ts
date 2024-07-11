// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * API request body for creating a transformation.
 */
export type TransformationCreate = {
  /**
   * The source code of the transformation.
   */
  code: string;

  /**
   * The uniquely identified name of your transformation.
   */
  name: string;

  /**
   * A descriptive name for your transformation of what it does.
   */
  description?: string;
};

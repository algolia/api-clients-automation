// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * API response for the successful creation of an authentication resource.
 */
export type AuthenticationCreateResponse = {
  /**
   * Universally unique identifier (UUID) of an authentication resource.
   */
  authenticationID: string;

  /**
   * Descriptive name for the resource.
   */
  name: string;

  /**
   * Date of creation in RFC 3339 format.
   */
  createdAt: string;
};

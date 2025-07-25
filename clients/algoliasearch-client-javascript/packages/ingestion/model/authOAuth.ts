// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

/**
 * Credentials for authenticating with OAuth 2.0.
 */
export type AuthOAuth = {
  /**
   * URL for the OAuth endpoint.
   */
  url: string;

  /**
   * Client ID.
   */
  client_id: string;

  /**
   * Client secret. This field is `null` in the API response.
   */
  client_secret: string;

  /**
   * OAuth scope.
   */
  scope?: string | undefined;
};

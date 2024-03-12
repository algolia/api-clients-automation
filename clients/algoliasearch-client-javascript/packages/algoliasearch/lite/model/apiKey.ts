// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { Acl } from './acl';

/**
 * API key object.
 */
export type ApiKey = {
  /**
   * Permissions that determine the type of API requests this key can make. The required ACL is listed in each endpoint\'s reference. For more information, see [access control list](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl).
   */
  acl: Acl[];

  /**
   * Description of an API key to help you identify this API key.
   */
  description?: string;

  /**
   * Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\".
   */
  indexes?: string[];

  /**
   * Maximum number of results this API key can retrieve in one query. By default, there\'s no limit.
   */
  maxHitsPerQuery?: number;

  /**
   * Maximum number of API requests allowed per IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) per hour.  If this limit is reached, the API returns an error with status code `429`. By default, there\'s no limit.
   */
  maxQueriesPerIPPerHour?: number;

  /**
   * Query parameters to add when making API requests with this API key.  To restrict this API key to specific IP addresses, add the `restrictSources` parameter. You can only add a single source, but you can provide a range of IP addresses.  Creating an API key fails if the request is made from an IP address that\'s outside the restricted range.
   */
  queryParameters?: string;

  /**
   * Allowed HTTP referrers for this API key.  By default, all referrers are allowed. You can use leading and trailing wildcard characters (`*`):  - `https://algolia.com/_*` allows all referrers starting with \"https://algolia.com/\" - `*.algolia.com` allows all referrers ending with \".algolia.com\" - `*algolia.com*` allows all referrers in the domain \"algolia.com\".  Like all HTTP headers, referrers can be spoofed. Don\'t rely on them to secure your data. For more information, see [HTTP referrer restrictions](https://www.algolia.com/doc/guides/security/security-best-practices/#http-referrers-restrictions).
   */
  referers?: string[];

  /**
   * Duration (in seconds) after which the API key expires. By default, API keys don\'t expire.
   */
  validity?: number;
};

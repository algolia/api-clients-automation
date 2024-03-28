/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Credentials for authenticating with Algolia.
 *
 * @param appID Algolia application ID.
 * @param apiKey Algolia API key with the ACL: `addObject`, `deleteObject`, `settings`, `editSettings`, `listIndexes`, `deleteIndex`. This field is `null` in the API response.
 */
@Serializable
public data class AuthAlgolia(

  /** Algolia application ID. */
  @SerialName(value = "appID") val appID: String,

  /** Algolia API key with the ACL: `addObject`, `deleteObject`, `settings`, `editSettings`, `listIndexes`, `deleteIndex`. This field is `null` in the API response.  */
  @SerialName(value = "apiKey") val apiKey: String,
) : AuthInput

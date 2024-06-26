/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Credentials for authenticating with the Algolia Insights API.
 *
 * @param appID Algolia application ID.
 * @param apiKey Algolia API key with the ACL: `search`. This field is `null` in the API response.
 */
@Serializable
public data class AuthAlgoliaInsightsPartial(

  /** Algolia application ID. */
  @SerialName(value = "appID") val appID: String? = null,

  /** Algolia API key with the ACL: `search`. This field is `null` in the API response.  */
  @SerialName(value = "apiKey") val apiKey: String? = null,
) : AuthInputPartial

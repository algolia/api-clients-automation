/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.personalization

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * DeleteUserProfileResponse
 *
 * @param userToken userToken representing the user for which to fetch the Personalization profile.
 * @param deletedUntil A date until which the data can safely be considered as deleted for the given user. Any data received after the `deletedUntil` date will start building a new user profile.
 */
@Serializable
public data class DeleteUserProfileResponse(

  /** userToken representing the user for which to fetch the Personalization profile. */
  @SerialName(value = "userToken") val userToken: String,

  /** A date until which the data can safely be considered as deleted for the given user. Any data received after the `deletedUntil` date will start building a new user profile. */
  @SerialName(value = "deletedUntil") val deletedUntil: String,
)

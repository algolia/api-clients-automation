/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * RedirectRuleIndexMetadata
 *
 * @param source Source index for the redirect rule.
 * @param dest Destination index for the redirect rule.
 * @param reason Reason for the redirect rule.
 * @param succeed Redirect rule status.
 * @param `data`
 */
@Serializable
public data class RedirectRuleIndexMetadata(

  /** Source index for the redirect rule. */
  @SerialName(value = "source") val source: String,

  /** Destination index for the redirect rule. */
  @SerialName(value = "dest") val dest: String,

  /** Reason for the redirect rule. */
  @SerialName(value = "reason") val reason: String,

  /** Redirect rule status. */
  @SerialName(value = "succeed") val succeed: Boolean,

  @SerialName(value = "data") val `data`: RedirectRuleIndexData,
)

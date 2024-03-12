/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Snippets that show the context around a matching search query.
 *
 * @param `value` Highlighted attribute value, including HTML tags.
 * @param matchLevel
 */
@Serializable
public data class SnippetResultOption(

  /** Highlighted attribute value, including HTML tags. */
  @SerialName(value = "value") val `value`: String,

  @SerialName(value = "matchLevel") val matchLevel: MatchLevel,
) : SnippetResult

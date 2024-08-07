/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * OperationIndexParams
 *
 * @param operation
 * @param destination Index name (case-sensitive).
 * @param scope **Only for copying.**  If you specify a scope, only the selected scopes are copied. Records and the other scopes are left unchanged. If you omit the `scope` parameter, everything is copied: records, settings, synonyms, and rules.
 */
@Serializable
public data class OperationIndexParams(

  @SerialName(value = "operation") val operation: OperationType,

  /** Index name (case-sensitive). */
  @SerialName(value = "destination") val destination: String,

  /** **Only for copying.**  If you specify a scope, only the selected scopes are copied. Records and the other scopes are left unchanged. If you omit the `scope` parameter, everything is copied: records, settings, synonyms, and rules.  */
  @SerialName(value = "scope") val scope: List<ScopeType>? = null,
)

/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Rule object.
 *
 * @param objectID Unique identifier of a rule object.
 * @param consequence
 * @param conditions Conditions that trigger a rule.  Some consequences require specific conditions or don't require any condition. For more information, see [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions).
 * @param description Description of the rule's purpose to help you distinguish between different rules.
 * @param enabled Whether the rule is active.
 * @param validity Time periods when the rule is active.
 */
@Serializable
public data class Rule(

  /** Unique identifier of a rule object. */
  @SerialName(value = "objectID") val objectID: String,

  @SerialName(value = "consequence") val consequence: Consequence,

  /** Conditions that trigger a rule.  Some consequences require specific conditions or don't require any condition. For more information, see [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions).  */
  @SerialName(value = "conditions") val conditions: List<Condition>? = null,

  /** Description of the rule's purpose to help you distinguish between different rules. */
  @SerialName(value = "description") val description: String? = null,

  /** Whether the rule is active. */
  @SerialName(value = "enabled") val enabled: Boolean? = null,

  /** Time periods when the rule is active. */
  @SerialName(value = "validity") val validity: List<TimeRange>? = null,
)

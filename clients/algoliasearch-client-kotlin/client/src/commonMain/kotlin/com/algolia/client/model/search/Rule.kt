/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Rule object.
 *
 * @param objectID Unique identifier for a rule object.
 * @param conditions [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions) required to activate a rule. You can use up to 25 conditions per rule.
 * @param consequence
 * @param description Description of the rule's purpose. This can be helpful for display in the Algolia dashboard.
 * @param enabled Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time.
 * @param validity If you specify a validity period, the rule _only_ applies only during that period. If specified, the array must not be empty.
 */
@Serializable
public data class Rule(

  /** Unique identifier for a rule object. */
  @SerialName(value = "objectID") val objectID: String,

  /** [Conditions](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#conditions) required to activate a rule. You can use up to 25 conditions per rule.  */
  @SerialName(value = "conditions") val conditions: List<Condition>? = null,

  @SerialName(value = "consequence") val consequence: Consequence? = null,

  /** Description of the rule's purpose. This can be helpful for display in the Algolia dashboard. */
  @SerialName(value = "description") val description: String? = null,

  /** Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time. */
  @SerialName(value = "enabled") val enabled: Boolean? = null,

  /** If you specify a validity period, the rule _only_ applies only during that period. If specified, the array must not be empty. */
  @SerialName(value = "validity") val validity: List<TimeRange>? = null,
)

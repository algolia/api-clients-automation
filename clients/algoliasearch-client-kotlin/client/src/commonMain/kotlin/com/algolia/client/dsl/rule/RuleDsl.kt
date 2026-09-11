@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.rule

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.generated.ConditionBuilder
import com.algolia.client.dsl.generated.ConsequenceBuilder
import com.algolia.client.dsl.generated.ConsequenceParamsBuilder
import com.algolia.client.dsl.generated.RuleBuilder
import com.algolia.client.model.search.Condition
import com.algolia.client.model.search.Consequence
import com.algolia.client.model.search.ConsequenceHide
import com.algolia.client.model.search.ConsequenceQuery
import com.algolia.client.model.search.ConsequenceRedirect
import com.algolia.client.model.search.Promote
import com.algolia.client.model.search.PromoteObjectID
import com.algolia.client.model.search.PromoteObjectIDs
import com.algolia.client.model.search.Rule

/**
 * Constructs a [Rule] from the generated [RuleBuilder].
 *
 * [Rule.objectID] is required. Set it in the block, or pass it to [rule]. An omitted [consequence]
 * becomes an empty [Consequence]. Last write wins on each builder property.
 *
 * ```
 * val built =
 *   rule("promo-iphone") {
 *     condition {
 *       pattern = "smartphone"
 *       anchoring = Anchoring.Is
 *     }
 *     consequence {
 *       params {
 *         query("iphone")
 *         filters { facet("brand", "Apple") }
 *       }
 *       promote("object-1", position = 0)
 *     }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun rule(block: RuleBuilder.() -> Unit): Rule =
  RuleBuilder().apply(block).apply { if (consequence == null) consequence = Consequence() }.build()

/**
 * Constructs a [Rule] with [objectID] already set.
 *
 * The [block] may overwrite [RuleBuilder.objectID]. Last write wins.
 *
 * ```
 * val built = rule("promo-iphone") { consequence { hide("object-9") } }
 * ```
 */
@AlgoliaExperimentalDsl
public fun rule(objectID: String, block: RuleBuilder.() -> Unit = {}): Rule = rule {
  this.objectID = objectID
  block()
}

/**
 * Sets [RuleBuilder.condition] from a [ConditionBuilder] block.
 *
 * Last write wins: this replaces any earlier [RuleBuilder.condition] value.
 */
@AlgoliaExperimentalDsl
public fun RuleBuilder.condition(block: ConditionBuilder.() -> Unit) {
  condition = ConditionBuilder().apply(block).build()
}

/**
 * Sets [RuleBuilder.conditions] from a [ConditionsDsl] block.
 *
 * Last write wins: this replaces any earlier [RuleBuilder.conditions] value.
 */
@AlgoliaExperimentalDsl
public fun RuleBuilder.conditions(block: ConditionsDsl.() -> Unit) {
  conditions = ConditionsDsl().apply(block).build()
}

/**
 * Sets [RuleBuilder.consequence] from a [ConsequenceBuilder] block.
 *
 * Last write wins: this replaces any earlier [RuleBuilder.consequence] value.
 */
@AlgoliaExperimentalDsl
public fun RuleBuilder.consequence(block: ConsequenceBuilder.() -> Unit) {
  consequence = ConsequenceBuilder().apply(block).build()
}

/** Builds a [List] of [Condition] values. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class ConditionsDsl {
  private val values: MutableList<Condition> = mutableListOf()

  /** Adds a [Condition] from [block]. */
  public fun condition(block: ConditionBuilder.() -> Unit) {
    values += ConditionBuilder().apply(block).build()
  }

  /** Adds [this] condition. */
  public operator fun Condition.unaryPlus() {
    values += this
  }

  internal fun build(): List<Condition> = values.toList()
}

/** Sets [ConditionBuilder.pattern] to `{facet:ATTRIBUTE}` for [attribute]. */
@AlgoliaExperimentalDsl
public fun ConditionBuilder.facetPattern(attribute: String) {
  pattern = "{facet:$attribute}"
}

/**
 * Sets [ConsequenceBuilder.params] from the generated [ConsequenceParamsBuilder].
 *
 * Last write wins: this replaces any earlier [ConsequenceBuilder.params] value.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceBuilder.params(block: ConsequenceParamsBuilder.() -> Unit) {
  params = ConsequenceParamsBuilder().apply(block).build()
}

/** Appends a single-record promotion at [position]. */
@AlgoliaExperimentalDsl
public fun ConsequenceBuilder.promote(objectID: String, position: Int) {
  promote = (promote ?: emptyList()) + Promote.of(PromoteObjectID(objectID, position))
}

/** Appends a group promotion of [objectIDs] at [position]. */
@AlgoliaExperimentalDsl
public fun ConsequenceBuilder.promote(objectIDs: List<String>, position: Int) {
  promote = (promote ?: emptyList()) + Promote.of(PromoteObjectIDs(objectIDs, position))
}

/** Appends a hidden record. */
@AlgoliaExperimentalDsl
public fun ConsequenceBuilder.hide(objectID: String) {
  hide = (hide ?: emptyList()) + ConsequenceHide(objectID)
}

/**
 * Sets [ConsequenceBuilder.redirect] to [indexName].
 *
 * Last write wins: this replaces any earlier [ConsequenceBuilder.redirect] value.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceBuilder.redirect(indexName: String) {
  redirect = ConsequenceRedirect(indexName)
}

/**
 * Sets [ConsequenceParamsBuilder.query] to a replacement query string.
 *
 * Last write wins: this replaces any earlier `query` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.query(value: String) {
  query = ConsequenceQuery.of(value)
}

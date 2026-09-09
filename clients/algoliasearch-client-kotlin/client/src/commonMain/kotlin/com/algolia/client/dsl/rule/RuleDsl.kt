@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.rule

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.filters as buildFilters
import com.algolia.client.dsl.generated.ConsequenceParamsBuilder
import com.algolia.client.model.search.Anchoring
import com.algolia.client.model.search.Condition
import com.algolia.client.model.search.Consequence
import com.algolia.client.model.search.ConsequenceHide
import com.algolia.client.model.search.ConsequenceParams
import com.algolia.client.model.search.ConsequenceQuery
import com.algolia.client.model.search.ConsequenceRedirect
import com.algolia.client.model.search.Promote
import com.algolia.client.model.search.PromoteObjectID
import com.algolia.client.model.search.PromoteObjectIDs
import com.algolia.client.model.search.Rule
import com.algolia.client.model.search.TimeRange
import kotlinx.serialization.json.JsonObject

/**
 * Constructs a [Rule] from the DSL block.
 *
 * [Rule.objectID] is required. Set it in the block, or pass it to [rule]. Last write wins: a later
 * assignment or `condition { }` / `consequence { }` / `conditions { }` call replaces an earlier
 * value for the same field. An omitted [consequence] becomes an empty [Consequence].
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
public fun rule(block: RuleDsl.() -> Unit): Rule = RuleDsl().apply(block).build()

/**
 * Constructs a [Rule] with [objectID] already set.
 *
 * The [block] may overwrite [RuleDsl.objectID]. Last write wins.
 *
 * ```
 * val built = rule("promo-iphone") { consequence { hide("object-9") } }
 * ```
 */
@AlgoliaExperimentalDsl
public fun rule(objectID: String, block: RuleDsl.() -> Unit = {}): Rule =
  RuleDsl()
    .apply {
      this.objectID = objectID
      block()
    }
    .build()

/** Builds a [Rule] with [condition] and [consequence] blocks. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class RuleDsl {
  /** Unique identifier of the rule. Required. */
  public var objectID: String? = null

  /** Description of the rule's purpose. */
  public var description: String? = null

  /** Whether the rule is active. */
  public var enabled: Boolean? = null

  /** Rule scope. */
  public var scope: String? = null

  /** Tags attached to the rule. */
  public var tags: List<String>? = null

  /** Single condition that triggers the rule. Last write wins versus [condition]. */
  public var condition: Condition? = null

  /** Conditions that trigger the rule. Last write wins versus [conditions]. */
  public var conditions: List<Condition>? = null

  /** Effect of the rule. Last write wins versus [consequence]. */
  public var consequence: Consequence? = null

  /** Time periods when the rule is active. */
  public var validity: List<TimeRange>? = null

  /**
   * Sets [condition] from a [ConditionDsl] block.
   *
   * Last write wins: this replaces any earlier [condition] value.
   */
  public fun condition(block: ConditionDsl.() -> Unit) {
    condition = ConditionDsl().apply(block).build()
  }

  /**
   * Sets [conditions] from a [ConditionsDsl] block.
   *
   * Last write wins: this replaces any earlier [conditions] value.
   */
  public fun conditions(block: ConditionsDsl.() -> Unit) {
    conditions = ConditionsDsl().apply(block).build()
  }

  /**
   * Sets [consequence] from a [ConsequenceDsl] block.
   *
   * Last write wins: this replaces any earlier [consequence] value.
   */
  public fun consequence(block: ConsequenceDsl.() -> Unit) {
    consequence = ConsequenceDsl().apply(block).build()
  }

  internal fun build(): Rule {
    val id = objectID
    require(!id.isNullOrEmpty()) { "rule { } requires objectID" }
    return Rule(
      objectID = id,
      consequence = consequence ?: Consequence(),
      conditions = conditions,
      description = description,
      enabled = enabled,
      validity = validity,
      tags = tags,
      scope = scope,
      condition = condition,
    )
  }
}

/** Builds a [Condition] that triggers a [Rule]. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class ConditionDsl {
  /**
   * Query pattern that triggers the rule. A literal string, or `{facet:ATTRIBUTE}` from
   * [facetPattern].
   */
  public var pattern: String? = null

  /** Which part of the query [pattern] must match. */
  public var anchoring: Anchoring? = null

  /** Whether the pattern should match plurals, synonyms, and typos. */
  public var alternatives: Boolean? = null

  /** Extra restriction that must match `ruleContexts`. */
  public var context: String? = null

  /** Filters that trigger the rule, as a SQL string. Last write wins versus [filters]. */
  public var filters: String? = null

  /** Sets [pattern] to `{facet:ATTRIBUTE}` for [attribute]. */
  public fun facetPattern(attribute: String) {
    pattern = "{facet:$attribute}"
  }

  /**
   * Sets [filters] from a typed filter block as a SQL string.
   *
   * Last write wins: this replaces any earlier [filters] value.
   */
  public fun filters(block: FilterDsl.() -> Unit) {
    filters = buildFilters(block).asSql()
  }

  internal fun build(): Condition =
    Condition(
      pattern = pattern,
      anchoring = anchoring,
      alternatives = alternatives,
      context = context,
      filters = filters,
    )
}

/** Builds a [List] of [Condition] values. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class ConditionsDsl {
  private val values: MutableList<Condition> = mutableListOf()

  /** Adds a [Condition] from [block]. */
  public fun condition(block: ConditionDsl.() -> Unit) {
    values += ConditionDsl().apply(block).build()
  }

  /** Adds [this] condition. */
  public operator fun Condition.unaryPlus() {
    values += this
  }

  internal fun build(): List<Condition> = values.toList()
}

/** Builds a [Consequence] for a [Rule]. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class ConsequenceDsl {
  /**
   * Query parameters applied by the rule. Last write wins versus [params].
   *
   * Assign a ready [ConsequenceParams], or build one with [params].
   */
  public var params: ConsequenceParams? = null

  /** Promoted records. [promote] appends. Assigning this property replaces the list. */
  public var promote: List<Promote>? = null

  /** Whether promoted records must also match active filters. */
  public var filterPromotes: Boolean? = null

  /** Hidden records. [hide] appends. Assigning this property replaces the list. */
  public var hide: List<ConsequenceHide>? = null

  /** Redirect to a virtual replica. Last write wins versus [redirect]. */
  public var redirect: ConsequenceRedirect? = null

  /** Custom data appended to the response `userData` array. */
  public var userData: JsonObject? = null

  /**
   * Sets [params] from the generated [ConsequenceParamsBuilder].
   *
   * Last write wins: this replaces any earlier [params] value. Use [filters] and the other filter
   * helpers on the builder for typed filter blocks.
   */
  public fun params(block: ConsequenceParamsBuilder.() -> Unit) {
    params = ConsequenceParamsBuilder().apply(block).build()
  }

  /** Appends a single-record promotion at [position]. */
  public fun promote(objectID: String, position: Int) {
    promote = (promote ?: emptyList()) + Promote.of(PromoteObjectID(objectID, position))
  }

  /** Appends a group promotion of [objectIDs] at [position]. */
  public fun promote(objectIDs: List<String>, position: Int) {
    promote = (promote ?: emptyList()) + Promote.of(PromoteObjectIDs(objectIDs, position))
  }

  /** Appends a hidden record. */
  public fun hide(objectID: String) {
    hide = (hide ?: emptyList()) + ConsequenceHide(objectID)
  }

  /**
   * Sets [redirect] to [indexName].
   *
   * Last write wins: this replaces any earlier [redirect] value.
   */
  public fun redirect(indexName: String) {
    redirect = ConsequenceRedirect(indexName)
  }

  internal fun build(): Consequence =
    Consequence(
      params = params,
      promote = promote,
      filterPromotes = filterPromotes,
      hide = hide,
      redirect = redirect,
      userData = userData,
    )
}

/**
 * Sets [ConsequenceParamsBuilder.filters] from a typed filter block as a SQL string.
 *
 * Last write wins: this replaces any earlier `filters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.filters(block: FilterDsl.() -> Unit) {
  filters = buildFilters(block).asSql()
}

/**
 * Sets [ConsequenceParamsBuilder.facetFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `facetFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.facetFilters(block: FilterDsl.() -> Unit) {
  facetFilters = buildFilters(block).asFacetFilters()
}

/**
 * Sets [ConsequenceParamsBuilder.optionalFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `optionalFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.optionalFilters(block: FilterDsl.() -> Unit) {
  optionalFilters = buildFilters(block).asOptionalFilters()
}

/**
 * Sets [ConsequenceParamsBuilder.numericFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `numericFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.numericFilters(block: FilterDsl.() -> Unit) {
  numericFilters = buildFilters(block).asNumericFilters()
}

/**
 * Sets [ConsequenceParamsBuilder.tagFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `tagFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun ConsequenceParamsBuilder.tagFilters(block: FilterDsl.() -> Unit) {
  tagFilters = buildFilters(block).asTagFilters()
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

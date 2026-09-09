@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.NumericFilters
import com.algolia.client.model.search.OptionalFilters
import com.algolia.client.model.search.TagFilters

/**
 * Builds a typed [FilterGroup] tree with a Kotlin DSL.
 *
 * Top-level children are combined with [FilterGroup.And]. [or] is untyped: mixed-family children
 * compile, and [FilterSqlConverter] / [FilterLegacyConverter] throw [IllegalArgumentException] at
 * conversion time. The builder does not merge or drop illegal `Or` children.
 *
 * ```
 * val built =
 *   filters {
 *     and {
 *       facet("color", "red")
 *       facet("category", "shirt")
 *     }
 *     or {
 *       range("price", 0 until 10)
 *       comparison("price", NumericOperator.Equals, 15)
 *     }
 *   }
 * val sql = built.asSql()
 * val facetFilters = built.asFacetFilters()
 * ```
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FilterDsl {
  private val children: MutableList<FilterGroup> = mutableListOf()

  /** Adds an [FilterGroup.And] of the children in [block]. */
  public fun and(block: FilterDsl.() -> Unit) {
    children += FilterGroup.And(FilterDsl().apply(block).snapshot())
  }

  /**
   * Adds an untyped [FilterGroup.Or] of the children in [block].
   *
   * Converters reject mixed families and nested `And` / `Or`.
   */
  public fun or(block: FilterDsl.() -> Unit) {
    children += FilterGroup.Or(FilterDsl().apply(block).snapshot())
  }

  /**
   * Adds a [FilterGroup.Not] of the children in [block].
   *
   * One child is negated as-is. Several children are negated as an [FilterGroup.And].
   */
  public fun not(block: FilterDsl.() -> Unit) {
    children += FilterGroup.Not(FilterDsl().apply(block).asNode())
  }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: String, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Boolean, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Number, score: Int? = null): Filter.Facet =
    Filter.Facet(attribute, value, score).also { children += it }

  /** Adds a [Filter.Tag] for [value]. */
  public fun tag(value: String): Filter.Tag = Filter.Tag(value).also { children += it }

  /** Adds a [Filter.Range] on [attribute] between [lowerBound] and [upperBound], inclusive. */
  public fun range(attribute: String, lowerBound: Number, upperBound: Number): Filter.Range =
    Filter.Range(attribute, lowerBound, upperBound).also { children += it }

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: IntRange): Filter.Range =
    Filter.Range(attribute, range).also { children += it }

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: LongRange): Filter.Range =
    Filter.Range(attribute, range).also { children += it }

  /** Adds a [Filter.Comparison] of [attribute] against [value] with [operator]. */
  public fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
  ): Filter.Comparison = Filter.Comparison(attribute, operator, value).also { children += it }

  internal fun build(): Filters = Filters(asNode())

  private fun snapshot(): List<FilterGroup> = children.toList()

  private fun asNode(): FilterGroup =
    when (children.size) {
      0 -> FilterGroup.And()
      1 -> children.single()
      else -> FilterGroup.And(children.toList())
    }
}

/**
 * A [FilterGroup] tree plus converters to the SQL `filters` string and the legacy oneOf wrappers.
 *
 * Empty [FilterGroup.And] / [FilterGroup.Or] convert to `null`. Mixed-family [FilterGroup.Or]
 * throws at conversion time.
 */
@AlgoliaExperimentalDsl
public class Filters(public val group: FilterGroup) {

  /** SQL `filters` string, or `null` when [group] is an empty And / Or. */
  public fun asSql(): String? = FilterSqlConverter(group)

  /** Legacy [FacetFilters] for [Filter.Facet] leaves, or `null` when none remain. */
  public fun asFacetFilters(): FacetFilters? = FilterLegacyConverter.facet(group)

  /** Legacy [OptionalFilters] for [Filter.Facet] leaves, or `null` when none remain. */
  public fun asOptionalFilters(): OptionalFilters? = FilterLegacyConverter.optional(group)

  /** Legacy [NumericFilters] for numeric leaves, or `null` when none remain. */
  public fun asNumericFilters(): NumericFilters? = FilterLegacyConverter.numeric(group)

  /** Legacy [TagFilters] for [Filter.Tag] leaves, or `null` when none remain. */
  public fun asTagFilters(): TagFilters? = FilterLegacyConverter.tag(group)
}

/** Constructs a [Filters] value from the DSL block. */
@AlgoliaExperimentalDsl
public fun filters(block: FilterDsl.() -> Unit): Filters = FilterDsl().apply(block).build()

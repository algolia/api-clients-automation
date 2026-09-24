@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

internal class FilterAccumulator<N : FilterGroup> {
  private val children: MutableList<N> = mutableListOf()

  fun add(node: N) {
    children += node
  }

  fun snapshot(): List<N> = children.toList()

  /** 0 -> And(), 1 -> single, n -> And(list). Only meaningful for N = FilterGroup. */
  fun root(): FilterGroup =
    when (children.size) {
      0 -> FilterGroup.And()
      1 -> children.single()
      else -> FilterGroup.And(children.map { it })
    }
}

/** Facet leaf constructors shared by [DSLFilters], [DSLFacetFilters], and [DSLGroupFacet]. */
@AlgoliaExperimentalDsl
public sealed interface DSLFacet {
  /**
   * Adds a [Filter.Facet] on [attribute] equal to [value].
   *
   * A non-null [score] is emitted as `<score=N>`, including `0`. With `getRankingInfo`, the engine
   * reports the maximum score inside an `OR` group and the sum across `AND`ed filters, in both
   * `filters` and `optionalFilters`. The DSL never rejects a score. [isNegated] sets
   * [Filter.negated]. Pass it by name: `facet("a", "b", isNegated = true)`. The third positional
   * argument is [score].
   */
  public fun facet(
    attribute: String,
    value: String,
    score: Int? = null,
    isNegated: Boolean = false,
  ): Unit

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. Same [score] / [isNegated] rules. */
  public fun facet(
    attribute: String,
    value: Boolean,
    score: Int? = null,
    isNegated: Boolean = false,
  ): Unit

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. Same [score] / [isNegated] rules. */
  public fun facet(
    attribute: String,
    value: Number,
    score: Int? = null,
    isNegated: Boolean = false,
  ): Unit
}

/** Tag leaf constructors shared by [DSLFilters] and [DSLGroupTag]. */
@AlgoliaExperimentalDsl
public sealed interface DSLTag {
  /** Adds a [Filter.Tag] for [value]. [isNegated] sets [Filter.negated]. */
  public fun tag(value: String, isNegated: Boolean = false): Unit
}

/** Numeric leaf constructors shared by [DSLFilters] and [DSLGroupNumeric]. */
@AlgoliaExperimentalDsl
public sealed interface DSLNumeric {
  /** Adds a [Filter.Range] on [attribute] between [lowerBound] and [upperBound], inclusive. */
  public fun range(
    attribute: String,
    lowerBound: Number,
    upperBound: Number,
    isNegated: Boolean = false,
  ): Unit

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: IntRange, isNegated: Boolean = false): Unit

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: LongRange, isNegated: Boolean = false): Unit

  /** Adds a [Filter.Comparison] of [attribute] against [value] with [operator]. */
  public fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
    isNegated: Boolean = false,
  ): Unit
}

internal class FacetLeafMixin(private val sink: (Filter.Facet) -> Unit) : DSLFacet {
  override fun facet(attribute: String, value: String, score: Int?, isNegated: Boolean) {
    sink(Filter.Facet(attribute, value, score, isNegated))
  }

  override fun facet(attribute: String, value: Boolean, score: Int?, isNegated: Boolean) {
    sink(Filter.Facet(attribute, value, score, isNegated))
  }

  override fun facet(attribute: String, value: Number, score: Int?, isNegated: Boolean) {
    sink(Filter.Facet(attribute, value, score, isNegated))
  }
}

internal class TagLeafMixin(private val sink: (Filter.Tag) -> Unit) : DSLTag {
  override fun tag(value: String, isNegated: Boolean) {
    sink(Filter.Tag(value, isNegated))
  }
}

internal class NumericLeafMixin(private val sink: (Filter.Numeric) -> Unit) : DSLNumeric {
  override fun range(
    attribute: String,
    lowerBound: Number,
    upperBound: Number,
    isNegated: Boolean,
  ) {
    sink(Filter.Range(attribute, lowerBound, upperBound, isNegated))
  }

  override fun range(attribute: String, range: IntRange, isNegated: Boolean) {
    sink(Filter.Range(attribute, range, isNegated))
  }

  override fun range(attribute: String, range: LongRange, isNegated: Boolean) {
    sink(Filter.Range(attribute, range, isNegated))
  }

  override fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
    isNegated: Boolean,
  ) {
    sink(Filter.Comparison(attribute, operator, value, isNegated))
  }
}

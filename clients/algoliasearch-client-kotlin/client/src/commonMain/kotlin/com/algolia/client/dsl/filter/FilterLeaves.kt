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

/** Facet leaf constructors shared by [FilterDsl], [FacetFilterDsl], and [FacetOrDsl]. */
@AlgoliaExperimentalDsl
public sealed interface FacetLeaves {
  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: String, score: Int? = null): Filter.Facet

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Boolean, score: Int? = null): Filter.Facet

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Number, score: Int? = null): Filter.Facet
}

/** Tag leaf constructors shared by [FilterDsl], [TagFilterDsl], and [TagOrDsl]. */
@AlgoliaExperimentalDsl
public sealed interface TagLeaves {
  /** Adds a [Filter.Tag] for [value]. */
  public fun tag(value: String): Filter.Tag
}

/** Numeric leaf constructors shared by [FilterDsl], [NumericFilterDsl], and [NumericOrDsl]. */
@AlgoliaExperimentalDsl
public sealed interface NumericLeaves {
  /** Adds a [Filter.Range] on [attribute] between [lowerBound] and [upperBound], inclusive. */
  public fun range(attribute: String, lowerBound: Number, upperBound: Number): Filter.Range

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: IntRange): Filter.Range

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: LongRange): Filter.Range

  /** Adds a [Filter.Comparison] of [attribute] against [value] with [operator]. */
  public fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
  ): Filter.Comparison
}

internal class FacetLeafMixin(private val sink: (Filter.Facet) -> Unit) : FacetLeaves {
  override fun facet(attribute: String, value: String, score: Int?): Filter.Facet =
    Filter.Facet(attribute, value, score).also(sink)

  override fun facet(attribute: String, value: Boolean, score: Int?): Filter.Facet =
    Filter.Facet(attribute, value, score).also(sink)

  override fun facet(attribute: String, value: Number, score: Int?): Filter.Facet =
    Filter.Facet(attribute, value, score).also(sink)
}

internal class TagLeafMixin(private val sink: (Filter.Tag) -> Unit) : TagLeaves {
  override fun tag(value: String): Filter.Tag = Filter.Tag(value).also(sink)
}

internal class NumericLeafMixin(private val sink: (Filter.Numeric) -> Unit) : NumericLeaves {
  override fun range(attribute: String, lowerBound: Number, upperBound: Number): Filter.Range =
    Filter.Range(attribute, lowerBound, upperBound).also(sink)

  override fun range(attribute: String, range: IntRange): Filter.Range =
    Filter.Range(attribute, range).also(sink)

  override fun range(attribute: String, range: LongRange): Filter.Range =
    Filter.Range(attribute, range).also(sink)

  override fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
  ): Filter.Comparison = Filter.Comparison(attribute, operator, value).also(sink)
}

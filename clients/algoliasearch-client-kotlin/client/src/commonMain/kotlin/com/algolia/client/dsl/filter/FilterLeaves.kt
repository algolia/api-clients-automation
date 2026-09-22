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
  public fun facet(attribute: String, value: String, score: Int? = null): Unit

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Boolean, score: Int? = null): Unit

  /** Adds a [Filter.Facet] on [attribute] equal to [value]. */
  public fun facet(attribute: String, value: Number, score: Int? = null): Unit
}

/** Tag leaf constructors shared by [FilterDsl], [TagFilterDsl], and [TagOrDsl]. */
@AlgoliaExperimentalDsl
public sealed interface TagLeaves {
  /** Adds a [Filter.Tag] for [value]. */
  public fun tag(value: String): Unit
}

/** Numeric leaf constructors shared by [FilterDsl], [NumericFilterDsl], and [NumericOrDsl]. */
@AlgoliaExperimentalDsl
public sealed interface NumericLeaves {
  /** Adds a [Filter.Range] on [attribute] between [lowerBound] and [upperBound], inclusive. */
  public fun range(attribute: String, lowerBound: Number, upperBound: Number): Unit

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: IntRange): Unit

  /** Adds a [Filter.Range] on [attribute] covering [range], inclusive. */
  public fun range(attribute: String, range: LongRange): Unit

  /** Adds a [Filter.Comparison] of [attribute] against [value] with [operator]. */
  public fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
  ): Unit
}

internal class FacetLeafMixin(private val sink: (Filter.Facet) -> Unit) : FacetLeaves {
  override fun facet(attribute: String, value: String, score: Int?) {
    sink(Filter.Facet(attribute, value, score))
  }

  override fun facet(attribute: String, value: Boolean, score: Int?) {
    sink(Filter.Facet(attribute, value, score))
  }

  override fun facet(attribute: String, value: Number, score: Int?) {
    sink(Filter.Facet(attribute, value, score))
  }
}

internal class TagLeafMixin(private val sink: (Filter.Tag) -> Unit) : TagLeaves {
  override fun tag(value: String) {
    sink(Filter.Tag(value))
  }
}

internal class NumericLeafMixin(private val sink: (Filter.Numeric) -> Unit) : NumericLeaves {
  override fun range(attribute: String, lowerBound: Number, upperBound: Number) {
    sink(Filter.Range(attribute, lowerBound, upperBound))
  }

  override fun range(attribute: String, range: IntRange) {
    sink(Filter.Range(attribute, range))
  }

  override fun range(attribute: String, range: LongRange) {
    sink(Filter.Range(attribute, range))
  }

  override fun comparison(
    attribute: String,
    operator: NumericOperator,
    value: Number,
  ) {
    sink(Filter.Comparison(attribute, operator, value))
  }
}

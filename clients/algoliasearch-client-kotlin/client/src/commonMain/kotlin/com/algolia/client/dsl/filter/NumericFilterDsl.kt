@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/** AND-context builder for numeric leaves and [FilterGroup.Or.Numeric] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericFilterDsl {
  private val children: MutableList<FilterGroup> = mutableListOf()

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

  /** Adds a [FilterGroup.Or.Numeric] of the numeric leaves in [block]. */
  public fun or(block: NumericOrDsl.() -> Unit) {
    children += FilterGroup.Or.Numeric(NumericOrDsl().apply(block).snapshot())
  }

  /** Adds a typed [FilterGroup.Not] of the children in [block]. */
  public fun not(block: NumericFilterDsl.() -> Unit) {
    children += negate(NumericFilterDsl().apply(block).snapshot())
  }

  internal fun build(): Filters = Filters(asNode())

  internal fun snapshot(): List<FilterGroup> = children.toList()

  private fun asNode(): FilterGroup =
    when (children.size) {
      0 -> FilterGroup.And()
      1 -> children.single()
      else -> FilterGroup.And(children.toList())
    }
}

/**
 * OR-context builder for [NumericAtom] children. Exposes only numeric leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericOrDsl {
  private val children: MutableList<NumericAtom> = mutableListOf()

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

  /**
   * Negates every numeric atom collected in [block] and appends each as its own [NumericAtom].
   *
   * An empty [block] appends nothing.
   */
  public fun not(block: NumericOrDsl.() -> Unit) {
    for (atom in NumericOrDsl().apply(block).snapshot()) {
      children += negateNumericAtom(atom)
    }
  }

  internal fun snapshot(): List<NumericAtom> = children.toList()
}

/** Constructs a [Filters] value from a numeric-only DSL block. */
@AlgoliaExperimentalDsl
public fun numericFilters(block: NumericFilterDsl.() -> Unit): Filters =
  NumericFilterDsl().apply(block).build()

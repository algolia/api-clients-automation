package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import kotlin.jvm.JvmInline

/**
 * A single typed filter leaf.
 *
 * Each [Filter] is also a [FilterGroup], so [FilterGroup.And], [FilterGroup.Or], and
 * [FilterGroup.Not] can nest leaves and groups in the same tree.
 *
 * Attributes and facet values are [String]. This is the v3 shape. Version 2 used an `Attribute`
 * wrapper.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/)
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public sealed interface Filter : FilterGroup {

  /**
   * Matches [attribute] to [value] exactly.
   *
   * An optional [score] assigns a priority among several [Facet] filters in the same group.
   * [Filter scoring](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#filters-scoring)
   */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Facet(
    public val attribute: String,
    public val value: String,
    public val score: Int? = null,
  ) : Filter {

    public constructor(
      attribute: String,
      value: Boolean,
      score: Int? = null,
    ) : this(attribute, value.toString(), score)

    public constructor(
      attribute: String,
      value: Number,
      score: Int? = null,
    ) : this(attribute, value.toString(), score)
  }

  /** Filters on a `_tags` value. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  @JvmInline
  public value class Tag(public val value: String) : Filter

  /** Numeric comparison of [attribute] against [value] with [operator]. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Comparison(
    public val attribute: String,
    public val operator: NumericOperator,
    public val value: Number,
  ) : Filter

  /** Numeric range of [attribute] between [lowerBound] and [upperBound], inclusive. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Range(
    public val attribute: String,
    public val lowerBound: Number,
    public val upperBound: Number,
  ) : Filter {

    public constructor(
      attribute: String,
      range: IntRange,
    ) : this(attribute, range.first, range.last)

    public constructor(
      attribute: String,
      range: LongRange,
    ) : this(attribute, range.first, range.last)
  }
}

/** Operator for [Filter.Comparison]. Mirrors version 2 `NumericOperator`. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public enum class NumericOperator(public val raw: String) {
  Less("<"),
  LessOrEquals("<="),
  Equals("="),
  NotEquals("!="),
  GreaterOrEquals(">="),
  Greater(">"),
}

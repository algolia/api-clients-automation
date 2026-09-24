package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import kotlin.jvm.JvmOverloads

/**
 * A single typed filter leaf.
 *
 * Each [Filter] is also a [FilterGroup], so [FilterGroup.And] and [FilterGroup.Or] can nest leaves
 * and groups in the same tree. Leaves carry a [negated] flag toggled by unary `!`;
 * [FilterGroup.Not] negates whole groups; the converters XOR the two.
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
   * `true` when this leaf is negated. Toggle with unary `!` / [not]; set with the `negated`
   * constructor parameter. Converters XOR this with any enclosing [FilterGroup.Not] parity.
   */
  public val negated: Boolean

  /**
   * Matches [attribute] to [value] exactly.
   *
   * A non-null [score] is emitted as `<score=N>`, including `0`. The engine takes the maximum score
   * inside an `OR` group and sums scores across `AND`ed filters, in `filters` and in
   * `optionalFilters`.
   * [Filter scoring](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#filters-scoring)
   */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Facet
  @JvmOverloads
  public constructor(
    public val attribute: String,
    public val value: String,
    public val score: Int? = null,
    override val negated: Boolean = false,
  ) : Filter {

    @JvmOverloads
    public constructor(
      attribute: String,
      value: Boolean,
      score: Int? = null,
      negated: Boolean = false,
    ) : this(attribute, value.toString(), score, negated)

    @JvmOverloads
    public constructor(
      attribute: String,
      value: Number,
      score: Int? = null,
      negated: Boolean = false,
    ) : this(attribute, value.toString(), score, negated)
  }

  /** Filters on a `_tags` value. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Tag
  @JvmOverloads
  public constructor(public val value: String, override val negated: Boolean = false) : Filter

  /**
   * A numeric leaf: [Comparison] or [Range]. The only legal children of [FilterGroup.Or.Numeric].
   */
  @AlgoliaDsl @AlgoliaExperimentalDsl public sealed interface Numeric : Filter

  /** Numeric comparison of [attribute] against [value] with [operator]. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Comparison
  @JvmOverloads
  public constructor(
    public val attribute: String,
    public val operator: NumericOperator,
    public val value: Number,
    override val negated: Boolean = false,
  ) : Numeric

  /** Numeric range of [attribute] between [lowerBound] and [upperBound], inclusive. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Range
  @JvmOverloads
  public constructor(
    public val attribute: String,
    public val lowerBound: Number,
    public val upperBound: Number,
    override val negated: Boolean = false,
  ) : Numeric {

    @JvmOverloads
    public constructor(
      attribute: String,
      range: IntRange,
      negated: Boolean = false,
    ) : this(attribute, range.first, range.last, negated)

    @JvmOverloads
    public constructor(
      attribute: String,
      range: LongRange,
      negated: Boolean = false,
    ) : this(attribute, range.first, range.last, negated)
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

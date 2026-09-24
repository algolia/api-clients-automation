@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.DSLParameters
import kotlin.jvm.JvmOverloads

/**
 * A single typed filter leaf.
 *
 * Each [Filter] is also a [FilterGroup], so [FilterGroup.And] and [FilterGroup.Or] can nest leaves
 * and groups in the same tree. Leaves carry a [negated] flag, set through the `isNegated` argument
 * of the DSL leaf helpers; the converters read it as the leaf's polarity.
 *
 * Attributes and facet values are [String]. This is the v3 shape. Version 2 used an `Attribute`
 * wrapper.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/)
 */
internal sealed interface Filter : FilterGroup {

  /**
   * `true` when this leaf is negated. Set with the `isNegated` argument of the DSL leaf helpers or
   * the `negated` constructor parameter. Converters emit it as the leaf's polarity.
   */
  val negated: Boolean

  /**
   * Matches [attribute] to [value] exactly.
   *
   * A non-null [score] is emitted as `<score=N>`, including `0`. The engine takes the maximum score
   * inside an `OR` group and sums scores across `AND`ed filters, in `filters` and in
   * `optionalFilters`.
   * [Filter scoring](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#filters-scoring)
   */
  data class Facet
  @JvmOverloads
  internal constructor(
    val attribute: String,
    val value: String,
    val score: Int? = null,
    override val negated: Boolean = false,
  ) : Filter {

    @JvmOverloads
    internal constructor(
      attribute: String,
      value: Boolean,
      score: Int? = null,
      negated: Boolean = false,
    ) : this(attribute, value.toString(), score, negated)

    @JvmOverloads
    internal constructor(
      attribute: String,
      value: Number,
      score: Int? = null,
      negated: Boolean = false,
    ) : this(attribute, value.toString(), score, negated)
  }

  /** Filters on a `_tags` value. */
  data class Tag
  @JvmOverloads
  internal constructor(val value: String, override val negated: Boolean = false) : Filter

  /**
   * A numeric leaf: [Comparison] or [Range]. The only legal children of [FilterGroup.Or.Numeric].
   */
  sealed interface Numeric : Filter

  /** Numeric comparison of [attribute] against [value] with [operator]. */
  data class Comparison
  @JvmOverloads
  internal constructor(
    val attribute: String,
    val operator: NumericOperator,
    val value: Number,
    override val negated: Boolean = false,
  ) : Numeric

  /** Numeric range of [attribute] between [lowerBound] and [upperBound], inclusive. */
  data class Range
  @JvmOverloads
  internal constructor(
    val attribute: String,
    val lowerBound: Number,
    val upperBound: Number,
    override val negated: Boolean = false,
  ) : Numeric {

    @JvmOverloads
    internal constructor(
      attribute: String,
      range: IntRange,
      negated: Boolean = false,
    ) : this(attribute, range.first, range.last, negated)

    @JvmOverloads
    internal constructor(
      attribute: String,
      range: LongRange,
      negated: Boolean = false,
    ) : this(attribute, range.first, range.last, negated)
  }
}

/** Operator for [Filter.Comparison]. Mirrors version 2 `NumericOperator`. */
@DSLParameters
@AlgoliaExperimentalDsl
public enum class NumericOperator(public val raw: String) {
  Less("<"),
  LessOrEquals("<="),
  Equals("="),
  NotEquals("!="),
  GreaterOrEquals(">="),
  Greater(">"),
}

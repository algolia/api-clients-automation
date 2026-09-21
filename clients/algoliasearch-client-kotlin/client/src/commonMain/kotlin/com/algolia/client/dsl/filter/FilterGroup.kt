@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * A node in the typed filter tree.
 *
 * [And] stays mixed. [Or] is family typed and holds leaves only: [Or.Facet] holds [Filter.Facet],
 * [Or.Tag] holds [Filter.Tag], [Or.Numeric] holds [Filter.Numeric]. Leaf negation is
 * [Filter.negated]; [Not] negates a group.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/)
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public sealed interface FilterGroup {

  /** Children evaluated with `AND`. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class And(public val children: List<FilterGroup> = emptyList()) : FilterGroup {

    public constructor(vararg children: FilterGroup) : this(children.toList())
  }

  /** Children evaluated with `OR`. Each variant holds one filter family. */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public sealed interface Or : FilterGroup {
    public val children: List<Filter>

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Facet(override val children: List<Filter.Facet> = emptyList()) : Or {
      public constructor(vararg children: Filter.Facet) : this(children.toList())
    }

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Tag(override val children: List<Filter.Tag> = emptyList()) : Or {
      public constructor(vararg children: Filter.Tag) : this(children.toList())
    }

    @AlgoliaDsl
    @AlgoliaExperimentalDsl
    public data class Numeric(override val children: List<Filter.Numeric> = emptyList()) : Or {
      public constructor(vararg children: Filter.Numeric) : this(children.toList())
    }
  }

  /**
   * Negates [child]. Leaves negate themselves with [Filter.negated]; use [Not] for groups.
   *
   * Both converters XOR [Filter.negated] with the number of enclosing [Not] nodes, so `Not(Not(x))`
   * and `Not(leaf.copy(negated = true))` both encode as the positive `x`.
   */
  @AlgoliaDsl
  @AlgoliaExperimentalDsl
  public data class Not(public val child: FilterGroup) : FilterGroup
}

/** Unary `!`. Toggles [Filter.negated]; a second `!` restores the original leaf. */
@AlgoliaExperimentalDsl
public operator fun Filter.Facet.not(): Filter.Facet = copy(negated = !negated)

/** Unary `!`. Toggles [Filter.negated]; a second `!` restores the original leaf. */
@AlgoliaExperimentalDsl public operator fun Filter.Tag.not(): Filter.Tag = copy(negated = !negated)

/** Unary `!`. Toggles [Filter.negated]; a second `!` restores the original leaf. */
@AlgoliaExperimentalDsl
public operator fun Filter.Comparison.not(): Filter.Comparison = copy(negated = !negated)

/** Unary `!`. Toggles [Filter.negated]; a second `!` restores the original leaf. */
@AlgoliaExperimentalDsl
public operator fun Filter.Range.not(): Filter.Range = copy(negated = !negated)

/**
 * Unary `!` on a numeric leaf. Keeps the [Filter.Numeric] static type for [FilterGroup.Or.Numeric].
 */
@AlgoliaExperimentalDsl
public operator fun Filter.Numeric.not(): Filter.Numeric =
  when (this) {
    is Filter.Comparison -> not()
    is Filter.Range -> not()
  }

/** Unary `!` on any leaf. Keeps the [Filter] static type. */
@AlgoliaExperimentalDsl
public operator fun Filter.not(): Filter =
  when (this) {
    is Filter.Facet -> not()
    is Filter.Tag -> not()
    is Filter.Numeric -> not()
  }

/**
 * Unary `!` on any node. A leaf toggles [Filter.negated]; a [FilterGroup.Not] is unwrapped; an
 * [FilterGroup.And] or [FilterGroup.Or] is wrapped in [FilterGroup.Not]. `!!node == node`.
 */
@AlgoliaExperimentalDsl
public operator fun FilterGroup.not(): FilterGroup =
  when (this) {
    is Filter -> not()
    is FilterGroup.Not -> child
    is FilterGroup.And,
    is FilterGroup.Or -> FilterGroup.Not(this)
  }

/**
 * AND-context `not { }`. Always a group [FilterGroup.Not] (a single leaf is wrapped, not
 * flag-toggled). A single [FilterGroup.Not] child is unwrapped so `not { not { … } }` is positive.
 */
internal fun negate(children: List<FilterGroup>): FilterGroup =
  when (children.size) {
    0 -> FilterGroup.Not(FilterGroup.And())
    1 ->
      when (val only = children.single()) {
        is FilterGroup.Not -> only.child
        else -> FilterGroup.Not(only)
      }
    else -> FilterGroup.Not(FilterGroup.And(children))
  }

@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.NumericFilters

/** AND-context builder for numeric leaves and [FilterGroup.Or.Numeric] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericFilterDsl
internal constructor(private val core: FamilyAndBuilder<Filter.Numeric>) :
  NumericLeaves by NumericLeafMixin(core::add) {

  public constructor() : this(FamilyAndBuilder<Filter.Numeric> { FilterGroup.Or.Numeric(it) })

  /** Adds a [FilterGroup.Or.Numeric] of the numeric leaves in [block]. */
  public fun or(block: NumericOrDsl.() -> Unit) {
    core.or(NumericOrDsl().apply(block).snapshot())
  }

  /**
   * Negates the children in [block].
   *
   * One child gets unary `!`: a leaf toggles its [Filter.negated] flag (`not { range("p", 0..1) }`
   * builds the same tree as `!Filter.Range("p", 0..1)`), a nested `not { }` is unwrapped so `not {
   * not { … } }` is the positive node, and an `or { }` group is wrapped in [FilterGroup.Not].
   * Several children are wrapped as [FilterGroup.Not] of an [FilterGroup.And]. An empty block adds
   * nothing. Both encoders emit a toggled leaf and a [FilterGroup.Not] over that leaf identically.
   */
  public fun not(block: NumericFilterDsl.() -> Unit) {
    core.not(NumericFilterDsl().apply(block).core.snapshot())
  }

  internal fun root(): FilterGroup = core.root()
}

/**
 * OR-context builder for [Filter.Numeric] children. Exposes only numeric leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericOrDsl internal constructor(private val core: FamilyOrBuilder<Filter.Numeric>) :
  NumericLeaves by NumericLeafMixin(core::add) {

  public constructor() : this(FamilyOrBuilder<Filter.Numeric> { !it })

  /**
   * Toggles [Filter.negated] on every numeric leaf collected in [block] and appends each one.
   *
   * `not { range(a); comparison(b) }` yields two negated leaves (`NOT a OR NOT b` inside the OR);
   * `not { not { range(a) } }` yields the positive leaf. An empty [block] appends nothing.
   */
  public fun not(block: NumericOrDsl.() -> Unit) {
    core.not(NumericOrDsl().apply(block).snapshot())
  }

  internal fun snapshot(): List<Filter.Numeric> = core.snapshot()
}

/** Constructs [NumericFilters] from a numeric-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun numericFilters(block: NumericFilterDsl.() -> Unit): NumericFilters? =
  FilterLegacyConverter.numeric(NumericFilterDsl().apply(block).root())

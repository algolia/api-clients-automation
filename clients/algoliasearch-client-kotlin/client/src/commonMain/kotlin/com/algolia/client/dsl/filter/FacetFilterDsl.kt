@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.OptionalFilters

/** AND-context builder for [Filter.Facet] leaves and [FilterGroup.Or.Facet] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetFilterDsl internal constructor(private val core: FamilyAndBuilder<Filter.Facet>) :
  FacetLeaves by FacetLeafMixin(core::add) {

  public constructor() : this(FamilyAndBuilder<Filter.Facet> { FilterGroup.Or.Facet(it) })

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. */
  public fun or(block: FacetOrDsl.() -> Unit) {
    core.or(FacetOrDsl().apply(block).snapshot())
  }

  /**
   * Negates the children in [block].
   *
   * One child gets unary `!`: a leaf toggles its [Filter.negated] flag (`not { facet("a", "b") }`
   * builds the same tree as `!Filter.Facet("a", "b")`), a nested `not { }` is unwrapped so `not {
   * not { … } }` is the positive node, and an `or { }` group is wrapped in [FilterGroup.Not].
   * Several children are wrapped as [FilterGroup.Not] of an [FilterGroup.And]. An empty block adds
   * nothing. Both encoders emit a toggled leaf and a [FilterGroup.Not] over that leaf identically.
   */
  public fun not(block: FacetFilterDsl.() -> Unit) {
    core.not(FacetFilterDsl().apply(block).core.snapshot())
  }

  internal fun root(): FilterGroup = core.root()
}

/**
 * OR-context builder for [Filter.Facet] children. Exposes only facet leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetOrDsl internal constructor(private val core: FamilyOrBuilder<Filter.Facet>) :
  FacetLeaves by FacetLeafMixin(core::add) {

  public constructor() : this(FamilyOrBuilder<Filter.Facet> { !it })

  /**
   * Toggles [Filter.negated] on every facet leaf collected in [block] and appends each one.
   *
   * `not { facet(a); facet(b) }` yields two negated leaves (`NOT a OR NOT b` inside the OR); `not {
   * not { facet(a) } }` yields the positive leaf. An empty [block] appends nothing.
   */
  public fun not(block: FacetOrDsl.() -> Unit) {
    core.not(FacetOrDsl().apply(block).snapshot())
  }

  internal fun snapshot(): List<Filter.Facet> = core.snapshot()
}

/** Constructs [FacetFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun facetFilters(block: FacetFilterDsl.() -> Unit): FacetFilters? =
  FilterLegacyConverter.facet(FacetFilterDsl().apply(block).root())

/** Constructs [OptionalFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun optionalFilters(block: FacetFilterDsl.() -> Unit): OptionalFilters? =
  FilterLegacyConverter.optional(FacetFilterDsl().apply(block).root())

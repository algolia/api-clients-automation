@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * AND-context core shared by [FacetFilterDsl], [NumericFilterDsl], and [TagFilterDsl]: a mixed
 * [FilterAccumulator], the family `or { }` wrapper, `not { }` through [negate], and [root]. The
 * public shells keep the typed block receivers and hand this class the collected children.
 */
internal class FamilyAndBuilder<L : Filter>(private val orGroup: (List<L>) -> FilterGroup.Or) {
  private val nodes = FilterAccumulator<FilterGroup>()

  fun add(node: FilterGroup) {
    nodes.add(node)
  }

  /**
   * Adds the family [FilterGroup.Or] built from [leaves]. An empty list still adds an empty group.
   */
  fun or(leaves: List<L>) {
    nodes.add(orGroup(leaves))
  }

  /** AND-context `not { }`: [negate] over [children]; an empty list adds nothing. */
  fun not(children: List<FilterGroup>) {
    negate(children)?.let(nodes::add)
  }

  fun snapshot(): List<FilterGroup> = nodes.snapshot()

  fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context core shared by [FacetOrDsl], [NumericOrDsl], and [TagOrDsl]: a leaf-typed
 * [FilterAccumulator] and a `not { }` that toggles [Filter.negated] on each collected leaf. There
 * is no `or { }`; the enclosing AND-context shell builds the family OR group.
 */
internal class FamilyOrBuilder<L : Filter>(private val toggle: (L) -> L) {
  private val nodes = FilterAccumulator<L>()

  fun add(leaf: L) {
    nodes.add(leaf)
  }

  /** OR-context `not { }`: appends each of [leaves] with [Filter.negated] toggled. */
  fun not(leaves: List<L>) {
    for (leaf in leaves) nodes.add(toggle(leaf))
  }

  fun snapshot(): List<L> = nodes.snapshot()
}

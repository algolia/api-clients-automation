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

  /** Adds the family [FilterGroup.Or] built from [leaves]. An empty list adds nothing. */
  fun or(leaves: List<L>) {
    if (leaves.isNotEmpty()) nodes.add(orGroup(leaves))
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

  /**
   * OR-context `not { }`: appends each of [leaves] with [Filter.negated] toggled through [toggle].
   *
   * An OR has no group to wrap, so negation distributes over the leaves: `not { a; b }` contributes
   * `NOT a OR NOT b`, and `not { not { a } }` contributes the positive `a` because the flag flips
   * twice. An empty list appends nothing. Both encoders emit a toggled leaf and a [FilterGroup.Not]
   * over that leaf identically, so this is the OR-context twin of [negate].
   */
  fun not(leaves: List<L>) {
    for (leaf in leaves) nodes.add(toggle(leaf))
  }

  fun snapshot(): List<L> = nodes.snapshot()
}

@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * AND-context core behind [FacetFilterDsl]: a mixed [FilterAccumulator], the family `and { }` and
 * `or { }` wrappers, and [root]. The public shell keeps the typed block receivers and hands this
 * class the collected children.
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

  /** Adds an [FilterGroup.And] of [children]. An empty list adds nothing. Encoders flatten it. */
  fun and(children: List<FilterGroup>) {
    if (children.isNotEmpty()) nodes.add(FilterGroup.And(children))
  }

  fun snapshot(): List<FilterGroup> = nodes.snapshot()

  fun root(): FilterGroup = nodes.root()
}

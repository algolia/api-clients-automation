package com.algolia.client.dsl.filter

/**
 * Row holder shared by [DSLFilters] and [DSLFacetFilters]: the outer list is `AND`, each inner row
 * is `OR`. An empty row is the sentinel for a group block that added no filter; only the encoders
 * drop it.
 */
internal class FilterRows<L : Filter> {
  private val rows: MutableList<List<L>> = mutableListOf()

  fun add(row: List<L>) {
    rows.add(row)
  }

  /** Flattens [child] into this holder; an empty child adds the empty-row sentinel. */
  fun and(child: FilterRows<L>) {
    if (child.rows.isEmpty()) rows.add(emptyList()) else rows.addAll(child.rows)
  }

  fun addAll(seed: List<List<L>>) {
    rows.addAll(seed)
  }

  fun snapshot(): List<List<L>> = rows.toList()
}

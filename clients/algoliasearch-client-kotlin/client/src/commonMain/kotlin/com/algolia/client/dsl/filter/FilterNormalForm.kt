@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Conjunctive rows of [root]: outer list `AND`, inner list `OR`. Nested `AND`s flatten; empty
 * groups add no row.
 */
internal fun conjunctiveRows(root: FilterGroup): List<List<Filter>> =
  when (root) {
    is Filter -> listOf(listOf(root))
    is FilterGroup.And -> root.children.flatMap(::conjunctiveRows)
    is FilterGroup.Or -> if (root.children.isEmpty()) emptyList() else listOf(root.children)
  }

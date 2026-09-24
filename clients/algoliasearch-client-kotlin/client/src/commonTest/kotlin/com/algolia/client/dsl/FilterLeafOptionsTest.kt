@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FacetOrDsl
import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.not
import com.algolia.client.dsl.filter.optionalFilters
import com.algolia.client.model.search.OptionalFilters
import kotlin.test.Test
import kotlin.test.assertEquals

/** Leaf helper options at the DSL level: `isNegated` on every leaf constructor. */
internal class FilterLeafOptionsTest {

  @Test
  fun isNegatedOnEveryLeaf() {
    val colorRed = Filter.Facet("color", "red")
    val priceUntil10 = Filter.Range("price", 0 until 10)
    val priceEquals15 = Filter.Comparison("price", NumericOperator.Equals, 15)

    assertEquals(!colorRed, FilterDsl().apply { facet("color", "red", isNegated = true) }.root())
    assertEquals(
      !Filter.Facet("available", true),
      FilterDsl().apply { facet("available", true, isNegated = true) }.root(),
    )
    assertEquals(
      !Filter.Facet("count", 10),
      FilterDsl().apply { facet("count", 10, isNegated = true) }.root(),
    )
    assertEquals(!Filter.Tag("a"), FilterDsl().apply { tag("a", isNegated = true) }.root())
    assertEquals(
      !priceUntil10,
      FilterDsl().apply { range("price", 0 until 10, isNegated = true) }.root(),
    )
    assertEquals(
      !Filter.Range("p", 0, 1),
      FilterDsl().apply { range("p", 0, 1, isNegated = true) }.root(),
    )
    assertEquals(
      !Filter.Range("p", 0L..1L),
      FilterDsl().apply { range("p", 0L..1L, isNegated = true) }.root(),
    )
    assertEquals(
      !priceEquals15,
      FilterDsl()
        .apply { comparison("price", NumericOperator.Equals, 15, isNegated = true) }
        .root(),
    )

    // Wire form on both encoders.
    assertEquals("NOT batchId:b-1", filters { facet("batchId", "b-1", isNegated = true) })
    assertEquals(
      listOf(listOf("batchId:-b-1")),
      optionalFilters { facet("batchId", "b-1", isNegated = true) }?.rows(),
    )

    // Full positional form pins the parameter order: (attribute, value, score, isNegated).
    assertEquals("NOT color:red<score=5>", filters { facet("color", "red", 5, true) })
    assertEquals(
      listOf(listOf("color:-red<score=5>")),
      optionalFilters { facet("color", "red", 5, true) }?.rows(),
    )

    // OR-context not { } toggles the flag again: double negation is the positive leaf.
    assertEquals(
      listOf(colorRed),
      FacetOrDsl().apply { not { facet("color", "red", isNegated = true) } }.snapshot(),
    )
  }
}

internal fun OptionalFilters.rows(): List<List<String>> =
  (this as OptionalFilters.ListOfOptionalFiltersValue).value.map { row ->
    (row as OptionalFilters.ListOfOptionalFiltersValue).value.map { cell ->
      (cell as OptionalFilters.StringValue).value
    }
  }

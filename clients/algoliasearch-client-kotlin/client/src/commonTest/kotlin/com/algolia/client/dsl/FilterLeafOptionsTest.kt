@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.optionalFilters
import com.algolia.client.model.search.OptionalFilters
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Leaf helper options at the DSL level: `isNegated` on every leaf constructor, checked on the wire.
 */
internal class FilterLeafOptionsTest {

  @Test
  fun isNegatedOnEveryLeaf() {
    assertEquals("NOT color:red", filters { facet("color", "red", isNegated = true) })
    assertEquals("NOT available:true", filters { facet("available", true, isNegated = true) })
    assertEquals("NOT count:10", filters { facet("count", 10, isNegated = true) })
    assertEquals("NOT _tags:a", filters { tag("a", isNegated = true) })
    assertEquals("NOT price:0 TO 9", filters { range("price", 0 until 10, isNegated = true) })
    assertEquals("NOT p:0 TO 1", filters { range("p", 0, 1, isNegated = true) })
    assertEquals("NOT p:0 TO 1", filters { range("p", 0L..1L, isNegated = true) })
    assertEquals(
      "NOT price = 15",
      filters { comparison("price", NumericOperator.Equals, 15, isNegated = true) },
    )

    // Full positional form pins the parameter order: (attribute, value, score, isNegated).
    assertEquals("NOT color:red<score=5>", filters { facet("color", "red", 5, true) })
    assertEquals(
      listOf(listOf("color:-red<score=5>")),
      optionalFilters { facet("color", "red", 5, true) }?.rows(),
    )

    // Named form on the optionalFilters encoder.
    assertEquals(
      listOf(listOf("batchId:-b-1")),
      optionalFilters { facet("batchId", "b-1", isNegated = true) }?.rows(),
    )
  }
}

internal fun OptionalFilters.rows(): List<List<String>> =
  (this as OptionalFilters.ListOfOptionalFiltersValue).value.map { row ->
    (row as OptionalFilters.ListOfOptionalFiltersValue).value.map { cell ->
      (cell as OptionalFilters.StringValue).value
    }
  }

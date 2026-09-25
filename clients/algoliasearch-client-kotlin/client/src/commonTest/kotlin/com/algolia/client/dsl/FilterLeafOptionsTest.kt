@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.optionalFilters
import com.algolia.client.model.search.OptionalFilters
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Leaf helper options at the DSL level, checked on the wire: `isNegated` on every leaf constructor,
 * and the quoting/escaping edges of the `filters` and `optionalFilters` encoders that the live
 * matrix never sends (the engine would reject or silently ignore them).
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

  @Test
  fun encodingEdgesLiveNeverSends() {
    // `filters`: values and attributes that need quotes (whitespace, operator keywords, embedded
    // quotes) are quoted by FilterQuote; embedded `"` is backslash-escaped.
    assertEquals("author:\"John Doe\"", filters { facet("author", "John Doe") })
    assertEquals("title:\"foo AND bar\"", filters { facet("title", "foo AND bar") })
    assertEquals("title:\"foo OR bar\"", filters { facet("title", "foo OR bar") })
    assertEquals("title:\"NOT bar\"", filters { facet("title", "NOT bar") })
    assertEquals("_tags:\"45\\\"-50\\\" tv's\"", filters { tag("45\"-50\" tv's") })
    assertEquals("\"my attr\":red", filters { facet("my attr", "red") })
    assertEquals(
      "\"my attr\" = 15",
      filters { comparison("my attr", NumericOperator.Equals, 15) },
    )

    // Anything outside ASCII letters, digits, `_`, `.`, `-` is quoted; `\` and `"` are escaped.
    assertEquals("v:a.b-c_1", filters { facet("v", "a.b-c_1") })
    assertEquals("v:\"\"", filters { facet("v", "") })
    assertEquals("v:\"TO\"", filters { facet("v", "TO") })
    assertEquals("v:\"café\"", filters { facet("v", "café") })
    assertEquals("v:\"trail\\\\\"", filters { facet("v", "trail\\") })
    assertEquals("\"a:b\" > 1", filters { comparison("a:b", NumericOperator.Greater, 1) })
    assertEquals("\"a(b)\":0 TO 1", filters { range("a(b)", 0..1) })

    // `optionalFilters` never quotes: a negated value that itself starts with `-` doubles the dash.
    assertEquals(
      listOf(listOf("category:--Movie")),
      optionalFilters { facet("category", "-Movie", isNegated = true) }?.rows(),
    )
  }
}

internal fun OptionalFilters.rows(): List<List<String>> =
  (this as OptionalFilters.ListOfOptionalFiltersValue).value.map { row ->
    (row as OptionalFilters.ListOfOptionalFiltersValue).value.map { cell ->
      (cell as OptionalFilters.StringValue).value
    }
  }

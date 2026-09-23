@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FacetFilterDsl
import com.algolia.client.dsl.filter.FacetOrDsl
import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.facetFilters
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.not
import com.algolia.client.dsl.filter.numericFilters
import com.algolia.client.dsl.filter.optionalFilters
import com.algolia.client.dsl.filter.tagFilters
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Leaf helper options at the DSL level: `isNegated` on every leaf constructor, the family `and { }`
 * block and its flattening in the legacy encoders, `score = 0` versus an omitted score, the
 * legacy-only leading-dash escape, and raw (unquoted) legacy facet values.
 */
internal class FilterLeafOptionsTest {

  @Test
  fun isNegatedOnEveryLeaf() {
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
      facetFilters { facet("batchId", "b-1", isNegated = true) }?.rows(),
    )
    assertEquals(listOf(listOf("-a")), tagFilters { tag("a", isNegated = true) }?.rows())

    // Full positional form pins the parameter order: (attribute, value, score, isNegated).
    assertEquals("NOT color:red<score=5>", filters { facet("color", "red", 5, true) })
    assertEquals(
      listOf(listOf("color:-red<score=5>")),
      facetFilters { facet("color", "red", 5, true) }?.rows(),
    )

    // OR-context not { } toggles the flag again: double negation is the positive leaf.
    assertEquals(
      listOf(colorRed),
      FacetOrDsl().apply { not { facet("color", "red", isNegated = true) } }.snapshot(),
    )
  }

  @Test
  fun familyAndFlattens() {
    assertEquals(
      listOf(
        listOf("genre:comedy<score=500>"),
        listOf("provider:NBC<score=500>"),
        listOf("isFeatured:true<score=500>", "isNew:true"),
      ),
      optionalFilters {
          and {
            facet("genre", "comedy", score = 500)
            facet("provider", "NBC", score = 500)
          }
          or {
            facet("isFeatured", true, score = 500)
            facet("isNew", true)
          }
        }
        ?.rows(),
    )

    // A single and { } child is the root itself; an empty block adds nothing.
    assertEquals(
      FilterGroup.And(colorRed, categoryShirt),
      FacetFilterDsl()
        .apply {
          and {
            facet("color", "red")
            facet("category", "shirt")
          }
        }
        .root(),
    )
    assertEquals(FilterGroup.And(), FacetFilterDsl().apply { and {} }.root())

    assertEquals(
      listOf(listOf("p:0 TO 1"), listOf("q < 5")),
      numericFilters {
          and {
            range("p", 0..1)
            comparison("q", NumericOperator.Less, 5)
          }
        }
        ?.rows(),
    )
    assertEquals(
      listOf(listOf("a"), listOf("b")),
      tagFilters {
          and {
            tag("a")
            tag("b")
          }
        }
        ?.rows(),
    )

    // not { and { a; b } } is De Morgan: one OR row of negated leaves.
    assertEquals(
      listOf(listOf("color:-red", "category:-shirt")),
      facetFilters {
          not {
            and {
              facet("color", "red")
              facet("category", "shirt")
            }
          }
        }
        ?.rows(),
    )
  }

  @Test
  fun scoreZeroAndOmitted() {
    assertEquals(
      listOf(listOf("genre:comedy<score=0>", "provider:NBC")),
      optionalFilters {
          or {
            facet("genre", "comedy", score = 0)
            facet("provider", "NBC")
          }
        }
        ?.rows(),
    )
    assertEquals(
      "(genre:comedy<score=0> OR provider:NBC)",
      filters {
        orFacet {
          facet("genre", "comedy", score = 0)
          facet("provider", "NBC")
        }
      },
    )
  }

  @Test
  fun leadingDashEscapedInLegacyOnly() {
    // Wire: category:\-Movie
    assertEquals(
      listOf(listOf("category:\\-Movie")),
      facetFilters { facet("category", "-Movie") }?.rows(),
    )
    // Negated leading dash is `--`, never `-\-`.
    assertEquals(
      listOf(listOf("category:--Movie")),
      facetFilters { facet("category", "-Movie", isNegated = true) }?.rows(),
    )
    assertEquals(
      listOf(listOf("category:\\-Movie<score=2>")),
      optionalFilters { facet("category", "-Movie", score = 2) }?.rows(),
    )
    // SQL `filters` leaf text is unchanged.
    assertEquals("category:-Movie", filters { facet("category", "-Movie") })
  }

  @Test
  fun legacyValuesAreRaw() {
    // Wire: provider:NBC: Universal "East" — no quoting, no escaping of `:`, spaces, or `"`.
    assertEquals(
      listOf(listOf("provider:NBC: Universal \"East\"")),
      facetFilters { facet("provider", "NBC: Universal \"East\"") }?.rows(),
    )
    assertEquals(
      listOf(listOf("color:navy blue<score=1>")),
      optionalFilters { facet("color", "navy blue", score = 1) }?.rows(),
    )
    // Negative optional filter keeps its score.
    assertEquals(
      listOf(listOf("color:-red<score=2>")),
      optionalFilters { facet("color", "red", score = 2, isNegated = true) }?.rows(),
    )
  }
}

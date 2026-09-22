@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.FilterLegacyConverter
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.facetFilters
import com.algolia.client.dsl.filter.numericFilters
import com.algolia.client.dsl.filter.tagFilters
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

/**
 * Golden vectors and family rules for [FilterLegacyConverter]. Fixtures in
 * FilterConverterFixtures.kt.
 */
internal class FilterLegacyConverterTest {

  @Test
  fun legacyGoldenVectors() {
    legacyVectors.forEach { vector ->
      val actual =
        when (vector.family) {
          Family.Facet -> FilterLegacyConverter.facet(vector.group)?.rows()
          Family.Numeric -> FilterLegacyConverter.numeric(vector.group)?.rows()
          Family.Tag -> FilterLegacyConverter.tag(vector.group)?.rows()
        }
      assertEquals(vector.rows, actual, vector.name)
      if (vector.family == Family.Facet) {
        assertEquals(
          vector.rows,
          FilterLegacyConverter.optional(vector.group)?.rows(),
          "${vector.name} optional",
        )
      }
    }
  }

  @Test
  fun legacyRejectVectors() {
    rejectVectors.forEach { vector ->
      if (vector.legacyFacetThrows) {
        assertFailsWith<IllegalArgumentException>("${vector.name} legacy facet") {
          FilterLegacyConverter.facet(vector.group)
        }
        assertFailsWith<IllegalArgumentException>("${vector.name} legacy optional") {
          FilterLegacyConverter.optional(vector.group)
        }
      }
      if (vector.legacyAllThrow) {
        assertFailsWith<IllegalArgumentException>("${vector.name} legacy numeric") {
          FilterLegacyConverter.numeric(vector.group)
        }
        assertFailsWith<IllegalArgumentException>("${vector.name} legacy tag") {
          FilterLegacyConverter.tag(vector.group)
        }
      }
    }
  }

  @Test
  fun familyHelperOrBuildsFamilyGroup() {
    assertEquals(
      listOf(listOf("\"color\":\"red\"", "\"color\":\"blue\"")),
      facetFilters {
          or {
            facet("color", "red")
            facet("color", "blue")
          }
        }
        ?.rows(),
    )

    assertEquals(
      listOf(listOf("price:0 TO 1", "price != 0")),
      numericFilters {
          or {
            range("price", 0..1)
            comparison("price", NumericOperator.NotEquals, 0)
          }
        }
        ?.rows(),
    )

    assertEquals(
      listOf(listOf("a", "b")),
      tagFilters {
          or {
            tag("a")
            tag("b")
          }
        }
        ?.rows(),
    )

    val mixedAnd = facetFilters {
      facet("color", "red")
      or {
        facet("size", "s")
        facet("size", "m")
      }
    }
    assertEquals(
      listOf(listOf("\"color\":\"red\""), listOf("\"size\":\"s\"", "\"size\":\"m\"")),
      mixedAnd?.rows(),
    )
  }

  @Test
  fun wrongFamilyLeafThrows() {
    assertFailsWith<IllegalArgumentException> {
      FilterLegacyConverter.numeric(Filter.Facet("a", "b"))
    }
    assertFailsWith<IllegalArgumentException> { FilterLegacyConverter.facet(Filter.Tag("t")) }
    assertFailsWith<IllegalArgumentException> {
      FilterLegacyConverter.optional(Filter.Range("p", 0..1))
    }
    assertFailsWith<IllegalArgumentException> {
      FilterLegacyConverter.tag(Filter.Comparison("p", NumericOperator.Less, 1))
    }
    assertFailsWith<IllegalArgumentException> {
      FilterLegacyConverter.facet(FilterGroup.And(Filter.Facet("a", "b"), Filter.Tag("t")))
    }
  }
}

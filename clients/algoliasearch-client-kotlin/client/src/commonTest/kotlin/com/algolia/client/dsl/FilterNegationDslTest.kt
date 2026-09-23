@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FacetFilterDsl
import com.algolia.client.dsl.filter.FacetOrDsl
import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.FilterLegacyConverter
import com.algolia.client.dsl.filter.FilterSqlConverter
import com.algolia.client.dsl.filter.NumericFilterDsl
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.NumericOrDsl
import com.algolia.client.dsl.filter.TagFilterDsl
import com.algolia.client.dsl.filter.TagOrDsl
import com.algolia.client.dsl.filter.facetFilters
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.not
import com.algolia.client.dsl.filter.numericFilters
import com.algolia.client.dsl.filter.optionalFilters
import com.algolia.client.dsl.filter.tagFilters
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

/**
 * `not { }` semantics across the DSL receivers: AND-context tree shape from `negate`, OR-context
 * leaf toggling, unary `!`, and agreement between [FilterSqlConverter] and [FilterLegacyConverter].
 */
internal class FilterNegationDslTest {

  @Test
  fun notEncodingVectors() {
    assertEquals("NOT color:red", filters { not { facet("color", "red") } })
    assertEquals(
      listOf(listOf("\"color\":-\"red\"")),
      facetFilters { not { facet("color", "red") } }?.rows(),
    )

    assertEquals(
      "(color:red OR NOT color:blue)",
      filters {
        orFacet {
          facet("color", "red")
          not { facet("color", "blue") }
        }
      },
    )
    assertEquals(
      listOf(listOf("\"color\":\"red\"", "\"color\":-\"blue\"")),
      facetFilters {
          or {
            facet("color", "red")
            not { facet("color", "blue") }
          }
        }
        ?.rows(),
    )

    assertEquals(
      "NOT (color:red OR color:blue)",
      filters {
        not {
          orFacet {
            facet("color", "red")
            facet("color", "blue")
          }
        }
      },
    )
    assertEquals(
      listOf(listOf("\"color\":-\"red\""), listOf("\"color\":-\"blue\"")),
      facetFilters {
          not {
            or {
              facet("color", "red")
              facet("color", "blue")
            }
          }
        }
        ?.rows(),
    )

    val deMorgan =
      FacetFilterDsl().apply {
        or {
          not {
            facet("color", "red")
            facet("category", "shirt")
          }
        }
      }
    assertEquals(FilterGroup.Or.Facet(!colorRed, !categoryShirt), deMorgan.root())
    assertEquals(
      "(NOT color:red OR NOT category:shirt)",
      filters {
        orFacet {
          not {
            facet("color", "red")
            facet("category", "shirt")
          }
        }
      },
    )
    assertEquals(
      listOf(listOf("\"color\":-\"red\"", "\"category\":-\"shirt\"")),
      facetFilters {
          or {
            not {
              facet("color", "red")
              facet("category", "shirt")
            }
          }
        }
        ?.rows(),
    )
  }

  @Test
  fun doubleNegationIsIdentity() {
    assertEquals(colorRed, colorRed.not().not())
    assertEquals(colorRed, ! !colorRed)
    assertEquals(Filter.Tag("a"), ! !Filter.Tag("a"))
    assertEquals(priceEquals15, ! !priceEquals15)
    assertEquals(priceUntil10, ! !priceUntil10)
    assertEquals(Filter.Facet("color", "red", negated = true), !colorRed)
    assertEquals(colorRed, !Filter.Facet("color", "red", negated = true))

    val g = FilterGroup.And(colorRed, categoryShirt)
    assertEquals(FilterGroup.Not(g), !g)
    assertEquals<FilterGroup>(g, ! !g)
    assertEquals<FilterGroup>(FilterGroup.Not(colorRed).child, !FilterGroup.Not(colorRed))
    // `!!Not(flagged leaf)` is the positive leaf, not the original `Not`.
    assertEquals(colorRed, ! !FilterGroup.Not(!colorRed))
  }

  @Test
  fun andContextNotBuildsGroupNot() {
    assertEquals(!colorRed, FilterDsl().apply { not { facet("color", "red") } }.root())
    assertEquals(colorRed, FilterDsl().apply { not { not { facet("color", "red") } } }.root())
    assertEquals(
      FilterGroup.And(colorRed, categoryShirt),
      FilterDsl()
        .apply {
          not {
            not {
              facet("color", "red")
              facet("category", "shirt")
            }
          }
        }
        .root(),
    )
    assertEquals(
      FilterGroup.Not(FilterGroup.And(!colorRed, categoryShirt)),
      FilterDsl()
        .apply {
          not {
            not { facet("color", "red") }
            facet("category", "shirt")
          }
        }
        .root(),
    )
    assertEquals(
      colorRed,
      FacetFilterDsl().apply { not { not { facet("color", "red") } } }.root(),
    )

    // negate() is shared by every AND-context shell; cover the single-leaf toggle per family.
    assertEquals(!colorRed, FacetFilterDsl().apply { not { facet("color", "red") } }.root())
    assertEquals(
      !priceUntil10,
      NumericFilterDsl().apply { not { range("price", 0 until 10) } }.root(),
    )
    assertEquals(!Filter.Tag("a"), TagFilterDsl().apply { not { tag("a") } }.root())
  }

  @Test
  fun doubleGroupNotAgreesAcrossEncoders() {
    assertEquals(
      "(color:red AND category:shirt)",
      filters {
        not {
          not {
            facet("color", "red")
            facet("category", "shirt")
          }
        }
      },
    )
    assertEquals(
      listOf(listOf("\"color\":\"red\""), listOf("\"category\":\"shirt\"")),
      facetFilters {
          not {
            not {
              facet("color", "red")
              facet("category", "shirt")
            }
          }
        }
        ?.rows(),
    )
    assertEquals(
      listOf(listOf("price:0 TO 10")),
      numericFilters { not { not { range("price", 0..10) } } }?.rows(),
    )
    assertEquals(listOf(listOf("a")), tagFilters { not { not { tag("a") } } }?.rows())

    assertEquals(
      "NOT (NOT color:red AND category:shirt)",
      filters {
        not {
          not { facet("color", "red") }
          facet("category", "shirt")
        }
      },
    )
    assertEquals(
      listOf(listOf("\"color\":\"red\"", "\"category\":-\"shirt\"")),
      facetFilters {
          not {
            not { facet("color", "red") }
            facet("category", "shirt")
          }
        }
        ?.rows(),
    )
  }

  @Test
  fun orContextNotTogglesLeafFlags() {
    assertEquals(
      listOf(!colorRed, !categoryShirt),
      FacetOrDsl()
        .apply {
          not {
            facet("color", "red")
            facet("category", "shirt")
          }
        }
        .snapshot(),
    )
    assertEquals(
      listOf(colorRed),
      FacetOrDsl().apply { not { not { facet("color", "red") } } }.snapshot(),
    )
    assertEquals(
      listOf(Filter.Tag("a", negated = true)),
      TagOrDsl().apply { not { tag("a") } }.snapshot(),
    )
    assertEquals(
      listOf(
        Filter.Range("p", 0..1, negated = true),
        Filter.Comparison("p", NumericOperator.Less, 1, negated = true),
      ),
      NumericOrDsl()
        .apply {
          not {
            range("p", 0..1)
            comparison("p", NumericOperator.Less, 1)
          }
        }
        .snapshot(),
    )
    assertEquals(
      FilterGroup.Or.Facet(!colorRed, !categoryShirt),
      FilterDsl()
        .apply {
          orFacet {
            not {
              facet("color", "red")
              facet("category", "shirt")
            }
          }
        }
        .root(),
    )
  }

  @Test
  fun emptyNotBlock() {
    assertNull(filters { not {} })
    assertNull(facetFilters { not {} })
    assertNull(optionalFilters { not {} })
    assertNull(numericFilters { not {} })
    assertNull(tagFilters { not {} })
    assertNull(filters { not { not {} } })
    assertNull(filters { and { not {} } })

    assertEquals(FilterGroup.And(), FilterDsl().apply { not {} }.root())
    assertEquals(FilterGroup.And(), FacetFilterDsl().apply { not {} }.root())
    assertEquals(FilterGroup.And(), FilterDsl().apply { and { not {} } }.root())

    assertEquals(
      "color:red",
      filters {
        facet("color", "red")
        not {}
      },
    )
    assertEquals(
      colorRed,
      FilterDsl()
        .apply {
          facet("color", "red")
          not {}
        }
        .root(),
    )
    assertEquals(
      listOf(listOf("\"color\":\"red\"")),
      facetFilters {
          facet("color", "red")
          not {}
        }
        ?.rows(),
    )
  }

  @Test
  fun emptyGroupBlocksAddNothing() {
    // Encoders: an empty group under not { } is null on both paths, never a throw.
    assertNull(filters { not { and {} } })
    assertNull(filters { not { orFacet {} } })
    assertNull(filters { not { orTag {} } })
    assertNull(filters { not { orNumeric {} } })
    assertNull(facetFilters { not { or {} } })
    assertNull(optionalFilters { not { or {} } })
    assertNull(numericFilters { not { or {} } })
    assertNull(tagFilters { not { or {} } })

    // Tree: empty and { } / or { } blocks insert no node, so not { } over them has no child.
    assertEquals(FilterGroup.And(), FilterDsl().apply { and {} }.root())
    assertEquals(FilterGroup.And(), FilterDsl().apply { orFacet {} }.root())
    assertEquals(FilterGroup.And(), FilterDsl().apply { not { and {} } }.root())
    assertEquals(FilterGroup.And(), FilterDsl().apply { not { orFacet {} } }.root())
    assertEquals(FilterGroup.And(), FacetFilterDsl().apply { or {} }.root())
    assertEquals(FilterGroup.And(), FacetFilterDsl().apply { not { or {} } }.root())
    assertEquals(FilterGroup.And(), NumericFilterDsl().apply { not { or {} } }.root())
    assertEquals(FilterGroup.And(), TagFilterDsl().apply { not { or {} } }.root())

    // An empty sibling leaves a single leaf as the root, so SQL has no wrapping parentheses.
    assertEquals(
      colorRed,
      FilterDsl()
        .apply {
          facet("color", "red")
          and {}
          not { orFacet {} }
        }
        .root(),
    )
    assertEquals(
      "color:red",
      filters {
        facet("color", "red")
        and {}
        not { orFacet {} }
      },
    )
    assertEquals(
      listOf(listOf("\"color\":\"red\"")),
      facetFilters {
          facet("color", "red")
          or {}
          not { or {} }
        }
        ?.rows(),
    )
  }

  @Test
  fun dslFamilyReceiversBuildTypedGroups() {
    assertEquals(
      FilterGroup.Or.Facet(Filter.Facet("attributeA", 0)),
      FilterDsl().apply { orFacet { facet("attributeA", 0) } }.root(),
    )
    assertEquals(
      FilterGroup.Or.Tag(Filter.Tag("a")),
      FilterDsl().apply { orTag { tag("a") } }.root(),
    )
    assertEquals(
      FilterGroup.Or.Numeric(Filter.Range("attributeA", 0..1)),
      FilterDsl().apply { orNumeric { range("attributeA", 0..1) } }.root(),
    )
  }

  @Test
  fun notAndWithNestedOrRejectsLegacyOnly() {
    assertEquals(
      "NOT ((color:red OR color:blue) AND category:shirt)",
      filters {
        not {
          orFacet {
            facet("color", "red")
            facet("color", "blue")
          }
          facet("category", "shirt")
        }
      },
    )
    assertFailsWith<IllegalArgumentException> {
      facetFilters {
        not {
          or {
            facet("color", "red")
            facet("color", "blue")
          }
          facet("category", "shirt")
        }
      }
    }
  }
}

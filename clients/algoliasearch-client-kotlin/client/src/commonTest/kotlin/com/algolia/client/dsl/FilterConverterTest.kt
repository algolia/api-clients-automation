@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FacetFilterDsl
import com.algolia.client.dsl.filter.FacetOrDsl
import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.FilterLegacyConverter
import com.algolia.client.dsl.filter.FilterSqlConverter
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.NumericOrDsl
import com.algolia.client.dsl.filter.TagOrDsl
import com.algolia.client.dsl.filter.facetFilters
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.not
import com.algolia.client.dsl.filter.numericFilters
import com.algolia.client.dsl.filter.optionalFilters
import com.algolia.client.dsl.filter.tagFilters
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.NumericFilters
import com.algolia.client.model.search.OptionalFilters
import com.algolia.client.model.search.TagFilters
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

/**
 * Golden vectors for [FilterSqlConverter] and [FilterLegacyConverter].
 *
 * SQL quotes only when T5 requires it (space, quote, `AND` / `OR` / `NOT`). Legacy facet rows
 * always quote. Legacy numeric attributes and tag values use the same T5 rule.
 */
internal class FilterConverterTest {

  @Test
  fun sqlGoldenVectors() {
    sqlVectors.forEach { vector ->
      assertEquals(vector.sql, FilterSqlConverter(vector.group), vector.name)
    }
  }

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
  fun rejectVectors() {
    rejectVectors.forEach { vector ->
      assertFailsWith<IllegalArgumentException>(vector.name) { FilterSqlConverter(vector.group) }
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
  fun docsDslVectorsMatchConverters() {
    val sql = filters {
      and {
        facet("color", "red")
        facet("category", "shirt")
      }
      orNumeric {
        range("price", 0 until 10)
        comparison("price", NumericOperator.Equals, 15)
      }
    }
    assertEquals("((color:red AND category:shirt) AND (price:0 TO 9 OR price = 15))", sql)
  }

  private class SqlVector(val name: String, val group: FilterGroup, val sql: String?)

  private enum class Family {
    Facet,
    Numeric,
    Tag,
  }

  private class LegacyVector(
    val name: String,
    val group: FilterGroup,
    val family: Family,
    val rows: List<List<String>>? = null,
  )

  private class RejectVector(
    val name: String,
    val group: FilterGroup,
    val legacyFacetThrows: Boolean = true,
    val legacyAllThrow: Boolean = true,
  )

  private val colorRed = Filter.Facet("color", "red")
  private val colorBlue = Filter.Facet("color", "blue")
  private val categoryShirt = Filter.Facet("category", "shirt")
  private val priceUntil10 = Filter.Range("price", 0 until 10)
  private val priceEquals15 = Filter.Comparison("price", NumericOperator.Equals, 15)

  private val sqlVectors: List<SqlVector> =
    listOf(
      SqlVector("facet", colorRed, "color:red"),
      SqlVector("facet score", Filter.Facet("color", "red", score = 2), "color:red<score=2>"),
      SqlVector("facet boolean", Filter.Facet("available", true), "available:true"),
      SqlVector("facet number", Filter.Facet("count", 10), "count:10"),
      SqlVector("tag", Filter.Tag("featured"), "_tags:featured"),
      SqlVector("range until", priceUntil10, "price:0 TO 9"),
      SqlVector("range inclusive", Filter.Range("price", 0..10), "price:0 TO 10"),
      SqlVector("range float", Filter.Range("price", 0.0, 6.0), "price:0.0 TO 6.0"),
      SqlVector(
        "comparison less",
        Filter.Comparison("price", NumericOperator.Less, 5),
        "price < 5",
      ),
      SqlVector(
        "comparison lessOrEquals",
        Filter.Comparison("price", NumericOperator.LessOrEquals, 5),
        "price <= 5",
      ),
      SqlVector("comparison equals", priceEquals15, "price = 15"),
      SqlVector(
        "comparison notEquals",
        Filter.Comparison("price", NumericOperator.NotEquals, 5),
        "price != 5",
      ),
      SqlVector(
        "comparison greaterOrEquals",
        Filter.Comparison("price", NumericOperator.GreaterOrEquals, 5),
        "price >= 5",
      ),
      SqlVector(
        "comparison greater",
        Filter.Comparison("price", NumericOperator.Greater, 5),
        "price > 5",
      ),
      SqlVector("and", FilterGroup.And(colorRed, categoryShirt), "(color:red AND category:shirt)"),
      SqlVector("or facet", FilterGroup.Or.Facet(colorRed, colorBlue), "(color:red OR color:blue)"),
      SqlVector(
        "or numeric",
        FilterGroup.Or.Numeric(priceUntil10, priceEquals15),
        "(price:0 TO 9 OR price = 15)",
      ),
      SqlVector(
        "or tag",
        FilterGroup.Or.Tag(Filter.Tag("a"), Filter.Tag("b")),
        "(_tags:a OR _tags:b)",
      ),
      SqlVector("not group leaf", FilterGroup.Not(colorRed), "NOT color:red"),
      SqlVector("not unary", colorRed.not(), "NOT color:red"),
      SqlVector("not flag ctor", Filter.Facet("color", "red", negated = true), "NOT color:red"),
      SqlVector(
        "not and",
        FilterGroup.Not(FilterGroup.And(colorRed, categoryShirt)),
        "NOT (color:red AND category:shirt)",
      ),
      SqlVector("not range", !Filter.Range("attributeA", 0..10), "NOT attributeA:0 TO 10"),
      SqlVector(
        "not group range",
        FilterGroup.Not(Filter.Range("attributeA", 0..10)),
        "NOT attributeA:0 TO 10",
      ),
      SqlVector("double not leaf", colorRed.not().not(), "color:red"),
      SqlVector("not of negated leaf", FilterGroup.Not(!colorRed), "color:red"),
      SqlVector(
        "not not and",
        FilterGroup.Not(FilterGroup.Not(FilterGroup.And(colorRed, categoryShirt))),
        "(color:red AND category:shirt)",
      ),
      SqlVector("not not range", FilterGroup.Not(FilterGroup.Not(priceUntil10)), "price:0 TO 9"),
      SqlVector("not of negated range", FilterGroup.Not(!priceUntil10), "price:0 TO 9"),
      SqlVector(
        "not and mixed polarity",
        FilterGroup.Not(FilterGroup.And(!colorRed, categoryShirt)),
        "NOT (NOT color:red AND category:shirt)",
      ),
      SqlVector(
        "or facet negated leaves",
        FilterGroup.Or.Facet(!colorRed, !categoryShirt),
        "(NOT color:red OR NOT category:shirt)",
      ),
      SqlVector("not tag flag", !Filter.Tag("featured"), "NOT _tags:featured"),
      SqlVector("not comparison flag", !priceEquals15, "NOT price = 15"),
      SqlVector("not not empty and", FilterGroup.Not(FilterGroup.Not(FilterGroup.And())), null),
      SqlVector("quote space", Filter.Facet("author", "John Doe"), "author:\"John Doe\""),
      SqlVector("quote AND", Filter.Facet("title", "foo AND bar"), "title:\"foo AND bar\""),
      SqlVector("quote OR", Filter.Facet("title", "foo OR bar"), "title:\"foo OR bar\""),
      SqlVector("quote NOT", Filter.Facet("title", "NOT bar"), "title:\"NOT bar\""),
      SqlVector("quote embedded", Filter.Tag("45\"-50\" tv's"), "_tags:\"45\\\"-50\\\" tv's\""),
      SqlVector("quote attribute space", Filter.Facet("my attr", "red"), "\"my attr\":red"),
      SqlVector("empty and", FilterGroup.And(), null),
      SqlVector("empty or", FilterGroup.Or.Facet(), null),
      SqlVector("empty or tag", FilterGroup.Or.Tag(), null),
      SqlVector("empty or numeric", FilterGroup.Or.Numeric(), null),
      SqlVector("empty dsl", FilterGroup.And(), null),
      SqlVector(
        "docs and+orNumeric",
        FilterGroup.And(
          FilterGroup.And(colorRed, categoryShirt),
          FilterGroup.Or.Numeric(priceUntil10, priceEquals15),
        ),
        "((color:red AND category:shirt) AND (price:0 TO 9 OR price = 15))",
      ),
      SqlVector(
        "optionalFilters docs",
        FilterGroup.And(Filter.Facet("category", "Book"), Filter.Facet("author", "John Doe")),
        "(category:Book AND author:\"John Doe\")",
      ),
    )

  private val legacyVectors: List<LegacyVector> =
    listOf(
      LegacyVector("facet", colorRed, Family.Facet, listOf(listOf("\"color\":\"red\""))),
      LegacyVector(
        "facet score",
        Filter.Facet("color", "red", score = 2),
        Family.Facet,
        listOf(listOf("\"color\":\"red\"<score=2>")),
      ),
      LegacyVector("tag", Filter.Tag("featured"), Family.Tag, listOf(listOf("featured"))),
      LegacyVector("range until", priceUntil10, Family.Numeric, listOf(listOf("price:0 TO 9"))),
      LegacyVector(
        "comparison equals",
        priceEquals15,
        Family.Numeric,
        listOf(listOf("price = 15")),
      ),
      LegacyVector(
        "and facets",
        FilterGroup.And(colorRed, categoryShirt),
        Family.Facet,
        listOf(listOf("\"color\":\"red\""), listOf("\"category\":\"shirt\"")),
      ),
      LegacyVector(
        "or facets",
        FilterGroup.Or.Facet(colorRed, colorBlue),
        Family.Facet,
        listOf(listOf("\"color\":\"red\"", "\"color\":\"blue\"")),
      ),
      LegacyVector(
        "or numeric",
        FilterGroup.Or.Numeric(priceUntil10, priceEquals15),
        Family.Numeric,
        listOf(listOf("price:0 TO 9", "price = 15")),
      ),
      LegacyVector(
        "not facet",
        FilterGroup.Not(colorRed),
        Family.Facet,
        listOf(listOf("\"color\":-\"red\"")),
      ),
      LegacyVector(
        "not facet flag ctor",
        Filter.Facet("color", "red", negated = true),
        Family.Facet,
        listOf(listOf("\"color\":-\"red\"")),
      ),
      LegacyVector(
        "not facet unary",
        !colorRed,
        Family.Facet,
        listOf(listOf("\"color\":-\"red\"")),
      ),
      LegacyVector(
        "not tag",
        !Filter.Tag("featured"),
        Family.Tag,
        listOf(listOf("-featured")),
      ),
      LegacyVector(
        "not tag flag ctor",
        Filter.Tag("featured", negated = true),
        Family.Tag,
        listOf(listOf("-featured")),
      ),
      LegacyVector(
        "not comparison less",
        !Filter.Comparison("attributeA", NumericOperator.Less, 5),
        Family.Numeric,
        listOf(listOf("attributeA >= 5")),
      ),
      LegacyVector(
        "not range",
        !Filter.Range("attributeA", 0..10),
        Family.Numeric,
        listOf(listOf("attributeA < 0", "attributeA > 10")),
      ),
      LegacyVector(
        "double not leaf",
        colorRed.not().not(),
        Family.Facet,
        listOf(listOf("\"color\":\"red\"")),
      ),
      LegacyVector(
        "not of negated leaf",
        FilterGroup.Not(!colorRed),
        Family.Facet,
        listOf(listOf("\"color\":\"red\"")),
      ),
      LegacyVector(
        "not not and",
        FilterGroup.Not(FilterGroup.Not(FilterGroup.And(colorRed, categoryShirt))),
        Family.Facet,
        listOf(listOf("\"color\":\"red\""), listOf("\"category\":\"shirt\"")),
      ),
      LegacyVector(
        "not not range",
        FilterGroup.Not(FilterGroup.Not(Filter.Range("attributeA", 0..10))),
        Family.Numeric,
        listOf(listOf("attributeA:0 TO 10")),
      ),
      LegacyVector(
        "not of negated range",
        FilterGroup.Not(!Filter.Range("attributeA", 0..10)),
        Family.Numeric,
        listOf(listOf("attributeA:0 TO 10")),
      ),
      LegacyVector(
        "not and mixed polarity",
        FilterGroup.Not(FilterGroup.And(!colorRed, categoryShirt)),
        Family.Facet,
        listOf(listOf("\"color\":\"red\"", "\"category\":-\"shirt\"")),
      ),
      LegacyVector(
        "or facet negated leaves",
        FilterGroup.Or.Facet(!colorRed, !categoryShirt),
        Family.Facet,
        listOf(listOf("\"color\":-\"red\"", "\"category\":-\"shirt\"")),
      ),
      LegacyVector(
        "not not empty and",
        FilterGroup.Not(FilterGroup.Not(FilterGroup.And())),
        Family.Facet,
      ),
      LegacyVector(
        "quote space",
        Filter.Facet("author", "John Doe"),
        Family.Facet,
        listOf(listOf("\"author\":\"John Doe\"")),
      ),
      LegacyVector(
        "quote AND",
        Filter.Facet("title", "foo AND bar"),
        Family.Facet,
        listOf(listOf("\"title\":\"foo AND bar\"")),
      ),
      LegacyVector(
        "quote embedded",
        Filter.Tag("45\"-50\" tv's"),
        Family.Tag,
        listOf(listOf("\"45\\\"-50\\\" tv's\"")),
      ),
      LegacyVector("empty and", FilterGroup.And(), Family.Facet),
      LegacyVector("empty or", FilterGroup.Or.Facet(), Family.Facet),
      LegacyVector("empty or tag", FilterGroup.Or.Tag(), Family.Tag),
      LegacyVector("empty or numeric", FilterGroup.Or.Numeric(), Family.Numeric),
      LegacyVector(
        "v2 and+or facets",
        FilterGroup.And(
          FilterGroup.And(
            Filter.Facet("attributeA", "unknown"),
            Filter.Facet("attributeB", "unknown"),
          ),
          FilterGroup.Or.Facet(
            Filter.Facet("attributeA", "unknown"),
            Filter.Facet("attributeB", "unknown"),
          ),
        ),
        Family.Facet,
        listOf(
          listOf("\"attributeA\":\"unknown\""),
          listOf("\"attributeB\":\"unknown\""),
          listOf("\"attributeA\":\"unknown\"", "\"attributeB\":\"unknown\""),
        ),
      ),
      LegacyVector(
        "quote numeric attribute space",
        Filter.Comparison("my attr", NumericOperator.Equals, 15),
        Family.Numeric,
        listOf(listOf("\"my attr\" = 15")),
      ),
      LegacyVector(
        "quote tag space",
        Filter.Tag("foo bar"),
        Family.Tag,
        listOf(listOf("\"foo bar\"")),
      ),
    )

  private val rejectVectors: List<RejectVector> =
    listOf(
      RejectVector(
        "not wrapping empty and",
        FilterGroup.Not(FilterGroup.And()),
        legacyFacetThrows = false,
        legacyAllThrow = false,
      ),
      RejectVector(
        "not wrapping empty or",
        FilterGroup.Not(FilterGroup.Or.Facet()),
        legacyFacetThrows = false,
        legacyAllThrow = false,
      ),
    )

  @Test
  fun v2PortedSqlVectors() {
    // Skip twoAndGroups_OfTheSameType_balanced: version 2 used a Set and collapsed equal groups.
    val vectors =
      listOf(
        Triple(
          "orFacet",
          filters {
            orFacet {
              facet("attributeA", 0)
              facet("attributeA", 1)
            }
          },
          "(attributeA:0 OR attributeA:1)",
        ),
        Triple(
          "orTag",
          filters {
            orTag {
              tag("a")
              tag("b")
            }
          },
          "(_tags:a OR _tags:b)",
        ),
        Triple(
          "orNumeric",
          filters {
            orNumeric {
              range("attributeA", 0..1)
              comparison("attributeA", NumericOperator.NotEquals, 0)
            }
          },
          "(attributeA:0 TO 1 OR attributeA != 0)",
        ),
        Triple(
          "emptyGroups",
          filters {
            and {}
            orFacet {}
          },
          null,
        ),
        Triple(
          "oneOfEveryType",
          filters {
            and { facet("attributeA", 0) }
            orFacet { facet("attributeA", 0) }
            orTag { tag("unknown") }
            orNumeric { range("attributeA", 0..1) }
          },
          "((attributeA:0) AND (attributeA:0) AND (_tags:unknown) AND (attributeA:0 TO 1))",
        ),
        Triple(
          "twoOfEveryType",
          filters {
            and {
              facet("attributeA", 0)
              facet("attributeB", 0)
            }
            orFacet {
              facet("attributeA", 0)
              facet("attributeB", 0)
            }
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
            orNumeric {
              range("attributeA", 0..1)
              comparison("attributeB", NumericOperator.Greater, 0)
            }
          },
          "((attributeA:0 AND attributeB:0) AND (attributeA:0 OR attributeB:0) AND (_tags:attributeA OR _tags:attributeB) AND (attributeA:0 TO 1 OR attributeB > 0))",
        ),
        Triple(
          "singleAndGroups_differentTypes",
          filters {
            and {
              facet("attributeA", 0)
              tag("unknown")
            }
          },
          "(attributeA:0 AND _tags:unknown)",
        ),
        Triple(
          "twoAndGroups_OfDifferentTypes_balanced",
          filters {
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
            orNumeric {
              range("attributeA", 0..1)
              range("attributeB", 0..1)
            }
          },
          "((_tags:attributeA OR _tags:attributeB) AND (attributeA:0 TO 1 OR attributeB:0 TO 1))",
        ),
        Triple(
          "twoAndGroups_OfTheSameType_unbalanced",
          filters {
            orTag { tag("attributeA") }
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
          },
          "((_tags:attributeA) AND (_tags:attributeA OR _tags:attributeB))",
        ),
        Triple(
          "twoAndGroups_OfDifferentTypes_unbalanced",
          filters {
            orTag {
              tag("attributeA")
              tag("attributeB")
            }
            orNumeric { range("attributeA", 0..1) }
          },
          "((_tags:attributeA OR _tags:attributeB) AND (attributeA:0 TO 1))",
        ),
      )
    for ((name, sql, expected) in vectors) {
      assertEquals(expected, sql, name)
    }
  }

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
    assertEquals(
      FilterGroup.Not(colorRed),
      FilterDsl().apply { not { facet("color", "red") } }.root(),
    )
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
      FilterGroup.Not(FilterGroup.And(FilterGroup.Not(colorRed), categoryShirt)),
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

  @Test
  fun sqlAcceptsEveryFamily() {
    assertEquals(
      "(a:b AND _tags:t AND p:0 TO 1)",
      filters {
        facet("a", "b")
        tag("t")
        range("p", 0..1)
      },
    )
  }
}

private fun FacetFilters.rows(): List<List<String>> =
  (this as FacetFilters.ListOfFacetFiltersValue).value.map { row ->
    (row as FacetFilters.ListOfFacetFiltersValue).value.map { cell ->
      (cell as FacetFilters.StringValue).value
    }
  }

private fun OptionalFilters.rows(): List<List<String>> =
  (this as OptionalFilters.ListOfOptionalFiltersValue).value.map { row ->
    (row as OptionalFilters.ListOfOptionalFiltersValue).value.map { cell ->
      (cell as OptionalFilters.StringValue).value
    }
  }

private fun NumericFilters.rows(): List<List<String>> =
  (this as NumericFilters.ListOfNumericFiltersValue).value.map { row ->
    (row as NumericFilters.ListOfNumericFiltersValue).value.map { cell ->
      (cell as NumericFilters.StringValue).value
    }
  }

private fun TagFilters.rows(): List<List<String>> =
  (this as TagFilters.ListOfTagFiltersValue).value.map { row ->
    (row as TagFilters.ListOfTagFiltersValue).value.map { cell ->
      (cell as TagFilters.StringValue).value
    }
  }

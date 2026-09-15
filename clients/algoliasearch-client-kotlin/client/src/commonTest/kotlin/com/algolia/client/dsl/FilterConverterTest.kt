@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.FilterLegacyConverter
import com.algolia.client.dsl.filter.FilterSqlConverter
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.facetFilters
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.not
import com.algolia.client.dsl.filter.numericFilters
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
      assertEquals(
        vector.facet,
        FilterLegacyConverter.facet(vector.group)?.rows(),
        "${vector.name} facet",
      )
      assertEquals(
        vector.facet,
        FilterLegacyConverter.optional(vector.group)?.rows(),
        "${vector.name} optional",
      )
      assertEquals(
        vector.numeric,
        FilterLegacyConverter.numeric(vector.group)?.rows(),
        "${vector.name} numeric",
      )
      assertEquals(
        vector.tag,
        FilterLegacyConverter.tag(vector.group)?.rows(),
        "${vector.name} tag",
      )
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
    val built = filters {
      and {
        facet("color", "red")
        facet("category", "shirt")
      }
      orNumeric {
        range("price", 0 until 10)
        comparison("price", NumericOperator.Equals, 15)
      }
    }
    assertEquals(
      "((color:red AND category:shirt) AND (price:0 TO 9 OR price = 15))",
      built.asSql(),
    )
    assertEquals(FilterSqlConverter(built.group), built.asSql())
    assertEquals(
      listOf(listOf("\"color\":\"red\""), listOf("\"category\":\"shirt\"")),
      built.asFacetFilters()?.rows(),
    )
    assertEquals(
      listOf(listOf("price:0 TO 9", "price = 15")),
      built.asNumericFilters()?.rows(),
    )
    assertNull(built.asTagFilters())
  }

  private class SqlVector(val name: String, val group: FilterGroup, val sql: String?)

  private class LegacyVector(
    val name: String,
    val group: FilterGroup,
    val facet: List<List<String>>? = null,
    val numeric: List<List<String>>? = null,
    val tag: List<List<String>>? = null,
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
      SqlVector("not", FilterGroup.Not.Facet(colorRed), "NOT color:red"),
      SqlVector("not unary", colorRed.not(), "NOT color:red"),
      SqlVector(
        "not and",
        FilterGroup.Not.Group(FilterGroup.And(colorRed, categoryShirt)),
        "NOT (color:red AND category:shirt)",
      ),
      SqlVector(
        "not range",
        FilterGroup.Not.Numeric(Filter.Range("attributeA", 0..10)),
        "NOT attributeA:0 TO 10",
      ),
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
      SqlVector("empty dsl", filters {}.group, null),
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
      LegacyVector("facet", colorRed, facet = listOf(listOf("\"color\":\"red\""))),
      LegacyVector(
        "facet score",
        Filter.Facet("color", "red", score = 2),
        facet = listOf(listOf("\"color\":\"red\"<score=2>")),
      ),
      LegacyVector("tag", Filter.Tag("featured"), tag = listOf(listOf("featured"))),
      LegacyVector("range until", priceUntil10, numeric = listOf(listOf("price:0 TO 9"))),
      LegacyVector(
        "comparison equals",
        priceEquals15,
        numeric = listOf(listOf("price = 15")),
      ),
      LegacyVector(
        "and facets",
        FilterGroup.And(colorRed, categoryShirt),
        facet = listOf(listOf("\"color\":\"red\""), listOf("\"category\":\"shirt\"")),
      ),
      LegacyVector(
        "or facets",
        FilterGroup.Or.Facet(colorRed, colorBlue),
        facet = listOf(listOf("\"color\":\"red\"", "\"color\":\"blue\"")),
      ),
      LegacyVector(
        "or numeric",
        FilterGroup.Or.Numeric(priceUntil10, priceEquals15),
        numeric = listOf(listOf("price:0 TO 9", "price = 15")),
      ),
      LegacyVector(
        "not facet",
        FilterGroup.Not.Facet(colorRed),
        facet = listOf(listOf("\"color\":-\"red\"")),
      ),
      LegacyVector(
        "not tag",
        FilterGroup.Not.Tag(Filter.Tag("featured")),
        tag = listOf(listOf("-featured")),
      ),
      LegacyVector(
        "not comparison less",
        FilterGroup.Not.Numeric(Filter.Comparison("attributeA", NumericOperator.Less, 5)),
        numeric = listOf(listOf("attributeA >= 5")),
      ),
      LegacyVector(
        "not range",
        FilterGroup.Not.Numeric(Filter.Range("attributeA", 0..10)),
        numeric = listOf(listOf("attributeA < 0", "attributeA > 10")),
      ),
      LegacyVector(
        "quote space",
        Filter.Facet("author", "John Doe"),
        facet = listOf(listOf("\"author\":\"John Doe\"")),
      ),
      LegacyVector(
        "quote AND",
        Filter.Facet("title", "foo AND bar"),
        facet = listOf(listOf("\"title\":\"foo AND bar\"")),
      ),
      LegacyVector(
        "quote embedded",
        Filter.Tag("45\"-50\" tv's"),
        tag = listOf(listOf("\"45\\\"-50\\\" tv's\"")),
      ),
      LegacyVector("empty and", FilterGroup.And()),
      LegacyVector("empty or", FilterGroup.Or.Facet()),
      LegacyVector("empty or tag", FilterGroup.Or.Tag()),
      LegacyVector("empty or numeric", FilterGroup.Or.Numeric()),
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
        facet =
          listOf(
            listOf("\"attributeA\":\"unknown\""),
            listOf("\"attributeB\":\"unknown\""),
            listOf("\"attributeA\":\"unknown\"", "\"attributeB\":\"unknown\""),
          ),
      ),
      LegacyVector(
        "family partition and",
        FilterGroup.And(colorRed, priceUntil10, Filter.Tag("featured")),
        facet = listOf(listOf("\"color\":\"red\"")),
        numeric = listOf(listOf("price:0 TO 9")),
        tag = listOf(listOf("featured")),
      ),
      LegacyVector(
        "quote numeric attribute space",
        Filter.Comparison("my attr", NumericOperator.Equals, 15),
        numeric = listOf(listOf("\"my attr\" = 15")),
      ),
      LegacyVector(
        "quote tag space",
        Filter.Tag("foo bar"),
        tag = listOf(listOf("\"foo bar\"")),
      ),
    )

  private val rejectVectors: List<RejectVector> =
    listOf(
      RejectVector(
        "not wrapping empty and",
        FilterGroup.Not.Group(FilterGroup.And()),
        legacyFacetThrows = false,
        legacyAllThrow = false,
      ),
      RejectVector(
        "not wrapping empty or",
        FilterGroup.Not.Group(FilterGroup.Or.Facet()),
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
    for ((name, built, sql) in vectors) {
      assertEquals(sql, built.asSql(), name)
    }
  }

  @Test
  fun notEncodingVectors() {
    val negatedLeaf = filters { not { facet("color", "red") } }
    assertEquals("NOT color:red", negatedLeaf.asSql())
    assertEquals(listOf(listOf("\"color\":-\"red\"")), negatedLeaf.asFacetFilters()?.rows())

    val notInsideOr = filters {
      orFacet {
        facet("color", "red")
        not { facet("color", "blue") }
      }
    }
    assertEquals("(color:red OR NOT color:blue)", notInsideOr.asSql())
    assertEquals(
      listOf(listOf("\"color\":\"red\"", "\"color\":-\"blue\"")),
      notInsideOr.asFacetFilters()?.rows(),
    )

    val orInsideNot = filters {
      not {
        orFacet {
          facet("color", "red")
          facet("color", "blue")
        }
      }
    }
    assertEquals("NOT (color:red OR color:blue)", orInsideNot.asSql())
    assertEquals(
      listOf(listOf("\"color\":-\"red\""), listOf("\"color\":-\"blue\"")),
      orInsideNot.asFacetFilters()?.rows(),
    )

    val deMorgan = filters {
      orFacet {
        not {
          facet("color", "red")
          facet("category", "shirt")
        }
      }
    }
    assertEquals(
      FilterGroup.Or.Facet(FilterGroup.Not.Facet(colorRed), FilterGroup.Not.Facet(categoryShirt)),
      deMorgan.group,
    )
    assertEquals("(NOT color:red OR NOT category:shirt)", deMorgan.asSql())
    assertEquals(
      listOf(listOf("\"color\":-\"red\"", "\"category\":-\"shirt\"")),
      deMorgan.asFacetFilters()?.rows(),
    )
  }

  @Test
  fun dslFamilyReceiversBuildTypedGroups() {
    assertEquals(
      FilterGroup.Or.Facet(Filter.Facet("attributeA", 0)),
      filters { orFacet { facet("attributeA", 0) } }.group,
    )
    assertEquals(
      FilterGroup.Or.Tag(Filter.Tag("a")),
      filters { orTag { tag("a") } }.group,
    )
    assertEquals(
      FilterGroup.Or.Numeric(Filter.Range("attributeA", 0..1)),
      filters { orNumeric { range("attributeA", 0..1) } }.group,
    )
  }

  @Test
  fun familyHelperOrBuildsFamilyGroup() {
    val facets = facetFilters {
      or {
        facet("color", "red")
        facet("color", "blue")
      }
    }
    assertEquals(FilterGroup.Or.Facet(colorRed, colorBlue), facets.group)
    assertEquals(
      listOf(listOf("\"color\":\"red\"", "\"color\":\"blue\"")),
      facets.asFacetFilters()?.rows(),
    )

    val numerics = numericFilters {
      or {
        range("price", 0..1)
        comparison("price", NumericOperator.NotEquals, 0)
      }
    }
    assertEquals(
      listOf(listOf("price:0 TO 1", "price != 0")),
      numerics.asNumericFilters()?.rows(),
    )

    val tags = tagFilters {
      or {
        tag("a")
        tag("b")
      }
    }
    assertEquals(listOf(listOf("a", "b")), tags.asTagFilters()?.rows())

    val mixedAnd = facetFilters {
      facet("color", "red")
      or {
        facet("size", "s")
        facet("size", "m")
      }
    }
    assertEquals(
      listOf(listOf("\"color\":\"red\""), listOf("\"size\":\"s\"", "\"size\":\"m\"")),
      mixedAnd.asFacetFilters()?.rows(),
    )
  }

  @Test
  fun notAndWithNestedOrRejectsLegacyOnly() {
    val built = filters {
      not {
        orFacet {
          facet("color", "red")
          facet("color", "blue")
        }
        facet("category", "shirt")
      }
    }
    assertEquals("NOT ((color:red OR color:blue) AND category:shirt)", built.asSql())
    assertFailsWith<IllegalArgumentException> { built.asFacetFilters() }
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

@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.FilterLegacyConverter
import com.algolia.client.dsl.filter.FilterSqlConverter
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.filters
import com.algolia.client.dsl.filter.not
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
 * SQL quotes only when T5 requires it (space, quote, `AND` / `OR` / `NOT`). Legacy rows always
 * quote, matching [FilterLegacyConverter] `escape()`.
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
      or {
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
      listOf(listOf("\"price\":0 TO 9", "\"price\" = 15")),
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
      SqlVector("or facet", FilterGroup.Or(colorRed, colorBlue), "(color:red OR color:blue)"),
      SqlVector(
        "or numeric",
        FilterGroup.Or(priceUntil10, priceEquals15),
        "(price:0 TO 9 OR price = 15)",
      ),
      SqlVector(
        "or tag",
        FilterGroup.Or(Filter.Tag("a"), Filter.Tag("b")),
        "(_tags:a OR _tags:b)",
      ),
      SqlVector("not", FilterGroup.Not(colorRed), "NOT color:red"),
      SqlVector("not unary", colorRed.not(), "NOT color:red"),
      SqlVector(
        "not and",
        FilterGroup.Not(FilterGroup.And(colorRed, categoryShirt)),
        "NOT (color:red AND category:shirt)",
      ),
      SqlVector(
        "not range",
        FilterGroup.Not(Filter.Range("attributeA", 0..10)),
        "NOT attributeA:0 TO 10",
      ),
      SqlVector("quote space", Filter.Facet("author", "John Doe"), "author:\"John Doe\""),
      SqlVector("quote AND", Filter.Facet("title", "foo AND bar"), "title:\"foo AND bar\""),
      SqlVector("quote OR", Filter.Facet("title", "foo OR bar"), "title:\"foo OR bar\""),
      SqlVector("quote NOT", Filter.Facet("title", "NOT bar"), "title:\"NOT bar\""),
      SqlVector("quote embedded", Filter.Tag("45\"-50\" tv's"), "_tags:\"45\\\"-50\\\" tv's\""),
      SqlVector("quote attribute space", Filter.Facet("my attr", "red"), "\"my attr\":red"),
      SqlVector("empty and", FilterGroup.And(), null),
      SqlVector("empty or", FilterGroup.Or(), null),
      SqlVector("empty dsl", filters {}.group, null),
      SqlVector(
        "docs and+orNumeric",
        FilterGroup.And(
          FilterGroup.And(colorRed, categoryShirt),
          FilterGroup.Or(priceUntil10, priceEquals15),
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
      LegacyVector("tag", Filter.Tag("featured"), tag = listOf(listOf("\"featured\""))),
      LegacyVector("range until", priceUntil10, numeric = listOf(listOf("\"price\":0 TO 9"))),
      LegacyVector(
        "comparison equals",
        priceEquals15,
        numeric = listOf(listOf("\"price\" = 15")),
      ),
      LegacyVector(
        "and facets",
        FilterGroup.And(colorRed, categoryShirt),
        facet = listOf(listOf("\"color\":\"red\""), listOf("\"category\":\"shirt\"")),
      ),
      LegacyVector(
        "or facets",
        FilterGroup.Or(colorRed, colorBlue),
        facet = listOf(listOf("\"color\":\"red\"", "\"color\":\"blue\"")),
      ),
      LegacyVector(
        "or numeric",
        FilterGroup.Or(priceUntil10, priceEquals15),
        numeric = listOf(listOf("\"price\":0 TO 9", "\"price\" = 15")),
      ),
      LegacyVector(
        "not facet",
        FilterGroup.Not(colorRed),
        facet = listOf(listOf("\"color\":-\"red\"")),
      ),
      LegacyVector(
        "not tag",
        FilterGroup.Not(Filter.Tag("featured")),
        tag = listOf(listOf("-\"featured\"")),
      ),
      LegacyVector(
        "not comparison less",
        FilterGroup.Not(Filter.Comparison("attributeA", NumericOperator.Less, 5)),
        numeric = listOf(listOf("\"attributeA\" >= 5")),
      ),
      LegacyVector(
        "not range",
        FilterGroup.Not(Filter.Range("attributeA", 0..10)),
        numeric = listOf(listOf("\"attributeA\" < 0", "\"attributeA\" > 10")),
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
      LegacyVector("empty or", FilterGroup.Or()),
      LegacyVector(
        "v2 and+or facets",
        FilterGroup.And(
          FilterGroup.And(
            Filter.Facet("attributeA", "unknown"),
            Filter.Facet("attributeB", "unknown"),
          ),
          FilterGroup.Or(
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
        numeric = listOf(listOf("\"price\":0 TO 9")),
        tag = listOf(listOf("\"featured\"")),
      ),
    )

  private val rejectVectors: List<RejectVector> =
    listOf(
      RejectVector(
        "mixed-family or facet+tag",
        FilterGroup.Or(colorRed, Filter.Tag("featured")),
      ),
      RejectVector(
        "mixed-family or facet+numeric",
        FilterGroup.Or(colorRed, priceEquals15),
      ),
      RejectVector(
        "Or-of-And",
        FilterGroup.Or(FilterGroup.And(colorRed, categoryShirt), colorBlue),
        legacyAllThrow = false,
      ),
      RejectVector(
        "Or-of-Or",
        FilterGroup.Or(FilterGroup.Or(colorRed, colorBlue), categoryShirt),
        legacyFacetThrows = false,
        legacyAllThrow = false,
      ),
    )
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

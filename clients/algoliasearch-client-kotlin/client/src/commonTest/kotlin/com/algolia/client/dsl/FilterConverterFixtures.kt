@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.Filter
import com.algolia.client.dsl.filter.FilterGroup
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.dsl.filter.not
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.NumericFilters
import com.algolia.client.model.search.OptionalFilters
import com.algolia.client.model.search.TagFilters

/**
 * Shared fixtures for [FilterSqlConverterTest], [FilterLegacyConverterTest], and
 * [FilterNegationDslTest]. Golden vectors: SQL quotes only when T5 requires it (space, quote, `AND`
 * / `OR` / `NOT`); legacy facet rows always quote; legacy numeric attributes and tag values use the
 * same T5 rule.
 */
internal class SqlVector(val name: String, val group: FilterGroup, val sql: String?)

internal enum class Family {
  Facet,
  Numeric,
  Tag,
}

internal class LegacyVector(
  val name: String,
  val group: FilterGroup,
  val family: Family,
  val rows: List<List<String>>? = null,
)

internal class RejectVector(
  val name: String,
  val group: FilterGroup,
  val legacyFacetThrows: Boolean = true,
  val legacyAllThrow: Boolean = true,
)

internal val colorRed = Filter.Facet("color", "red")
internal val colorBlue = Filter.Facet("color", "blue")
internal val categoryShirt = Filter.Facet("category", "shirt")
internal val priceUntil10 = Filter.Range("price", 0 until 10)
internal val priceEquals15 = Filter.Comparison("price", NumericOperator.Equals, 15)

internal val sqlVectors: List<SqlVector> =
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

internal val legacyVectors: List<LegacyVector> =
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

internal val rejectVectors: List<RejectVector> =
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

internal fun FacetFilters.rows(): List<List<String>> =
  (this as FacetFilters.ListOfFacetFiltersValue).value.map { row ->
    (row as FacetFilters.ListOfFacetFiltersValue).value.map { cell ->
      (cell as FacetFilters.StringValue).value
    }
  }

internal fun OptionalFilters.rows(): List<List<String>> =
  (this as OptionalFilters.ListOfOptionalFiltersValue).value.map { row ->
    (row as OptionalFilters.ListOfOptionalFiltersValue).value.map { cell ->
      (cell as OptionalFilters.StringValue).value
    }
  }

internal fun NumericFilters.rows(): List<List<String>> =
  (this as NumericFilters.ListOfNumericFiltersValue).value.map { row ->
    (row as NumericFilters.ListOfNumericFiltersValue).value.map { cell ->
      (cell as NumericFilters.StringValue).value
    }
  }

internal fun TagFilters.rows(): List<List<String>> =
  (this as TagFilters.ListOfTagFiltersValue).value.map { row ->
    (row as TagFilters.ListOfTagFiltersValue).value.map { cell ->
      (cell as TagFilters.StringValue).value
    }
  }

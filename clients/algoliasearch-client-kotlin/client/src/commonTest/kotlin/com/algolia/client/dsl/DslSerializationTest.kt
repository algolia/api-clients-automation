@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.dsl.filter.NumericOperator
import com.algolia.client.model.search.BrowseParamsObject
import com.algolia.client.model.search.DeleteByParams
import com.algolia.client.model.search.IndexSettings
import com.algolia.client.model.search.SearchParamsObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * Serialization equivalence between DSL builders and data-class constructors.
 *
 * Uses [ClientOptions.json], the same [kotlinx.serialization.json.Json] the client sends on
 * requests. That instance leaves `encodeDefaults` off (kotlinx default), so unset null properties
 * are omitted. Comparison is on parsed [JsonObject], never on encoded strings.
 */
internal class DslSerializationTest {

  private val json = ClientOptions().json

  @Test
  fun queryDslMatchesConstructor() {
    val dsl =
      query("shoes") {
        hitsPerPage = 10
        filters { facet("brand", "Apple") }
      }
    val ctor =
      SearchParamsObject(
        query = "shoes",
        hitsPerPage = 10,
        filters = "brand:Apple",
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun browseDslMatchesConstructor() {
    val dsl = browse {
      query = "shoes"
      cursor = "cursor-1"
      filters { facet("brand", "Apple") }
    }
    val ctor =
      BrowseParamsObject(
        query = "shoes",
        cursor = "cursor-1",
        filters = "brand:Apple",
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun settingsDslMatchesConstructor() {
    val dsl = settings {
      searchableAttributes {
        ordered("name")
        unordered("description")
      }
      attributesForFaceting {
        +"brand"
        filterOnly("internalSku")
        searchable("category")
      }
      customRanking { desc("followers") }
      ranking {
        typo()
        geo()
        words()
        filters()
        proximity()
        attribute()
        exact()
        custom()
      }
    }
    val ctor =
      IndexSettings(
        searchableAttributes = listOf("name", "unordered(description)"),
        attributesForFaceting = listOf("brand", "filterOnly(internalSku)", "searchable(category)"),
        customRanking = listOf("desc(followers)"),
        ranking =
          listOf("typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom"),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun deleteByDslMatchesConstructor() {
    val dsl = deleteBy {
      aroundLatLng = "40.71,-74.01"
      filters { facet("brand", "Apple") }
    }
    val ctor =
      DeleteByParams(
        aroundLatLng = "40.71,-74.01",
        filters = "brand:Apple",
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun queryLastWriteWinsFiltersBlockOverwritesString() {
    val dsl = query {
      filters = "brand:Nike"
      filters { facet("brand", "Apple") }
    }
    assertJsonEquals(SearchParamsObject(filters = "brand:Apple"), dsl)
  }

  @Test
  fun queryLastWriteWinsFiltersStringOverwritesBlock() {
    val dsl = query {
      filters { facet("brand", "Apple") }
      filters = "brand:Nike"
    }
    assertJsonEquals(SearchParamsObject(filters = "brand:Nike"), dsl)
  }

  @Test
  fun browseLastWriteWinsFiltersBlockOverwritesString() {
    val dsl = browse {
      filters = "brand:Nike"
      filters { facet("brand", "Apple") }
    }
    assertJsonEquals(BrowseParamsObject(filters = "brand:Apple"), dsl)
  }

  @Test
  fun deleteByLastWriteWinsFiltersBlockOverwritesString() {
    val dsl = deleteBy {
      filters = "brand:Nike"
      filters { facet("brand", "Apple") }
    }
    assertJsonEquals(DeleteByParams(filters = "brand:Apple"), dsl)
  }

  @Test
  fun settingsLastWriteWinsSearchableAttributesBlockOverwritesList() {
    val dsl = settings {
      searchableAttributes = listOf("old")
      searchableAttributes { ordered("name") }
    }
    assertJsonEquals(IndexSettings(searchableAttributes = listOf("name")), dsl)
  }

  @Test
  fun settingsOrderedVarargJoinsWithCommaSpace() {
    val dsl = settings { searchableAttributes { ordered("title", "name") } }
    assertJsonEquals(IndexSettings(searchableAttributes = listOf("title, name")), dsl)
  }

  @Test
  fun settingsDslClassesShareTheStringListBase() {
    val dsl = settings {
      searchableAttributes { +"name" }
      attributesForFaceting { +"brand" }
      customRanking { asc("price") }
      ranking { desc("rating") }
    }
    assertJsonEquals(
      IndexSettings(
        searchableAttributes = listOf("name"),
        attributesForFaceting = listOf("brand"),
        customRanking = listOf("asc(price)"),
        ranking = listOf("desc(rating)"),
      ),
      dsl,
    )
  }

  @Test
  fun queryLegacyFilterHelpersMatchExpectedJson() {
    val dsl = query {
      facetFilters { facet("brand", "Apple") }
      optionalFilters { facet("category", "Book") }
      numericFilters { comparison("price", NumericOperator.Equals, 15) }
      tagFilters { tag("featured") }
    }
    assertEncodedJson(
      dsl,
      """
      {
        "facetFilters": [["\"brand\":\"Apple\""]],
        "optionalFilters": [["\"category\":\"Book\""]],
        "numericFilters": [["\"price\" = 15"]],
        "tagFilters": [["\"featured\""]]
      }
      """,
    )
  }

  @Test
  fun browseLegacyFilterHelpersMatchExpectedJson() {
    val dsl = browse {
      facetFilters { facet("brand", "Apple") }
      optionalFilters { facet("category", "Book") }
      numericFilters { comparison("price", NumericOperator.Equals, 15) }
      tagFilters { tag("featured") }
    }
    assertEncodedJson(
      dsl,
      """
      {
        "facetFilters": [["\"brand\":\"Apple\""]],
        "optionalFilters": [["\"category\":\"Book\""]],
        "numericFilters": [["\"price\" = 15"]],
        "tagFilters": [["\"featured\""]]
      }
      """,
    )
  }

  @Test
  fun deleteByLegacyFilterHelpersMatchExpectedJson() {
    val dsl = deleteBy {
      facetFilters { facet("brand", "Apple") }
      numericFilters { comparison("price", NumericOperator.Equals, 15) }
      tagFilters { tag("featured") }
    }
    assertEncodedJson(
      dsl,
      """
      {
        "facetFilters": [["\"brand\":\"Apple\""]],
        "numericFilters": [["\"price\" = 15"]],
        "tagFilters": [["\"featured\""]]
      }
      """,
    )
  }

  @Test
  fun emptyFilterBlockLeavesFieldUnset() {
    assertEncodedJson(query { filters {} }, "{}")
    assertEncodedJson(query { facetFilters {} }, "{}")
  }

  private inline fun <reified T> assertEncodedJson(dsl: T, expectedJson: String) {
    assertEquals(json.parseToJsonElement(expectedJson), json.encodeToJsonElement(dsl))
  }

  private inline fun <reified T> assertJsonEquals(constructor: T, dsl: T) {
    val constructorJson = json.encodeToJsonElement(constructor)
    val dslJson = json.encodeToJsonElement(dsl)
    assertIs<JsonObject>(constructorJson)
    assertIs<JsonObject>(dslJson)
    assertEquals(constructorJson.jsonObject, dslJson.jsonObject)
  }
}

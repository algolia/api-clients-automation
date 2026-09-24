@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.dsl.filter.filters
import com.algolia.client.model.search.IndexSettings
import com.algolia.client.model.search.SearchParamsObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * Wire-level semantics of the DSL builders that a constructor-equivalence golden cannot pin: block
 * helpers overwrite the property they target (last write wins), and empty blocks leave the field
 * unset.
 *
 * Uses [ClientOptions.json], the same [kotlinx.serialization.json.Json] the client sends on
 * requests. That instance leaves `encodeDefaults` off (kotlinx default), so unset null properties
 * are omitted. Comparison is on parsed [JsonObject], never on encoded strings.
 */
internal class DslSerializationTest {

  private val json = ClientOptions().json

  @Test
  fun queryLastWriteWinsFiltersBlockOverwritesString() {
    val dsl = query {
      filters = "brand:Nike"
      filters { facet("brand", "Apple") }
    }
    assertJsonEquals(SearchParamsObject(filters = "brand:Apple"), dsl)
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
  fun emptyFilterBlockLeavesFieldUnset() {
    assertEncodedJson(query { filters {} }, "{}")
    assertEncodedJson(query { optionalFilters {} }, "{}")

    // Nested empty groups collapse too: no leaf, no field.
    assertEncodedJson(
      query {
        filters {
          and {}
          orFacet {}
        }
      },
      "{}",
    )
    assertEncodedJson(query { optionalFilters { or {} } }, "{}")

    // An empty group beside a leaf is dropped, not parenthesised.
    assertEquals(
      "color:red",
      filters {
        facet("color", "red")
        and {}
      },
    )
  }

  @Test
  fun secondFiltersBlockReplacesTheFirst() {
    val dsl = query {
      filters { facet("genre", "comedy") }
      filters { facet("genre", "drama") }
    }
    assertEncodedJson(dsl, """{"filters":"genre:drama"}""")
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

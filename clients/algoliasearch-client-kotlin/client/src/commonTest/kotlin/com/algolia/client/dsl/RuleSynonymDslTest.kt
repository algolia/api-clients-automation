@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.dsl.rule.*
import com.algolia.client.dsl.synonym.altCorrection1
import com.algolia.client.dsl.synonym.altCorrection2
import com.algolia.client.dsl.synonym.oneWaySynonym
import com.algolia.client.dsl.synonym.placeholder
import com.algolia.client.dsl.synonym.synonym
import com.algolia.client.model.search.Anchoring
import com.algolia.client.model.search.Condition
import com.algolia.client.model.search.Consequence
import com.algolia.client.model.search.ConsequenceParams
import com.algolia.client.model.search.ConsequenceQuery
import com.algolia.client.model.search.Promote
import com.algolia.client.model.search.PromoteObjectID
import com.algolia.client.model.search.Rule
import com.algolia.client.model.search.SynonymHit
import com.algolia.client.model.search.SynonymType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * Serialization equivalence between rule/synonym DSL builders and data-class constructors.
 *
 * Uses [ClientOptions.json], the same [kotlinx.serialization.json.Json] the client sends on
 * requests. That instance leaves `encodeDefaults` off (kotlinx default), so unset null properties
 * are omitted. Comparison is on parsed [JsonObject], never on encoded strings.
 */
internal class RuleSynonymDslTest {

  private val json = ClientOptions().json

  @Test
  fun ruleDslMatchesConstructor() {
    val dsl =
      rule("promo-iphone") {
        condition {
          pattern = "smartphone"
          anchoring = Anchoring.Is
        }
        consequence {
          params {
            query("iphone")
            filters { facet("brand", "Apple") }
          }
          promote("object-1", position = 0)
        }
      }
    val ctor =
      Rule(
        objectID = "promo-iphone",
        condition =
          Condition(
            pattern = "smartphone",
            anchoring = Anchoring.Is,
          ),
        consequence =
          Consequence(
            params =
              ConsequenceParams(
                query = ConsequenceQuery.of("iphone"),
                filters = "brand:Apple",
              ),
            promote = listOf(Promote.of(PromoteObjectID("object-1", 0))),
          ),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun regularSynonymDslMatchesConstructor() {
    val dsl =
      synonym("syn-1") {
        +"car"
        +"auto"
        +"vehicle"
      }
    val ctor =
      SynonymHit(
        objectID = "syn-1",
        type = SynonymType.Synonym,
        synonyms = listOf("car", "auto", "vehicle"),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun oneWaySynonymDslMatchesConstructor() {
    val dsl =
      oneWaySynonym("syn-2", input = "tablet") {
        +"ipad"
        +"galaxy tab"
      }
    val ctor =
      SynonymHit(
        objectID = "syn-2",
        type = SynonymType.OneWaySynonym,
        input = "tablet",
        synonyms = listOf("ipad", "galaxy tab"),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun altCorrection1DslMatchesConstructor() {
    val dsl = altCorrection1("syn-3", word = "trousers") { +"pants" }
    val ctor =
      SynonymHit(
        objectID = "syn-3",
        type = SynonymType.AltCorrection1,
        word = "trousers",
        corrections = listOf("pants"),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun altCorrection2DslMatchesConstructor() {
    val dsl = altCorrection2("syn-4", word = "trousers") { +"pants" }
    val ctor =
      SynonymHit(
        objectID = "syn-4",
        type = SynonymType.AltCorrection2,
        word = "trousers",
        corrections = listOf("pants"),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun placeholderDslMatchesConstructor() {
    val dsl =
      placeholder("syn-5", placeholder = "<Street>") {
        +"street"
        +"st"
      }
    val ctor =
      SynonymHit(
        objectID = "syn-5",
        type = SynonymType.Placeholder,
        placeholder = "<Street>",
        replacements = listOf("street", "st"),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun conditionFiltersHelperMatchesConstructor() {
    val dsl = rule("x") { condition { filters { facet("brand", "Apple") } } }
    val ctor =
      Rule(
        objectID = "x",
        condition = Condition(filters = "brand:Apple"),
        consequence = Consequence(),
      )
    assertJsonEquals(ctor, dsl)
  }

  @Test
  fun consequenceParamsLegacyFilterHelpersMatchExpectedJson() {
    val dsl =
      rule("x") {
        consequence {
          params {
            facetFilters { facet("brand", "Apple") }
            numericFilters { range("price", 0 until 10) }
            tagFilters { tag("featured") }
            optionalFilters { facet("category", "Book") }
          }
        }
      }
    val expected =
      json.parseToJsonElement(
        """
        {
          "objectID": "x",
          "consequence": {
            "params": {
              "facetFilters": [["\"brand\":\"Apple\""]],
              "numericFilters": [["\"price\":0 TO 9"]],
              "tagFilters": [["\"featured\""]],
              "optionalFilters": [["\"category\":\"Book\""]]
            }
          }
        }
        """
          .trimIndent()
      )
    val actual = json.encodeToJsonElement(dsl)
    assertIs<JsonObject>(actual)
    assertEquals(expected.jsonObject, actual.jsonObject)
  }

  @Test
  fun synonymFactoriesLeaveOtherVariantFieldsUnset() {
    assertEquals(
      setOf("objectID", "type", "synonyms"),
      json
        .encodeToJsonElement(
          synonym("syn-1") {
            +"car"
            +"auto"
            +"vehicle"
          }
        )
        .jsonObject
        .keys
        .toSet(),
    )
    assertEquals(
      setOf("objectID", "type", "input", "synonyms"),
      json
        .encodeToJsonElement(
          oneWaySynonym("syn-2", input = "tablet") {
            +"ipad"
            +"galaxy tab"
          }
        )
        .jsonObject
        .keys
        .toSet(),
    )
    assertEquals(
      setOf("objectID", "type", "word", "corrections"),
      json
        .encodeToJsonElement(altCorrection1("syn-3", word = "trousers") { +"pants" })
        .jsonObject
        .keys
        .toSet(),
    )
    assertEquals(
      setOf("objectID", "type", "word", "corrections"),
      json
        .encodeToJsonElement(altCorrection2("syn-4", word = "trousers") { +"pants" })
        .jsonObject
        .keys
        .toSet(),
    )
    assertEquals(
      setOf("objectID", "type", "placeholder", "replacements"),
      json
        .encodeToJsonElement(
          placeholder("syn-5", placeholder = "<Street>") {
            +"street"
            +"st"
          }
        )
        .jsonObject
        .keys
        .toSet(),
    )
  }

  private inline fun <reified T> assertJsonEquals(constructor: T, dsl: T) {
    val constructorJson = json.encodeToJsonElement(constructor)
    val dslJson = json.encodeToJsonElement(dsl)
    assertIs<JsonObject>(constructorJson)
    assertIs<JsonObject>(dslJson)
    assertEquals(constructorJson.jsonObject, dslJson.jsonObject)
  }
}

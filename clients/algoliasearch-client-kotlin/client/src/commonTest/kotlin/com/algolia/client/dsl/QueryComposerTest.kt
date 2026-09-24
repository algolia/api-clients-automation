@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.model.search.SearchParamsObject
import com.algolia.client.model.search.SupportedLanguage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.serialization.json.encodeToJsonElement

/**
 * [QueryComposer]: `add { }` fragments accumulate per field inside one receiver, `override { }`
 * runs after them with last write wins, and nothing runs until `build()`.
 *
 * The documentation modules golden (locale, searchable title, boost, `assemble`) is Phase 0 matrix
 * rows C10–C13 and is not duplicated here.
 */
internal class QueryComposerTest {

  private val json = ClientOptions().json

  @Test
  fun filtersFromSeveralFragmentsAreAnded() {
    val params = composeQuery {
      add {
        filters {
          orFacet {
            facet("locale", "en-US")
            facet("locale", "en-GB")
          }
        }
      }
      add { filters { facet("entityId", "x") } }
    }
    assertEquals("(locale:en-US OR locale:en-GB) AND entityId:x", params.filters)
  }

  @Test
  fun optionalFragmentsConcatenateRows() {
    val params = composeQuery {
      add { optionalFilters { or { facet("isFeatured", true, score = 500) } } }
      add { optionalFilters { facet("genre", "comedy", score = 0) } }
    }
    assertEquals(
      listOf(listOf("isFeatured:true<score=500>"), listOf("genre:comedy<score=0>")),
      assertNotNull(params.optionalFilters).rows(),
    )
  }

  @Test
  fun listFragmentsConcatenateInCallOrder() {
    val params = composeQuery {
      add {
        ruleContexts { +"desktop" }
        restrictSearchableAttributes { +"title" }
        queryLanguages { +SupportedLanguage.En }
        responseFields { +"hits" }
      }
      add {
        ruleContexts { +"eu" }
        restrictSearchableAttributes { +"description" }
        queryLanguages { +SupportedLanguage.Fr }
        responseFields { +"nbHits" }
      }
    }
    assertEquals(listOf("desktop", "eu"), params.ruleContexts)
    assertEquals(listOf("title", "description"), params.restrictSearchableAttributes)
    assertEquals(listOf(SupportedLanguage.En, SupportedLanguage.Fr), params.queryLanguages)
    assertEquals(listOf("hits", "nbHits"), params.responseFields)
  }

  @Test
  fun overridesRunAfterAdditionsLastWriteWins() {
    val params = composeQuery {
      // Declared before the additions on purpose: overrides still run after them.
      override { filters = "x:y" }
      add { filters { facet("a", "b") } }
      add { queryLanguages { +SupportedLanguage.Fr } }
      override { hitsPerPage = 10 }
      override { hitsPerPage = 20 }
      override { queryLanguages { +SupportedLanguage.En } }
      override { sumOrFiltersScores = true }
    }
    assertEquals(
      SearchParamsObject(
        filters = "x:y",
        hitsPerPage = 20,
        queryLanguages = listOf(SupportedLanguage.En),
        sumOrFiltersScores = true,
      ),
      params,
    )
  }

  @Test
  fun emptyComposerAndEmptyFragmentsOmitFields() {
    val empty = json.parseToJsonElement("{}")
    assertEquals(empty, json.encodeToJsonElement(QueryComposer().build()))

    val emptyFragments = composeQuery {
      add {
        filters {}
        ruleContexts {}
      }
    }
    assertEquals(empty, json.encodeToJsonElement(emptyFragments))
  }

  @Test
  fun buildIsRepeatable() {
    val composer = QueryComposer()
    composer.add { ruleContexts { +"a" } }
    composer.override { hitsPerPage = 5 }

    val first = composer.build()
    assertEquals(first, composer.build())

    composer.add { ruleContexts { +"b" } }
    val second = composer.build()
    assertEquals(listOf("a", "b"), second.ruleContexts)
    assertEquals(5, second.hitsPerPage)
    // The earlier result is a value; the later add does not reach into it.
    assertEquals(listOf("a"), first.ruleContexts)
  }

  @Test
  fun nothingRunsBeforeBuild() {
    var runs = 0
    val composer = QueryComposer()
    composer.add {
      runs++
      ruleContexts {
        runs++
        +"x"
      }
    }
    composer.override { runs++ }
    assertEquals(0, runs)

    composer.build()
    assertEquals(3, runs)

    composer.build()
    assertEquals(6, runs)
  }

  @Test
  fun lateBoundCapturesReadAtBuild() {
    var locale = "en-US"
    val contexts = mutableListOf("a")
    val composer = QueryComposer()
    composer.add { filters { facet("locale", locale) } }
    composer.add { ruleContexts { +contexts } }

    locale = "fr-FR"
    contexts += "b"

    val params = composer.build()
    assertEquals("locale:fr-FR", params.filters)
    assertEquals(listOf("a", "b"), params.ruleContexts)
  }

  @Test
  fun fieldBlocksShareOneReceiver() {
    val params = composeQuery {
      add { filters { orFacet { facet("a", "1") } } }
      add { filters { facet("b", "2", isNegated = true) } }
    }
    // Both fragments ran in one FilterDsl: one top-level AND, never parenthesised.
    assertEquals("a:1 AND NOT b:2", params.filters)
  }

  @Test
  fun unqualifiedOverrideCompiles() {
    // `override` is a soft keyword: the unqualified call inside the composer lambda must parse.
    val params = composeQuery {
      add { ruleContexts { +"x" } }
      override { hitsPerPage = 1 }
    }
    assertEquals(SearchParamsObject(ruleContexts = listOf("x"), hitsPerPage = 1), params)
  }

  @Test
  fun storedAdditionsFragment() {
    val extra: QueryAdditions.() -> Unit = { ruleContexts { +"desktop" } }
    val composer = QueryComposer()
    composer.add(extra)
    assertEquals(listOf("desktop"), composer.build().ruleContexts)
  }
}

@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.model.search.OptionalFilters
import com.algolia.client.model.search.SearchParamsObject
import com.algolia.client.model.search.SupportedLanguage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlinx.serialization.json.encodeToJsonElement

/**
 * [DSLQueryComposer]: `add { }` fragments accumulate per field inside one receiver, `override { }`
 * runs after them with last write wins, and nothing runs until `build()`.
 *
 * The documentation modules golden (locale, searchable title, boost, `assemble`) is Phase 0 matrix
 * rows C10–C13 and is not duplicated here.
 */
internal class DSLQueryComposerTest {

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
  fun emptyComposerOmitsFieldsAndEmptyListFragmentsSendEmptyLists() {
    val empty = json.parseToJsonElement("{}")
    assertEquals(empty, json.encodeToJsonElement(DSLQueryComposer().build()))

    val emptyFragments = composeQuery {
      add {
        filters {}
        ruleContexts {}
      }
    }
    assertEquals(
      json.parseToJsonElement("""{"ruleContexts":[]}"""),
      json.encodeToJsonElement(emptyFragments),
    )
  }

  @Test
  fun buildIsRepeatable() {
    val composer = DSLQueryComposer()
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
    val composer = DSLQueryComposer()
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
    val composer = DSLQueryComposer()
    composer.add { filters { facet("locale", locale) } }
    composer.add { ruleContexts { +contexts } }

    locale = "fr-FR"
    contexts += "b"

    val params = composer.build()
    assertEquals("locale:fr-FR", params.filters)
    assertEquals(listOf("a", "b"), params.ruleContexts)
  }

  @Test
  fun baseFiltersMergeWithFragments() {
    val params =
      DSLQueryComposer(
          base = {
            hitsPerPage = 10
            filters { facet("base", "x") }
          }
        )
        .apply { add { filters { facet("module", "y") } } }
        .build()
    assertEquals("base:x AND module:y", params.filters)
    assertEquals(10, params.hitsPerPage)
  }

  @Test
  fun baseOptionalFiltersMergeWithFragments() {
    val params =
      composeQuery(base = { optionalFilters { facet("genre", "comedy") } }) {
        add { optionalFilters { or { facet("isFeatured", true) } } }
      }
    assertEquals(
      listOf(listOf("genre:comedy"), listOf("isFeatured:true")),
      assertNotNull(params.optionalFilters).rows(),
    )
  }

  @Test
  fun baseListsPrecedeFragments() {
    val params =
      composeQuery(base = { ruleContexts { +"base" } }) {
        add { ruleContexts { +"a" } }
        add { ruleContexts { +"b" } }
      }
    assertEquals(listOf("base", "a", "b"), params.ruleContexts)

    val explicitEmpty =
      composeQuery(base = { attributesToRetrieve = emptyList() }) {
        add { attributesToRetrieve {} }
      }
    assertEquals(emptyList(), explicitEmpty.attributesToRetrieve)
  }

  @Test
  fun rawBaseFilterCannotMergeWithFragments() {
    val error =
      assertFailsWith<IllegalStateException> {
        composeQuery(base = { filters = "a:1 OR b:2" }) { add { filters { facet("c", "3") } } }
      }
    assertTrue(error.message.orEmpty().contains("filters { } in the base"))

    assertFailsWith<IllegalStateException> {
      composeQuery(base = { optionalFilters = OptionalFilters.of("a:1") }) {
        add { optionalFilters { facet("b", "2") } }
      }
    }

    val untouched =
      composeQuery(base = { filters = "a:1 OR b:2" }) { add { ruleContexts { +"x" } } }
    assertEquals("a:1 OR b:2", untouched.filters)
  }

  @Test
  fun overrideStillWinsOverTheMergedValue() {
    val params =
      composeQuery(base = { filters { facet("base", "x") } }) {
        add { filters { facet("module", "y") } }
        override { filters { facet("final", "z") } }
      }
    assertEquals("final:z", params.filters)
  }

  @Test
  fun baseOnlyComposerEqualsQuery() {
    val base: DSLQuery.() -> Unit = {
      hitsPerPage = 3
      filters { orFacet { facet("a", "1") } }
      ruleContexts { +"c" }
    }
    assertEquals(query(block = base), DSLQueryComposer(base).build())
    assertEquals(query(block = base), composeQuery(base) {})
  }

  @Test
  fun fromKeepsUntouchedFieldsAndReplacesComposedOnes() {
    val existing =
      SearchParamsObject(
        query = "shoes",
        hitsPerPage = 5,
        filters = "old:1 OR old:2",
        ruleContexts = listOf("old"),
        attributesToHighlight = listOf("title"),
      )
    val composer = DSLQueryComposer(from = existing)
    composer.add { filters { facet("module", "y") } }
    composer.add { ruleContexts { +"new" } }
    composer.override { hitsPerPage = 10 }

    assertEquals(
      existing.copy(filters = "module:y", ruleContexts = listOf("new"), hitsPerPage = 10),
      composer.build(),
    )
    // The source object is never modified, and every build starts from it again.
    assertEquals("old:1 OR old:2", existing.filters)
    assertEquals(composer.build(), composer.build())
  }

  @Test
  fun fromWithoutFragmentsEqualsTheSource() {
    val existing = SearchParamsObject(query = "q", optionalFilters = OptionalFilters.of("a:1"))
    assertEquals(existing, DSLQueryComposer(from = existing).build())
    assertEquals(existing, composeQuery(from = existing) {})
  }

  @Test
  fun fromEmptyFragmentsSendEmptyLists() {
    val existing = SearchParamsObject(attributesToHighlight = listOf("title"), filters = "a:1")
    val params =
      composeQuery(from = existing) {
        add { attributesToHighlight {} }
        add { filters {} }
      }
    assertEquals(emptyList(), params.attributesToHighlight)
    // An empty filters fragment replaces the seeded string with nothing, as on a query builder.
    assertEquals(null, params.filters)
  }

  @Test
  fun fieldBlocksShareOneReceiver() {
    val params = composeQuery {
      add { filters { orFacet { facet("a", "1") } } }
      add { filters { facet("b", "2", isNegated = true) } }
    }
    // Both fragments ran in one DSLFilters: one top-level AND, never parenthesised.
    assertEquals("a:1 AND NOT b:2", params.filters)
  }
}

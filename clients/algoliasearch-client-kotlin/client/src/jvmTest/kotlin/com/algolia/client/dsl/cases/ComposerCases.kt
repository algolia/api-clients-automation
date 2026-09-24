@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.cases

import com.algolia.client.dsl.*
import com.algolia.client.dsl.cases.samples.QueryWrapper
import com.algolia.client.dsl.cases.samples.SearchRequest
import com.algolia.client.dsl.cases.samples.applyBoost
import com.algolia.client.dsl.cases.samples.applyLocale
import com.algolia.client.dsl.cases.samples.applySearchableTitle
import com.algolia.client.dsl.cases.samples.assemble
import com.algolia.client.dsl.cases.samples.setPinned
import com.algolia.client.dsl.cases.samples.setPriority
import com.algolia.client.dsl.cases.samples.setSuggestionType
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

/**
 * [DSLQueryComposer] and the user-side wrapper it replaces: fragments added once, overrides last.
 */
internal object ComposerCases {

  val queryWrapperPort =
    LiveCase(
      dsl = {
        val wrapper = QueryWrapper({ query = "office" })
        wrapper.add {
          filters {
            orFacet {
              facet("locale", "en-US")
              facet("locale", "fr-FR")
            }
          }
        }
        wrapper.add { filters { facet("isPinned", false) } }
        wrapper.add { restrictSearchableAttributes { +"title" } }
        wrapper.add { restrictSearchableAttributes { +"alternateTitles" } }
        wrapper.add { attributesToHighlight { +"title" } }
        wrapper.add { optionalFilters { or { facet("isFeatured", true, score = 500) } } }
        wrapper.add { ruleContexts { +"desktop" } }
        wrapper.override { hitsPerPage = 5 }
        wrapper.override { hitsPerPage = 10 }
        wrapper.build()
      },
      body =
        """{"query":"office","filters":"(locale:en-US OR locale:fr-FR) AND isPinned:false","restrictSearchableAttributes":["title","alternateTitles"],"attributesToHighlight":["title"],"optionalFilters":[["isFeatured:true<score=500>"]],"ruleContexts":["desktop"],"hitsPerPage":10}""",
      expect =
        listOf(Expect.Hits(setOf("1")), Expect.UserData(jsonArray("""[{"ctx":"desktop"}]"""))),
    )

  val addAndOverride =
    LiveCase(
      dsl = {
        val composer = DSLQueryComposer()
        composer.add {
          filters {
            orFacet {
              facet("locale", "en-US")
              facet("locale", "fr-FR")
            }
          }
        }
        composer.add { filters { facet("isPinned", false) } }
        composer.add { restrictSearchableAttributes { +"title" } }
        composer.add { restrictSearchableAttributes { +"alternateTitles" } }
        composer.add { attributesToHighlight { +"title" } }
        composer.add { optionalFilters { or { facet("isFeatured", true, score = 500) } } }
        composer.add { optionalFilters { facet("genre", "comedy", score = 0) } }
        composer.add { ruleContexts { +"desktop" } }
        composer.add { ruleContexts { +"ab-variant-b" } }
        composer.override {
          query = "office"
          hitsPerPage = 5
        }
        composer.override { hitsPerPage = 10 }
        composer.build()
      },
      body =
        """{"query":"office","hitsPerPage":10,"filters":"(locale:en-US OR locale:fr-FR) AND isPinned:false","restrictSearchableAttributes":["title","alternateTitles"],"attributesToHighlight":["title"],"optionalFilters":[["isFeatured:true<score=500>"],["genre:comedy<score=0>"]],"ruleContexts":["desktop","ab-variant-b"]}""",
      expect =
        listOf(Expect.Hits(setOf("1")), Expect.UserData(jsonArray("""[{"ctx":"desktop"}]"""))),
    )

  // ── Modules contributing to one composer ──────────────────────────────────────────────────────

  val localeModuleWithoutSecondary =
    LiveCase(
      dsl = { DSLQueryComposer().also { applyLocale(it, "en-US", null) }.build() },
      body = """{"filters":"locale:en-US","queryLanguages":["en"]}""",
      expect = listOf(Expect.Hits(setOf("1", "4"))),
    )

  val localeModuleWithSecondary =
    LiveCase(
      dsl = { DSLQueryComposer().also { applyLocale(it, "en-US", "fr-FR") }.build() },
      body = """{"filters":"(locale:en-US OR locale:fr-FR)","queryLanguages":["en","fr"]}""",
      expect = listOf(Expect.Hits(setOf("1", "2", "4", "5"))),
    )

  val searchableTitleModule =
    LiveCase(
      dsl = {
        DSLQueryComposer()
          .also {
            applySearchableTitle(it)
            it.override { query = "office" }
          }
          .build()
      },
      body =
        """{"query":"office","restrictSearchableAttributes":["title"],"attributesToHighlight":["title"]}""",
      expect = listOf(Expect.Hits(setOf("1", "3")), Expect.HighlightKeys(setOf("title"))),
    )

  val boostModule =
    LiveCase(
      dsl = {
        DSLQueryComposer()
          .also {
            applyBoost(it)
            it.override { getRankingInfo = true }
          }
          .build()
      },
      body =
        """{"optionalFilters":[["isFeatured:true<score=500>"]],"sumOrFiltersScores":true,"getRankingInfo":true}""",
      expect =
        listOf(
          Expect.Scores(mapOf("1" to 500, "4" to 500), others = 0),
          Expect.FirstHits(setOf("1", "4")),
        ),
    )

  val assembledContributorsAppliedOnce =
    LiveCase(
      dsl = {
        assemble(
          listOf<(DSLQueryComposer) -> Unit>(
            { applyLocale(it, "en-US", "fr-FR") },
            ::applySearchableTitle,
            ::applyBoost,
            { it.override { getRankingInfo = true } },
          )
        )
      },
      body =
        """{"filters":"(locale:en-US OR locale:fr-FR)","queryLanguages":["en","fr"],"restrictSearchableAttributes":["title"],"attributesToHighlight":["title"],"optionalFilters":[["isFeatured:true<score=500>"]],"sumOrFiltersScores":true,"getRankingInfo":true}""",
      // Mandatory `filters` clauses count in `_rankingInfo.filters` too
      // ([FilterCases.andScoresSummedFlat]): matched locale 1 + optional 500 for the featured
      // records, 1 alone for the others. Observed live 2026-09-23.
      expect =
        listOf(
          Expect.Hits(setOf("1", "2", "4", "5")),
          Expect.Scores(mapOf("1" to 501, "4" to 501, "2" to 1, "5" to 1)),
          Expect.FirstHits(setOf("1", "4")),
          Expect.HighlightKeys(setOf("title")),
        ),
    )

  // ── Request-map modules ───────────────────────────────────────────────────────────────────────

  private fun fromRequest(request: SearchRequest): SearchParamsObject =
    DSLQueryComposer()
      .also {
        it.setSuggestionType(request)
        it.setPriority(request)
        it.setPinned()
      }
      .build()

  val requestMapModules =
    LiveCase(
      dsl = { fromRequest(SearchRequest(mapOf("suggestionType" to "show", "priority" to "2"))) },
      body =
        """{"filters":"suggestionType:show<score=0> AND priority:2<score=0> AND isPinned:false<score=0>"}""",
      expect = listOf(Expect.Hits(setOf("3"))),
    )

  val requestMapModulesSkipUnparsablePriority =
    LiveCase(
      dsl = { fromRequest(SearchRequest(mapOf("priority" to "abc"))) },
      body = """{"filters":"isPinned:false<score=0>"}""",
      expect = listOf(Expect.Hits(setOf("1", "3", "4"))),
    )
}

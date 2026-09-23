@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

internal object RowsP3 {
  fun c09(): SearchParamsObject {
    val composer = QueryComposer()
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
    return composer.build()
  }

  fun c10(secondary: String?): SearchParamsObject =
    QueryComposer().also { applyLocale(it, "en-US", secondary) }.build()

  fun c11(): SearchParamsObject =
    QueryComposer()
      .also {
        applySearchableTitle(it)
        it.override { query = "office" }
      }
      .build()

  fun c12(): SearchParamsObject =
    QueryComposer()
      .also {
        applyBoost(it)
        it.override { getRankingInfo = true }
      }
      .build()

  fun c13(): SearchParamsObject =
    assemble(
      listOf<(QueryComposer) -> Unit>(
        { applyLocale(it, "en-US", "fr-FR") },
        ::applySearchableTitle,
        ::applyBoost,
        { it.override { getRankingInfo = true } },
      )
    )

  fun c14(): DeleteByParams {
    val composer = DeleteByComposer()
    composer.add {
      filters { orFacet { listOf("e1", "e2", "e3").forEach { facet("entityId", it) } } }
    }
    composer.add { filters { facet("batchId", "b2", isNegated = true) } }
    return composer.build()
  }

  fun c18(request: SearchRequest): SearchParamsObject =
    QueryComposer()
      .also {
        it.setSuggestionType(request)
        it.setPriority(request)
        it.setPinned()
      }
      .build()
}

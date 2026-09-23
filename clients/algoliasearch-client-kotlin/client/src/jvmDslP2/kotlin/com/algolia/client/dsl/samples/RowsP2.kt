@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

internal object RowsP2 {
  const val USER_TERMS: String = "office"
  const val PAGE_SIZE: Int = 10

  val c03Block: QueryBuilder.() -> Unit = {
    query = USER_TERMS
    hitsPerPage = PAGE_SIZE
    distinct = Distinct.of(1)
    getRankingInfo = true
    restrictHighlightAndSnippetArrays = true
    clickAnalytics = true

    filters { and { facet("locale", "en-US") } }

    restrictSearchableAttributes {
      +"title"
      +"alternateTitles"
    }
  }

  fun c03(): SearchParamsObject = query(block = c03Block)

  fun c08(): SearchParamsObject {
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
    return wrapper.build()
  }

  fun c25(extraFields: List<String>): SearchParamsObject = query {
    query = "office"
    restrictSearchableAttributes {
      +"title"
      +"tags"
      extraFields.forEach { +it }
    }
  }

  fun c26(): SearchParamsObject = query {
    query = "office"
    attributesToHighlight { +"title" }
  }

  fun c27(mapperRequiredFields: List<String> = listOf("locale")): SearchParamsObject = query {
    attributesToRetrieve {
      +"objectID"
      +"title"
      mapperRequiredFields.forEach { +it }
    }
  }

  fun c28(secondary: SupportedLanguage?): SearchParamsObject = query {
    query = "the office"
    removeStopWords = RemoveStopWords.of(true)
    queryLanguages {
      +SupportedLanguage.En
      secondary?.let { +it }
    }
  }

  fun c28French(): SearchParamsObject = query {
    query = "the office"
    removeStopWords = RemoveStopWords.of(true)
    queryLanguages { +SupportedLanguage.Fr }
  }

  fun c29(): SearchParamsObject = query {
    responseFields {
      +ResponseField.Hits
      +ResponseField.Exhaustive
      +ResponseField.ProcessingTimeMS
      +ResponseField.Other("processingTimingsMS")
    }
  }

  fun c29Constant(): SearchParamsObject = query {
    responseFields {
      +ResponseField.Hits
      +ResponseField.Exhaustive
      +ResponseField.ProcessingTimeMS
      +ResponseField.ProcessingTimingsMS
    }
  }

  fun c30(): SearchParamsObject = query {
    ruleContexts {
      +"desktop"
      +"ab-variant-b"
    }
  }
}

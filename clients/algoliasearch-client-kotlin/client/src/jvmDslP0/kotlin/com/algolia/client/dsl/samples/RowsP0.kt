@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

internal object RowsP0 {
  fun c01(): SearchParamsObject = query {
    query = "office"
    hitsPerPage = 2
    distinct = Distinct.of(1)
    getRankingInfo = true
    restrictHighlightAndSnippetArrays = true
    clickAnalytics = true
  }

  fun c04(): SearchParamsObject = query {
    filters { facet("genre", "comedy") }
    filters { facet("genre", "drama") }
  }

  val locales: DSLFilters.() -> Unit = {
    orFacet {
      facet("locale", "en-US")
      facet("locale", "fr-FR")
    }
  }
  val counts: DSLFilters.() -> Unit = { range("count", 0..10) }
  val featured: DSLFilters.() -> Unit = { tag("featured") }

  fun c05(): SearchParamsObject = query {
    filters {
      locales()
      counts()
      featured()
    }
  }

  fun c20(): DeleteByParams = deleteBy {
    filters {
      orFacet {
        facet("entityId", "e1")
        facet("entityId", "e2")
      }
    }
  }

  fun c20Search(): SearchParamsObject = query {
    filters {
      orFacet {
        facet("entityId", "e1")
        facet("entityId", "e2")
      }
    }
  }

  fun c32(): SearchParamsObject = query {
    filters {
      orFacet {
        facet("genre", "comedy", score = 0)
        facet("provider", "NBC")
      }
    }
    getRankingInfo = true
  }

  fun c34(): SearchParamsObject = query {
    distinct = Distinct.of(1)
    typoTolerance = TypoTolerance.of(TypoToleranceEnum.Min)
    ignorePlurals = IgnorePlurals.of(listOf(SupportedLanguage.En))
    removeStopWords = RemoveStopWords.of(true)
    userToken = "user-1"
    enablePersonalization = false
    synonyms = true
    enableReRanking = false
    analytics = false
  }

  fun x03(): SearchParamsObject = query {
    filters {
      orFacet {
        facet("color", "red")
        facet("category", "shirt", isNegated = true)
      }
    }
  }

  fun x07(): SearchParamsObject = query { filters { range("count", 0..9, isNegated = true) } }

  fun x08a(): SearchParamsObject = query { filters { facet("label", "-Movie") } }

  fun x08b(): SearchParamsObject = query { filters { facet("count", -12) } }

  fun x17a(): SearchParamsObject = query {
    filters {
      orFacet {
        facet("color", "red", score = 3)
        facet("color", "blue", score = 1)
      }
    }
    sumOrFiltersScores = true
    getRankingInfo = true
  }

  fun x17b(): SearchParamsObject = query {
    filters {
      orFacet {
        facet("color", "red", score = 0)
        facet("color", "blue", score = 2)
      }
    }
    getRankingInfo = true
  }
}

@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

internal object RowsP1 {
  fun c02(): SearchParamsObject = query { filters { and { facet("locale", "en-US") } } }

  val locales: FilterDsl.() -> Unit = {
    orFacet {
      facet("locale", "en-US")
      facet("locale", "fr-FR")
    }
  }
  val notPinned: FilterDsl.() -> Unit = { facet("isPinned", false) }
  val boost: FacetFilterDsl.() -> Unit = { or { facet("isFeatured", true, score = 500) } }

  fun c06(): SearchParamsObject = query {
    filters {
      locales()
      notPinned()
    }
    optionalFilters(boost)
    getRankingInfo = true
  }

  fun c07a(): SearchParamsObject = lookupById("e1")

  fun c07b(): SearchParamsObject =
    lookupById("e1", extraFilters = { facet("locale", "en-US") }, extraQuery = { hitsPerPage = 1 })

  fun c07c(): SearchParamsObject = lookupById("e1", extraFilters = { facet("locale", "fr-FR") })

  fun c15(): SearchParamsObject = query {
    filters {
      facet("genre", "comedy")
      facet("priority", 1)
      facet("isFeatured", true)
    }
  }

  fun c16a(): SearchParamsObject = query {
    filters {
      facet("genre", "comedy", isNegated = true)
      facet("isFeatured", true, isNegated = true)
      facet("priority", 1, isNegated = true)
    }
  }

  fun c16b(): SearchParamsObject = query {
    facetFilters { facet("genre", "comedy", isNegated = true) }
  }

  fun c17a(): SearchParamsObject = query { filters { and { addFacet(SUGGESTION_TYPE, "show") } } }

  fun c17b(): SearchParamsObject = query { filters { and { addFacet(PRIORITY, 2) } } }

  fun c17c(): SearchParamsObject = query {
    filters { and { addFacet(IS_PINNED, IsPinned.FALSE.value) } }
  }

  fun c17d(): SearchParamsObject = query {
    filters {
      and { addFacet(SUGGESTION_TYPE, "show") }
      and { addFacet(PRIORITY, 2) }
      and { addFacet(IS_PINNED, IsPinned.FALSE.value) }
    }
  }

  fun c19Filters(entityIds: List<String>, currentBatchId: String): FilterDsl.() -> Unit = {
    orFacet { entityIds.forEach { facet("entityId", it) } }
    and { facet("batchId", currentBatchId, isNegated = true) }
  }

  val entityIds: List<String> = listOf("e1", "e2", "e3")
  const val CURRENT_BATCH_ID: String = "b2"

  fun c19(): DeleteByParams = deleteBy { filters(c19Filters(entityIds, CURRENT_BATCH_ID)) }

  fun c19Search(): SearchParamsObject = query { filters(c19Filters(entityIds, CURRENT_BATCH_ID)) }

  fun c21(): SearchParamsObject = query {
    filters {
      orNumeric {
        range("count", 0..9)
        comparison("count", NumericOperator.Equals, 10)
      }
      orTag {
        tag("featured")
        tag("x")
      }
    }
  }

  fun c23(): SearchParamsObject = query {
    optionalFilters {
      or {
        facet("genre", "comedy", score = 500)
        facet("provider", "NBC", score = 500)
      }
    }
    sumOrFiltersScores = true
    getRankingInfo = true // test addition: needed to read the scores
  }

  fun c24(): SearchParamsObject = query {
    optionalFilters {
      and {
        facet("genre", "comedy", score = 2)
        facet("isFeatured", true, score = 3)
      }
      or { facet("provider", "NBC", score = 1, isNegated = true) }
    }
    getRankingInfo = true
  }

  fun c31a(): SearchParamsObject = query { filters { addFacet("batchId", "b2", isNegated = true) } }

  fun c31b(): SearchParamsObject = query {
    filters {
      orFacet {
        addFacet("genre", "comedy")
        addFacet("genre", "drama", score = 3)
      }
    }
    getRankingInfo = true
  }

  fun c31c(): SearchParamsObject = query {
    optionalFilters { addFacet("genre", "comedy") }
    getRankingInfo = true
  }

  fun c31d(): SearchParamsObject = query { filters { addFacet("genre", "comedy", score = null) } }

  fun c31e(): SearchParamsObject = query { filters { and { addFacet("priority", 2) } } }

  fun c31f(): SearchParamsObject = query {
    optionalFilters { or { addFacet("isFeatured", true, score = 500) } }
  }

  fun c31g(): SearchParamsObject = query {
    facetFilters { addFacet("genre", "comedy", score = null, isNegated = true) }
  }

  fun c33(): SearchParamsObject = query {
    optionalFilters {
      facet("genre", "comedy", score = 0)
      facet("provider", "NBC")
    }
    getRankingInfo = true
  }
}

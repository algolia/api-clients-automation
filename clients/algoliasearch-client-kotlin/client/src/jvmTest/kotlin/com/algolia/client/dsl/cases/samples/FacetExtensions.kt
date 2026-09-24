@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.cases.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

/*
 * User-side extensions of the filter DSL, as an application would write them: typed attribute
 * constants, an `addFacet` overload set that defaults `score` to 0, and a lookup helper that
 * injects caller filters into a fixed shape.
 */

internal const val SUGGESTION_TYPE: String = "suggestionType"
internal const val PRIORITY: String = "priority"
internal const val IS_PINNED: String = "isPinned"

internal enum class IsPinned(val value: Boolean) {
  TRUE(true),
  FALSE(false),
}

internal fun DSLFacet.addFacet(
  name: String,
  value: String,
  score: Int? = 0,
  isNegated: Boolean = false,
) {
  facet(name, value, score, isNegated)
}

internal fun DSLFacet.addFacet(
  name: String,
  value: Int,
  score: Int? = 0,
  isNegated: Boolean = false,
) {
  facet(name, value, score, isNegated)
}

internal fun DSLFacet.addFacet(
  name: String,
  value: Boolean,
  score: Int? = 0,
  isNegated: Boolean = false,
) {
  facet(name, value, score, isNegated)
}

internal fun lookupById(
  id: String,
  extraFilters: (DSLFilters.() -> Unit)? = null,
  extraQuery: (DSLQuery.() -> Unit)? = null,
): SearchParamsObject = query {
  filters {
    orFacet { facet("entityId", id) }
    extraFilters?.invoke(this)
  }
  attributesToHighlight = emptyList()
  getRankingInfo = false
  extraQuery?.invoke(this)
}

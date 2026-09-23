@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.model.search.BrowseParamsObject
import com.algolia.client.model.search.DeleteByParams
import com.algolia.client.model.search.IndexSettings
import com.algolia.client.model.search.SearchParamsObject
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * The receiver typealiases ([QueryBuilder], [BrowseBuilder], [DeleteByBuilder], [SettingsBuilder])
 * name the DSL receivers so callers can store fragments as `Alias.() -> Unit` and pass them to the
 * entry points without spelling the generated `*Builder` class names.
 */
internal class DslReceiversTest {

  @Test
  fun storedFragmentsCompose() {
    val locale: FilterDsl.() -> Unit = {
      orFacet {
        facet("locale", "en-US")
        facet("locale", "en-GB")
      }
    }
    val base: QueryBuilder.() -> Unit = {
      hitsPerPage = 20
      filters(locale)
    }
    assertEquals(
      SearchParamsObject(hitsPerPage = 20, filters = "(locale:en-US OR locale:en-GB)"),
      query(block = base),
    )

    val del: DeleteByBuilder.() -> Unit = { filters { facet("batchId", "b", isNegated = true) } }
    assertEquals(DeleteByParams(filters = "NOT batchId:b"), deleteBy(del))

    val s: SettingsBuilder.() -> Unit = { searchableAttributes { +"title" } }
    assertEquals(IndexSettings(searchableAttributes = listOf("title")), settings(s))

    val b: BrowseBuilder.() -> Unit = { query = "x" }
    assertEquals(BrowseParamsObject(query = "x"), browse(b))
  }
}

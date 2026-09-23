@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.samples

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.model.search.*

internal class QueryWrapper(private val base: QueryBuilder.() -> Unit = {}) {

  interface Additive {
    fun restrictSearchableAttributes(block: StringListDsl.() -> Unit)

    fun attributesToHighlight(block: StringListDsl.() -> Unit)

    fun filters(block: FilterDsl.() -> Unit)

    fun optionalFilters(block: FacetFilterDsl.() -> Unit)

    fun ruleContexts(block: StringListDsl.() -> Unit)
  }

  private val restrict = mutableListOf<StringListDsl.() -> Unit>()
  private val highlight = mutableListOf<StringListDsl.() -> Unit>()
  private val hardFilters = mutableListOf<FilterDsl.() -> Unit>()
  private val optional = mutableListOf<FacetFilterDsl.() -> Unit>()
  private val contexts = mutableListOf<StringListDsl.() -> Unit>()
  private val overrides = mutableListOf<QueryBuilder.() -> Unit>()

  fun add(block: Additive.() -> Unit) {
    block(
      object : Additive {
        override fun restrictSearchableAttributes(block: StringListDsl.() -> Unit) {
          restrict += block
        }

        override fun attributesToHighlight(block: StringListDsl.() -> Unit) {
          highlight += block
        }

        override fun filters(block: FilterDsl.() -> Unit) {
          hardFilters += block
        }

        override fun optionalFilters(block: FacetFilterDsl.() -> Unit) {
          optional += block
        }

        override fun ruleContexts(block: StringListDsl.() -> Unit) {
          contexts += block
        }
      }
    )
  }

  fun override(block: QueryBuilder.() -> Unit) {
    overrides += block
  }

  fun build(): SearchParamsObject = query {
    base()
    restrictSearchableAttributes { restrict.forEach { it() } }
    attributesToHighlight { highlight.forEach { it() } }
    filters { hardFilters.forEach { it() } }
    optionalFilters { optional.forEach { it() } }
    ruleContexts { contexts.forEach { it() } }
    overrides.forEach { it() }
  }
}

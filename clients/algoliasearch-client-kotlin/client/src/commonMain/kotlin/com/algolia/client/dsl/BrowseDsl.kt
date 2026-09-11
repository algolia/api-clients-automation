@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.BrowseParamsObjectBuilder
import com.algolia.client.model.search.BrowseParamsObject

/**
 * Constructs a [BrowseParamsObject] from the generated [BrowseParamsObjectBuilder].
 *
 * Last write wins: a later assignment to the same builder property replaces an earlier one. A later
 * `filters { }` or `filters = "..."` assignment replaces an earlier `filters` value. The same rule
 * applies to `facetFilters`, `optionalFilters`, `numericFilters`, and `tagFilters`. The DSL does
 * not merge filter parameters.
 *
 * ```
 * val params =
 *   browse {
 *     query = "shoes"
 *     filters { facet("brand", "Apple") }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun browse(block: BrowseParamsObjectBuilder.() -> Unit): BrowseParamsObject =
  BrowseParamsObjectBuilder().apply(block).build()

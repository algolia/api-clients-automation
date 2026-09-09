@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.filters as buildFilters
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

/**
 * Sets [BrowseParamsObjectBuilder.filters] from a typed filter block as a SQL string.
 *
 * Last write wins: this replaces any earlier `filters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun BrowseParamsObjectBuilder.filters(block: FilterDsl.() -> Unit) {
  filters = buildFilters(block).asSql()
}

/**
 * Sets [BrowseParamsObjectBuilder.facetFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `facetFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun BrowseParamsObjectBuilder.facetFilters(block: FilterDsl.() -> Unit) {
  facetFilters = buildFilters(block).asFacetFilters()
}

/**
 * Sets [BrowseParamsObjectBuilder.optionalFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `optionalFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun BrowseParamsObjectBuilder.optionalFilters(block: FilterDsl.() -> Unit) {
  optionalFilters = buildFilters(block).asOptionalFilters()
}

/**
 * Sets [BrowseParamsObjectBuilder.numericFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `numericFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun BrowseParamsObjectBuilder.numericFilters(block: FilterDsl.() -> Unit) {
  numericFilters = buildFilters(block).asNumericFilters()
}

/**
 * Sets [BrowseParamsObjectBuilder.tagFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `tagFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun BrowseParamsObjectBuilder.tagFilters(block: FilterDsl.() -> Unit) {
  tagFilters = buildFilters(block).asTagFilters()
}

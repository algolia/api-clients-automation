/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.querysuggestions

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Configuration of an Algolia index for Query Suggestions.
 *
 * @param indexName Name of the Algolia index to use as source for query suggestions.
 * @param replicas If true, Query Suggestions uses all replicas of the primary index to find popular searches. If false, only the primary index is used.
 * @param analyticsTags [Analytics tags](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) for filtering the popular searches.
 * @param facets Facets to use as top categories with your suggestions.  If provided, Query Suggestions adds the top facet values to each suggestion.
 * @param minHits Minimum number of hits required to be included as a suggestion.  A search query must at least generate `minHits` hits to be included in the Query Suggestions index.
 * @param minLetters Minimum letters required to be included as a suggestion.  A search query must be at least `minLetters` long to be included in the Query Suggestions index.
 * @param generate
 * @param `external` Algolia indices with popular searches to use as query suggestions.  Records of these indices must have these attributes:    - `query`: search query which will be added as a suggestion   - `count`: measure of popularity of that search query  For example, you can export popular searches from an external analytics tool, such as Google Analytics or Adobe Analytics, and feed this data into an external Algolia index. You can use this external index to generate query suggestions until your Algolia analytics has collected enough data.
 */
@Serializable
public data class SourceIndex(

  /** Name of the Algolia index to use as source for query suggestions. */
  @SerialName(value = "indexName") val indexName: String,

  /** If true, Query Suggestions uses all replicas of the primary index to find popular searches. If false, only the primary index is used.  */
  @SerialName(value = "replicas") val replicas: Boolean? = null,

  /** [Analytics tags](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) for filtering the popular searches.  */
  @SerialName(value = "analyticsTags") val analyticsTags: List<String>? = null,

  /** Facets to use as top categories with your suggestions.  If provided, Query Suggestions adds the top facet values to each suggestion.  */
  @SerialName(value = "facets") val facets: List<Facet>? = null,

  /** Minimum number of hits required to be included as a suggestion.  A search query must at least generate `minHits` hits to be included in the Query Suggestions index.  */
  @SerialName(value = "minHits") val minHits: Int? = null,

  /** Minimum letters required to be included as a suggestion.  A search query must be at least `minLetters` long to be included in the Query Suggestions index.  */
  @SerialName(value = "minLetters") val minLetters: Int? = null,

  @SerialName(value = "generate") val generate: List<List<String>>? = null,

  /** Algolia indices with popular searches to use as query suggestions.  Records of these indices must have these attributes:    - `query`: search query which will be added as a suggestion   - `count`: measure of popularity of that search query  For example, you can export popular searches from an external analytics tool, such as Google Analytics or Adobe Analytics, and feed this data into an external Algolia index. You can use this external index to generate query suggestions until your Algolia analytics has collected enough data.  */
  @SerialName(value = "external") val `external`: List<String>? = null,
)

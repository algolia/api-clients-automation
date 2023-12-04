/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.algolia.client.model.search


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * OK
 *
 * @param query Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users.
 * @param clusterName Cluster name.
 * @param page Page to retrieve (the first page is `0`, not `1`).
 * @param hitsPerPage Number of hits per page.
 */
@Serializable

data class SearchUserIdsParams (

    /* Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users. */
    @SerialName(value = "query") @Required val query: String,

    /* Cluster name. */
    @SerialName(value = "clusterName") val clusterName: String? = null,

    /* Page to retrieve (the first page is `0`, not `1`). */
    @SerialName(value = "page") val page: Int? = 0,

    /* Number of hits per page. */
    @SerialName(value = "hitsPerPage") val hitsPerPage: Int? = 20

)


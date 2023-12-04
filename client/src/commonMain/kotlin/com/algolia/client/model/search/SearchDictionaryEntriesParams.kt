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
 * `searchDictionaryEntries` parameters. 
 *
 * @param query Text to search for in an index.
 * @param page Page to retrieve (the first page is `0`, not `1`).
 * @param hitsPerPage Number of hits per page.
 * @param language [Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/). 
 */
@Serializable

data class SearchDictionaryEntriesParams (

    /* Text to search for in an index. */
    @SerialName(value = "query") @Required val query: String = "",

    /* Page to retrieve (the first page is `0`, not `1`). */
    @SerialName(value = "page") val page: Int? = 0,

    /* Number of hits per page. */
    @SerialName(value = "hitsPerPage") val hitsPerPage: Int? = 20,

    /* [Supported language ISO code](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/).  */
    @SerialName(value = "language") val language: String? = null

)


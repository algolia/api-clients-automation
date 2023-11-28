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

import com.algolia.client.model.search.RedirectRuleIndexMetadata

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * [Redirect results to a URL](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/redirects/). 
 *
 * @param index 
 */
@Serializable

data class Redirect (

    @SerialName(value = "index") val index: kotlin.collections.List<RedirectRuleIndexMetadata>? = null

)


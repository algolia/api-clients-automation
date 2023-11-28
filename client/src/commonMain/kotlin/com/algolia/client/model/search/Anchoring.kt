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

/**
 * Whether the pattern parameter matches the beginning (`startsWith`) or end (`endsWith`) of the query string, is an exact match (`is`), or a partial match (`contains`).
 *
 * Values: `is`,startsWith,endsWith,contains
 */
@Serializable
enum class Anchoring(val value: String) {

    @SerialName(value = "is")
    `is`("is"),

    @SerialName(value = "startsWith")
    startsWith("startsWith"),

    @SerialName(value = "endsWith")
    endsWith("endsWith"),

    @SerialName(value = "contains")
    contains("contains");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is Anchoring) "$data" else null

        /**
         * Returns a valid [Anchoring] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): Anchoring? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}


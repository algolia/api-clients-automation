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
 * 
 *
 * Values: settings,synonyms,rules
 */
@Serializable
enum class ScopeType(val value: String) {

    @SerialName(value = "settings")
    settings("settings"),

    @SerialName(value = "synonyms")
    synonyms("synonyms"),

    @SerialName(value = "rules")
    rules("rules");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is ScopeType) "$data" else null

        /**
         * Returns a valid [ScopeType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): ScopeType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}


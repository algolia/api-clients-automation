/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * SourceInput
 *
 * Implementations:
 * - [SourceBigCommerce]
 * - [SourceBigQuery]
 * - [SourceCSV]
 * - [SourceCommercetools]
 * - [SourceDocker]
 * - [SourceGA4BigQueryExport]
 * - [SourceJSON]
 * - [SourceShopify]
 */
@Serializable(SourceInputSerializer::class)
public sealed interface SourceInput {
  @Serializable
  @JvmInline
  public value class SourceGA4BigQueryExportValue(public val value: SourceGA4BigQueryExport) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceDockerValue(public val value: SourceDocker) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceCommercetoolsValue(public val value: SourceCommercetools) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceBigCommerceValue(public val value: SourceBigCommerce) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceBigQueryValue(public val value: SourceBigQuery) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceShopifyValue(public val value: SourceShopify) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceJSONValue(public val value: SourceJSON) : SourceInput

  @Serializable
  @JvmInline
  public value class SourceCSVValue(public val value: SourceCSV) : SourceInput

  public companion object {

    public fun of(value: SourceGA4BigQueryExport): SourceInput = SourceGA4BigQueryExportValue(value)

    public fun of(value: SourceDocker): SourceInput = SourceDockerValue(value)

    public fun of(value: SourceCommercetools): SourceInput = SourceCommercetoolsValue(value)

    public fun of(value: SourceBigCommerce): SourceInput = SourceBigCommerceValue(value)

    public fun of(value: SourceBigQuery): SourceInput = SourceBigQueryValue(value)

    public fun of(value: SourceShopify): SourceInput = SourceShopifyValue(value)

    public fun of(value: SourceJSON): SourceInput = SourceJSONValue(value)

    public fun of(value: SourceCSV): SourceInput = SourceCSVValue(value)
  }
}

internal class SourceInputSerializer : JsonContentPolymorphicSerializer<SourceInput>(SourceInput::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<SourceInput> = when {
    element is JsonObject && element.containsKey("projectID") && element.containsKey("datasetID") && element.containsKey("tablePrefix") -> SourceGA4BigQueryExport.serializer()
    element is JsonObject && element.containsKey("image") && element.containsKey("configuration") -> SourceDocker.serializer()
    element is JsonObject && element.containsKey("projectKey") -> SourceCommercetools.serializer()
    element is JsonObject && element.containsKey("storeHash") -> SourceBigCommerce.serializer()
    element is JsonObject && element.containsKey("projectID") -> SourceBigQuery.serializer()
    element is JsonObject && element.containsKey("shopURL") -> SourceShopify.serializer()
    element is JsonObject -> SourceJSON.serializer()
    element is JsonObject -> SourceCSV.serializer()
    else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
  }
}

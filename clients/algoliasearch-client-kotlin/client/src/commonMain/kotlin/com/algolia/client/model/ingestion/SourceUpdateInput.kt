/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * SourceUpdateInput
 */
@Serializable(SourceUpdateInputSerializer::class)
public sealed interface SourceUpdateInput {

  public companion object {

    /**
     * SourceBigQuery
     *
     * @param projectID Project ID of the BigQuery Source.
     * @param datasetID Dataset ID of the BigQuery Source.
     * @param dataType
     * @param table Table name (for default BQ).
     * @param tablePrefix Table prefix (for Google Analytics).
     * @param customSQLRequest Custom SQL request to extract data from the BigQuery table.
     * @param uniqueIDColumn The name of the column that contains the unique ID, used as `objectID` in Algolia.
     */
    public fun SourceBigQuery(
      projectID: String,
      datasetID: String,
      dataType: BigQueryDataType? = null,
      table: String? = null,
      tablePrefix: String? = null,
      customSQLRequest: String? = null,
      uniqueIDColumn: String? = null,
    ): SourceBigQuery = com.algolia.client.model.ingestion.SourceBigQuery(
      projectID = projectID,
      datasetID = datasetID,
      dataType = dataType,
      table = table,
      tablePrefix = tablePrefix,
      customSQLRequest = customSQLRequest,
      uniqueIDColumn = uniqueIDColumn,
    )

    /**
     * SourceCSV
     *
     * @param url The URL of the file.
     * @param uniqueIDColumn The name of the column that contains the unique ID, used as `objectID` in Algolia.
     * @param mapping Mapping of type for every column. For example {\"myColumn\": \"boolean\", \"myOtherColumn\": \"json\"}.
     * @param method
     * @param delimiter The character used to split the value on each line, default to a comma (\\r, \\n, 0xFFFD, and space are forbidden).
     */
    public fun SourceCSV(
      url: String,
      uniqueIDColumn: String? = null,
      mapping: Map<kotlin.String, MappingTypeCSV>? = null,
      method: MethodType? = null,
      delimiter: String? = null,
    ): SourceCSV = com.algolia.client.model.ingestion.SourceCSV(
      url = url,
      uniqueIDColumn = uniqueIDColumn,
      mapping = mapping,
      method = method,
      delimiter = delimiter,
    )

    /**
     * SourceDocker
     *
     * @param registry
     * @param image The name of the image to pull.
     * @param imageType
     * @param configuration The configuration of the spec.
     * @param version The version of the image, defaults to `latest`.
     * @param outputFile The full name of the output file.
     */
    public fun SourceDocker(
      registry: DockerRegistry,
      image: String,
      imageType: DockerImageType,
      configuration: JsonObject,
      version: String? = null,
      outputFile: String? = null,
    ): SourceDocker = com.algolia.client.model.ingestion.SourceDocker(
      registry = registry,
      image = image,
      imageType = imageType,
      configuration = configuration,
      version = version,
      outputFile = outputFile,
    )

    /**
     * SourceJSON
     *
     * @param url The URL of the file.
     * @param uniqueIDColumn The name of the column that contains the unique ID, used as `objectID` in Algolia.
     * @param method
     */
    public fun SourceJSON(
      url: String,
      uniqueIDColumn: String? = null,
      method: MethodType? = null,
    ): SourceJSON = com.algolia.client.model.ingestion.SourceJSON(
      url = url,
      uniqueIDColumn = uniqueIDColumn,
      method = method,
    )

    /**
     * SourceUpdateCommercetools
     *
     * @param storeKeys Unique and immutable key of the referenced Store.
     * @param locales Array of locales that must match the following pattern: ^[a-z]{2}(-[A-Z]{2})?$. For example [\"fr-FR\", \"en\"].
     */
    public fun SourceUpdateCommercetools(
      storeKeys: List<String>? = null,
      locales: List<String>? = null,
    ): SourceUpdateCommercetools = com.algolia.client.model.ingestion.SourceUpdateCommercetools(
      storeKeys = storeKeys,
      locales = locales,
    )
  }
}

internal class SourceUpdateInputSerializer : KSerializer<SourceUpdateInput> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("SourceUpdateInput")

  override fun serialize(encoder: Encoder, value: SourceUpdateInput) {
    when (value) {
      is SourceBigQuery -> SourceBigQuery.serializer().serialize(encoder, value)
      is SourceCSV -> SourceCSV.serializer().serialize(encoder, value)
      is SourceDocker -> SourceDocker.serializer().serialize(encoder, value)
      is SourceJSON -> SourceJSON.serializer().serialize(encoder, value)
      is SourceUpdateCommercetools -> SourceUpdateCommercetools.serializer().serialize(encoder, value)
    }
  }

  override fun deserialize(decoder: Decoder): SourceUpdateInput {
    val codec = decoder.asJsonDecoder()
    val tree = codec.decodeJsonElement()

    // deserialize SourceBigQuery
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<SourceBigQuery>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize SourceBigQuery (error: ${e.message})")
      }
    }

    // deserialize SourceCSV
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<SourceCSV>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize SourceCSV (error: ${e.message})")
      }
    }

    // deserialize SourceDocker
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<SourceDocker>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize SourceDocker (error: ${e.message})")
      }
    }

    // deserialize SourceJSON
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<SourceJSON>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize SourceJSON (error: ${e.message})")
      }
    }

    // deserialize SourceUpdateCommercetools
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<SourceUpdateCommercetools>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize SourceUpdateCommercetools (error: ${e.message})")
      }
    }

    throw AlgoliaClientException("Failed to deserialize json element: $tree")
  }
}

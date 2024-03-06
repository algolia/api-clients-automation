/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

/** Transformations to apply to source, serialized as a JSON string.
  *
  * @param format
  *   Name of the mapping format schema, `mappingkit/v1` is currently the only supported format.
  */
case class MappingInput(
    format: String,
    actions: Seq[MappingKitAction]
)

/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import algoliasearch.ingestion.DockerImageType._
import algoliasearch.ingestion.DockerRegistry._

/** SourceDocker
  *
  * @param image
  *   The name of the image to pull.
  * @param version
  *   The version of the image, defaults to `latest`.
  * @param configuration
  *   The configuration of the spec.
  */
case class SourceDocker(
    imageType: DockerImageType,
    registry: DockerRegistry,
    image: String,
    version: Option[String] = scala.None,
    configuration: Any
) extends SourceInputTrait

object SourceDockerEnums {}

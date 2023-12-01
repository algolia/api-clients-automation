/** Search API Use the Search REST API to manage your data (indices and records), implement search, and improve
  * relevance (with Rules, synonyms, and language dictionaries). Although Algolia provides a REST API, you should use
  * the official open source API [clients, libraries, and
  * tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no
  * [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.search

import org.json4s.{Extraction, Formats, JObject, JValue, Serializer, TypeInfo}

/** A single hit.
  *
  * @param objectID
  *   Unique object identifier.
  * @param highlightResult
  *   Show highlighted section and words matched on a query.
  * @param snippetResult
  *   Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
  */
case class Hit(
    objectID: String,
    highlightResult: Option[Map[String, HighlightResult]] = scala.None,
    snippetResult: Option[Map[String, SnippetResult]] = scala.None,
    rankingInfo: Option[RankingInfo] = scala.None,
    distinctSeqID: Option[Int] = scala.None,
    additionalProperties: Map[String, JValue] = Map.empty
)

class HitSerializer extends Serializer[Hit] {

  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Hit] = {
    case (TypeInfo(clazz, _), json) if clazz == classOf[Hit] =>
      json match {
        case jobject: JObject =>
          val formats = format - this
          val mf = manifest[Hit]
          val obj = Extraction.extract[Hit](jobject)(formats, mf)
          val properties =
            jobject.obj.toMap - "objectID" - "highlightResult" - "snippetResult" - "rankingInfo" - "distinctSeqID"
          obj.copy(additionalProperties = properties)
        case _ => throw new IllegalArgumentException(s"Can't deserialize $json as Hit")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: Hit =>
    val formats = format - this // remove current serializer from formats to avoid stackoverflow
    Extraction.decompose(value.copy(additionalProperties = Map.empty))(formats) merge Extraction.decompose(
      value.additionalProperties
    )(formats)
  }
}

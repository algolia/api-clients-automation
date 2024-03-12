/** Recommend API The Recommend API lets you generate recommendations with several AI models. > **Note**: You should use
  * Algolia's [libraries and
  * tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with
  * the Recommend API. Using the HTTP endpoints directly is not covered by the
  * [SLA](https://www.algolia.com/policies/sla/).
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.recommend

import org.json4s._

sealed trait ExactOnSingleWordQuery

/** Determines how the [Exact ranking
  * criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes)
  * is computed when the search query has only one word. <dl> <dt><code>attribute</code></dt> <dd> The Exact ranking
  * criterion is 1 if the query word and attribute value are the same. For example, a search for \"road\" will match the
  * value \"road\", but not \"road trip\". </dd> <dt><code>none</code></dt> <dd> The Exact ranking criterion is ignored
  * on single-word searches. </dd> <dt><code>word</code></dt> <dd> The Exact ranking criterion is 1 if the query word is
  * found in the attribute value. The query word must have at least 3 characters and must not be a stop word. </dd>
  * </dl> If `exactOnSingleWordQuery` is `word`, only exact matches will be highlighted, partial and prefix matches
  * won't.
  */
object ExactOnSingleWordQuery {
  case object Attribute extends ExactOnSingleWordQuery {
    override def toString = "attribute"
  }
  case object None extends ExactOnSingleWordQuery {
    override def toString = "none"
  }
  case object Word extends ExactOnSingleWordQuery {
    override def toString = "word"
  }
  val values: Seq[ExactOnSingleWordQuery] = Seq(Attribute, None, Word)

  def withName(name: String): ExactOnSingleWordQuery = ExactOnSingleWordQuery.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown ExactOnSingleWordQuery value: $name"))
}

class ExactOnSingleWordQuerySerializer
    extends CustomSerializer[ExactOnSingleWordQuery](_ =>
      (
        {
          case JString(value) => ExactOnSingleWordQuery.withName(value)
          case JNull          => null
        },
        { case value: ExactOnSingleWordQuery =>
          JString(value.toString)
        }
      )
    )

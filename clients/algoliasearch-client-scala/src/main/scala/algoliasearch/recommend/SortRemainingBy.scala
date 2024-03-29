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

sealed trait SortRemainingBy

/** Order of facet values that aren't explicitly positioned with the `order` setting. <dl> <dt><code>count</code></dt>
  * <dd> Order remaining facet values by decreasing count. The count is the number of matching records containing this
  * facet value. </dd> <dt><code>alpha</code></dt> <dd>Sort facet values alphabetically.</dd>
  * <dt><code>hidden</code></dt> <dd>Don't show facet values that aren't explicitly positioned.</dd> </dl>.
  */
object SortRemainingBy {
  case object Count extends SortRemainingBy {
    override def toString = "count"
  }
  case object Alpha extends SortRemainingBy {
    override def toString = "alpha"
  }
  case object Hidden extends SortRemainingBy {
    override def toString = "hidden"
  }
  val values: Seq[SortRemainingBy] = Seq(Count, Alpha, Hidden)

  def withName(name: String): SortRemainingBy = SortRemainingBy.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown SortRemainingBy value: $name"))
}

class SortRemainingBySerializer
    extends CustomSerializer[SortRemainingBy](_ =>
      (
        {
          case JString(value) => SortRemainingBy.withName(value)
          case JNull          => null
        },
        { case value: SortRemainingBy =>
          JString(value.toString)
        }
      )
    )

/** Algolia Monitoring API The Monitoring API lets you check the status and performance of your Algolia infrastructure.
  * > **Note**: The Monitoring API is available on [Premium plans](https://www.algolia.com/pricing/) and plans including
  * the Enterprise add-on.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.monitoring

import org.json4s._

sealed trait Metric

/** Metric enumeration
  */
object Metric {
  case object AvgBuildTime extends Metric {
    override def toString = "avg_build_time"
  }
  case object SsdUsage extends Metric {
    override def toString = "ssd_usage"
  }
  case object RamSearchUsage extends Metric {
    override def toString = "ram_search_usage"
  }
  case object RamIndexingUsage extends Metric {
    override def toString = "ram_indexing_usage"
  }
  case object CpuUsage extends Metric {
    override def toString = "cpu_usage"
  }
  case object Star extends Metric {
    override def toString = "*"
  }
  val values: Seq[Metric] = Seq(AvgBuildTime, SsdUsage, RamSearchUsage, RamIndexingUsage, CpuUsage, Star)

  def withName(name: String): Metric = Metric.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown Metric value: $name"))
}

class MetricSerializer
    extends CustomSerializer[Metric](_ =>
      (
        {
          case JString(value) => Metric.withName(value)
          case JNull          => null
        },
        { case value: Metric =>
          JString(value.toString)
        }
      )
    )

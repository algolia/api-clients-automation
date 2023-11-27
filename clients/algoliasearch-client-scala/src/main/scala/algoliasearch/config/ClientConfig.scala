package algoliasearch.config

import scala.concurrent.duration.Duration

trait ClientConfig {
  val connectTimeout: Duration
  val writeTimeout: Duration
  val readTimeout: Duration
  val logging: Option[Logging]
  val defaultHeaders: Map[String, String]
  val compressionType: CompressionType
}

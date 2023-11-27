package algoliasearch.config

import scala.concurrent.duration.Duration

/** RequestOptions are used to pass extra parameters, headers, and timeouts to the request. Parameters set in the
  * request option will override the default parameter.
  *
  * @param headers
  *   HTTP headers
  * @param queryParameters
  *   HTTP query parameters
  * @param readTimeout
  *   HTTP read timeout
  * @param writeTimeout
  *   HTTP write timeout
  */
case class RequestOptions(
    headers: Map[String, String] = Map.empty,
    queryParameters: Map[String, String] = Map.empty,
    readTimeout: Option[Duration] = None,
    writeTimeout: Option[Duration] = None
)

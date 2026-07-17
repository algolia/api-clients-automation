package algoliasearch.config

/** Full HTTP response returned by the `*WithHTTPInfo` method derivatives.
  *
  * @param statusCode
  *   the HTTP status code
  * @param headers
  *   the response headers, with lowercase names
  * @param body
  *   the raw response body, empty for 204/empty responses
  * @param data
  *   the deserialized response body, `None` for 204/empty responses
  * @tparam T
  *   the type of the deserialized response body
  */
case class AlgoliaHttpResponse[T](
    statusCode: Int,
    headers: Map[String, Seq[String]],
    body: String,
    data: Option[T]
)

package algoliasearch.config

import algoliasearch.internal.util._

import scala.collection.mutable

/** Represents an HTTP request.
  *
  * @param method
  *   HTTP method
  * @param path
  *   HTTP path
  * @param read
  *   Whether this request is a read request
  * @param headers
  *   HTTP headers
  * @param queryParameters
  *   HTTP query parameters
  * @param body
  *   HTTP body
  */
case class HttpRequest(
    method: String,
    path: String,
    read: Boolean = false,
    headers: Map[String, String] = Map.empty,
    queryParameters: Map[String, String] = Map.empty,
    body: Option[Any] = None
)

object HttpRequest {

  /** Builder for [[HttpRequest]].
    */
  class Builder {
    private var method: String = _
    private var path: String = _
    private var read: Boolean = false
    private val headers: mutable.Map[String, String] = mutable.Map()
    private val queryParameters: mutable.Map[String, String] = mutable.Map()
    private var body: Option[Any] = None

    def withMethod(method: String) = {
      this.method = method
      this
    }

    def withPath(path: String) = {
      this.path = path
      this
    }

    def withRead(read: Boolean) = {
      this.read = read
      this
    }

    def withQueryParameter(key: String, value: Any) = {
      this.queryParameters += key -> paramToString(value)
      this
    }

    def withQueryParameters(queryParameters: Map[String, Any]) = {
      for ((key, value) <- queryParameters)
        withQueryParameter(key, value)
      this
    }

    def withBody(body: Any) = {
      this.body = Some(body)
      this
    }

    def withHeader(key: String, value: Any): HttpRequest.Builder = {
      this.headers += key -> paramToString(value)
      this
    }

    def withHeaders(headers: Map[String, Any]): HttpRequest.Builder = {
      for ((key, value) <- headers)
        withHeader(key, value)
      this
    }

    def build() =
      HttpRequest(
        method,
        path,
        read,
        headers.toMap,
        queryParameters.toMap,
        body
      )
  }

  /** Create a new [[HttpRequest]] builder.
    */
  def builder() = new Builder
}

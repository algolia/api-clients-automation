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

    def withMethod(method: String): Builder = {
      this.method = method
      this
    }

    def withPath(path: String): Builder = {
      this.path = path
      this
    }

    def withPathEncoded(path: String): Builder = {
      this.path = path
      this
    }

    def withRead(read: Boolean): Builder = {
      this.read = read
      this
    }

    def withQueryParameter(key: String, value: Any): Builder = {
      this.queryParameters += key -> paramToString(value)
      this
    }

    def withQueryParameter(key: String, value: Option[Any]): Builder = {
      value match {
        case Some(param) => withQueryParameter(key, param)
        case None        => this
      }
    }

    def withQueryParameters(queryParameters: Option[Map[String, Any]]): Builder = {
      queryParameters match {
        case Some(parameters) => withQueryParameters(parameters)
        case None             => this
      }
    }

    def withQueryParameters(queryParameters: Map[String, Any]): Builder = {
      for ((key, value) <- queryParameters)
        withQueryParameter(key, value)
      this
    }

    def withBody(body: Any): Builder = {
      this.body = Some(body)
      this
    }

    def withBody(body: Option[Any]): Builder = {
      this.body = body
      this
    }

    def withHeader(key: String, value: Any): HttpRequest.Builder = {
      this.headers += key.toLowerCase -> paramToString(value)
      this
    }

    def withHeaders(headers: Map[String, Any]): HttpRequest.Builder = {
      for ((key, value) <- headers)
        withHeader(key, value)
      this
    }

    def build(): HttpRequest =
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

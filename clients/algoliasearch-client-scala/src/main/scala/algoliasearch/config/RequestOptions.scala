package algoliasearch.config

import algoliasearch.internal.util.paramToString

import scala.collection.mutable
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
  * @param connectTimeout
  *   HTTP connect timeout
  */
case class RequestOptions(
    headers: Map[String, String] = Map.empty,
    queryParameters: Map[String, String] = Map.empty,
    readTimeout: Option[Duration] = None,
    writeTimeout: Option[Duration] = None,
    connectTimeout: Option[Duration] = None
) {
  def +(other: Option[RequestOptions]): RequestOptions = {
    val some = other.getOrElse(return this)
    new RequestOptions(
      headers = this.headers ++ some.headers,
      queryParameters = this.queryParameters ++ some.queryParameters,
      readTimeout = some.readTimeout.orElse(this.readTimeout),
      writeTimeout = some.writeTimeout.orElse(this.writeTimeout),
      connectTimeout = some.connectTimeout.orElse(this.connectTimeout)
    )
  }
}

object RequestOptions {

  /** Builder for [[RequestOptions]].
    */
  class Builder() {
    private val headers: mutable.Map[String, String] = mutable.Map()
    private val queryParameters: mutable.Map[String, String] = mutable.Map()
    private var readTimeout: Option[Duration] = None
    private var writeTimeout: Option[Duration] = None
    private var connectTimeout: Option[Duration] = None

    /** Adds a header to the request.
      */
    def withHeader(key: String, value: Any): Builder = {
      this.headers += (key -> paramToString(value))
      this
    }

    /** Adds a query parameter to the request.
      */
    def withQueryParameter(key: String, value: Any): Builder = {
      this.queryParameters += (key -> paramToString(value))
      this
    }

    /** Sets the read timeout for the request.
      */
    def withReadTimeout(readTimeout: Option[Duration]): Builder = {
      this.readTimeout = readTimeout
      this
    }

    /** Sets the write timeout for the request.
      */
    def withWriteTimeout(writeTimeout: Option[Duration]): Builder = {
      this.writeTimeout = writeTimeout
      this
    }

    /** Sets the write timeout for the request.
      */
    def withConnectTimeout(connectTimeout: Option[Duration]): Builder = {
      this.connectTimeout = connectTimeout
      this
    }

    /** Builds the [[RequestOptions]].
      */
    def build(): RequestOptions = {
      RequestOptions(
        headers = headers.toMap,
        queryParameters = queryParameters.toMap,
        readTimeout = readTimeout,
        writeTimeout = writeTimeout,
        connectTimeout = connectTimeout
      )
    }
  }

  /** Returns a new [[Builder]] instance.
    */
  def builder(): Builder = new Builder()
}

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
  */
case class RequestOptions(
    headers: Map[String, String] = Map.empty,
    queryParameters: Map[String, String] = Map.empty,
    readTimeout: Option[Duration] = None,
    writeTimeout: Option[Duration] = None
)

object RequestOptions {

  /** Builder for [[RequestOptions]].
    */
  class Builder() {
    private val headers: mutable.Map[String, String] = mutable.Map()
    private val queryParameters: mutable.Map[String, String] = mutable.Map()
    private var readTimeout: Option[Duration] = None
    private var writeTimeout: Option[Duration] = None

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

    /** Builds the [[RequestOptions]].
      */
    def build(): RequestOptions = {
      RequestOptions(
        headers = headers.toMap,
        queryParameters = queryParameters.toMap,
        readTimeout = readTimeout,
        writeTimeout = writeTimeout
      )
    }
  }

  /** Returns a new [[Builder]] instance.
    */
  def builder(): Builder = new Builder()
}

package algoliasearch.internal

import algoliasearch.config.RequestOptions

import java.util.concurrent.ThreadLocalRandom

/** Generates and detects the `Request-ID` that ties every attempt of one logical operation together in Algolia's logs.
  * It is a trace identifier: a retried write is still applied twice.
  */
private[algoliasearch] object RequestId {

  /** Name of the header carrying the Request-ID. */
  val HeaderName: String = "request-id"

  /** Name of the query parameter carrying the Request-ID. */
  val QueryParameterName: String = "x-algolia-request-id"

  private val Base62Chars: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
  private val IdLength: Int = 11

  /** Returns a new 11-character base62 Request-ID. */
  def generate(): String = {
    val random = ThreadLocalRandom.current()
    Array.fill(IdLength)(Base62Chars.charAt(random.nextInt(Base62Chars.length))).mkString
  }

  /** Whether the given request options already carry a Request-ID, on either channel.
    *
    * @param requestOptions
    *   the request options to inspect
    */
  def isPresent(requestOptions: Option[RequestOptions]): Boolean = requestOptions.exists { options =>
    options.headers.keys.exists(_.equalsIgnoreCase(HeaderName)) ||
    options.queryParameters.keys.exists(_.equalsIgnoreCase(QueryParameterName))
  }
}

package algoliasearch

import algoliasearch.config._
import algoliasearch.exception.AlgoliaClientException
import algoliasearch.internal.interceptor.{AuthInterceptor, RequestIdInterceptor, RetryStrategy, UserAgentInterceptor}
import algoliasearch.internal.{AlgoliaAgent, HttpRequester, RequestId, StatefulHost}
import org.json4s.Formats

import scala.concurrent.duration.Duration
import scala.util.Try

/** Base class for all API clients. It provides a mechanism for request serialization and deserialization. It also
  * provides a mechanism for retrying requests on failure. It is responsible for closing the underlying HTTP client.
  *
  * @param appId
  *   the application ID
  * @param apiKey
  *   the API key
  * @param clientName
  *   the name of the client
  * @param defaultHosts
  *   the default hosts
  * @param defaultReadTimeout
  *   the default read timeout
  * @param defaultConnectTimeout
  *   the default connect timeout
  * @param defaultWriteTimeout
  *   the default write timeout
  * @param formats
  *   the JSON formats
  * @param options
  *   the client options
  * @param requestIdSupport
  *   whether the target API accepts a `Request-ID`. Only the search cluster clients do.
  */
abstract class ApiClient(
    appId: String,
    apiKey: String,
    clientName: String,
    defaultHosts: Seq[Host],
    defaultReadTimeout: Duration,
    defaultConnectTimeout: Duration,
    defaultWriteTimeout: Duration,
    formats: Formats,
    options: ClientOptions = ClientOptions(),
    requestIdSupport: Boolean = false
) extends AutoCloseable {

  if (appId == null || appId.isEmpty) {
    throw AlgoliaClientException("`appId` is missing.")
  }
  if (apiKey == null || apiKey.isEmpty) {
    throw AlgoliaClientException("`apiKey` is missing.")
  }

  /** The logger from the client options, or [[Logger.Default]] when logging is not configured. */
  private[algoliasearch] val logger: Logger =
    options.logging.map(_.logger).getOrElse(Logger.Default)

  private val authInterceptor = new AuthInterceptor(appId, apiKey)

  private val requester = options.customRequester match {
    case Some(customRequester) => customRequester
    case None =>
      defaultRequester(
        appId,
        apiKey,
        clientName,
        options,
        defaultHosts,
        defaultReadTimeout,
        defaultConnectTimeout,
        defaultWriteTimeout
      )
  }

  private def defaultRequester(
      appId: String,
      apiKey: String,
      clientName: String,
      options: ClientOptions,
      defaultHosts: Seq[Host],
      defaultReadTimeout: Duration,
      defaultConnectTimeout: Duration,
      defaultWriteTimeout: Duration
  ): Requester = {
    val optionsWithDefaultTimeouts = options.copy(
      readTimeout = defaultReadTimeout,
      connectTimeout = defaultConnectTimeout,
      writeTimeout = defaultWriteTimeout
    )

    val algoliaAgent = AlgoliaAgent(BuildInfo.version)
      .addSegment(AgentSegment(clientName, Some(BuildInfo.version)))
      .addSegments(optionsWithDefaultTimeouts.agentSegments)

    val hosts = if (optionsWithDefaultTimeouts.hosts.isEmpty) defaultHosts else optionsWithDefaultTimeouts.hosts
    val statefulHosts = hosts.map(host => StatefulHost(host)).toList

    val builder = HttpRequester
      .builder(optionsWithDefaultTimeouts.customFormats.getOrElse(formats))
      .withInterceptor(authInterceptor)
      .withInterceptor(new UserAgentInterceptor(algoliaAgent))

    if (requestIdSupport) {
      builder.withInterceptor(new RequestIdInterceptor())
    }
    builder.withInterceptor(new RetryStrategy(statefulHosts))

    optionsWithDefaultTimeouts.requesterConfig.foreach(_(builder))

    builder.build(optionsWithDefaultTimeouts)
  }

  /** Executes the given request and returns the response.
    *
    * @param httpRequest
    *   the request to execute
    * @param requestOptions
    *   the request options
    * @tparam T
    *   the type of the returned object
    * @return
    *   the deserialized response
    */
  protected def execute[T: Manifest](
      httpRequest: HttpRequest,
      requestOptions: Option[RequestOptions] = None
  ): T = requester.execute(httpRequest, requestOptions)

  /** Executes the given request and returns the full HTTP response.
    *
    * @param httpRequest
    *   the request to execute
    * @param requestOptions
    *   the request options
    * @tparam T
    *   the type of the deserialized response body
    * @return
    *   the full HTTP response
    */
  protected def executeWithHttpInfo[T: Manifest](
      httpRequest: HttpRequest,
      requestOptions: Option[RequestOptions] = None
  ): AlgoliaHttpResponse[T] = requester.executeWithHttpInfo(httpRequest, requestOptions)

  private val requestIdInDefaults: Boolean =
    options.defaultHeaders.keys.exists(_.equalsIgnoreCase(RequestId.HeaderName))

  /** Returns request options carrying a `Request-ID`, so that every request a multi-request helper performs shares one
    * identifier. Returns the options unchanged when the client has no Request-ID support or when the caller already
    * supplied one, per call or in the client's default headers.
    *
    * @param requestOptions
    *   the request options given to the helper
    */
  private[algoliasearch] def withRequestId(
      requestOptions: Option[RequestOptions]
  ): Option[RequestOptions] = {
    if (!requestIdSupport || requestIdInDefaults || RequestId.isPresent(requestOptions)) requestOptions
    else Some(RequestOptions(headers = Map(RequestId.HeaderName -> RequestId.generate())) + requestOptions)
  }

  override def close(): Unit = {
    Try(requester.close())
  }

  def setClientApiKey(apiKey: String): Unit = {
    authInterceptor.setApiKey(apiKey)
  }
}

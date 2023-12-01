package algoliasearch

import algoliasearch.config._
import algoliasearch.exception.AlgoliaClientException
import algoliasearch.internal.interceptor.{AuthInterceptor, RetryStrategy, UserAgentInterceptor}
import algoliasearch.internal.{AlgoliaAgent, HttpRequester, StatefulHost}
import org.json4s.Formats

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
  * @param formats
  *   the JSON formats
  * @param options
  *   the client options
  */
abstract class ApiClient(
    appId: String,
    apiKey: String,
    clientName: String,
    defaultHosts: Seq[Host],
    formats: Formats,
    options: ClientOptions = ClientOptions()
) extends AutoCloseable {

  if (appId == null || appId.isEmpty) {
    throw AlgoliaClientException("`appId` is missing.")
  }
  if (apiKey == null || apiKey.isEmpty) {
    throw AlgoliaClientException("`apiKey` is missing.")
  }

  private val requester = options.customRequester match {
    case Some(customRequester) => customRequester
    case None =>
      defaultRequester(appId, apiKey, clientName, options, defaultHosts)
  }

  private def defaultRequester(
      appId: String,
      apiKey: String,
      clientName: String,
      options: ClientOptions,
      defaultHosts: Seq[Host]
  ): Requester = {
    val algoliaAgent = AlgoliaAgent(BuildInfo.version)
      .addSegment(AgentSegment(clientName, Some(BuildInfo.version)))
      .addSegments(options.agentSegments)

    val hosts = if (options.hosts.isEmpty) defaultHosts else options.hosts
    val statefulHosts = hosts.map(host => StatefulHost(host)).toList

    val builder = HttpRequester
      .builder(options.customFormats.getOrElse(formats))
      .withInterceptor(new AuthInterceptor(appId, apiKey))
      .withInterceptor(new UserAgentInterceptor(algoliaAgent))
      .withInterceptor(new RetryStrategy(statefulHosts))

    options.requesterConfig.foreach(_(builder))

    builder.build(options)
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
  override def close(): Unit = {
    Try(requester.close())
  }
}

package algoliasearch.config

import algoliasearch.internal.{AlgoliaAgent, HttpRequester}
import org.json4s.Formats

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration

/** Represents the configuration of an API client.
  *
  * @param agentSegments
  *   segments to add to the Algolia agent header
  * @param hosts
  *   hosts to use for requests
  * @param connectTimeout
  *   connection timeout
  * @param writeTimeout
  *   write timeout
  * @param readTimeout
  *   read timeout
  * @param defaultHeaders
  *   default headers to add to requests
  * @param compressionType
  *   compression type to use for requests
  * @param logging
  *   logging configuration
  * @param customFormats
  *   custom JSON formats
  * @param requesterConfig
  *   configuration for the HTTP requester
  * @param customRequester
  *   custom HTTP requester
  */
case class ClientOptions(
    agentSegments: Seq[AgentSegment] = Seq.empty,
    hosts: Seq[Host] = Seq.empty,
    connectTimeout: Duration = Duration(2, TimeUnit.SECONDS),
    writeTimeout: Duration = Duration(30, TimeUnit.SECONDS),
    readTimeout: Duration = Duration(5, TimeUnit.SECONDS),
    defaultHeaders: Map[String, String] = Map.empty,
    compressionType: CompressionType = CompressionType.None,
    logging: Option[Logging] = None,
    customFormats: Option[Formats] = None,
    requesterConfig: Option[HttpRequester.Builder => _] = None,
    customRequester: Option[Requester] = None
) extends ClientConfig

object ClientOptions {

  /** Builder for [[ClientOptions]].
    */
  class Builder() {
    private var agentSegments: Seq[AgentSegment] = Seq.empty
    private var hosts: Seq[Host] = Seq.empty
    private var connectTimeout: Duration = Duration(2, TimeUnit.SECONDS)
    private var writeTimeout: Duration = Duration(30, TimeUnit.SECONDS)
    private var readTimeout: Duration = Duration(5, TimeUnit.SECONDS)
    private var defaultHeaders: Map[String, String] = Map.empty
    private var compressionType: CompressionType = CompressionType.None
    private var logging: Option[Logging] = None
    private var customFormats: Option[Formats] = None
    private var requesterConfig: Option[HttpRequester.Builder => _] = None
    private var customRequester: Option[Requester] = None

    def withAgentSegments(agentSegments: Seq[AgentSegment]) = {
      this.agentSegments = agentSegments
      this
    }

    def withAgentSegment(value: String, version: Option[String] = None) = {
      this.agentSegments = Seq(AgentSegment(value, version))
      this
    }

    def withHosts(hosts: Seq[Host]) = {
      this.hosts = hosts
      this
    }

    def withConnectTimeout(connectTimeout: Duration) = {
      this.connectTimeout = connectTimeout
      this
    }

    def withWriteTimeout(writeTimeout: Duration) = {
      this.writeTimeout = writeTimeout
      this
    }

    def withReadTimeout(readTimeout: Duration) = {
      this.readTimeout = readTimeout
      this
    }

    def withDefaultHeaders(defaultHeaders: Map[String, String]) = {
      this.defaultHeaders = defaultHeaders
      this
    }

    def withCompressionType(compressionType: CompressionType) = {
      this.compressionType = compressionType
      this
    }

    def withLogging(logging: Logging) = {
      this.logging = Some(logging)
      this
    }

    def withCustomFormats(customFormats: Formats) = {
      this.customFormats = Some(customFormats)
      this
    }

    def withRequesterConfig(requesterConfig: HttpRequester.Builder => _) = {
      this.requesterConfig = Some(requesterConfig)
      this
    }

    def withCustomRequester(customRequester: Requester) = {
      this.customRequester = Some(customRequester)
      this
    }

    def build() = ClientOptions(
      agentSegments = agentSegments,
      hosts = hosts,
      connectTimeout = connectTimeout,
      writeTimeout = writeTimeout,
      readTimeout = readTimeout,
      defaultHeaders = defaultHeaders,
      compressionType = compressionType,
      logging = logging,
      customFormats = customFormats,
      requesterConfig = requesterConfig,
      customRequester = customRequester
    )
  }

  /** Create a new [[ClientOptions]] builder.
    */
  def builder() = new Builder
}

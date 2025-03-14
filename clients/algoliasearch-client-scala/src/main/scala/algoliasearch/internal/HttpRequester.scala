package algoliasearch.internal

import algoliasearch.config._
import algoliasearch.exception.{AlgoliaApiException, AlgoliaClientException}
import algoliasearch.internal.interceptor.{GzipRequestInterceptor, HeaderInterceptor, LogInterceptor}
import algoliasearch.internal.util.escape
import algoliasearch.internal.util.UseReadTransporter
import okhttp3._
import okhttp3.internal.http.HttpMethod
import okio.BufferedSink
import org.json4s.native.{JsonMethods, JsonParser, parseJson}
import org.json4s.{DefaultFormats, Extraction, Formats}
import org.json4s.native.Serialization.read

import java.io.IOException
import java.util.Collections
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import scala.collection.mutable.ListBuffer
import scala.util.Try

/** HttpRequester is responsible for making HTTP requests using the OkHttp client. It provides a mechanism for request
  * serialization and deserialization using a given JsonSerializer.
  */
private[algoliasearch] class HttpRequester private (
    builder: HttpRequester.Builder,
    config: ClientConfig
) extends Requester
    with AutoCloseable {

  private val httpClient: OkHttpClient = {
    val clientBuilder = new OkHttpClient.Builder()
      .connectTimeout(config.connectTimeout.toMillis, TimeUnit.MILLISECONDS)
      .readTimeout(config.readTimeout.toMillis, TimeUnit.MILLISECONDS)
      .writeTimeout(config.writeTimeout.toMillis, TimeUnit.MILLISECONDS)
      .addInterceptor(new HeaderInterceptor(config.defaultHeaders))
    config.logging.foreach(logging => clientBuilder.addNetworkInterceptor(new LogInterceptor(logging)))

    builder.interceptors.foreach(clientBuilder.addInterceptor)
    builder.networkInterceptors.foreach(clientBuilder.addNetworkInterceptor)

    if (config.compressionType == CompressionType.Gzip) {
      clientBuilder.addInterceptor(new GzipRequestInterceptor())
    }

    builder.clientConfig.foreach(_(clientBuilder))

    clientBuilder.build()
  }

  private val jsonSerializer = JsonSerializer()(builder.formats)
  private val isClosed: AtomicBoolean = new AtomicBoolean(false)

  /** Constructs the URL for the HTTP request. */
  private def createHttpUrl(
      request: HttpRequest,
      requestOptions: Option[RequestOptions] = None
  ) = {
    val urlBuilder = new HttpUrl.Builder()
      .scheme("https")
      .host("algolia.com") // will be overridden by the retry strategy
      .encodedPath(request.path)
    for ((key, value) <- request.queryParameters)
      urlBuilder.addEncodedQueryParameter(escape(key), escape(value))

    if (requestOptions.isDefined) {
      for ((key, value) <- requestOptions.get.queryParameters)
        urlBuilder.addEncodedQueryParameter(escape(key), escape(value))
    }
    urlBuilder.build
  }

  /** Creates a request body for the HTTP request. */
  private def createRequestBody(httpRequest: HttpRequest): RequestBody = {
    val method = httpRequest.method
    var body = httpRequest.body
    if (!HttpMethod.permitsRequestBody(method) || (method == "DELETE" && body.isEmpty)) return null
    if (body.isEmpty) {
      body = if (HttpMethod.requiresRequestBody(method)) Some(Collections.emptyMap) else Some("")
    }
    buildRequestBody(body)
  }

  /** Serializes the request body into JSON format. */
  private def buildRequestBody(requestBody: AnyRef) = new RequestBody() {
    override def contentType: MediaType = MediaType.parse("application/json")

    override def writeTo(bufferedSink: BufferedSink): Unit = {
      jsonSerializer.serialize(bufferedSink.outputStream, requestBody)
    }
  }

  /** Constructs the headers for the HTTP request. */
  private def createHeaders(
      request: HttpRequest,
      requestOptions: Option[RequestOptions]
  ) = {
    val builder = new Headers.Builder
    for ((key, value) <- request.headers)
      builder.add(key, value)

    if (requestOptions.isDefined)
      for ((key, value) <- requestOptions.get.headers)
        builder.add(key, value)

    builder.build
  }

  /** Returns a suitable OkHttpClient instance based on the provided request options.
    */
  private def okHttpClient(
      requestOptions: Option[RequestOptions] = None
  ): OkHttpClient = {
    // Return the default client if no request options are provided.
    if (requestOptions == null) return httpClient
    // Create a new client builder from the default client and adjust timeouts if provided.
    val builder = httpClient.newBuilder
    requestOptions.foreach(options => {
      options.readTimeout.foreach(timeout => builder.readTimeout(timeout.toMillis, TimeUnit.MILLISECONDS))
      options.writeTimeout.foreach(timeout => builder.writeTimeout(timeout.toMillis, TimeUnit.MILLISECONDS))
      options.connectTimeout.foreach(timeout => builder.connectTimeout(timeout.toMillis, TimeUnit.MILLISECONDS))
    })
    builder.build
  }

  override def close(): Unit = {
    if (isClosed.compareAndSet(false, true)) {
      httpClient.dispatcher().executorService().shutdown()
      httpClient.connectionPool().evictAll()
      val cache = httpClient.cache()
      if (cache != null) {
        cache.close()
      }
    }
  }

  /** Core method to execute an HTTP request and handle the response. */
  override def execute[T: Manifest](
      httpRequest: HttpRequest,
      requestOptions: Option[RequestOptions] = None
  ): T = {
    if (isClosed.get) throw new IllegalStateException("HttpRequester is closed")
    // Create the request components.
    val url = createHttpUrl(httpRequest, requestOptions)
    val headers = createHeaders(httpRequest, requestOptions)
    val requestBody = createRequestBody(httpRequest)
    // Build the HTTP request.
    val requestBuilder = new Request.Builder()
      .url(url)
      .headers(headers)
      .method(httpRequest.method, requestBody)
    if (httpRequest.read) requestBuilder.tag(UseReadTransporter)
    val request = requestBuilder.build
    // Get or adjust the HTTP client according to request options.
    val client = okHttpClient(requestOptions)
    // Execute the request.
    val call = client.newCall(request)
    var response: Response = null
    try {
      response = call.execute
      // Handle unsuccessful responses.
      if (!response.isSuccessful)
        throw AlgoliaApiException(message = response.message, httpErrorCode = response.code)
      // Deserialize and return the response.
      jsonSerializer.deserialize[T](response.body.byteStream)
    } catch {
      case exception: IOException => throw AlgoliaClientException(cause = exception)
      case exception: AlgoliaApiException =>
        var message = ""
        try {
          val errorMap = read[Map[String, Any]](exception.message)(DefaultFormats, manifest[Map[String, Any]])
          message = errorMap.getOrElse("message", exception.message).toString
        } catch {
          case _: Throwable => message = exception.message
        }

        throw AlgoliaApiException(
          message = message,
          cause = exception.cause,
          httpErrorCode = exception.httpErrorCode
        )
    } finally if (response != null) response.close()
  }
}

object HttpRequester {

  /** Builder for HttpRequester.
    */
  class Builder(val formats: Formats) {
    private[internal] val interceptors = ListBuffer[Interceptor]()
    private[internal] val networkInterceptors = ListBuffer[Interceptor]()
    private[internal] var clientConfig: Option[OkHttpClient.Builder => _] = None

    def withInterceptor(interceptor: Interceptor): Builder = {
      interceptors += interceptor
      this
    }

    def withNetworkInterceptor(interceptor: Interceptor): Builder = {
      networkInterceptors += interceptor
      this
    }

    def withHttpClientConfig(config: OkHttpClient.Builder => _): Builder = {
      this.clientConfig = Option(config)
      this
    }

    def build(config: ClientConfig): HttpRequester =
      new HttpRequester(this, config)
  }

  def builder(formats: Formats): Builder = new Builder(formats)
}

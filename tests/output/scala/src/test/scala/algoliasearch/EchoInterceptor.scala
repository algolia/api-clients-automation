package algoliasearch

import algoliasearch.internal.util.escape
import okhttp3.*
import okhttp3.Interceptor.Chain
import okio.Buffer

import scala.collection.convert.ImplicitConversions.*
import scala.collection.mutable

class EchoInterceptor(private val httpCode: Int = 200) extends Interceptor {
  var lastResponse: Option[EchoResponse] = None

  def intercept(chain: Chain): Response = {
    val request = chain.request
    try {
      val useReadTransporter = request.tag

      val echo = EchoResponse(
        path = request.url.encodedPath,
        host = request.url.host,
        method = request.method,
        body = processResponseBody(request),
        queryParameters = buildQueryParameters(request),
        headers = buildHeaders(request.headers),
        connectTimeout = chain.connectTimeoutMillis,
        responseTimeout =
          if (useReadTransporter != null || request.method.equals("GET")) chain.readTimeoutMillis
          else chain.writeTimeoutMillis
      )
      lastResponse = Some(echo)
    } catch {
      case e: Exception =>
        System.err.println(e)
        lastResponse = None
    }
    new Response.Builder()
      .code(httpCode)
      .request(request)
      .protocol(Protocol.HTTP_2)
      .message("EchoMessage")
      .body(ResponseBody.create("", MediaType.parse("application/json")))
      .build
  }

  private def processResponseBody(request: Request): Option[String] = {
    val copy = request.newBuilder.build
    val buffer = new Buffer()
    if (copy.body == null) return None
    copy.body.writeTo(buffer)
    Some(buffer.readUtf8)
  }

  private def buildQueryParameters(request: Request): Map[String, String] = {
    val url = request.url
    if (url.queryParameterNames.isEmpty) return Map.empty
    val params = mutable.Map[String, String]()
    for (name: String <- url.queryParameterNames()) {
      for (value: String <- url.queryParameterValues(name)) {
        params.put(escape(name), escape(value))
      }
    }
    params.toMap
  }

  private def buildHeaders(headers: Headers): Map[String, String] = {
    val names = headers.names
    if (names.isEmpty) return Map.empty
    val mapHeaders = mutable.Map[String, String]()
    for (headerName <- names) {
      mapHeaders.put(headerName, headers.get(headerName))
    }
    mapHeaders.toMap
  }
}

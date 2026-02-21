package algoliasearch.internal.interceptor

import okhttp3.{Interceptor, Request, Response}

/** Interceptor that adds headers to a request.
  *
  * @param headers
  *   headers to add to the request
  */
private[internal] class HeaderInterceptor(headers: Map[String, String]) extends Interceptor {

  private val immutableHeaders: Map[String, String] = Map(headers.toSeq: _*)

  override def intercept(chain: Interceptor.Chain): Response = {
    val request: Request = chain.request()
    val builder: Request.Builder = request.newBuilder()
    val requestHeaders = request.headers()

    immutableHeaders.foreach { case (key, value) =>
      if (requestHeaders.get(key) == null) {
        builder.header(key, value)
      }
    }

    val newRequest: Request = builder.build()
    chain.proceed(newRequest)
  }
}

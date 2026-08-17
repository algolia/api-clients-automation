package algoliasearch.internal.interceptor

import algoliasearch.internal.RequestId
import okhttp3.{Interceptor, Response}

import scala.jdk.CollectionConverters._

/** Interceptor that stamps a `Request-ID` header on the request unless one is already supplied on either channel. It is
  * registered before [[RetryStrategy]], which loops internally, so it runs once per call and every retry reuses the
  * same identifier.
  */
private[algoliasearch] class RequestIdInterceptor extends Interceptor {

  override def intercept(chain: Interceptor.Chain): Response = {
    val request = chain.request()
    val alreadySupplied = request.header(RequestId.HeaderName) != null ||
      request.url().queryParameterNames().asScala.exists(_.equalsIgnoreCase(RequestId.QueryParameterName))

    if (alreadySupplied) chain.proceed(request)
    else chain.proceed(request.newBuilder().header(RequestId.HeaderName, RequestId.generate()).build())
  }
}

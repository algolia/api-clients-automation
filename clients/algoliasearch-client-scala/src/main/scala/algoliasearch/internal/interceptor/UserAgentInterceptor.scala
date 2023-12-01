package algoliasearch.internal.interceptor

import algoliasearch.internal.AlgoliaAgent
import okhttp3.{Interceptor, Request, Response}

/** Interceptor that adds the user agent to the request headers.
  *
  * @param agent
  *   user agent
  */
private[algoliasearch] class UserAgentInterceptor(agent: AlgoliaAgent) extends Interceptor {

  override def intercept(chain: Interceptor.Chain): Response = {
    val originalRequest: Request = chain.request()
    val newRequest: Request = originalRequest
      .newBuilder()
      .header("user-agent", agent.toString)
      .build()

    chain.proceed(newRequest)
  }
}

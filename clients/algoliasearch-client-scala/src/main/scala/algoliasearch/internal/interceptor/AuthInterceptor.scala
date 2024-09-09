package algoliasearch.internal.interceptor

import okhttp3.{Interceptor, Response}

/** Interceptor that adds the application ID and API key to the request headers.
  *
  * @param applicationId
  *   application ID
  * @param apiKey
  *   API key
  */
private[algoliasearch] class AuthInterceptor(
    applicationId: String,
    private var apiKey: String
) extends Interceptor {

  private val HeaderApplicationId = "x-algolia-application-id"
  private val HeaderApiKey = "x-algolia-api-key"

  def setApiKey(newApiKey: String): Unit = {
    apiKey = newApiKey
  }

  override def intercept(chain: Interceptor.Chain): Response = {
    val originalRequest = chain.request()
    val builder = originalRequest.newBuilder()
    val headers = originalRequest.headers()

    if (headers.get(HeaderApplicationId) == null) {
      builder.header(HeaderApplicationId, applicationId)
    }
    if (headers.get(HeaderApiKey) == null) {
      builder.header(HeaderApiKey, apiKey)
    }

    val newRequest = builder.build()
    chain.proceed(newRequest)
  }
}

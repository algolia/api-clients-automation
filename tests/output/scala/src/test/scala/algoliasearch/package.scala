import algoliasearch.api.SearchClient
import algoliasearch.config.ClientOptions

package object algoliasearch {

  def testSearchClient(): (SearchClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      SearchClient(
        appId = "appId",
        apiKey = "apiKey",
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  def testRecommendClient(): (SearchClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      SearchClient(
        appId = "appId",
        apiKey = "apiKey",
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }
}

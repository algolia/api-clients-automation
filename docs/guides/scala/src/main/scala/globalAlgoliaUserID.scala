import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions

def globalAlgoliaUserID(): Unit = {
  val client = SearchClient(
    appId = "ALGOLIA_APPLICATION_ID",
    apiKey = "ALGOLIA_API_KEY",
    clientOptions = ClientOptions(
      defaultHeaders = Map("X-Algolia-UserToken" -> "test-user-123")
    )
  )
  println(client)
}

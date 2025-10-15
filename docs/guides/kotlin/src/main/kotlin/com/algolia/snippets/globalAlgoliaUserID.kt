import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun globalAlgoliaUserID() {
  val client =
    SearchClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      options = ClientOptions(defaultHeaders = mapOf("X-Algolia-User-ID" to "test-user-123")),
    )
  println(client.options.defaultHeaders)
}

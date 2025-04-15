import kotlinx.serialization.json.JsonObject

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*

import com.algolia.client.model.search.*
import com.algolia.client.transport.RequestOptions

suspend fun saveObjectsPublicUser() {
  val playlists: List<JsonObject> = listOf() // Your records

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  client.saveObjects(
    indexName = "<YOUR_INDEX_NAME>",
    objects = playlists,
    waitForTasks = false,
    batchSize = 1000,
    requestOptions = RequestOptions(
      headers = buildMap {
        put("X-Algolia-User-ID", "*")
      },
    ),
  )
}

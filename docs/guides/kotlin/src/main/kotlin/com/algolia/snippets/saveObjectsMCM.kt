import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*
import kotlinx.serialization.json.JsonObject

val getAllAppIDConfigurations: () -> Map<String, String> = {
  mapOf() // A map of your MCM AppID/ApiKey pairs
}

suspend fun saveObjectsMCM() {
  val playlists: List<JsonObject> = listOf() // Your records

  val configurations = getAllAppIDConfigurations()

  configurations.map { (appID, apiKey) ->
    val client = SearchClient(appID, apiKey)

    try {
      client.saveObjects(indexName = "<YOUR_INDEX_NAME>", objects = playlists)
    } catch (e: Exception) {
      throw Exception("Error for appID $appID: ${e.message}")
    }
  }
}

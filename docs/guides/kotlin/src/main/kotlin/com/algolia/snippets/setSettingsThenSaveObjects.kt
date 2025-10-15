import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*
import kotlinx.serialization.json.JsonObject

val playlists = listOf<JsonObject>() // Your records

val getAppIDFor: (String) -> String = {
  "" // Implement your own logic here
}
val getIndexingApiKeyFor: (String) -> String = {
  "" // Implement your own logic here
}

suspend fun setSettingsThenSaveObjects() {
  playlists.forEach { playlist ->
    // Fetch from your own data storage and with your own code
    // the associated application ID and API key for this user
    val appID = getAppIDFor(playlist["user"].toString())
    val apiKey = getIndexingApiKeyFor(playlist["user"].toString())

    val client = SearchClient(appID, apiKey)
    val settings = IndexSettings(attributesForFaceting = listOf("filterOnly(user)"))

    try {
      client.setSettings(indexName = "<YOUR_INDEX_NAME>", indexSettings = settings)

      client.saveObjects(indexName = "<YOUR_INDEX_NAME>", objects = playlists)
    } catch (exception: Exception) {
      println(exception.message)
    }
  }
}

package org.example
import com.algolia.client.api.SearchClient
import com.algolia.client.extensions.*

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import java.net.URI

suspend fun main() {
  val url = URI.create("https://dashboard.algolia.com/sample_datasets/movie.json")
  val json = url.toURL().readText()
  val movies: List<JsonObject> = Json.decodeFromString(ListSerializer(JsonObject.serializer()), json)

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  try {
    client.saveObjects(
      indexName = "<YOUR_INDEX_NAME>",
      objects = movies,
    )
  } catch (e: Exception) {
    println(e.message)
  }
}

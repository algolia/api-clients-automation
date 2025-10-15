package org.example

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.transport.*
import java.net.URI
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

suspend fun main() {
  val url = URI.create("https://dashboard.algolia.com/api/1/sample_datasets?type=movie")
  val json = url.toURL().readText()
  val movies: List<JsonObject> =
    Json.decodeFromString(ListSerializer(JsonObject.serializer()), json)

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  try {
    client.saveObjects(indexName = "<YOUR_INDEX_NAME>", objects = movies)
  } catch (e: Exception) {
    println(e.message)
  }
}

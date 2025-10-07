import java.io.File
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*

suspend fun saveObjectsChunks() {
  val path = "/tmp/records.json"
  val json = try {
    File(path).readText()
  } catch (e: Exception) {
    throw RuntimeException("Failed to read file at $path", e)
  }
  val records: List<JsonObject> = Json.decodeFromString(ListSerializer(JsonObject.serializer()), json)

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  records.chunked(10000).forEach { chunk ->
    try {
      client.saveObjects(indexName = "<YOUR_INDEX_NAME>", objects = chunk)
    } catch (exception: Exception) {
      println(exception.message)
    }
  }
}

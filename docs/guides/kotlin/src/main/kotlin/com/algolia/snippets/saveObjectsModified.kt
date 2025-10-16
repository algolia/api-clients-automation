import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*
import java.io.File
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.*

suspend fun saveObjectsModified() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val path = "/tmp/records.json"
  val json =
    try {
      File(path).readText()
    } catch (e: Exception) {
      throw RuntimeException("Failed to read file at $path", e)
    }
  val products: List<JsonObject> =
    Json.decodeFromString(ListSerializer(JsonObject.serializer()), json)

  val records =
    products.map { product ->
      val reference = product["product_reference"].toString()
      val suffixes =
        reference.windowed(reference.length, 1, partialWindows = true).drop(1).map {
          JsonPrimitive(it)
        }
      JsonObject(product + ("product_reference_suffixes" to JsonArray(suffixes)))
    }

  client.saveObjects(indexName = "<YOUR_INDEX_NAME>", objects = records)
}

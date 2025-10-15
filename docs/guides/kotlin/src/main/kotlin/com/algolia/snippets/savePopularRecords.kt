import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject

suspend fun savePopularRecords() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  var records: List<JsonObject> = listOf()

  client.browseObjects(
    "YOUR_INDEX_NAME",
    BrowseParamsObject(),
    aggregator = { response ->
      records =
        records +
          response.hits.map { hit ->
            val props = hit.additionalProperties ?: mapOf()

            val nbFollowers = props["nbFollowers"].toString().toInt()

            buildJsonObject {
              put("twitterHandle", JsonPrimitive(props["twitterHandle"].toString()))
              put("nbFollowers", JsonPrimitive(nbFollowers))
              put("isPopular", JsonPrimitive(nbFollowers > 1000000))
            }
          }
    },
  )
  client.saveObjects(indexName = "<YOUR_INDEX_NAME>", objects = records)
}

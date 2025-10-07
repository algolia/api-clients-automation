import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.BrowseParamsObject
import com.algolia.client.model.search.IndexSettings

suspend fun saveImageClassificationsAndSettings() {
  data class Image(
    val imageURL: String,
    val objectID: String,
    val objects: List<Map<String, Any>>
  )

  // Retrieve labels
  fun getImageLabels(imageURL: String, objectID: String, scoreLimit: Float): Image {
    // Implement your image classification logic here
    return Image(imageURL, objectID, emptyList())
  }

  // API key ACL should include editSettings / addObject
  try {
    val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    val images: MutableList<Image> = mutableListOf()

    client.browseObjects(
      indexName = "<YOUR_INDEX_NAME>",
      params = BrowseParamsObject(),
      aggregator = { browseResponse ->
        images.addAll(
          browseResponse.hits.map {
            val props = it.additionalProperties ?: emptyMap()
            return@map getImageLabels(props.getOrElse("imageURL") { "" }.toString(), it.objectID, 0.5f)
          },
        )
      },
    )

    val records = images.map { Json.encodeToJsonElement(it).jsonObject }

    // Update records with image classifications
    client.partialUpdateObjects(indexName = "<YOUR_INDEX_NAME>", objects = records, createIfNotExists = true)

    val facets = mutableListOf<String>()
    val attributes = mutableListOf<String>()

    images.forEach { record ->
      record.objects.forEach { obj ->
        obj.forEach { (key, values) ->
          if (values is Iterable<*>) {
            facets.add("searchable(objects.$key.label)")
            facets.add("searchable(objects.$key.score)")
            attributes.add("objects.$key.label")
          }
        }
      }
    }

    val currentSettings = client.getSettings(indexName = "<YOUR_INDEX_NAME>")

    val settings = IndexSettings(
      searchableAttributes = currentSettings.searchableAttributes?.plus(attributes),
      attributesForFaceting = currentSettings.attributesForFaceting?.plus(facets),
    )

    client.setSettings(indexName = "<YOUR_INDEX_NAME>", indexSettings = settings)
  } catch (e: Exception) {
    println(e.message)
  }
}

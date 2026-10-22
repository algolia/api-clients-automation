import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.dsl.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

@OptIn(AlgoliaExperimentalDsl::class)
suspend fun setSettingsWithDsl() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val settings = settings {
    searchableAttributes {
      ordered("name")
      unordered("description")
    }
    attributesForFaceting {
      +"brand"
      filterOnly("internalSku")
      searchable("category")
    }
  }

  client.setSettings(indexName = "<YOUR_INDEX_NAME>", indexSettings = settings)
}

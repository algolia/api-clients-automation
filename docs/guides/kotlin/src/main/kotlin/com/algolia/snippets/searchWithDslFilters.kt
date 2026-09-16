import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.dsl.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

@OptIn(AlgoliaExperimentalDsl::class)
suspend fun searchWithDslFilters() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val searchParams =
    query("<YOUR_SEARCH_QUERY>") {
      filters {
        facet("brand", "Apple")
        range("price", 0, 100)
      }
    }

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

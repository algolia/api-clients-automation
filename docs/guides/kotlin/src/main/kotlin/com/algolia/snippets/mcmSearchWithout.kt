import kotlinx.serialization.json.JsonObject

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*

suspend fun mcmSearchWithout() {
  val getAppIDFor: (String) -> String = {
    "" // Implement your own logic here
  }
  val getIndexingApiKeyFor: (String) -> String = {
    "" // Implement your own logic here
  }

  // Fetch from your own data storage and with your own code
  // the associated application ID and API key for this user
  val appID = getAppIDFor("user42")
  val apiKey = getIndexingApiKeyFor("user42")

  val client = SearchClient(appID, apiKey)
  val searchParams = SearchParamsObject(
    query = "<YOUR_SEARCH_QUERY>",
    facetFilters = FacetFilters.of(
      listOf(
        FacetFilters.of("user:user42"),
        FacetFilters.of("user:public"),
      ),
    ),
  )

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

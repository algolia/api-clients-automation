import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun searchInReplicaIndex() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // 1. Change the sort dynamically based on the UI events
  val sortByPrice = false

  // 2. Get the index name based on sortByPrice
  val indexName = if (sortByPrice) "products_price_desc" else "products"

  // 3. Search on dynamic index name (primary or replica)
  client.searchSingleIndex(
    indexName = indexName,
    searchParams = SearchParamsObject(query = "query"),
  )
}

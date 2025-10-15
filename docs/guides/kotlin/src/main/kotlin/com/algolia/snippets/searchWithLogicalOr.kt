import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun searchWithLogicalOr() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")
  val query = "the query"
  val optionalWords = listOf("the", "query")
  val searchParams =
    SearchParamsObject(query = query, optionalWords = OptionalWords.of(optionalWords))
  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

val getBuyerAccountId: () -> String = {
  "" // Implement your logic here
}

suspend fun searchWithRuleContextBuyer() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // get the buyer account information
  val buyer = getBuyerAccountId()
  val searchParams = SearchParamsObject(query = "<YOUR_SEARCH_QUERY>", ruleContexts = listOf(buyer))

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

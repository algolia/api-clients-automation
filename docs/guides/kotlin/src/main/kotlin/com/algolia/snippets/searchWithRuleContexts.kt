import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*

import com.algolia.client.model.search.*

val getPlatformTag: () -> String = {
  "" // Implement your logic here
}

suspend fun searchWithRuleContexts() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val platformTag = getPlatformTag()
  val searchParams = SearchParamsObject(
    query = "<YOUR_SEARCH_QUERY>",
    ruleContexts = listOf(platformTag),
  )

  client.searchSingleIndex(
    indexName = "<YOUR_INDEX_NAME>",
    searchParams = searchParams,
  )
}

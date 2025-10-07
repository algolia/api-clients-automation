import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*

import com.algolia.client.model.search.*

val getGoogleAnalyticsUserIdFromBrowserCookie: (String) -> String = {
  "" // Implement your logic here
}

suspend fun searchWithGAToken() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val userToken = getGoogleAnalyticsUserIdFromBrowserCookie("_ga")
  var searchParams = SearchParamsObject(query = "<YOUR_SEARCH_QUERY>", userToken = userToken)

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)

  val loggedInUser: String? = null
  searchParams = SearchParamsObject(query = "<YOUR_SEARCH_QUERY>", userToken = loggedInUser ?: userToken)

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

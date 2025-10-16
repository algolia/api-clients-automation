import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun searchWithAnalyticsAndHeader() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  /*
  '94.228.178.246' should be replaced with your user's IP address.
  Depending on your stack there are multiple ways to get this information.
  */
  val ip = "94.228.178.246"
  val query = "query"

  val searchParams = SearchParamsObject(query = query, analytics = true)

  client.searchSingleIndex(
    indexName = "<YOUR_INDEX_NAME>",
    searchParams = searchParams,
    requestOptions = RequestOptions(headers = buildMap { put("X-Forwarded-For", ip) }),
  )
}

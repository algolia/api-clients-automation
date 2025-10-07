import java.time.Instant

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*

suspend fun searchFuturePublishedBooks() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val dateTimestamp = Instant.now().epochSecond
  val searchParams = SearchParamsObject(
    query = "<YOUR_SEARCH_QUERY>",
    filters = "date_timestamp > $dateTimestamp",
  )

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

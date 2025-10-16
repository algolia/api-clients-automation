import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

val labels: List<String> = listOf() // A list of labels

val reduceLabelsToFilters: (List<String>) -> OptionalFilters = {
  OptionalFilters.of("") // Implement your logic here
}

suspend fun searchWithOptionalFilters() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val optionalFilters = reduceLabelsToFilters(labels)
  val searchParams =
    SearchParamsObject(query = "<YOUR_SEARCH_QUERY>", optionalFilters = optionalFilters)

  client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
}

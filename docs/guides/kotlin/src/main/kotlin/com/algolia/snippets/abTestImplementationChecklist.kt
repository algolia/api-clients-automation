import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

fun getUserToken(): String {
  // Implement your logic here
  return ""
}

suspend fun abTestImplementationChecklist() {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // Set the searchParams and get the current user token
  val userToken = getUserToken()

  // Is the user token anonymous?
  val searchParams =
    if (userToken.isEmpty() || userToken == "YOUR_ANONYMOUS_USER_TOKEN") {
      // Disable A/B testing for this request
      SearchParamsObject(query = "User search query", enableABTest = false)
    } else {
      // Set the user token to the current user token
      SearchParamsObject(query = "User search query", enableABTest = true, userToken = userToken)
    }

  try {
    // Perform the searchSingleIndex
    val result =
      client.searchSingleIndex(indexName = "<YOUR_INDEX_NAME>", searchParams = searchParams)
    // SearchSingleIndex results
    println(result)
  } catch (err: Exception) {
    // SearchSingleIndex errors
    println(err)
  }
}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

val getUserToken: String = {
  "" // Implement your logic here
}

def abTestImplementationChecklist(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // Set the searchParams and get the current user token
  val userToken = getUserToken

  // Is the user token anonymous?
  val searchParams = if (userToken == null || userToken.isEmpty || userToken == "YOUR_ANONYMOUS_USER_TOKEN") {
    // Disable A/B testing for this request
    SearchParamsObject(
      query = Some("User search query"),
      enableABTest = Some(false)
    )
  } else {
    // Set the user token to the current user token
    SearchParamsObject(
      query = Some("User search query"),
      enableABTest = Some(true),
      userToken = Some(userToken)
    )
  }

  // Perform the searchSingleIndex
  client
    .searchSingleIndex(
      indexName = "<YOUR_INDEX_NAME>",
      searchParams = Some(searchParams)
    )
    .map { result =>
      // SearchSingleIndex results
      println(result)
    }
    .recover { case err: Exception =>
      // SearchSingleIndex errors
      println(s"An error occurred: ${err.getMessage}")
    }
}

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

  // Set the query and get the current user token
  val query = "User search query"
  val userToken = getUserToken

  // Set the searchParams
  var searchParams = SearchParamsObject(
    query = Some(query)
  )

  // Is the user token anonymous?
  if (userToken == null || userToken.isEmpty || userToken == "YOUR_ANONYMOUS_USER_TOKEN") {
    // Disable A/B testing for this request
    searchParams = searchParams.copy(enableABTest = Some(false))
  } else {
    // Set the user token to the current user token
    searchParams = searchParams.copy(userToken = Some(userToken))
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

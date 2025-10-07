import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

val getGoogleAnalyticsUserIdFromBrowserCookie: String => String = _ => {
  "" // Implement your logic here
}

def searchWithGAToken(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val userToken = getGoogleAnalyticsUserIdFromBrowserCookie("_ga")
  var searchParams = SearchParamsObject(query = Some("<YOUR_SEARCH_QUERY>"), userToken = Some(userToken))

  Await.result(
    client
      .searchSingleIndex(
        indexName = "<YOUR_INDEX_NAME>",
        searchParams = Some(searchParams)
      )
      .map(_ => Future.unit),
    Duration(5, "sec")
  )

  val loggedInUser = Some("...")
  searchParams =
    SearchParamsObject(query = Some("<YOUR_SEARCH_QUERY>"), userToken = Some(loggedInUser.getOrElse(userToken)))

  Await.result(
    client
      .searchSingleIndex(
        indexName = "<YOUR_INDEX_NAME>",
        searchParams = Some(searchParams)
      )
      .map(_ => Future.unit),
    Duration(5, "sec")
  )
}

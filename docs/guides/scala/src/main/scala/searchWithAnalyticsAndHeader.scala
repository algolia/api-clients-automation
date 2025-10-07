import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

def searchWithAnalyticsAndHeader(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  /*
  '94.228.178.246' should be replaced with your user's IP address.
  Depending on your stack there are multiple ways to get this information.
   */
  val ip = "94.228.178.246"
  val query = "query"

  val searchParams = SearchParamsObject(
    query = Some(query),
    analytics = Some(true)
  )

  client
    .searchSingleIndex(
      indexName = "<YOUR_INDEX_NAME>",
      searchParams = Some(searchParams),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withHeader("X-Forwarded-For", "ip")
          .build()
      )
    )
    .map { response =>
      println(response)
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}

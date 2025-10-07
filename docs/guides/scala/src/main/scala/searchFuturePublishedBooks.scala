import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import java.time.Instant

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

def searchFuturePublishedBooks(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val dateTimestamp = Instant.now.getEpochSecond
  val searchParams = SearchParamsObject(
    query = Some("<YOUR_SEARCH_QUERY>"),
    filters = Some(s"date_timestamp > $dateTimestamp")
  )

  client
    .searchSingleIndex(
      indexName = "<YOUR_INDEX_NAME>",
      searchParams = Some(searchParams)
    )
    .map { response =>
      println(response)
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

def searchInReplicaIndex(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // 1. Change the sort dynamically based on the UI events
  val sortByPrice = false

  // 2. Get the index name based on sortByPrice
  val indexName = if sortByPrice then "products_price_desc" else "products"

  // 3. Search on dynamic index name (primary or replica)
  client
    .searchSingleIndex(
      indexName = indexName,
      searchParams = Some(
        SearchParamsObject(
          query = Some("query")
        )
      )
    )
    .map { response =>
      println(response)
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}

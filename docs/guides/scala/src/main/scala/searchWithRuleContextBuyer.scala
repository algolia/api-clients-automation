import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

val getBuyerAccountId: () => String = () => {
  "" // Implement your logic here
}

def searchWithRuleContextBuyer(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // get the buyer account information
  val buyer = getBuyerAccountId()
  val searchParams = SearchParamsObject(query = Some("<YOUR_SEARCH_QUERY>"), ruleContexts = Some(Seq(buyer)))

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

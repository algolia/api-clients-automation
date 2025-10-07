import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.SearchParamsObject

val getPlatformTag: String = {
  "" // Implement your logic here
}

def searchWithRuleContexts(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val platformTag = getPlatformTag
  val searchParams = SearchParamsObject(
    query = Some("<YOUR_SEARCH_QUERY>"),
    ruleContexts = Some(Seq(platformTag))
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

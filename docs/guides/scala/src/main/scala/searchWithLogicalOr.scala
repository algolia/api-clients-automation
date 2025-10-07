import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{OptionalWords, SearchParamsObject}

def searchWithLogicalOr(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")
  val query = "the query"
  val optionalWords = Seq("the", "query")
  val searchParams = SearchParamsObject(
    query = Some(query),
    optionalWords = Some(OptionalWords.SeqOfString(optionalWords))
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

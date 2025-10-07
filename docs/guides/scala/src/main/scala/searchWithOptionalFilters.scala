import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.OptionalFilters.SeqOfOptionalFilters
import algoliasearch.search.SearchParamsObject

val labels: List[String] = List() // A list of labels

val reduceLabelsToFilters: Seq[String] => SeqOfOptionalFilters = _ => {
  SeqOfOptionalFilters(Seq()) // Implement your logic here
}

def searchWithOptionalFilters(): Future[Unit] = {
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val optionalFilters = reduceLabelsToFilters(labels)
  val searchParams = SearchParamsObject(query = Some("<YOUR_SEARCH_QUERY>"), optionalFilters = Some(optionalFilters))

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

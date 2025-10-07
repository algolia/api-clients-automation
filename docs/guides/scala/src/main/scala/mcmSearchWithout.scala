import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{FacetFilters, SearchParamsObject}

def mcmSearchWithout(): Future[Unit] = {
  val getAppIDFor: String => String = _ => {
    "" // Implement your own logic here
  }
  val getIndexingApiKeyFor: String => String = _ => {
    "" // Implement your own logic here
  }

  // Fetch from your own data storage and with your own code
  // the associated application ID and API key for this user
  val appID = getAppIDFor("user42")
  val apiKey = getIndexingApiKeyFor("user42")

  val client = SearchClient(appID, apiKey)
  val searchParams = SearchParamsObject(
    query = Some("<YOUR_SEARCH_QUERY>"),
    facetFilters = Some(
      FacetFilters.SeqOfFacetFilters(
        Seq(
          FacetFilters.StringValue("user:user42"),
          FacetFilters.StringValue("user:public")
        )
      )
    )
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

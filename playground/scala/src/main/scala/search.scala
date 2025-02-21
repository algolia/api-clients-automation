import algoliasearch.api.SearchClient
import algoliasearch.config.{ClientOptions, Logging}
import algoliasearch.search.{SearchForHits, SearchMethodParams, SearchResponse}
import io.github.cdimascio.dotenv.Dotenv
import org.json4s.jvalue2extractable

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

def main(): Unit = {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: org.json4s.Formats = org.json4s.DefaultFormats

  val dotenv = Dotenv.configure.directory("../").load
  val appId = dotenv.get("ALGOLIA_APPLICATION_ID")
  val apiKey = dotenv.get("ALGOLIA_ADMIN_KEY")
  val indexName = dotenv.get("SEARCH_INDEX")
  val query = dotenv.get("SEARCH_QUERY")

  val client = SearchClient(
    appId = appId,
    apiKey = apiKey,
    clientOptions = ClientOptions
      .builder()
      .withLogging(Logging.Full)
      .withAgentSegment("playground")
      .build()
  )

  val params = SearchMethodParams(
    requests = Seq(
      SearchForHits(
        indexName = indexName,
        query = Some(query)
      )
    )
  )
  val res = client.search(searchMethodParams = params)
  val value = Await.result(res, Duration(100, "sec"))
  val response = value.results.head.asInstanceOf[SearchResponse]
  for (hit <- response.hits) {
    //val actor = hit.extract[Actor]
    //println(actor)
  }
}

case class Actor(name: String)

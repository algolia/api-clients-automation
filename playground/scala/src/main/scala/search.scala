import algoliasearch.api.SearchClient
import algoliasearch.config.{ClientOptions, Logging}
import algoliasearch.search.{JsonSupport, SearchForHits, SearchMethodParams, SearchResponse}
import io.github.cdimascio.dotenv.Dotenv
import org.json4s.{Extraction, Formats, jvalue2extractable}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

object search {
  private case class Contact(firstname: String, lastname: String, company: String, followers: Long, objectID: String)
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
    implicit val formats: Formats = JsonSupport.format

      val dotenv = Dotenv.configure.directory("../").load
      val appId = dotenv.get("ALGOLIA_APPLICATION_ID")
      val apiKey = dotenv.get("ALGOLIA_ADMIN_KEY")

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
            indexName = "contacts",
            query = Some("Jimmie")
          )
        )
      )
      val res = client.search(searchMethodParams = params)
      val value = Await.result(res, Duration(100, "sec"))
      val response = value.results.head.asInstanceOf[SearchResponse]
      for (hit <- response.hits) {
        val contact = jvalue2extractable(Extraction.decompose(hit)).extract[Contact]
        println(contact)
      }
  }
}

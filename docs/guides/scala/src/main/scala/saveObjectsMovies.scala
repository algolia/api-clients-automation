import scala.io.Source
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

import algoliasearch.api.SearchClient
import algoliasearch.extension.SearchClientExtensions

import algoliasearch.extension.SearchClientExtensions

import org.json4s.native.JsonMethods
import org.json4s.jvalue2extractable

object Main {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
    implicit val formats: org.json4s.Formats = org.json4s.DefaultFormats

    // Fetch sample dataset
    val url = "https://dashboard.algolia.com/sample_datasets/movie.json"
    val result = Source.fromURL(url).mkString
    val movies = JsonMethods.parse(result).extract[Seq[Map[String, Any]]]

    // Connect and authenticate with your Algolia app
    val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Save records in Algolia index
    try {
      Await.result(
        client.saveObjects(
          indexName = "<YOUR_INDEX_NAME>",
          objects = movies
        ),
        Duration(100, "sec")
      )
    } catch {
      case e: Exception => println(e)
    }
  }
}

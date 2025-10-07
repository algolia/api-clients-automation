import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source
import scala.util.Using

import org.json4s.native.JsonMethods
import org.json4s.jvalue2extractable

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.JsonSupport
import algoliasearch.config.RequestOptions

def saveObjectsChunks(): Future[Unit] = {
  implicit val formats: org.json4s.Formats = JsonSupport.format

  val path = "/tmp/records.json"
  val result = Using(Source.fromFile(path))(_.mkString).getOrElse {
    throw new RuntimeException(s"Failed to read file at $path")
  }
  val records = JsonMethods.parse(result).extract[Seq[Map[String, Any]]]

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  records.grouped(10000).foreach { chunk =>
    try {
      Await.result(
        client.saveObjects(
          indexName = "<YOUR_INDEX_NAME>",
          objects = chunk
        ),
        Duration(5, "sec")
      )
    } catch {
      case e: Exception => println(e)
    }
  }

  Future.unit
}

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

def saveObjectsModified(): Future[Unit] = {
  implicit val formats: org.json4s.Formats = JsonSupport.format

  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  val path = "/tmp/records.json"
  val result = Using(Source.fromFile(path))(_.mkString).getOrElse {
    throw new RuntimeException(s"Failed to read file at $path")
  }
  val products = JsonMethods.parse(result).extract[Seq[Map[String, Any]]]

  val records = products.map { product =>
    val reference = product("product_reference").toString
    val suffixes = reference.tails.toList.drop(1).filter(_.nonEmpty)
    product + ("product_reference_suffixes" -> suffixes)
  }

  Await.result(
    client
      .saveObjects(
        indexName = "<YOUR_INDEX_NAME>",
        objects = records
      )
      .map(_ => Future.unit),
    Duration(5, "seconds")
  )
}

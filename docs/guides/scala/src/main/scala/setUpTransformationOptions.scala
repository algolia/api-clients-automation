import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import org.json4s.*

object SetUpTransformationOptions {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global

    // Set transformationOptions with your transformation region to use the `WithTransformation` helper methods.
    // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
    val client = SearchClient.withTransformation(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      transformationOptions = TransformationOptions("us")
    )

    // Save records, transforming them through the Push connector
    try {
      Await.result(
        client.saveObjectsWithTransformation(
          indexName = "<YOUR_INDEX_NAME>",
          objects = Seq(
            JObject(List(JField("objectID", JString("1")), JField("name", JString("Adam")))),
            JObject(List(JField("objectID", JString("2")), JField("name", JString("Benoit"))))
          ),
          waitForTasks = true
        ),
        Duration(100, "sec")
      )
    } catch {
      case e: Exception => println(e)
    }
  }
}

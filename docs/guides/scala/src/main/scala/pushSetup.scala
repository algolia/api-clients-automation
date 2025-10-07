import scala.io.Source
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

import algoliasearch.api.IngestionClient
import algoliasearch.config.*
import algoliasearch.config.*
import algoliasearch.ingestion.*

import org.json4s.native.JsonMethods
import org.json4s.jvalue2extractable

object PushSetup {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
    implicit val formats: org.json4s.Formats = JsonSupport.format

    val result = Source.fromFile("records.json").getLines().mkString
    val records = JsonMethods.parse(result).extract[Seq[algoliasearch.ingestion.PushTaskRecords]]

    // use the region matching your applicationID
    val client = IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    try {
      // setting `watch` to `true` will make the call synchronous
      val resp = Await.result(
        client.pushTask(
          taskID = "YOUR_TASK_ID",
          pushTaskPayload = PushTaskPayload(
            action = Action.withName("addObject"),
            records = records
          ),
          watch = Some(true)
        ),
        Duration(100, "sec")
      )

      println(resp)
    } catch {
      case e: Exception => println(e)
    }
  }
}

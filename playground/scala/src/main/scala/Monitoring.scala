import algoliasearch.monitoring.JsonSupport
import io.github.cdimascio.dotenv.Dotenv
import org.json4s.Formats

import scala.concurrent.ExecutionContextExecutor

object Monitoring {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
    implicit val formats: Formats = JsonSupport.format

    val dotenv = Dotenv.configure.directory("../").load
    val appId = dotenv.get("ALGOLIA_APPLICATION_ID")
    val apiKey = dotenv.get("ALGOLIA_ADMIN_KEY")

    println("hello, world!")
  }
}

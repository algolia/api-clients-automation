import algoliasearch.api.AgentStudioClient
import algoliasearch.agentstudio.JsonSupport
import io.github.cdimascio.dotenv.Dotenv
import org.json4s.Formats

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

object AgentStudio {
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
    implicit val formats: Formats = JsonSupport.format

    val dotenv = Dotenv.configure.directory("../").load
    val appId = dotenv.get("ALGOLIA_APPLICATION_ID")
    val apiKey = dotenv.get("ALGOLIA_ADMIN_KEY")

    val client = AgentStudioClient(
      appId = appId,
      apiKey = apiKey,
      region = "us",
    )

    val res = client.listAgents()
    val response = Await.result(res, Duration(100, "sec"))

    println("List of agents:")
    for (agent <- response.data) {
      println(s"- ${agent.name} (ID: ${agent.id})")
    }
  }
}

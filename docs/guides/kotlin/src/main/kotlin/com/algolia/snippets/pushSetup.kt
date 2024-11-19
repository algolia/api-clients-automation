package org.example
import com.algolia.client.api.IngestionClient

import com.algolia.client.model.ingestion.*

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

suspend fun main() {
  val json = File("/my-raw-records.json").readText()
  val records: List<PushTaskRecords> = Json.decodeFromString(ListSerializer(PushTaskRecords.serializer()), json)

  // use the region matching your applicationID
  val client = IngestionClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

  try {
    val run = client.pushTask(
      taskID = "YOUR_TASK_ID",
      pushTaskPayload = PushTaskPayload(
        action = Action.entries.first { it.value == "addObject" },
        records = records,
      ),
    )

    // use runID in the Observability debugger
    println(run)
  } catch (e: Exception) {
    println(e.message)
  }
}

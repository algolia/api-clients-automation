package org.example

import com.algolia.client.api.IngestionClient
import com.algolia.client.configuration.*
import com.algolia.client.model.ingestion.*
import com.algolia.client.transport.*
import java.io.File
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

suspend fun main() {
  val json = File("records.json").readText()
  val records: List<PushTaskRecords> =
    Json.decodeFromString(ListSerializer(PushTaskRecords.serializer()), json)

  // use the region matching your applicationID
  val client =
    IngestionClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION",
    )

  try {
    // setting `watch` to `true` will make the call synchronous
    val resp =
      client.pushTask(
        taskID = "YOUR_TASK_ID",
        pushTaskPayload =
          PushTaskPayload(
            action = Action.entries.first { it.value == "addObject" },
            records = records,
          ),
        watch = true,
      )

    println(resp)
  } catch (e: Exception) {
    println(e.message)
  }
}

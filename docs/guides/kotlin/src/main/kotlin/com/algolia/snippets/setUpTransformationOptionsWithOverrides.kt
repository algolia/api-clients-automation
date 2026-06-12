package org.example

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.transport.*
import kotlin.time.Duration.Companion.seconds
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject

suspend fun main() {
  // Override the Ingestion API defaults. Any option you don't set keeps its default.
  // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
  val client =
    SearchClient.withTransformation(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      transformationOptions =
        TransformationOptions(
          region = "us",
          clientOptions = ClientOptions(connectTimeout = 5.seconds, readTimeout = 30.seconds),
        ),
    )

  try {
    // Save records, transforming them through the Push connector
    client.saveObjectsWithTransformation(
      indexName = "<YOUR_INDEX_NAME>",
      objects =
        listOf(
          buildJsonObject {
            put("objectID", JsonPrimitive("1"))
            put("name", JsonPrimitive("Adam"))
          },
          buildJsonObject {
            put("objectID", JsonPrimitive("2"))
            put("name", JsonPrimitive("Benoit"))
          },
        ),
      waitForTasks = true,
    )
  } catch (e: Exception) {
    println(e.message)
  }
}

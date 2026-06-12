package org.example

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.transport.*
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject

suspend fun main() {
  // Set `transformationOptions` with your transformation region to use the `WithTransformation`
  // helper methods.
  // Replace "us" with "eu" if your Algolia application uses the Europe analytics region.
  val client =
    SearchClient.withTransformation(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      transformationOptions = TransformationOptions(region = "us"),
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

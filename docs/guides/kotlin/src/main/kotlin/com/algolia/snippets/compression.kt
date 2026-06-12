package org.example

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun main() {
  // Initialize the client with gzip compression enabled
  // Compression reduces the size of request bodies sent to Algolia
  val client =
    SearchClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      options = ClientOptions(compressionType = CompressionType.GZIP),
    )

  // Search with compressed request body
  try {
    val result =
      client.searchSingleIndex(
        indexName = "<YOUR_INDEX_NAME>",
        searchParams = SearchParamsObject(query = "comedy"),
      )
    println(result.hits)
  } catch (e: Exception) {
    println(e.message)
  }
}

package com.algolia.snippets

import com.algolia.client.api.QuerySuggestionsClient
import com.algolia.client.model.querysuggestions.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetQuerySuggestionsClient {
  suspend fun snippetForCreateConfig() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.createConfig(
      querySuggestionsConfigurationWithIndex = QuerySuggestionsConfigurationWithIndex(
        indexName = "theIndexName",
        sourceIndices = listOf(
          SourceIndex(
            indexName = "testIndex",
            facets = listOf(
              Facet(
                attribute = "test",
              ),
            ),
            generate = listOf(listOf("facetA", "facetB"), listOf("facetC")),
          ),
        ),
        languages = Languages.of(listOf("french")),
        exclude = listOf("test"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customDelete(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customGet(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPost(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteConfig() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteConfig(
      indexName = "theIndexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetAllConfigs() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getAllConfigs()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetConfig() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getConfig(
      indexName = "cts_e2e_browse_query_suggestions",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetConfigStatus() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getConfigStatus(
      indexName = "theIndexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetLogFile() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getLogFile(
      indexName = "theIndexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForUpdateConfig() {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.updateConfig(
      indexName = "theIndexName",
      querySuggestionsConfiguration = QuerySuggestionsConfiguration(
        sourceIndices = listOf(
          SourceIndex(
            indexName = "testIndex",
            facets = listOf(
              Facet(
                attribute = "test",
              ),
            ),
            generate = listOf(listOf("facetA", "facetB"), listOf("facetC")),
          ),
        ),
        languages = Languages.of(listOf("french")),
        exclude = listOf("test"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

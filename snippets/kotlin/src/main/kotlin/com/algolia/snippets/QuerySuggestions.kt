// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.snippets

// >IMPORT
import com.algolia.client.api.QuerySuggestionsClient
// IMPORT<
import com.algolia.client.model.querysuggestions.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetQuerySuggestionsClient {
  suspend fun snippetForCreateConfig() {
    // >SEPARATOR createConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.createConfig(
      configurationWithIndex = ConfigurationWithIndex(
        indexName = "<YOUR_INDEX_NAME>",
        sourceIndices = listOf(
          SourceIndex(
            indexName = "<YOUR_INDEX_NAME>",
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
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customDelete(
      path = "test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customGet(
      path = "test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.customPut(
      path = "test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteConfig() {
    // >SEPARATOR deleteConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.deleteConfig(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetAllConfigs() {
    // >SEPARATOR getAllConfigs default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getAllConfigs()

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetConfig() {
    // >SEPARATOR getConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getConfig(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetConfigStatus() {
    // >SEPARATOR getConfigStatus default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getConfigStatus(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetLogFile() {
    // >SEPARATOR getLogFile default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.getLogFile(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateConfig() {
    // >SEPARATOR updateConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    var response = client.updateConfig(
      indexName = "<YOUR_INDEX_NAME>",
      configuration = Configuration(
        sourceIndices = listOf(
          SourceIndex(
            indexName = "<YOUR_INDEX_NAME>",
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
    // SEPARATOR<

    exitProcess(0)
  }
}

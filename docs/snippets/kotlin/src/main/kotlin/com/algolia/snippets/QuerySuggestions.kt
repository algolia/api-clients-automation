// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.snippets

// >IMPORT
import com.algolia.client.api.QuerySuggestionsClient
import com.algolia.client.configuration.*
import com.algolia.client.transport.*

// IMPORT<
import com.algolia.client.model.querysuggestions.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetQuerySuggestionsClient {
  suspend fun snippetForCreateConfig() {
    // >SEPARATOR createConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customDelete(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete1() {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customDelete(
      path = "test/all",
      parameters = mapOf("query" to "parameters"),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customGet(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet1() {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customGet(
      path = "test/all",
      parameters = mapOf("query" to "parameters with space"),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet2() {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customGet(
      path = "test/all",
      parameters = mapOf("query" to "to be overriden"),
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("query", "parameters with space")
          put("and an array", listOf("array", "with spaces"))
        },
        headers = buildMap {
          put("x-header-1", "spaces are left alone")
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost1() {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/all",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "body",
          JsonPrimitive("parameters"),
        )
      },
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost2() {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("query", "myQueryParameter")
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost3() {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("query2", "myQueryParameter")
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost4() {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        headers = buildMap {
          put("x-algolia-api-key", "ALGOLIA_API_KEY")
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost5() {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        headers = buildMap {
          put("x-algolia-api-key", "ALGOLIA_API_KEY")
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost6() {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("isItWorking", true)
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost7() {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("myParam", 2)
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost8() {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("myParam", listOf("b and c", "d"))
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost9() {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("myParam", listOf(true, true, false))
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost10() {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPost(
      path = "test/requestOptions",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "facet",
          JsonPrimitive("filters"),
        )
      },
      requestOptions = RequestOptions(
        urlParameters = buildMap {
          put("myParam", listOf(1, 2))
        },
      ),
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPut(
      path = "test/minimal",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPut1() {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.customPut(
      path = "test/all",
      parameters = mapOf("query" to "parameters"),
      body = buildJsonObject {
        put(
          "body",
          JsonPrimitive("parameters"),
        )
      },
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForDeleteConfig() {
    // >SEPARATOR deleteConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.deleteConfig(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetAllConfigs() {
    // >SEPARATOR getAllConfigs default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getAllConfigs()

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetConfig() {
    // >SEPARATOR getConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getConfig(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetConfigStatus() {
    // >SEPARATOR getConfigStatus default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getConfigStatus(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetLogFile() {
    // >SEPARATOR getLogFile default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    var response = client.getLogFile(
      indexName = "<YOUR_INDEX_NAME>",
    )

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForSetClientApiKey() {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

    // Call the API
    client.setClientApiKey(
      apiKey = "updated-api-key",
    )

    // >LOG
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForUpdateConfig() {
    // >SEPARATOR updateConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY", region = "ALGOLIA_APPLICATION_REGION")

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

    // >LOG
    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }
}

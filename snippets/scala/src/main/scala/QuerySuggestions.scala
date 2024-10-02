// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

// >IMPORT
import algoliasearch.api.QuerySuggestionsClient
// IMPORT<
import algoliasearch.querysuggestions.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetQuerySuggestionsClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the createConfig method.
    *
    * createConfig
    */
  def snippetForQuerySuggestionsClientCreateConfig(): Unit = {
    // >SEPARATOR createConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.createConfig(
      configurationWithIndex = ConfigurationWithIndex(
        indexName = "<YOUR_INDEX_NAME>",
        sourceIndices = Seq(
          SourceIndex(
            indexName = "<YOUR_INDEX_NAME>",
            facets = Some(
              Seq(
                Facet(
                  attribute = Some("test")
                )
              )
            ),
            generate = Some(Seq(Seq("facetA", "facetB"), Seq("facetC")))
          )
        ),
        languages = Some(Languages(Seq("french"))),
        exclude = Some(Seq("test"))
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customDelete[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomGet(): Unit = {
    // >SEPARATOR customGet default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customGet[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomPost(): Unit = {
    // >SEPARATOR customPost default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customPost[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomPut(): Unit = {
    // >SEPARATOR customPut default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.customPut[JObject](
      path = "test/minimal"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteConfig method.
    *
    * deleteConfig
    */
  def snippetForQuerySuggestionsClientDeleteConfig(): Unit = {
    // >SEPARATOR deleteConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.deleteConfig(
      indexName = "<YOUR_INDEX_NAME>"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getAllConfigs method.
    *
    * getAllConfigs
    */
  def snippetForQuerySuggestionsClientGetAllConfigs(): Unit = {
    // >SEPARATOR getAllConfigs default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getAllConfigs(
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getConfig method.
    *
    * Retrieve QS config e2e
    */
  def snippetForQuerySuggestionsClientGetConfig(): Unit = {
    // >SEPARATOR getConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getConfig(
      indexName = "<YOUR_INDEX_NAME>"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getConfigStatus method.
    *
    * getConfigStatus
    */
  def snippetForQuerySuggestionsClientGetConfigStatus(): Unit = {
    // >SEPARATOR getConfigStatus default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getConfigStatus(
      indexName = "<YOUR_INDEX_NAME>"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getLogFile method.
    *
    * getLogFile
    */
  def snippetForQuerySuggestionsClientGetLogFile(): Unit = {
    // >SEPARATOR getLogFile default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.getLogFile(
      indexName = "<YOUR_INDEX_NAME>"
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the updateConfig method.
    *
    * updateConfig
    */
  def snippetForQuerySuggestionsClientUpdateConfig(): Unit = {
    // >SEPARATOR updateConfig default
    // Initialize the client
    val client = QuerySuggestionsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = "ALGOLIA_APPLICATION_REGION"
    )

    // Call the API
    val response = client.updateConfig(
      indexName = "<YOUR_INDEX_NAME>",
      configuration = Configuration(
        sourceIndices = Seq(
          SourceIndex(
            indexName = "<YOUR_INDEX_NAME>",
            facets = Some(
              Seq(
                Facet(
                  attribute = Some("test")
                )
              )
            ),
            generate = Some(Seq(Seq("facetA", "facetB"), Seq("facetC")))
          )
        ),
        languages = Some(Languages(Seq("french"))),
        exclude = Some(Seq("test"))
      )
    )

    // >LOG
    // Use the response
    val value = Await.result(response, Duration(100, "sec"))
    // SEPARATOR<
  }

}

package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.QuerySuggestionsClient
import algoliasearch.querysuggestions.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetQuerySuggestionsClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the createConfig method.
    *
    * createConfig0
    */
  def snippetForQuerySuggestionsClientCreateConfig(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.createConfig(
      querySuggestionsConfigurationWithIndex = QuerySuggestionsConfigurationWithIndex(
        indexName = "theIndexName",
        sourceIndices = Seq(
          SourceIndex(
            indexName = "testIndex",
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

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomDelete(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomGet(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomPost(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForQuerySuggestionsClientCustomPut(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteConfig method.
    *
    * deleteConfig0
    */
  def snippetForQuerySuggestionsClientDeleteConfig(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteConfig(
      indexName = "theIndexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getAllConfigs method.
    *
    * getAllConfigs0
    */
  def snippetForQuerySuggestionsClientGetAllConfigs(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getAllConfigs(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getConfig method.
    *
    * getConfig0
    */
  def snippetForQuerySuggestionsClientGetConfig(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getConfig(
      indexName = "theIndexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getConfigStatus method.
    *
    * getConfigStatus0
    */
  def snippetForQuerySuggestionsClientGetConfigStatus(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getConfigStatus(
      indexName = "theIndexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getLogFile method.
    *
    * getLogFile0
    */
  def snippetForQuerySuggestionsClientGetLogFile(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getLogFile(
      indexName = "theIndexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the updateConfig method.
    *
    * updateConfig0
    */
  def snippetForQuerySuggestionsClientUpdateConfig(): Unit = {
    // Initialize the client
    val client = QuerySuggestionsClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.updateConfig(
      indexName = "theIndexName",
      querySuggestionsConfiguration = QuerySuggestionsConfiguration(
        sourceIndices = Seq(
          SourceIndex(
            indexName = "testIndex",
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

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

}

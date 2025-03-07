// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

// >IMPORT
import algoliasearch.api.MonitoringClient
import algoliasearch.config.*

// IMPORT<
import algoliasearch.monitoring.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetMonitoringClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = JsonSupport.format

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForMonitoringClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customDelete[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with all parameters
    */
  def snippetForMonitoringClientCustomDelete1(): Unit = {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customDelete[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters"))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForMonitoringClientCustomGet(): Unit = {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customGet[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with all parameters
    */
  def snippetForMonitoringClientCustomGet1(): Unit = {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customGet[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters with space"))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * requestOptions should be escaped too
    */
  def snippetForMonitoringClientCustomGet2(): Unit = {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customGet[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "to be overriden")),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("query", "parameters with space")
            .withQueryParameter("and an array", Seq("array", "with spaces"))
            .withHeader("x-header-1", "spaces are left alone")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForMonitoringClientCustomPost(): Unit = {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with all parameters
    */
  def snippetForMonitoringClientCustomPost1(): Unit = {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("body", JString("parameters")))))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions can override default query parameters
    */
  def snippetForMonitoringClientCustomPost2(): Unit = {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("query", "myQueryParameter")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions merges query parameters with default ones
    */
  def snippetForMonitoringClientCustomPost3(): Unit = {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("query2", "myQueryParameter")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions can override default headers
    */
  def snippetForMonitoringClientCustomPost4(): Unit = {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions merges headers with default ones
    */
  def snippetForMonitoringClientCustomPost5(): Unit = {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts booleans
    */
  def snippetForMonitoringClientCustomPost6(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("isItWorking", true)
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts integers
    */
  def snippetForMonitoringClientCustomPost7(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", 2)
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts list of string
    */
  def snippetForMonitoringClientCustomPost8(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", Seq("b and c", "d"))
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts list of booleans
    */
  def snippetForMonitoringClientCustomPost9(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", Seq(true, true, false))
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts list of integers
    */
  def snippetForMonitoringClientCustomPost10(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", Seq(1, 2))
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForMonitoringClientCustomPut(): Unit = {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPut[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with all parameters
    */
  def snippetForMonitoringClientCustomPut1(): Unit = {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.customPut[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("body", JString("parameters")))))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getClusterIncidents method.
    *
    * getClusterIncidents
    */
  def snippetForMonitoringClientGetClusterIncidents(): Unit = {
    // >SEPARATOR getClusterIncidents default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getClusterIncidents(
        clusters = "c1-de"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getClusterStatus method.
    *
    * getClusterStatus
    */
  def snippetForMonitoringClientGetClusterStatus(): Unit = {
    // >SEPARATOR getClusterStatus default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getClusterStatus(
        clusters = "c1-de"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getIncidents method.
    *
    * getIncidents
    */
  def snippetForMonitoringClientGetIncidents(): Unit = {
    // >SEPARATOR getIncidents default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getIncidents(
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getIndexingTime method.
    *
    * getIndexingTime
    */
  def snippetForMonitoringClientGetIndexingTime(): Unit = {
    // >SEPARATOR getIndexingTime default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getIndexingTime(
        clusters = "c1-de"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getLatency method.
    *
    * getLatency
    */
  def snippetForMonitoringClientGetLatency(): Unit = {
    // >SEPARATOR getLatency default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getLatency(
        clusters = "c1-de"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getMetrics method.
    *
    * getMetrics
    */
  def snippetForMonitoringClientGetMetrics(): Unit = {
    // >SEPARATOR getMetrics default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getMetrics(
        metric = Metric.withName("avg_build_time"),
        period = Period.withName("minute")
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getReachability method.
    *
    * getReachability
    */
  def snippetForMonitoringClientGetReachability(): Unit = {
    // >SEPARATOR getReachability default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getReachability(
        clusters = "c1-de"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getServers method.
    *
    * getInventory
    */
  def snippetForMonitoringClientGetServers(): Unit = {
    // >SEPARATOR getServers default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getServers(
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the getStatus method.
    *
    * getStatus
    */
  def snippetForMonitoringClientGetStatus(): Unit = {
    // >SEPARATOR getStatus default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    val response = Await.result(
      client.getStatus(
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the setClientApiKey method.
    *
    * switch API key
    */
  def snippetForMonitoringClientSetClientApiKey(): Unit = {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    val client = MonitoringClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

    // Call the API
    client.setClientApiKey(
      apiKey = "updated-api-key"
    ) // >LOG
    // SEPARATOR<
  }

}

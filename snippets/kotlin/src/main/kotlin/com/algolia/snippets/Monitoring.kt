package com.algolia.snippets

import com.algolia.client.api.MonitoringClient
import com.algolia.client.model.monitoring.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetMonitoringClient {
  suspend fun snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customDelete(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customGet(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPost(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetClusterIncidents() {
    // >SEPARATOR getClusterIncidents
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getClusterIncidents(
      clusters = "c1-de",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetClusterStatus() {
    // >SEPARATOR getClusterStatus
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getClusterStatus(
      clusters = "c1-de",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetIncidents() {
    // >SEPARATOR getIncidents
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getIncidents()

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetIndexingTime() {
    // >SEPARATOR getIndexingTime
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getIndexingTime(
      clusters = "c1-de",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetInventory() {
    // >SEPARATOR getInventory
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getInventory()

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetLatency() {
    // >SEPARATOR getLatency
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getLatency(
      clusters = "c1-de",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetMetrics() {
    // >SEPARATOR getMetrics
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getMetrics(
      metric = Metric.entries.first { it.value == "avg_build_time" },
      period = Period.entries.first { it.value == "minute" },
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetReachability() {
    // >SEPARATOR getReachability
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getReachability(
      clusters = "c1-de",
    )

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }

  suspend fun snippetForGetStatus() {
    // >SEPARATOR getStatus
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getStatus()

    // Use the response
    println(response)
    // SEPARATOR<

    exitProcess(0)
  }
}

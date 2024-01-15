package com.algolia.snippets

import com.algolia.client.api.MonitoringClient
import com.algolia.client.model.monitoring.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetMonitoringClient {
  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetClusterIncidents() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getClusterIncidents(
      clusters = "c1-de",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetClusterStatus() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getClusterStatus(
      clusters = "c1-de",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetIncidents() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getIncidents()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetIndexingTime() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getIndexingTime(
      clusters = "c1-de",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetInventory() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getInventory()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetLatency() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getLatency(
      clusters = "c1-de",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetMetrics() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getMetrics(
      metric = Metric.entries.first { it.value == "avg_build_time" },
      period = Period.entries.first { it.value == "minute" },
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetReachability() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getReachability(
      clusters = "c1-de",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetStatus() {
    // Initialize the client
    val client = MonitoringClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getStatus()

    // Use the response
    println(response)

    exitProcess(0)
  }
}

package com.algolia.methods.requests

import com.algolia.client.api.MonitoringClient
import com.algolia.client.configuration.*
import com.algolia.client.model.monitoring.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.json.*
import kotlin.test.*

class MonitoringTest {

  val client = MonitoringClient(
    appId = "appId",
    apiKey = "apiKey",
  )

  // customDelete

  @Test
  fun `allow del method for a custom path with minimal parameters`() = runTest {
    client.runTest(
      call = {
        customDelete(
          path = "test/minimal",
        )
      },
      intercept = {
        assertEquals("/test/minimal".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("DELETE"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `allow del method for a custom path with all parameters`() = runTest {
    client.runTest(
      call = {
        customDelete(
          path = "test/all",
          parameters = mapOf("query" to "parameters"),
        )
      },
      intercept = {
        assertEquals("/test/all".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("DELETE"), it.method)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // customGet

  @Test
  fun `allow get method for a custom path with minimal parameters`() = runTest {
    client.runTest(
      call = {
        customGet(
          path = "test/minimal",
        )
      },
      intercept = {
        assertEquals("/test/minimal".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `allow get method for a custom path with all parameters`() = runTest {
    client.runTest(
      call = {
        customGet(
          path = "test/all",
          parameters = mapOf("query" to "parameters with space"),
        )
      },
      intercept = {
        assertEquals("/test/all".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"query":"parameters%20with%20space"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `requestOptions should be escaped too`() = runTest {
    client.runTest(
      call = {
        customGet(
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
      },
      intercept = {
        assertEquals("/test/all".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertContainsAll("""{"x-header-1":"spaces are left alone"}""", it.headers)
        assertQueryParams("""{"query":"parameters%20with%20space","and%20an%20array":"array%2Cwith%20spaces"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // customPost

  @Test
  fun `allow post method for a custom path with minimal parameters`() = runTest {
    client.runTest(
      call = {
        customPost(
          path = "test/minimal",
        )
      },
      intercept = {
        assertEquals("/test/minimal".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{}""", it.body)
      },
    )
  }

  @Test
  fun `allow post method for a custom path with all parameters`() = runTest {
    client.runTest(
      call = {
        customPost(
          path = "test/all",
          parameters = mapOf("query" to "parameters"),
          body = buildJsonObject {
            put(
              "body",
              JsonPrimitive("parameters"),
            )
          },
        )
      },
      intercept = {
        assertEquals("/test/all".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"body":"parameters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions can override default query parameters`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"myQueryParameter"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions merges query parameters with default ones`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters","query2":"myQueryParameter"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions can override default headers`() = runTest {
    client.runTest(
      call = {
        customPost(
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
              put("x-algolia-api-key", "myApiKey")
            },
          ),
        )
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertContainsAll("""{"x-algolia-api-key":"myApiKey"}""", it.headers)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions merges headers with default ones`() = runTest {
    client.runTest(
      call = {
        customPost(
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
              put("x-algolia-api-key", "myApiKey")
            },
          ),
        )
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertContainsAll("""{"x-algolia-api-key":"myApiKey"}""", it.headers)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions queryParameters accepts booleans`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters","isItWorking":"true"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions queryParameters accepts integers`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters","myParam":"2"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions queryParameters accepts list of string`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters","myParam":"b%20and%20c%2Cd"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions queryParameters accepts list of booleans`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters","myParam":"true%2Ctrue%2Cfalse"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions queryParameters accepts list of integers`() = runTest {
    client.runTest(
      call = {
        customPost(
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
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertQueryParams("""{"query":"parameters","myParam":"1%2C2"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  // customPut

  @Test
  fun `allow put method for a custom path with minimal parameters`() = runTest {
    client.runTest(
      call = {
        customPut(
          path = "test/minimal",
        )
      },
      intercept = {
        assertEquals("/test/minimal".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("PUT"), it.method)
        assertJsonBody("""{}""", it.body)
      },
    )
  }

  @Test
  fun `allow put method for a custom path with all parameters`() = runTest {
    client.runTest(
      call = {
        customPut(
          path = "test/all",
          parameters = mapOf("query" to "parameters"),
          body = buildJsonObject {
            put(
              "body",
              JsonPrimitive("parameters"),
            )
          },
        )
      },
      intercept = {
        assertEquals("/test/all".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("PUT"), it.method)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"body":"parameters"}""", it.body)
      },
    )
  }

  // getClusterIncidents

  @Test
  fun `getClusterIncidents`() = runTest {
    client.runTest(
      call = {
        getClusterIncidents(
          clusters = "c1-de",
        )
      },
      intercept = {
        assertEquals("/1/incidents/c1-de".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getClusterStatus

  @Test
  fun `getClusterStatus`() = runTest {
    client.runTest(
      call = {
        getClusterStatus(
          clusters = "c1-de",
        )
      },
      intercept = {
        assertEquals("/1/status/c1-de".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getIncidents

  @Test
  fun `getIncidents`() = runTest {
    client.runTest(
      call = {
        getIncidents()
      },
      intercept = {
        assertEquals("/1/incidents".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getIndexingTime

  @Test
  fun `getIndexingTime`() = runTest {
    client.runTest(
      call = {
        getIndexingTime(
          clusters = "c1-de",
        )
      },
      intercept = {
        assertEquals("/1/indexing/c1-de".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getLatency

  @Test
  fun `getLatency`() = runTest {
    client.runTest(
      call = {
        getLatency(
          clusters = "c1-de",
        )
      },
      intercept = {
        assertEquals("/1/latency/c1-de".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getMetrics

  @Test
  fun `getMetrics`() = runTest {
    client.runTest(
      call = {
        getMetrics(
          metric = Metric.entries.first { it.value == "avg_build_time" },
          period = Period.entries.first { it.value == "minute" },
        )
      },
      intercept = {
        assertEquals("/1/infrastructure/avg_build_time/period/minute".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getReachability

  @Test
  fun `getReachability`() = runTest {
    client.runTest(
      call = {
        getReachability(
          clusters = "c1-de",
        )
      },
      intercept = {
        assertEquals("/1/reachability/c1-de/probes".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getServers

  @Test
  fun `getInventory`() = runTest {
    client.runTest(
      call = {
        getServers()
      },
      intercept = {
        assertEquals("/1/inventory/servers".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getStatus

  @Test
  fun `getStatus`() = runTest {
    client.runTest(
      call = {
        getStatus()
      },
      intercept = {
        assertEquals("/1/status".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }
}

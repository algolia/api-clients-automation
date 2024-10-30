// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.client

import com.algolia.client.api.AnalyticsClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.analytics.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import kotlin.test.*

class AnalyticsTest {

  @Test
  fun `calls api with correct user agent`() = runTest {
    val client = AnalyticsClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Analytics (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `the user agent contains the latest version`() = runTest {
    val client = AnalyticsClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(3.7.0\\).*".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `calls api with default read timeouts`() = runTest {
    val client = AnalyticsClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customGet(
          path = "1/test",
        )
      },
      intercept = {
        assertEquals(2000, it.connectTimeout)
        assertEquals(5000, it.socketTimeout)
      },
    )
  }

  @Test
  fun `calls api with default write timeouts`() = runTest {
    val client = AnalyticsClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        assertEquals(2000, it.connectTimeout)
        assertEquals(30000, it.socketTimeout)
      },
    )
  }

  @Test
  fun `fallbacks to the alias when region is not given`() = runTest {
    val client = AnalyticsClient(appId = "my-app-id", apiKey = "my-api-key")
    client.runTest(
      call = {
        getAverageClickPosition(
          index = "my-index",
        )
      },
      intercept = {
        assertEquals("analytics.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `uses the correct region`() = runTest {
    val client = AnalyticsClient(appId = "my-app-id", apiKey = "my-api-key", "de")
    client.runTest(
      call = {
        customPost(
          path = "test",
        )
      },
      intercept = {
        assertEquals("analytics.de.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `throws when incorrect region is given`() = runTest {
    assertFails {
      val client = AnalyticsClient(appId = "my-app-id", apiKey = "my-api-key", "not_a_region")
    }.let { error -> assertError(error, "`region` must be one of the following: de, us".replace("%localhost%", if (System.getenv("CI") == "true") "localhost" else "host.docker.internal")) }
  }

  @Test
  fun `getAverageClickPosition throws without index`() = runTest {
    val client = AnalyticsClient(appId = "appId", apiKey = "apiKey", region = "us")
    assertFails {
      client.getClickPositions(
        index = empty(),
      )
    }.let { error -> assertError(error, "Parameter `index` is required when calling `getClickPositions`.".replace("%localhost%", if (System.getenv("CI") == "true") "localhost" else "host.docker.internal")) }
  }

  @Test
  fun `switch API key`() = runTest {
    val client = AnalyticsClient(appId = "test-app-id", apiKey = "test-api-key", "us", options = ClientOptions(hosts = listOf(Host(url = if (System.getenv("CI") == "true") "localhost" else "host.docker.internal", protocol = "http", port = 6683))))
    client.runTest(
      call = {
        customGet(
          path = "check-api-key/1",
        )
      },

      response = {
        val response = Json.encodeToString(it)
        assertEquals("{\"headerAPIKeyValue\":\"test-api-key\"}", response)
      },
    )
    client.runTest(
      call = {
        setClientApiKey(
          apiKey = "updated-api-key",
        )
      },
      intercept = {
      },
    )
    client.runTest(
      call = {
        customGet(
          path = "check-api-key/2",
        )
      },

      response = {
        val response = Json.encodeToString(it)
        assertEquals("{\"headerAPIKeyValue\":\"updated-api-key\"}", response)
      },
    )
  }
}

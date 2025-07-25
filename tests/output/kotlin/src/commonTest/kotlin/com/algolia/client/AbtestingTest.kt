// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.client

import com.algolia.client.api.AbtestingClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.abtesting.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import kotlin.test.*

class AbtestingTest {

  @Test
  fun `calls api with correct user agent`() = runTest {
    val client = AbtestingClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Abtesting (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `the user agent contains the latest version`() = runTest {
    val client = AbtestingClient(appId = "appId", apiKey = "apiKey", region = "us")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(3.25.1\\).*".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `fallbacks to the alias when region is not given`() = runTest {
    val client = AbtestingClient(appId = "my-app-id", apiKey = "my-api-key")
    client.runTest(
      call = {
        getABTest(
          id = 123,
        )
      },
      intercept = {
        assertEquals("analytics.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `uses the correct region`() = runTest {
    val client = AbtestingClient(appId = "my-app-id", apiKey = "my-api-key", "us")
    client.runTest(
      call = {
        getABTest(
          id = 123,
        )
      },
      intercept = {
        assertEquals("analytics.us.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `throws when incorrect region is given`() = runTest {
    assertFails {
      val client = AbtestingClient(appId = "my-app-id", apiKey = "my-api-key", "not_a_region")
    }.let { error -> assertError(error, "`region` must be one of the following: de, us".replace("%localhost%", if (System.getenv("CI") == "true") "localhost" else "host.docker.internal")) }
  }

  @Test
  fun `switch API key`() = runTest {
    val client = AbtestingClient(appId = "test-app-id", apiKey = "test-api-key", "us", options = ClientOptions(hosts = listOf(Host(url = if (System.getenv("CI") == "true") "localhost" else "host.docker.internal", protocol = "http", port = 6683))))
    client.runTest(
      call = {
        customGet(
          path = "check-api-key/1",
        )
      },

      response = {
        assertNotNull(it)
        JSONAssert.assertEquals("""{"headerAPIKeyValue":"test-api-key"}""", Json.encodeToString(Json.encodeToJsonElement(it)), JSONCompareMode.STRICT)
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
        assertNotNull(it)
        JSONAssert.assertEquals("""{"headerAPIKeyValue":"updated-api-key"}""", Json.encodeToString(Json.encodeToJsonElement(it)), JSONCompareMode.STRICT)
      },
    )
  }
}

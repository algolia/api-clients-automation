// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.client

import com.algolia.client.api.UsageClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.usage.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.json.*
import kotlin.test.*

class UsageTest {

  @Test
  fun `calls api with correct read host`() = runTest {
    val client = UsageClient(appId = "test-app-id", apiKey = "test-api-key")
    client.runTest(
      call = {
        customGet(
          path = "test",
        )
      },
      intercept = {
        assertEquals("usage.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `calls api with correct write host`() = runTest {
    val client = UsageClient(appId = "test-app-id", apiKey = "test-api-key")
    client.runTest(
      call = {
        customPost(
          path = "test",
        )
      },
      intercept = {
        assertEquals("usage.algolia.com", it.url.host)
      },
    )
  }

  @Test
  fun `calls api with correct user agent`() = runTest {
    val client = UsageClient(appId = "appId", apiKey = "apiKey")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Usage (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `the user agent contains the latest version`() = runTest {
    val client = UsageClient(appId = "appId", apiKey = "apiKey")
    client.runTest(
      call = {
        customPost(
          path = "1/test",
        )
      },
      intercept = {
        val regexp = "^Algolia for Kotlin \\(3.2.4\\).*".toRegex()
        val header = it.headers["User-Agent"].orEmpty()
        assertTrue(actual = header.matches(regexp), message = "Expected $header to match the following regex: $regexp")
      },
    )
  }

  @Test
  fun `calls api with default read timeouts`() = runTest {
    val client = UsageClient(appId = "appId", apiKey = "apiKey")
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
    val client = UsageClient(appId = "appId", apiKey = "apiKey")
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
  fun `client throws with invalid parameters`() = runTest {
    assertFails {
      val client = UsageClient(appId = "", apiKey = "")
    }.let { error -> assertError(error, "`appId` is missing.") }
    assertFails {
      val client = UsageClient(appId = "", apiKey = "my-api-key")
    }.let { error -> assertError(error, "`appId` is missing.") }
    assertFails {
      val client = UsageClient(appId = "my-app-id", apiKey = "")
    }.let { error -> assertError(error, "`apiKey` is missing.") }
  }
}

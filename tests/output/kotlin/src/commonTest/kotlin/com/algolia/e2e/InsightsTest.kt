// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.e2e

import com.algolia.client.api.InsightsClient
import com.algolia.client.configuration.*
import com.algolia.client.model.insights.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.github.cdimascio.dotenv.Dotenv
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import kotlin.test.*

class InsightsTest {

  var client: InsightsClient

  init {
    if (System.getenv("CI") == "true") {
      this.client = InsightsClient(appId = System.getenv("ALGOLIA_APPLICATION_ID"), apiKey = System.getenv("ALGOLIA_ADMIN_KEY"), region = "us")
    } else {
      val dotenv = Dotenv.configure().directory("../../").load()
      this.client = InsightsClient(appId = dotenv["ALGOLIA_APPLICATION_ID"], apiKey = dotenv["ALGOLIA_ADMIN_KEY"], region = "us")
    }
  }

  @Test
  fun `Many events type1`() = runTest {
    client.runTest(
      call = {
        pushEvents(
          insightsEvents = InsightsEvents(
            events = listOf(
              ConvertedObjectIDsAfterSearch(
                eventType = ConversionEvent.entries.first { it.value == "conversion" },
                eventName = "Product Purchased",
                index = "products",
                userToken = "user-123456",
                authenticatedUserToken = "user-123456",
                timestamp = 1753228800000L,
                objectIDs = listOf("9780545139700", "9780439784542"),
                queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              ),
              ViewedObjectIDs(
                eventType = ViewEvent.entries.first { it.value == "view" },
                eventName = "Product Detail Page Viewed",
                index = "products",
                userToken = "user-123456",
                authenticatedUserToken = "user-123456",
                timestamp = 1753228800000L,
                objectIDs = listOf("9780545139700", "9780439784542"),
              ),
            ),
          ),
        )
      },
      response = {
        JSONAssert.assertEquals("{\"message\":\"OK\",\"status\":200}", Json.encodeToString(it), JSONCompareMode.LENIENT)
      },
    )
  }
}

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.e2e

import com.algolia.client.api.AbtestingClient
import com.algolia.client.configuration.*
import com.algolia.client.model.abtesting.*
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

class AbtestingTest {

  var client: AbtestingClient

  init {
    if (System.getenv("CI") == "true") {
      this.client = AbtestingClient(appId = System.getenv("ALGOLIA_APPLICATION_ID"), apiKey = System.getenv("ALGOLIA_ADMIN_KEY"), region = "us")
    } else {
      val dotenv = Dotenv.configure().directory("../../").load()
      this.client = AbtestingClient(appId = dotenv["ALGOLIA_APPLICATION_ID"], apiKey = dotenv["ALGOLIA_ADMIN_KEY"], region = "us")
    }
  }

  @Test
  fun `listABTests with parameters1`() = runTest {
    client.runTest(
      call = {
        listABTests(
          offset = 0,
          limit = 21,
          indexPrefix = "cts_e2e ab",
          indexSuffix = "t",
        )
      },
      response = {
        JSONAssert.assertEquals("{\"abtests\":[{\"abTestID\":85635,\"createdAt\":\"2024-05-13T10:12:27.739233Z\",\"endAt\":\"2124-05-13T00:00:00Z\",\"name\":\"cts_e2e_abtest\",\"status\":\"active\",\"variants\":[{\"addToCartCount\":0,\"clickCount\":0,\"conversionCount\":0,\"description\":\"this abtest is used for api client automation tests and will expire in 2124\",\"index\":\"cts_e2e_search_facet\",\"purchaseCount\":0,\"trafficPercentage\":25},{\"addToCartCount\":0,\"clickCount\":0,\"conversionCount\":0,\"description\":\"\",\"index\":\"cts_e2e abtest\",\"purchaseCount\":0,\"trafficPercentage\":75}]}],\"count\":1,\"total\":1}", Json.encodeToString(it), JSONCompareMode.LENIENT)
      },
    )
  }
}

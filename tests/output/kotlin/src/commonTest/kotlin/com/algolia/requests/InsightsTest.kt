package com.algolia.methods.requests

import com.algolia.client.api.InsightsClient
import com.algolia.client.configuration.*
import com.algolia.client.model.insights.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.json.*
import kotlin.test.*

class InsightsTest {

  val client = InsightsClient(
    appId = "appId",
    apiKey = "apiKey",
    region = "us",
  )

  // customDelete

  @Test
  fun `allow del method for a custom path with minimal parameters`() = runTest {
    client.runTest(
      call = {
        customDelete(
          path = "/test/minimal",
        )
      },
      intercept = {
        assertEquals("/1/test/minimal".toPathSegments(), it.url.pathSegments)
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
          path = "/test/all",
          parameters = mapOf("query" to "parameters"),
        )
      },
      intercept = {
        assertEquals("/1/test/all".toPathSegments(), it.url.pathSegments)
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
          path = "/test/minimal",
        )
      },
      intercept = {
        assertEquals("/1/test/minimal".toPathSegments(), it.url.pathSegments)
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
          path = "/test/all",
          parameters = mapOf("query" to "parameters with space"),
        )
      },
      intercept = {
        assertEquals("/1/test/all".toPathSegments(), it.url.pathSegments)
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
          path = "/test/all",
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
        assertEquals("/1/test/all".toPathSegments(), it.url.pathSegments)
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
          path = "/test/minimal",
        )
      },
      intercept = {
        assertEquals("/1/test/minimal".toPathSegments(), it.url.pathSegments)
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
          path = "/test/all",
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
        assertEquals("/1/test/all".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/requestOptions",
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
        assertEquals("/1/test/requestOptions".toPathSegments(), it.url.pathSegments)
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
          path = "/test/minimal",
        )
      },
      intercept = {
        assertEquals("/1/test/minimal".toPathSegments(), it.url.pathSegments)
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
          path = "/test/all",
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
        assertEquals("/1/test/all".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("PUT"), it.method)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"body":"parameters"}""", it.body)
      },
    )
  }

  // deleteUserToken

  @Test
  fun `deleteUserToken0`() = runTest {
    client.runTest(
      call = {
        deleteUserToken(
          userToken = "test-user-1",
        )
      },
      intercept = {
        assertEquals("/1/usertokens/test-user-1".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("DELETE"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // pushEvents

  @Test
  fun `pushEvents0`() = runTest {
    client.runTest(
      call = {
        pushEvents(
          insightsEvents = InsightsEvents(
            events = listOf(
              ClickedObjectIDsAfterSearch(
                eventType = ClickEvent.entries.first { it.value == "click" },
                eventName = "Product Clicked",
                index = "products",
                userToken = "user-123456",
                authenticatedUserToken = "user-123456",
                timestamp = 1641290601962L,
                objectIDs = listOf("9780545139700", "9780439784542"),
                queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
                positions = listOf(7, 6),
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/events".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]}]}""", it.body)
      },
    )
  }

  @Test
  fun `Many events type`() = runTest {
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
                timestamp = 1709424000000L,
                objectIDs = listOf("9780545139700", "9780439784542"),
                queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              ),
              ViewedObjectIDs(
                eventType = ViewEvent.entries.first { it.value == "view" },
                eventName = "Product Detail Page Viewed",
                index = "products",
                userToken = "user-123456",
                authenticatedUserToken = "user-123456",
                timestamp = 1709424000000L,
                objectIDs = listOf("9780545139700", "9780439784542"),
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/events".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1709424000000,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1709424000000,"objectIDs":["9780545139700","9780439784542"]}]}""", it.body)
      },
    )
  }

  @Test
  fun `ConvertedObjectIDsAfterSearch`() = runTest {
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
                timestamp = 1641290601962L,
                objectIDs = listOf("9780545139700", "9780439784542"),
                queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/events".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}""", it.body)
      },
    )
  }

  @Test
  fun `ViewedObjectIDs`() = runTest {
    client.runTest(
      call = {
        pushEvents(
          insightsEvents = InsightsEvents(
            events = listOf(
              ViewedObjectIDs(
                eventType = ViewEvent.entries.first { it.value == "view" },
                eventName = "Product Detail Page Viewed",
                index = "products",
                userToken = "user-123456",
                authenticatedUserToken = "user-123456",
                timestamp = 1641290601962L,
                objectIDs = listOf("9780545139700", "9780439784542"),
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/events".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"events":[{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]}]}""", it.body)
      },
    )
  }

  @Test
  fun `AddedToCartObjectIDs`() = runTest {
    client.runTest(
      call = {
        pushEvents(
          insightsEvents = InsightsEvents(
            events = listOf(
              AddedToCartObjectIDsAfterSearch(
                eventType = ConversionEvent.entries.first { it.value == "conversion" },
                eventSubtype = AddToCartEvent.entries.first { it.value == "addToCart" },
                eventName = "Product Added To Cart",
                index = "products",
                queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
                userToken = "user-123456",
                authenticatedUserToken = "user-123456",
                timestamp = 1641290601962L,
                objectIDs = listOf("9780545139700", "9780439784542"),
                objectData = listOf(
                  ObjectDataAfterSearch(
                    price = Price.of(19.99),
                    quantity = 10,
                    discount = Discount.of(2.5),
                  ),
                  ObjectDataAfterSearch(
                    price = Price.of("8$"),
                    quantity = 7,
                    discount = Discount.of("30%"),
                  ),
                ),
                currency = "USD",
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/events".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"events":[{"eventType":"conversion","eventSubtype":"addToCart","eventName":"Product Added To Cart","index":"products","queryID":"43b15df305339e827f0ac0bdc5ebcaa7","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"objectData":[{"price":19.99,"quantity":10,"discount":2.5},{"price":"8$","quantity":7,"discount":"30%"}],"currency":"USD"}]}""", it.body)
      },
    )
  }
}

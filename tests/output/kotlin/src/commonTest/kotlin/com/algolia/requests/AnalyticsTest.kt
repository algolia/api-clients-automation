package com.algolia.methods.requests

import com.algolia.client.api.AnalyticsClient
import com.algolia.client.configuration.*
import com.algolia.client.model.analytics.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.json.*
import kotlin.test.*

class AnalyticsTest {

  val client = AnalyticsClient(
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

  // getAverageClickPosition

  @Test
  fun `get getAverageClickPosition with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getAverageClickPosition(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/clicks/averageClickPosition".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getAverageClickPosition with all parameters`() = runTest {
    client.runTest(
      call = {
        getAverageClickPosition(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/clicks/averageClickPosition".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getClickPositions

  @Test
  fun `get getClickPositions with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getClickPositions(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/clicks/positions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getClickPositions with all parameters`() = runTest {
    client.runTest(
      call = {
        getClickPositions(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/clicks/positions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getClickThroughRate

  @Test
  fun `get getClickThroughRate with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getClickThroughRate(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/clicks/clickThroughRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getClickThroughRate with all parameters`() = runTest {
    client.runTest(
      call = {
        getClickThroughRate(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/clicks/clickThroughRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getConversationRate

  @Test
  fun `get getConversationRate with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getConversationRate(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/conversions/conversionRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getConversationRate with all parameters`() = runTest {
    client.runTest(
      call = {
        getConversationRate(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/conversions/conversionRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getNoClickRate

  @Test
  fun `get getNoClickRate with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getNoClickRate(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/searches/noClickRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getNoClickRate with all parameters`() = runTest {
    client.runTest(
      call = {
        getNoClickRate(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/searches/noClickRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getNoResultsRate

  @Test
  fun `get getNoResultsRate with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getNoResultsRate(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/searches/noResultRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getNoResultsRate with all parameters`() = runTest {
    client.runTest(
      call = {
        getNoResultsRate(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/searches/noResultRate".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getSearchesCount

  @Test
  fun `get getSearchesCount with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getSearchesCount(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/searches/count".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getSearchesCount with all parameters`() = runTest {
    client.runTest(
      call = {
        getSearchesCount(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/searches/count".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getSearchesNoClicks

  @Test
  fun `get getSearchesNoClicks with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getSearchesNoClicks(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/searches/noClicks".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getSearchesNoClicks with all parameters`() = runTest {
    client.runTest(
      call = {
        getSearchesNoClicks(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/searches/noClicks".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getSearchesNoResults

  @Test
  fun `get getSearchesNoResults with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getSearchesNoResults(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/searches/noResults".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getSearchesNoResults with all parameters`() = runTest {
    client.runTest(
      call = {
        getSearchesNoResults(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/searches/noResults".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getStatus

  @Test
  fun `get getStatus with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getStatus(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/status".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getTopCountries

  @Test
  fun `get getTopCountries with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getTopCountries(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/countries".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopCountries with all parameters`() = runTest {
    client.runTest(
      call = {
        getTopCountries(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/countries".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getTopFilterAttributes

  @Test
  fun `get getTopFilterAttributes with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getTopFilterAttributes(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/filters".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopFilterAttributes with all parameters`() = runTest {
    client.runTest(
      call = {
        getTopFilterAttributes(
          index = "index",
          search = "mySearch",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/filters".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getTopFilterForAttribute

  @Test
  fun `get getTopFilterForAttribute with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getTopFilterForAttribute(
          attribute = "myAttribute",
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/filters/myAttribute".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopFilterForAttribute with minimal parameters and multiple attributes`() = runTest {
    client.runTest(
      call = {
        getTopFilterForAttribute(
          attribute = "myAttribute1,myAttribute2",
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/filters/myAttribute1%2CmyAttribute2".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopFilterForAttribute with all parameters`() = runTest {
    client.runTest(
      call = {
        getTopFilterForAttribute(
          attribute = "myAttribute",
          index = "index",
          search = "mySearch",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/filters/myAttribute".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopFilterForAttribute with all parameters and multiple attributes`() = runTest {
    client.runTest(
      call = {
        getTopFilterForAttribute(
          attribute = "myAttribute1,myAttribute2",
          index = "index",
          search = "mySearch",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/filters/myAttribute1%2CmyAttribute2".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getTopFiltersNoResults

  @Test
  fun `get getTopFiltersNoResults with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getTopFiltersNoResults(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/filters/noResults".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopFiltersNoResults with all parameters`() = runTest {
    client.runTest(
      call = {
        getTopFiltersNoResults(
          index = "index",
          search = "mySearch",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/filters/noResults".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getTopHits

  @Test
  fun `get getTopHits with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getTopHits(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/hits".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopHits with all parameters`() = runTest {
    client.runTest(
      call = {
        getTopHits(
          index = "index",
          search = "mySearch",
          clickAnalytics = true,
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/hits".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","search":"mySearch","clickAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getTopSearches

  @Test
  fun `get getTopSearches with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getTopSearches(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/searches".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getTopSearches with all parameters`() = runTest {
    client.runTest(
      call = {
        getTopSearches(
          index = "index",
          clickAnalytics = true,
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          orderBy = OrderBy.entries.first { it.value == "searchCount" },
          direction = Direction.entries.first { it.value == "asc" },
          limit = 21,
          offset = 42,
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/searches".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","clickAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","orderBy":"searchCount","direction":"asc","limit":"21","offset":"42","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `e2e with complex query params`() = runTest {
    client.runTest(
      call = {
        getTopSearches(
          index = "cts_e2e_space in index",
        )
      },
      intercept = {
        assertEquals("/2/searches".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"cts_e2e_space%20in%20index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  // getUsersCount

  @Test
  fun `get getUsersCount with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getUsersCount(
          index = "index",
        )
      },
      intercept = {
        assertEquals("/2/users/count".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }

  @Test
  fun `get getUsersCount with all parameters`() = runTest {
    client.runTest(
      call = {
        getUsersCount(
          index = "index",
          startDate = "1999-09-19",
          endDate = "2001-01-01",
          tags = "tag",
        )
      },
      intercept = {
        assertEquals("/2/users/count".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertQueryParams("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""", it.url.encodedParameters)
        assertNoBody(it.body)
      },
    )
  }
}

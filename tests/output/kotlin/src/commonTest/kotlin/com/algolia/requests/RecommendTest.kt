// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package com.algolia.requests

import com.algolia.client.api.RecommendClient
import com.algolia.client.configuration.*
import com.algolia.client.model.recommend.*
import com.algolia.client.transport.*
import com.algolia.utils.*
import io.ktor.http.*
import kotlinx.coroutines.test.*
import kotlinx.serialization.json.*
import kotlin.test.*

class RecommendTest {

  val client = RecommendClient(
    appId = "appId",
    apiKey = "apiKey",
  )

  // batchRecommendRules

  @Test
  fun `batch recommend rules`() = runTest {
    client.runTest(
      call = {
        batchRecommendRules(
          indexName = "indexName",
          model = RecommendModels.entries.first { it.value == "related-products" },
        )
      },
      intercept = {
        assertEquals("/1/indexes/indexName/related-products/recommend/rules/batch".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{}""", it.body)
      },
    )
  }

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
  fun `allow del method for a custom path with all parameters1`() = runTest {
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
  fun `allow get method for a custom path with all parameters1`() = runTest {
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
  fun `requestOptions should be escaped too2`() = runTest {
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
  fun `allow post method for a custom path with all parameters1`() = runTest {
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
  fun `requestOptions can override default query parameters2`() = runTest {
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
  fun `requestOptions merges query parameters with default ones3`() = runTest {
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
  fun `requestOptions can override default headers4`() = runTest {
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
              put("x-algolia-api-key", "ALGOLIA_API_KEY")
            },
          ),
        )
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertContainsAll("""{"x-algolia-api-key":"ALGOLIA_API_KEY"}""", it.headers)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions merges headers with default ones5`() = runTest {
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
              put("x-algolia-api-key", "ALGOLIA_API_KEY")
            },
          ),
        )
      },
      intercept = {
        assertEquals("/test/requestOptions".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertContainsAll("""{"x-algolia-api-key":"ALGOLIA_API_KEY"}""", it.headers)
        assertQueryParams("""{"query":"parameters"}""", it.url.encodedParameters)
        assertJsonBody("""{"facet":"filters"}""", it.body)
      },
    )
  }

  @Test
  fun `requestOptions queryParameters accepts booleans6`() = runTest {
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
  fun `requestOptions queryParameters accepts integers7`() = runTest {
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
  fun `requestOptions queryParameters accepts list of string8`() = runTest {
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
  fun `requestOptions queryParameters accepts list of booleans9`() = runTest {
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
  fun `requestOptions queryParameters accepts list of integers10`() = runTest {
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
  fun `allow put method for a custom path with all parameters1`() = runTest {
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

  // deleteRecommendRule

  @Test
  fun `deleteRecommendRule`() = runTest {
    client.runTest(
      call = {
        deleteRecommendRule(
          indexName = "indexName",
          model = RecommendModels.entries.first { it.value == "related-products" },
          objectID = "objectID",
        )
      },
      intercept = {
        assertEquals("/1/indexes/indexName/related-products/recommend/rules/objectID".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("DELETE"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getRecommendRule

  @Test
  fun `getRecommendRule`() = runTest {
    client.runTest(
      call = {
        getRecommendRule(
          indexName = "indexName",
          model = RecommendModels.entries.first { it.value == "related-products" },
          objectID = "objectID",
        )
      },
      intercept = {
        assertEquals("/1/indexes/indexName/related-products/recommend/rules/objectID".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getRecommendStatus

  @Test
  fun `getRecommendStatus`() = runTest {
    client.runTest(
      call = {
        getRecommendStatus(
          indexName = "indexName",
          model = RecommendModels.entries.first { it.value == "related-products" },
          taskID = 12345L,
        )
      },
      intercept = {
        assertEquals("/1/indexes/indexName/related-products/task/12345".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("GET"), it.method)
        assertNoBody(it.body)
      },
    )
  }

  // getRecommendations

  @Test
  fun `get recommendations for recommend model with minimal parameters`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              RelatedQuery(
                indexName = "indexName",
                objectID = "objectID",
                model = RelatedModel.entries.first { it.value == "related-products" },
                threshold = 42.1,
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42.1}]}""", it.body)
      },
    )
  }

  @Test
  fun `get recommendations for recommend model with all parameters1`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              RelatedQuery(
                indexName = "indexName",
                objectID = "objectID",
                model = RelatedModel.entries.first { it.value == "related-products" },
                threshold = 42.1,
                maxRecommendations = 10,
                queryParameters = RecommendSearchParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("query"))),
                ),
                fallbackParameters = FallbackParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("fallback"))),
                ),
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42.1,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}""", it.body)
      },
    )
  }

  @Test
  fun `get recommendations for trending model with minimal parameters2`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              TrendingItemsQuery(
                indexName = "indexName",
                model = TrendingItemsModel.entries.first { it.value == "trending-items" },
                threshold = 42.1,
                facetName = "facet",
                facetValue = "value",
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42.1,"facetName":"facet","facetValue":"value"}]}""", it.body)
      },
    )
  }

  @Test
  fun `get recommendations for trending model with all parameters3`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              TrendingItemsQuery(
                indexName = "indexName",
                model = TrendingItemsModel.entries.first { it.value == "trending-items" },
                threshold = 42.1,
                maxRecommendations = 10,
                facetName = "myFacetName",
                facetValue = "myFacetValue",
                queryParameters = RecommendSearchParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("query"))),
                ),
                fallbackParameters = FallbackParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("fallback"))),
                ),
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42.1,"maxRecommendations":10,"facetName":"myFacetName","facetValue":"myFacetValue","queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}""", it.body)
      },
    )
  }

  @Test
  fun `get multiple recommendations with minimal parameters4`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              RelatedQuery(
                indexName = "indexName1",
                objectID = "objectID1",
                model = RelatedModel.entries.first { it.value == "related-products" },
                threshold = 21.7,
              ),
              RelatedQuery(
                indexName = "indexName2",
                objectID = "objectID2",
                model = RelatedModel.entries.first { it.value == "related-products" },
                threshold = 21.7,
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21.7},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21.7}]}""", it.body)
      },
    )
  }

  @Test
  fun `get multiple recommendations with all parameters5`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              RelatedQuery(
                indexName = "indexName1",
                objectID = "objectID1",
                model = RelatedModel.entries.first { it.value == "related-products" },
                threshold = 21.7,
                maxRecommendations = 10,
                queryParameters = RecommendSearchParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("query1"))),
                ),
                fallbackParameters = FallbackParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("fallback1"))),
                ),
              ),
              RelatedQuery(
                indexName = "indexName2",
                objectID = "objectID2",
                model = RelatedModel.entries.first { it.value == "related-products" },
                threshold = 21.7,
                maxRecommendations = 10,
                queryParameters = RecommendSearchParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("query2"))),
                ),
                fallbackParameters = FallbackParams(
                  query = "myQuery",
                  facetFilters = FacetFilters.of(listOf(FacetFilters.of("fallback2"))),
                ),
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21.7,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query1"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback1"]}},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21.7,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query2"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback2"]}}]}""", it.body)
      },
    )
  }

  @Test
  fun `get frequently bought together recommendations6`() = runTest {
    client.runTest(
      call = {
        getRecommendations(
          getRecommendationsParams = GetRecommendationsParams(
            requests = listOf(
              BoughtTogetherQuery(
                indexName = "indexName1",
                objectID = "objectID1",
                model = FbtModel.entries.first { it.value == "bought-together" },
                threshold = 42.7,
              ),
            ),
          ),
        )
      },
      intercept = {
        assertEquals("/1/indexes/*/recommendations".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"bought-together","threshold":42.7}]}""", it.body)
      },
    )
  }

  // searchRecommendRules

  @Test
  fun `searchRecommendRules`() = runTest {
    client.runTest(
      call = {
        searchRecommendRules(
          indexName = "indexName",
          model = RecommendModels.entries.first { it.value == "related-products" },
        )
      },
      intercept = {
        assertEquals("/1/indexes/indexName/related-products/recommend/rules/search".toPathSegments(), it.url.pathSegments)
        assertEquals(HttpMethod.parse("POST"), it.method)
        assertJsonBody("""{}""", it.body)
      },
    )
  }
}

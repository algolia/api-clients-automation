package algoliasearch.methods.requests

import algoliasearch.EchoInterceptor
import algoliasearch.api.AbtestingClient
import algoliasearch.config.*
import algoliasearch.abtesting.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class AbtestingTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(): (AbtestingClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      AbtestingClient(
        appId = "appId",
        apiKey = "apiKey",
        region = Some("us"),
        clientOptions = ClientOptions
          .builder()
          .withRequesterConfig(requester => requester.withInterceptor(echo))
          .build()
      ),
      echo
    )
  }

  test("addABTests with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.addABTests(
      addABTestsRequest = AddABTestsRequest(
        endAt = "2022-12-31T00:00:00.000Z",
        name = "myABTest",
        variants = Seq(
          AbTestsVariant(
            index = "AB_TEST_1",
            trafficPercentage = 30
          ),
          AbTestsVariant(
            index = "AB_TEST_2",
            trafficPercentage = 50
          )
        )
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests")
    assert(res.method == "POST")
    val expectedBody = parse(
      """{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variants":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}"""
    )
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("allow del method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.del[JObject](
      path = "/test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/minimal")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
  }

  test("allow del method for a custom path with all parameters") {
    val (client, echo) = testClient()
    val future = client.del[JObject](
      path = "/test/all",
      parameters = Some(Map("query" -> "parameters"))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/all")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("deleteABTest") {
    val (client, echo) = testClient()
    val future = client.deleteABTest(
      id = 42
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/42")
    assert(res.method == "DELETE")
    assert(res.body.isEmpty)
  }

  test("allow get method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.get[JObject](
      path = "/test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/minimal")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("allow get method for a custom path with all parameters") {
    val (client, echo) = testClient()
    val future = client.get[JObject](
      path = "/test/all",
      parameters = Some(Map("query" -> "parameters"))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/all")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("getABTest") {
    val (client, echo) = testClient()
    val future = client.getABTest(
      id = 42
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/42")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("listABTests with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.listABTests(
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
  }

  test("listABTests with parameters") {
    val (client, echo) = testClient()
    val future = client.listABTests(
      offset = Some(42),
      limit = Some(21),
      indexPrefix = Some("foo"),
      indexSuffix = Some("bar")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery =
      parse("""{"offset":"42","limit":"21","indexPrefix":"foo","indexSuffix":"bar"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("allow post method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/minimal")
    assert(res.method == "POST")
    val expectedBody = parse("""{}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("allow post method for a custom path with all parameters") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/all",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("body", JString("parameters")))))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/all")
    assert(res.method == "POST")
    val expectedBody = parse("""{"body":"parameters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions can override default query parameters") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("query", "myQueryParameter")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"myQueryParameter"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions merges query parameters with default ones") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("query2", "myQueryParameter")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","query2":"myQueryParameter"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions can override default headers") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withHeader("x-algolia-api-key", "myApiKey")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
    val expectedHeaders = parse("""{"x-algolia-api-key":"myApiKey"}""").asInstanceOf[JObject].obj.toMap
    val actualHeaders = res.headers
    for ((k, v) <- expectedHeaders) {
      assert(actualHeaders.contains(k))
      assert(actualHeaders(k) == v.asInstanceOf[JString].s)
    }
  }

  test("requestOptions merges headers with default ones") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withHeader("x-algolia-api-key", "myApiKey")
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
    val expectedHeaders = parse("""{"x-algolia-api-key":"myApiKey"}""").asInstanceOf[JObject].obj.toMap
    val actualHeaders = res.headers
    for ((k, v) <- expectedHeaders) {
      assert(actualHeaders.contains(k))
      assert(actualHeaders(k) == v.asInstanceOf[JString].s)
    }
  }

  test("requestOptions queryParameters accepts booleans") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("isItWorking", true)
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","isItWorking":"true"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts integers") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", 2)
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"2"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts list of string") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", Seq("c", "d"))
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"c,d"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts list of booleans") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", Seq(true, true, false))
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"true,true,false"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("requestOptions queryParameters accepts list of integers") {
    val (client, echo) = testClient()
    val future = client.post[JObject](
      path = "/test/requestOptions",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("facet", JString("filters"))))),
      requestOptions = Some(
        RequestOptions
          .builder()
          .withQueryParameter("myParam", Seq(1, 2))
          .build()
      )
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/requestOptions")
    assert(res.method == "POST")
    val expectedBody = parse("""{"facet":"filters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters","myParam":"1,2"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("allow put method for a custom path with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.put[JObject](
      path = "/test/minimal"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/minimal")
    assert(res.method == "PUT")
    val expectedBody = parse("""{}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
  }

  test("allow put method for a custom path with all parameters") {
    val (client, echo) = testClient()
    val future = client.put[JObject](
      path = "/test/all",
      parameters = Some(Map("query" -> "parameters")),
      body = Some(JObject(List(JField("body", JString("parameters")))))
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/1/test/all")
    assert(res.method == "PUT")
    val expectedBody = parse("""{"body":"parameters"}""")
    val actualBody = parse(res.body.get)
    assert(actualBody == expectedBody)
    val expectedQuery = parse("""{"query":"parameters"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("stopABTest") {
    val (client, echo) = testClient()
    val future = client.stopABTest(
      id = 42
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/abtests/42/stop")
    assert(res.method == "POST")
    assert(res.body.contains("{}"))
  }

}

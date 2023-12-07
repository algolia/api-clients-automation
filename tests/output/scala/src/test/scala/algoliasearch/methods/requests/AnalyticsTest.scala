package algoliasearch.methods.requests

import algoliasearch.EchoInterceptor
import algoliasearch.api.AnalyticsClient
import algoliasearch.config.*
import algoliasearch.analytics.*
import org.json4s.*
import org.json4s.native.JsonParser.*
import org.scalatest.funsuite.AnyFunSuite

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

class AnalyticsTest extends AnyFunSuite {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  def testClient(): (AnalyticsClient, EchoInterceptor) = {
    val echo = EchoInterceptor()
    (
      AnalyticsClient(
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

  test("get getAverageClickPosition with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getAverageClickPosition(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/clicks/averageClickPosition")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getAverageClickPosition with all parameters") {
    val (client, echo) = testClient()
    val future = client.getAverageClickPosition(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/clicks/averageClickPosition")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getClickPositions with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getClickPositions(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/clicks/positions")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getClickPositions with all parameters") {
    val (client, echo) = testClient()
    val future = client.getClickPositions(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/clicks/positions")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getClickThroughRate with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getClickThroughRate(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/clicks/clickThroughRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getClickThroughRate with all parameters") {
    val (client, echo) = testClient()
    val future = client.getClickThroughRate(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/clicks/clickThroughRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getConversationRate with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getConversationRate(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/conversions/conversionRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getConversationRate with all parameters") {
    val (client, echo) = testClient()
    val future = client.getConversationRate(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/conversions/conversionRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getNoClickRate with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getNoClickRate(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noClickRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getNoClickRate with all parameters") {
    val (client, echo) = testClient()
    val future = client.getNoClickRate(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noClickRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getNoResultsRate with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getNoResultsRate(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noResultRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getNoResultsRate with all parameters") {
    val (client, echo) = testClient()
    val future = client.getNoResultsRate(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noResultRate")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getSearchesCount with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getSearchesCount(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/count")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getSearchesCount with all parameters") {
    val (client, echo) = testClient()
    val future = client.getSearchesCount(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/count")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getSearchesNoClicks with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getSearchesNoClicks(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noClicks")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getSearchesNoClicks with all parameters") {
    val (client, echo) = testClient()
    val future = client.getSearchesNoClicks(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noClicks")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getSearchesNoResults with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getSearchesNoResults(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noResults")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getSearchesNoResults with all parameters") {
    val (client, echo) = testClient()
    val future = client.getSearchesNoResults(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches/noResults")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getStatus with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getStatus(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/status")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopCountries with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getTopCountries(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/countries")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopCountries with all parameters") {
    val (client, echo) = testClient()
    val future = client.getTopCountries(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/countries")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFilterAttributes with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getTopFilterAttributes(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFilterAttributes with all parameters") {
    val (client, echo) = testClient()
    val future = client.getTopFilterAttributes(
      index = "index",
      search = Some("mySearch"),
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFilterForAttribute with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getTopFilterForAttribute(
      attribute = "myAttribute",
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters/myAttribute")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFilterForAttribute with minimal parameters and multiple attributes") {
    val (client, echo) = testClient()
    val future = client.getTopFilterForAttribute(
      attribute = "myAttribute1,myAttribute2",
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters/myAttribute1%2CmyAttribute2")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFilterForAttribute with all parameters") {
    val (client, echo) = testClient()
    val future = client.getTopFilterForAttribute(
      attribute = "myAttribute",
      index = "index",
      search = Some("mySearch"),
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters/myAttribute")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFilterForAttribute with all parameters and multiple attributes") {
    val (client, echo) = testClient()
    val future = client.getTopFilterForAttribute(
      attribute = "myAttribute1,myAttribute2",
      index = "index",
      search = Some("mySearch"),
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters/myAttribute1%2CmyAttribute2")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFiltersNoResults with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getTopFiltersNoResults(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters/noResults")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopFiltersNoResults with all parameters") {
    val (client, echo) = testClient()
    val future = client.getTopFiltersNoResults(
      index = "index",
      search = Some("mySearch"),
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/filters/noResults")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopHits with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getTopHits(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/hits")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopHits with all parameters") {
    val (client, echo) = testClient()
    val future = client.getTopHits(
      index = "index",
      search = Some("mySearch"),
      clickAnalytics = Some(true),
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/hits")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","search":"mySearch","clickAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopSearches with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getTopSearches(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getTopSearches with all parameters") {
    val (client, echo) = testClient()
    val future = client.getTopSearches(
      index = "index",
      clickAnalytics = Some(true),
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      orderBy = Some(OrderBy.withName("searchCount")),
      direction = Some(Direction.withName("asc")),
      limit = Some(21),
      offset = Some(42),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/searches")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse(
      """{"index":"index","clickAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","orderBy":"searchCount","direction":"asc","limit":"21","offset":"42","tags":"tag"}"""
    ).asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getUsersCount with minimal parameters") {
    val (client, echo) = testClient()
    val future = client.getUsersCount(
      index = "index"
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/users/count")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index"}""").asInstanceOf[JObject].obj.toMap
    val actualQuery = res.queryParameters
    assert(actualQuery.size == expectedQuery.size)
    for ((k, v) <- actualQuery) {
      assert(expectedQuery.contains(k))
      assert(expectedQuery(k).values == v)
    }
  }

  test("get getUsersCount with all parameters") {
    val (client, echo) = testClient()
    val future = client.getUsersCount(
      index = "index",
      startDate = Some("1999-09-19"),
      endDate = Some("2001-01-01"),
      tags = Some("tag")
    )

    Await.ready(future, Duration.Inf)
    val res = echo.lastResponse.get

    assert(res.path == "/2/users/count")
    assert(res.method == "GET")
    assert(res.body.isEmpty)
    val expectedQuery = parse("""{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}""")
      .asInstanceOf[JObject]
      .obj
      .toMap
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

}

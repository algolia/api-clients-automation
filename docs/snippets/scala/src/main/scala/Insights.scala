// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

// >IMPORT
import algoliasearch.api.InsightsClient
import algoliasearch.config.*

// IMPORT<
import algoliasearch.insights.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetInsightsClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = JsonSupport.format

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForInsightsClientCustomDelete(): Unit = {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customDelete[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with all parameters
    */
  def snippetForInsightsClientCustomDelete1(): Unit = {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customDelete[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters"))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForInsightsClientCustomGet(): Unit = {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customGet[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with all parameters
    */
  def snippetForInsightsClientCustomGet1(): Unit = {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customGet[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters with space"))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * requestOptions should be escaped too
    */
  def snippetForInsightsClientCustomGet2(): Unit = {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customGet[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "to be overriden")),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("query", "parameters with space")
            .withQueryParameter("and an array", Seq("array", "with spaces"))
            .withHeader("x-header-1", "spaces are left alone")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForInsightsClientCustomPost(): Unit = {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with all parameters
    */
  def snippetForInsightsClientCustomPost1(): Unit = {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("body", JString("parameters")))))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions can override default query parameters
    */
  def snippetForInsightsClientCustomPost2(): Unit = {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("query", "myQueryParameter")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions merges query parameters with default ones
    */
  def snippetForInsightsClientCustomPost3(): Unit = {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("query2", "myQueryParameter")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions can override default headers
    */
  def snippetForInsightsClientCustomPost4(): Unit = {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions merges headers with default ones
    */
  def snippetForInsightsClientCustomPost5(): Unit = {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts booleans
    */
  def snippetForInsightsClientCustomPost6(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("isItWorking", true)
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts integers
    */
  def snippetForInsightsClientCustomPost7(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", 2)
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts list of string
    */
  def snippetForInsightsClientCustomPost8(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", Seq("b and c", "d"))
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts list of booleans
    */
  def snippetForInsightsClientCustomPost9(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", Seq(true, true, false))
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * requestOptions queryParameters accepts list of integers
    */
  def snippetForInsightsClientCustomPost10(): Unit = {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPost[JObject](
        path = "test/requestOptions",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("facet", JString("filters"))))),
        requestOptions = Some(
          RequestOptions
            .builder()
            .withQueryParameter("myParam", Seq(1, 2))
            .build()
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForInsightsClientCustomPut(): Unit = {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPut[JObject](
        path = "test/minimal"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with all parameters
    */
  def snippetForInsightsClientCustomPut1(): Unit = {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.customPut[JObject](
        path = "test/all",
        parameters = Some(Map("query" -> "parameters")),
        body = Some(JObject(List(JField("body", JString("parameters")))))
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the deleteUserToken method.
    *
    * deleteUserToken
    */
  def snippetForInsightsClientDeleteUserToken(): Unit = {
    // >SEPARATOR deleteUserToken default
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    Await.result(
      client.deleteUserToken(
        userToken = "test-user-1"
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the pushEvents method.
    *
    * pushEvents
    */
  def snippetForInsightsClientPushEvents(): Unit = {
    // >SEPARATOR pushEvents pushEvents
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.pushEvents(
        insightsEvents = InsightsEvents(
          events = Seq(
            ClickedObjectIDsAfterSearch(
              eventType = ClickEvent.withName("click"),
              eventName = "Product Clicked",
              index = "products",
              userToken = "user-123456",
              authenticatedUserToken = Some("user-123456"),
              timestamp = Some(1641290601962L),
              objectIDs = Seq("9780545139700", "9780439784542"),
              queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              positions = Seq(7, 6)
            )
          )
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the pushEvents method.
    *
    * Many events type
    */
  def snippetForInsightsClientPushEvents1(): Unit = {
    // >SEPARATOR pushEvents Many events type
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.pushEvents(
        insightsEvents = InsightsEvents(
          events = Seq(
            ConvertedObjectIDsAfterSearch(
              eventType = ConversionEvent.withName("conversion"),
              eventName = "Product Purchased",
              index = "products",
              userToken = "user-123456",
              authenticatedUserToken = Some("user-123456"),
              timestamp = Some(1741564800000L),
              objectIDs = Seq("9780545139700", "9780439784542"),
              queryID = "43b15df305339e827f0ac0bdc5ebcaa7"
            ),
            ViewedObjectIDs(
              eventType = ViewEvent.withName("view"),
              eventName = "Product Detail Page Viewed",
              index = "products",
              userToken = "user-123456",
              authenticatedUserToken = Some("user-123456"),
              timestamp = Some(1741564800000L),
              objectIDs = Seq("9780545139700", "9780439784542")
            )
          )
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the pushEvents method.
    *
    * ConvertedObjectIDsAfterSearch
    */
  def snippetForInsightsClientPushEvents2(): Unit = {
    // >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.pushEvents(
        insightsEvents = InsightsEvents(
          events = Seq(
            ConvertedObjectIDsAfterSearch(
              eventType = ConversionEvent.withName("conversion"),
              eventName = "Product Purchased",
              index = "products",
              userToken = "user-123456",
              authenticatedUserToken = Some("user-123456"),
              timestamp = Some(1641290601962L),
              objectIDs = Seq("9780545139700", "9780439784542"),
              queryID = "43b15df305339e827f0ac0bdc5ebcaa7"
            )
          )
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the pushEvents method.
    *
    * ViewedObjectIDs
    */
  def snippetForInsightsClientPushEvents3(): Unit = {
    // >SEPARATOR pushEvents ViewedObjectIDs
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.pushEvents(
        insightsEvents = InsightsEvents(
          events = Seq(
            ViewedObjectIDs(
              eventType = ViewEvent.withName("view"),
              eventName = "Product Detail Page Viewed",
              index = "products",
              userToken = "user-123456",
              authenticatedUserToken = Some("user-123456"),
              timestamp = Some(1641290601962L),
              objectIDs = Seq("9780545139700", "9780439784542")
            )
          )
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the pushEvents method.
    *
    * AddedToCartObjectIDs
    */
  def snippetForInsightsClientPushEvents4(): Unit = {
    // >SEPARATOR pushEvents AddedToCartObjectIDs
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    val response = Await.result(
      client.pushEvents(
        insightsEvents = InsightsEvents(
          events = Seq(
            AddedToCartObjectIDsAfterSearch(
              eventType = ConversionEvent.withName("conversion"),
              eventSubtype = AddToCartEvent.withName("addToCart"),
              eventName = "Product Added To Cart",
              index = "products",
              queryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              userToken = "user-123456",
              authenticatedUserToken = Some("user-123456"),
              timestamp = Some(1641290601962L),
              objectIDs = Seq("9780545139700", "9780439784542"),
              objectData = Some(
                Seq(
                  ObjectDataAfterSearch(
                    price = Some(Price(19.99)),
                    quantity = Some(10),
                    discount = Some(Discount(2.5))
                  ),
                  ObjectDataAfterSearch(
                    price = Some(Price("8$")),
                    quantity = Some(7),
                    discount = Some(Discount("30%"))
                  )
                )
              ),
              currency = Some("USD")
            )
          )
        )
      ),
      Duration(100, "sec")
    )
    // >LOG
    // SEPARATOR<
  }

  /** Snippet for the setClientApiKey method.
    *
    * switch API key
    */
  def snippetForInsightsClientSetClientApiKey(): Unit = {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    val client = InsightsClient(
      appId = "ALGOLIA_APPLICATION_ID",
      apiKey = "ALGOLIA_API_KEY",
      region = Option("ALGOLIA_APPLICATION_REGION")
    )

    // Call the API
    client.setClientApiKey(
      apiKey = "updated-api-key"
    ) // >LOG
    // SEPARATOR<
  }

}

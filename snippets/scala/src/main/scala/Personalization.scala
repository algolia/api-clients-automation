package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.PersonalizationClient
import algoliasearch.personalization.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetPersonalizationClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomDelete(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomGet(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomPost(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomPut(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteUserProfile method.
    *
    * delete deleteUserProfile
    */
  def snippetForPersonalizationClientDeleteUserProfile(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteUserProfile(
      userToken = "UserToken"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getPersonalizationStrategy method.
    *
    * get getPersonalizationStrategy
    */
  def snippetForPersonalizationClientGetPersonalizationStrategy(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getPersonalizationStrategy(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getUserTokenProfile method.
    *
    * get getUserTokenProfile
    */
  def snippetForPersonalizationClientGetUserTokenProfile(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getUserTokenProfile(
      userToken = "UserToken"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the setPersonalizationStrategy method.
    *
    * set setPersonalizationStrategy
    */
  def snippetForPersonalizationClientSetPersonalizationStrategy(): Unit = {
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.setPersonalizationStrategy(
      personalizationStrategyParams = PersonalizationStrategyParams(
        eventScoring = Seq(
          EventScoring(
            score = 42,
            eventName = "Algolia",
            eventType = "Event"
          )
        ),
        facetScoring = Seq(
          FacetScoring(
            score = 42,
            facetName = "Event"
          )
        ),
        personalizationImpact = 42
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

}

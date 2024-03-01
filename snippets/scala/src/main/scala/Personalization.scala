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
    // >SEPARATOR customDelete
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customDelete[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customGet method.
    *
    * allow get method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomGet(): Unit = {
    // >SEPARATOR customGet
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customGet[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPost method.
    *
    * allow post method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomPost(): Unit = {
    // >SEPARATOR customPost
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPost[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the customPut method.
    *
    * allow put method for a custom path with minimal parameters
    */
  def snippetForPersonalizationClientCustomPut(): Unit = {
    // >SEPARATOR customPut
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the deleteUserProfile method.
    *
    * delete deleteUserProfile
    */
  def snippetForPersonalizationClientDeleteUserProfile(): Unit = {
    // >SEPARATOR deleteUserProfile
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.deleteUserProfile(
      userToken = "UserToken"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getPersonalizationStrategy method.
    *
    * get getPersonalizationStrategy
    */
  def snippetForPersonalizationClientGetPersonalizationStrategy(): Unit = {
    // >SEPARATOR getPersonalizationStrategy
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getPersonalizationStrategy(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the getUserTokenProfile method.
    *
    * get getUserTokenProfile
    */
  def snippetForPersonalizationClientGetUserTokenProfile(): Unit = {
    // >SEPARATOR getUserTokenProfile
    // Initialize the client
    val client = PersonalizationClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY", region = "YOUR_APP_ID_REGION")

    // Call the API
    val res = client.getUserTokenProfile(
      userToken = "UserToken"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
    // SEPARATOR<
  }

  /** Snippet for the setPersonalizationStrategy method.
    *
    * set setPersonalizationStrategy
    */
  def snippetForPersonalizationClientSetPersonalizationStrategy(): Unit = {
    // >SEPARATOR setPersonalizationStrategy
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
    // SEPARATOR<
  }

}

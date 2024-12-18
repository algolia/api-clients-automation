/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
  * https://github.com/algolia/api-clients-automation. DO NOT EDIT.
  */
package algoliasearch.api

import algoliasearch.recommend.DeletedAtResponse
import algoliasearch.recommend.ErrorBase
import algoliasearch.recommend.GetRecommendTaskResponse
import algoliasearch.recommend.GetRecommendationsParams
import algoliasearch.recommend.GetRecommendationsResponse
import algoliasearch.recommend.RecommendModels._
import algoliasearch.recommend.RecommendRule
import algoliasearch.recommend.RecommendUpdatedAtResponse
import algoliasearch.recommend.SearchRecommendRulesParams
import algoliasearch.recommend.SearchRecommendRulesResponse
import algoliasearch.recommend._
import algoliasearch.ApiClient
import algoliasearch.api.RecommendClient.hosts
import algoliasearch.api.RecommendClient.readTimeout
import algoliasearch.api.RecommendClient.writeTimeout
import algoliasearch.api.RecommendClient.connectTimeout
import algoliasearch.config._
import algoliasearch.internal.util._

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

object RecommendClient {

  /** Creates a new RecommendClient instance using default hosts.
    *
    * @param appId
    *   application ID
    * @param apiKey
    *   api key
    *
    * @param clientOptions
    *   client options
    */
  def apply(
      appId: String,
      apiKey: String,
      clientOptions: ClientOptions = ClientOptions()
  ) = new RecommendClient(
    appId = appId,
    apiKey = apiKey,
    clientOptions = clientOptions
  )

  private def readTimeout(): Duration = {
    Duration(5, TimeUnit.SECONDS)
  }

  private def connectTimeout(): Duration = {
    Duration(2, TimeUnit.SECONDS)
  }

  private def writeTimeout(): Duration = {
    Duration(30, TimeUnit.SECONDS)
  }

  private def hosts(appId: String): Seq[Host] = {
    val commonHosts = Random.shuffle(
      List(
        Host(appId + "-1.algolianet.com", Set(CallType.Read, CallType.Write)),
        Host(appId + "-2.algolianet.com", Set(CallType.Read, CallType.Write)),
        Host(appId + "-3.algolianet.com", Set(CallType.Read, CallType.Write))
      )
    )
    List(
      Host(appId + "-dsn.algolia.net", Set(CallType.Read)),
      Host(appId + ".algolia.net", Set(CallType.Write))
    ) ++ commonHosts
  }
}

class RecommendClient(
    appId: String,
    apiKey: String,
    clientOptions: ClientOptions = ClientOptions()
) extends ApiClient(
      appId = appId,
      apiKey = apiKey,
      clientName = "Recommend",
      defaultHosts = hosts(appId),
      defaultReadTimeout = readTimeout(),
      defaultWriteTimeout = writeTimeout(),
      defaultConnectTimeout = connectTimeout(),
      formats = JsonSupport.format,
      options = clientOptions
    ) {

  /** Create or update a batch of Recommend Rules Each Recommend Rule is created or updated, depending on whether a
    * Recommend Rule with the same `objectID` already exists. You may also specify `true` for `clearExistingRules`, in
    * which case the batch will atomically replace all the existing Recommend Rules. Recommend Rules are similar to
    * Search Rules, except that the conditions and consequences apply to a [source
    * item](/doc/guides/algolia-recommend/overview/#recommend-models) instead of a query. The main differences are the
    * following: - Conditions `pattern` and `anchoring` are unavailable. - Condition `filters` triggers if the source
    * item matches the specified filters. - Condition `filters` accepts numeric filters. - Consequence `params` only
    * covers filtering parameters. - Consequence `automaticFacetFilters` doesn't require a facet value placeholder (it
    * tries to match the data source item's attributes instead).
    *
    * Required API Key ACLs:
    *   - editSettings
    *
    * @param indexName
    *   Name of the index on which to perform the operation.
    * @param model
    *   [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    */
  def batchRecommendRules(
      indexName: String,
      model: RecommendModels,
      recommendRule: Option[Seq[RecommendRule]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[RecommendUpdatedAtResponse] = Future {
    requireNotNull(indexName, "Parameter `indexName` is required when calling `batchRecommendRules`.")
    requireNotNull(model, "Parameter `model` is required when calling `batchRecommendRules`.")

    val request = HttpRequest
      .builder()
      .withMethod("POST")
      .withPath(s"/1/indexes/${escape(indexName)}/${escape(model)}/recommend/rules/batch")
      .withBody(recommendRule)
      .build()
    execute[RecommendUpdatedAtResponse](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    */
  def customDelete[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customDelete`.")

    val request = HttpRequest
      .builder()
      .withMethod("DELETE")
      .withPath(s"/${path}")
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    */
  def customGet[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customGet`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/${path}")
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    * @param body
    *   Parameters to send with the custom request.
    */
  def customPost[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      body: Option[Any] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customPost`.")

    val request = HttpRequest
      .builder()
      .withMethod("POST")
      .withPath(s"/${path}")
      .withBody(body)
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    * @param body
    *   Parameters to send with the custom request.
    */
  def customPut[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      body: Option[Any] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customPut`.")

    val request = HttpRequest
      .builder()
      .withMethod("PUT")
      .withPath(s"/${path}")
      .withBody(body)
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** Deletes a Recommend rule from a recommendation scenario.
    *
    * Required API Key ACLs:
    *   - editSettings
    *
    * @param indexName
    *   Name of the index on which to perform the operation.
    * @param model
    *   [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    * @param objectID
    *   Unique record identifier.
    */
  def deleteRecommendRule(
      indexName: String,
      model: RecommendModels,
      objectID: String,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[DeletedAtResponse] = Future {
    requireNotNull(indexName, "Parameter `indexName` is required when calling `deleteRecommendRule`.")
    requireNotNull(model, "Parameter `model` is required when calling `deleteRecommendRule`.")
    requireNotNull(objectID, "Parameter `objectID` is required when calling `deleteRecommendRule`.")

    val request = HttpRequest
      .builder()
      .withMethod("DELETE")
      .withPath(s"/1/indexes/${escape(indexName)}/${escape(model)}/recommend/rules/${escape(objectID)}")
      .build()
    execute[DeletedAtResponse](request, requestOptions)
  }

  /** Retrieves a Recommend rule that you previously created in the Algolia dashboard.
    *
    * Required API Key ACLs:
    *   - settings
    *
    * @param indexName
    *   Name of the index on which to perform the operation.
    * @param model
    *   [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    * @param objectID
    *   Unique record identifier.
    */
  def getRecommendRule(
      indexName: String,
      model: RecommendModels,
      objectID: String,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[RecommendRule] = Future {
    requireNotNull(indexName, "Parameter `indexName` is required when calling `getRecommendRule`.")
    requireNotNull(model, "Parameter `model` is required when calling `getRecommendRule`.")
    requireNotNull(objectID, "Parameter `objectID` is required when calling `getRecommendRule`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/1/indexes/${escape(indexName)}/${escape(model)}/recommend/rules/${escape(objectID)}")
      .build()
    execute[RecommendRule](request, requestOptions)
  }

  /** Checks the status of a given task. Deleting a Recommend rule is asynchronous. When you delete a rule, a task is
    * created on a queue and completed depending on the load on the server. The API response includes a task ID that you
    * can use to check the status.
    *
    * Required API Key ACLs:
    *   - editSettings
    *
    * @param indexName
    *   Name of the index on which to perform the operation.
    * @param model
    *   [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    * @param taskID
    *   Unique task identifier.
    */
  def getRecommendStatus(
      indexName: String,
      model: RecommendModels,
      taskID: Long,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetRecommendTaskResponse] = Future {
    requireNotNull(indexName, "Parameter `indexName` is required when calling `getRecommendStatus`.")
    requireNotNull(model, "Parameter `model` is required when calling `getRecommendStatus`.")
    requireNotNull(taskID, "Parameter `taskID` is required when calling `getRecommendStatus`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/1/indexes/${escape(indexName)}/${escape(model)}/task/${escape(taskID)}")
      .build()
    execute[GetRecommendTaskResponse](request, requestOptions)
  }

  /** Retrieves recommendations from selected AI models.
    *
    * Required API Key ACLs:
    *   - search
    */
  def getRecommendations(
      getRecommendationsParams: GetRecommendationsParams,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetRecommendationsResponse] = Future {
    requireNotNull(
      getRecommendationsParams,
      "Parameter `getRecommendationsParams` is required when calling `getRecommendations`."
    )

    val request = HttpRequest
      .builder()
      .withMethod("POST")
      .withPath(s"/1/indexes/*/recommendations")
      .withBody(getRecommendationsParams)
      .withRead(true)
      .build()
    execute[GetRecommendationsResponse](request, requestOptions)
  }

  /** Searches for Recommend rules. Use an empty query to list all rules for this recommendation scenario.
    *
    * Required API Key ACLs:
    *   - settings
    *
    * @param indexName
    *   Name of the index on which to perform the operation.
    * @param model
    *   [Recommend model](https://www.algolia.com/doc/guides/algolia-recommend/overview/#recommend-models).
    */
  def searchRecommendRules(
      indexName: String,
      model: RecommendModels,
      searchRecommendRulesParams: Option[SearchRecommendRulesParams] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[SearchRecommendRulesResponse] = Future {
    requireNotNull(indexName, "Parameter `indexName` is required when calling `searchRecommendRules`.")
    requireNotNull(model, "Parameter `model` is required when calling `searchRecommendRules`.")

    val request = HttpRequest
      .builder()
      .withMethod("POST")
      .withPath(s"/1/indexes/${escape(indexName)}/${escape(model)}/recommend/rules/search")
      .withBody(searchRecommendRulesParams)
      .withRead(true)
      .build()
    execute[SearchRecommendRulesResponse](request, requestOptions)
  }

}

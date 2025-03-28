package com.algolia.client.extensions

import com.algolia.client.api.SearchClient
import com.algolia.client.exception.AlgoliaApiException
import com.algolia.client.extensions.internal.*
import com.algolia.client.extensions.internal.DisjunctiveFaceting
import com.algolia.client.extensions.internal.buildRestrictionString
import com.algolia.client.extensions.internal.encodeKeySHA256
import com.algolia.client.extensions.internal.retryUntil
import com.algolia.client.model.search.*
import com.algolia.client.transport.RequestOptions
import io.ktor.util.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.json.*
import kotlinx.serialization.json.JsonObject
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Wait for an API key to be added, updated or deleted based on a given `operation`.
 *
 * @param key The `key` that has been added, deleted or updated.
 * @param operation The `operation` that was done on a `key`.
 * @param apiKey Necessary to know if an `update` operation has been processed, compare fields of
 *     the response with it.
 * @param maxRetries The maximum number of retries. 50 by default. (optional)
 * @param timeout The function to decide how long to wait between retries. min(retries * 200,
 *     5000) by default. (optional)
 * @param requestOptions The requestOptions to send along with the query, they will be merged with
 *     the transporter requestOptions. (optional)
 */
public suspend fun SearchClient.waitForApiKey(
  key: String,
  operation: ApiKeyOperation,
  apiKey: ApiKey? = null,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): GetApiKeyResponse? = when (operation) {
  ApiKeyOperation.Add -> waitKeyCreation(
    key = key,
    maxRetries = maxRetries,
    timeout = timeout,
    initialDelay = initialDelay,
    maxDelay = maxDelay,
    requestOptions = requestOptions,
  )

  ApiKeyOperation.Delete -> waitKeyDelete(
    key = key,
    maxRetries = maxRetries,
    timeout = timeout,
    initialDelay = initialDelay,
    maxDelay = maxDelay,
    requestOptions = requestOptions,
  )

  ApiKeyOperation.Update -> waitKeyUpdate(
    key = key,
    apiKey = requireNotNull(apiKey) { "apiKey is required for update api key operation" },
    timeout = timeout,
    maxRetries = maxRetries,
    initialDelay = initialDelay,
    maxDelay = maxDelay,
    requestOptions = requestOptions,
  )
}

/**
 * Wait for a [taskID] to complete before executing the next line of code, to synchronize index
 * updates. All write operations in Algolia are asynchronous by design. It means that when you add
 * or update an object to your index, our servers will reply to your request with a [taskID] as soon
 * as they understood the write operation. The actual insert and indexing will be done after
 * replying to your code. You can wait for a task to complete by using the [taskID] and this method.
 *
 * @param indexName The index in which to perform the request.
 * @param taskID The ID of the task to wait for.
 * @param timeout If specified, the method will throw a
 *   [kotlinx.coroutines.TimeoutCancellationException] after the timeout value is elapsed.
 * @param maxRetries maximum number of retry attempts.
 * @param requestOptions additional request configuration.
 */
public suspend fun SearchClient.waitForTask(
  indexName: String,
  taskID: Long,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): GetTaskResponse = retryUntil(
  timeout = timeout,
  maxRetries = maxRetries,
  initialDelay = initialDelay,
  maxDelay = maxDelay,
  retry = { getTask(indexName, taskID, requestOptions) },
  until = { it.status == TaskStatus.Published },
)

@Deprecated(
  "Please use waitForTask instead",
  ReplaceWith("waitForTask(indexName, taskID, maxRetries, timeout, initialDelay, maxDelay, requestOptions)"),
)
public suspend fun SearchClient.waitTask(
  indexName: String,
  taskID: Long,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): TaskStatus = waitForTask(
  indexName = indexName,
  taskID = taskID,
  maxRetries = maxRetries,
  timeout = timeout,
  initialDelay = initialDelay,
  maxDelay = maxDelay,
  requestOptions = requestOptions,
).status

/**
 * Wait for an application-level [taskID] to complete before executing the next line of code.
 *
 * @param taskID The ID of the task to wait for.
 * @param timeout If specified, the method will throw a
 *   [kotlinx.coroutines.TimeoutCancellationException] after the timeout value is elapsed.
 * @param maxRetries maximum number of retry attempts.
 * @param requestOptions additional request configuration.
 */
public suspend fun SearchClient.waitForAppTask(
  taskID: Long,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): GetTaskResponse = retryUntil(
  timeout = timeout,
  maxRetries = maxRetries,
  initialDelay = initialDelay,
  maxDelay = maxDelay,
  retry = { getAppTask(taskID, requestOptions) },
  until = { it.status == TaskStatus.Published },
)

@Deprecated(
  "Please use waitForAppTask instead",
  ReplaceWith("waitForAppTask(taskID, maxRetries, timeout, initialDelay, maxDelay, requestOptions)"),
)
public suspend fun SearchClient.waitAppTask(
  taskID: Long,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): TaskStatus = waitForAppTask(
  taskID = taskID,
  maxRetries = maxRetries,
  timeout = timeout,
  initialDelay = initialDelay,
  maxDelay = maxDelay,
  requestOptions = requestOptions,
).status

/**
 * Wait on an API key update operation.
 *
 * @param key The key that has been updated.
 * @param apiKey Necessary to know if an `update` operation has been processed, compare fields of
 *   the response with it.
 * @param timeout If specified, the method will throw a
 *   [kotlinx.coroutines.TimeoutCancellationException] after the timeout value is elapsed.
 * @param maxRetries Maximum number of retry attempts.
 * @param requestOptions Additional request configuration.
 */
public suspend fun SearchClient.waitKeyUpdate(
  key: String,
  apiKey: ApiKey,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): GetApiKeyResponse = retryUntil(
  timeout = timeout,
  maxRetries = maxRetries,
  initialDelay = initialDelay,
  maxDelay = maxDelay,
  retry = { getApiKey(key, requestOptions) },
  until = {
    apiKey ==
      ApiKey(
        acl = it.acl,
        description = it.description,
        indexes = it.indexes,
        maxHitsPerQuery = it.maxHitsPerQuery,
        maxQueriesPerIPPerHour = it.maxQueriesPerIPPerHour,
        queryParameters = it.queryParameters,
        referers = it.referers,
        validity = it.validity,
      )
  },
)

/**
 * Wait on an API key creation operation.
 *
 * @param timeout If specified, the method will throw a
 *   [kotlinx.coroutines.TimeoutCancellationException] after the timeout value is elapsed.
 * @param maxRetries Maximum number of retry attempts.
 * @param requestOptions Additional request configuration.
 */
public suspend fun SearchClient.waitKeyCreation(
  key: String,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): GetApiKeyResponse = retryUntil(
  timeout = timeout,
  maxRetries = maxRetries,
  initialDelay = initialDelay,
  maxDelay = maxDelay,
  retry = {
    try {
      val response = getApiKey(key, requestOptions)
      Result.success(response)
    } catch (e: AlgoliaApiException) {
      Result.failure(e)
    }
  },
  until = { it.isSuccess },
).getOrThrow()

/**
 * Wait on a delete API ket operation.
 *
 * @param maxRetries Maximum number of retry attempts.
 * @param timeout If specified, the method will throw a
 *   [kotlinx.coroutines.TimeoutCancellationException] after the timeout value is elapsed.
 * @param requestOptions Additional request configuration.
 */
public suspend fun SearchClient.waitKeyDelete(
  key: String,
  maxRetries: Int = 50,
  timeout: Duration = Duration.INFINITE,
  initialDelay: Duration = 200.milliseconds,
  maxDelay: Duration = 5.seconds,
  requestOptions: RequestOptions? = null,
): GetApiKeyResponse? {
  return retryUntil(
    timeout = timeout,
    maxRetries = maxRetries,
    initialDelay = initialDelay,
    maxDelay = maxDelay,
    retry = {
      try {
        return@retryUntil getApiKey(key, requestOptions)
      } catch (e: AlgoliaApiException) {
        if (e.httpErrorCode == 404) {
          return@retryUntil null
        }

        throw e
      }
    },
    until = { result ->
      result == null
    },
  )
}

/**
 * Calls the `search` method but with certainty that we will only request Algolia records (hits).
 */
public suspend fun SearchClient.searchForHits(
  requests: List<SearchForHits>,
  strategy: SearchStrategy? = null,
  requestOptions: RequestOptions? = null,
): List<SearchResponse> {
  val request = SearchMethodParams(requests = requests, strategy = strategy)
  return search(searchMethodParams = request, requestOptions = requestOptions).results.map { it as SearchResponse }
}

/**
 * Calls the `search` method but with certainty that we will only request Algolia facets.
 */
public suspend fun SearchClient.searchForFacets(
  requests: List<SearchForFacets>,
  strategy: SearchStrategy? = null,
  requestOptions: RequestOptions? = null,
): List<SearchForFacetValuesResponse> {
  val request = SearchMethodParams(requests = requests, strategy = strategy)
  return search(
    searchMethodParams = request,
    requestOptions = requestOptions,
  ).results.map { it as SearchForFacetValuesResponse }
}

/**
 * Helper: Chunks the given `objects` list in subset of 1000 elements max to make it fit in `batch` requests.
 *
 * @param indexName The index in which to perform the request.
 * @param objects The list of objects to index.
 * @param action The action to perform on the objects. Default is `Action.AddObject`.
 * @param waitForTasks If true, wait for the task to complete.
 * @param batchSize The size of the batch. Default is 1000.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
 * @return The list of responses from the batch requests.
 *
 */
public suspend fun SearchClient.chunkedBatch(
  indexName: String,
  objects: List<JsonObject>,
  action: Action = Action.AddObject,
  waitForTasks: Boolean,
  batchSize: Int = 1000,
  requestOptions: RequestOptions? = null,
): List<BatchResponse> {
  val tasks = mutableListOf<BatchResponse>()
  objects.chunked(batchSize).forEach { chunk ->
    val requests = chunk.map {
      BatchRequest(
        action = action,
        body = it,
      )
    }
    val batch = batch(
      indexName = indexName,
      batchWriteParams = BatchWriteParams(requests),
      requestOptions = requestOptions,
    )
    tasks.add(batch)
  }
  if (waitForTasks) {
    tasks.forEach { waitForTask(indexName, it.taskID) }
  }
  return tasks
}

/**
 * Helper: Saves the given array of objects in the given index. The `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objects in it.
 *
 * @param indexName The index in which to perform the request.
 * @param objects The list of objects to index.
 * @param waitForTasks If true, wait for the task to complete.
 * @param batchSize The size of the batch. Default is 1000.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
 * @return The list of responses from the batch requests.
 *
 */
public suspend fun SearchClient.saveObjects(
  indexName: String,
  objects: List<JsonObject>,
  waitForTasks: Boolean = false,
  batchSize: Int = 1000,
  requestOptions: RequestOptions? = null,
): List<BatchResponse> = this.chunkedBatch(
  indexName = indexName,
  objects = objects,
  action = Action.AddObject,
  waitForTasks = waitForTasks,
  batchSize = batchSize,
  requestOptions = requestOptions,
)

/**
 * Helper: Deletes every record for the given objectIDs. The `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objectIDs in it.
 *
 * @param indexName The index in which to perform the request.
 * @param objectIDs The list of objectIDs to delete from the index.
 * @param waitForTasks If true, wait for the task to complete.
 * @param batchSize The size of the batch. Default is 1000.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
 * @return The list of responses from the batch requests.
 *
 */
public suspend fun SearchClient.deleteObjects(
  indexName: String,
  objectIDs: List<String>,
  waitForTasks: Boolean = false,
  batchSize: Int = 1000,
  requestOptions: RequestOptions? = null,
): List<BatchResponse> = this.chunkedBatch(
  indexName = indexName,
  objects = objectIDs.map { id -> JsonObject(mapOf("objectID" to Json.encodeToJsonElement(id))) },
  action = Action.DeleteObject,
  waitForTasks = waitForTasks,
  batchSize = batchSize,
  requestOptions = requestOptions,
)

/**
 * Helper: Replaces object content of all the given objects according to their respective `objectID` field. The `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objects in it.
 *
 * @param indexName The index in which to perform the request.
 * @param objects The list of objects to update in the index.
 * @param createIfNotExists To be provided if non-existing objects are passed, otherwise, the call will fail..
 * @param waitForTasks If true, wait for the task to complete.
 * @param batchSize The size of the batch. Default is 1000.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
 * @return The list of responses from the batch requests.
 *
 */
public suspend fun SearchClient.partialUpdateObjects(
  indexName: String,
  objects: List<JsonObject>,
  createIfNotExists: Boolean,
  waitForTasks: Boolean = false,
  batchSize: Int = 1000,
  requestOptions: RequestOptions? = null,
): List<BatchResponse> = this.chunkedBatch(
  indexName = indexName,
  objects = objects,
  action = if (createIfNotExists) Action.PartialUpdateObject else Action.PartialUpdateObjectNoCreate,
  waitForTasks = waitForTasks,
  batchSize = batchSize,
  requestOptions = requestOptions,
)

/**
 * Push a new set of objects and remove all previous ones. Settings, synonyms and query rules are untouched.
 * Replace all objects in an index without any downtime.
 * Internally, this method copies the existing index settings, synonyms and query rules and indexes all
 * passed objects. Finally, the temporary one replaces the existing index.
 *
 * See https://api-clients-automation.netlify.app/docs/add-new-api-client#5-helpers for implementation details.
 *
 * @param indexName The index in which to perform the request.
 * @param objects The list of objects to replace.
 * @param batchSize The size of the batch. Default is 1000.
 * @param scopes The `scopes` to keep from the index. Defaults to ['settings', 'rules', 'synonyms'].
 * @return responses from the three-step operations: copy, batch, move.
 */
public suspend fun SearchClient.replaceAllObjects(
  indexName: String,
  objects: List<JsonObject>,
  batchSize: Int = 1000,
  scopes: List<ScopeType> = listOf(ScopeType.Settings, ScopeType.Rules, ScopeType.Synonyms),
  requestOptions: RequestOptions? = null,
): ReplaceAllObjectsResponse {
  val tmpIndexName = "${indexName}_tmp_${Random.nextInt(from = 0, until = 100)}"

  try {
    var copy = operationIndex(
      indexName = indexName,
      operationIndexParams = OperationIndexParams(
        operation = OperationType.Copy,
        destination = tmpIndexName,
        scope = scopes,
      ),
      requestOptions = requestOptions,
    )

    val batchResponses = this.chunkedBatch(
      indexName = tmpIndexName,
      objects = objects,
      action = Action.AddObject,
      waitForTasks = true,
      batchSize = batchSize,
      requestOptions = requestOptions,
    )

    waitForTask(indexName = tmpIndexName, taskID = copy.taskID)

    copy = operationIndex(
      indexName = indexName,
      operationIndexParams = OperationIndexParams(
        operation = OperationType.Copy,
        destination = tmpIndexName,
        scope = scopes,
      ),
      requestOptions = requestOptions,
    )
    waitForTask(indexName = tmpIndexName, taskID = copy.taskID)

    val move = operationIndex(
      indexName = tmpIndexName,
      operationIndexParams = OperationIndexParams(operation = OperationType.Move, destination = indexName),
      requestOptions = requestOptions,
    )
    waitForTask(indexName = tmpIndexName, taskID = move.taskID)

    return ReplaceAllObjectsResponse(copy, batchResponses, move)
  } catch (e: Exception) {
    deleteIndex(tmpIndexName)

    throw e
  }
}

/**
 * Generate a virtual API Key without any call to the server.
 *
 * @param parentApiKey API key to generate from.
 * @param restrictions Restriction to add the key
 * @throws Exception if an error occurs during the encoding
 */
public fun SearchClient.generateSecuredApiKey(parentApiKey: String, restrictions: SecuredApiKeyRestrictions): String {
  val restrictionString = buildRestrictionString(restrictions)
  val hash = encodeKeySHA256(parentApiKey, restrictionString)
  return "$hash$restrictionString".encodeBase64()
}

/**
 * Gets how many milliseconds are left before the secured API key expires.
 *
 * @param apiKey The secured API Key to check.
 * @return Duration left before the secured API key expires.
 * @throws IllegalArgumentException if [apiKey] doesn't have a [SecuredApiKeyRestrictions.validUntil].
 */
public fun securedApiKeyRemainingValidity(apiKey: String): Duration {
  val decoded = apiKey.decodeBase64String()
  val pattern = Regex("validUntil=(\\d+)")
  val match = requireNotNull(pattern.find(decoded)) { "The Secured API Key doesn't have a validUntil parameter." }
  val validUntil = Instant.fromEpochMilliseconds(match.groupValues[1].toLong())
  return validUntil - Clock.System.now()
}

/**
 * Checks that an index exists.
 *
 * @param indexName The name of the index to check.
 * @return true if the index exists, false otherwise.
 * @throws AlgoliaApiException if an error occurs during the request.
 */
public suspend fun SearchClient.indexExists(indexName: String): Boolean {
  try {
    getSettings(indexName)
  } catch (e: AlgoliaApiException) {
    if (e.httpErrorCode == 404) {
      return false
    }
    throw e
  }

  return true
}

public data class SearchDisjunctiveFacetingResponse(
  val response: SearchResponse,
  val disjunctiveFacets: Map<String, Map<String, Int>>,
)

/**
 * Method used for perform search with disjunctive facets.
 *
 * @param indexName The name of the index in which the search queries should be performed
 * @param searchParamsObject The search query params.
 * @param refinements Refinements to apply to the search in form of dictionary with
 *  facet attribute as a key and a list of facet values for the designated attribute.
 *  Any facet in this list not present in the `disjunctiveFacets` set will be filtered conjunctively (with AND operator).
 * @param disjunctiveFacets Set of facets attributes applied disjunctively (with OR operator)
 * @param requestOptions Configure request locally with RequestOptions.
 * @return SearchDisjunctiveFacetingResponse - a struct containing the merge response from all the
 * disjunctive faceting search queries, and a list of disjunctive facets
 * @throws NoSuchElementException if there are no search response from the multi-query search
 */
public suspend fun SearchClient.searchDisjunctiveFaceting(
  indexName: String,
  searchParamsObject: SearchParamsObject,
  refinements: Map<String, List<String>>,
  disjunctiveFacets: Set<String>,
  requestOptions: RequestOptions? = null
): SearchDisjunctiveFacetingResponse {
  val helper = DisjunctiveFaceting(
    query = SearchForHits.from(searchParamsObject, indexName),
    refinements = refinements,
    disjunctiveFacets = disjunctiveFacets,
  )
  val queries = helper.buildQueries()
  val responses = searchForHits(queries, requestOptions = requestOptions)
  return helper.mergeResponses(responses)
}

/**
 * Helper: Returns an iterator on top of the `browse` method.
 *
 * @param indexName The index in which to perform the request.
 * @param params The `browse` parameters.
 * @param validate The function to validate the response. Default is to check if the cursor is not null.
 * @param aggregator The function to aggregate the response.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with
 *     the transporter requestOptions. (optional)
 */
public suspend fun SearchClient.browseObjects(
  indexName: String,
  params: BrowseParamsObject,
  validate: (BrowseResponse) -> Boolean = { response -> response.cursor == null },
  aggregator: ((BrowseResponse) -> Unit),
  requestOptions: RequestOptions? = null,
): BrowseResponse = createIterable(
  execute = { previousResponse ->
    browse(
      indexName,
      params.copy(hitsPerPage = params.hitsPerPage ?: 1000, cursor = previousResponse?.cursor),
      requestOptions,
    )
  },
  validate = validate,
  aggregator = aggregator,
)

/**
 * Helper: Returns an iterator on top of the `browse` method.
 *
 * @param indexName The index in which to perform the request.
 * @param searchRulesParams The search rules request parameters
 * @param validate The function to validate the response. Default is to check if the cursor is not null.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with
 *     the transporter requestOptions. (optional)
 */
public suspend fun SearchClient.browseRules(
  indexName: String,
  searchRulesParams: SearchRulesParams,
  validate: ((SearchRulesResponse) -> Boolean)? = null,
  aggregator: (SearchRulesResponse) -> Unit,
  requestOptions: RequestOptions? = null,
): SearchRulesResponse {
  val hitsPerPage = searchRulesParams.hitsPerPage ?: 1000

  return createIterable(
    execute = { previousResponse ->
      searchRules(
        indexName,
        searchRulesParams.copy(
          page = if (previousResponse != null) (previousResponse.page + 1) else 0,
          hitsPerPage = hitsPerPage,
        ),
        requestOptions,
      )
    },
    validate = validate ?: { response -> response.hits.count() < hitsPerPage },
    aggregator = aggregator,
  )
}

/**
 * Helper: Returns an iterator on top of the `browse` method.
 *
 * @param indexName The index in which to perform the request.
 * @param searchSynonymsParams The search synonyms request parameters
 * @param validate The function to validate the response. Default is to check if the cursor is not null.
 * @param requestOptions The requestOptions to send along with the query, they will be merged with
 *     the transporter requestOptions. (optional)
 */
public suspend fun SearchClient.browseSynonyms(
  indexName: String,
  searchSynonymsParams: SearchSynonymsParams,
  validate: ((SearchSynonymsResponse) -> Boolean)? = null,
  aggregator: (SearchSynonymsResponse) -> Unit,
  requestOptions: RequestOptions? = null,
): SearchSynonymsResponse {
  val hitsPerPage = 1000
  var page = searchSynonymsParams.page ?: 0

  return createIterable(
    execute = { _ ->
      try {
        searchSynonyms(
          indexName,
          searchSynonymsParams = searchSynonymsParams.copy(
            page = page,
            hitsPerPage = hitsPerPage,
          ),
          requestOptions,
        )
      } finally {
        page += 1
      }
    },
    validate = validate ?: { response -> response.hits.count() < hitsPerPage },
    aggregator = aggregator,
  )
}

package algoliasearch

import algoliasearch.api.SearchClient
import algoliasearch.config.RequestOptions
import algoliasearch.exception.AlgoliaApiException
import algoliasearch.extension.internal.Iterable.createIterable
import algoliasearch.extension.internal.RetryUntil.{DEFAULT_DELAY, retryUntil}
import algoliasearch.search._

import scala.concurrent.{ExecutionContext, Future}

package object extension {

  implicit class SearchClientExtensions(val client: SearchClient) {

    /** Wait for an API key to be added, updated or deleted based on a given `operation`.
      *
      * @param operation
      *   The operation that was done on a key.
      * @param key
      *   The key that has been added, deleted or updated.
      * @param apiKey
      *   Required for `update` operation, to compare the response with the given key.
      * @param maxRetries
      *   The maximum number of retries. 50 by default. (optional)
      * @param requestOptions
      *   Additional request configuration.
      */
    def waitForApiKey(
        operation: ApiKeyOperation,
        key: String,
        apiKey: Option[ApiKey] = None,
        maxRetries: Int = 50,
        delay: Long => Long = DEFAULT_DELAY,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[Any] = {
      operation match {
        case ApiKeyOperation.Add =>
          client.waitKeyCreation(key, maxRetries, delay, requestOptions)
        case ApiKeyOperation.Update =>
          client.waitKeyUpdate(key, apiKey.get, maxRetries, delay, requestOptions)
        case ApiKeyOperation.Delete =>
          client.waitKeyDelete(key, maxRetries, delay, requestOptions)
      }
    }

    /** Wait for a taskID to complete before executing the next line of code, to synchronize index updates. All write
      * operations in Algolia are asynchronous by design. It means that when you add or update an object to your index,
      * our servers will reply to your request with a taskID as soon as they understood the write operation. The actual
      * insert and indexing will be done after replying to your code. You can wait for a task to complete by using the
      * [taskID] and this method.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param taskID
      *   The ID of the task to wait for.
      * @param maxRetries
      *   maximum number of retry attempts.
      * @param requestOptions
      *   additional request configuration.
      */
    def waitTask(
        indexName: String,
        taskID: Long,
        delay: Long => Long = DEFAULT_DELAY,
        maxRetries: Int = 50,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[TaskStatus] = {
      retryUntil(
        retry = () => client.getTask(indexName, taskID, requestOptions).map(_.status),
        until = (status: TaskStatus) => status == TaskStatus.Published,
        maxRetries = maxRetries,
        delay = delay
      )
    }

    /** Wait for an application-level taskID to complete before executing the next line of code.
      *
      * @param taskID
      *   The ID of the task to wait for.
      * @param maxRetries
      *   maximum number of retry attempts.
      * @param requestOptions
      *   additional request configuration.
      */
    def waitAppTask(
        taskID: Long,
        delay: Long => Long = DEFAULT_DELAY,
        maxRetries: Int = 50,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[TaskStatus] = {
      retryUntil(
        retry = () => client.getAppTask(taskID, requestOptions).map(_.status),
        until = (status: TaskStatus) => status == TaskStatus.Published,
        maxRetries = maxRetries,
        delay = delay
      )
    }

    /** Wait on an API key update operation.
      *
      * @param key
      *   The key that has been updated.
      * @param apiKey
      *   Necessary to know if an `update` operation has been processed, compare fields of the response with it.
      * @param maxRetries
      *   Maximum number of retry attempts.
      * @param requestOptions
      *   Additional request configuration.
      */
    def waitKeyUpdate(
        key: String,
        apiKey: ApiKey,
        maxRetries: Int = 50,
        delay: Long => Long = DEFAULT_DELAY,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[GetApiKeyResponse] = {
      retryUntil(
        retry = () => client.getApiKey(key, requestOptions),
        until = (res: GetApiKeyResponse) =>
          apiKey == ApiKey(
            acl = res.acl,
            description = res.description,
            indexes = res.indexes,
            maxHitsPerQuery = res.maxHitsPerQuery,
            maxQueriesPerIPPerHour = res.maxQueriesPerIPPerHour,
            queryParameters = res.queryParameters,
            referers = res.referers
          ),
        maxRetries = maxRetries,
        delay = delay
      )
    }

    /** Wait on an API key creation operation.
      *
      * @param key
      *   The key that has been created.
      * @param maxRetries
      *   Maximum number of retry attempts.
      * @param requestOptions
      *   Additional request configuration.
      */
    def waitKeyCreation(
        key: String,
        maxRetries: Int = 50,
        delay: Long => Long = DEFAULT_DELAY,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[GetApiKeyResponse] = {
      retryUntil(
        retry = () =>
          client
            .getApiKey(key, requestOptions)
            .map(Some(_))
            .recover { case _ => None },
        until = (res: Option[GetApiKeyResponse]) => res.isDefined,
        maxRetries = maxRetries,
        delay = delay
      ).map(_.get)
    }

    /** Wait on a delete API ket operation
      *
      * @param key
      *   The key that has been deleted.
      * @param maxRetries
      *   Maximum number of retry attempts.
      * @param requestOptions
      *   Additional request configuration.
      */
    def waitKeyDelete(
        key: String,
        maxRetries: Int = 50,
        delay: Long => Long = DEFAULT_DELAY,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[Boolean] = {
      retryUntil(
        retry = () =>
          client
            .getApiKey(key, requestOptions)
            .map(_ => None) // The key still exists, return None
            .recover {
              case e: AlgoliaApiException if e.httpErrorCode == 404 => Some(true) // The key does not exist, done!
              case _                                                => None // Any other error, still return None
            },
        until = (result: Option[Boolean]) =>
          result match {
            case Some(true) => true // Stop retrying when we get Some(true), indicating the key is deleted
            case _          => false // Continue retrying otherwise
          },
        maxRetries = maxRetries,
        delay = delay
      )
      Future.successful(true)
    }

    /** Helper: Chunks the given `objects` list in subset of 1000 elements max to make it fit in `batch` requests.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param objects
      *   The list of objects to save.
      * @param action
      *   The action to perform on the objects.
      * @param waitForTasks
      *   Whether to wait for the tasks to complete.
      * @param batchSize
      *   The size of the batch. Default is 1000.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the response of the batch operations.
      */
    def chunkedBatch(
        indexName: String,
        objects: Seq[Any],
        action: Action = Action.AddObject,
        waitForTasks: Boolean,
        batchSize: Int = 1000,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[Seq[BatchResponse]] = {
      var futures = Seq.empty[Future[BatchResponse]]
      objects.grouped(batchSize).foreach { chunk =>
        val requests = chunk.map { record =>
          BatchRequest(action = action, body = record)
        }
        val future = client.batch(
          indexName = indexName,
          batchWriteParams = BatchWriteParams(requests),
          requestOptions = requestOptions
        )
        futures = futures :+ future
      }

      val responses = Future.sequence(futures)

      if (waitForTasks) {
        responses.foreach { tasks =>
          tasks.foreach { task =>
            client.waitTask(indexName, task.taskID, requestOptions = requestOptions)
          }
        }
      }

      responses
    }

    /** Helper: Saves the given array of objects in the given index. The `chunkedBatch` helper is used under the hood,
      * which creates a `batch` requests with at most 1000 objects in it.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param objects
      *   The list of objects to save.
      * @param waitForTasks
      *   Whether to wait for the tasks to complete.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the response of the batch operations.
      */
    def saveObjects(
        indexName: String,
        objects: Seq[Any],
        waitForTasks: Boolean = false,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[Seq[BatchResponse]] = {
      chunkedBatch(indexName, objects, Action.AddObject, waitForTasks, 1000, requestOptions)
    }

    /** Helper: Deletes every objects for the given objectIDs. The `chunkedBatch` helper is used under the hood, which
      * creates a `batch` requests with at most 1000 objectIDs in it.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param objectIDs
      *   The list of objectIDs to delete.
      * @param waitForTasks
      *   Whether to wait for the tasks to complete.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the response of the batch operations.
      */
    def deleteObjects(
        indexName: String,
        objectIDs: Seq[String],
        waitForTasks: Boolean = false,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[Seq[BatchResponse]] = {
      chunkedBatch(
        indexName,
        objectIDs.map(id => new { val objectID: String = id }),
        Action.DeleteObject,
        waitForTasks,
        1000,
        requestOptions
      )
    }

    /** Helper: Replaces object content of all the given objects according to their respective `objectID` field. The
      * `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objects in it.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param objects
      *   The list of objects to save.
      * @param createIfNotExists
      *   To be provided if non-existing objects are passed, otherwise, the call will fail.
      * @param waitForTasks
      *   Whether to wait for the tasks to complete.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the response of the batch operations.
      */
    def partialUpdateObjects(
        indexName: String,
        objects: Seq[Any],
        createIfNotExists: Boolean = false,
        waitForTasks: Boolean = false,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[Seq[BatchResponse]] = {
      chunkedBatch(
        indexName,
        objects,
        if (createIfNotExists) Action.PartialUpdateObject else Action.PartialUpdateObjectNoCreate,
        waitForTasks,
        1000,
        requestOptions
      )
    }

    /** Push a new set of objects and remove all previous ones. Settings, synonyms and query rules are untouched.
      * Replace all objects in an index without any downtime. Internally, this method copies the existing index
      * settings, synonyms and query rules and indexes all passed objects. Finally, the temporary one replaces the
      * existing index.
      *
      * See https://api-clients-automation.netlify.app/docs/add-new-api-client#5-helpers for implementation details.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param objects
      *   The list of objects to replace.
      * @param batchSize
      *   The size of the batch. Default is 1000.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the response of the three-step operations: copy, batch and move.
      */
    def replaceAllObjects(
        indexName: String,
        objects: Seq[Any],
        batchSize: Int = 1000,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[ReplaceAllObjectsResponse] = {
      val tmpIndexName = s"${indexName}_tmp_${scala.util.Random.nextInt(100)}"

      for {
        copy <- client.operationIndex(
          indexName = indexName,
          operationIndexParams = OperationIndexParams(
            operation = OperationType.Copy,
            destination = tmpIndexName,
            scope = Some(Seq(ScopeType.Settings, ScopeType.Rules, ScopeType.Synonyms))
          ),
          requestOptions = requestOptions
        )

        batchResponses <- chunkedBatch(
          indexName = tmpIndexName,
          objects = objects,
          action = Action.AddObject,
          waitForTasks = true,
          batchSize = batchSize,
          requestOptions = requestOptions
        )

        _ <- client.waitTask(indexName = tmpIndexName, taskID = copy.taskID, requestOptions = requestOptions)

        copy <- client.operationIndex(
          indexName = indexName,
          operationIndexParams = OperationIndexParams(
            operation = OperationType.Copy,
            destination = tmpIndexName,
            scope = Some(Seq(ScopeType.Settings, ScopeType.Rules, ScopeType.Synonyms))
          ),
          requestOptions = requestOptions
        )
        _ <- client.waitTask(indexName = tmpIndexName, taskID = copy.taskID, requestOptions = requestOptions)

        move <- client.operationIndex(
          indexName = tmpIndexName,
          operationIndexParams = OperationIndexParams(operation = OperationType.Move, destination = indexName),
          requestOptions = requestOptions
        )
        _ <- client.waitTask(indexName = tmpIndexName, taskID = move.taskID, requestOptions = requestOptions)
      } yield ReplaceAllObjectsResponse(
        copyOperationResponse = copy,
        batchResponses = batchResponses,
        moveOperationResponse = move
      )
    }

    /** Check if an index exists.
      * @param indexName
      *   The index name to check.
      * @return
      *   A future containing a boolean indicating if the index exists.
      */
    def indexExists(indexName: String)(implicit ec: ExecutionContext): Future[Boolean] = {
      try {
        client.getSettings(indexName)
      } catch {
        case apiError: AlgoliaApiException if apiError.httpErrorCode == 404 => Future.successful(false)
        case e: Throwable                                                   => throw e
      }

      Future.successful(true)
    }

    /** Browse objects in an index.
      * @param indexName
      *   The index name to browse.
      * @param browseParams
      *   The browse parameters.
      * @param validate
      *   The validation function. Default is to check if the cursor is defined.
      * @param aggregator
      *   The aggregation function. This is where you can aggregate the results.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the last browse response.
      */
    def browseObjects(
        indexName: String,
        browseParams: BrowseParamsObject,
        validate: BrowseResponse => Boolean = response => response.cursor.isEmpty,
        aggregator: BrowseResponse => Unit,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[BrowseResponse] = {
      createIterable(
        execute = (previousResponse: Option[BrowseResponse]) =>
          client.browse(
            indexName,
            Some(
              browseParams.copy(
                hitsPerPage = previousResponse.flatMap(_.hitsPerPage.orElse(Some(1000))),
                cursor = previousResponse.flatMap(_.cursor)
              )
            ),
            requestOptions
          ),
        validate = validate,
        aggregator = Some(aggregator)
      )
    }

    /** Browse rules in an index.
      * @param indexName
      *   The index name to browse.
      * @param searchRulesParams
      *   The search rules parameters.
      * @param validate
      *   The validation function. Default is to check if the number of hits is less than the hits per page.
      * @param aggregator
      *   The aggregation function. This is where you can aggregate the results.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the last search rules response.
      */
    def browseRules(
        indexName: String,
        searchRulesParams: SearchRulesParams,
        validate: Option[SearchRulesResponse => Boolean] = None,
        aggregator: SearchRulesResponse => Unit,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[SearchRulesResponse] = {
      val hitsPerPage = 1000

      createIterable(
        execute = (previousResponse: Option[SearchRulesResponse]) =>
          client.searchRules(
            indexName,
            Some(
              searchRulesParams.copy(
                page = previousResponse.map(_.page + 1).orElse(Some(0)),
                hitsPerPage = Some(hitsPerPage)
              )
            ),
            requestOptions
          ),
        validate = validate.getOrElse((response: SearchRulesResponse) => response.hits.length < hitsPerPage),
        aggregator = Some(aggregator)
      )
    }

    /** Browse synonyms in an index.
      * @param indexName
      *   The index name to browse.
      * @param searchSynonymsParams
      *   The search synonyms parameters.
      * @param validate
      *   The validation function. Default is to check if the number of hits is less than the hits per page.
      * @param aggregator
      *   The aggregation function. This is where you can aggregate the results.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the last search synonyms response.
      */
    def browseSynonyms(
        indexName: String,
        searchSynonymsParams: SearchSynonymsParams,
        validate: Option[SearchSynonymsResponse => Boolean] = None,
        aggregator: SearchSynonymsResponse => Unit,
        requestOptions: Option[RequestOptions] = None
    )(implicit ec: ExecutionContext): Future[SearchSynonymsResponse] = {
      val hitsPerPage = 1000
      var page = searchSynonymsParams.page.getOrElse(0)

      createIterable(
        execute = (_: Option[SearchSynonymsResponse]) =>
          try {
            client.searchSynonyms(
              indexName,
              Some(
                searchSynonymsParams.copy(
                  page = Some(page),
                  hitsPerPage = Some(hitsPerPage)
                )
              ),
              requestOptions
            )
          } finally {
            page += 1
          },
        validate = validate.getOrElse((response: SearchSynonymsResponse) => response.hits.length < hitsPerPage),
        aggregator = Some(aggregator)
      )
    }
  }
}

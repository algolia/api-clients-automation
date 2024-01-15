package algoliasearch.methods.snippets

import scala.concurrent.duration.Duration

import algoliasearch.api.SearchClient
import algoliasearch.search.*

import org.json4s.*
import org.json4s.native.JsonParser.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class SnippetSearchClient {
  implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
  implicit val formats: Formats = org.json4s.DefaultFormats

  /** Snippet for the addApiKey method.
    *
    * addApiKey0
    */
  def snippetForSearchClientAddApiKey(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.addApiKey(
      apiKey = ApiKey(
        acl = Seq(Acl.withName("search"), Acl.withName("addObject")),
        description = Some("my new api key"),
        validity = Some(300),
        maxQueriesPerIPPerHour = Some(100),
        maxHitsPerQuery = Some(20)
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the addOrUpdateObject method.
    *
    * addOrUpdateObject0
    */
  def snippetForSearchClientAddOrUpdateObject(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.addOrUpdateObject(
      indexName = "indexName",
      objectID = "uniqueID",
      body = JObject(List(JField("key", JString("value"))))
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the appendSource method.
    *
    * appendSource0
    */
  def snippetForSearchClientAppendSource(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.appendSource(
      source = Source(
        source = "theSource",
        description = Some("theDescription")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the assignUserId method.
    *
    * assignUserId0
    */
  def snippetForSearchClientAssignUserId(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.assignUserId(
      xAlgoliaUserID = "userID",
      assignUserIdParams = AssignUserIdParams(
        cluster = "theCluster"
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the batch method.
    *
    * allows batch method with `addObject` action
    */
  def snippetForSearchClientBatch(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.batch(
      indexName = "theIndexName",
      batchWriteParams = BatchWriteParams(
        requests = Seq(
          BatchRequest(
            action = Action.withName("addObject"),
            body = JObject(List(JField("key", JString("value"))))
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the batchAssignUserIds method.
    *
    * batchAssignUserIds0
    */
  def snippetForSearchClientBatchAssignUserIds(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.batchAssignUserIds(
      xAlgoliaUserID = "userID",
      batchAssignUserIdsParams = BatchAssignUserIdsParams(
        cluster = "theCluster",
        users = Seq("user1", "user2")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the batchDictionaryEntries method.
    *
    * get batchDictionaryEntries results with minimal parameters
    */
  def snippetForSearchClientBatchDictionaryEntries(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.batchDictionaryEntries(
      dictionaryName = DictionaryType.withName("compounds"),
      batchDictionaryEntriesParams = BatchDictionaryEntriesParams(
        requests = Seq(
          BatchDictionaryEntriesRequest(
            action = DictionaryAction.withName("addEntry"),
            body = DictionaryEntry(
              objectID = "1",
              language = "en"
            )
          ),
          BatchDictionaryEntriesRequest(
            action = DictionaryAction.withName("deleteEntry"),
            body = DictionaryEntry(
              objectID = "2",
              language = "fr"
            )
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the browse method.
    *
    * browse with minimal parameters
    */
  def snippetForSearchClientBrowse(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.browse(
      indexName = "cts_e2e_browse"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the clearAllSynonyms method.
    *
    * clearAllSynonyms0
    */
  def snippetForSearchClientClearAllSynonyms(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.clearAllSynonyms(
      indexName = "indexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the clearObjects method.
    *
    * clearObjects0
    */
  def snippetForSearchClientClearObjects(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.clearObjects(
      indexName = "theIndexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the clearRules method.
    *
    * clearRules0
    */
  def snippetForSearchClientClearRules(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.clearRules(
      indexName = "indexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the customDelete method.
    *
    * allow del method for a custom path with minimal parameters
    */
  def snippetForSearchClientCustomDelete(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
  def snippetForSearchClientCustomGet(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
  def snippetForSearchClientCustomPost(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

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
  def snippetForSearchClientCustomPut(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.customPut[JObject](
      path = "/test/minimal"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteApiKey method.
    *
    * deleteApiKey0
    */
  def snippetForSearchClientDeleteApiKey(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteApiKey(
      key = "myTestApiKey"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteBy method.
    *
    * deleteBy0
    */
  def snippetForSearchClientDeleteBy(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteBy(
      indexName = "theIndexName",
      deleteByParams = DeleteByParams(
        filters = Some("brand:brandName")
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteIndex method.
    *
    * deleteIndex0
    */
  def snippetForSearchClientDeleteIndex(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteIndex(
      indexName = "theIndexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteObject method.
    *
    * deleteObject0
    */
  def snippetForSearchClientDeleteObject(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteObject(
      indexName = "theIndexName",
      objectID = "uniqueID"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteRule method.
    *
    * delete rule simple case
    */
  def snippetForSearchClientDeleteRule(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteRule(
      indexName = "indexName",
      objectID = "id1"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteSource method.
    *
    * deleteSource0
    */
  def snippetForSearchClientDeleteSource(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteSource(
      source = "theSource"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the deleteSynonym method.
    *
    * deleteSynonym0
    */
  def snippetForSearchClientDeleteSynonym(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.deleteSynonym(
      indexName = "indexName",
      objectID = "id1"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getApiKey method.
    *
    * getApiKey0
    */
  def snippetForSearchClientGetApiKey(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getApiKey(
      key = "myTestApiKey"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getDictionaryLanguages method.
    *
    * get getDictionaryLanguages
    */
  def snippetForSearchClientGetDictionaryLanguages(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getDictionaryLanguages(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getDictionarySettings method.
    *
    * get getDictionarySettings results
    */
  def snippetForSearchClientGetDictionarySettings(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getDictionarySettings(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getLogs method.
    *
    * getLogs with minimal parameters
    */
  def snippetForSearchClientGetLogs(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getLogs(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getObject method.
    *
    * getObject0
    */
  def snippetForSearchClientGetObject(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getObject(
      indexName = "theIndexName",
      objectID = "uniqueID",
      attributesToRetrieve = Some(Seq("attr1", "attr2"))
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getObjects method.
    *
    * getObjects0
    */
  def snippetForSearchClientGetObjects(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getObjects(
      getObjectsParams = GetObjectsParams(
        requests = Seq(
          GetObjectsRequest(
            attributesToRetrieve = Some(Seq("attr1", "attr2")),
            objectID = "uniqueID",
            indexName = "theIndexName"
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getRule method.
    *
    * getRule0
    */
  def snippetForSearchClientGetRule(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getRule(
      indexName = "indexName",
      objectID = "id1"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSettings method.
    *
    * getSettings0
    */
  def snippetForSearchClientGetSettings(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getSettings(
      indexName = "cts_e2e_settings"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSources method.
    *
    * getSources0
    */
  def snippetForSearchClientGetSources(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getSources(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getSynonym method.
    *
    * getSynonym0
    */
  def snippetForSearchClientGetSynonym(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getSynonym(
      indexName = "indexName",
      objectID = "id1"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTask method.
    *
    * getTask0
    */
  def snippetForSearchClientGetTask(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getTask(
      indexName = "theIndexName",
      taskID = 123L
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getTopUserIds method.
    *
    * getTopUserIds0
    */
  def snippetForSearchClientGetTopUserIds(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getTopUserIds(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the getUserId method.
    *
    * getUserId0
    */
  def snippetForSearchClientGetUserId(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.getUserId(
      userID = "uniqueID"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the hasPendingMappings method.
    *
    * hasPendingMappings with minimal parameters
    */
  def snippetForSearchClientHasPendingMappings(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.hasPendingMappings(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the listApiKeys method.
    *
    * listApiKeys0
    */
  def snippetForSearchClientListApiKeys(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.listApiKeys(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the listClusters method.
    *
    * listClusters0
    */
  def snippetForSearchClientListClusters(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.listClusters(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the listIndices method.
    *
    * listIndices with minimal parameters
    */
  def snippetForSearchClientListIndices(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.listIndices(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the listUserIds method.
    *
    * listUserIds with minimal parameters
    */
  def snippetForSearchClientListUserIds(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.listUserIds(
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the multipleBatch method.
    *
    * multipleBatch0
    */
  def snippetForSearchClientMultipleBatch(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.multipleBatch(
      batchParams = BatchParams(
        requests = Seq(
          MultipleBatchRequest(
            action = Action.withName("addObject"),
            body = JObject(List(JField("key", JString("value")))),
            indexName = "theIndexName"
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the operationIndex method.
    *
    * operationIndex0
    */
  def snippetForSearchClientOperationIndex(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.operationIndex(
      indexName = "theIndexName",
      operationIndexParams = OperationIndexParams(
        operation = OperationType.withName("copy"),
        destination = "dest",
        scope = Some(Seq(ScopeType.withName("rules"), ScopeType.withName("settings")))
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the partialUpdateObject method.
    *
    * partialUpdateObject0
    */
  def snippetForSearchClientPartialUpdateObject(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.partialUpdateObject(
      indexName = "theIndexName",
      objectID = "uniqueID",
      attributesToUpdate = Map(
        "id1" -> AttributeToUpdate("test"),
        "id2" -> BuiltInOperation(
          _operation = BuiltInOperationType.withName("AddUnique"),
          value = "test2"
        )
      ),
      createIfNotExists = Some(true)
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the removeUserId method.
    *
    * removeUserId0
    */
  def snippetForSearchClientRemoveUserId(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.removeUserId(
      userID = "uniqueID"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the replaceSources method.
    *
    * replaceSources0
    */
  def snippetForSearchClientReplaceSources(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.replaceSources(
      source = Seq(
        Source(
          source = "theSource",
          description = Some("theDescription")
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the restoreApiKey method.
    *
    * restoreApiKey0
    */
  def snippetForSearchClientRestoreApiKey(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.restoreApiKey(
      key = "myApiKey"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the saveObject method.
    *
    * saveObject0
    */
  def snippetForSearchClientSaveObject(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.saveObject(
      indexName = "theIndexName",
      body = JObject(List(JField("objectID", JString("id")), JField("test", JString("val"))))
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the saveRule method.
    *
    * saveRule with minimal parameters
    */
  def snippetForSearchClientSaveRule(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.saveRule(
      indexName = "indexName",
      objectID = "id1",
      rule = Rule(
        objectID = "id1",
        conditions = Some(
          Seq(
            Condition(
              pattern = Some("apple"),
              anchoring = Some(Anchoring.withName("contains"))
            )
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the saveRules method.
    *
    * saveRules with minimal parameters
    */
  def snippetForSearchClientSaveRules(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.saveRules(
      indexName = "indexName",
      rules = Seq(
        Rule(
          objectID = "a-rule-id",
          conditions = Some(
            Seq(
              Condition(
                pattern = Some("smartphone"),
                anchoring = Some(Anchoring.withName("contains"))
              )
            )
          )
        ),
        Rule(
          objectID = "a-second-rule-id",
          conditions = Some(
            Seq(
              Condition(
                pattern = Some("apple"),
                anchoring = Some(Anchoring.withName("contains"))
              )
            )
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the saveSynonym method.
    *
    * saveSynonym0
    */
  def snippetForSearchClientSaveSynonym(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.saveSynonym(
      indexName = "indexName",
      objectID = "id1",
      synonymHit = SynonymHit(
        objectID = "id1",
        `type` = SynonymType.withName("synonym"),
        synonyms = Some(Seq("car", "vehicule", "auto"))
      ),
      forwardToReplicas = Some(true)
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the saveSynonyms method.
    *
    * saveSynonyms0
    */
  def snippetForSearchClientSaveSynonyms(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.saveSynonyms(
      indexName = "indexName",
      synonymHit = Seq(
        SynonymHit(
          objectID = "id1",
          `type` = SynonymType.withName("synonym"),
          synonyms = Some(Seq("car", "vehicule", "auto"))
        ),
        SynonymHit(
          objectID = "id2",
          `type` = SynonymType.withName("onewaysynonym"),
          input = Some("iphone"),
          synonyms = Some(Seq("ephone", "aphone", "yphone"))
        )
      ),
      forwardToReplicas = Some(true),
      replaceExistingSynonyms = Some(false)
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the search method.
    *
    * search for a single hits request with minimal parameters
    */
  def snippetForSearchClientSearch(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.search(
      searchMethodParams = SearchMethodParams(
        requests = Seq(
          SearchForHits(
            indexName = "cts_e2e_search_empty_index"
          )
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchDictionaryEntries method.
    *
    * get searchDictionaryEntries results with minimal parameters
    */
  def snippetForSearchClientSearchDictionaryEntries(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchDictionaryEntries(
      dictionaryName = DictionaryType.withName("compounds"),
      searchDictionaryEntriesParams = SearchDictionaryEntriesParams(
        query = "foo"
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchForFacetValues method.
    *
    * get searchForFacetValues results with minimal parameters
    */
  def snippetForSearchClientSearchForFacetValues(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchForFacetValues(
      indexName = "indexName",
      facetName = "facetName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchRules method.
    *
    * searchRules0
    */
  def snippetForSearchClientSearchRules(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchRules(
      indexName = "indexName",
      searchRulesParams = Some(
        SearchRulesParams(
          query = Some("something")
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchSingleIndex method.
    *
    * search with minimal parameters
    */
  def snippetForSearchClientSearchSingleIndex(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchSingleIndex(
      indexName = "indexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchSynonyms method.
    *
    * searchSynonyms with minimal parameters
    */
  def snippetForSearchClientSearchSynonyms(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchSynonyms(
      indexName = "indexName"
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the searchUserIds method.
    *
    * searchUserIds0
    */
  def snippetForSearchClientSearchUserIds(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.searchUserIds(
      searchUserIdsParams = SearchUserIdsParams(
        query = "test",
        clusterName = Some("theClusterName"),
        page = Some(5),
        hitsPerPage = Some(10)
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the setDictionarySettings method.
    *
    * get setDictionarySettings results with minimal parameters
    */
  def snippetForSearchClientSetDictionarySettings(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.setDictionarySettings(
      dictionarySettingsParams = DictionarySettingsParams(
        disableStandardEntries = StandardEntries(
          plurals = Some(Map("fr" -> false, "en" -> false, "ru" -> true))
        )
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the setSettings method.
    *
    * setSettings with minimal parameters
    */
  def snippetForSearchClientSetSettings(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.setSettings(
      indexName = "cts_e2e_settings",
      indexSettings = IndexSettings(
        paginationLimitedTo = Some(10)
      ),
      forwardToReplicas = Some(true)
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

  /** Snippet for the updateApiKey method.
    *
    * updateApiKey0
    */
  def snippetForSearchClientUpdateApiKey(): Unit = {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    val res = client.updateApiKey(
      key = "myApiKey",
      apiKey = ApiKey(
        acl = Seq(Acl.withName("search"), Acl.withName("addObject")),
        validity = Some(300),
        maxQueriesPerIPPerHour = Some(100),
        maxHitsPerQuery = Some(20)
      )
    )

    // Use the response
    val value = Await.result(res, Duration(100, "sec"))
  }

}

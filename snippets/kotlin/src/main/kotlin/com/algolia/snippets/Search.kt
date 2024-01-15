package com.algolia.snippets

import com.algolia.client.api.SearchClient
import com.algolia.client.model.search.*
import kotlinx.serialization.json.*
import kotlin.system.exitProcess

class SnippetSearchClient {
  suspend fun snippetForAddApiKey() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.addApiKey(
      apiKey = ApiKey(
        acl = listOf(Acl.entries.first { it.value == "search" }, Acl.entries.first { it.value == "addObject" }),
        description = "my new api key",
        validity = 300,
        maxQueriesPerIPPerHour = 100,
        maxHitsPerQuery = 20,
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForAddOrUpdateObject() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.addOrUpdateObject(
      indexName = "indexName",
      objectID = "uniqueID",
      body = buildJsonObject {
        put(
          "key",
          JsonPrimitive("value"),
        )
      },
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForAppendSource() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.appendSource(
      source = Source(
        source = "theSource",
        description = "theDescription",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForAssignUserId() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.assignUserId(
      xAlgoliaUserID = "userID",
      assignUserIdParams = AssignUserIdParams(
        cluster = "theCluster",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForBatch() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.batch(
      indexName = "theIndexName",
      batchWriteParams = BatchWriteParams(
        requests = listOf(
          BatchRequest(
            action = Action.entries.first { it.value == "addObject" },
            body = buildJsonObject {
              put(
                "key",
                JsonPrimitive("value"),
              )
            },
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForBatchAssignUserIds() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.batchAssignUserIds(
      xAlgoliaUserID = "userID",
      batchAssignUserIdsParams = BatchAssignUserIdsParams(
        cluster = "theCluster",
        users = listOf("user1", "user2"),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForBatchDictionaryEntries() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.batchDictionaryEntries(
      dictionaryName = DictionaryType.entries.first { it.value == "compounds" },
      batchDictionaryEntriesParams = BatchDictionaryEntriesParams(
        requests = listOf(
          BatchDictionaryEntriesRequest(
            action = DictionaryAction.entries.first { it.value == "addEntry" },
            body = DictionaryEntry(
              objectID = "1",
              language = "en",
            ),
          ),
          BatchDictionaryEntriesRequest(
            action = DictionaryAction.entries.first { it.value == "deleteEntry" },
            body = DictionaryEntry(
              objectID = "2",
              language = "fr",
            ),
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForBrowse() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.browse(
      indexName = "cts_e2e_browse",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForClearAllSynonyms() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.clearAllSynonyms(
      indexName = "indexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForClearObjects() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.clearObjects(
      indexName = "theIndexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForClearRules() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.clearRules(
      indexName = "indexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomDelete() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customDelete(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomGet() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customGet(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomPost() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPost(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForCustomPut() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.customPut(
      path = "/test/minimal",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteApiKey() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteApiKey(
      key = "myTestApiKey",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteBy() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteBy(
      indexName = "theIndexName",
      deleteByParams = DeleteByParams(
        filters = "brand:brandName",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteIndex() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteIndex(
      indexName = "theIndexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteObject() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteObject(
      indexName = "theIndexName",
      objectID = "uniqueID",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteRule() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteRule(
      indexName = "indexName",
      objectID = "id1",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteSource() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteSource(
      source = "theSource",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForDeleteSynonym() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.deleteSynonym(
      indexName = "indexName",
      objectID = "id1",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetApiKey() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getApiKey(
      key = "myTestApiKey",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetDictionaryLanguages() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getDictionaryLanguages()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetDictionarySettings() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getDictionarySettings()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetLogs() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getLogs()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetObject() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getObject(
      indexName = "theIndexName",
      objectID = "uniqueID",
      attributesToRetrieve = listOf("attr1", "attr2"),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetObjects() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getObjects(
      getObjectsParams = GetObjectsParams(
        requests = listOf(
          GetObjectsRequest(
            attributesToRetrieve = listOf("attr1", "attr2"),
            objectID = "uniqueID",
            indexName = "theIndexName",
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetRule() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getRule(
      indexName = "indexName",
      objectID = "id1",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSettings() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getSettings(
      indexName = "cts_e2e_settings",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSources() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getSources()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetSynonym() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getSynonym(
      indexName = "indexName",
      objectID = "id1",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTask() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getTask(
      indexName = "theIndexName",
      taskID = 123L,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetTopUserIds() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getTopUserIds()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForGetUserId() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.getUserId(
      userID = "uniqueID",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForHasPendingMappings() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.hasPendingMappings()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForListApiKeys() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.listApiKeys()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForListClusters() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.listClusters()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForListIndices() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.listIndices()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForListUserIds() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.listUserIds()

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForMultipleBatch() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.multipleBatch(
      batchParams = BatchParams(
        requests = listOf(
          MultipleBatchRequest(
            action = Action.entries.first { it.value == "addObject" },
            body = buildJsonObject {
              put(
                "key",
                JsonPrimitive("value"),
              )
            },
            indexName = "theIndexName",
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForOperationIndex() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.operationIndex(
      indexName = "theIndexName",
      operationIndexParams = OperationIndexParams(
        operation = OperationType.entries.first { it.value == "copy" },
        destination = "dest",
        scope = listOf(ScopeType.entries.first { it.value == "rules" }, ScopeType.entries.first { it.value == "settings" }),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForPartialUpdateObject() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.partialUpdateObject(
      indexName = "theIndexName",
      objectID = "uniqueID",
      attributesToUpdate = mapOf(
        "id1" to AttributeToUpdate.of("test"),
        "id2" to BuiltInOperation(
          operation = BuiltInOperationType.entries.first { it.value == "AddUnique" },
          value = "test2",
        ),
      ),
      createIfNotExists = true,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForRemoveUserId() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.removeUserId(
      userID = "uniqueID",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForReplaceSources() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.replaceSources(
      source = listOf(
        Source(
          source = "theSource",
          description = "theDescription",
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForRestoreApiKey() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.restoreApiKey(
      key = "myApiKey",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSaveObject() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.saveObject(
      indexName = "theIndexName",
      body = buildJsonObject {
        put(
          "objectID",
          JsonPrimitive("id"),
        )
        put(
          "test",
          JsonPrimitive("val"),
        )
      },
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSaveRule() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.saveRule(
      indexName = "indexName",
      objectID = "id1",
      rule = Rule(
        objectID = "id1",
        conditions = listOf(
          Condition(
            pattern = "apple",
            anchoring = Anchoring.entries.first { it.value == "contains" },
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSaveRules() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.saveRules(
      indexName = "indexName",
      rules = listOf(
        Rule(
          objectID = "a-rule-id",
          conditions = listOf(
            Condition(
              pattern = "smartphone",
              anchoring = Anchoring.entries.first { it.value == "contains" },
            ),
          ),
        ),
        Rule(
          objectID = "a-second-rule-id",
          conditions = listOf(
            Condition(
              pattern = "apple",
              anchoring = Anchoring.entries.first { it.value == "contains" },
            ),
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSaveSynonym() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.saveSynonym(
      indexName = "indexName",
      objectID = "id1",
      synonymHit = SynonymHit(
        objectID = "id1",
        type = SynonymType.entries.first { it.value == "synonym" },
        synonyms = listOf("car", "vehicule", "auto"),
      ),
      forwardToReplicas = true,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSaveSynonyms() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.saveSynonyms(
      indexName = "indexName",
      synonymHit = listOf(
        SynonymHit(
          objectID = "id1",
          type = SynonymType.entries.first { it.value == "synonym" },
          synonyms = listOf("car", "vehicule", "auto"),
        ),
        SynonymHit(
          objectID = "id2",
          type = SynonymType.entries.first { it.value == "onewaysynonym" },
          input = "iphone",
          synonyms = listOf("ephone", "aphone", "yphone"),
        ),
      ),
      forwardToReplicas = true,
      replaceExistingSynonyms = false,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearch() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.search(
      searchMethodParams = SearchMethodParams(
        requests = listOf(
          SearchForHits(
            indexName = "cts_e2e_search_empty_index",
          ),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchDictionaryEntries() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchDictionaryEntries(
      dictionaryName = DictionaryType.entries.first { it.value == "compounds" },
      searchDictionaryEntriesParams = SearchDictionaryEntriesParams(
        query = "foo",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchForFacetValues() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchForFacetValues(
      indexName = "indexName",
      facetName = "facetName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchRules() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchRules(
      indexName = "indexName",
      searchRulesParams = SearchRulesParams(
        query = "something",
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchSingleIndex() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchSingleIndex(
      indexName = "indexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchSynonyms() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchSynonyms(
      indexName = "indexName",
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSearchUserIds() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.searchUserIds(
      searchUserIdsParams = SearchUserIdsParams(
        query = "test",
        clusterName = "theClusterName",
        page = 5,
        hitsPerPage = 10,
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSetDictionarySettings() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.setDictionarySettings(
      dictionarySettingsParams = DictionarySettingsParams(
        disableStandardEntries = StandardEntries(
          plurals = mapOf("fr" to false, "en" to false, "ru" to true),
        ),
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForSetSettings() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.setSettings(
      indexName = "cts_e2e_settings",
      indexSettings = IndexSettings(
        paginationLimitedTo = 10,
      ),
      forwardToReplicas = true,
    )

    // Use the response
    println(response)

    exitProcess(0)
  }

  suspend fun snippetForUpdateApiKey() {
    // Initialize the client
    val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

    // Call the API
    var response = client.updateApiKey(
      key = "myApiKey",
      apiKey = ApiKey(
        acl = listOf(Acl.entries.first { it.value == "search" }, Acl.entries.first { it.value == "addObject" }),
        validity = 300,
        maxQueriesPerIPPerHour = 100,
        maxHitsPerQuery = 20,
      ),
    )

    // Use the response
    println(response)

    exitProcess(0)
  }
}

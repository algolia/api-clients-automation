#if canImport(AnyCodable)
    import AnyCodable
#endif

import Core
import Search

final class SearchClientSnippet {
    // Snippet for the addApiKey method.
    //
    // addApiKey0
    func snippetForAddApiKey() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.addApiKey(apiKey: ApiKey(acl: [Acl.search,
                                                            Acl.addObject],
                                                      description: "my new api key",
                                                      maxHitsPerQuery: 20,
                                                      maxQueriesPerIPPerHour: 100,
                                                      validity: 300)
        )
    }

    // Snippet for the addOrUpdateObject method.
    //
    // addOrUpdateObject0
    func snippetForAddOrUpdateObject() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.addOrUpdateObject(indexName: "indexName",
                                               objectID: "uniqueID",
                                               body: ["key": "value"])
    }

    // Snippet for the appendSource method.
    //
    // appendSource0
    func snippetForAppendSource() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.appendSource(source: Source(source: "theSource",
                                                         description: "theDescription")
        )
    }

    // Snippet for the assignUserId method.
    //
    // assignUserId0
    func snippetForAssignUserId() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.assignUserId(xAlgoliaUserID: "userID",
                                          assignUserIdParams: AssignUserIdParams(cluster: "theCluster"
                                          ))
    }

    // Snippet for the batch method.
    //
    // allows batch method with `addObject` action
    func snippetForBatch() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.batch(indexName: "theIndexName",
                                   batchWriteParams: BatchWriteParams(requests: [BatchRequest(action: Action.addObject,
                                                                                              body: ["key": "value"])]
                                   ))
    }

    // Snippet for the batchAssignUserIds method.
    //
    // batchAssignUserIds0
    func snippetForBatchAssignUserIds() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.batchAssignUserIds(xAlgoliaUserID: "userID",
                                                batchAssignUserIdsParams: BatchAssignUserIdsParams(cluster: "theCluster",
                                                                                                   users: ["user1",
                                                                                                           "user2"]))
    }

    // Snippet for the batchDictionaryEntries method.
    //
    // get batchDictionaryEntries results with minimal parameters
    func snippetForBatchDictionaryEntries() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.batchDictionaryEntries(dictionaryName: DictionaryType.compounds,
                                                    batchDictionaryEntriesParams: BatchDictionaryEntriesParams(requests: [BatchDictionaryEntriesRequest(action: DictionaryAction.addEntry,
                                                                                                                                                        body: DictionaryEntry(objectID: "1",
                                                                                                                                                                              language: "en")),
                                                                                                                          BatchDictionaryEntriesRequest(action: DictionaryAction.deleteEntry,
                                                                                                                                                        body: DictionaryEntry(objectID: "2",
                                                                                                                                                                              language: "fr"))]
                                                    ))
    }

    // Snippet for the browse method.
    //
    // browse with minimal parameters
    func snippetForBrowse() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.browse(indexName: "cts_e2e_browse"
        )
    }

    // Snippet for the clearObjects method.
    //
    // clearObjects0
    func snippetForClearObjects() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.clearObjects(indexName: "theIndexName"
        )
    }

    // Snippet for the clearRules method.
    //
    // clearRules0
    func snippetForClearRules() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.clearRules(indexName: "indexName"
        )
    }

    // Snippet for the clearSynonyms method.
    //
    // clearSynonyms0
    func snippetForClearSynonyms() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.clearSynonyms(indexName: "indexName"
        )
    }

    // Snippet for the customDelete method.
    //
    // allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customDelete(path: "/test/minimal"
        )
    }

    // Snippet for the customGet method.
    //
    // allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customGet(path: "/test/minimal"
        )
    }

    // Snippet for the customPost method.
    //
    // allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPost(path: "/test/minimal"
        )
    }

    // Snippet for the customPut method.
    //
    // allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPut(path: "/test/minimal"
        )
    }

    // Snippet for the deleteApiKey method.
    //
    // deleteApiKey0
    func snippetForDeleteApiKey() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteApiKey(key: "myTestApiKey"
        )
    }

    // Snippet for the deleteBy method.
    //
    // deleteBy0
    func snippetForDeleteBy() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteBy(indexName: "theIndexName",
                                      deleteByParams: DeleteByParams(filters: "brand:brandName"
                                      ))
    }

    // Snippet for the deleteIndex method.
    //
    // deleteIndex0
    func snippetForDeleteIndex() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteIndex(indexName: "theIndexName"
        )
    }

    // Snippet for the deleteObject method.
    //
    // deleteObject0
    func snippetForDeleteObject() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteObject(indexName: "theIndexName",
                                          objectID: "uniqueID")
    }

    // Snippet for the deleteRule method.
    //
    // delete rule simple case
    func snippetForDeleteRule() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteRule(indexName: "indexName",
                                        objectID: "id1")
    }

    // Snippet for the deleteSource method.
    //
    // deleteSource0
    func snippetForDeleteSource() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteSource(source: "theSource"
        )
    }

    // Snippet for the deleteSynonym method.
    //
    // deleteSynonym0
    func snippetForDeleteSynonym() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteSynonym(indexName: "indexName",
                                           objectID: "id1")
    }

    // Snippet for the getApiKey method.
    //
    // getApiKey0
    func snippetForGetApiKey() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getApiKey(key: "myTestApiKey"
        )
    }

    // Snippet for the getDictionaryLanguages method.
    //
    // get getDictionaryLanguages
    func snippetForGetDictionaryLanguages() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getDictionaryLanguages()
    }

    // Snippet for the getDictionarySettings method.
    //
    // get getDictionarySettings results
    func snippetForGetDictionarySettings() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getDictionarySettings()
    }

    // Snippet for the getLogs method.
    //
    // getLogs with minimal parameters
    func snippetForGetLogs() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getLogs()
    }

    // Snippet for the getObject method.
    //
    // getObject0
    func snippetForGetObject() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getObject(indexName: "theIndexName",
                                       objectID: "uniqueID",
                                       attributesToRetrieve: ["attr1",
                                                              "attr2"])
    }

    // Snippet for the getObjects method.
    //
    // getObjects0
    func snippetForGetObjects() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getObjects(getObjectsParams: GetObjectsParams(requests: [GetObjectsRequest(attributesToRetrieve: ["attr1",
                                                                                                                               "attr2"],
            objectID: "uniqueID",
            indexName: "theIndexName")]
        )
        )
    }

    // Snippet for the getRule method.
    //
    // getRule0
    func snippetForGetRule() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getRule(indexName: "indexName",
                                     objectID: "id1")
    }

    // Snippet for the getSettings method.
    //
    // getSettings0
    func snippetForGetSettings() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getSettings(indexName: "cts_e2e_settings"
        )
    }

    // Snippet for the getSources method.
    //
    // getSources0
    func snippetForGetSources() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getSources()
    }

    // Snippet for the getSynonym method.
    //
    // getSynonym0
    func snippetForGetSynonym() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getSynonym(indexName: "indexName",
                                        objectID: "id1")
    }

    // Snippet for the getTask method.
    //
    // getTask0
    func snippetForGetTask() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getTask(indexName: "theIndexName",
                                     taskID: Int64(123))
    }

    // Snippet for the getTopUserIds method.
    //
    // getTopUserIds0
    func snippetForGetTopUserIds() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getTopUserIds()
    }

    // Snippet for the getUserId method.
    //
    // getUserId0
    func snippetForGetUserId() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getUserId(userID: "uniqueID"
        )
    }

    // Snippet for the hasPendingMappings method.
    //
    // hasPendingMappings with minimal parameters
    func snippetForHasPendingMappings() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.hasPendingMappings()
    }

    // Snippet for the listApiKeys method.
    //
    // listApiKeys0
    func snippetForListApiKeys() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listApiKeys()
    }

    // Snippet for the listClusters method.
    //
    // listClusters0
    func snippetForListClusters() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listClusters()
    }

    // Snippet for the listIndices method.
    //
    // listIndices with minimal parameters
    func snippetForListIndices() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listIndices()
    }

    // Snippet for the listUserIds method.
    //
    // listUserIds with minimal parameters
    func snippetForListUserIds() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listUserIds()
    }

    // Snippet for the multipleBatch method.
    //
    // multipleBatch0
    func snippetForMultipleBatch() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.multipleBatch(batchParams: BatchParams(requests: [MultipleBatchRequest(action: Action.addObject,
                                                                                                    body: ["key": "value"],
                                                                                                    indexName: "theIndexName")]
        )
        )
    }

    // Snippet for the operationIndex method.
    //
    // operationIndex0
    func snippetForOperationIndex() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.operationIndex(indexName: "theIndexName",
                                            operationIndexParams: OperationIndexParams(operation: OperationType.copy,
                                                                                       destination: "dest",
                                                                                       scope: [ScopeType.rules,
                                                                                               ScopeType.settings]))
    }

    // Snippet for the partialUpdateObject method.
    //
    // partialUpdateObject0
    func snippetForPartialUpdateObject() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.partialUpdateObject(indexName: "theIndexName",
                                                 objectID: "uniqueID",
                                                 attributesToUpdate: ["id1": AttributeToUpdate.string("test"
                                                 ), "id2": AttributeToUpdate.builtInOperation(BuiltInOperation(operation: BuiltInOperationType.addUnique,
                                                                                                               value: "test2"
                                                     )
                                                 )],
                                                 createIfNotExists: true)
    }

    // Snippet for the removeUserId method.
    //
    // removeUserId0
    func snippetForRemoveUserId() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.removeUserId(userID: "uniqueID"
        )
    }

    // Snippet for the replaceSources method.
    //
    // replaceSources0
    func snippetForReplaceSources() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.replaceSources(source: [Source(source: "theSource",
                                                            description: "theDescription")]
        )
    }

    // Snippet for the restoreApiKey method.
    //
    // restoreApiKey0
    func snippetForRestoreApiKey() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.restoreApiKey(key: "myApiKey"
        )
    }

    // Snippet for the saveObject method.
    //
    // saveObject0
    func snippetForSaveObject() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveObject(indexName: "theIndexName",
                                        body: ["objectID": "id",
                                               "test": "val"])
    }

    // Snippet for the saveRule method.
    //
    // saveRule with minimal parameters
    func snippetForSaveRule() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveRule(indexName: "indexName",
                                      objectID: "id1",
                                      rule: Rule(objectID: "id1",
                                                 conditions: [Condition(pattern: "apple",
                                                                        anchoring: Anchoring.contains)]))
    }

    // Snippet for the saveRules method.
    //
    // saveRules with minimal parameters
    func snippetForSaveRules() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveRules(indexName: "indexName",
                                       rules: [Rule(objectID: "a-rule-id",
                                                    conditions: [Condition(pattern: "smartphone",
                                                                           anchoring: Anchoring.contains)]),
                                               Rule(objectID: "a-second-rule-id",
                                                    conditions: [Condition(pattern: "apple",
                                                                           anchoring: Anchoring.contains)])])
    }

    // Snippet for the saveSynonym method.
    //
    // saveSynonym0
    func snippetForSaveSynonym() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveSynonym(indexName: "indexName",
                                         objectID: "id1",
                                         synonymHit: SynonymHit(objectID: "id1",
                                                                type: SynonymType.synonym,
                                                                synonyms: ["car",
                                                                           "vehicule",
                                                                           "auto"]),
                                         forwardToReplicas: true)
    }

    // Snippet for the saveSynonyms method.
    //
    // saveSynonyms0
    func snippetForSaveSynonyms() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveSynonyms(indexName: "indexName",
                                          synonymHit: [SynonymHit(objectID: "id1",
                                                                  type: SynonymType.synonym,
                                                                  synonyms: ["car",
                                                                             "vehicule",
                                                                             "auto"]),
                                                       SynonymHit(objectID: "id2",
                                                                  type: SynonymType.onewaysynonym,
                                                                  synonyms: ["ephone",
                                                                             "aphone",
                                                                             "yphone"],
                                                                  input: "iphone")],
                                          forwardToReplicas: true,
                                          replaceExistingSynonyms: false)
    }

    // Snippet for the search method.
    //
    // search for a single hits request with minimal parameters
    func snippetForSearch() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(indexName: "cts_e2e_search_empty_index"
        )
        )]
        )
        )
    }

    // Snippet for the searchDictionaryEntries method.
    //
    // get searchDictionaryEntries results with minimal parameters
    func snippetForSearchDictionaryEntries() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchDictionaryEntries(dictionaryName: DictionaryType.compounds,
                                                     searchDictionaryEntriesParams: SearchDictionaryEntriesParams(query: "foo"
                                                     ))
    }

    // Snippet for the searchForFacetValues method.
    //
    // get searchForFacetValues results with minimal parameters
    func snippetForSearchForFacetValues() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchForFacetValues(indexName: "indexName",
                                                  facetName: "facetName")
    }

    // Snippet for the searchRules method.
    //
    // searchRules0
    func snippetForSearchRules() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchRules(indexName: "indexName",
                                         searchRulesParams: SearchRulesParams(query: "something"
                                         ))
    }

    // Snippet for the searchSingleIndex method.
    //
    // search with minimal parameters
    func snippetForSearchSingleIndex() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchSingleIndex(indexName: "indexName"
        )
    }

    // Snippet for the searchSynonyms method.
    //
    // searchSynonyms with minimal parameters
    func snippetForSearchSynonyms() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchSynonyms(indexName: "indexName"
        )
    }

    // Snippet for the searchUserIds method.
    //
    // searchUserIds0
    func snippetForSearchUserIds() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchUserIds(searchUserIdsParams: SearchUserIdsParams(query: "test",
                                                                                    clusterName: "theClusterName",
                                                                                    page: 5,
                                                                                    hitsPerPage: 10)
        )
    }

    // Snippet for the setDictionarySettings method.
    //
    // get setDictionarySettings results with minimal parameters
    func snippetForSetDictionarySettings() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.setDictionarySettings(dictionarySettingsParams: DictionarySettingsParams(disableStandardEntries: StandardEntries(plurals: ["fr": false,
                                                                                                                                                        "en": false,
                                                                                                                                                        "ru": true]
            )
        )
        )
    }

    // Snippet for the setSettings method.
    //
    // setSettings with minimal parameters
    func snippetForSetSettings() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.setSettings(indexName: "cts_e2e_settings",
                                         indexSettings: IndexSettings(paginationLimitedTo: 10
                                         ),
                                         forwardToReplicas: true)
    }

    // Snippet for the updateApiKey method.
    //
    // updateApiKey0
    func snippetForUpdateApiKey() async throws {
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.updateApiKey(key: "myApiKey",
                                          apiKey: ApiKey(acl: [Acl.search,
                                                               Acl.addObject],
                                                         maxHitsPerQuery: 20,
                                                         maxQueriesPerIPPerHour: 100,
                                                         validity: 300))
    }
}

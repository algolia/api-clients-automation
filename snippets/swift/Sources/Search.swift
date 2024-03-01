import AnyCodable

import Core
import Search

final class SearchClientSnippet {
    /// Snippet for the addApiKey method.
    ///
    /// addApiKey0
    func snippetForAddApiKey() async throws {
        // >SEPARATOR addApiKey
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.addApiKey(
            apiKey: ApiKey(
                acl: [
                    Acl.search,
                    Acl.addObject,
                ],
                description: "my new api key",
                maxHitsPerQuery: 20,
                maxQueriesPerIPPerHour: 100,
                validity: 300
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the addOrUpdateObject method.
    ///
    /// addOrUpdateObject0
    func snippetForAddOrUpdateObject() async throws {
        // >SEPARATOR addOrUpdateObject
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.addOrUpdateObject(
            indexName: "indexName",
            objectID: "uniqueID",
            body: [
                "key": "value",
            ]
        )
        // SEPARATOR<
    }

    /// Snippet for the appendSource method.
    ///
    /// appendSource0
    func snippetForAppendSource() async throws {
        // >SEPARATOR appendSource
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.appendSource(
            source: Source(
                source: "theSource",
                description: "theDescription"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the assignUserId method.
    ///
    /// assignUserId0
    func snippetForAssignUserId() async throws {
        // >SEPARATOR assignUserId
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.assignUserId(
            xAlgoliaUserID: "userID",
            assignUserIdParams: AssignUserIdParams(
                cluster: "theCluster"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// allows batch method with `addObject` action
    func snippetForBatch() async throws {
        // >SEPARATOR batch
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.batch(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(
                requests: [
                    BatchRequest(
                        action: Action.addObject,
                        body: [
                            "key": "value",
                        ]
                    ),
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the batchAssignUserIds method.
    ///
    /// batchAssignUserIds0
    func snippetForBatchAssignUserIds() async throws {
        // >SEPARATOR batchAssignUserIds
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.batchAssignUserIds(
            xAlgoliaUserID: "userID",
            batchAssignUserIdsParams: BatchAssignUserIdsParams(
                cluster: "theCluster",
                users: [
                    "user1",
                    "user2",
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// get batchDictionaryEntries results with minimal parameters
    func snippetForBatchDictionaryEntries() async throws {
        // >SEPARATOR batchDictionaryEntries
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.batchDictionaryEntries(
            dictionaryName: DictionaryType.compounds,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
                requests: [
                    BatchDictionaryEntriesRequest(
                        action: DictionaryAction.addEntry,
                        body: DictionaryEntry(
                            objectID: "1",
                            language: "en"
                        )
                    ),
                    BatchDictionaryEntriesRequest(
                        action: DictionaryAction.deleteEntry,
                        body: DictionaryEntry(
                            objectID: "2",
                            language: "fr"
                        )
                    ),
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the browse method.
    ///
    /// browse with minimal parameters
    func snippetForBrowse() async throws {
        // >SEPARATOR browse
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.browse(
            indexName: "cts_e2e_browse"
        )
        // SEPARATOR<
    }

    /// Snippet for the clearObjects method.
    ///
    /// clearObjects0
    func snippetForClearObjects() async throws {
        // >SEPARATOR clearObjects
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.clearObjects(
            indexName: "theIndexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the clearRules method.
    ///
    /// clearRules0
    func snippetForClearRules() async throws {
        // >SEPARATOR clearRules
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.clearRules(
            indexName: "indexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the clearSynonyms method.
    ///
    /// clearSynonyms0
    func snippetForClearSynonyms() async throws {
        // >SEPARATOR clearSynonyms
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.clearSynonyms(
            indexName: "indexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customDelete(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customGet(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPost(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteApiKey method.
    ///
    /// deleteApiKey0
    func snippetForDeleteApiKey() async throws {
        // >SEPARATOR deleteApiKey
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteApiKey(
            key: "myTestApiKey"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteBy method.
    ///
    /// deleteBy0
    func snippetForDeleteBy() async throws {
        // >SEPARATOR deleteBy
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteBy(
            indexName: "theIndexName",
            deleteByParams: DeleteByParams(
                filters: "brand:brandName"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteIndex method.
    ///
    /// deleteIndex0
    func snippetForDeleteIndex() async throws {
        // >SEPARATOR deleteIndex
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteIndex(
            indexName: "theIndexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteObject method.
    ///
    /// deleteObject0
    func snippetForDeleteObject() async throws {
        // >SEPARATOR deleteObject
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteObject(
            indexName: "theIndexName",
            objectID: "uniqueID"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteRule method.
    ///
    /// delete rule simple case
    func snippetForDeleteRule() async throws {
        // >SEPARATOR deleteRule
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteRule(
            indexName: "indexName",
            objectID: "id1"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteSource method.
    ///
    /// deleteSource0
    func snippetForDeleteSource() async throws {
        // >SEPARATOR deleteSource
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteSource(
            source: "theSource"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteSynonym method.
    ///
    /// deleteSynonym0
    func snippetForDeleteSynonym() async throws {
        // >SEPARATOR deleteSynonym
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteSynonym(
            indexName: "indexName",
            objectID: "id1"
        )
        // SEPARATOR<
    }

    /// Snippet for the getApiKey method.
    ///
    /// getApiKey0
    func snippetForGetApiKey() async throws {
        // >SEPARATOR getApiKey
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getApiKey(
            key: "myTestApiKey"
        )
        // SEPARATOR<
    }

    /// Snippet for the getDictionaryLanguages method.
    ///
    /// get getDictionaryLanguages
    func snippetForGetDictionaryLanguages() async throws {
        // >SEPARATOR getDictionaryLanguages
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getDictionaryLanguages()
        // SEPARATOR<
    }

    /// Snippet for the getDictionarySettings method.
    ///
    /// get getDictionarySettings results
    func snippetForGetDictionarySettings() async throws {
        // >SEPARATOR getDictionarySettings
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getDictionarySettings()
        // SEPARATOR<
    }

    /// Snippet for the getLogs method.
    ///
    /// getLogs with minimal parameters
    func snippetForGetLogs() async throws {
        // >SEPARATOR getLogs
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getLogs()
        // SEPARATOR<
    }

    /// Snippet for the getObject method.
    ///
    /// getObject0
    func snippetForGetObject() async throws {
        // >SEPARATOR getObject
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getObject(
            indexName: "theIndexName",
            objectID: "uniqueID",
            attributesToRetrieve: [
                "attr1",
                "attr2",
            ]
        )
        // SEPARATOR<
    }

    /// Snippet for the getObjects method.
    ///
    /// getObjects0
    func snippetForGetObjects() async throws {
        // >SEPARATOR getObjects
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getObjects(
            getObjectsParams: GetObjectsParams(
                requests: [
                    GetObjectsRequest(
                        attributesToRetrieve: [
                            "attr1",
                            "attr2",
                        ],
                        objectID: "uniqueID",
                        indexName: "theIndexName"
                    ),
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the getRule method.
    ///
    /// getRule0
    func snippetForGetRule() async throws {
        // >SEPARATOR getRule
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getRule(
            indexName: "indexName",
            objectID: "id1"
        )
        // SEPARATOR<
    }

    /// Snippet for the getSettings method.
    ///
    /// getSettings0
    func snippetForGetSettings() async throws {
        // >SEPARATOR getSettings
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getSettings(
            indexName: "cts_e2e_settings"
        )
        // SEPARATOR<
    }

    /// Snippet for the getSources method.
    ///
    /// getSources0
    func snippetForGetSources() async throws {
        // >SEPARATOR getSources
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getSources()
        // SEPARATOR<
    }

    /// Snippet for the getSynonym method.
    ///
    /// getSynonym0
    func snippetForGetSynonym() async throws {
        // >SEPARATOR getSynonym
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getSynonym(
            indexName: "indexName",
            objectID: "id1"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTask method.
    ///
    /// getTask0
    func snippetForGetTask() async throws {
        // >SEPARATOR getTask
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getTask(
            indexName: "theIndexName",
            taskID: Int64(123)
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopUserIds method.
    ///
    /// getTopUserIds0
    func snippetForGetTopUserIds() async throws {
        // >SEPARATOR getTopUserIds
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getTopUserIds()
        // SEPARATOR<
    }

    /// Snippet for the getUserId method.
    ///
    /// getUserId0
    func snippetForGetUserId() async throws {
        // >SEPARATOR getUserId
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getUserId(
            userID: "uniqueID"
        )
        // SEPARATOR<
    }

    /// Snippet for the hasPendingMappings method.
    ///
    /// hasPendingMappings with minimal parameters
    func snippetForHasPendingMappings() async throws {
        // >SEPARATOR hasPendingMappings
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.hasPendingMappings()
        // SEPARATOR<
    }

    /// Snippet for the listApiKeys method.
    ///
    /// listApiKeys0
    func snippetForListApiKeys() async throws {
        // >SEPARATOR listApiKeys
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listApiKeys()
        // SEPARATOR<
    }

    /// Snippet for the listClusters method.
    ///
    /// listClusters0
    func snippetForListClusters() async throws {
        // >SEPARATOR listClusters
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listClusters()
        // SEPARATOR<
    }

    /// Snippet for the listIndices method.
    ///
    /// listIndices with minimal parameters
    func snippetForListIndices() async throws {
        // >SEPARATOR listIndices
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listIndices()
        // SEPARATOR<
    }

    /// Snippet for the listUserIds method.
    ///
    /// listUserIds with minimal parameters
    func snippetForListUserIds() async throws {
        // >SEPARATOR listUserIds
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.listUserIds()
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch0
    func snippetForMultipleBatch() async throws {
        // >SEPARATOR multipleBatch
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.multipleBatch(
            batchParams: BatchParams(
                requests: [
                    MultipleBatchRequest(
                        action: Action.addObject,
                        body: [
                            "key": "value",
                        ],
                        indexName: "theIndexName"
                    ),
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// operationIndex0
    func snippetForOperationIndex() async throws {
        // >SEPARATOR operationIndex
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.operationIndex(
            indexName: "theIndexName",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.copy,
                destination: "dest",
                scope: [
                    ScopeType.rules,
                    ScopeType.settings,
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// partialUpdateObject0
    func snippetForPartialUpdateObject() async throws {
        // >SEPARATOR partialUpdateObject
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.partialUpdateObject(
            indexName: "theIndexName",
            objectID: "uniqueID",
            attributesToUpdate: ["id1": AttributeToUpdate.string("test"
            ), "id2": AttributeToUpdate.builtInOperation(BuiltInOperation(operation: BuiltInOperationType.addUnique,
                                                                          value: "test2"
                )
            )],
            createIfNotExists: true
        )
        // SEPARATOR<
    }

    /// Snippet for the removeUserId method.
    ///
    /// removeUserId0
    func snippetForRemoveUserId() async throws {
        // >SEPARATOR removeUserId
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.removeUserId(
            userID: "uniqueID"
        )
        // SEPARATOR<
    }

    /// Snippet for the replaceSources method.
    ///
    /// replaceSources0
    func snippetForReplaceSources() async throws {
        // >SEPARATOR replaceSources
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.replaceSources(
            source: [
                Source(
                    source: "theSource",
                    description: "theDescription"
                ),
            ]
        )
        // SEPARATOR<
    }

    /// Snippet for the restoreApiKey method.
    ///
    /// restoreApiKey0
    func snippetForRestoreApiKey() async throws {
        // >SEPARATOR restoreApiKey
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.restoreApiKey(
            key: "myApiKey"
        )
        // SEPARATOR<
    }

    /// Snippet for the saveObject method.
    ///
    /// saveObject0
    func snippetForSaveObject() async throws {
        // >SEPARATOR saveObject
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveObject(
            indexName: "theIndexName",
            body: [
                "objectID": "id",
                "test": "val",
            ]
        )
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// saveRule with minimal parameters
    func snippetForSaveRule() async throws {
        // >SEPARATOR saveRule
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveRule(
            indexName: "indexName",
            objectID: "id1",
            rule: Rule(
                objectID: "id1",
                conditions: [
                    Condition(
                        pattern: "apple",
                        anchoring: Anchoring.contains
                    ),
                ]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules with minimal parameters
    func snippetForSaveRules() async throws {
        // >SEPARATOR saveRules
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveRules(
            indexName: "indexName",
            rules: [
                Rule(
                    objectID: "a-rule-id",
                    conditions: [
                        Condition(
                            pattern: "smartphone",
                            anchoring: Anchoring.contains
                        ),
                    ]
                ),
                Rule(
                    objectID: "a-second-rule-id",
                    conditions: [
                        Condition(
                            pattern: "apple",
                            anchoring: Anchoring.contains
                        ),
                    ]
                ),
            ]
        )
        // SEPARATOR<
    }

    /// Snippet for the saveSynonym method.
    ///
    /// saveSynonym0
    func snippetForSaveSynonym() async throws {
        // >SEPARATOR saveSynonym
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveSynonym(
            indexName: "indexName",
            objectID: "id1",
            synonymHit: SynonymHit(
                objectID: "id1",
                type: SynonymType.synonym,
                synonyms: [
                    "car",
                    "vehicule",
                    "auto",
                ]
            ),
            forwardToReplicas: true
        )
        // SEPARATOR<
    }

    /// Snippet for the saveSynonyms method.
    ///
    /// saveSynonyms0
    func snippetForSaveSynonyms() async throws {
        // >SEPARATOR saveSynonyms
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.saveSynonyms(
            indexName: "indexName",
            synonymHit: [
                SynonymHit(
                    objectID: "id1",
                    type: SynonymType.synonym,
                    synonyms: [
                        "car",
                        "vehicule",
                        "auto",
                    ]
                ),
                SynonymHit(
                    objectID: "id2",
                    type: SynonymType.onewaysynonym,
                    synonyms: [
                        "ephone",
                        "aphone",
                        "yphone",
                    ],
                    input: "iphone"
                ),
            ],
            forwardToReplicas: true,
            replaceExistingSynonyms: false
        )
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for a single hits request with minimal parameters
    func snippetForSearch() async throws {
        // >SEPARATOR search
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client
            .search(
                searchMethodParams: SearchMethodParams(
                    requests: [
                        SearchQuery
                            .searchForHits(
                                SearchForHits(
                                    indexName: "cts_e2e_search_empty_index"
                                )
                            ),
                    ]
                )
            )
        // SEPARATOR<
    }

    /// Snippet for the searchDictionaryEntries method.
    ///
    /// get searchDictionaryEntries results with minimal parameters
    func snippetForSearchDictionaryEntries() async throws {
        // >SEPARATOR searchDictionaryEntries
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchDictionaryEntries(
            dictionaryName: DictionaryType.compounds,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(
                query: "foo"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// get searchForFacetValues results with minimal parameters
    func snippetForSearchForFacetValues() async throws {
        // >SEPARATOR searchForFacetValues
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchForFacetValues(
            indexName: "indexName",
            facetName: "facetName"
        )
        // SEPARATOR<
    }

    /// Snippet for the searchRules method.
    ///
    /// searchRules0
    func snippetForSearchRules() async throws {
        // >SEPARATOR searchRules
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchRules(
            indexName: "indexName",
            searchRulesParams: SearchRulesParams(
                query: "something"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search with minimal parameters
    func snippetForSearchSingleIndex() async throws {
        // >SEPARATOR searchSingleIndex
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchSingleIndex(
            indexName: "indexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the searchSynonyms method.
    ///
    /// searchSynonyms with minimal parameters
    func snippetForSearchSynonyms() async throws {
        // >SEPARATOR searchSynonyms
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchSynonyms(
            indexName: "indexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the searchUserIds method.
    ///
    /// searchUserIds0
    func snippetForSearchUserIds() async throws {
        // >SEPARATOR searchUserIds
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchUserIds(
            searchUserIdsParams: SearchUserIdsParams(
                query: "test",
                clusterName: "theClusterName",
                page: 5,
                hitsPerPage: 10
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the setDictionarySettings method.
    ///
    /// get setDictionarySettings results with minimal parameters
    func snippetForSetDictionarySettings() async throws {
        // >SEPARATOR setDictionarySettings
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client
            .setDictionarySettings(
                dictionarySettingsParams: DictionarySettingsParams(
                    disableStandardEntries: StandardEntries(
                        plurals: [
                            "fr": false,
                            "en": false,
                            "ru": true,
                        ]
                    )
                )
            )
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// setSettings with minimal parameters
    func snippetForSetSettings() async throws {
        // >SEPARATOR setSettings
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.setSettings(
            indexName: "cts_e2e_settings",
            indexSettings: IndexSettings(
                paginationLimitedTo: 10
            ),
            forwardToReplicas: true
        )
        // SEPARATOR<
    }

    /// Snippet for the updateApiKey method.
    ///
    /// updateApiKey0
    func snippetForUpdateApiKey() async throws {
        // >SEPARATOR updateApiKey
        // Initialize the client
        let client = try SearchClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.updateApiKey(
            key: "myApiKey",
            apiKey: ApiKey(
                acl: [
                    Acl.search,
                    Acl.addObject,
                ],
                maxHitsPerQuery: 20,
                maxQueriesPerIPPerHour: 100,
                validity: 300
            )
        )
        // SEPARATOR<
    }
}

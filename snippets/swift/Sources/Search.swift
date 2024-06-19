#if canImport(Core)
    import Core
#endif
// >IMPORT
import Search

// IMPORT<

final class SearchClientSnippet {
    /// Snippet for the addApiKey method.
    ///
    /// addApiKey
    func snippetForAddApiKey() async throws {
        // >SEPARATOR addApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.addApiKey(apiKey: ApiKey(
            acl: [Acl.search, Acl.addObject],
            description: "my new api key",
            maxHitsPerQuery: 20,
            maxQueriesPerIPPerHour: 100,
            validity: 300
        ))
        // SEPARATOR<
    }

    /// Snippet for the addOrUpdateObject method.
    ///
    /// addOrUpdateObject
    func snippetForAddOrUpdateObject() async throws {
        // >SEPARATOR addOrUpdateObject default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.addOrUpdateObject(
            indexName: "indexName",
            objectID: "uniqueID",
            body: ["key": "value"]
        )
        // SEPARATOR<
    }

    /// Snippet for the appendSource method.
    ///
    /// appendSource
    func snippetForAppendSource() async throws {
        // >SEPARATOR appendSource default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.appendSource(source: SearchSource(
            source: "theSource",
            description: "theDescription"
        ))
        // SEPARATOR<
    }

    /// Snippet for the assignUserId method.
    ///
    /// assignUserId
    func snippetForAssignUserId() async throws {
        // >SEPARATOR assignUserId default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.assignUserId(
            xAlgoliaUserID: "userID",
            assignUserIdParams: AssignUserIdParams(cluster: "theCluster")
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// addObject
    func snippetForBatch() async throws {
        // >SEPARATOR batch addObject
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [
                BatchRequest(action: Action.addObject, body: ["key": "bar", "foo": "1"]),
                BatchRequest(action: Action.addObject, body: ["key": "baz", "foo": "2"]),
            ])
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// clear
    func snippetForBatch1() async throws {
        // >SEPARATOR batch clear
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(action: Action.clear, body: ["key": "value"])])
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// delete
    func snippetForBatch2() async throws {
        // >SEPARATOR batch delete
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(action: Action.delete, body: ["key": "value"])])
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// deleteObject
    func snippetForBatch3() async throws {
        // >SEPARATOR batch deleteObject
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.deleteObject,
                body: ["key": "value"]
            )])
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// partialUpdateObject
    func snippetForBatch4() async throws {
        // >SEPARATOR batch partialUpdateObject
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.partialUpdateObject,
                body: ["key": "value"]
            )])
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// partialUpdateObjectNoCreate
    func snippetForBatch5() async throws {
        // >SEPARATOR batch partialUpdateObjectNoCreate
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.partialUpdateObjectNoCreate,
                body: ["key": "value"]
            )])
        )
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// updateObject
    func snippetForBatch6() async throws {
        // >SEPARATOR batch updateObject
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.updateObject,
                body: ["key": "value"]
            )])
        )
        // SEPARATOR<
    }

    /// Snippet for the batchAssignUserIds method.
    ///
    /// batchAssignUserIds
    func snippetForBatchAssignUserIds() async throws {
        // >SEPARATOR batchAssignUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batchAssignUserIds(
            xAlgoliaUserID: "userID",
            batchAssignUserIdsParams: BatchAssignUserIdsParams(cluster: "theCluster", users: ["user1", "user2"])
        )
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// replace
    func snippetForBatchDictionaryEntries() async throws {
        // >SEPARATOR batchDictionaryEntries replace
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batchDictionaryEntries(
            dictionaryName: DictionaryType.plurals,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
                clearExistingDictionaryEntries: true,
                requests: [BatchDictionaryEntriesRequest(
                    action: DictionaryAction.addEntry,
                    body: DictionaryEntry(
                        objectID: "1",
                        language: SearchSupportedLanguage.en,
                        word: "fancy",
                        words: ["believe", "algolia"],
                        decomposition: ["trust", "algolia"],
                        state: DictionaryEntryState.enabled
                    )
                )]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// delete
    func snippetForBatchDictionaryEntries1() async throws {
        // >SEPARATOR batchDictionaryEntries delete
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batchDictionaryEntries(
            dictionaryName: DictionaryType.plurals,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
                clearExistingDictionaryEntries: true,
                requests: [BatchDictionaryEntriesRequest(
                    action: DictionaryAction.deleteEntry,
                    body: DictionaryEntry(
                        objectID: "1",
                        language: SearchSupportedLanguage.en,
                        word: "fancy",
                        words: ["believe", "algolia"],
                        decomposition: ["trust", "algolia"],
                        state: DictionaryEntryState.enabled
                    )
                )]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// append
    func snippetForBatchDictionaryEntries2() async throws {
        // >SEPARATOR batchDictionaryEntries append
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.batchDictionaryEntries(
            dictionaryName: DictionaryType.stopwords,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(requests: [BatchDictionaryEntriesRequest(
                action: DictionaryAction.addEntry,
                body: DictionaryEntry(from: [
                    "objectID": AnyCodable("1"),
                    "language": AnyCodable(SearchSupportedLanguage.en),
                    "additional": AnyCodable("try me"),
                ])
            )])
        )
        // SEPARATOR<
    }

    /// Snippet for the browse method.
    ///
    /// browse with minimal parameters
    func snippetForBrowse() async throws {
        // >SEPARATOR browse default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: BrowseResponse<Hit> = try await client.browse(indexName: "cts_e2e_browse")
        // SEPARATOR<
    }

    /// Snippet for the clearObjects method.
    ///
    /// clearObjects
    func snippetForClearObjects() async throws {
        // >SEPARATOR clearObjects default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.clearObjects(indexName: "theIndexName")
        // SEPARATOR<
    }

    /// Snippet for the clearRules method.
    ///
    /// clearRules
    func snippetForClearRules() async throws {
        // >SEPARATOR clearRules default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.clearRules(indexName: "indexName")
        // SEPARATOR<
    }

    /// Snippet for the clearSynonyms method.
    ///
    /// clearSynonyms
    func snippetForClearSynonyms() async throws {
        // >SEPARATOR clearSynonyms default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.clearSynonyms(indexName: "indexName")
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the deleteApiKey method.
    ///
    /// deleteApiKey
    func snippetForDeleteApiKey() async throws {
        // >SEPARATOR deleteApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteApiKey(key: "myTestApiKey")
        // SEPARATOR<
    }

    /// Snippet for the deleteBy method.
    ///
    /// deleteBy
    func snippetForDeleteBy() async throws {
        // >SEPARATOR deleteBy default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteBy(
            indexName: "theIndexName",
            deleteByParams: DeleteByParams(filters: "brand:brandName")
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteIndex method.
    ///
    /// deleteIndex
    func snippetForDeleteIndex() async throws {
        // >SEPARATOR deleteIndex default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteIndex(indexName: "theIndexName")
        // SEPARATOR<
    }

    /// Snippet for the deleteObject method.
    ///
    /// deleteObject
    func snippetForDeleteObject() async throws {
        // >SEPARATOR deleteObject default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteObject(indexName: "<YOUR_INDEX_NAME>", objectID: "uniqueID")
        // SEPARATOR<
    }

    /// Snippet for the deleteRule method.
    ///
    /// delete rule simple case
    func snippetForDeleteRule() async throws {
        // >SEPARATOR deleteRule default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteRule(indexName: "indexName", objectID: "id1")
        // SEPARATOR<
    }

    /// Snippet for the deleteSource method.
    ///
    /// deleteSource
    func snippetForDeleteSource() async throws {
        // >SEPARATOR deleteSource default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteSource(source: "theSource")
        // SEPARATOR<
    }

    /// Snippet for the deleteSynonym method.
    ///
    /// deleteSynonym
    func snippetForDeleteSynonym() async throws {
        // >SEPARATOR deleteSynonym default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteSynonym(indexName: "indexName", objectID: "id1")
        // SEPARATOR<
    }

    /// Snippet for the getApiKey method.
    ///
    /// getApiKey
    func snippetForGetApiKey() async throws {
        // >SEPARATOR getApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getApiKey(key: "myTestApiKey")
        // SEPARATOR<
    }

    /// Snippet for the getAppTask method.
    ///
    /// getAppTask
    func snippetForGetAppTask() async throws {
        // >SEPARATOR getAppTask default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getAppTask(taskID: Int64(123))
        // SEPARATOR<
    }

    /// Snippet for the getDictionaryLanguages method.
    ///
    /// get getDictionaryLanguages
    func snippetForGetDictionaryLanguages() async throws {
        // >SEPARATOR getDictionaryLanguages default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getDictionaryLanguages()
        // SEPARATOR<
    }

    /// Snippet for the getDictionarySettings method.
    ///
    /// get getDictionarySettings results
    func snippetForGetDictionarySettings() async throws {
        // >SEPARATOR getDictionarySettings default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getDictionarySettings()
        // SEPARATOR<
    }

    /// Snippet for the getLogs method.
    ///
    /// getLogs with minimal parameters
    func snippetForGetLogs() async throws {
        // >SEPARATOR getLogs default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getLogs()
        // SEPARATOR<
    }

    /// Snippet for the getObject method.
    ///
    /// getObject
    func snippetForGetObject() async throws {
        // >SEPARATOR getObject default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getObject(
            indexName: "theIndexName",
            objectID: "uniqueID",
            attributesToRetrieve: ["attr1", "attr2"]
        )
        // SEPARATOR<
    }

    /// Snippet for the getObjects method.
    ///
    /// getObjects
    func snippetForGetObjects() async throws {
        // >SEPARATOR getObjects default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: GetObjectsResponse<Hit> = try await client
            .getObjects(getObjectsParams: GetObjectsParams(requests: [GetObjectsRequest(
                attributesToRetrieve: ["attr1", "attr2"],
                objectID: "uniqueID",
                indexName: "theIndexName"
            )]))
        // SEPARATOR<
    }

    /// Snippet for the getRule method.
    ///
    /// getRule
    func snippetForGetRule() async throws {
        // >SEPARATOR getRule default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getRule(indexName: "indexName", objectID: "id1")
        // SEPARATOR<
    }

    /// Snippet for the getSettings method.
    ///
    /// getSettings
    func snippetForGetSettings() async throws {
        // >SEPARATOR getSettings default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getSettings(indexName: "cts_e2e_settings")
        // SEPARATOR<
    }

    /// Snippet for the getSources method.
    ///
    /// getSources
    func snippetForGetSources() async throws {
        // >SEPARATOR getSources default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getSources()
        // SEPARATOR<
    }

    /// Snippet for the getSynonym method.
    ///
    /// getSynonym
    func snippetForGetSynonym() async throws {
        // >SEPARATOR getSynonym default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getSynonym(indexName: "indexName", objectID: "id1")
        // SEPARATOR<
    }

    /// Snippet for the getTask method.
    ///
    /// getTask
    func snippetForGetTask() async throws {
        // >SEPARATOR getTask default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getTask(indexName: "theIndexName", taskID: Int64(123))
        // SEPARATOR<
    }

    /// Snippet for the getTopUserIds method.
    ///
    /// getTopUserIds
    func snippetForGetTopUserIds() async throws {
        // >SEPARATOR getTopUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getTopUserIds()
        // SEPARATOR<
    }

    /// Snippet for the getUserId method.
    ///
    /// getUserId
    func snippetForGetUserId() async throws {
        // >SEPARATOR getUserId default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getUserId(userID: "uniqueID")
        // SEPARATOR<
    }

    /// Snippet for the hasPendingMappings method.
    ///
    /// hasPendingMappings with minimal parameters
    func snippetForHasPendingMappings() async throws {
        // >SEPARATOR hasPendingMappings default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.hasPendingMappings()
        // SEPARATOR<
    }

    /// Snippet for the listApiKeys method.
    ///
    /// listApiKeys
    func snippetForListApiKeys() async throws {
        // >SEPARATOR listApiKeys default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.listApiKeys()
        // SEPARATOR<
    }

    /// Snippet for the listClusters method.
    ///
    /// listClusters
    func snippetForListClusters() async throws {
        // >SEPARATOR listClusters default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.listClusters()
        // SEPARATOR<
    }

    /// Snippet for the listIndices method.
    ///
    /// listIndices with minimal parameters
    func snippetForListIndices() async throws {
        // >SEPARATOR listIndices default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.listIndices()
        // SEPARATOR<
    }

    /// Snippet for the listUserIds method.
    ///
    /// listUserIds with minimal parameters
    func snippetForListUserIds() async throws {
        // >SEPARATOR listUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.listUserIds()
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch
    func snippetForMultipleBatch() async throws {
        // >SEPARATOR multipleBatch default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.multipleBatch(batchParams: BatchParams(requests: [MultipleBatchRequest(
            action: Action.addObject,
            body: ["key": "value"],
            indexName: "theIndexName"
        )]))
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// scopes
    func snippetForOperationIndex() async throws {
        // >SEPARATOR operationIndex scopes
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.operationIndex(
            indexName: "<SOURCE_INDEX_NAME>",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.move,
                destination: "<DESTINATION_INDEX_NAME>",
                scope: [ScopeType.rules, ScopeType.settings]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// copy
    func snippetForOperationIndex1() async throws {
        // >SEPARATOR operationIndex copy
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.operationIndex(
            indexName: "<SOURCE_INDEX_NAME>",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.copy,
                destination: "<DESTINATION_INDEX_NAME>"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// move
    func snippetForOperationIndex2() async throws {
        // >SEPARATOR operationIndex move
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.operationIndex(
            indexName: "<SOURCE_INDEX_NAME>",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.move,
                destination: "<DESTINATION_INDEX_NAME>"
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// partialUpdateObject
    func snippetForPartialUpdateObject() async throws {
        // >SEPARATOR partialUpdateObject default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "theIndexName",
            objectID: "uniqueID",
            attributesToUpdate: [
                "id1": AttributeToUpdate.string("test"),
                "id2": AttributeToUpdate
                    .builtInOperation(BuiltInOperation(operation: BuiltInOperationType.addUnique, value: "test2")),
            ],
            createIfNotExists: true
        )
        // SEPARATOR<
    }

    /// Snippet for the removeUserId method.
    ///
    /// removeUserId
    func snippetForRemoveUserId() async throws {
        // >SEPARATOR removeUserId default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.removeUserId(userID: "uniqueID")
        // SEPARATOR<
    }

    /// Snippet for the replaceSources method.
    ///
    /// replaceSources
    func snippetForReplaceSources() async throws {
        // >SEPARATOR replaceSources default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.replaceSources(source: [SearchSource(
            source: "theSource",
            description: "theDescription"
        )])
        // SEPARATOR<
    }

    /// Snippet for the restoreApiKey method.
    ///
    /// restoreApiKey
    func snippetForRestoreApiKey() async throws {
        // >SEPARATOR restoreApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.restoreApiKey(key: "myApiKey")
        // SEPARATOR<
    }

    /// Snippet for the saveObject method.
    ///
    /// saveObject
    func snippetForSaveObject() async throws {
        // >SEPARATOR saveObject default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.saveObject(
            indexName: "<YOUR_INDEX_NAME>",
            body: ["objectID": "id", "test": "val"]
        )
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// saveRule with minimal parameters
    func snippetForSaveRule() async throws {
        // >SEPARATOR saveRule default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "indexName",
            objectID: "id1",
            rule: Rule(
                objectID: "id1",
                conditions: [SearchCondition(pattern: "apple", anchoring: SearchAnchoring.contains)]
            )
        )
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules with minimal parameters
    func snippetForSaveRules() async throws {
        // >SEPARATOR saveRules default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            indexName: "<YOUR_INDEX_NAME>",
            rules: [
                Rule(
                    objectID: "a-rule-id",
                    conditions: [SearchCondition(pattern: "smartphone", anchoring: SearchAnchoring.contains)]
                ),
                Rule(
                    objectID: "a-second-rule-id",
                    conditions: [SearchCondition(pattern: "apple", anchoring: SearchAnchoring.contains)]
                ),
            ],
            forwardToReplicas: false,
            clearExistingRules: true
        )
        // SEPARATOR<
    }

    /// Snippet for the saveSynonym method.
    ///
    /// saveSynonym
    func snippetForSaveSynonym() async throws {
        // >SEPARATOR saveSynonym default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.saveSynonym(
            indexName: "indexName",
            objectID: "id1",
            synonymHit: SynonymHit(objectID: "id1", type: SynonymType.synonym, synonyms: ["car", "vehicule", "auto"]),
            forwardToReplicas: true
        )
        // SEPARATOR<
    }

    /// Snippet for the saveSynonyms method.
    ///
    /// saveSynonyms
    func snippetForSaveSynonyms() async throws {
        // >SEPARATOR saveSynonyms default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.saveSynonyms(
            indexName: "<YOUR_INDEX_NAME>",
            synonymHit: [
                SynonymHit(objectID: "id1", type: SynonymType.synonym, synonyms: ["car", "vehicule", "auto"]),
                SynonymHit(
                    objectID: "id2",
                    type: SynonymType.onewaysynonym,
                    synonyms: ["ephone", "aphone", "yphone"],
                    input: "iphone"
                ),
            ],
            forwardToReplicas: true,
            replaceExistingSynonyms: true
        )
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// withHitsPerPage
    func snippetForSearch() async throws {
        // >SEPARATOR search withHitsPerPage
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                hitsPerPage: 50,
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// filterOnly
    func snippetForSearch1() async throws {
        // >SEPARATOR search filterOnly
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                filters: "actor:Scarlett Johansson",
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// filterOr
    func snippetForSearch2() async throws {
        // >SEPARATOR search filterOr
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                filters: "actor:Tom Cruise OR actor:Scarlett Johansson",
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// filterNot
    func snippetForSearch3() async throws {
        // >SEPARATOR search filterNot
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                filters: "NOT actor:Nicolas Cage",
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// retrieveFacets
    func snippetForSearch5() async throws {
        // >SEPARATOR search retrieveFacets
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                facets: ["author", "genre"],
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// retrieveFacetsWildcard
    func snippetForSearch6() async throws {
        // >SEPARATOR search retrieveFacetsWildcard
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                facets: ["*"],
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // SEPARATOR<
    }

    /// Snippet for the searchDictionaryEntries method.
    ///
    /// get searchDictionaryEntries results with minimal parameters
    func snippetForSearchDictionaryEntries() async throws {
        // >SEPARATOR searchDictionaryEntries default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.searchDictionaryEntries(
            dictionaryName: DictionaryType.stopwords,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(query: "about")
        )
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// get searchForFacetValues results with minimal parameters
    func snippetForSearchForFacetValues() async throws {
        // >SEPARATOR searchForFacetValues default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(indexName: "indexName", facetName: "facetName")
        // SEPARATOR<
    }

    /// Snippet for the searchRules method.
    ///
    /// searchRules
    func snippetForSearchRules() async throws {
        // >SEPARATOR searchRules default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.searchRules(
            indexName: "indexName",
            searchRulesParams: SearchRulesParams(query: "something")
        )
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search with minimal parameters
    func snippetForSearchSingleIndex() async throws {
        // >SEPARATOR searchSingleIndex default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(indexName: "indexName")
        // SEPARATOR<
    }

    /// Snippet for the searchSynonyms method.
    ///
    /// searchSynonyms with minimal parameters
    func snippetForSearchSynonyms() async throws {
        // >SEPARATOR searchSynonyms default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.searchSynonyms(indexName: "indexName")
        // SEPARATOR<
    }

    /// Snippet for the searchUserIds method.
    ///
    /// searchUserIds
    func snippetForSearchUserIds() async throws {
        // >SEPARATOR searchUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.searchUserIds(searchUserIdsParams: SearchUserIdsParams(
            query: "test",
            clusterName: "theClusterName",
            page: 5,
            hitsPerPage: 10
        ))
        // SEPARATOR<
    }

    /// Snippet for the setDictionarySettings method.
    ///
    /// get setDictionarySettings results with minimal parameters
    func snippetForSetDictionarySettings() async throws {
        // >SEPARATOR setDictionarySettings default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client
            .setDictionarySettings(
                dictionarySettingsParams: DictionarySettingsParams(disableStandardEntries: StandardEntries(plurals: [
                    "fr": false,
                    "en": false,
                    "ru": true,
                ]))
            )
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// setSettingsAttributesForFaceting
    func snippetForSetSettings() async throws {
        // >SEPARATOR setSettings setSettingsAttributesForFaceting
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: [
                "actor",
                "filterOnly(category)",
                "searchable(publisher)",
            ])
        )
        // SEPARATOR<
    }

    /// Snippet for the updateApiKey method.
    ///
    /// updateApiKey
    func snippetForUpdateApiKey() async throws {
        // >SEPARATOR updateApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.updateApiKey(
            key: "myApiKey",
            apiKey: ApiKey(
                acl: [Acl.search, Acl.addObject],
                maxHitsPerQuery: 20,
                maxQueriesPerIPPerHour: 100,
                validity: 300
            )
        )
        // SEPARATOR<
    }
}

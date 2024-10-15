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
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.addApiKey(apiKey: ApiKey(
            acl: [Acl.search, Acl.addObject],
            description: "my new api key",
            maxHitsPerQuery: 20,
            maxQueriesPerIPPerHour: 100,
            validity: 300
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the addOrUpdateObject method.
    ///
    /// addOrUpdateObject
    func snippetForAddOrUpdateObject() async throws {
        // >SEPARATOR addOrUpdateObject default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.addOrUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            body: ["key": "value"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the appendSource method.
    ///
    /// appendSource
    func snippetForAppendSource() async throws {
        // >SEPARATOR appendSource default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.appendSource(source: SearchSource(
            source: "theSource",
            description: "theDescription"
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the assignUserId method.
    ///
    /// assignUserId
    func snippetForAssignUserId() async throws {
        // >SEPARATOR assignUserId default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.assignUserId(
            xAlgoliaUserID: "userID",
            assignUserIdParams: AssignUserIdParams(cluster: "theCluster")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// addObject
    func snippetForBatch() async throws {
        // >SEPARATOR batch addObject
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [
                SearchBatchRequest(action: SearchAction.addObject, body: ["key": "bar", "foo": "1"]),
                SearchBatchRequest(action: SearchAction.addObject, body: ["key": "baz", "foo": "2"]),
            ])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// clear
    func snippetForBatch1() async throws {
        // >SEPARATOR batch clear
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [SearchBatchRequest(
                action: SearchAction.clear,
                body: ["key": "value"]
            )])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// delete
    func snippetForBatch2() async throws {
        // >SEPARATOR batch delete
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [SearchBatchRequest(
                action: SearchAction.delete,
                body: ["key": "value"]
            )])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// deleteObject
    func snippetForBatch3() async throws {
        // >SEPARATOR batch deleteObject
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [SearchBatchRequest(
                action: SearchAction.deleteObject,
                body: ["key": "value"]
            )])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// partialUpdateObject
    func snippetForBatch4() async throws {
        // >SEPARATOR batch partialUpdateObject
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [SearchBatchRequest(
                action: SearchAction.partialUpdateObject,
                body: ["key": "value"]
            )])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// partialUpdateObjectNoCreate
    func snippetForBatch5() async throws {
        // >SEPARATOR batch partialUpdateObjectNoCreate
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [SearchBatchRequest(
                action: SearchAction.partialUpdateObjectNoCreate,
                body: ["key": "value"]
            )])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batch method.
    ///
    /// updateObject
    func snippetForBatch6() async throws {
        // >SEPARATOR batch updateObject
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batch(
            indexName: "<YOUR_INDEX_NAME>",
            batchWriteParams: SearchBatchWriteParams(requests: [SearchBatchRequest(
                action: SearchAction.updateObject,
                body: ["key": "value"]
            )])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batchAssignUserIds method.
    ///
    /// batchAssignUserIds
    func snippetForBatchAssignUserIds() async throws {
        // >SEPARATOR batchAssignUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batchAssignUserIds(
            xAlgoliaUserID: "userID",
            batchAssignUserIdsParams: BatchAssignUserIdsParams(cluster: "theCluster", users: ["user1", "user2"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// replace
    func snippetForBatchDictionaryEntries() async throws {
        // >SEPARATOR batchDictionaryEntries replace
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// delete
    func snippetForBatchDictionaryEntries1() async throws {
        // >SEPARATOR batchDictionaryEntries delete
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batchDictionaryEntries(
            dictionaryName: DictionaryType.plurals,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
                clearExistingDictionaryEntries: true,
                requests: [BatchDictionaryEntriesRequest(
                    action: DictionaryAction.deleteEntry,
                    body: DictionaryEntry(objectID: "1")
                )]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the batchDictionaryEntries method.
    ///
    /// append
    func snippetForBatchDictionaryEntries2() async throws {
        // >SEPARATOR batchDictionaryEntries append
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the browse method.
    ///
    /// browse with minimal parameters
    func snippetForBrowse() async throws {
        // >SEPARATOR browse default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: BrowseResponse<Hit> = try await client.browse(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the clearObjects method.
    ///
    /// clearObjects
    func snippetForClearObjects() async throws {
        // >SEPARATOR clearObjects default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.clearObjects(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the clearRules method.
    ///
    /// clearRules
    func snippetForClearRules() async throws {
        // >SEPARATOR clearRules default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.clearRules(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the clearSynonyms method.
    ///
    /// clearSynonyms
    func snippetForClearSynonyms() async throws {
        // >SEPARATOR clearSynonyms default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.clearSynonyms(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteApiKey method.
    ///
    /// deleteApiKey
    func snippetForDeleteApiKey() async throws {
        // >SEPARATOR deleteApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteApiKey(key: "myTestApiKey")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteBy method.
    ///
    /// deleteBy
    func snippetForDeleteBy() async throws {
        // >SEPARATOR deleteBy default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteBy(
            indexName: "<YOUR_INDEX_NAME>",
            deleteByParams: DeleteByParams(filters: "brand:brandName")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteIndex method.
    ///
    /// deleteIndex
    func snippetForDeleteIndex() async throws {
        // >SEPARATOR deleteIndex default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteIndex(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteObject method.
    ///
    /// deleteObject
    func snippetForDeleteObject() async throws {
        // >SEPARATOR deleteObject default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteObject(indexName: "<YOUR_INDEX_NAME>", objectID: "uniqueID")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteObjects method.
    ///
    /// call deleteObjects without error
    func snippetForDeleteObjects() async throws {
        // >SEPARATOR deleteObjects default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteObjects(indexName: "<YOUR_INDEX_NAME>", objectIDs: ["1", "2"])
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteRule method.
    ///
    /// delete rule simple case
    func snippetForDeleteRule() async throws {
        // >SEPARATOR deleteRule default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteRule(indexName: "<YOUR_INDEX_NAME>", objectID: "id1")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteSource method.
    ///
    /// deleteSource
    func snippetForDeleteSource() async throws {
        // >SEPARATOR deleteSource default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteSource(source: "theSource")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteSynonym method.
    ///
    /// deleteSynonym
    func snippetForDeleteSynonym() async throws {
        // >SEPARATOR deleteSynonym default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteSynonym(indexName: "<YOUR_INDEX_NAME>", objectID: "id1")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// generate secured api key basic
    func snippetForGenerateSecuredApiKey() async throws {
        // >SEPARATOR generateSecuredApiKey generate secured api key basic
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
            restrictions: SecuredApiKeyRestrictions(validUntil: Int64(2_524_604_400), restrictIndices: ["Movies"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// generate secured api key with searchParams
    func snippetForGenerateSecuredApiKey1() async throws {
        // >SEPARATOR generateSecuredApiKey generate secured api key with searchParams
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
            restrictions: SecuredApiKeyRestrictions(
                searchParams: SearchSearchParamsObject(
                    query: "batman",
                    aroundRadius: SearchAroundRadius.searchAroundRadiusAll(SearchAroundRadiusAll.all),
                    hitsPerPage: 10,
                    typoTolerance: SearchTypoTolerance.searchTypoToleranceEnum(SearchTypoToleranceEnum.strict),
                    mode: SearchMode.neuralSearch,
                    optionalWords: ["one", "two"]
                ),
                filters: "category:Book OR category:Ebook AND _tags:published",
                validUntil: Int64(2_524_604_400),
                restrictIndices: ["Movies", "cts_e2e_settings"],
                restrictSources: "192.168.1.0/24",
                userToken: "user123"
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getApiKey method.
    ///
    /// getApiKey
    func snippetForGetApiKey() async throws {
        // >SEPARATOR getApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getApiKey(key: "myTestApiKey")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getAppTask method.
    ///
    /// getAppTask
    func snippetForGetAppTask() async throws {
        // >SEPARATOR getAppTask default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getAppTask(taskID: Int64(123))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getDictionaryLanguages method.
    ///
    /// get getDictionaryLanguages
    func snippetForGetDictionaryLanguages() async throws {
        // >SEPARATOR getDictionaryLanguages default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getDictionaryLanguages()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getDictionarySettings method.
    ///
    /// get getDictionarySettings results
    func snippetForGetDictionarySettings() async throws {
        // >SEPARATOR getDictionarySettings default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getDictionarySettings()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getLogs method.
    ///
    /// getLogs with minimal parameters
    func snippetForGetLogs() async throws {
        // >SEPARATOR getLogs default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getLogs()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getObject method.
    ///
    /// getObject
    func snippetForGetObject() async throws {
        // >SEPARATOR getObject default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToRetrieve: ["attr1", "attr2"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getObjects method.
    ///
    /// getObjects
    func snippetForGetObjects() async throws {
        // >SEPARATOR getObjects default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: GetObjectsResponse<Hit> = try await client
            .getObjects(getObjectsParams: GetObjectsParams(requests: [GetObjectsRequest(
                attributesToRetrieve: ["attr1", "attr2"],
                objectID: "uniqueID",
                indexName: "<YOUR_INDEX_NAME>"
            )]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getRule method.
    ///
    /// getRule
    func snippetForGetRule() async throws {
        // >SEPARATOR getRule default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getRule(indexName: "<YOUR_INDEX_NAME>", objectID: "qr-1725004648916")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSettings method.
    ///
    /// getSettings
    func snippetForGetSettings() async throws {
        // >SEPARATOR getSettings default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getSettings(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSources method.
    ///
    /// getSources
    func snippetForGetSources() async throws {
        // >SEPARATOR getSources default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getSources()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSynonym method.
    ///
    /// getSynonym
    func snippetForGetSynonym() async throws {
        // >SEPARATOR getSynonym default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getSynonym(indexName: "<YOUR_INDEX_NAME>", objectID: "id1")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTask method.
    ///
    /// getTask
    func snippetForGetTask() async throws {
        // >SEPARATOR getTask default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getTask(indexName: "<YOUR_INDEX_NAME>", taskID: Int64(123))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTopUserIds method.
    ///
    /// getTopUserIds
    func snippetForGetTopUserIds() async throws {
        // >SEPARATOR getTopUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getTopUserIds()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getUserId method.
    ///
    /// getUserId
    func snippetForGetUserId() async throws {
        // >SEPARATOR getUserId default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getUserId(userID: "uniqueID")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the hasPendingMappings method.
    ///
    /// hasPendingMappings with minimal parameters
    func snippetForHasPendingMappings() async throws {
        // >SEPARATOR hasPendingMappings default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.hasPendingMappings()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the indexExists method.
    ///
    /// indexExists
    func snippetForIndexExists() async throws {
        // >SEPARATOR indexExists indexExists
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.indexExists(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the indexExists method.
    ///
    /// indexNotExists
    func snippetForIndexExists1() async throws {
        // >SEPARATOR indexExists indexNotExists
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.indexExists(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the indexExists method.
    ///
    /// indexExistsWithError
    func snippetForIndexExists2() async throws {
        // >SEPARATOR indexExists indexExistsWithError
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.indexExists(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listApiKeys method.
    ///
    /// listApiKeys
    func snippetForListApiKeys() async throws {
        // >SEPARATOR listApiKeys default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listApiKeys()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listClusters method.
    ///
    /// listClusters
    func snippetForListClusters() async throws {
        // >SEPARATOR listClusters default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listClusters()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listIndices method.
    ///
    /// listIndices with minimal parameters
    func snippetForListIndices() async throws {
        // >SEPARATOR listIndices default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listIndices()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listUserIds method.
    ///
    /// listUserIds with minimal parameters
    func snippetForListUserIds() async throws {
        // >SEPARATOR listUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listUserIds()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch
    func snippetForMultipleBatch() async throws {
        // >SEPARATOR multipleBatch default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.multipleBatch(batchParams: BatchParams(requests: [MultipleBatchRequest(
            action: SearchAction.addObject,
            body: ["key": "value"],
            indexName: "<YOUR_INDEX_NAME>"
        )]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// scopes
    func snippetForOperationIndex() async throws {
        // >SEPARATOR operationIndex scopes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.operationIndex(
            indexName: "<SOURCE_INDEX_NAME>",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.move,
                destination: "<DESTINATION_INDEX_NAME>",
                scope: [ScopeType.rules, ScopeType.settings]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// copy
    func snippetForOperationIndex1() async throws {
        // >SEPARATOR operationIndex copy
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.operationIndex(
            indexName: "<SOURCE_INDEX_NAME>",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.copy,
                destination: "<DESTINATION_INDEX_NAME>"
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the operationIndex method.
    ///
    /// move
    func snippetForOperationIndex2() async throws {
        // >SEPARATOR operationIndex move
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.operationIndex(
            indexName: "<SOURCE_INDEX_NAME>",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.move,
                destination: "<DESTINATION_INDEX_NAME>"
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// Partial update with a new value for a string attribute
    func snippetForPartialUpdateObject() async throws {
        // >SEPARATOR partialUpdateObject default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["attributeId": "new value"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObjects method.
    ///
    /// call partialUpdateObjects with createIfNotExists=true
    func snippetForPartialUpdateObjects() async throws {
        // >SEPARATOR partialUpdateObjects call partialUpdateObjects with createIfNotExists=true
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]],
            createIfNotExists: true
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObjects method.
    ///
    /// call partialUpdateObjects with createIfNotExists=false
    func snippetForPartialUpdateObjects1() async throws {
        // >SEPARATOR partialUpdateObjects call partialUpdateObjects with createIfNotExists=false
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [["objectID": "3", "name": "Cyril"], ["objectID": "4", "name": "David"]],
            createIfNotExists: false
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the removeUserId method.
    ///
    /// removeUserId
    func snippetForRemoveUserId() async throws {
        // >SEPARATOR removeUserId default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.removeUserId(userID: "uniqueID")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the replaceAllObjects method.
    ///
    /// call replaceAllObjects without error
    func snippetForReplaceAllObjects() async throws {
        // >SEPARATOR replaceAllObjects default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.replaceAllObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [
                ["objectID": "1", "name": "Adam"],
                ["objectID": "2", "name": "Benoit"],
                ["objectID": "3", "name": "Cyril"],
                ["objectID": "4", "name": "David"],
                ["objectID": "5", "name": "Eva"],
                ["objectID": "6", "name": "Fiona"],
                ["objectID": "7", "name": "Gael"],
                ["objectID": "8", "name": "Hugo"],
                ["objectID": "9", "name": "Igor"],
                ["objectID": "10", "name": "Julia"],
            ],
            batchSize: 3
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the replaceSources method.
    ///
    /// replaceSources
    func snippetForReplaceSources() async throws {
        // >SEPARATOR replaceSources default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.replaceSources(source: [SearchSource(
            source: "theSource",
            description: "theDescription"
        )])
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the restoreApiKey method.
    ///
    /// restoreApiKey
    func snippetForRestoreApiKey() async throws {
        // >SEPARATOR restoreApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.restoreApiKey(key: "ALGOLIA_API_KEY")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveObject method.
    ///
    /// saveObject
    func snippetForSaveObject() async throws {
        // >SEPARATOR saveObject default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveObject(
            indexName: "<YOUR_INDEX_NAME>",
            body: ["objectID": "id", "test": "val"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveObjects method.
    ///
    /// call saveObjects without error
    func snippetForSaveObjects() async throws {
        // >SEPARATOR saveObjects call saveObjects without error
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveObjects method.
    ///
    /// saveObjects should report errors
    func snippetForSaveObjects1() async throws {
        // >SEPARATOR saveObjects saveObjects should report errors
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// saveRule with minimal parameters
    func snippetForSaveRule() async throws {
        // >SEPARATOR saveRule default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "id1",
            rule: Rule(
                objectID: "id1",
                conditions: [SearchCondition(pattern: "apple", anchoring: SearchAnchoring.contains)]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules with minimal parameters
    func snippetForSaveRules() async throws {
        // >SEPARATOR saveRules default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveSynonym method.
    ///
    /// saveSynonym
    func snippetForSaveSynonym() async throws {
        // >SEPARATOR saveSynonym default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveSynonym(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "id1",
            synonymHit: SynonymHit(objectID: "id1", type: SynonymType.synonym, synonyms: ["car", "vehicule", "auto"]),
            forwardToReplicas: true
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveSynonyms method.
    ///
    /// saveSynonyms
    func snippetForSaveSynonyms() async throws {
        // >SEPARATOR saveSynonyms default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// withHitsPerPage
    func snippetForSearch() async throws {
        // >SEPARATOR search withHitsPerPage
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                hitsPerPage: 50,
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// filterOnly
    func snippetForSearch1() async throws {
        // >SEPARATOR search filterOnly
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                filters: "actor:Scarlett Johansson",
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// filterOr
    func snippetForSearch2() async throws {
        // >SEPARATOR search filterOr
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                filters: "actor:Tom Cruise OR actor:Scarlett Johansson",
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// filterNot
    func snippetForSearch3() async throws {
        // >SEPARATOR search filterNot
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                filters: "NOT actor:Nicolas Cage",
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// retrieveFacets
    func snippetForSearch4() async throws {
        // >SEPARATOR search retrieveFacets
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                facets: ["author", "genre"],
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// retrieveFacetsWildcard
    func snippetForSearch5() async throws {
        // >SEPARATOR search retrieveFacetsWildcard
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "<YOUR_QUERY>",
                facets: ["*"],
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchDictionaryEntries method.
    ///
    /// get searchDictionaryEntries results with minimal parameters
    func snippetForSearchDictionaryEntries() async throws {
        // >SEPARATOR searchDictionaryEntries default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchDictionaryEntries(
            dictionaryName: DictionaryType.stopwords,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(query: "about")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// get searchForFacetValues results with minimal parameters
    func snippetForSearchForFacetValues() async throws {
        // >SEPARATOR searchForFacetValues default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(indexName: "<YOUR_INDEX_NAME>", facetName: "facetName")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchRules method.
    ///
    /// searchRules
    func snippetForSearchRules() async throws {
        // >SEPARATOR searchRules default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchRules(
            indexName: "<YOUR_INDEX_NAME>",
            searchRulesParams: SearchRulesParams(query: "zorro")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search with minimal parameters
    func snippetForSearchSingleIndex() async throws {
        // >SEPARATOR searchSingleIndex default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSynonyms method.
    ///
    /// searchSynonyms with minimal parameters
    func snippetForSearchSynonyms() async throws {
        // >SEPARATOR searchSynonyms default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchSynonyms(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchUserIds method.
    ///
    /// searchUserIds
    func snippetForSearchUserIds() async throws {
        // >SEPARATOR searchUserIds default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchUserIds(searchUserIdsParams: SearchUserIdsParams(
            query: "test",
            clusterName: "theClusterName",
            page: 5,
            hitsPerPage: 10
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setDictionarySettings method.
    ///
    /// get setDictionarySettings results with minimal parameters
    func snippetForSetDictionarySettings() async throws {
        // >SEPARATOR setDictionarySettings default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .setDictionarySettings(
                dictionarySettingsParams: DictionarySettingsParams(disableStandardEntries: StandardEntries(plurals: [
                    "fr": false,
                    "en": false,
                    "ru": true,
                ]))
            )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// setSettingsAttributesForFaceting
    func snippetForSetSettings() async throws {
        // >SEPARATOR setSettings default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: [
                "actor",
                "filterOnly(category)",
                "searchable(publisher)",
            ])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateApiKey method.
    ///
    /// updateApiKey
    func snippetForUpdateApiKey() async throws {
        // >SEPARATOR updateApiKey default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateApiKey(
            key: "ALGOLIA_API_KEY",
            apiKey: ApiKey(
                acl: [Acl.search, Acl.addObject],
                maxHitsPerQuery: 20,
                maxQueriesPerIPPerHour: 100,
                validity: 300
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the waitForApiKey method.
    ///
    /// wait for api key helper - add
    func snippetForWaitForApiKey() async throws {
        // >SEPARATOR waitForApiKey wait for api key helper - add
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.waitForApiKey(
            key: "api-key-add-operation-test-swift",
            operation: ApiKeyOperation.add
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the waitForApiKey method.
    ///
    /// wait for api key - update
    func snippetForWaitForApiKey1() async throws {
        // >SEPARATOR waitForApiKey wait for api key - update
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.waitForApiKey(
            key: "api-key-update-operation-test-swift",
            operation: ApiKeyOperation.update,
            apiKey: ApiKey(
                acl: [Acl.search, Acl.addObject, Acl.deleteObject],
                description: "my updated api key",
                indexes: ["Movies", "Books"],
                maxHitsPerQuery: 20,
                maxQueriesPerIPPerHour: 95,
                referers: ["*google.com", "*algolia.com"],
                validity: 305
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the waitForApiKey method.
    ///
    /// wait for api key - delete
    func snippetForWaitForApiKey2() async throws {
        // >SEPARATOR waitForApiKey wait for api key - delete
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.waitForApiKey(
            key: "api-key-delete-operation-test-swift",
            operation: ApiKeyOperation.delete
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the waitForAppTask method.
    ///
    /// wait for an application-level task
    func snippetForWaitForAppTask() async throws {
        // >SEPARATOR waitForAppTask default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.waitForAppTask(taskID: Int64(123))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the waitForTask method.
    ///
    /// wait for task
    func snippetForWaitForTask() async throws {
        // >SEPARATOR waitForTask default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.waitForTask(indexName: "<YOUR_INDEX_NAME>", taskID: Int64(123))
        // >LOG
        // SEPARATOR<
    }
}

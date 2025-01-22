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
    /// simple
    func snippetForAssignUserId() async throws {
        // >SEPARATOR assignUserId default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.assignUserId(
            xAlgoliaUserID: "user42",
            assignUserIdParams: AssignUserIdParams(cluster: "d4242-eu")
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
    /// api key basic
    func snippetForGenerateSecuredApiKey() async throws {
        // >SEPARATOR generateSecuredApiKey api key basic
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
    /// with searchParams
    func snippetForGenerateSecuredApiKey1() async throws {
        // >SEPARATOR generateSecuredApiKey with searchParams
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
                    optionalWords: SearchOptionalWords.arrayOfString(["one", "two"])
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

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// with filters
    func snippetForGenerateSecuredApiKey2() async throws {
        // >SEPARATOR generateSecuredApiKey with filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
            restrictions: SecuredApiKeyRestrictions(
                filters: "user:user42 AND user:public AND (visible_by:John OR visible_by:group/Finance)"
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// with visible_by filter
    func snippetForGenerateSecuredApiKey3() async throws {
        // >SEPARATOR generateSecuredApiKey with visible_by filter
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
            restrictions: SecuredApiKeyRestrictions(filters: "visible_by:group/Finance")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// with userID
    func snippetForGenerateSecuredApiKey4() async throws {
        // >SEPARATOR generateSecuredApiKey with userID
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
            restrictions: SecuredApiKeyRestrictions(userToken: "user42")
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
    /// Partial update with a new value for an object attribute
    func snippetForPartialUpdateObject() async throws {
        // >SEPARATOR partialUpdateObject Partial update with a new value for an object attribute
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["attributeId": ["nested": "value"]]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// with visible_by filter
    func snippetForPartialUpdateObject1() async throws {
        // >SEPARATOR partialUpdateObject with visible_by filter
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["visible_by": ["Angela", "group/Finance", "group/Shareholders"]]
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
        // >SEPARATOR replaceAllObjects call replaceAllObjects without error
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

    /// Snippet for the replaceAllObjects method.
    ///
    /// call replaceAllObjects with partial scopes
    func snippetForReplaceAllObjects1() async throws {
        // >SEPARATOR replaceAllObjects call replaceAllObjects with partial scopes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.replaceAllObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]],
            batchSize: 77,
            scopes: [ScopeType.settings, ScopeType.synonyms]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the replaceAllObjects method.
    ///
    /// replaceAllObjects should cleanup on failure
    func snippetForReplaceAllObjects2() async throws {
        // >SEPARATOR replaceAllObjects replaceAllObjects should cleanup on failure
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.replaceAllObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [
                ["objectID": "fine", "body": "small obj"],
                ["objectID": "toolarge", "body": "something bigger than 10KB"],
            ]
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

    /// Snippet for the saveObjects method.
    ///
    /// saveObjectsPlaylist
    func snippetForSaveObjects2() async throws {
        // >SEPARATOR saveObjects saveObjectsPlaylist
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [[
                "objectID": "1",
                "visibility": "public",
                "name": "Hot 100 Billboard Charts",
                "playlistId": "d3e8e8f3-0a4f-4b7d-9b6b-7e8f4e8e3a0f",
                "createdAt": "1500240452",
            ]]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveObjects method.
    ///
    /// saveObjectsPublicUser
    func snippetForSaveObjects3() async throws {
        // >SEPARATOR saveObjects saveObjectsPublicUser
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [[
                "objectID": "1",
                "visibility": "public",
                "name": "Hot 100 Billboard Charts",
                "playlistId": "d3e8e8f3-0a4f-4b7d-9b6b-7e8f4e8e3a0f",
                "createdAt": "1500240452",
            ]]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// b2b catalog
    func snippetForSaveRule() async throws {
        // >SEPARATOR saveRule b2b catalog
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "article-rule",
            rule: Rule(
                objectID: "article-rule",
                conditions: [SearchCondition(pattern: "article", anchoring: SearchAnchoring.startsWith)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    restrictSearchableAttributes: ["title", "book_id"],
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(edits: [SearchEdit(
                            type: SearchEditType.remove,
                            delete: "article"
                        )]))
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// merchandising and promoting
    func snippetForSaveRule1() async throws {
        // >SEPARATOR saveRule merchandising and promoting
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "director-rule",
            rule: Rule(
                objectID: "director-rule",
                conditions: [SearchCondition(
                    pattern: "{facet:director} director",
                    anchoring: SearchAnchoring.contains
                )],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    restrictSearchableAttributes: ["title", "book_id"],
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(edits: [SearchEdit(
                            type: SearchEditType.remove,
                            delete: "director"
                        )])),
                    automaticFacetFilters: SearchAutomaticFacetFilters
                        .arrayOfSearchAutomaticFacetFilter([SearchAutomaticFacetFilter(facet: "director")])
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// harry potter
    func snippetForSaveRule2() async throws {
        // >SEPARATOR saveRule harry potter
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "harry-potter-rule",
            rule: Rule(
                objectID: "harry-potter-rule",
                conditions: [SearchCondition(pattern: "harry potter", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(userData: ["promo_content": "20% OFF on all Harry Potter books!"])
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// merchandising empty query
    func snippetForSaveRule3() async throws {
        // >SEPARATOR saveRule merchandising empty query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "clearance-category-filter",
            rule: Rule(
                objectID: "clearance-category-filter",
                conditions: [SearchCondition(pattern: "", anchoring: SearchAnchoring.`is`, context: "landing")],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    optionalFilters: SearchOptionalFilters
                        .string("clearance:true")
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// redirect
    func snippetForSaveRule4() async throws {
        // >SEPARATOR saveRule redirect
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "redirect-help-rule",
            rule: Rule(
                objectID: "redirect-help-rule",
                conditions: [SearchCondition(pattern: "help", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(userData: ["redirect": "https://www.algolia.com/support"])
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote some results over others
    func snippetForSaveRule5() async throws {
        // >SEPARATOR saveRule promote some results over others
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "tomato-fruit",
            rule: Rule(
                objectID: "tomato-fruit",
                conditions: [SearchCondition(pattern: "tomato", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    optionalFilters: SearchOptionalFilters
                        .string("food_group:fruit")
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote several hits
    func snippetForSaveRule6() async throws {
        // >SEPARATOR saveRule promote several hits
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "Promote-Apple-Newest",
            rule: Rule(
                objectID: "Promote-Apple-Newest",
                conditions: [SearchCondition(pattern: "apple", anchoring: SearchAnchoring.`is`)],
                consequence: SearchConsequence(promote: [SearchPromote.searchPromoteObjectIDs(SearchPromoteObjectIDs(
                    objectIDs: ["iPhone-12345", "watch-123"],
                    position: 0
                ))])
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote newest release
    func snippetForSaveRule7() async throws {
        // >SEPARATOR saveRule promote newest release
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "Promote-iPhone-X",
            rule: Rule(
                objectID: "Promote-iPhone-X",
                conditions: [SearchCondition(pattern: "iPhone", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(promote: [SearchPromote.searchPromoteObjectID(SearchPromoteObjectID(
                    objectID: "iPhone-12345",
                    position: 0
                ))])
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote single item
    func snippetForSaveRule8() async throws {
        // >SEPARATOR saveRule promote single item
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "promote-harry-potter-box-set",
            rule: Rule(
                objectID: "promote-harry-potter-box-set",
                conditions: [SearchCondition(pattern: "Harry Potter", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(promote: [SearchPromote.searchPromoteObjectID(SearchPromoteObjectID(
                    objectID: "HP-12345",
                    position: 0
                ))])
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// limit search results
    func snippetForSaveRule9() async throws {
        // >SEPARATOR saveRule limit search results
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "article-rule",
            rule: Rule(
                objectID: "article-rule",
                conditions: [SearchCondition(pattern: "article", anchoring: SearchAnchoring.startsWith)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    restrictSearchableAttributes: ["title", "book_id"],
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(edits: [SearchEdit(
                            type: SearchEditType.remove,
                            delete: "article"
                        )]))
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// query match
    func snippetForSaveRule10() async throws {
        // >SEPARATOR saveRule query match
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "tagged-brand-rule",
            rule: Rule(
                objectID: "tagged-brand-rule",
                conditions: [SearchCondition(
                    pattern: "brand: {facet:brand}",
                    anchoring: SearchAnchoring.contains,
                    alternatives: false
                )],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    query: SearchConsequenceQuery.searchConsequenceQueryObject(SearchConsequenceQueryObject(remove: [
                        "brand:",
                        "{facet:brand}",
                    ])),
                    automaticFacetFilters: SearchAutomaticFacetFilters
                        .arrayOfSearchAutomaticFacetFilter([SearchAutomaticFacetFilter(facet: "brand")])
                )),
                description: "filter on brand: {brand}"
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// dynamic filtering
    func snippetForSaveRule11() async throws {
        // >SEPARATOR saveRule dynamic filtering
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "color-facets",
            rule: Rule(
                objectID: "color-facets",
                conditions: [SearchCondition(pattern: "{facet:color}")],
                consequence: SearchConsequence(
                    params: SearchConsequenceParams(
                        automaticFacetFilters: SearchAutomaticFacetFilters
                            .arrayOfSearchAutomaticFacetFilter([SearchAutomaticFacetFilter(facet: "color")])
                    )
                )
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// hide hits
    func snippetForSaveRule12() async throws {
        // >SEPARATOR saveRule hide hits
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "hide-12345",
            rule: Rule(
                objectID: "hide-12345",
                conditions: [SearchCondition(pattern: "cheap", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(hide: [SearchConsequenceHide(objectID: "to-hide-12345")])
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// one rule per facet
    func snippetForSaveRule13() async throws {
        // >SEPARATOR saveRule one rule per facet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "red-color",
            rule: Rule(
                objectID: "red-color",
                conditions: [SearchCondition(pattern: "red", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    filters: "color:red",
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(remove: ["red"]))
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// numerical filters
    func snippetForSaveRule14() async throws {
        // >SEPARATOR saveRule numerical filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "cheap",
            rule: Rule(
                objectID: "cheap",
                conditions: [SearchCondition(pattern: "cheap", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    filters: "price < 10",
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(remove: ["cheap"]))
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// negative filters
    func snippetForSaveRule15() async throws {
        // >SEPARATOR saveRule negative filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "gluten-free-rule",
            rule: Rule(
                objectID: "gluten-free-rule",
                conditions: [SearchCondition(pattern: "gluten-free", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    filters: "NOT allergens:gluten",
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(edits: [SearchEdit(
                            type: SearchEditType.remove,
                            delete: "gluten-free"
                        )]))
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// positive filters
    func snippetForSaveRule16() async throws {
        // >SEPARATOR saveRule positive filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "diet-rule",
            rule: Rule(
                objectID: "diet-rule",
                conditions: [SearchCondition(pattern: "diet", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    filters: "'low-carb' OR 'low-fat'",
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(edits: [SearchEdit(
                            type: SearchEditType.remove,
                            delete: "diet"
                        )]))
                ))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// conditionless
    func snippetForSaveRule17() async throws {
        // >SEPARATOR saveRule conditionless
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "diet-rule",
            rule: Rule(
                objectID: "diet-rule",
                consequence: SearchConsequence(params: SearchConsequenceParams(
                    filters: "'low-carb' OR 'low-fat'",
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(edits: [SearchEdit(
                            type: SearchEditType.remove,
                            delete: "diet"
                        )]))
                ))
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
                    conditions: [SearchCondition(pattern: "smartphone", anchoring: SearchAnchoring.contains)],
                    consequence: SearchConsequence(params: SearchConsequenceParams(filters: "brand:apple"))
                ),
                Rule(
                    objectID: "a-second-rule-id",
                    conditions: [SearchCondition(pattern: "apple", anchoring: SearchAnchoring.contains)],
                    consequence: SearchConsequence(params: SearchConsequenceParams(filters: "brand:samsung"))
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
    /// search with searchParams
    func snippetForSearchSingleIndex() async throws {
        // >SEPARATOR searchSingleIndex search with searchParams
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "myQuery",
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("tags:algolia")])
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// query
    func snippetForSearchSingleIndex1() async throws {
        // >SEPARATOR searchSingleIndex query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "phone"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filters
    func snippetForSearchSingleIndex2() async throws {
        // >SEPARATOR searchSingleIndex filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(filters: "country:US AND price.gross < 2.0"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// distinct
    func snippetForSearchSingleIndex3() async throws {
        // >SEPARATOR searchSingleIndex distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(distinct: SearchDistinct.bool(true)))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersNumeric
    func snippetForSearchSingleIndex4() async throws {
        // >SEPARATOR searchSingleIndex filtersNumeric
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(filters: "price < 10"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersTimestamp
    func snippetForSearchSingleIndex5() async throws {
        // >SEPARATOR searchSingleIndex filtersTimestamp
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(
                    SearchSearchParamsObject(filters: "NOT date_timestamp:1514764800 TO 1546300799")
                )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersSumOrFiltersScoresFalse
    func snippetForSearchSingleIndex6() async throws {
        // >SEPARATOR searchSingleIndex filtersSumOrFiltersScoresFalse
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                filters: "(company:Google<score=3> OR company:Amazon<score=2> OR company:Facebook<score=1>)",
                sumOrFiltersScores: false
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersSumOrFiltersScoresTrue
    func snippetForSearchSingleIndex7() async throws {
        // >SEPARATOR searchSingleIndex filtersSumOrFiltersScoresTrue
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                filters: "(company:Google<score=3> OR company:Amazon<score=2> OR company:Facebook<score=1>)",
                sumOrFiltersScores: true
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersStephenKing
    func snippetForSearchSingleIndex8() async throws {
        // >SEPARATOR searchSingleIndex filtersStephenKing
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(filters: "author:\"Stephen King\""))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersNotTags
    func snippetForSearchSingleIndex9() async throws {
        // >SEPARATOR searchSingleIndex filtersNotTags
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(filters: "NOT _tags:non-fiction"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersList
    func snippetForSearchSingleIndex10() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersList
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    facetFilters: SearchFacetFilters
                        .arrayOfSearchFacetFilters([
                            SearchFacetFilters.string("publisher:Penguin"),
                            SearchFacetFilters.arrayOfSearchFacetFilters([
                                SearchFacetFilters.string("author:Stephen King"),
                                SearchFacetFilters.string("genre:Horror"),
                            ]),
                        ])
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersNeg
    func snippetForSearchSingleIndex11() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersNeg
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    facetFilters: SearchFacetFilters
                        .string("category:-Ebook")
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersAndFacetFilters
    func snippetForSearchSingleIndex12() async throws {
        // >SEPARATOR searchSingleIndex filtersAndFacetFilters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                filters: "(author:\"Stephen King\" OR genre:\"Horror\")",
                facetFilters: SearchFacetFilters
                    .arrayOfSearchFacetFilters([SearchFacetFilters.string("publisher:Penguin")])
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// aroundLatLng
    func snippetForSearchSingleIndex13() async throws {
        // >SEPARATOR searchSingleIndex aroundLatLng
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(aroundLatLng: "40.71, -74.01"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// aroundLatLngViaIP
    func snippetForSearchSingleIndex14() async throws {
        // >SEPARATOR searchSingleIndex aroundLatLngViaIP
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(aroundLatLngViaIP: true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// aroundRadius
    func snippetForSearchSingleIndex15() async throws {
        // >SEPARATOR searchSingleIndex aroundRadius
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                aroundLatLng: "40.71, -74.01",
                aroundRadius: SearchAroundRadius.int(1_000_000)
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// insideBoundingBox
    func snippetForSearchSingleIndex16() async throws {
        // >SEPARATOR searchSingleIndex insideBoundingBox
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    insideBoundingBox: SearchInsideBoundingBox
                        .arrayOfArrayOfDouble([[
                            49.067996905313834,
                            65.73828125,
                            25.905859247243498,
                            128.8046875,
                        ]])
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// insidePolygon
    func snippetForSearchSingleIndex17() async throws {
        // >SEPARATOR searchSingleIndex insidePolygon
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(insidePolygon: [[
                42.01,
                -124.31,
                48.835509470063045,
                -124.40453125000005,
                45.01082951668149,
                -65.95726562500005,
                31.247243545293433,
                -81.06578125000004,
                25.924152577235226,
                -97.68234374999997,
                32.300311895879545,
                -117.54828125,
            ]]))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// insidePolygon
    func snippetForSearchSingleIndex18() async throws {
        // >SEPARATOR searchSingleIndex insidePolygon
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(insidePolygon: [[
                42.01,
                -124.31,
                48.835509470063045,
                -124.40453125000005,
                45.01082951668149,
                -65.95726562500005,
                31.247243545293433,
                -81.06578125000004,
                25.924152577235226,
                -97.68234374999997,
                32.300311895879545,
                -117.54828125,
            ]]))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// optionalFilters
    func snippetForSearchSingleIndex19() async throws {
        // >SEPARATOR searchSingleIndex optionalFilters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    optionalFilters: SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([SearchOptionalFilters.string("can_deliver_quickly:true")])
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// optionalFiltersMany
    func snippetForSearchSingleIndex20() async throws {
        // >SEPARATOR searchSingleIndex optionalFiltersMany
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    optionalFilters: SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([
                            SearchOptionalFilters.string("brand:Apple<score=3>"),
                            SearchOptionalFilters.string("brand:Samsung<score=2>"),
                            SearchOptionalFilters.string("brand:-Huawei"),
                        ])
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// optionalFiltersSimple
    func snippetForSearchSingleIndex21() async throws {
        // >SEPARATOR searchSingleIndex optionalFiltersSimple
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    optionalFilters: SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([
                            SearchOptionalFilters.string("brand:Apple<score=2>"),
                            SearchOptionalFilters.string("type:tablet"),
                        ])
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// restrictSearchableAttributes
    func snippetForSearchSingleIndex22() async throws {
        // >SEPARATOR searchSingleIndex restrictSearchableAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(restrictSearchableAttributes: ["title_fr"]))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// getRankingInfo
    func snippetForSearchSingleIndex23() async throws {
        // >SEPARATOR searchSingleIndex getRankingInfo
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(getRankingInfo: true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// clickAnalytics
    func snippetForSearchSingleIndex24() async throws {
        // >SEPARATOR searchSingleIndex clickAnalytics
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(clickAnalytics: true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// clickAnalyticsUserToken
    func snippetForSearchSingleIndex25() async throws {
        // >SEPARATOR searchSingleIndex clickAnalyticsUserToken
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                userToken: "user-1",
                clickAnalytics: true
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enablePersonalization
    func snippetForSearchSingleIndex26() async throws {
        // >SEPARATOR searchSingleIndex enablePersonalization
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                userToken: "user-1",
                enablePersonalization: true
            ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// userToken
    func snippetForSearchSingleIndex27() async throws {
        // >SEPARATOR searchSingleIndex userToken
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(userToken: "user-1"))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// analyticsTag
    func snippetForSearchSingleIndex28() async throws {
        // >SEPARATOR searchSingleIndex analyticsTag
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(analyticsTags: ["YOUR_ANALYTICS_TAG"]))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersUsers
    func snippetForSearchSingleIndex29() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersUsers
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(
                    facetFilters: SearchFacetFilters
                        .arrayOfSearchFacetFilters([
                            SearchFacetFilters.string("user:user42"),
                            SearchFacetFilters.string("user:public"),
                        ])
                ))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// buildTheQuery
    func snippetForSearchSingleIndex30() async throws {
        // >SEPARATOR searchSingleIndex buildTheQuery
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                filters: "categoryPageId: Men's Clothing",
                analyticsTags: ["mens-clothing"],
                hitsPerPage: 50
            ))
        )
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
    /// removeStopWords boolean
    func snippetForSetSettings() async throws {
        // >SEPARATOR setSettings removeStopWords boolean
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(removeStopWords: SearchRemoveStopWords.bool(true)),
            forwardToReplicas: true
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// removeStopWords list of string
    func snippetForSetSettings1() async throws {
        // >SEPARATOR setSettings removeStopWords list of string
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                removeStopWords: SearchRemoveStopWords
                    .arrayOfSearchSupportedLanguage([SearchSupportedLanguage.fr])
            ),
            forwardToReplicas: true
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct company
    func snippetForSetSettings2() async throws {
        // >SEPARATOR setSettings distinct company
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "company", distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct design
    func snippetForSetSettings3() async throws {
        // >SEPARATOR setSettings distinct design
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "design", distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct true
    func snippetForSetSettings4() async throws {
        // >SEPARATOR setSettings distinct true
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct section
    func snippetForSetSettings5() async throws {
        // >SEPARATOR setSettings distinct section
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "section", distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting allergens
    func snippetForSetSettings6() async throws {
        // >SEPARATOR setSettings attributesForFaceting allergens
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["allergens"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting categoryPageId
    func snippetForSetSettings7() async throws {
        // >SEPARATOR setSettings attributesForFaceting categoryPageId
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["searchable(categoryPageId)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// unretrievableAttributes
    func snippetForSetSettings8() async throws {
        // >SEPARATOR setSettings unretrievableAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(unretrievableAttributes: ["visible_by"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting user restricted data
    func snippetForSetSettings9() async throws {
        // >SEPARATOR setSettings attributesForFaceting user restricted data
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["filterOnly(visible_by)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting optional filters
    func snippetForSetSettings10() async throws {
        // >SEPARATOR setSettings attributesForFaceting optional filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["can_deliver_quickly", "restaurant"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting redirect index
    func snippetForSetSettings11() async throws {
        // >SEPARATOR setSettings attributesForFaceting redirect index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["query_terms"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting multiple consequences
    func snippetForSetSettings12() async throws {
        // >SEPARATOR setSettings attributesForFaceting multiple consequences
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["director"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting in-depth optional filters
    func snippetForSetSettings13() async throws {
        // >SEPARATOR setSettings attributesForFaceting in-depth optional filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["filterOnly(brand)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// mode neuralSearch
    func snippetForSetSettings14() async throws {
        // >SEPARATOR setSettings mode neuralSearch
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(mode: SearchMode.neuralSearch)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// mode keywordSearch
    func snippetForSetSettings15() async throws {
        // >SEPARATOR setSettings mode keywordSearch
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(mode: SearchMode.keywordSearch)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes same priority
    func snippetForSetSettings16() async throws {
        // >SEPARATOR setSettings searchableAttributes same priority
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["title,comments", "ingredients"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes higher priority
    func snippetForSetSettings17() async throws {
        // >SEPARATOR setSettings searchableAttributes higher priority
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["title", "ingredients"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking retweets
    func snippetForSetSettings18() async throws {
        // >SEPARATOR setSettings customRanking retweets
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(retweets)", "desc(likes)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking boosted
    func snippetForSetSettings19() async throws {
        // >SEPARATOR setSettings customRanking boosted
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(boosted)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking pageviews
    func snippetForSetSettings20() async throws {
        // >SEPARATOR setSettings customRanking pageviews
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(pageviews)", "desc(comments)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking applying search parameters for a specific query
    func snippetForSetSettings21() async throws {
        // >SEPARATOR setSettings customRanking applying search parameters for a specific query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                attributesForFaceting: ["city, country"],
                customRanking: ["desc(nb_airline_liaisons)"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking rounded pageviews
    func snippetForSetSettings22() async throws {
        // >SEPARATOR setSettings customRanking rounded pageviews
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(rounded_pageviews)", "desc(comments)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking price
    func snippetForSetSettings23() async throws {
        // >SEPARATOR setSettings customRanking price
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(price)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking exhaustive
    func snippetForSetSettings24() async throws {
        // >SEPARATOR setSettings ranking exhaustive
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: [
                "desc(price)",
                "typo",
                "geo",
                "words",
                "filters",
                "proximity",
                "attribute",
                "exact",
                "custom",
            ])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking standard replica
    func snippetForSetSettings25() async throws {
        // >SEPARATOR setSettings ranking standard replica
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: ["desc(post_date_timestamp)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking virtual replica
    func snippetForSetSettings26() async throws {
        // >SEPARATOR setSettings ranking virtual replica
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(post_date_timestamp)"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking and ranking sort alphabetically
    func snippetForSetSettings27() async throws {
        // >SEPARATOR setSettings customRanking and ranking sort alphabetically
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                customRanking: ["asc(textual_attribute)"],
                ranking: ["custom", "typo", "geo", "words", "filters", "proximity", "attribute", "exact"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// relevancyStrictness
    func snippetForSetSettings28() async throws {
        // >SEPARATOR setSettings relevancyStrictness
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["asc(textual_attribute)"], relevancyStrictness: 0)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// create replica index
    func snippetForSetSettings29() async throws {
        // >SEPARATOR setSettings create replica index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: ["products_price_desc"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// unlink replica index
    func snippetForSetSettings30() async throws {
        // >SEPARATOR setSettings unlink replica index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: [""])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// forwardToReplicas
    func snippetForSetSettings31() async throws {
        // >SEPARATOR setSettings forwardToReplicas
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["name", "description"]),
            forwardToReplicas: true
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// maxValuesPerFacet
    func snippetForSetSettings32() async throws {
        // >SEPARATOR setSettings maxValuesPerFacet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(maxValuesPerFacet: 1000)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// maxFacetHits
    func snippetForSetSettings33() async throws {
        // >SEPARATOR setSettings maxFacetHits
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(maxFacetHits: 1000)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting complex
    func snippetForSetSettings34() async throws {
        // >SEPARATOR setSettings attributesForFaceting complex
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

    /// Snippet for the setSettings method.
    ///
    /// ranking closest dates
    func snippetForSetSettings35() async throws {
        // >SEPARATOR setSettings ranking closest dates
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: [
                "asc(date_timestamp)",
                "typo",
                "geo",
                "words",
                "filters",
                "proximity",
                "attribute",
                "exact",
                "custom",
            ])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes item variation
    func snippetForSetSettings36() async throws {
        // >SEPARATOR setSettings searchableAttributes item variation
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["design", "type", "color"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes around location
    func snippetForSetSettings37() async throws {
        // >SEPARATOR setSettings searchableAttributes around location
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                searchableAttributes: ["name", "country", "code", "iata_code"],
                customRanking: ["desc(links_count)"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes around location
    func snippetForSetSettings38() async throws {
        // >SEPARATOR setSettings searchableAttributes around location
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                searchableAttributes: ["name", "country", "code", "iata_code"],
                customRanking: ["desc(links_count)"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disableTypoToleranceOnAttributes
    func snippetForSetSettings39() async throws {
        // >SEPARATOR setSettings disableTypoToleranceOnAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disableTypoToleranceOnAttributes: ["serial_number"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesWithCustomRankingsAndAttributesForFaceting
    func snippetForSetSettings40() async throws {
        // >SEPARATOR setSettings searchableAttributesWithCustomRankingsAndAttributesForFaceting
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                attributesForFaceting: ["searchable(brand)", "type", "categories", "price"],
                searchableAttributes: ["brand", "name", "categories", "unordered(description)"],
                customRanking: ["desc(popularity)"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesProductReferenceSuffixes
    func snippetForSetSettings41() async throws {
        // >SEPARATOR setSettings searchableAttributesProductReferenceSuffixes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: [
                "name",
                "product_reference",
                "product_reference_suffixes",
            ])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// queryLanguageAndIgnorePlurals
    func snippetForSetSettings42() async throws {
        // >SEPARATOR setSettings queryLanguageAndIgnorePlurals
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                ignorePlurals: SearchIgnorePlurals.bool(true),
                queryLanguages: [SearchSupportedLanguage.en]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesInMovies
    func snippetForSetSettings43() async throws {
        // >SEPARATOR setSettings searchableAttributesInMovies
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["title_eng", "title_fr", "title_es"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disablePrefixOnAttributes
    func snippetForSetSettings44() async throws {
        // >SEPARATOR setSettings disablePrefixOnAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disablePrefixOnAttributes: ["serial_number"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disableTypoToleranceOnAttributes
    func snippetForSetSettings45() async throws {
        // >SEPARATOR setSettings disableTypoToleranceOnAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disableTypoToleranceOnAttributes: ["serial_number"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesSimpleExample
    func snippetForSetSettings46() async throws {
        // >SEPARATOR setSettings searchableAttributesSimpleExample
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["serial_number"])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesSimpleExampleAlt
    func snippetForSetSettings47() async throws {
        // >SEPARATOR setSettings searchableAttributesSimpleExampleAlt
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["serial_number", "serial_number_suffixes"])
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

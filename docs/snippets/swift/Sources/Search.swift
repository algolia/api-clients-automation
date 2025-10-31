#if canImport(Core)
    import Core
#endif
// >IMPORT
import Search

// IMPORT<

final class SearchClientSnippet {
    /// Snippet for the addApiKey method.
    ///
    /// minimal
    func snippetForAddApiKey() async throws {
        // >SEPARATOR addApiKey minimal
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.addApiKey(apiKey: ApiKey(
            acl: [Acl.search, Acl.addObject],
            description: "my new api key"
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the addApiKey method.
    ///
    /// all
    func snippetForAddApiKey1() async throws {
        // >SEPARATOR addApiKey all
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the assignUserId method.
    ///
    /// simple
    func snippetForAssignUserId() async throws {
        // >SEPARATOR assignUserId simple
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.assignUserId(
            xAlgoliaUserID: "user42",
            assignUserIdParams: AssignUserIdParams(cluster: "d4242-eu")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the assignUserId method.
    ///
    /// it should not encode the userID
    func snippetForAssignUserId1() async throws {
        // >SEPARATOR assignUserId it should not encode the userID
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.assignUserId(
            xAlgoliaUserID: "user id with spaces",
            assignUserIdParams: AssignUserIdParams(cluster: "cluster with spaces")
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the browse method.
    ///
    /// browse with minimal parameters
    func snippetForBrowse() async throws {
        // >SEPARATOR browse browse with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: BrowseResponse<Hit> = try await client.browse(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the browse method.
    ///
    /// browse with search parameters
    func snippetForBrowse1() async throws {
        // >SEPARATOR browse browse with search parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: BrowseResponse<Hit> = try await client.browse(
            indexName: "<YOUR_INDEX_NAME>",
            browseParams: BrowseParams.browseParamsObject(BrowseParamsObject(
                query: "myQuery",
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("tags:algolia")])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the browse method.
    ///
    /// browse allow a cursor in parameters
    func snippetForBrowse2() async throws {
        // >SEPARATOR browse browse allow a cursor in parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: BrowseResponse<Hit> = try await client.browse(
            indexName: "<YOUR_INDEX_NAME>",
            browseParams: BrowseParams.browseParamsObject(BrowseParamsObject(cursor: "test"))
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with all parameters
    func snippetForCustomDelete1() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/all", parameters: ["query": AnyCodable("parameters")])
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet allow get method for a custom path with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with all parameters
    func snippetForCustomGet1() async throws {
        // >SEPARATOR customGet allow get method for a custom path with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// requestOptions should be escaped too
    func snippetForCustomGet2() async throws {
        // >SEPARATOR customGet requestOptions should be escaped too
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("to be overridden")],
            requestOptions: RequestOptions(
                headers: ["x-header-1": "spaces are left alone"],

                queryParameters: ["query": "parameters with space", "and an array": ["array", "with spaces"]]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost allow post method for a custom path with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with all parameters
    func snippetForCustomPost1() async throws {
        // >SEPARATOR customPost allow post method for a custom path with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default query parameters
    func snippetForCustomPost2() async throws {
        // >SEPARATOR customPost requestOptions can override default query parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["query": "myQueryParameter"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges query parameters with default ones
    func snippetForCustomPost3() async throws {
        // >SEPARATOR customPost requestOptions merges query parameters with default ones
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["query2": "myQueryParameter"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default headers
    func snippetForCustomPost4() async throws {
        // >SEPARATOR customPost requestOptions can override default headers
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                headers: ["x-algolia-api-key": "ALGOLIA_API_KEY"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges headers with default ones
    func snippetForCustomPost5() async throws {
        // >SEPARATOR customPost requestOptions merges headers with default ones
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                headers: ["x-algolia-api-key": "ALGOLIA_API_KEY"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts booleans
    func snippetForCustomPost6() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts booleans
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["isItWorking": true]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts integers
    func snippetForCustomPost7() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts integers
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": 2]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of string
    func snippetForCustomPost8() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of string
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": ["b and c", "d"]]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of booleans
    func snippetForCustomPost9() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": [true, true, false]]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of integers
    func snippetForCustomPost10() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": [1, 2]]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut allow put method for a custom path with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with all parameters
    func snippetForCustomPut1() async throws {
        // >SEPARATOR customPut allow put method for a custom path with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the deleteRule method.
    ///
    /// delete rule simple case
    func snippetForDeleteRule() async throws {
        // >SEPARATOR deleteRule delete rule simple case
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteRule(indexName: "<YOUR_INDEX_NAME>", objectID: "id1")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the deleteRule method.
    ///
    /// delete rule with simple characters to encode in objectID
    func snippetForDeleteRule1() async throws {
        // >SEPARATOR deleteRule delete rule with simple characters to encode in objectID
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteRule(indexName: "<YOUR_INDEX_NAME>", objectID: "test/with/slash")
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
                    optionalWords: SearchOptionalWords.arrayOfString([
                        "one",
                        "two",
                    ])
                ),
                filters: "category:Book OR category:Ebook AND _tags:published",
                validUntil: Int64(2_524_604_400),
                restrictIndices: ["Movies", "cts_e2e_settings"],
                restrictSources: "192.168.1.0/24",
                userToken: "user123"
            )
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// mcm with filters
    func snippetForGenerateSecuredApiKey5() async throws {
        // >SEPARATOR generateSecuredApiKey mcm with filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "YourSearchOnlyApiKey",
            restrictions: SecuredApiKeyRestrictions(filters: "user:user42 AND user:public")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the generateSecuredApiKey method.
    ///
    /// mcm with user token
    func snippetForGenerateSecuredApiKey6() async throws {
        // >SEPARATOR generateSecuredApiKey mcm with user token
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try client.generateSecuredApiKey(
            parentApiKey: "YourSearchOnlyApiKey",
            restrictions: SecuredApiKeyRestrictions(userToken: "user42")
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getLogs method.
    ///
    /// getLogs with minimal parameters
    func snippetForGetLogs() async throws {
        // >SEPARATOR getLogs getLogs with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getLogs()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getLogs method.
    ///
    /// getLogs with parameters
    func snippetForGetLogs1() async throws {
        // >SEPARATOR getLogs getLogs with parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getLogs(
            offset: 5,
            length: 10,
            indexName: "<YOUR_INDEX_NAME>",
            type: LogType.all
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getObject method.
    ///
    /// getObject
    func snippetForGetObject() async throws {
        // >SEPARATOR getObject getObject
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToRetrieve: ["attr1", "attr2"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getObject method.
    ///
    /// search with a real object
    func snippetForGetObject1() async throws {
        // >SEPARATOR getObject search with a real object
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getObject(indexName: "<YOUR_INDEX_NAME>", objectID: "Batman and Robin")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getObjects method.
    ///
    /// by ID
    func snippetForGetObjects() async throws {
        // >SEPARATOR getObjects by ID
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: GetObjectsResponse<Hit> = try await client
            .getObjects(getObjectsParams: GetObjectsParams(requests: [GetObjectsRequest(
                objectID: "uniqueID",
                indexName: "<YOUR_INDEX_NAME>"
            )]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getObjects method.
    ///
    /// multiple IDs
    func snippetForGetObjects1() async throws {
        // >SEPARATOR getObjects multiple IDs
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: GetObjectsResponse<Hit> = try await client
            .getObjects(getObjectsParams: GetObjectsParams(requests: [
                GetObjectsRequest(objectID: "uniqueID1", indexName: "<YOUR_INDEX_NAME>"),
                GetObjectsRequest(objectID: "uniqueID2", indexName: "<YOUR_INDEX_NAME>"),
            ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getObjects method.
    ///
    /// with attributesToRetrieve
    func snippetForGetObjects2() async throws {
        // >SEPARATOR getObjects with attributesToRetrieve
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        let response = try await client.getSettings(indexName: "<YOUR_INDEX_NAME>", getVersion: 2)
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the hasPendingMappings method.
    ///
    /// hasPendingMappings with minimal parameters
    func snippetForHasPendingMappings() async throws {
        // >SEPARATOR hasPendingMappings hasPendingMappings with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.hasPendingMappings()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the hasPendingMappings method.
    ///
    /// hasPendingMappings with parameters
    func snippetForHasPendingMappings1() async throws {
        // >SEPARATOR hasPendingMappings hasPendingMappings with parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.hasPendingMappings(getClusters: true)
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listIndices method.
    ///
    /// listIndices with minimal parameters
    func snippetForListIndices() async throws {
        // >SEPARATOR listIndices listIndices with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listIndices()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listIndices method.
    ///
    /// listIndices with parameters
    func snippetForListIndices1() async throws {
        // >SEPARATOR listIndices listIndices with parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listIndices(page: 8, hitsPerPage: 3)
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listUserIds method.
    ///
    /// listUserIds with minimal parameters
    func snippetForListUserIds() async throws {
        // >SEPARATOR listUserIds listUserIds with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listUserIds()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listUserIds method.
    ///
    /// listUserIds with parameters
    func snippetForListUserIds1() async throws {
        // >SEPARATOR listUserIds listUserIds with parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listUserIds(page: 8, hitsPerPage: 100)
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// Partial update with a new value for a string attribute
    func snippetForPartialUpdateObject() async throws {
        // >SEPARATOR partialUpdateObject Partial update with a new value for a string attribute
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["attributeId": "new value"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// Partial update with a new value for an integer attribute
    func snippetForPartialUpdateObject1() async throws {
        // >SEPARATOR partialUpdateObject Partial update with a new value for an integer attribute
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["attributeId": 1]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// Partial update with a new value for a boolean attribute
    func snippetForPartialUpdateObject2() async throws {
        // >SEPARATOR partialUpdateObject Partial update with a new value for a boolean attribute
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["attributeId": true]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// Partial update with a new value for an array attribute
    func snippetForPartialUpdateObject3() async throws {
        // >SEPARATOR partialUpdateObject Partial update with a new value for an array attribute
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "uniqueID",
            attributesToUpdate: ["attributeId": ["one", "two", "three"]]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// Partial update with a new value for an object attribute
    func snippetForPartialUpdateObject4() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// with visible_by filter
    func snippetForPartialUpdateObject5() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// add men pant
    func snippetForPartialUpdateObject6() async throws {
        // >SEPARATOR partialUpdateObject add men pant
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "productId",
            attributesToUpdate: ["categoryPageId": ["_operation": "Add", "value": "men-clothing-pants"]]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the partialUpdateObject method.
    ///
    /// remove men pant
    func snippetForPartialUpdateObject7() async throws {
        // >SEPARATOR partialUpdateObject remove men pant
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.partialUpdateObject(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "productId",
            attributesToUpdate: ["categoryPageId": ["_operation": "Remove", "value": "men-clothing-pants"]]
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
            body: [
                "name": "Black T-shirt",
                "color": "#000000||black",
                "availableIn": "https://source.unsplash.com/100x100/?paris||Paris",
                "objectID": "myID",
            ]
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
            ]],
            waitForTasks: false,
            batchSize: 1000,
            requestOptions: RequestOptions(
                headers: ["X-Algolia-User-ID": "*"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// saveRule with minimal parameters
    func snippetForSaveRule() async throws {
        // >SEPARATOR saveRule saveRule with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "id1",
            rule: Rule(
                objectID: "id1",
                conditions: [SearchCondition(pattern: "apple", anchoring: SearchAnchoring.contains)],
                consequence: SearchConsequence(params: SearchConsequenceParams(filters: "brand:xiaomi"))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// saveRule with all parameters
    func snippetForSaveRule1() async throws {
        // >SEPARATOR saveRule saveRule with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "id1",
            rule: Rule(
                objectID: "id1",
                conditions: [SearchCondition(
                    pattern: "apple",
                    anchoring: SearchAnchoring.contains,
                    alternatives: false,
                    context: "search"
                )],
                consequence: SearchConsequence(
                    params: SearchConsequenceParams(
                        filters: "brand:apple",
                        query: SearchConsequenceQuery.searchConsequenceQueryObject(SearchConsequenceQueryObject(
                            remove: ["algolia"],
                            edits: [
                                SearchEdit(type: SearchEditType.remove, delete: "abc", insert: "cde"),
                                SearchEdit(type: SearchEditType.replace, delete: "abc", insert: "cde"),
                            ]
                        ))
                    ),
                    promote: [
                        SearchPromote.searchPromoteObjectID(SearchPromoteObjectID(objectID: "abc", position: 3)),
                        SearchPromote.searchPromoteObjectIDs(SearchPromoteObjectIDs(
                            objectIDs: ["abc", "def"],
                            position: 1
                        )),
                    ],
                    filterPromotes: false,
                    hide: [SearchConsequenceHide(objectID: "321")],
                    userData: ["algolia": "aloglia"]
                ),
                description: "test",
                enabled: true,
                validity: [SearchTimeRange(from: Int64(1_656_670_273), until: Int64(1_656_670_277))]
            ),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// b2b catalog
    func snippetForSaveRule2() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// merchandising and promoting
    func snippetForSaveRule3() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// harry potter
    func snippetForSaveRule4() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// merchandising empty query
    func snippetForSaveRule5() async throws {
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
                consequence: SearchConsequence(params: SearchConsequenceParams(optionalFilters: SearchOptionalFilters
                        .string("clearance:true")))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// redirect
    func snippetForSaveRule6() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote some results over others
    func snippetForSaveRule7() async throws {
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
                consequence: SearchConsequence(params: SearchConsequenceParams(optionalFilters: SearchOptionalFilters
                        .string("food_group:fruit")))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote several hits
    func snippetForSaveRule8() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote newest release
    func snippetForSaveRule9() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// promote single item
    func snippetForSaveRule10() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// limit search results
    func snippetForSaveRule11() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// query match
    func snippetForSaveRule12() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// dynamic filtering
    func snippetForSaveRule13() async throws {
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
                    params: SearchConsequenceParams(automaticFacetFilters: SearchAutomaticFacetFilters
                        .arrayOfSearchAutomaticFacetFilter([SearchAutomaticFacetFilter(facet: "color")]))
                )
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// hide hits
    func snippetForSaveRule14() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// one rule per facet
    func snippetForSaveRule15() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// numerical filters
    func snippetForSaveRule16() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// negative filters
    func snippetForSaveRule17() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// positive filters
    func snippetForSaveRule18() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// conditionless
    func snippetForSaveRule19() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// contextual
    func snippetForSaveRule20() async throws {
        // >SEPARATOR saveRule contextual
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "a-rule-id",
            rule: Rule(
                objectID: "a-rule-id",
                conditions: [SearchCondition(context: "mobile")],
                consequence: SearchConsequence(params: SearchConsequenceParams(filters: "release_date >= 1577836800"))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// saveRule always active rule
    func snippetForSaveRule21() async throws {
        // >SEPARATOR saveRule saveRule always active rule
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "a-rule-id",
            rule: Rule(
                objectID: "a-rule-id",
                consequence: SearchConsequence(params: SearchConsequenceParams(aroundRadius: SearchAroundRadius
                        .int(1000))),
                validity: [SearchTimeRange(from: Int64(1_577_836_800), until: Int64(1_577_836_800))]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRule method.
    ///
    /// one sided validity
    func snippetForSaveRule22() async throws {
        // >SEPARATOR saveRule one sided validity
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRule(
            indexName: "<YOUR_INDEX_NAME>",
            objectID: "a-rule-id",
            rule: Rule(
                objectID: "a-rule-id",
                consequence: SearchConsequence(params: SearchConsequenceParams(aroundRadius: SearchAroundRadius
                        .int(1000))),
                validity: [SearchTimeRange(from: Int64(1_577_836_800))]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules with minimal parameters
    func snippetForSaveRules() async throws {
        // >SEPARATOR saveRules saveRules with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            indexName: "<YOUR_INDEX_NAME>",
            rules: [
                Rule(objectID: "a-rule-id", conditions: [SearchCondition(
                    pattern: "smartphone",
                    anchoring: SearchAnchoring.contains
                )], consequence: SearchConsequence(params: SearchConsequenceParams(filters: "brand:apple"))),
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules with all parameters
    func snippetForSaveRules1() async throws {
        // >SEPARATOR saveRules saveRules with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            indexName: "<YOUR_INDEX_NAME>",
            rules: [Rule(
                objectID: "id1",
                conditions: [SearchCondition(
                    pattern: "apple",
                    anchoring: SearchAnchoring.contains,
                    alternatives: false,
                    context: "search"
                )],
                consequence: SearchConsequence(
                    params: SearchConsequenceParams(
                        filters: "brand:apple",
                        query: SearchConsequenceQuery.searchConsequenceQueryObject(SearchConsequenceQueryObject(
                            remove: ["algolia"],
                            edits: [
                                SearchEdit(type: SearchEditType.remove, delete: "abc", insert: "cde"),
                                SearchEdit(type: SearchEditType.replace, delete: "abc", insert: "cde"),
                            ]
                        ))
                    ),
                    promote: [
                        SearchPromote.searchPromoteObjectID(SearchPromoteObjectID(objectID: "abc", position: 3)),
                        SearchPromote.searchPromoteObjectIDs(SearchPromoteObjectIDs(
                            objectIDs: ["abc", "def"],
                            position: 1
                        )),
                    ],
                    filterPromotes: false,
                    hide: [SearchConsequenceHide(objectID: "321")],
                    userData: ["algolia": "aloglia"]
                ),
                description: "test",
                enabled: true,
                validity: [SearchTimeRange(from: Int64(1_656_670_273), until: Int64(1_656_670_277))]
            )],
            forwardToReplicas: true,
            clearExistingRules: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// dynamic filtering
    func snippetForSaveRules2() async throws {
        // >SEPARATOR saveRules dynamic filtering
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            indexName: "<YOUR_INDEX_NAME>",
            rules: [
                Rule(objectID: "toaster", conditions: [SearchCondition(
                    pattern: "toaster",
                    anchoring: SearchAnchoring.contains
                )], consequence: SearchConsequence(params: SearchConsequenceParams(
                    filters: "product_type:toaster",
                    query: SearchConsequenceQuery
                        .searchConsequenceQueryObject(SearchConsequenceQueryObject(remove: ["toaster"]))
                ))),
                Rule(
                    objectID: "cheap",
                    conditions: [SearchCondition(pattern: "cheap", anchoring: SearchAnchoring.contains)],
                    consequence: SearchConsequence(params: SearchConsequenceParams(
                        filters: "price < 15",
                        query: SearchConsequenceQuery
                            .searchConsequenceQueryObject(SearchConsequenceQueryObject(remove: ["cheap"]))
                    ))
                ),
            ]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// enhance search results
    func snippetForSaveRules3() async throws {
        // >SEPARATOR saveRules enhance search results
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            indexName: "<YOUR_INDEX_NAME>",
            rules: [
                Rule(objectID: "country", conditions: [SearchCondition(
                    pattern: "{facet:country}",
                    anchoring: SearchAnchoring.contains
                )], consequence: SearchConsequence(params: SearchConsequenceParams(aroundLatLngViaIP: false))),
                Rule(
                    objectID: "city",
                    conditions: [SearchCondition(pattern: "{facet:city}", anchoring: SearchAnchoring.contains)],
                    consequence: SearchConsequence(params: SearchConsequenceParams(aroundLatLngViaIP: false))
                ),
            ]
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for a single hits request with minimal parameters
    func snippetForSearch4() async throws {
        // >SEPARATOR search search for a single hits request with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery
                    .searchForHits(SearchForHits(indexName: "<YOUR_INDEX_NAME>"))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search with highlight and snippet results
    func snippetForSearch5() async throws {
        // >SEPARATOR search search with highlight and snippet results
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "vim",
                attributesToRetrieve: ["*"],
                attributesToHighlight: ["*"],
                attributesToSnippet: ["*:20"],
                indexName: "<YOUR_INDEX_NAME>"
            ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// retrieveFacets
    func snippetForSearch6() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// retrieveFacetsWildcard
    func snippetForSearch7() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for a single facet request with minimal parameters
    func snippetForSearch8() async throws {
        // >SEPARATOR search search for a single facet request with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client.search(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                facet: "editor",
                indexName: "<YOUR_INDEX_NAME>",
                type: SearchTypeFacet.facet
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for a single hits request with all parameters
    func snippetForSearch9() async throws {
        // >SEPARATOR search search for a single hits request with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "myQuery",
                hitsPerPage: 50,
                indexName: "<YOUR_INDEX_NAME>",
                type: SearchTypeDefault.`default`
            ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for a single facet request with all parameters
    func snippetForSearch10() async throws {
        // >SEPARATOR search search for a single facet request with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client.search(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                query: "theQuery",
                facet: "theFacet",
                indexName: "<YOUR_INDEX_NAME>",
                facetQuery: "theFacetQuery",
                maxFacetHits: 50,
                type: SearchTypeFacet.facet
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for multiple mixed requests in multiple indices with minimal parameters
    func snippetForSearch11() async throws {
        // >SEPARATOR search search for multiple mixed requests in multiple indices with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client.search(searchMethodParams: SearchMethodParams(
            requests: [
                SearchQuery.searchForHits(SearchForHits(indexName: "<YOUR_INDEX_NAME>")),
                SearchQuery.searchForFacets(SearchForFacets(
                    facet: "theFacet",
                    indexName: "<YOUR_INDEX_NAME>",
                    type: SearchTypeFacet.facet
                )),
                SearchQuery.searchForHits(SearchForHits(
                    indexName: "<YOUR_INDEX_NAME>",
                    type: SearchTypeDefault.`default`
                )),
            ],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search for multiple mixed requests in multiple indices with all parameters
    func snippetForSearch12() async throws {
        // >SEPARATOR search search for multiple mixed requests in multiple indices with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client.search(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                query: "theQuery",
                facet: "theFacet",
                indexName: "<YOUR_INDEX_NAME>",
                facetQuery: "theFacetQuery",
                maxFacetHits: 50,
                type: SearchTypeFacet.facet
            )), SearchQuery.searchForHits(SearchForHits(
                query: "myQuery",
                hitsPerPage: 50,
                indexName: "<YOUR_INDEX_NAME>",
                type: SearchTypeDefault.`default`
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search filters accept all of the possible shapes
    func snippetForSearch13() async throws {
        // >SEPARATOR search search filters accept all of the possible shapes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client.search(searchMethodParams: SearchMethodParams(requests: [
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: SearchFacetFilters.string("mySearch:filters"),
                optionalFilters: SearchOptionalFilters.string("mySearch:filters"),
                numericFilters: SearchNumericFilters.string("mySearch:filters"),
                tagFilters: SearchTagFilters.string("mySearch:filters"),
                reRankingApplyFilter: SearchReRankingApplyFilter.string("mySearch:filters"),
                indexName: "<YOUR_INDEX_NAME>"
            )),
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([
                    SearchFacetFilters.string("mySearch:filters"),
                    SearchFacetFilters.arrayOfSearchFacetFilters([
                        SearchFacetFilters.string("mySearch:filters"),
                        SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("mySearch:filters")]),
                    ]),
                ]),
                optionalFilters: SearchOptionalFilters.arrayOfSearchOptionalFilters([
                    SearchOptionalFilters.string("mySearch:filters"),
                    SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([SearchOptionalFilters.string("mySearch:filters")]),
                ]),
                numericFilters: SearchNumericFilters.arrayOfSearchNumericFilters([
                    SearchNumericFilters.string("mySearch:filters"),
                    SearchNumericFilters.arrayOfSearchNumericFilters([SearchNumericFilters.string("mySearch:filters")]),
                ]),
                tagFilters: SearchTagFilters.arrayOfSearchTagFilters([
                    SearchTagFilters.string("mySearch:filters"),
                    SearchTagFilters.arrayOfSearchTagFilters([SearchTagFilters.string("mySearch:filters")]),
                ]),
                reRankingApplyFilter: SearchReRankingApplyFilter.arrayOfSearchReRankingApplyFilter([
                    SearchReRankingApplyFilter.string("mySearch:filters"),
                    SearchReRankingApplyFilter
                        .arrayOfSearchReRankingApplyFilter([SearchReRankingApplyFilter.string("mySearch:filters")]),
                ]),
                indexName: "<YOUR_INDEX_NAME>"
            )),
        ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search filters end to end
    func snippetForSearch14() async throws {
        // >SEPARATOR search search filters end to end
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client.search(searchMethodParams: SearchMethodParams(requests: [
            SearchQuery.searchForHits(SearchForHits(
                filters: "editor:'visual studio' OR editor:neovim",
                indexName: "<YOUR_INDEX_NAME>"
            )),
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([
                    SearchFacetFilters.string("editor:'visual studio'"),
                    SearchFacetFilters.string("editor:neovim"),
                ]),
                indexName: "<YOUR_INDEX_NAME>"
            )),
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([
                    SearchFacetFilters.string("editor:'visual studio'"),
                    SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("editor:neovim")]),
                ]),
                indexName: "<YOUR_INDEX_NAME>"
            )),
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([
                    SearchFacetFilters.string("editor:'visual studio'"),
                    SearchFacetFilters.arrayOfSearchFacetFilters([
                        SearchFacetFilters.string("editor:neovim"),
                        SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("editor:goland")]),
                    ]),
                ]),
                indexName: "<YOUR_INDEX_NAME>"
            )),
        ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search with all search parameters
    func snippetForSearch15() async throws {
        // >SEPARATOR search search with all search parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponses<Hit> = try await client
            .search(searchMethodParams: SearchMethodParams(requests: [SearchQuery.searchForHits(SearchForHits(
                query: "",
                similarQuery: "",
                filters: "",
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("")]),
                optionalFilters: SearchOptionalFilters.arrayOfSearchOptionalFilters([SearchOptionalFilters.string("")]),
                numericFilters: SearchNumericFilters.arrayOfSearchNumericFilters([SearchNumericFilters.string("")]),
                tagFilters: SearchTagFilters.arrayOfSearchTagFilters([SearchTagFilters.string("")]),
                sumOrFiltersScores: true,
                restrictSearchableAttributes: [""],
                facets: [""],
                facetingAfterDistinct: true,
                page: 0,
                offset: 0,
                length: 1,
                aroundLatLng: "",
                aroundLatLngViaIP: true,
                aroundRadius: SearchAroundRadius.searchAroundRadiusAll(SearchAroundRadiusAll.all),
                aroundPrecision: SearchAroundPrecision.int(0),
                minimumAroundRadius: 1,
                insideBoundingBox: SearchInsideBoundingBox.arrayOfArrayOfDouble([
                    [47.3165, 4.9665, 47.3424, 5.0201],
                    [40.9234, 2.1185, 38.643, 1.9916],
                ]),
                insidePolygon: [
                    [47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9],
                    [40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104],
                ],
                naturalLanguages: [SearchSupportedLanguage.fr],
                ruleContexts: [""],
                personalizationImpact: 0,
                userToken: "",
                getRankingInfo: true,
                synonyms: true,
                clickAnalytics: true,
                analytics: true,
                analyticsTags: [""],
                percentileComputation: true,
                enableABTest: true,
                attributesToRetrieve: [""],
                ranking: [""],
                relevancyStrictness: 0,
                attributesToHighlight: [""],
                attributesToSnippet: [""],
                highlightPreTag: "",
                highlightPostTag: "",
                snippetEllipsisText: "",
                restrictHighlightAndSnippetArrays: true,
                hitsPerPage: 1,
                minWordSizefor1Typo: 0,
                minWordSizefor2Typos: 0,
                typoTolerance: SearchTypoTolerance.searchTypoToleranceEnum(SearchTypoToleranceEnum.min),
                allowTyposOnNumericTokens: true,
                disableTypoToleranceOnAttributes: [""],
                ignorePlurals: SearchIgnorePlurals.bool(false),
                removeStopWords: SearchRemoveStopWords.bool(true),
                queryLanguages: [SearchSupportedLanguage.fr],
                decompoundQuery: true,
                enableRules: true,
                enablePersonalization: true,
                queryType: SearchQueryType.prefixAll,
                removeWordsIfNoResults: SearchRemoveWordsIfNoResults.allOptional,
                advancedSyntax: true,
                optionalWords: SearchOptionalWords.arrayOfString([""]),
                disableExactOnAttributes: [""],
                exactOnSingleWordQuery: SearchExactOnSingleWordQuery.attribute,
                alternativesAsExact: [SearchAlternativesAsExact.multiWordsSynonym],
                advancedSyntaxFeatures: [SearchAdvancedSyntaxFeatures.exactPhrase],
                distinct: SearchDistinct.int(0),
                replaceSynonymsInHighlight: true,
                minProximity: 1,
                responseFields: [""],
                maxValuesPerFacet: 0,
                sortFacetValuesBy: "",
                attributeCriteriaComputedByMinProximity: true,
                renderingContent: SearchRenderingContent(facetOrdering: SearchFacetOrdering(
                    facets: SearchFacets(order: ["a", "b"]),
                    values: ["a": SearchValue(order: ["b"], sortRemainingBy: SearchSortRemainingBy.count)]
                )),
                enableReRanking: true,
                reRankingApplyFilter: SearchReRankingApplyFilter
                    .arrayOfSearchReRankingApplyFilter([SearchReRankingApplyFilter.string("")]),
                indexName: "<YOUR_INDEX_NAME>",
                type: SearchTypeDefault.`default`
            ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchDictionaryEntries method.
    ///
    /// get searchDictionaryEntries results with minimal parameters
    func snippetForSearchDictionaryEntries() async throws {
        // >SEPARATOR searchDictionaryEntries get searchDictionaryEntries results with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchDictionaryEntries(
            dictionaryName: DictionaryType.stopwords,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(query: "about")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchDictionaryEntries method.
    ///
    /// get searchDictionaryEntries results with all parameters
    func snippetForSearchDictionaryEntries1() async throws {
        // >SEPARATOR searchDictionaryEntries get searchDictionaryEntries results with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchDictionaryEntries(
            dictionaryName: DictionaryType.compounds,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(
                query: "foo",
                page: 4,
                hitsPerPage: 2,
                language: SearchSupportedLanguage.fr
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// get searchForFacetValues results with minimal parameters
    func snippetForSearchForFacetValues() async throws {
        // >SEPARATOR searchForFacetValues get searchForFacetValues results with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(indexName: "<YOUR_INDEX_NAME>", facetName: "facetName")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// get searchForFacetValues results with all parameters
    func snippetForSearchForFacetValues1() async throws {
        // >SEPARATOR searchForFacetValues get searchForFacetValues results with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(
            indexName: "<YOUR_INDEX_NAME>",
            facetName: "facetName",
            searchForFacetValuesRequest: SearchForFacetValuesRequest(
                params: "query=foo&facetFilters=['bar']",
                facetQuery: "foo",
                maxFacetHits: 42
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// facetName and facetQuery
    func snippetForSearchForFacetValues2() async throws {
        // >SEPARATOR searchForFacetValues facetName and facetQuery
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(
            indexName: "<YOUR_INDEX_NAME>",
            facetName: "author",
            searchForFacetValuesRequest: SearchForFacetValuesRequest(facetQuery: "stephen")
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search with minimal parameters
    func snippetForSearchSingleIndex() async throws {
        // >SEPARATOR searchSingleIndex search with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search with special characters in indexName
    func snippetForSearchSingleIndex1() async throws {
        // >SEPARATOR searchSingleIndex search with special characters in indexName
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search with searchParams
    func snippetForSearchSingleIndex2() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// single search retrieve snippets
    func snippetForSearchSingleIndex3() async throws {
        // >SEPARATOR searchSingleIndex single search retrieve snippets
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "batman mask of the phantasm",
                attributesToRetrieve: ["*"],
                attributesToSnippet: ["*:20"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// query
    func snippetForSearchSingleIndex4() async throws {
        // >SEPARATOR searchSingleIndex query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "phone"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filters
    func snippetForSearchSingleIndex5() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filters for stores
    func snippetForSearchSingleIndex6() async throws {
        // >SEPARATOR searchSingleIndex filters for stores
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "ben",
                filters: "categories:politics AND store:Gibert Joseph Saint-Michel"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filters boolean
    func snippetForSearchSingleIndex7() async throws {
        // >SEPARATOR searchSingleIndex filters boolean
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(filters: "is_available:true"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// distinct
    func snippetForSearchSingleIndex8() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersNumeric
    func snippetForSearchSingleIndex9() async throws {
        // >SEPARATOR searchSingleIndex filtersNumeric
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(filters: "price < 10"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersTimestamp
    func snippetForSearchSingleIndex10() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersSumOrFiltersScoresFalse
    func snippetForSearchSingleIndex11() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersSumOrFiltersScoresTrue
    func snippetForSearchSingleIndex12() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersStephenKing
    func snippetForSearchSingleIndex13() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersNotTags
    func snippetForSearchSingleIndex14() async throws {
        // >SEPARATOR searchSingleIndex filtersNotTags
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "harry",
                filters: "_tags:non-fiction"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersList
    func snippetForSearchSingleIndex15() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersList
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(facetFilters: SearchFacetFilters
                        .arrayOfSearchFacetFilters([
                            SearchFacetFilters.string("publisher:Penguin"),
                            SearchFacetFilters.arrayOfSearchFacetFilters([
                                SearchFacetFilters.string("author:Stephen King"),
                                SearchFacetFilters.string("genre:Horror"),
                            ]),
                        ])))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersBook
    func snippetForSearchSingleIndex16() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersBook
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([SearchFacetFilters.string("category:Book")])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersAND
    func snippetForSearchSingleIndex17() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersAND
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([
                    SearchFacetFilters.string("category:Book"),
                    SearchFacetFilters.string("author:John Doe"),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersOR
    func snippetForSearchSingleIndex18() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersOR
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facetFilters: SearchFacetFilters
                    .arrayOfSearchFacetFilters([SearchFacetFilters.arrayOfSearchFacetFilters([
                        SearchFacetFilters.string("category:Book"),
                        SearchFacetFilters.string("author:John Doe"),
                    ])])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersCombined
    func snippetForSearchSingleIndex19() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersCombined
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facetFilters: SearchFacetFilters.arrayOfSearchFacetFilters([
                    SearchFacetFilters.string("author:John Doe"),
                    SearchFacetFilters.arrayOfSearchFacetFilters([
                        SearchFacetFilters.string("category:Book"),
                        SearchFacetFilters.string("category:Movie"),
                    ]),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersNeg
    func snippetForSearchSingleIndex20() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersNeg
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(facetFilters: SearchFacetFilters
                        .string("category:-Ebook")))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// filtersAndFacetFilters
    func snippetForSearchSingleIndex21() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facet author genre
    func snippetForSearchSingleIndex22() async throws {
        // >SEPARATOR searchSingleIndex facet author genre
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(facets: [
                "author",
                "genre",
            ]))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facet wildcard
    func snippetForSearchSingleIndex23() async throws {
        // >SEPARATOR searchSingleIndex facet wildcard
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(facets: ["*"]))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// maxValuesPerFacet
    func snippetForSearchSingleIndex24() async throws {
        // >SEPARATOR searchSingleIndex maxValuesPerFacet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(maxValuesPerFacet: 1000))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// aroundLatLng
    func snippetForSearchSingleIndex25() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// aroundLatLngViaIP
    func snippetForSearchSingleIndex26() async throws {
        // >SEPARATOR searchSingleIndex aroundLatLngViaIP
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(aroundLatLngViaIP: true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// aroundRadius
    func snippetForSearchSingleIndex27() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// insideBoundingBox
    func snippetForSearchSingleIndex28() async throws {
        // >SEPARATOR searchSingleIndex insideBoundingBox
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(insideBoundingBox: SearchInsideBoundingBox
                        .arrayOfArrayOfDouble([[
                            49.067996905313834,
                            65.73828125,
                            25.905859247243498,
                            128.8046875,
                        ]])))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// insidePolygon
    func snippetForSearchSingleIndex29() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// optionalFilters
    func snippetForSearchSingleIndex30() async throws {
        // >SEPARATOR searchSingleIndex optionalFilters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(optionalFilters: SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([SearchOptionalFilters.string("can_deliver_quickly:true")])))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// optionalFiltersMany
    func snippetForSearchSingleIndex31() async throws {
        // >SEPARATOR searchSingleIndex optionalFiltersMany
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(optionalFilters: SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([
                            SearchOptionalFilters.string("brand:Apple<score=3>"),
                            SearchOptionalFilters.string("brand:Samsung<score=2>"),
                            SearchOptionalFilters.string("brand:-Huawei"),
                        ])))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// optionalFiltersSimple
    func snippetForSearchSingleIndex32() async throws {
        // >SEPARATOR searchSingleIndex optionalFiltersSimple
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(optionalFilters: SearchOptionalFilters
                        .arrayOfSearchOptionalFilters([
                            SearchOptionalFilters.string("brand:Apple<score=2>"),
                            SearchOptionalFilters.string("type:tablet"),
                        ])))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// restrictSearchableAttributes
    func snippetForSearchSingleIndex33() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// getRankingInfo
    func snippetForSearchSingleIndex34() async throws {
        // >SEPARATOR searchSingleIndex getRankingInfo
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(getRankingInfo: true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// clickAnalytics
    func snippetForSearchSingleIndex35() async throws {
        // >SEPARATOR searchSingleIndex clickAnalytics
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(clickAnalytics: true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// clickAnalyticsUserToken
    func snippetForSearchSingleIndex36() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enablePersonalization
    func snippetForSearchSingleIndex37() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// userToken
    func snippetForSearchSingleIndex38() async throws {
        // >SEPARATOR searchSingleIndex userToken
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(userToken: "user-1"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// userToken1234
    func snippetForSearchSingleIndex39() async throws {
        // >SEPARATOR searchSingleIndex userToken1234
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                userToken: "user-1234"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// analyticsTag
    func snippetForSearchSingleIndex40() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facetFiltersUsers
    func snippetForSearchSingleIndex41() async throws {
        // >SEPARATOR searchSingleIndex facetFiltersUsers
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams
                .searchSearchParamsObject(SearchSearchParamsObject(facetFilters: SearchFacetFilters
                        .arrayOfSearchFacetFilters([
                            SearchFacetFilters.string("user:user42"),
                            SearchFacetFilters.string("user:public"),
                        ])))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// buildTheQuery
    func snippetForSearchSingleIndex42() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// attributesToHighlightOverride
    func snippetForSearchSingleIndex43() async throws {
        // >SEPARATOR searchSingleIndex attributesToHighlightOverride
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                attributesToHighlight: ["title", "content"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disableTypoToleranceOnAttributes
    func snippetForSearchSingleIndex44() async throws {
        // >SEPARATOR searchSingleIndex disableTypoToleranceOnAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                disableTypoToleranceOnAttributes: ["serial_number"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search query
    func snippetForSearchSingleIndex45() async throws {
        // >SEPARATOR searchSingleIndex search query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "shirt"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_everything
    func snippetForSearchSingleIndex46() async throws {
        // >SEPARATOR searchSingleIndex search_everything
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: ""))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// api_filtering_range_example
    func snippetForSearchSingleIndex47() async throws {
        // >SEPARATOR searchSingleIndex api_filtering_range_example
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "books",
                filters: "price:10 TO 20"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// similarQuery
    func snippetForSearchSingleIndex48() async throws {
        // >SEPARATOR searchSingleIndex similarQuery
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "",
                similarQuery: "Comedy Drama Crime McDormand Macy Buscemi Stormare Presnell Coen",
                filters: "year:1991 TO 2001"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_retrievable_attributes
    func snippetForSearchSingleIndex49() async throws {
        // >SEPARATOR searchSingleIndex override_retrievable_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                attributesToRetrieve: ["title", "content"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// restrict_searchable_attributes
    func snippetForSearchSingleIndex50() async throws {
        // >SEPARATOR searchSingleIndex restrict_searchable_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                restrictSearchableAttributes: ["title", "author"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_relevancy
    func snippetForSearchSingleIndex51() async throws {
        // >SEPARATOR searchSingleIndex override_default_relevancy
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                relevancyStrictness: 70
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_filters
    func snippetForSearchSingleIndex52() async throws {
        // >SEPARATOR searchSingleIndex apply_filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                filters: "(category:Book OR category:Ebook) AND _tags:published"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_all_filters
    func snippetForSearchSingleIndex53() async throws {
        // >SEPARATOR searchSingleIndex apply_all_filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                filters: "available = 1 AND (category:Book OR NOT category:Ebook) AND _tags:published AND publication_date:1441745506 TO 1441755506 AND inStock > 0 AND author:\"John Doe\""
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// escape_spaces
    func snippetForSearchSingleIndex54() async throws {
        // >SEPARATOR searchSingleIndex escape_spaces
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                filters: "category:\"Books and Comics\""
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// escape_keywords
    func snippetForSearchSingleIndex55() async throws {
        // >SEPARATOR searchSingleIndex escape_keywords
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                filters: "keyword:\"OR\""
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// escape_single_quotes
    func snippetForSearchSingleIndex56() async throws {
        // >SEPARATOR searchSingleIndex escape_single_quotes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                filters: "content:\"It's a wonderful day\""
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// escape_double_quotes
    func snippetForSearchSingleIndex57() async throws {
        // >SEPARATOR searchSingleIndex escape_double_quotes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                filters: "content:\"She said \"Hello World\""
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_optional_filters
    func snippetForSearchSingleIndex58() async throws {
        // >SEPARATOR searchSingleIndex apply_optional_filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                optionalFilters: SearchOptionalFilters.arrayOfSearchOptionalFilters([
                    SearchOptionalFilters.string("category:Book"),
                    SearchOptionalFilters.string("author:John Doe"),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_negative_filters
    func snippetForSearchSingleIndex59() async throws {
        // >SEPARATOR searchSingleIndex apply_negative_filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                optionalFilters: SearchOptionalFilters.arrayOfSearchOptionalFilters([
                    SearchOptionalFilters.string("category:Book"),
                    SearchOptionalFilters.string("author:-John Doe"),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_negative_filters_restaurants
    func snippetForSearchSingleIndex60() async throws {
        // >SEPARATOR searchSingleIndex apply_negative_filters_restaurants
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                optionalFilters: SearchOptionalFilters
                    .arrayOfSearchOptionalFilters([SearchOptionalFilters.string("restaurant:-Bert's Inn")])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_numeric_filters
    func snippetForSearchSingleIndex61() async throws {
        // >SEPARATOR searchSingleIndex apply_numeric_filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                numericFilters: SearchNumericFilters.arrayOfSearchNumericFilters([
                    SearchNumericFilters.string("price < 1000"),
                    SearchNumericFilters.arrayOfSearchNumericFilters([
                        SearchNumericFilters.string("inStock = 1"),
                        SearchNumericFilters.string("deliveryDate < 1441755506"),
                    ]),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// apply_tag_filters
    func snippetForSearchSingleIndex62() async throws {
        // >SEPARATOR searchSingleIndex apply_tag_filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                tagFilters: SearchTagFilters.arrayOfSearchTagFilters([
                    SearchTagFilters.string("SciFi"),
                    SearchTagFilters.arrayOfSearchTagFilters([
                        SearchTagFilters.string("Book"),
                        SearchTagFilters.string("Movie"),
                    ]),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_sum_or_filters_scores
    func snippetForSearchSingleIndex63() async throws {
        // >SEPARATOR searchSingleIndex set_sum_or_filters_scores
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                sumOrFiltersScores: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// facets_all
    func snippetForSearchSingleIndex64() async throws {
        // >SEPARATOR searchSingleIndex facets_all
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facets: ["*"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// retrieve_only_some_facets
    func snippetForSearchSingleIndex65() async throws {
        // >SEPARATOR searchSingleIndex retrieve_only_some_facets
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facets: ["category", "author"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_max_values_per_facet
    func snippetForSearchSingleIndex66() async throws {
        // >SEPARATOR searchSingleIndex override_default_max_values_per_facet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                maxValuesPerFacet: 20
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_faceting_after_distinct
    func snippetForSearchSingleIndex67() async throws {
        // >SEPARATOR searchSingleIndex enable_faceting_after_distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                facetingAfterDistinct: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// sort_facet_values_alphabetically
    func snippetForSearchSingleIndex68() async throws {
        // >SEPARATOR searchSingleIndex sort_facet_values_alphabetically
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                sortFacetValuesBy: "count"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_attributes_to_snippet
    func snippetForSearchSingleIndex69() async throws {
        // >SEPARATOR searchSingleIndex override_attributes_to_snippet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                attributesToSnippet: ["title", "content:80"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_highlight_pre_tag
    func snippetForSearchSingleIndex70() async throws {
        // >SEPARATOR searchSingleIndex override_default_highlight_pre_tag
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                highlightPreTag: "<strong>"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_highlight_post_tag
    func snippetForSearchSingleIndex71() async throws {
        // >SEPARATOR searchSingleIndex override_default_highlight_post_tag
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                highlightPostTag: "</strong>"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_snippet_ellipsis_text
    func snippetForSearchSingleIndex72() async throws {
        // >SEPARATOR searchSingleIndex override_default_snippet_ellipsis_text
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                snippetEllipsisText: ""
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_restrict_highlight_and_snippet_arrays
    func snippetForSearchSingleIndex73() async throws {
        // >SEPARATOR searchSingleIndex enable_restrict_highlight_and_snippet_arrays
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                restrictHighlightAndSnippetArrays: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// access_page
    func snippetForSearchSingleIndex74() async throws {
        // >SEPARATOR searchSingleIndex access_page
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "query", page: 0))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_hits_per_page
    func snippetForSearchSingleIndex75() async throws {
        // >SEPARATOR searchSingleIndex override_default_hits_per_page
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                hitsPerPage: 10
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// get_nth_hit
    func snippetForSearchSingleIndex76() async throws {
        // >SEPARATOR searchSingleIndex get_nth_hit
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                offset: 4
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// get_n_results
    func snippetForSearchSingleIndex77() async throws {
        // >SEPARATOR searchSingleIndex get_n_results
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                length: 4
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_min_word_size_for_one_typo
    func snippetForSearchSingleIndex78() async throws {
        // >SEPARATOR searchSingleIndex override_default_min_word_size_for_one_typo
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                minWordSizefor1Typo: 2
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_min_word_size_for_two_typos
    func snippetForSearchSingleIndex79() async throws {
        // >SEPARATOR searchSingleIndex override_default_min_word_size_for_two_typos
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                minWordSizefor2Typos: 2
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_typo_tolerance_mode
    func snippetForSearchSingleIndex80() async throws {
        // >SEPARATOR searchSingleIndex override_default_typo_tolerance_mode
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                typoTolerance: SearchTypoTolerance.bool(false)
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disable_typos_on_numeric_tokens_at_search_time
    func snippetForSearchSingleIndex81() async throws {
        // >SEPARATOR searchSingleIndex disable_typos_on_numeric_tokens_at_search_time
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                allowTyposOnNumericTokens: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_around_a_position
    func snippetForSearchSingleIndex82() async throws {
        // >SEPARATOR searchSingleIndex search_around_a_position
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                aroundLatLng: "40.71, -74.01"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_around_server_ip
    func snippetForSearchSingleIndex83() async throws {
        // >SEPARATOR searchSingleIndex search_around_server_ip
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                aroundLatLngViaIP: true
            )),
            requestOptions: RequestOptions(
                headers: [
                    "x-forwarded-for": "94.228.178.246 // should be replaced with the actual IP you would like to search around",
                ]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_around_radius
    func snippetForSearchSingleIndex84() async throws {
        // >SEPARATOR searchSingleIndex set_around_radius
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                aroundRadius: SearchAroundRadius.int(1000)
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disable_automatic_radius
    func snippetForSearchSingleIndex85() async throws {
        // >SEPARATOR searchSingleIndex disable_automatic_radius
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                aroundRadius: SearchAroundRadius.searchAroundRadiusAll(SearchAroundRadiusAll.all)
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_geo_search_precision
    func snippetForSearchSingleIndex86() async throws {
        // >SEPARATOR searchSingleIndex set_geo_search_precision
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                aroundPrecision: SearchAroundPrecision.int(100)
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_geo_search_precision_non_linear
    func snippetForSearchSingleIndex87() async throws {
        // >SEPARATOR searchSingleIndex set_geo_search_precision_non_linear
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                aroundPrecision: SearchAroundPrecision.arrayOfSearchRange([
                    SearchRange(from: 0, value: 25),
                    SearchRange(from: 2000, value: 1000),
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_minimum_geo_search_radius
    func snippetForSearchSingleIndex88() async throws {
        // >SEPARATOR searchSingleIndex set_minimum_geo_search_radius
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                minimumAroundRadius: 1000
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_inside_rectangular_area
    func snippetForSearchSingleIndex89() async throws {
        // >SEPARATOR searchSingleIndex search_inside_rectangular_area
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                insideBoundingBox: SearchInsideBoundingBox.arrayOfArrayOfDouble([[
                    46.650828100116044,
                    7.123046875,
                    45.17210966999772,
                    1.009765625,
                ]])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_inside_multiple_rectangular_areas
    func snippetForSearchSingleIndex90() async throws {
        // >SEPARATOR searchSingleIndex search_inside_multiple_rectangular_areas
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                insideBoundingBox: SearchInsideBoundingBox.arrayOfArrayOfDouble([
                    [46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625],
                    [49.62625916704081, 4.6181640625, 47.715070300900194, 0.482421875],
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_inside_polygon_area
    func snippetForSearchSingleIndex91() async throws {
        // >SEPARATOR searchSingleIndex search_inside_polygon_area
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                insidePolygon: [[
                    46.650828100116044,
                    7.123046875,
                    45.17210966999772,
                    1.009765625,
                    49.62625916704081,
                    4.6181640625,
                ]]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// search_inside_multiple_polygon_areas
    func snippetForSearchSingleIndex92() async throws {
        // >SEPARATOR searchSingleIndex search_inside_multiple_polygon_areas
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                insidePolygon: [
                    [46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625, 49.62625916704081, 4.6181640625],
                    [
                        49.62625916704081,
                        4.6181640625,
                        47.715070300900194,
                        0.482421875,
                        45.17210966999772,
                        1.009765625,
                        50.62626704081,
                        4.6181640625,
                    ],
                ]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_querylanguages_override
    func snippetForSearchSingleIndex93() async throws {
        // >SEPARATOR searchSingleIndex set_querylanguages_override
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                ignorePlurals: SearchIgnorePlurals.arrayOfSearchSupportedLanguage([
                    SearchSupportedLanguage.ca,
                    SearchSupportedLanguage.es,
                ])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_querylanguages_with_japanese_query
    func snippetForSearchSingleIndex94() async throws {
        // >SEPARATOR searchSingleIndex set_querylanguages_with_japanese_query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                queryLanguages: [SearchSupportedLanguage.ja, SearchSupportedLanguage.en]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_natural_languages
    func snippetForSearchSingleIndex95() async throws {
        // >SEPARATOR searchSingleIndex set_natural_languages
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "",
                naturalLanguages: [SearchSupportedLanguage.fr]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_natural_languages_with_query
    func snippetForSearchSingleIndex96() async throws {
        // >SEPARATOR searchSingleIndex override_natural_languages_with_query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "",
                naturalLanguages: [SearchSupportedLanguage.fr],
                removeWordsIfNoResults: SearchRemoveWordsIfNoResults.firstWords
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_decompound_query_search_time
    func snippetForSearchSingleIndex97() async throws {
        // >SEPARATOR searchSingleIndex enable_decompound_query_search_time
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                decompoundQuery: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_rules_search_time
    func snippetForSearchSingleIndex98() async throws {
        // >SEPARATOR searchSingleIndex enable_rules_search_time
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                enableRules: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_rule_contexts
    func snippetForSearchSingleIndex99() async throws {
        // >SEPARATOR searchSingleIndex set_rule_contexts
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                ruleContexts: ["front_end", "website2"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_personalization
    func snippetForSearchSingleIndex100() async throws {
        // >SEPARATOR searchSingleIndex enable_personalization
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                enablePersonalization: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_personalization_with_user_token
    func snippetForSearchSingleIndex101() async throws {
        // >SEPARATOR searchSingleIndex enable_personalization_with_user_token
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                userToken: "123456",
                enablePersonalization: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// personalization_impact
    func snippetForSearchSingleIndex102() async throws {
        // >SEPARATOR searchSingleIndex personalization_impact
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                personalizationImpact: 20
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_user_token
    func snippetForSearchSingleIndex103() async throws {
        // >SEPARATOR searchSingleIndex set_user_token
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                userToken: "123456"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_user_token_with_personalization
    func snippetForSearchSingleIndex104() async throws {
        // >SEPARATOR searchSingleIndex set_user_token_with_personalization
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                userToken: "123456",
                enablePersonalization: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_query_type
    func snippetForSearchSingleIndex105() async throws {
        // >SEPARATOR searchSingleIndex override_default_query_type
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                queryType: SearchQueryType.prefixAll
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_remove_words_if_no_results
    func snippetForSearchSingleIndex106() async throws {
        // >SEPARATOR searchSingleIndex override_default_remove_words_if_no_results
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                removeWordsIfNoResults: SearchRemoveWordsIfNoResults.lastWords
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_advanced_syntax_search_time
    func snippetForSearchSingleIndex107() async throws {
        // >SEPARATOR searchSingleIndex enable_advanced_syntax_search_time
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                advancedSyntax: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// overide_default_optional_words
    func snippetForSearchSingleIndex108() async throws {
        // >SEPARATOR searchSingleIndex overide_default_optional_words
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                optionalWords: SearchOptionalWords.arrayOfString(["toyota", "2020 2021"])
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disabling_exact_for_some_attributes_search_time
    func snippetForSearchSingleIndex109() async throws {
        // >SEPARATOR searchSingleIndex disabling_exact_for_some_attributes_search_time
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                disableExactOnAttributes: ["description"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_exact_single_word_query
    func snippetForSearchSingleIndex110() async throws {
        // >SEPARATOR searchSingleIndex override_default_exact_single_word_query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                exactOnSingleWordQuery: SearchExactOnSingleWordQuery.`none`
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_aternative_as_exact
    func snippetForSearchSingleIndex111() async throws {
        // >SEPARATOR searchSingleIndex override_default_aternative_as_exact
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                alternativesAsExact: [SearchAlternativesAsExact.multiWordsSynonym]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_advanced_syntax_exact_phrase
    func snippetForSearchSingleIndex112() async throws {
        // >SEPARATOR searchSingleIndex enable_advanced_syntax_exact_phrase
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                advancedSyntax: true,
                advancedSyntaxFeatures: [SearchAdvancedSyntaxFeatures.exactPhrase]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_advanced_syntax_exclude_words
    func snippetForSearchSingleIndex113() async throws {
        // >SEPARATOR searchSingleIndex enable_advanced_syntax_exclude_words
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                advancedSyntax: true,
                advancedSyntaxFeatures: [SearchAdvancedSyntaxFeatures.excludeWords]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_distinct
    func snippetForSearchSingleIndex114() async throws {
        // >SEPARATOR searchSingleIndex override_distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                distinct: SearchDistinct.int(0)
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// get_ranking_info
    func snippetForSearchSingleIndex115() async throws {
        // >SEPARATOR searchSingleIndex get_ranking_info
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                getRankingInfo: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disable_click_analytics
    func snippetForSearchSingleIndex116() async throws {
        // >SEPARATOR searchSingleIndex disable_click_analytics
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                clickAnalytics: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// enable_click_analytics
    func snippetForSearchSingleIndex117() async throws {
        // >SEPARATOR searchSingleIndex enable_click_analytics
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                clickAnalytics: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disable_analytics
    func snippetForSearchSingleIndex118() async throws {
        // >SEPARATOR searchSingleIndex disable_analytics
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                analytics: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// add_analytics_tags
    func snippetForSearchSingleIndex119() async throws {
        // >SEPARATOR searchSingleIndex add_analytics_tags
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                analyticsTags: ["front_end", "website2"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// disable_synonyms
    func snippetForSearchSingleIndex120() async throws {
        // >SEPARATOR searchSingleIndex disable_synonyms
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                synonyms: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_replace_synonyms_in_highlights
    func snippetForSearchSingleIndex121() async throws {
        // >SEPARATOR searchSingleIndex override_replace_synonyms_in_highlights
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                replaceSynonymsInHighlight: true
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_min_proximity
    func snippetForSearchSingleIndex122() async throws {
        // >SEPARATOR searchSingleIndex override_min_proximity
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                minProximity: 2
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_default_field
    func snippetForSearchSingleIndex123() async throws {
        // >SEPARATOR searchSingleIndex override_default_field
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                responseFields: ["hits", "facets"]
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// override_percentile_computation
    func snippetForSearchSingleIndex124() async throws {
        // >SEPARATOR searchSingleIndex override_percentile_computation
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                percentileComputation: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_ab_test
    func snippetForSearchSingleIndex125() async throws {
        // >SEPARATOR searchSingleIndex set_ab_test
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                enableABTest: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// set_enable_re_ranking
    func snippetForSearchSingleIndex126() async throws {
        // >SEPARATOR searchSingleIndex set_enable_re_ranking
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(
                query: "query",
                enableReRanking: false
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// with algolia user id
    func snippetForSearchSingleIndex127() async throws {
        // >SEPARATOR searchSingleIndex with algolia user id
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "query")),
            requestOptions: RequestOptions(
                headers: ["X-Algolia-User-ID": "user1234"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSingleIndex method.
    ///
    /// mcm with algolia user id
    func snippetForSearchSingleIndex128() async throws {
        // >SEPARATOR searchSingleIndex mcm with algolia user id
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "peace")),
            requestOptions: RequestOptions(
                headers: ["X-Algolia-User-ID": "user42"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSynonyms method.
    ///
    /// searchSynonyms with minimal parameters
    func snippetForSearchSynonyms() async throws {
        // >SEPARATOR searchSynonyms searchSynonyms with minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchSynonyms(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchSynonyms method.
    ///
    /// searchSynonyms with all parameters
    func snippetForSearchSynonyms1() async throws {
        // >SEPARATOR searchSynonyms searchSynonyms with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchSynonyms(
            indexName: "<YOUR_INDEX_NAME>",
            searchSynonymsParams: SearchSynonymsParams(
                query: "myQuery",
                type: SynonymType.altcorrection1,
                page: 10,
                hitsPerPage: 10
            )
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // >SEPARATOR setDictionarySettings get setDictionarySettings results with minimal parameters
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setDictionarySettings method.
    ///
    /// get setDictionarySettings results with all parameters
    func snippetForSetDictionarySettings1() async throws {
        // >SEPARATOR setDictionarySettings get setDictionarySettings results with all parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .setDictionarySettings(
                dictionarySettingsParams: DictionarySettingsParams(disableStandardEntries: StandardEntries(
                    plurals: ["fr": false, "en": false, "ru": true],
                    stopwords: ["fr": false],
                    compounds: ["ru": true]
                ))
            )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// minimal parameters
    func snippetForSetSettings() async throws {
        // >SEPARATOR setSettings minimal parameters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                paginationLimitedTo: 10,
                typoTolerance: SearchTypoTolerance.searchTypoToleranceEnum(SearchTypoToleranceEnum.`false`)
            ),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// boolean typoTolerance
    func snippetForSetSettings1() async throws {
        // >SEPARATOR setSettings boolean typoTolerance
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(typoTolerance: SearchTypoTolerance.bool(true)),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enum typoTolerance
    func snippetForSetSettings2() async throws {
        // >SEPARATOR setSettings enum typoTolerance
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(typoTolerance: SearchTypoTolerance
                .searchTypoToleranceEnum(SearchTypoToleranceEnum.min)),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ignorePlurals
    func snippetForSetSettings3() async throws {
        // >SEPARATOR setSettings ignorePlurals
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ignorePlurals: SearchIgnorePlurals.bool(true)),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// list of string ignorePlurals
    func snippetForSetSettings4() async throws {
        // >SEPARATOR setSettings list of string ignorePlurals
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ignorePlurals: SearchIgnorePlurals
                .arrayOfSearchSupportedLanguage([SearchSupportedLanguage.fr])),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// removeStopWords boolean
    func snippetForSetSettings5() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// removeStopWords list of string
    func snippetForSetSettings6() async throws {
        // >SEPARATOR setSettings removeStopWords list of string
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(removeStopWords: SearchRemoveStopWords
                .arrayOfSearchSupportedLanguage([SearchSupportedLanguage.fr])),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// boolean distinct
    func snippetForSetSettings7() async throws {
        // >SEPARATOR setSettings boolean distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(distinct: SearchDistinct.bool(true)),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// integer distinct
    func snippetForSetSettings8() async throws {
        // >SEPARATOR setSettings integer distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(distinct: SearchDistinct.int(1)),
            forwardToReplicas: true
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct company
    func snippetForSetSettings9() async throws {
        // >SEPARATOR setSettings distinct company
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "company", distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct design
    func snippetForSetSettings10() async throws {
        // >SEPARATOR setSettings distinct design
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "design", distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct true
    func snippetForSetSettings11() async throws {
        // >SEPARATOR setSettings distinct true
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// distinct section
    func snippetForSetSettings12() async throws {
        // >SEPARATOR setSettings distinct section
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "section", distinct: SearchDistinct.bool(true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting allergens
    func snippetForSetSettings13() async throws {
        // >SEPARATOR setSettings attributesForFaceting allergens
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["allergens"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting availableIn
    func snippetForSetSettings14() async throws {
        // >SEPARATOR setSettings attributesForFaceting availableIn
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["color", "availableIn"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// api_attributes_for_faceting
    func snippetForSetSettings15() async throws {
        // >SEPARATOR setSettings api_attributes_for_faceting
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["genre", "author"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// api_attributes_for_faceting_searchable
    func snippetForSetSettings16() async throws {
        // >SEPARATOR setSettings api_attributes_for_faceting_searchable
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["genre", "searchable(author)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// api_attributes_for_filter_only
    func snippetForSetSettings17() async throws {
        // >SEPARATOR setSettings api_attributes_for_filter_only
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["filterOnly(genre)", "author"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting categoryPageId
    func snippetForSetSettings18() async throws {
        // >SEPARATOR setSettings attributesForFaceting categoryPageId
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["searchable(categoryPageId)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// unretrievableAttributes
    func snippetForSetSettings19() async throws {
        // >SEPARATOR setSettings unretrievableAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(unretrievableAttributes: ["visible_by"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting user restricted data
    func snippetForSetSettings20() async throws {
        // >SEPARATOR setSettings attributesForFaceting user restricted data
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["filterOnly(visible_by)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting optional filters
    func snippetForSetSettings21() async throws {
        // >SEPARATOR setSettings attributesForFaceting optional filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["can_deliver_quickly", "restaurant"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting redirect index
    func snippetForSetSettings22() async throws {
        // >SEPARATOR setSettings attributesForFaceting redirect index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["query_terms"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting multiple consequences
    func snippetForSetSettings23() async throws {
        // >SEPARATOR setSettings attributesForFaceting multiple consequences
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["director"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting in-depth optional filters
    func snippetForSetSettings24() async throws {
        // >SEPARATOR setSettings attributesForFaceting in-depth optional filters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: ["filterOnly(brand)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// mode neuralSearch
    func snippetForSetSettings25() async throws {
        // >SEPARATOR setSettings mode neuralSearch
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(mode: SearchMode.neuralSearch)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// mode keywordSearch
    func snippetForSetSettings26() async throws {
        // >SEPARATOR setSettings mode keywordSearch
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(mode: SearchMode.keywordSearch)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes same priority
    func snippetForSetSettings27() async throws {
        // >SEPARATOR setSettings searchableAttributes same priority
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["title,comments", "ingredients"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes higher priority
    func snippetForSetSettings28() async throws {
        // >SEPARATOR setSettings searchableAttributes higher priority
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["title", "ingredients"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking retweets
    func snippetForSetSettings29() async throws {
        // >SEPARATOR setSettings customRanking retweets
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(retweets)", "desc(likes)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking boosted
    func snippetForSetSettings30() async throws {
        // >SEPARATOR setSettings customRanking boosted
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(boosted)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking pageviews
    func snippetForSetSettings31() async throws {
        // >SEPARATOR setSettings customRanking pageviews
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(pageviews)", "desc(comments)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking applying search parameters for a specific query
    func snippetForSetSettings32() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking rounded pageviews
    func snippetForSetSettings33() async throws {
        // >SEPARATOR setSettings customRanking rounded pageviews
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(rounded_pageviews)", "desc(comments)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking price
    func snippetForSetSettings34() async throws {
        // >SEPARATOR setSettings customRanking price
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(price)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking exhaustive (price)
    func snippetForSetSettings35() async throws {
        // >SEPARATOR setSettings ranking exhaustive (price)
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking exhaustive (is_popular)
    func snippetForSetSettings36() async throws {
        // >SEPARATOR setSettings ranking exhaustive (is_popular)
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: [
                "desc(is_popular)",
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking standard replica
    func snippetForSetSettings37() async throws {
        // >SEPARATOR setSettings ranking standard replica
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: ["desc(post_date_timestamp)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking virtual replica
    func snippetForSetSettings38() async throws {
        // >SEPARATOR setSettings ranking virtual replica
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(post_date_timestamp)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// customRanking and ranking sort alphabetically
    func snippetForSetSettings39() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// relevancyStrictness
    func snippetForSetSettings40() async throws {
        // >SEPARATOR setSettings relevancyStrictness
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["asc(textual_attribute)"], relevancyStrictness: 0)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// create replica index
    func snippetForSetSettings41() async throws {
        // >SEPARATOR setSettings create replica index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: ["products_price_desc"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// create replica index articles
    func snippetForSetSettings42() async throws {
        // >SEPARATOR setSettings create replica index articles
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: ["articles_date_desc"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// create virtual replica index
    func snippetForSetSettings43() async throws {
        // >SEPARATOR setSettings create virtual replica index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: ["virtual(products_price_desc)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// unlink replica index
    func snippetForSetSettings44() async throws {
        // >SEPARATOR setSettings unlink replica index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: [""])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// forwardToReplicas
    func snippetForSetSettings45() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// maxValuesPerFacet
    func snippetForSetSettings46() async throws {
        // >SEPARATOR setSettings maxValuesPerFacet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(maxValuesPerFacet: 1000)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// maxFacetHits
    func snippetForSetSettings47() async throws {
        // >SEPARATOR setSettings maxFacetHits
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(maxFacetHits: 100)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesForFaceting complex
    func snippetForSetSettings48() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// ranking closest dates
    func snippetForSetSettings49() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes item variation
    func snippetForSetSettings50() async throws {
        // >SEPARATOR setSettings searchableAttributes item variation
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["design", "type", "color"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributes around location
    func snippetForSetSettings51() async throws {
        // >SEPARATOR setSettings searchableAttributes around location
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                searchableAttributes: ["name", "country", "city", "iata_code"],
                customRanking: ["desc(links_count)"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesToHighlight
    func snippetForSetSettings52() async throws {
        // >SEPARATOR setSettings attributesToHighlight
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToHighlight: ["author", "title", "content"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// attributesToHighlightStar
    func snippetForSetSettings53() async throws {
        // >SEPARATOR setSettings attributesToHighlightStar
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToHighlight: ["*"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// everything
    func snippetForSetSettings54() async throws {
        // >SEPARATOR setSettings everything
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                attributesForFaceting: ["algolia"],
                replicas: [""],
                paginationLimitedTo: 0,
                unretrievableAttributes: ["foo"],
                disableTypoToleranceOnWords: ["algolia"],
                attributesToTransliterate: ["algolia"],
                camelCaseAttributes: ["algolia"],
                decompoundedAttributes: ["algolia": "aloglia"],
                indexLanguages: [SearchSupportedLanguage.fr],
                disablePrefixOnAttributes: ["algolia"],
                allowCompressionOfIntegerArray: true,
                numericAttributesForFiltering: ["algolia"],
                separatorsToIndex: "bar",
                searchableAttributes: ["foo"],
                userData: ["user": "data"],
                customNormalization: ["algolia": ["aloglia": "aglolia"]],
                attributeForDistinct: "test",
                maxFacetHits: 20,
                keepDiacriticsOnCharacters: "abc",
                customRanking: ["algolia"],
                attributesToRetrieve: ["algolia"],
                ranking: ["geo"],
                relevancyStrictness: 10,
                attributesToHighlight: ["algolia"],
                attributesToSnippet: ["algolia"],
                highlightPreTag: "<span>",
                highlightPostTag: "</span>",
                snippetEllipsisText: "---",
                restrictHighlightAndSnippetArrays: true,
                hitsPerPage: 10,
                minWordSizefor1Typo: 5,
                minWordSizefor2Typos: 11,
                typoTolerance: SearchTypoTolerance.bool(false),
                allowTyposOnNumericTokens: true,
                disableTypoToleranceOnAttributes: ["algolia"],
                ignorePlurals: SearchIgnorePlurals.bool(false),
                removeStopWords: SearchRemoveStopWords.bool(false),
                queryLanguages: [SearchSupportedLanguage.fr],
                decompoundQuery: false,
                enableRules: true,
                enablePersonalization: true,
                queryType: SearchQueryType.prefixLast,
                removeWordsIfNoResults: SearchRemoveWordsIfNoResults.lastWords,
                mode: SearchMode.neuralSearch,
                semanticSearch: SearchSemanticSearch(eventSources: ["foo"]),
                advancedSyntax: true,
                optionalWords: SearchOptionalWords.arrayOfString(["myspace"]),
                disableExactOnAttributes: ["algolia"],
                exactOnSingleWordQuery: SearchExactOnSingleWordQuery.attribute,
                alternativesAsExact: [SearchAlternativesAsExact.singleWordSynonym],
                advancedSyntaxFeatures: [SearchAdvancedSyntaxFeatures.exactPhrase],
                distinct: SearchDistinct.int(3),
                replaceSynonymsInHighlight: true,
                minProximity: 6,
                responseFields: ["algolia"],
                maxValuesPerFacet: 30,
                sortFacetValuesBy: "date",
                attributeCriteriaComputedByMinProximity: true,
                renderingContent: SearchRenderingContent(facetOrdering: SearchFacetOrdering(
                    facets: SearchFacets(order: ["a", "b"]),
                    values: ["a": SearchValue(order: ["b"], sortRemainingBy: SearchSortRemainingBy.count)]
                )),
                enableReRanking: false,
                reRankingApplyFilter: SearchReRankingApplyFilter.string("mySearch:filters")
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesWithCustomRankingsAndAttributesForFaceting
    func snippetForSetSettings55() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesOrdering
    func snippetForSetSettings56() async throws {
        // >SEPARATOR setSettings searchableAttributesOrdering
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["unordered(title)", "cast"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesProductReferenceSuffixes
    func snippetForSetSettings57() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// queryLanguageAndIgnorePlurals
    func snippetForSetSettings58() async throws {
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesInMovies
    func snippetForSetSettings59() async throws {
        // >SEPARATOR setSettings searchableAttributesInMovies
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["title_eng", "title_fr", "title_es"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disablePrefixOnAttributes
    func snippetForSetSettings60() async throws {
        // >SEPARATOR setSettings disablePrefixOnAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disablePrefixOnAttributes: ["serial_number"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disableTypoToleranceOnAttributes
    func snippetForSetSettings61() async throws {
        // >SEPARATOR setSettings disableTypoToleranceOnAttributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disableTypoToleranceOnAttributes: ["serial_number"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesSimpleExample
    func snippetForSetSettings62() async throws {
        // >SEPARATOR setSettings searchableAttributesSimpleExample
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["serial_number"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// searchableAttributesSimpleExampleAlt
    func snippetForSetSettings63() async throws {
        // >SEPARATOR setSettings searchableAttributesSimpleExampleAlt
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: ["serial_number", "serial_number_suffixes"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_searchable_attributes
    func snippetForSetSettings64() async throws {
        // >SEPARATOR setSettings set_searchable_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(searchableAttributes: [
                "title,alternative_title",
                "author",
                "unordered(text)",
                "emails.personal",
            ])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_attributes_for_faceting
    func snippetForSetSettings65() async throws {
        // >SEPARATOR setSettings set_attributes_for_faceting
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesForFaceting: [
                "author",
                "filterOnly(isbn)",
                "searchable(edition)",
                "afterDistinct(category)",
                "afterDistinct(searchable(publisher))",
            ])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// unretrievable_attributes
    func snippetForSetSettings66() async throws {
        // >SEPARATOR setSettings unretrievable_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(unretrievableAttributes: ["total_number_of_sales"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_retrievable_attributes
    func snippetForSetSettings67() async throws {
        // >SEPARATOR setSettings set_retrievable_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToRetrieve: ["author", "title", "content"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_all_attributes_as_retrievable
    func snippetForSetSettings68() async throws {
        // >SEPARATOR setSettings set_all_attributes_as_retrievable
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToRetrieve: ["*"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// specify_attributes_not_to_retrieve
    func snippetForSetSettings69() async throws {
        // >SEPARATOR setSettings specify_attributes_not_to_retrieve
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToRetrieve: ["*", "-SKU", "-internal_desc"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// neural_search
    func snippetForSetSettings70() async throws {
        // >SEPARATOR setSettings neural_search
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(mode: SearchMode.neuralSearch)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// keyword_search
    func snippetForSetSettings71() async throws {
        // >SEPARATOR setSettings keyword_search
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(mode: SearchMode.keywordSearch)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_ranking
    func snippetForSetSettings72() async throws {
        // >SEPARATOR setSettings set_default_ranking
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: [
                "typo",
                "geo",
                "words",
                "filters",
                "attribute",
                "proximity",
                "exact",
                "custom",
            ])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_ranking_by_attribute_asc
    func snippetForSetSettings73() async throws {
        // >SEPARATOR setSettings set_ranking_by_attribute_asc
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(ranking: [
                "asc(price)",
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_ranking_by_attribute_desc
    func snippetForSetSettings74() async throws {
        // >SEPARATOR setSettings set_ranking_by_attribute_desc
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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_custom_ranking
    func snippetForSetSettings75() async throws {
        // >SEPARATOR setSettings set_custom_ranking
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customRanking: ["desc(popularity)", "asc(price)"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_relevancy
    func snippetForSetSettings76() async throws {
        // >SEPARATOR setSettings set_default_relevancy
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(relevancyStrictness: 90)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_replicas
    func snippetForSetSettings77() async throws {
        // >SEPARATOR setSettings set_replicas
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replicas: ["name_of_replica_index1", "name_of_replica_index2"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_max_values_per_facet
    func snippetForSetSettings78() async throws {
        // >SEPARATOR setSettings set_default_max_values_per_facet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(maxValuesPerFacet: 100)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_sort_facet_values_by
    func snippetForSetSettings79() async throws {
        // >SEPARATOR setSettings set_default_sort_facet_values_by
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(sortFacetValuesBy: "alpha")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_attributes_to_snippet
    func snippetForSetSettings80() async throws {
        // >SEPARATOR setSettings set_attributes_to_snippet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToSnippet: ["content:80", "description"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_all_attributes_to_snippet
    func snippetForSetSettings81() async throws {
        // >SEPARATOR setSettings set_all_attributes_to_snippet
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributesToSnippet: ["*:80"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_highlight_pre_tag
    func snippetForSetSettings82() async throws {
        // >SEPARATOR setSettings set_default_highlight_pre_tag
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(highlightPreTag: "<em>")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_highlight_post_tag
    func snippetForSetSettings83() async throws {
        // >SEPARATOR setSettings set_default_highlight_post_tag
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(highlightPostTag: "</em>")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_snippet_ellipsis_text
    func snippetForSetSettings84() async throws {
        // >SEPARATOR setSettings set_default_snippet_ellipsis_text
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(snippetEllipsisText: "…")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enable_restrict_highlight_and_snippet_arrays_by_default
    func snippetForSetSettings85() async throws {
        // >SEPARATOR setSettings enable_restrict_highlight_and_snippet_arrays_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(restrictHighlightAndSnippetArrays: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_hits_per_page
    func snippetForSetSettings86() async throws {
        // >SEPARATOR setSettings set_default_hits_per_page
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(hitsPerPage: 20)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_pagination_limit
    func snippetForSetSettings87() async throws {
        // >SEPARATOR setSettings set_pagination_limit
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(paginationLimitedTo: 1000)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_min_word_size_for_one_typo
    func snippetForSetSettings88() async throws {
        // >SEPARATOR setSettings set_default_min_word_size_for_one_typo
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(minWordSizefor1Typo: 4)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_min_word_size_for_two_typos
    func snippetForSetSettings89() async throws {
        // >SEPARATOR setSettings set_default_min_word_size_for_two_typos
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(minWordSizefor2Typos: 4)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_typo_tolerance_mode
    func snippetForSetSettings90() async throws {
        // >SEPARATOR setSettings set_default_typo_tolerance_mode
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(typoTolerance: SearchTypoTolerance.bool(true))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disable_typos_on_numeric_tokens_by_default
    func snippetForSetSettings91() async throws {
        // >SEPARATOR setSettings disable_typos_on_numeric_tokens_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(allowTyposOnNumericTokens: false)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disable_typo_tolerance_for_words
    func snippetForSetSettings92() async throws {
        // >SEPARATOR setSettings disable_typo_tolerance_for_words
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disableTypoToleranceOnWords: ["wheel", "1X2BCD"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_separators_to_index
    func snippetForSetSettings93() async throws {
        // >SEPARATOR setSettings set_separators_to_index
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(separatorsToIndex: "+#")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_querylanguage_ignoreplurals
    func snippetForSetSettings94() async throws {
        // >SEPARATOR setSettings set_querylanguage_ignoreplurals
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                ignorePlurals: SearchIgnorePlurals.bool(true),
                queryLanguages: [SearchSupportedLanguage.es]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_attributes_to_transliterate
    func snippetForSetSettings95() async throws {
        // >SEPARATOR setSettings set_attributes_to_transliterate
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                attributesToTransliterate: ["name", "description"],
                indexLanguages: [SearchSupportedLanguage.ja]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_querylanguage_removestopwords
    func snippetForSetSettings96() async throws {
        // >SEPARATOR setSettings set_querylanguage_removestopwords
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                removeStopWords: SearchRemoveStopWords.bool(true),
                queryLanguages: [SearchSupportedLanguage.es]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_camel_case_attributes
    func snippetForSetSettings97() async throws {
        // >SEPARATOR setSettings set_camel_case_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(camelCaseAttributes: ["description"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_decompounded_attributes
    func snippetForSetSettings98() async throws {
        // >SEPARATOR setSettings set_decompounded_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(decompoundedAttributes: ["de": ["name"]])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_decompounded_multiple_attributes
    func snippetForSetSettings99() async throws {
        // >SEPARATOR setSettings set_decompounded_multiple_attributes
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(decompoundedAttributes: [
                "de": ["name_de", "description_de"],
                "fi": ["name_fi", "description_fi"],
            ])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_keep_diacritics_on_characters
    func snippetForSetSettings100() async throws {
        // >SEPARATOR setSettings set_keep_diacritics_on_characters
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(keepDiacriticsOnCharacters: "øé")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_custom_normalization
    func snippetForSetSettings101() async throws {
        // >SEPARATOR setSettings set_custom_normalization
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(customNormalization: ["default": ["ä": "ae"]])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_querylanguage_both
    func snippetForSetSettings102() async throws {
        // >SEPARATOR setSettings set_querylanguage_both
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                ignorePlurals: SearchIgnorePlurals.bool(true),
                removeStopWords: SearchRemoveStopWords.bool(true),
                queryLanguages: [SearchSupportedLanguage.es]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_indexlanguages
    func snippetForSetSettings103() async throws {
        // >SEPARATOR setSettings set_indexlanguages
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(indexLanguages: [SearchSupportedLanguage.ja])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enable_decompound_query_by_default
    func snippetForSetSettings104() async throws {
        // >SEPARATOR setSettings enable_decompound_query_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(decompoundQuery: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enable_rules_syntax_by_default
    func snippetForSetSettings105() async throws {
        // >SEPARATOR setSettings enable_rules_syntax_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(enableRules: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enable_personalization_settings
    func snippetForSetSettings106() async throws {
        // >SEPARATOR setSettings enable_personalization_settings
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(enablePersonalization: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_query_type
    func snippetForSetSettings107() async throws {
        // >SEPARATOR setSettings set_default_query_type
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(queryType: SearchQueryType.prefixLast)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_remove_words_if_no_result
    func snippetForSetSettings108() async throws {
        // >SEPARATOR setSettings set_default_remove_words_if_no_result
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(removeWordsIfNoResults: SearchRemoveWordsIfNoResults.`none`)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enable_advanced_syntax_by_default
    func snippetForSetSettings109() async throws {
        // >SEPARATOR setSettings enable_advanced_syntax_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(advancedSyntax: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_optional_words
    func snippetForSetSettings110() async throws {
        // >SEPARATOR setSettings set_default_optional_words
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(optionalWords: SearchOptionalWords.arrayOfString(["blue", "iphone case"]))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disabling_prefix_search_for_some_attributes_by_default
    func snippetForSetSettings111() async throws {
        // >SEPARATOR setSettings disabling_prefix_search_for_some_attributes_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disablePrefixOnAttributes: ["sku"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// disabling_exact_for_some_attributes_by_default
    func snippetForSetSettings112() async throws {
        // >SEPARATOR setSettings disabling_exact_for_some_attributes_by_default
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(disableExactOnAttributes: ["description"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_exact_single_word_query
    func snippetForSetSettings113() async throws {
        // >SEPARATOR setSettings set_default_exact_single_word_query
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(exactOnSingleWordQuery: SearchExactOnSingleWordQuery.attribute)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_aternative_as_exact
    func snippetForSetSettings114() async throws {
        // >SEPARATOR setSettings set_default_aternative_as_exact
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(alternativesAsExact: [
                SearchAlternativesAsExact.ignorePlurals,
                SearchAlternativesAsExact.singleWordSynonym,
            ])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_numeric_attributes_for_filtering
    func snippetForSetSettings115() async throws {
        // >SEPARATOR setSettings set_numeric_attributes_for_filtering
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(numericAttributesForFiltering: ["quantity", "popularity"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// enable_compression_of_integer_array
    func snippetForSetSettings116() async throws {
        // >SEPARATOR setSettings enable_compression_of_integer_array
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(allowCompressionOfIntegerArray: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_attributes_for_distinct
    func snippetForSetSettings117() async throws {
        // >SEPARATOR setSettings set_attributes_for_distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "url")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_distinct
    func snippetForSetSettings118() async throws {
        // >SEPARATOR setSettings set_distinct
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeForDistinct: "url", distinct: SearchDistinct.int(1))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_replace_synonyms_in_highlights
    func snippetForSetSettings119() async throws {
        // >SEPARATOR setSettings set_replace_synonyms_in_highlights
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(replaceSynonymsInHighlight: false)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_min_proximity
    func snippetForSetSettings120() async throws {
        // >SEPARATOR setSettings set_min_proximity
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(minProximity: 1)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_default_field
    func snippetForSetSettings121() async throws {
        // >SEPARATOR setSettings set_default_field
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(responseFields: ["hits", "hitsPerPage", "nbPages", "page"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_max_facet_hits
    func snippetForSetSettings122() async throws {
        // >SEPARATOR setSettings set_max_facet_hits
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(maxFacetHits: 10)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_attribute_criteria_computed_by_min_proximity
    func snippetForSetSettings123() async throws {
        // >SEPARATOR setSettings set_attribute_criteria_computed_by_min_proximity
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(attributeCriteriaComputedByMinProximity: true)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_user_data
    func snippetForSetSettings124() async throws {
        // >SEPARATOR setSettings set_user_data
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(
                userData: ["extraData": "This is the custom data that you want to store in your index"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setSettings method.
    ///
    /// set_rendering_content
    func snippetForSetSettings125() async throws {
        // >SEPARATOR setSettings set_rendering_content
        // Initialize the client
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.setSettings(
            indexName: "<YOUR_INDEX_NAME>",
            indexSettings: IndexSettings(renderingContent: SearchRenderingContent(facetOrdering: SearchFacetOrdering(
                facets: SearchFacets(order: ["size", "brand"]),
                values: [
                    "brand": SearchValue(
                        order: ["uniqlo"],
                        sortRemainingBy: SearchSortRemainingBy.count,
                        hide: ["muji"]
                    ),
                    "size": SearchValue(order: ["S", "M", "L"], sortRemainingBy: SearchSortRemainingBy.hidden),
                ]
            )))
        )
        // >LOG
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
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
        // print the response
        print(response)
        // SEPARATOR<
    }
}

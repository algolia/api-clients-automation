#if canImport(Core)
    import Core
#endif
// >IMPORT
import Recommend

// IMPORT<

final class RecommendClientSnippet {
    /// Snippet for the batchRecommendRules method.
    ///
    /// batch recommend rules
    func snippetForBatchRecommendRules() async throws {
        // >SEPARATOR batchRecommendRules default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.batchRecommendRules(
            indexName: "<YOUR_INDEX_NAME>",
            model: RecommendModels.relatedProducts
        )
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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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

    /// Snippet for the deleteRecommendRule method.
    ///
    /// deleteRecommendRule
    func snippetForDeleteRecommendRule() async throws {
        // >SEPARATOR deleteRecommendRule default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteRecommendRule(
            indexName: "<YOUR_INDEX_NAME>",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendRule method.
    ///
    /// getRecommendRule
    func snippetForGetRecommendRule() async throws {
        // >SEPARATOR getRecommendRule default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getRecommendRule(
            indexName: "<YOUR_INDEX_NAME>",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendStatus method.
    ///
    /// getRecommendStatus
    func snippetForGetRecommendStatus() async throws {
        // >SEPARATOR getRecommendStatus default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getRecommendStatus(
            indexName: "<YOUR_INDEX_NAME>",
            model: RecommendModels.relatedProducts,
            taskID: Int64(12345)
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for recommend model with minimal parameters
    func snippetForGetRecommendations() async throws {
        // >SEPARATOR getRecommendations get recommendations for recommend model with minimal parameters
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [RecommendationsRequest
                    .relatedQuery(RelatedQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 42.1,
                        model: RelatedModel.relatedProducts,
                        objectID: "objectID"
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations with e2e to check oneOf model
    func snippetForGetRecommendations1() async throws {
        // >SEPARATOR getRecommendations get recommendations with e2e to check oneOf model
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [RecommendationsRequest
                    .relatedQuery(RelatedQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 20.0,
                        maxRecommendations: 2,
                        model: RelatedModel.relatedProducts,
                        objectID: "Æon Flux"
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for recommend model with all parameters
    func snippetForGetRecommendations2() async throws {
        // >SEPARATOR getRecommendations get recommendations for recommend model with all parameters
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [RecommendationsRequest
                    .relatedQuery(RelatedQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 42.1,
                        maxRecommendations: 10,
                        queryParameters: RecommendSearchParams(
                            facetFilters: RecommendFacetFilters
                                .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("query")]),
                            query: "myQuery"
                        ),
                        model: RelatedModel.relatedProducts,
                        objectID: "objectID",
                        fallbackParameters: FallbackParams(
                            facetFilters: RecommendFacetFilters
                                .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("fallback")]),
                            query: "myQuery"
                        )
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for trending model with minimal parameters
    func snippetForGetRecommendations3() async throws {
        // >SEPARATOR getRecommendations get recommendations for trending model with minimal parameters
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [RecommendationsRequest
                    .trendingItemsQuery(TrendingItemsQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 42.1,
                        facetName: "facet",
                        facetValue: "value",
                        model: TrendingItemsModel.trendingItems
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for trending model with all parameters
    func snippetForGetRecommendations4() async throws {
        // >SEPARATOR getRecommendations get recommendations for trending model with all parameters
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [RecommendationsRequest
                    .trendingItemsQuery(TrendingItemsQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 42.1,
                        maxRecommendations: 10,
                        queryParameters: RecommendSearchParams(
                            facetFilters: RecommendFacetFilters
                                .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("query")]),
                            query: "myQuery"
                        ),
                        facetName: "myFacetName",
                        facetValue: "myFacetValue",
                        model: TrendingItemsModel.trendingItems,
                        fallbackParameters: FallbackParams(
                            facetFilters: RecommendFacetFilters
                                .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("fallback")]),
                            query: "myQuery"
                        )
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get multiple recommendations with minimal parameters
    func snippetForGetRecommendations5() async throws {
        // >SEPARATOR getRecommendations get multiple recommendations with minimal parameters
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [
                RecommendationsRequest.relatedQuery(RelatedQuery(
                    indexName: "<YOUR_INDEX_NAME>",
                    threshold: 21.7,
                    model: RelatedModel.relatedProducts,
                    objectID: "objectID1"
                )),
                RecommendationsRequest.relatedQuery(RelatedQuery(
                    indexName: "<YOUR_INDEX_NAME>",
                    threshold: 21.7,
                    model: RelatedModel.relatedProducts,
                    objectID: "objectID2"
                )),
            ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get multiple recommendations with all parameters
    func snippetForGetRecommendations6() async throws {
        // >SEPARATOR getRecommendations get multiple recommendations with all parameters
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [
                RecommendationsRequest.relatedQuery(RelatedQuery(
                    indexName: "<YOUR_INDEX_NAME>",
                    threshold: 21.7,
                    maxRecommendations: 10,
                    queryParameters: RecommendSearchParams(
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("query1")]),
                        query: "myQuery"
                    ),
                    model: RelatedModel.relatedProducts,
                    objectID: "objectID1",
                    fallbackParameters: FallbackParams(
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("fallback1")]),
                        query: "myQuery"
                    )
                )),
                RecommendationsRequest.relatedQuery(RelatedQuery(
                    indexName: "<YOUR_INDEX_NAME>",
                    threshold: 21.7,
                    maxRecommendations: 10,
                    queryParameters: RecommendSearchParams(
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("query2")]),
                        query: "myQuery"
                    ),
                    model: RelatedModel.relatedProducts,
                    objectID: "objectID2",
                    fallbackParameters: FallbackParams(
                        facetFilters: RecommendFacetFilters
                            .arrayOfRecommendFacetFilters([RecommendFacetFilters.string("fallback2")]),
                        query: "myQuery"
                    )
                )),
            ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get frequently bought together recommendations
    func snippetForGetRecommendations7() async throws {
        // >SEPARATOR getRecommendations get frequently bought together recommendations
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [RecommendationsRequest
                    .boughtTogetherQuery(BoughtTogetherQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 42.7,
                        model: FbtModel.boughtTogether,
                        objectID: "objectID1"
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchRecommendRules method.
    ///
    /// searchRecommendRules
    func snippetForSearchRecommendRules() async throws {
        // >SEPARATOR searchRecommendRules default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchRecommendRules(
            indexName: "<YOUR_INDEX_NAME>",
            model: RecommendModels.relatedProducts
        )
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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }
}

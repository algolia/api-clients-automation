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
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
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
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for recommend model with minimal parameters
    func snippetForGetRecommendations() async throws {
        // >SEPARATOR getRecommendations default
        // Initialize the client
        let client = try RecommendClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [
                RecommendationsRequest
                    .relatedQuery(RelatedQuery(
                        indexName: "<YOUR_INDEX_NAME>",
                        threshold: 42.1,
                        model: RelatedModel.relatedProducts,
                        objectID: "objectID"
                    )),
            ]))
        // >LOG
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

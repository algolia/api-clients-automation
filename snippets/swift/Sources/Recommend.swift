#if canImport(Core)
    import Core
#endif
// >IMPORT
import Recommend

// IMPORT<

final class RecommendClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

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
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

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
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

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
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the deleteRecommendRule method.
    ///
    /// deleteRecommendRule
    func snippetForDeleteRecommendRule() async throws {
        // >SEPARATOR deleteRecommendRule default
        // Initialize the client
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.deleteRecommendRule(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
        // SEPARATOR<
    }

    /// Snippet for the getRecommendRule method.
    ///
    /// getRecommendRule
    func snippetForGetRecommendRule() async throws {
        // >SEPARATOR getRecommendRule default
        // Initialize the client
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getRecommendRule(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
        // SEPARATOR<
    }

    /// Snippet for the getRecommendStatus method.
    ///
    /// getRecommendStatus
    func snippetForGetRecommendStatus() async throws {
        // >SEPARATOR getRecommendStatus default
        // Initialize the client
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getRecommendStatus(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            taskID: Int64(12345)
        )
        // SEPARATOR<
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for recommend model with minimal parameters
    func snippetForGetRecommendations() async throws {
        // >SEPARATOR getRecommendations default
        // Initialize the client
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client
            .getRecommendations(getRecommendationsParams: GetRecommendationsParams(requests: [
                RecommendationsRequest
                    .relatedQuery(RelatedQuery(
                        indexName: "indexName",
                        threshold: 42.1,
                        model: RelatedModel.relatedProducts,
                        objectID: "objectID"
                    )),
            ]))
        // SEPARATOR<
    }

    /// Snippet for the searchRecommendRules method.
    ///
    /// searchRecommendRules
    func snippetForSearchRecommendRules() async throws {
        // >SEPARATOR searchRecommendRules default
        // Initialize the client
        let client = try RecommendClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.searchRecommendRules(
            indexName: "indexName",
            model: RecommendModels.relatedProducts
        )
        // SEPARATOR<
    }
}

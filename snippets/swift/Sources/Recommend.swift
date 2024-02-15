#if canImport(AnyCodable)
    import AnyCodable
#endif

import Core
import Recommend

final class RecommendClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customDelete(
            path: "/test/minimal"
        )
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customGet(
            path: "/test/minimal"
        )
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPost(
            path: "/test/minimal"
        )
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the deleteRecommendRule method.
    ///
    /// deleteRecommendRule0
    func snippetForDeleteRecommendRule() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.deleteRecommendRule(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
    }

    /// Snippet for the getRecommendRule method.
    ///
    /// getRecommendRule0
    func snippetForGetRecommendRule() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getRecommendRule(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            objectID: "objectID"
        )
    }

    /// Snippet for the getRecommendStatus method.
    ///
    /// getRecommendStatus0
    func snippetForGetRecommendStatus() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.getRecommendStatus(
            indexName: "indexName",
            model: RecommendModels.relatedProducts,
            taskID: Int64(12345)
        )
    }

    /// Snippet for the getRecommendations method.
    ///
    /// get recommendations for recommend model with minimal parameters
    func snippetForGetRecommendations() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client
            .getRecommendations(
                getRecommendationsParams: GetRecommendationsParams(
                    requests: [
                        RecommendationsRequest
                            .recommendationsQuery(
                                RecommendationsQuery(
                                    indexName: "indexName",
                                    threshold: 42,
                                    model: RecommendationModels.relatedProducts,
                                    objectID: "objectID"
                                )
                            ),
                    ]
                )
            )
    }

    /// Snippet for the searchRecommendRules method.
    ///
    /// searchRecommendRules0
    func snippetForSearchRecommendRules() async throws {
        // Initialize the client
        let client = try RecommendClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        _ = try await client.searchRecommendRules(
            indexName: "indexName",
            model: RecommendModels.relatedProducts
        )
    }
}

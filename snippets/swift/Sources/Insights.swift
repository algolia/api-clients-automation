#if canImport(Core)
    import Core
#endif
// >IMPORT
import Insights

// IMPORT<

final class InsightsClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteUserToken method.
    ///
    /// deleteUserToken
    func snippetForDeleteUserToken() async throws {
        // >SEPARATOR deleteUserToken default
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try await client.deleteUserToken(userToken: "test-user-1")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the pushEvents method.
    ///
    /// pushEvents
    func snippetForPushEvents() async throws {
        // >SEPARATOR pushEvents default
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .pushEvents(insightsEvents: InsightsEvents(events: [
                EventsItems
                    .clickedObjectIDsAfterSearch(ClickedObjectIDsAfterSearch(
                        eventName: "Product Clicked",
                        eventType: ClickEvent.click,
                        index: "products",
                        objectIDs: ["9780545139700", "9780439784542"],
                        positions: [7, 6],
                        queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                        userToken: "user-123456",
                        authenticatedUserToken: "user-123456",
                        timestamp: Int64(1_641_290_601_962)
                    )),
            ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }
}

import AnyCodable

import Core
import Insights

final class InsightsClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try InsightsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try InsightsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try InsightsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try InsightsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the deleteUserToken method.
    ///
    /// deleteUserToken0
    func snippetForDeleteUserToken() async throws {
        // Initialize the client
        let client = try InsightsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteUserToken(
            userToken: "test-user-1"
        )
    }

    /// Snippet for the pushEvents method.
    ///
    /// pushEvents0
    func snippetForPushEvents() async throws {
        // Initialize the client
        let client = try InsightsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client
            .pushEvents(
                insightsEvents: InsightsEvents(
                    events: [
                        EventsItems
                            .clickedObjectIDsAfterSearch(
                                ClickedObjectIDsAfterSearch(
                                    eventName: "Product Clicked",
                                    eventType: ClickEvent.click,
                                    index: "products",
                                    objectIDs: [
                                        "9780545139700",
                                        "9780439784542",
                                    ],
                                    positions: [
                                        7,
                                        6,
                                    ],
                                    queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                                    userToken: "user-123456",
                                    authenticatedUserToken: "user-123456",
                                    timestamp: Int64(1_641_290_601_962)
                                )
                            ),
                    ]
                )
            )
    }
}

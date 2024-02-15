#if canImport(AnyCodable)
    import AnyCodable
#endif

import Abtesting
import Core

final class AbtestingClientSnippet {
    /// Snippet for the addABTests method.
    ///
    /// addABTests with minimal parameters
    func snippetForAddABTests() async throws {
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.addABTests(
            addABTestsRequest: AddABTestsRequest(
                name: "myABTest",
                variants: [AddABTestsVariant.abTestsVariant(
                    AbTestsVariant(
                        index: "AB_TEST_1",
                        trafficPercentage: 30
                    )
                ), AddABTestsVariant.abTestsVariant(
                    AbTestsVariant(
                        index: "AB_TEST_2",
                        trafficPercentage: 50
                    )
                )],
                endAt: "2022-12-31T00:00:00.000Z"
            )
        )
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the deleteABTest method.
    ///
    /// deleteABTest
    func snippetForDeleteABTest() async throws {
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteABTest(
            id: 42
        )
    }

    /// Snippet for the getABTest method.
    ///
    /// getABTest
    func snippetForGetABTest() async throws {
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getABTest(
            id: 42
        )
    }

    /// Snippet for the listABTests method.
    ///
    /// listABTests with minimal parameters
    func snippetForListABTests() async throws {
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.listABTests()
    }

    /// Snippet for the stopABTest method.
    ///
    /// stopABTest
    func snippetForStopABTest() async throws {
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.stopABTest(
            id: 42
        )
    }
}

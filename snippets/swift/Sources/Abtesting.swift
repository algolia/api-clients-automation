import AnyCodable

import Abtesting
import Core

final class AbtestingClientSnippet {
    /// Snippet for the addABTests method.
    ///
    /// addABTests with minimal parameters
    func snippetForAddABTests() async throws {
        // >SEPARATOR addABTests
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
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customDelete(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customGet(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPost(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteABTest method.
    ///
    /// deleteABTest
    func snippetForDeleteABTest() async throws {
        // >SEPARATOR deleteABTest
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteABTest(
            id: 42
        )
        // SEPARATOR<
    }

    /// Snippet for the getABTest method.
    ///
    /// getABTest
    func snippetForGetABTest() async throws {
        // >SEPARATOR getABTest
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getABTest(
            id: 42
        )
        // SEPARATOR<
    }

    /// Snippet for the listABTests method.
    ///
    /// listABTests with minimal parameters
    func snippetForListABTests() async throws {
        // >SEPARATOR listABTests
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.listABTests()
        // SEPARATOR<
    }

    /// Snippet for the stopABTest method.
    ///
    /// stopABTest
    func snippetForStopABTest() async throws {
        // >SEPARATOR stopABTest
        // Initialize the client
        let client = try AbtestingClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.stopABTest(
            id: 42
        )
        // SEPARATOR<
    }
}

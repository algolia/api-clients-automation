#if canImport(Core)
    import Core
#endif
// >IMPORT
import Abtesting

// IMPORT<

final class AbtestingClientSnippet {
    /// Snippet for the addABTests method.
    ///
    /// addABTests with minimal parameters
    func snippetForAddABTests() async throws {
        // >SEPARATOR addABTests default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.addABTests(addABTestsRequest: AddABTestsRequest(
            name: "myABTest",
            variants: [
                AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_1", trafficPercentage: 30)),
                AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_2", trafficPercentage: 50)),
            ],
            endAt: "2022-12-31T00:00:00.000Z"
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteABTest method.
    ///
    /// deleteABTest
    func snippetForDeleteABTest() async throws {
        // >SEPARATOR deleteABTest default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteABTest(id: 42)
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getABTest method.
    ///
    /// getABTest
    func snippetForGetABTest() async throws {
        // >SEPARATOR getABTest default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getABTest(id: 42)
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listABTests method.
    ///
    /// listABTests with minimal parameters
    func snippetForListABTests() async throws {
        // >SEPARATOR listABTests default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listABTests()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the scheduleABTest method.
    ///
    /// scheduleABTest with minimal parameters
    func snippetForScheduleABTest() async throws {
        // >SEPARATOR scheduleABTest default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.scheduleABTest(scheduleABTestsRequest: ScheduleABTestsRequest(
            name: "myABTest",
            variants: [
                AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_1", trafficPercentage: 30)),
                AddABTestsVariant.abTestsVariant(AbTestsVariant(index: "AB_TEST_2", trafficPercentage: 50)),
            ],
            scheduledAt: "2022-11-31T00:00:00.000Z",
            endAt: "2022-12-31T00:00:00.000Z"
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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the stopABTest method.
    ///
    /// stopABTest
    func snippetForStopABTest() async throws {
        // >SEPARATOR stopABTest default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.stopABTest(id: 42)
        // >LOG
        // SEPARATOR<
    }
}

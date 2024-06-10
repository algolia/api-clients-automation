#if canImport(Core)
    import Core
#endif
// >IMPORT
import Usage

// IMPORT<

final class UsageClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try UsageClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

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
        let client = try UsageClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

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
        let client = try UsageClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

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
        let client = try UsageClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the getIndexUsage method.
    ///
    /// getIndexUsage with minimal parameters
    func snippetForGetIndexUsage() async throws {
        // >SEPARATOR getIndexUsage default
        // Initialize the client
        let client = try UsageClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getIndexUsage(
            statistic: Statistic.queriesOperations,
            indexName: "myIndexName",
            startDate: "2024-04-03T12:46:43Z",
            endDate: "2024-04-05T12:46:43Z"
        )
        // SEPARATOR<
    }

    /// Snippet for the getUsage method.
    ///
    /// getUsage with minimal parameters
    func snippetForGetUsage() async throws {
        // >SEPARATOR getUsage default
        // Initialize the client
        let client = try UsageClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY")

        // Call the API
        let response = try await client.getUsage(
            statistic: Statistic.queriesOperations,
            startDate: "2024-04-03T12:46:43Z",
            endDate: "2024-04-05T12:46:43Z"
        )
        // SEPARATOR<
    }
}

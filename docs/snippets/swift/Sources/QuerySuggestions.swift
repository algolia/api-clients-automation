#if canImport(Core)
    import Core
#endif
// >IMPORT
import QuerySuggestions

// IMPORT<

final class QuerySuggestionsClientSnippet {
    /// Snippet for the createConfig method.
    ///
    /// createConfig
    func snippetForCreateConfig() async throws {
        // >SEPARATOR createConfig default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createConfig(configurationWithIndex: ConfigurationWithIndex(
            sourceIndices: [SourceIndex(
                indexName: "<YOUR_INDEX_NAME>",
                facets: [Facet(attribute: "test")],
                generate: [["facetA", "facetB"], ["facetC"]]
            )],
            languages: QuerySuggestionsLanguages.arrayOfString(["french"]),
            exclude: ["test"],
            indexName: "<YOUR_INDEX_NAME>"
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
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteConfig method.
    ///
    /// deleteConfig
    func snippetForDeleteConfig() async throws {
        // >SEPARATOR deleteConfig default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteConfig(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getAllConfigs method.
    ///
    /// getAllConfigs
    func snippetForGetAllConfigs() async throws {
        // >SEPARATOR getAllConfigs default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAllConfigs()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getConfig method.
    ///
    /// Retrieve QS config e2e
    func snippetForGetConfig() async throws {
        // >SEPARATOR getConfig default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getConfig(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getConfigStatus method.
    ///
    /// getConfigStatus
    func snippetForGetConfigStatus() async throws {
        // >SEPARATOR getConfigStatus default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getConfigStatus(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getLogFile method.
    ///
    /// getLogFile
    func snippetForGetLogFile() async throws {
        // >SEPARATOR getLogFile default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getLogFile(indexName: "<YOUR_INDEX_NAME>")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateConfig method.
    ///
    /// updateConfig
    func snippetForUpdateConfig() async throws {
        // >SEPARATOR updateConfig default
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateConfig(
            indexName: "<YOUR_INDEX_NAME>",
            configuration: QuerySuggestionsConfiguration(
                sourceIndices: [SourceIndex(
                    indexName: "<YOUR_INDEX_NAME>",
                    facets: [Facet(attribute: "test")],
                    generate: [["facetA", "facetB"], ["facetC"]]
                )],
                languages: QuerySuggestionsLanguages.arrayOfString(["french"]),
                exclude: ["test"]
            )
        )
        // >LOG
        // SEPARATOR<
    }
}

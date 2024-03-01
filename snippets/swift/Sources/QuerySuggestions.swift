import AnyCodable

import Core
import QuerySuggestions

final class QuerySuggestionsClientSnippet {
    /// Snippet for the createConfig method.
    ///
    /// createConfig0
    func snippetForCreateConfig() async throws {
        // >SEPARATOR createConfig
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.createConfig(
            querySuggestionsConfigurationWithIndex: QuerySuggestionsConfigurationWithIndex(
                indexName: "theIndexName",
                sourceIndices: [
                    SourceIndex(
                        indexName: "testIndex",
                        facets: [
                            Facet(
                                attribute: "test"
                            ),
                        ],
                        generate: [
                            [
                                "facetA",
                                "facetB",
                            ],
                            [
                                "facetC",
                            ],
                        ]
                    ),
                ],
                languages: Languages.arrayOfString(
                    [
                        "french",
                    ]
                ),
                exclude: [
                    "test",
                ]
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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteConfig method.
    ///
    /// deleteConfig0
    func snippetForDeleteConfig() async throws {
        // >SEPARATOR deleteConfig
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteConfig(
            indexName: "theIndexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the getAllConfigs method.
    ///
    /// getAllConfigs0
    func snippetForGetAllConfigs() async throws {
        // >SEPARATOR getAllConfigs
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getAllConfigs()
        // SEPARATOR<
    }

    /// Snippet for the getConfig method.
    ///
    /// Retrieve QS config e2e
    func snippetForGetConfig() async throws {
        // >SEPARATOR getConfig
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getConfig(
            indexName: "cts_e2e_browse_query_suggestions"
        )
        // SEPARATOR<
    }

    /// Snippet for the getConfigStatus method.
    ///
    /// getConfigStatus0
    func snippetForGetConfigStatus() async throws {
        // >SEPARATOR getConfigStatus
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getConfigStatus(
            indexName: "theIndexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the getLogFile method.
    ///
    /// getLogFile0
    func snippetForGetLogFile() async throws {
        // >SEPARATOR getLogFile
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getLogFile(
            indexName: "theIndexName"
        )
        // SEPARATOR<
    }

    /// Snippet for the updateConfig method.
    ///
    /// updateConfig0
    func snippetForUpdateConfig() async throws {
        // >SEPARATOR updateConfig
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.updateConfig(
            indexName: "theIndexName",
            querySuggestionsConfiguration: QuerySuggestionsConfiguration(
                sourceIndices: [
                    SourceIndex(
                        indexName: "testIndex",
                        facets: [
                            Facet(
                                attribute: "test"
                            ),
                        ],
                        generate: [
                            [
                                "facetA",
                                "facetB",
                            ],
                            [
                                "facetC",
                            ],
                        ]
                    ),
                ],
                languages: Languages.arrayOfString(
                    [
                        "french",
                    ]
                ),
                exclude: [
                    "test",
                ]
            )
        )
        // SEPARATOR<
    }
}

import AnyCodable

import Core
import QuerySuggestions

final class QuerySuggestionsClientSnippet {
    /// Snippet for the createConfig method.
    ///
    /// createConfig0
    func snippetForCreateConfig() async throws {
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
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the deleteConfig method.
    ///
    /// deleteConfig0
    func snippetForDeleteConfig() async throws {
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteConfig(
            indexName: "theIndexName"
        )
    }

    /// Snippet for the getAllConfigs method.
    ///
    /// getAllConfigs0
    func snippetForGetAllConfigs() async throws {
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getAllConfigs()
    }

    /// Snippet for the getConfig method.
    ///
    /// Retrieve QS config e2e
    func snippetForGetConfig() async throws {
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getConfig(
            indexName: "cts_e2e_browse_query_suggestions"
        )
    }

    /// Snippet for the getConfigStatus method.
    ///
    /// getConfigStatus0
    func snippetForGetConfigStatus() async throws {
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getConfigStatus(
            indexName: "theIndexName"
        )
    }

    /// Snippet for the getLogFile method.
    ///
    /// getLogFile0
    func snippetForGetLogFile() async throws {
        // Initialize the client
        let client = try QuerySuggestionsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getLogFile(
            indexName: "theIndexName"
        )
    }

    /// Snippet for the updateConfig method.
    ///
    /// updateConfig0
    func snippetForUpdateConfig() async throws {
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
    }
}

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
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with all parameters
    func snippetForCustomDelete1() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with all parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/all", parameters: ["query": AnyCodable("parameters")])
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet allow get method for a custom path with minimal parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with all parameters
    func snippetForCustomGet1() async throws {
        // >SEPARATOR customGet allow get method for a custom path with all parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// requestOptions should be escaped too
    func snippetForCustomGet2() async throws {
        // >SEPARATOR customGet requestOptions should be escaped too
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("to be overridden")],
            requestOptions: RequestOptions(
                headers: ["x-header-1": "spaces are left alone"],

                queryParameters: ["query": "parameters with space", "and an array": ["array", "with spaces"]]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost allow post method for a custom path with minimal parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with all parameters
    func snippetForCustomPost1() async throws {
        // >SEPARATOR customPost allow post method for a custom path with all parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default query parameters
    func snippetForCustomPost2() async throws {
        // >SEPARATOR customPost requestOptions can override default query parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["query": "myQueryParameter"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges query parameters with default ones
    func snippetForCustomPost3() async throws {
        // >SEPARATOR customPost requestOptions merges query parameters with default ones
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["query2": "myQueryParameter"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default headers
    func snippetForCustomPost4() async throws {
        // >SEPARATOR customPost requestOptions can override default headers
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                headers: ["x-algolia-api-key": "ALGOLIA_API_KEY"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges headers with default ones
    func snippetForCustomPost5() async throws {
        // >SEPARATOR customPost requestOptions merges headers with default ones
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                headers: ["x-algolia-api-key": "ALGOLIA_API_KEY"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts booleans
    func snippetForCustomPost6() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts booleans
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["isItWorking": true]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts integers
    func snippetForCustomPost7() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts integers
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": 2]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of string
    func snippetForCustomPost8() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of string
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": ["b and c", "d"]]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of booleans
    func snippetForCustomPost9() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": [true, true, false]]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of integers
    func snippetForCustomPost10() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: RequestOptions(
                queryParameters: ["myParam": [1, 2]]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut allow put method for a custom path with minimal parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with all parameters
    func snippetForCustomPut1() async throws {
        // >SEPARATOR customPut allow put method for a custom path with all parameters
        // Initialize the client
        let client = try QuerySuggestionsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
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

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
        let response = try await client.addABTests(addABTestsRequest: AbtestingAddABTestsRequest(
            name: "myABTest",
            variants: [
                AbtestingAddABTestsVariant.abtestingAbTestsVariant(AbtestingAbTestsVariant(
                    index: "AB_TEST_1",
                    trafficPercentage: 30
                )),
                AbtestingAddABTestsVariant.abtestingAbTestsVariant(AbtestingAbTestsVariant(
                    index: "AB_TEST_2",
                    trafficPercentage: 50
                )),
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
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
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

    /// Snippet for the estimateABTest method.
    ///
    /// estimate AB Test sample size
    func snippetForEstimateABTest() async throws {
        // >SEPARATOR estimateABTest default
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.estimateABTest(estimateABTestRequest: AbtestingEstimateABTestRequest(
            configuration: AbtestingEstimateConfiguration(
                emptySearch: EmptySearch(exclude: true),
                minimumDetectableEffect: AbtestingMinimumDetectableEffect(
                    size: 0.03,
                    metric: AbtestingEffectMetric.conversionRate
                )
            ),
            variants: [
                AbtestingAddABTestsVariant.abtestingAbTestsVariant(AbtestingAbTestsVariant(
                    index: "AB_TEST_1",
                    trafficPercentage: 50
                )),
                AbtestingAddABTestsVariant.abtestingAbTestsVariant(AbtestingAbTestsVariant(
                    index: "AB_TEST_2",
                    trafficPercentage: 50
                )),
            ]
        ))
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
        // >SEPARATOR listABTests listABTests with minimal parameters
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listABTests()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listABTests method.
    ///
    /// listABTests with parameters
    func snippetForListABTests1() async throws {
        // >SEPARATOR listABTests listABTests with parameters
        // Initialize the client
        let client = try AbtestingClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listABTests(offset: 0, limit: 21, indexPrefix: "cts_e2e ab", indexSuffix: "t")
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
        let response = try await client.scheduleABTest(scheduleABTestsRequest: AbtestingScheduleABTestsRequest(
            name: "myABTest",
            variants: [
                AbtestingAddABTestsVariant.abtestingAbTestsVariant(AbtestingAbTestsVariant(
                    index: "AB_TEST_1",
                    trafficPercentage: 30
                )),
                AbtestingAddABTestsVariant.abtestingAbTestsVariant(AbtestingAbTestsVariant(
                    index: "AB_TEST_2",
                    trafficPercentage: 50
                )),
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

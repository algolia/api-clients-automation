#if canImport(Core)
    import Core
#endif
// >IMPORT
import Insights

// IMPORT<

final class InsightsClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with all parameters
    func snippetForCustomDelete1() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with all parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/all", parameters: ["query": AnyCodable("parameters")])
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet allow get method for a custom path with minimal parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with all parameters
    func snippetForCustomGet1() async throws {
        // >SEPARATOR customGet allow get method for a custom path with all parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// requestOptions should be escaped too
    func snippetForCustomGet2() async throws {
        // >SEPARATOR customGet requestOptions should be escaped too
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost allow post method for a custom path with minimal parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with all parameters
    func snippetForCustomPost1() async throws {
        // >SEPARATOR customPost allow post method for a custom path with all parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default query parameters
    func snippetForCustomPost2() async throws {
        // >SEPARATOR customPost requestOptions can override default query parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges query parameters with default ones
    func snippetForCustomPost3() async throws {
        // >SEPARATOR customPost requestOptions merges query parameters with default ones
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default headers
    func snippetForCustomPost4() async throws {
        // >SEPARATOR customPost requestOptions can override default headers
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges headers with default ones
    func snippetForCustomPost5() async throws {
        // >SEPARATOR customPost requestOptions merges headers with default ones
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts booleans
    func snippetForCustomPost6() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts booleans
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts integers
    func snippetForCustomPost7() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts integers
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of string
    func snippetForCustomPost8() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of string
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of booleans
    func snippetForCustomPost9() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of integers
    func snippetForCustomPost10() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut allow put method for a custom path with minimal parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with all parameters
    func snippetForCustomPut1() async throws {
        // >SEPARATOR customPut allow put method for a custom path with all parameters
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the deleteUserToken method.
    ///
    /// deleteUserToken
    func snippetForDeleteUserToken() async throws {
        // >SEPARATOR deleteUserToken default
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try await client.deleteUserToken(userToken: "test-user-1")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the pushEvents method.
    ///
    /// pushEvents
    func snippetForPushEvents() async throws {
        // >SEPARATOR pushEvents pushEvents
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .pushEvents(insightsEvents: InsightsEvents(events: [EventsItems
                    .clickedObjectIDsAfterSearch(ClickedObjectIDsAfterSearch(
                        eventName: "Product Clicked",
                        eventType: ClickEvent.click,
                        index: "products",
                        objectIDs: ["9780545139700", "9780439784542"],
                        positions: [7, 6],
                        queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                        userToken: "user-123456",
                        authenticatedUserToken: "user-123456",
                        timestamp: Int64(1_641_290_601_962)
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the pushEvents method.
    ///
    /// Many events type
    func snippetForPushEvents1() async throws {
        // >SEPARATOR pushEvents Many events type
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.pushEvents(insightsEvents: InsightsEvents(events: [
            EventsItems.convertedObjectIDsAfterSearch(ConvertedObjectIDsAfterSearch(
                eventName: "Product Purchased",
                eventType: ConversionEvent.conversion,
                index: "products",
                objectIDs: ["9780545139700", "9780439784542"],
                queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                userToken: "user-123456",
                authenticatedUserToken: "user-123456",
                timestamp: Int64(1_769_817_600_000)
            )),
            EventsItems.viewedObjectIDs(ViewedObjectIDs(
                eventName: "Product Detail Page Viewed",
                eventType: ViewEvent.view,
                index: "products",
                objectIDs: ["9780545139700", "9780439784542"],
                userToken: "user-123456",
                authenticatedUserToken: "user-123456",
                timestamp: Int64(1_769_817_600_000)
            )),
        ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the pushEvents method.
    ///
    /// ConvertedObjectIDsAfterSearch
    func snippetForPushEvents2() async throws {
        // >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .pushEvents(insightsEvents: InsightsEvents(events: [EventsItems
                    .convertedObjectIDsAfterSearch(ConvertedObjectIDsAfterSearch(
                        eventName: "Product Purchased",
                        eventType: ConversionEvent.conversion,
                        index: "products",
                        objectIDs: ["9780545139700", "9780439784542"],
                        queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                        userToken: "user-123456",
                        authenticatedUserToken: "user-123456",
                        timestamp: Int64(1_641_290_601_962)
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the pushEvents method.
    ///
    /// ViewedObjectIDs
    func snippetForPushEvents3() async throws {
        // >SEPARATOR pushEvents ViewedObjectIDs
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .pushEvents(insightsEvents: InsightsEvents(events: [EventsItems.viewedObjectIDs(ViewedObjectIDs(
                eventName: "Product Detail Page Viewed",
                eventType: ViewEvent.view,
                index: "products",
                objectIDs: ["9780545139700", "9780439784542"],
                userToken: "user-123456",
                authenticatedUserToken: "user-123456",
                timestamp: Int64(1_641_290_601_962)
            ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the pushEvents method.
    ///
    /// AddedToCartObjectIDs
    func snippetForPushEvents4() async throws {
        // >SEPARATOR pushEvents AddedToCartObjectIDs
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .pushEvents(insightsEvents: InsightsEvents(events: [EventsItems
                    .addedToCartObjectIDsAfterSearch(AddedToCartObjectIDsAfterSearch(
                        eventName: "Product Added To Cart",
                        eventType: ConversionEvent.conversion,
                        eventSubtype: AddToCartEvent.addToCart,
                        index: "products",
                        queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
                        objectIDs: ["9780545139700", "9780439784542"],
                        userToken: "user-123456",
                        authenticatedUserToken: "user-123456",
                        currency: "USD",
                        objectData: [
                            ObjectDataAfterSearch(
                                price: Price.double(19.99),
                                quantity: 10,
                                discount: Discount.double(2.5)
                            ),
                            ObjectDataAfterSearch(
                                price: Price.string("8$"),
                                quantity: 7,
                                discount: Discount.string("30%")
                            ),
                        ],
                        timestamp: Int64(1_641_290_601_962)
                    ))]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try InsightsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }
}

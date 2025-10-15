#if canImport(Core)
    import Core
#endif
// >IMPORT
import Analytics

// IMPORT<

final class AnalyticsClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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

    /// Snippet for the getAddToCartRate method.
    ///
    /// get getAddToCartRate with minimal parameters
    func snippetForGetAddToCartRate() async throws {
        // >SEPARATOR getAddToCartRate get getAddToCartRate with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAddToCartRate(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAddToCartRate method.
    ///
    /// get getAddToCartRate with all parameters
    func snippetForGetAddToCartRate1() async throws {
        // >SEPARATOR getAddToCartRate get getAddToCartRate with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAddToCartRate(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAverageClickPosition method.
    ///
    /// get getAverageClickPosition with minimal parameters
    func snippetForGetAverageClickPosition() async throws {
        // >SEPARATOR getAverageClickPosition get getAverageClickPosition with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAverageClickPosition(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAverageClickPosition method.
    ///
    /// get getAverageClickPosition with all parameters
    func snippetForGetAverageClickPosition1() async throws {
        // >SEPARATOR getAverageClickPosition get getAverageClickPosition with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAverageClickPosition(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getClickPositions method.
    ///
    /// get getClickPositions with minimal parameters
    func snippetForGetClickPositions() async throws {
        // >SEPARATOR getClickPositions get getClickPositions with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getClickPositions(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getClickPositions method.
    ///
    /// get getClickPositions with all parameters
    func snippetForGetClickPositions1() async throws {
        // >SEPARATOR getClickPositions get getClickPositions with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getClickPositions(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getClickThroughRate method.
    ///
    /// get getClickThroughRate with minimal parameters
    func snippetForGetClickThroughRate() async throws {
        // >SEPARATOR getClickThroughRate get getClickThroughRate with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getClickThroughRate(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getClickThroughRate method.
    ///
    /// get getClickThroughRate with all parameters
    func snippetForGetClickThroughRate1() async throws {
        // >SEPARATOR getClickThroughRate get getClickThroughRate with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getClickThroughRate(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getConversionRate method.
    ///
    /// get getConversationRate with minimal parameters
    func snippetForGetConversionRate() async throws {
        // >SEPARATOR getConversionRate get getConversationRate with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getConversionRate(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getConversionRate method.
    ///
    /// get getConversationRate with all parameters
    func snippetForGetConversionRate1() async throws {
        // >SEPARATOR getConversionRate get getConversationRate with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getConversionRate(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getNoClickRate method.
    ///
    /// get getNoClickRate with minimal parameters
    func snippetForGetNoClickRate() async throws {
        // >SEPARATOR getNoClickRate get getNoClickRate with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getNoClickRate(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getNoClickRate method.
    ///
    /// get getNoClickRate with all parameters
    func snippetForGetNoClickRate1() async throws {
        // >SEPARATOR getNoClickRate get getNoClickRate with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getNoClickRate(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getNoResultsRate method.
    ///
    /// get getNoResultsRate with minimal parameters
    func snippetForGetNoResultsRate() async throws {
        // >SEPARATOR getNoResultsRate get getNoResultsRate with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getNoResultsRate(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getNoResultsRate method.
    ///
    /// get getNoResultsRate with all parameters
    func snippetForGetNoResultsRate1() async throws {
        // >SEPARATOR getNoResultsRate get getNoResultsRate with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getNoResultsRate(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getPurchaseRate method.
    ///
    /// get getPurchaseRate with minimal parameters
    func snippetForGetPurchaseRate() async throws {
        // >SEPARATOR getPurchaseRate get getPurchaseRate with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getPurchaseRate(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getPurchaseRate method.
    ///
    /// get getPurchaseRate with all parameters
    func snippetForGetPurchaseRate1() async throws {
        // >SEPARATOR getPurchaseRate get getPurchaseRate with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getPurchaseRate(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRevenue method.
    ///
    /// get getRevenue with minimal parameters
    func snippetForGetRevenue() async throws {
        // >SEPARATOR getRevenue get getRevenue with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getRevenue(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRevenue method.
    ///
    /// get getRevenue with all parameters
    func snippetForGetRevenue1() async throws {
        // >SEPARATOR getRevenue get getRevenue with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getRevenue(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSearchesCount method.
    ///
    /// get getSearchesCount with minimal parameters
    func snippetForGetSearchesCount() async throws {
        // >SEPARATOR getSearchesCount get getSearchesCount with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesCount(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSearchesCount method.
    ///
    /// get getSearchesCount with all parameters
    func snippetForGetSearchesCount1() async throws {
        // >SEPARATOR getSearchesCount get getSearchesCount with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesCount(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoClicks method.
    ///
    /// get getSearchesNoClicks with minimal parameters
    func snippetForGetSearchesNoClicks() async throws {
        // >SEPARATOR getSearchesNoClicks get getSearchesNoClicks with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesNoClicks(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoClicks method.
    ///
    /// get getSearchesNoClicks with all parameters
    func snippetForGetSearchesNoClicks1() async throws {
        // >SEPARATOR getSearchesNoClicks get getSearchesNoClicks with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesNoClicks(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoResults method.
    ///
    /// get getSearchesNoResults with minimal parameters
    func snippetForGetSearchesNoResults() async throws {
        // >SEPARATOR getSearchesNoResults get getSearchesNoResults with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesNoResults(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoResults method.
    ///
    /// get getSearchesNoResults with all parameters
    func snippetForGetSearchesNoResults1() async throws {
        // >SEPARATOR getSearchesNoResults get getSearchesNoResults with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesNoResults(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getStatus method.
    ///
    /// get getStatus with minimal parameters
    func snippetForGetStatus() async throws {
        // >SEPARATOR getStatus default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getStatus(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopCountries method.
    ///
    /// get getTopCountries with minimal parameters
    func snippetForGetTopCountries() async throws {
        // >SEPARATOR getTopCountries get getTopCountries with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopCountries(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopCountries method.
    ///
    /// get getTopCountries with all parameters
    func snippetForGetTopCountries1() async throws {
        // >SEPARATOR getTopCountries get getTopCountries with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopCountries(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterAttributes method.
    ///
    /// get getTopFilterAttributes with minimal parameters
    func snippetForGetTopFilterAttributes() async throws {
        // >SEPARATOR getTopFilterAttributes get getTopFilterAttributes with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterAttributes(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterAttributes method.
    ///
    /// get getTopFilterAttributes with all parameters
    func snippetForGetTopFilterAttributes1() async throws {
        // >SEPARATOR getTopFilterAttributes get getTopFilterAttributes with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterAttributes(
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with minimal parameters
    func snippetForGetTopFilterForAttribute() async throws {
        // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterForAttribute(attribute: "myAttribute", index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with minimal parameters and multiple attributes
    func snippetForGetTopFilterForAttribute1() async throws {
        // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with minimal parameters and multiple
        // attributes
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterForAttribute(attribute: "myAttribute1,myAttribute2", index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with all parameters
    func snippetForGetTopFilterForAttribute2() async throws {
        // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterForAttribute(
            attribute: "myAttribute",
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with all parameters and multiple attributes
    func snippetForGetTopFilterForAttribute3() async throws {
        // >SEPARATOR getTopFilterForAttribute get getTopFilterForAttribute with all parameters and multiple attributes
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterForAttribute(
            attribute: "myAttribute1,myAttribute2",
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFiltersNoResults method.
    ///
    /// get getTopFiltersNoResults with minimal parameters
    func snippetForGetTopFiltersNoResults() async throws {
        // >SEPARATOR getTopFiltersNoResults get getTopFiltersNoResults with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFiltersNoResults(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopFiltersNoResults method.
    ///
    /// get getTopFiltersNoResults with all parameters
    func snippetForGetTopFiltersNoResults1() async throws {
        // >SEPARATOR getTopFiltersNoResults get getTopFiltersNoResults with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFiltersNoResults(
            index: "index",
            search: "mySearch",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopHits method.
    ///
    /// get getTopHits with minimal parameters
    func snippetForGetTopHits() async throws {
        // >SEPARATOR getTopHits get getTopHits with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopHits(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopHits method.
    ///
    /// get getTopHits with all parameters
    func snippetForGetTopHits1() async throws {
        // >SEPARATOR getTopHits get getTopHits with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopHits(
            index: "index",
            search: "mySearch",
            clickAnalytics: true,
            revenueAnalytics: true,
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopSearches method.
    ///
    /// get getTopSearches with minimal parameters
    func snippetForGetTopSearches() async throws {
        // >SEPARATOR getTopSearches get getTopSearches with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopSearches(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTopSearches method.
    ///
    /// get getTopSearches with all parameters
    func snippetForGetTopSearches1() async throws {
        // >SEPARATOR getTopSearches get getTopSearches with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopSearches(
            index: "index",
            clickAnalytics: true,
            revenueAnalytics: true,
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            orderBy: OrderBy.searchCount,
            direction: AnalyticsDirection.asc,
            limit: 21,
            offset: 42,
            tags: "tag"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getUsersCount method.
    ///
    /// get getUsersCount with minimal parameters
    func snippetForGetUsersCount() async throws {
        // >SEPARATOR getUsersCount get getUsersCount with minimal parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getUsersCount(index: "index")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getUsersCount method.
    ///
    /// get getUsersCount with all parameters
    func snippetForGetUsersCount1() async throws {
        // >SEPARATOR getUsersCount get getUsersCount with all parameters
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getUsersCount(
            index: "index",
            startDate: "1999-09-19",
            endDate: "2001-01-01",
            tags: "tag"
        )
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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }
}

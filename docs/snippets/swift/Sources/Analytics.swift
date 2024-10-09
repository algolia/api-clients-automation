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
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getAddToCartRate method.
    ///
    /// get getAddToCartRate with minimal parameters
    func snippetForGetAddToCartRate() async throws {
        // >SEPARATOR getAddToCartRate default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAddToCartRate(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getAverageClickPosition method.
    ///
    /// get getAverageClickPosition with minimal parameters
    func snippetForGetAverageClickPosition() async throws {
        // >SEPARATOR getAverageClickPosition default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAverageClickPosition(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getClickPositions method.
    ///
    /// get getClickPositions with minimal parameters
    func snippetForGetClickPositions() async throws {
        // >SEPARATOR getClickPositions default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getClickPositions(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getClickThroughRate method.
    ///
    /// get getClickThroughRate with minimal parameters
    func snippetForGetClickThroughRate() async throws {
        // >SEPARATOR getClickThroughRate default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getClickThroughRate(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getConversionRate method.
    ///
    /// get getConversationRate with minimal parameters
    func snippetForGetConversionRate() async throws {
        // >SEPARATOR getConversionRate default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getConversionRate(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getNoClickRate method.
    ///
    /// get getNoClickRate with minimal parameters
    func snippetForGetNoClickRate() async throws {
        // >SEPARATOR getNoClickRate default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getNoClickRate(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getNoResultsRate method.
    ///
    /// get getNoResultsRate with minimal parameters
    func snippetForGetNoResultsRate() async throws {
        // >SEPARATOR getNoResultsRate default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getNoResultsRate(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getPurchaseRate method.
    ///
    /// get getPurchaseRate with minimal parameters
    func snippetForGetPurchaseRate() async throws {
        // >SEPARATOR getPurchaseRate default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getPurchaseRate(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getRevenue method.
    ///
    /// get getRevenue with minimal parameters
    func snippetForGetRevenue() async throws {
        // >SEPARATOR getRevenue default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getRevenue(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSearchesCount method.
    ///
    /// get getSearchesCount with minimal parameters
    func snippetForGetSearchesCount() async throws {
        // >SEPARATOR getSearchesCount default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesCount(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoClicks method.
    ///
    /// get getSearchesNoClicks with minimal parameters
    func snippetForGetSearchesNoClicks() async throws {
        // >SEPARATOR getSearchesNoClicks default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesNoClicks(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoResults method.
    ///
    /// get getSearchesNoResults with minimal parameters
    func snippetForGetSearchesNoResults() async throws {
        // >SEPARATOR getSearchesNoResults default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSearchesNoResults(index: "index")
        // >LOG
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
        // SEPARATOR<
    }

    /// Snippet for the getTopCountries method.
    ///
    /// get getTopCountries with minimal parameters
    func snippetForGetTopCountries() async throws {
        // >SEPARATOR getTopCountries default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopCountries(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterAttributes method.
    ///
    /// get getTopFilterAttributes with minimal parameters
    func snippetForGetTopFilterAttributes() async throws {
        // >SEPARATOR getTopFilterAttributes default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterAttributes(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with minimal parameters
    func snippetForGetTopFilterForAttribute() async throws {
        // >SEPARATOR getTopFilterForAttribute default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFilterForAttribute(attribute: "myAttribute", index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTopFiltersNoResults method.
    ///
    /// get getTopFiltersNoResults with minimal parameters
    func snippetForGetTopFiltersNoResults() async throws {
        // >SEPARATOR getTopFiltersNoResults default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopFiltersNoResults(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTopHits method.
    ///
    /// get getTopHits with minimal parameters
    func snippetForGetTopHits() async throws {
        // >SEPARATOR getTopHits default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopHits(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTopSearches method.
    ///
    /// get getTopSearches with minimal parameters
    func snippetForGetTopSearches() async throws {
        // >SEPARATOR getTopSearches default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTopSearches(index: "index")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getUsersCount method.
    ///
    /// get getUsersCount with minimal parameters
    func snippetForGetUsersCount() async throws {
        // >SEPARATOR getUsersCount default
        // Initialize the client
        let client = try AnalyticsClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getUsersCount(index: "index")
        // >LOG
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

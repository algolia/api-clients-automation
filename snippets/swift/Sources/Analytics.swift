#if canImport(AnyCodable)
    import AnyCodable
#endif

import Analytics
import Core

// MARK: - AnalyticsClientSnippet

final class AnalyticsClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the getAverageClickPosition method.
    ///
    /// get getAverageClickPosition with minimal parameters
    func snippetForGetAverageClickPosition() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getAverageClickPosition(
            index: "index"
        )
    }

    /// Snippet for the getClickPositions method.
    ///
    /// get getClickPositions with minimal parameters
    func snippetForGetClickPositions() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getClickPositions(
            index: "index"
        )
    }

    /// Snippet for the getClickThroughRate method.
    ///
    /// get getClickThroughRate with minimal parameters
    func snippetForGetClickThroughRate() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getClickThroughRate(
            index: "index"
        )
    }

    /// Snippet for the getConversationRate method.
    ///
    /// get getConversationRate with minimal parameters
    func snippetForGetConversationRate() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getConversationRate(
            index: "index"
        )
    }

    /// Snippet for the getNoClickRate method.
    ///
    /// get getNoClickRate with minimal parameters
    func snippetForGetNoClickRate() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getNoClickRate(
            index: "index"
        )
    }

    /// Snippet for the getNoResultsRate method.
    ///
    /// get getNoResultsRate with minimal parameters
    func snippetForGetNoResultsRate() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getNoResultsRate(
            index: "index"
        )
    }

    /// Snippet for the getSearchesCount method.
    ///
    /// get getSearchesCount with minimal parameters
    func snippetForGetSearchesCount() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSearchesCount(
            index: "index"
        )
    }

    /// Snippet for the getSearchesNoClicks method.
    ///
    /// get getSearchesNoClicks with minimal parameters
    func snippetForGetSearchesNoClicks() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSearchesNoClicks(
            index: "index"
        )
    }

    /// Snippet for the getSearchesNoResults method.
    ///
    /// get getSearchesNoResults with minimal parameters
    func snippetForGetSearchesNoResults() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSearchesNoResults(
            index: "index"
        )
    }

    /// Snippet for the getStatus method.
    ///
    /// get getStatus with minimal parameters
    func snippetForGetStatus() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getStatus(
            index: "index"
        )
    }

    /// Snippet for the getTopCountries method.
    ///
    /// get getTopCountries with minimal parameters
    func snippetForGetTopCountries() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopCountries(
            index: "index"
        )
    }

    /// Snippet for the getTopFilterAttributes method.
    ///
    /// get getTopFilterAttributes with minimal parameters
    func snippetForGetTopFilterAttributes() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopFilterAttributes(
            index: "index"
        )
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with minimal parameters
    func snippetForGetTopFilterForAttribute() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopFilterForAttribute(
            attribute: "myAttribute",
            index: "index"
        )
    }

    /// Snippet for the getTopFiltersNoResults method.
    ///
    /// get getTopFiltersNoResults with minimal parameters
    func snippetForGetTopFiltersNoResults() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopFiltersNoResults(
            index: "index"
        )
    }

    /// Snippet for the getTopHits method.
    ///
    /// get getTopHits with minimal parameters
    func snippetForGetTopHits() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopHits(
            index: "index"
        )
    }

    /// Snippet for the getTopSearches method.
    ///
    /// get getTopSearches with minimal parameters
    func snippetForGetTopSearches() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopSearches(
            index: "index"
        )
    }

    /// Snippet for the getUsersCount method.
    ///
    /// get getUsersCount with minimal parameters
    func snippetForGetUsersCount() async throws {
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getUsersCount(
            index: "index"
        )
    }
}

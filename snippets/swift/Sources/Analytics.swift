import AnyCodable

import Analytics
import Core

final class AnalyticsClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the getAverageClickPosition method.
    ///
    /// get getAverageClickPosition with minimal parameters
    func snippetForGetAverageClickPosition() async throws {
        // >SEPARATOR getAverageClickPosition
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getAverageClickPosition(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getClickPositions method.
    ///
    /// get getClickPositions with minimal parameters
    func snippetForGetClickPositions() async throws {
        // >SEPARATOR getClickPositions
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getClickPositions(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getClickThroughRate method.
    ///
    /// get getClickThroughRate with minimal parameters
    func snippetForGetClickThroughRate() async throws {
        // >SEPARATOR getClickThroughRate
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getClickThroughRate(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getConversationRate method.
    ///
    /// get getConversationRate with minimal parameters
    func snippetForGetConversationRate() async throws {
        // >SEPARATOR getConversationRate
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getConversationRate(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getNoClickRate method.
    ///
    /// get getNoClickRate with minimal parameters
    func snippetForGetNoClickRate() async throws {
        // >SEPARATOR getNoClickRate
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getNoClickRate(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getNoResultsRate method.
    ///
    /// get getNoResultsRate with minimal parameters
    func snippetForGetNoResultsRate() async throws {
        // >SEPARATOR getNoResultsRate
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getNoResultsRate(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getSearchesCount method.
    ///
    /// get getSearchesCount with minimal parameters
    func snippetForGetSearchesCount() async throws {
        // >SEPARATOR getSearchesCount
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSearchesCount(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoClicks method.
    ///
    /// get getSearchesNoClicks with minimal parameters
    func snippetForGetSearchesNoClicks() async throws {
        // >SEPARATOR getSearchesNoClicks
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSearchesNoClicks(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getSearchesNoResults method.
    ///
    /// get getSearchesNoResults with minimal parameters
    func snippetForGetSearchesNoResults() async throws {
        // >SEPARATOR getSearchesNoResults
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSearchesNoResults(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getStatus method.
    ///
    /// get getStatus with minimal parameters
    func snippetForGetStatus() async throws {
        // >SEPARATOR getStatus
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getStatus(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopCountries method.
    ///
    /// get getTopCountries with minimal parameters
    func snippetForGetTopCountries() async throws {
        // >SEPARATOR getTopCountries
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopCountries(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterAttributes method.
    ///
    /// get getTopFilterAttributes with minimal parameters
    func snippetForGetTopFilterAttributes() async throws {
        // >SEPARATOR getTopFilterAttributes
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopFilterAttributes(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopFilterForAttribute method.
    ///
    /// get getTopFilterForAttribute with minimal parameters
    func snippetForGetTopFilterForAttribute() async throws {
        // >SEPARATOR getTopFilterForAttribute
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopFilterForAttribute(
            attribute: "myAttribute",
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopFiltersNoResults method.
    ///
    /// get getTopFiltersNoResults with minimal parameters
    func snippetForGetTopFiltersNoResults() async throws {
        // >SEPARATOR getTopFiltersNoResults
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopFiltersNoResults(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopHits method.
    ///
    /// get getTopHits with minimal parameters
    func snippetForGetTopHits() async throws {
        // >SEPARATOR getTopHits
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopHits(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getTopSearches method.
    ///
    /// get getTopSearches with minimal parameters
    func snippetForGetTopSearches() async throws {
        // >SEPARATOR getTopSearches
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTopSearches(
            index: "index"
        )
        // SEPARATOR<
    }

    /// Snippet for the getUsersCount method.
    ///
    /// get getUsersCount with minimal parameters
    func snippetForGetUsersCount() async throws {
        // >SEPARATOR getUsersCount
        // Initialize the client
        let client = try AnalyticsClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getUsersCount(
            index: "index"
        )
        // SEPARATOR<
    }
}

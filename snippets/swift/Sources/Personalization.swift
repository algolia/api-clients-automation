#if canImport(Core)
    import Core
#endif
// >IMPORT
import Personalization

// IMPORT<

final class PersonalizationClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the deleteUserProfile method.
    ///
    /// delete deleteUserProfile
    func snippetForDeleteUserProfile() async throws {
        // >SEPARATOR deleteUserProfile default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteUserProfile(userToken: "UserToken")
        // SEPARATOR<
    }

    /// Snippet for the getPersonalizationStrategy method.
    ///
    /// get getPersonalizationStrategy
    func snippetForGetPersonalizationStrategy() async throws {
        // >SEPARATOR getPersonalizationStrategy default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getPersonalizationStrategy()
        // SEPARATOR<
    }

    /// Snippet for the getUserTokenProfile method.
    ///
    /// get getUserTokenProfile
    func snippetForGetUserTokenProfile() async throws {
        // >SEPARATOR getUserTokenProfile default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getUserTokenProfile(userToken: "UserToken")
        // SEPARATOR<
    }

    /// Snippet for the setPersonalizationStrategy method.
    ///
    /// set setPersonalizationStrategy
    func snippetForSetPersonalizationStrategy() async throws {
        // >SEPARATOR setPersonalizationStrategy default
        // Initialize the client
        let client = try PersonalizationClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .setPersonalizationStrategy(personalizationStrategyParams: PersonalizationStrategyParams(
                eventScoring: [EventScoring(
                    score: 42,
                    eventName: "Algolia",
                    eventType: PersonalizationEventType.click
                )],
                facetScoring: [FacetScoring(score: 42, facetName: "Event")],
                personalizationImpact: 42
            ))
        // SEPARATOR<
    }
}

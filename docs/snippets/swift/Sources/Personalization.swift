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
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteUserProfile method.
    ///
    /// delete deleteUserProfile
    func snippetForDeleteUserProfile() async throws {
        // >SEPARATOR deleteUserProfile default
        // Initialize the client
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteUserProfile(userToken: "UserToken")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getPersonalizationStrategy method.
    ///
    /// get getPersonalizationStrategy
    func snippetForGetPersonalizationStrategy() async throws {
        // >SEPARATOR getPersonalizationStrategy default
        // Initialize the client
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getPersonalizationStrategy()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getUserTokenProfile method.
    ///
    /// get getUserTokenProfile
    func snippetForGetUserTokenProfile() async throws {
        // >SEPARATOR getUserTokenProfile default
        // Initialize the client
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getUserTokenProfile(userToken: "UserToken")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setPersonalizationStrategy method.
    ///
    /// set setPersonalizationStrategy
    func snippetForSetPersonalizationStrategy() async throws {
        // >SEPARATOR setPersonalizationStrategy default
        // Initialize the client
        let client = try PersonalizationClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .setPersonalizationStrategy(personalizationStrategyParams: PersonalizationStrategyParams(
                eventsScoring: [EventsScoring(
                    score: 42,
                    eventName: "Algolia",
                    eventType: PersonalizationEventType.click
                )],
                facetsScoring: [FacetsScoring(score: 42, facetName: "Event")],
                personalizationImpact: 42
            ))
        // >LOG
        // SEPARATOR<
    }
}

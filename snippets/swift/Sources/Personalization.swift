import AnyCodable

import Core
import Personalization

final class PersonalizationClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete
        // Initialize the client
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
        // SEPARATOR<
    }

    /// Snippet for the deleteUserProfile method.
    ///
    /// delete deleteUserProfile
    func snippetForDeleteUserProfile() async throws {
        // >SEPARATOR deleteUserProfile
        // Initialize the client
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteUserProfile(
            userToken: "UserToken"
        )
        // SEPARATOR<
    }

    /// Snippet for the getPersonalizationStrategy method.
    ///
    /// get getPersonalizationStrategy
    func snippetForGetPersonalizationStrategy() async throws {
        // >SEPARATOR getPersonalizationStrategy
        // Initialize the client
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getPersonalizationStrategy()
        // SEPARATOR<
    }

    /// Snippet for the getUserTokenProfile method.
    ///
    /// get getUserTokenProfile
    func snippetForGetUserTokenProfile() async throws {
        // >SEPARATOR getUserTokenProfile
        // Initialize the client
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getUserTokenProfile(
            userToken: "UserToken"
        )
        // SEPARATOR<
    }

    /// Snippet for the setPersonalizationStrategy method.
    ///
    /// set setPersonalizationStrategy
    func snippetForSetPersonalizationStrategy() async throws {
        // >SEPARATOR setPersonalizationStrategy
        // Initialize the client
        let client = try PersonalizationClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.setPersonalizationStrategy(
            personalizationStrategyParams: PersonalizationStrategyParams(
                eventScoring: [
                    EventScoring(
                        score: 42,
                        eventName: "Algolia",
                        eventType: "Event"
                    ),
                ],
                facetScoring: [
                    FacetScoring(
                        score: 42,
                        facetName: "Event"
                    ),
                ],
                personalizationImpact: 42
            )
        )
        // SEPARATOR<
    }
}

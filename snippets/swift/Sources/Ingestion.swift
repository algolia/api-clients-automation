#if canImport(AnyCodable)
    import AnyCodable
#endif

import Core
import Ingestion

// MARK: - IngestionClientSnippet

final class IngestionClientSnippet {
    /// Snippet for the createAuthentication method.
    ///
    /// createAuthenticationOAuth
    func snippetForCreateAuthentication() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.createAuthentication(
            authenticationCreate: AuthenticationCreate(
                type: AuthenticationType.oauth,
                name: "authName",
                input: AuthInput.authOAuth(
                    AuthOAuth(
                        url: "http://test.oauth",
                        clientId: "myID",
                        clientSecret: "mySecret"
                    )
                )
            )
        )
    }

    /// Snippet for the createDestination method.
    ///
    /// createDestination
    func snippetForCreateDestination() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.createDestination(
            destinationCreate: DestinationCreate(
                type: DestinationType.search,
                name: "destinationName",
                input: DestinationInput.destinationIndexPrefix(
                    DestinationIndexPrefix(
                        indexPrefix: "prefix_"
                    )
                ),
                authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        )
    }

    /// Snippet for the createSource method.
    ///
    /// createSource
    func snippetForCreateSource() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.createSource(
            sourceCreate: SourceCreate(
                type: SourceType.commercetools,
                name: "sourceName",
                input: SourceInput.sourceCommercetools(
                    SourceCommercetools(
                        storeKeys: [
                            "myStore",
                        ],
                        locales: [
                            "de",
                        ],
                        url: "http://commercetools.com",
                        projectKey: "keyID"
                    )
                ),
                authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
            )
        )
    }

    /// Snippet for the createTask method.
    ///
    /// createTaskOnDemand
    func snippetForCreateTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.createTask(
            taskCreate: TaskCreate(
                sourceID: "search",
                destinationID: "destinationName",
                trigger: TaskCreateTrigger.onDemandTriggerInput(
                    OnDemandTriggerInput(
                        type: OnDemandTriggerType.onDemand
                    )
                ),
                action: ActionType.replace
            )
        )
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.customPut(
            path: "/test/minimal"
        )
    }

    /// Snippet for the deleteAuthentication method.
    ///
    /// deleteAuthentication
    func snippetForDeleteAuthentication() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteAuthentication(
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the deleteDestination method.
    ///
    /// deleteDestination
    func snippetForDeleteDestination() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteDestination(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the deleteSource method.
    ///
    /// deleteSource
    func snippetForDeleteSource() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the deleteTask method.
    ///
    /// deleteTask
    func snippetForDeleteTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.deleteTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the disableTask method.
    ///
    /// disableTask
    func snippetForDisableTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.disableTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the enableTask method.
    ///
    /// enableTask
    func snippetForEnableTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.enableTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getAuthentication method.
    ///
    /// getAuthentication
    func snippetForGetAuthentication() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getAuthentication(
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getAuthentications method.
    ///
    /// getAuthentications
    func snippetForGetAuthentications() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getAuthentications()
    }

    /// Snippet for the getDestination method.
    ///
    /// getDestination
    func snippetForGetDestination() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getDestination(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getDestinations method.
    ///
    /// getDestinations
    func snippetForGetDestinations() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getDestinations()
    }

    /// Snippet for the getDockerSourceStreams method.
    ///
    /// getDockerSourceStreams
    func snippetForGetDockerSourceStreams() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getDockerSourceStreams(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getEvent method.
    ///
    /// getEvent
    func snippetForGetEvent() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getEvent(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            eventID: "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
        )
    }

    /// Snippet for the getEvents method.
    ///
    /// getEvents
    func snippetForGetEvents() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getEvents(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getRun method.
    ///
    /// getRun
    func snippetForGetRun() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getRun(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getRuns method.
    ///
    /// getRuns
    func snippetForGetRuns() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getRuns()
    }

    /// Snippet for the getSource method.
    ///
    /// getSource
    func snippetForGetSource() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getSources method.
    ///
    /// getSources
    func snippetForGetSources() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getSources()
    }

    /// Snippet for the getTask method.
    ///
    /// getTask
    func snippetForGetTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the getTasks method.
    ///
    /// getTasks
    func snippetForGetTasks() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.getTasks()
    }

    /// Snippet for the runTask method.
    ///
    /// runTask
    func snippetForRunTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.runTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the searchAuthentications method.
    ///
    /// searchAuthentications
    func snippetForSearchAuthentications() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.searchAuthentications(
            authenticationSearch: AuthenticationSearch(
                authenticationIDs: [
                    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                    "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                ]
            )
        )
    }

    /// Snippet for the searchDestinations method.
    ///
    /// searchDestinations
    func snippetForSearchDestinations() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.searchDestinations(
            destinationSearch: DestinationSearch(
                destinationIDs: [
                    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                    "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                ]
            )
        )
    }

    /// Snippet for the searchSources method.
    ///
    /// searchSources
    func snippetForSearchSources() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.searchSources(
            sourceSearch: SourceSearch(
                sourceIDs: [
                    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                    "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                ]
            )
        )
    }

    /// Snippet for the searchTasks method.
    ///
    /// searchTasks
    func snippetForSearchTasks() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.searchTasks(
            taskSearch: TaskSearch(
                taskIDs: [
                    "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                    "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                ]
            )
        )
    }

    /// Snippet for the triggerDockerSourceDiscover method.
    ///
    /// triggerDockerSourceDiscover
    func snippetForTriggerDockerSourceDiscover() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.triggerDockerSourceDiscover(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        )
    }

    /// Snippet for the updateAuthentication method.
    ///
    /// updateAuthentication
    func snippetForUpdateAuthentication() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.updateAuthentication(
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            authenticationUpdate: AuthenticationUpdate(
                name: "newName"
            )
        )
    }

    /// Snippet for the updateDestination method.
    ///
    /// updateDestination
    func snippetForUpdateDestination() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.updateDestination(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            destinationUpdate: DestinationUpdate(
                name: "newName"
            )
        )
    }

    /// Snippet for the updateSource method.
    ///
    /// updateSource
    func snippetForUpdateSource() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.updateSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(
                name: "newName"
            )
        )
    }

    /// Snippet for the updateTask method.
    ///
    /// updateTask
    func snippetForUpdateTask() async throws {
        // Initialize the client
        let client = try IngestionClient(appId: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        _ = try await client.updateTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskUpdate: TaskUpdate(
                enabled: false
            )
        )
    }
}

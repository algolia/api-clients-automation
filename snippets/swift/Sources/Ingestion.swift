#if canImport(Core)
    import Core
#endif
// >IMPORT
import Ingestion

// IMPORT<

final class IngestionClientSnippet {
    /// Snippet for the createAuthentication method.
    ///
    /// createAuthenticationOAuth
    func snippetForCreateAuthentication() async throws {
        // >SEPARATOR createAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createAuthentication(authenticationCreate: AuthenticationCreate(
            type: AuthenticationType.oauth,
            name: "authName",
            input: AuthInput.authOAuth(AuthOAuth(url: "http://test.oauth", clientId: "myID", clientSecret: "mySecret"))
        ))
        // SEPARATOR<
    }

    /// Snippet for the createDestination method.
    ///
    /// createDestination
    func snippetForCreateDestination() async throws {
        // >SEPARATOR createDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createDestination(destinationCreate: DestinationCreate(
            type: DestinationType.search,
            name: "destinationName",
            input: DestinationInput.destinationIndexPrefix(DestinationIndexPrefix(indexPrefix: "prefix_")),
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        ))
        // SEPARATOR<
    }

    /// Snippet for the createSource method.
    ///
    /// createSource
    func snippetForCreateSource() async throws {
        // >SEPARATOR createSource default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createSource(sourceCreate: SourceCreate(
            type: SourceType.commercetools,
            name: "sourceName",
            input: SourceInput.sourceCommercetools(SourceCommercetools(
                storeKeys: ["myStore"],
                locales: ["de"],
                url: "http://commercetools.com",
                projectKey: "keyID"
            )),
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        ))
        // SEPARATOR<
    }

    /// Snippet for the createTask method.
    ///
    /// createTaskOnDemand
    func snippetForCreateTask() async throws {
        // >SEPARATOR createTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTask(taskCreate: TaskCreate(
            sourceID: "search",
            destinationID: "destinationName",
            trigger: TaskCreateTrigger.onDemandTriggerInput(OnDemandTriggerInput(type: OnDemandTriggerType.onDemand)),
            action: ActionType.replace
        ))
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

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
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // SEPARATOR<
    }

    /// Snippet for the deleteAuthentication method.
    ///
    /// deleteAuthentication
    func snippetForDeleteAuthentication() async throws {
        // >SEPARATOR deleteAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteAuthentication(authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the deleteDestination method.
    ///
    /// deleteDestination
    func snippetForDeleteDestination() async throws {
        // >SEPARATOR deleteDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteDestination(destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the deleteSource method.
    ///
    /// deleteSource
    func snippetForDeleteSource() async throws {
        // >SEPARATOR deleteSource default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteSource(sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the deleteTask method.
    ///
    /// deleteTask
    func snippetForDeleteTask() async throws {
        // >SEPARATOR deleteTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the disableTask method.
    ///
    /// disableTask
    func snippetForDisableTask() async throws {
        // >SEPARATOR disableTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.disableTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the enableTask method.
    ///
    /// enable task e2e
    func snippetForEnableTask() async throws {
        // >SEPARATOR enableTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.enableTask(taskID: "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        // SEPARATOR<
    }

    /// Snippet for the getAuthentication method.
    ///
    /// getAuthentication
    func snippetForGetAuthentication() async throws {
        // >SEPARATOR getAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAuthentication(authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getAuthentications method.
    ///
    /// getAuthentications
    func snippetForGetAuthentications() async throws {
        // >SEPARATOR getAuthentications default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAuthentications()
        // SEPARATOR<
    }

    /// Snippet for the getDestination method.
    ///
    /// getDestination
    func snippetForGetDestination() async throws {
        // >SEPARATOR getDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getDestination(destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getDestinations method.
    ///
    /// getDestinations
    func snippetForGetDestinations() async throws {
        // >SEPARATOR getDestinations default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getDestinations()
        // SEPARATOR<
    }

    /// Snippet for the getDockerSourceStreams method.
    ///
    /// getDockerSourceStreams
    func snippetForGetDockerSourceStreams() async throws {
        // >SEPARATOR getDockerSourceStreams default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getDockerSourceStreams(sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getEvent method.
    ///
    /// getEvent
    func snippetForGetEvent() async throws {
        // >SEPARATOR getEvent default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getEvent(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            eventID: "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
        )
        // SEPARATOR<
    }

    /// Snippet for the getEvents method.
    ///
    /// getEvents
    func snippetForGetEvents() async throws {
        // >SEPARATOR getEvents default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getEvents(runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getRun method.
    ///
    /// getRun
    func snippetForGetRun() async throws {
        // >SEPARATOR getRun default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getRun(runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getRuns method.
    ///
    /// getRuns
    func snippetForGetRuns() async throws {
        // >SEPARATOR getRuns default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getRuns()
        // SEPARATOR<
    }

    /// Snippet for the getSource method.
    ///
    /// getSource
    func snippetForGetSource() async throws {
        // >SEPARATOR getSource default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSource(sourceID: "75eeb306-51d3-4e5e-a279-3c92bd8893ac")
        // SEPARATOR<
    }

    /// Snippet for the getSources method.
    ///
    /// getSources
    func snippetForGetSources() async throws {
        // >SEPARATOR getSources default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSources()
        // SEPARATOR<
    }

    /// Snippet for the getTask method.
    ///
    /// getTask
    func snippetForGetTask() async throws {
        // >SEPARATOR getTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getTasks method.
    ///
    /// getTasks
    func snippetForGetTasks() async throws {
        // >SEPARATOR getTasks default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTasks()
        // SEPARATOR<
    }

    /// Snippet for the runTask method.
    ///
    /// runTask
    func snippetForRunTask() async throws {
        // >SEPARATOR runTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.runTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the searchAuthentications method.
    ///
    /// searchAuthentications
    func snippetForSearchAuthentications() async throws {
        // >SEPARATOR searchAuthentications default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .searchAuthentications(authenticationSearch: AuthenticationSearch(authenticationIDs: [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ]))
        // SEPARATOR<
    }

    /// Snippet for the searchDestinations method.
    ///
    /// searchDestinations
    func snippetForSearchDestinations() async throws {
        // >SEPARATOR searchDestinations default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchDestinations(destinationSearch: DestinationSearch(destinationIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        ]))
        // SEPARATOR<
    }

    /// Snippet for the searchSources method.
    ///
    /// searchSources
    func snippetForSearchSources() async throws {
        // >SEPARATOR searchSources default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchSources(sourceSearch: SourceSearch(sourceIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        ]))
        // SEPARATOR<
    }

    /// Snippet for the searchTasks method.
    ///
    /// searchTasks
    func snippetForSearchTasks() async throws {
        // >SEPARATOR searchTasks default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchTasks(taskSearch: TaskSearch(taskIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        ]))
        // SEPARATOR<
    }

    /// Snippet for the triggerDockerSourceDiscover method.
    ///
    /// triggerDockerSourceDiscover
    func snippetForTriggerDockerSourceDiscover() async throws {
        // >SEPARATOR triggerDockerSourceDiscover default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.triggerDockerSourceDiscover(sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the updateAuthentication method.
    ///
    /// updateAuthentication
    func snippetForUpdateAuthentication() async throws {
        // >SEPARATOR updateAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateAuthentication(
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            authenticationUpdate: AuthenticationUpdate(name: "newName")
        )
        // SEPARATOR<
    }

    /// Snippet for the updateDestination method.
    ///
    /// updateDestination
    func snippetForUpdateDestination() async throws {
        // >SEPARATOR updateDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateDestination(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            destinationUpdate: DestinationUpdate(name: "newName")
        )
        // SEPARATOR<
    }

    /// Snippet for the updateSource method.
    ///
    /// updateSource
    func snippetForUpdateSource() async throws {
        // >SEPARATOR updateSource default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(name: "newName")
        )
        // SEPARATOR<
    }

    /// Snippet for the updateTask method.
    ///
    /// updateTask
    func snippetForUpdateTask() async throws {
        // >SEPARATOR updateTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskUpdate: TaskUpdate(enabled: false)
        )
        // SEPARATOR<
    }

    /// Snippet for the validateSource method.
    ///
    /// validateSource
    func snippetForValidateSource() async throws {
        // >SEPARATOR validateSource default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.validateSource(sourceCreate: SourceCreate(
            type: SourceType.commercetools,
            name: "sourceName",
            input: SourceInput.sourceCommercetools(SourceCommercetools(
                storeKeys: ["myStore"],
                locales: ["de"],
                url: "http://commercetools.com",
                projectKey: "keyID"
            )),
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        ))
        // SEPARATOR<
    }

    /// Snippet for the validateSourceBeforeUpdate method.
    ///
    /// validateSourceBeforeUpdate
    func snippetForValidateSourceBeforeUpdate() async throws {
        // >SEPARATOR validateSourceBeforeUpdate default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.validateSourceBeforeUpdate(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(name: "newName")
        )
        // SEPARATOR<
    }
}

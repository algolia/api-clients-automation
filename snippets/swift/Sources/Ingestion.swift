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
    /// task without cron
    func snippetForCreateTask() async throws {
        // >SEPARATOR createTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTask(taskCreate: TaskCreate(
            sourceID: "search",
            destinationID: "destinationName",
            action: ActionType.replace
        ))
        // SEPARATOR<
    }

    /// Snippet for the createTaskV1 method.
    ///
    /// createTaskOnDemand
    func snippetForCreateTaskV1() async throws {
        // >SEPARATOR createTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTaskV1(taskCreate: TaskCreateV1(
            sourceID: "search",
            destinationID: "destinationName",
            trigger: TaskCreateTrigger.onDemandTriggerInput(OnDemandTriggerInput(type: OnDemandTriggerType.onDemand)),
            action: ActionType.replace
        ))
        // SEPARATOR<
    }

    /// Snippet for the createTransformation method.
    ///
    /// createTransformation
    func snippetForCreateTransformation() async throws {
        // >SEPARATOR createTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTransformation(transformationCreate: TransformationCreate(
            code: "foo",
            name: "bar",
            description: "baz"
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

    /// Snippet for the deleteTaskV1 method.
    ///
    /// deleteTaskV1
    func snippetForDeleteTaskV1() async throws {
        // >SEPARATOR deleteTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the deleteTransformation method.
    ///
    /// deleteTransformation
    func snippetForDeleteTransformation() async throws {
        // >SEPARATOR deleteTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteTransformation(transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
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

    /// Snippet for the disableTaskV1 method.
    ///
    /// disableTaskV1
    func snippetForDisableTaskV1() async throws {
        // >SEPARATOR disableTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.disableTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the enableTask method.
    ///
    /// enableTask
    func snippetForEnableTask() async throws {
        // >SEPARATOR enableTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.enableTask(taskID: "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        // SEPARATOR<
    }

    /// Snippet for the enableTaskV1 method.
    ///
    /// enableTaskV1
    func snippetForEnableTaskV1() async throws {
        // >SEPARATOR enableTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.enableTaskV1(taskID: "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
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

    /// Snippet for the getTaskV1 method.
    ///
    /// getTaskV1
    func snippetForGetTaskV1() async throws {
        // >SEPARATOR getTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the getTransformation method.
    ///
    /// getTransformation
    func snippetForGetTransformation() async throws {
        // >SEPARATOR getTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTransformation(transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the listAuthentications method.
    ///
    /// getAuthentications
    func snippetForListAuthentications() async throws {
        // >SEPARATOR listAuthentications default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listAuthentications()
        // SEPARATOR<
    }

    /// Snippet for the listDestinations method.
    ///
    /// getDestinations
    func snippetForListDestinations() async throws {
        // >SEPARATOR listDestinations default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listDestinations()
        // SEPARATOR<
    }

    /// Snippet for the listEvents method.
    ///
    /// getEvents
    func snippetForListEvents() async throws {
        // >SEPARATOR listEvents default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listEvents(runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // SEPARATOR<
    }

    /// Snippet for the listRuns method.
    ///
    /// listRuns
    func snippetForListRuns() async throws {
        // >SEPARATOR listRuns default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listRuns()
        // SEPARATOR<
    }

    /// Snippet for the listSources method.
    ///
    /// listSources
    func snippetForListSources() async throws {
        // >SEPARATOR listSources default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listSources()
        // SEPARATOR<
    }

    /// Snippet for the listTasks method.
    ///
    /// listTasks
    func snippetForListTasks() async throws {
        // >SEPARATOR listTasks default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listTasks()
        // SEPARATOR<
    }

    /// Snippet for the listTasksV1 method.
    ///
    /// listTasksV1
    func snippetForListTasksV1() async throws {
        // >SEPARATOR listTasksV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listTasksV1()
        // SEPARATOR<
    }

    /// Snippet for the listTransformations method.
    ///
    /// listTransformations
    func snippetForListTransformations() async throws {
        // >SEPARATOR listTransformations default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.listTransformations()
        // SEPARATOR<
    }

    /// Snippet for the pushTask method.
    ///
    /// pushTask
    func snippetForPushTask() async throws {
        // >SEPARATOR pushTask default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.pushTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            batchWriteParams: IngestionBatchWriteParams(requests: [
                IngestionBatchRequest(action: IngestionAction.addObject, body: ["key": "bar", "foo": "1"]),
                IngestionBatchRequest(action: IngestionAction.addObject, body: ["key": "baz", "foo": "2"]),
            ])
        )
        // SEPARATOR<
    }

    /// Snippet for the runSource method.
    ///
    /// runSource
    func snippetForRunSource() async throws {
        // >SEPARATOR runSource default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.runSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            runSourcePayload: RunSourcePayload(
                indexToInclude: ["products_us", "products eu"],
                entityIDs: ["1234", "5678"],
                entityType: EntityType.product
            )
        )
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

    /// Snippet for the runTaskV1 method.
    ///
    /// runTaskV1
    func snippetForRunTaskV1() async throws {
        // >SEPARATOR runTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.runTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
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

    /// Snippet for the searchTasksV1 method.
    ///
    /// searchTasksV1
    func snippetForSearchTasksV1() async throws {
        // >SEPARATOR searchTasksV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchTasksV1(taskSearch: TaskSearch(taskIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        ]))
        // SEPARATOR<
    }

    /// Snippet for the searchTransformations method.
    ///
    /// searchTransformations
    func snippetForSearchTransformations() async throws {
        // >SEPARATOR searchTransformations default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .searchTransformations(transformationSearch: TransformationSearch(transformationsIDs: [
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

    /// Snippet for the tryTransformations method.
    ///
    /// tryTransformations
    func snippetForTryTransformations() async throws {
        // >SEPARATOR tryTransformations default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.tryTransformations(transformationTry: TransformationTry(
            code: "foo",
            sampleRecord: ["bar": "baz"]
        ))
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
            taskUpdate: TaskUpdate(cron: "* * * * *", enabled: false)
        )
        // SEPARATOR<
    }

    /// Snippet for the updateTaskV1 method.
    ///
    /// updateTaskV1
    func snippetForUpdateTaskV1() async throws {
        // >SEPARATOR updateTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateTaskV1(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskUpdate: TaskUpdateV1(enabled: false)
        )
        // SEPARATOR<
    }

    /// Snippet for the updateTransformation method.
    ///
    /// updateTransformation
    func snippetForUpdateTransformation() async throws {
        // >SEPARATOR updateTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "YOUR_APP_ID", apiKey: "YOUR_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateTransformation(
            transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            transformationCreate: TransformationCreate(code: "foo", name: "bar", description: "baz")
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

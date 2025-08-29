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
        // >SEPARATOR createAuthentication createAuthenticationOAuth
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createAuthentication(authenticationCreate: AuthenticationCreate(
            type: AuthenticationType.oauth,
            name: "authName",
            input: AuthInput.authOAuth(AuthOAuth(url: "http://test.oauth", clientId: "myID", clientSecret: "mySecret"))
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createAuthentication method.
    ///
    /// createAuthenticationAlgolia
    func snippetForCreateAuthentication1() async throws {
        // >SEPARATOR createAuthentication createAuthenticationAlgolia
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createAuthentication(authenticationCreate: AuthenticationCreate(
            type: AuthenticationType.algolia,
            name: "authName",
            input: AuthInput.authAlgolia(AuthAlgolia(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY"))
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createDestination method.
    ///
    /// createDestination
    func snippetForCreateDestination() async throws {
        // >SEPARATOR createDestination createDestination
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createDestination(destinationCreate: DestinationCreate(
            type: DestinationType.search,
            name: "destinationName",
            input: DestinationInput(indexName: "<YOUR_INDEX_NAME>"),
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createDestination method.
    ///
    /// with transformationIDs
    func snippetForCreateDestination1() async throws {
        // >SEPARATOR createDestination with transformationIDs
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createDestination(destinationCreate: DestinationCreate(
            type: DestinationType.search,
            name: "destinationName",
            input: DestinationInput(indexName: "<YOUR_INDEX_NAME>"),
            transformationIDs: ["6c02aeb1-775e-418e-870b-1faccd4b2c0f"]
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createSource method.
    ///
    /// createSource
    func snippetForCreateSource() async throws {
        // >SEPARATOR createSource createSource
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createSource(sourceCreate: SourceCreate(
            type: SourceType.commercetools,
            name: "sourceName",
            input: SourceInput.sourceCommercetools(SourceCommercetools(
                storeKeys: ["myStore"],
                locales: ["de"],
                url: "http://commercetools.com",
                projectKey: "keyID",
                productQueryPredicate: "masterVariant(attributes(name=\"Brand\" and value=\"Algolia\"))"
            )),
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f"
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createSource method.
    ///
    /// push
    func snippetForCreateSource1() async throws {
        // >SEPARATOR createSource push
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createSource(sourceCreate: SourceCreate(
            type: SourceType.push,
            name: "pushezpourentrer"
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTask method.
    ///
    /// task without cron
    func snippetForCreateTask() async throws {
        // >SEPARATOR createTask task without cron
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTask(taskCreate: TaskCreate(
            sourceID: "search",
            destinationID: "destinationID",
            action: ActionType.replace
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTask method.
    ///
    /// task with cron
    func snippetForCreateTask1() async throws {
        // >SEPARATOR createTask task with cron
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTask(taskCreate: TaskCreate(
            sourceID: "search",
            destinationID: "destinationID",
            action: ActionType.replace,
            cron: "* * * * *",
            notifications: Notifications(email: EmailNotifications(enabled: true)),
            policies: Policies(criticalThreshold: 8)
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTask method.
    ///
    /// task shopify
    func snippetForCreateTask2() async throws {
        // >SEPARATOR createTask task shopify
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTask(taskCreate: TaskCreate(
            sourceID: "search",
            destinationID: "destinationID",
            action: ActionType.replace,
            cron: "* * * * *",
            input: TaskInput.dockerStreamsInput(DockerStreamsInput(streams: [DockerStreams(
                name: "foo",
                syncMode: DockerStreamsSyncMode.incremental
            )]))
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTaskV1 method.
    ///
    /// createTaskOnDemand
    func snippetForCreateTaskV1() async throws {
        // >SEPARATOR createTaskV1 createTaskOnDemand
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTaskV1(taskCreate: TaskCreateV1(
            sourceID: "search",
            destinationID: "destinationName",
            trigger: TaskCreateTrigger.onDemandTriggerInput(OnDemandTriggerInput(type: OnDemandTriggerType.onDemand)),
            action: ActionType.replace
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTaskV1 method.
    ///
    /// createTaskSchedule
    func snippetForCreateTaskV11() async throws {
        // >SEPARATOR createTaskV1 createTaskSchedule
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTaskV1(taskCreate: TaskCreateV1(
            sourceID: "search",
            destinationID: "destinationName",
            trigger: TaskCreateTrigger.scheduleTriggerInput(ScheduleTriggerInput(
                type: ScheduleTriggerType.schedule,
                cron: "* * * * *"
            )),
            action: ActionType.replace
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTaskV1 method.
    ///
    /// createTaskSubscription
    func snippetForCreateTaskV12() async throws {
        // >SEPARATOR createTaskV1 createTaskSubscription
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTaskV1(taskCreate: TaskCreateV1(
            sourceID: "search",
            destinationID: "destinationName",
            trigger: TaskCreateTrigger.onDemandTriggerInput(OnDemandTriggerInput(type: OnDemandTriggerType.onDemand)),
            action: ActionType.replace
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTaskV1 method.
    ///
    /// task shopify
    func snippetForCreateTaskV13() async throws {
        // >SEPARATOR createTaskV1 task shopify
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTaskV1(taskCreate: TaskCreateV1(
            sourceID: "search",
            destinationID: "destinationName",
            trigger: TaskCreateTrigger.onDemandTriggerInput(OnDemandTriggerInput(type: OnDemandTriggerType.onDemand)),
            action: ActionType.replace,
            input: TaskInput.dockerStreamsInput(DockerStreamsInput(streams: [DockerStreams(
                name: "foo",
                syncMode: DockerStreamsSyncMode.incremental
            )]))
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createTransformation method.
    ///
    /// createTransformation
    func snippetForCreateTransformation() async throws {
        // >SEPARATOR createTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.createTransformation(transformationCreate: TransformationCreate(
            name: "bar",
            type: TransformationType.code,
            input: TransformationInput.transformationCode(TransformationCode(code: "foo")),
            description: "baz"
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with all parameters
    func snippetForCustomDelete1() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with all parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customDelete(path: "test/all", parameters: ["query": AnyCodable("parameters")])
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet allow get method for a custom path with minimal parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with all parameters
    func snippetForCustomGet1() async throws {
        // >SEPARATOR customGet allow get method for a custom path with all parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// requestOptions should be escaped too
    func snippetForCustomGet2() async throws {
        // >SEPARATOR customGet requestOptions should be escaped too
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("to be overriden")],
            requestOptions: RequestOptions(
                headers: ["x-header-1": "spaces are left alone"],

                queryParameters: ["query": "parameters with space", "and an array": ["array", "with spaces"]]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost allow post method for a custom path with minimal parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with all parameters
    func snippetForCustomPost1() async throws {
        // >SEPARATOR customPost allow post method for a custom path with all parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPost(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default query parameters
    func snippetForCustomPost2() async throws {
        // >SEPARATOR customPost requestOptions can override default query parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges query parameters with default ones
    func snippetForCustomPost3() async throws {
        // >SEPARATOR customPost requestOptions merges query parameters with default ones
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default headers
    func snippetForCustomPost4() async throws {
        // >SEPARATOR customPost requestOptions can override default headers
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges headers with default ones
    func snippetForCustomPost5() async throws {
        // >SEPARATOR customPost requestOptions merges headers with default ones
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts booleans
    func snippetForCustomPost6() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts booleans
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts integers
    func snippetForCustomPost7() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts integers
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of string
    func snippetForCustomPost8() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of string
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of booleans
    func snippetForCustomPost9() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of integers
    func snippetForCustomPost10() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut allow put method for a custom path with minimal parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with all parameters
    func snippetForCustomPut1() async throws {
        // >SEPARATOR customPut allow put method for a custom path with all parameters
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.customPut(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteAuthentication method.
    ///
    /// deleteAuthentication
    func snippetForDeleteAuthentication() async throws {
        // >SEPARATOR deleteAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteAuthentication(authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteDestination method.
    ///
    /// deleteDestination
    func snippetForDeleteDestination() async throws {
        // >SEPARATOR deleteDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteDestination(destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteSource method.
    ///
    /// deleteSource
    func snippetForDeleteSource() async throws {
        // >SEPARATOR deleteSource default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteSource(sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteTask method.
    ///
    /// deleteTask
    func snippetForDeleteTask() async throws {
        // >SEPARATOR deleteTask default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteTaskV1 method.
    ///
    /// deleteTaskV1
    func snippetForDeleteTaskV1() async throws {
        // >SEPARATOR deleteTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteTransformation method.
    ///
    /// deleteTransformation
    func snippetForDeleteTransformation() async throws {
        // >SEPARATOR deleteTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.deleteTransformation(transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the disableTask method.
    ///
    /// disableTask
    func snippetForDisableTask() async throws {
        // >SEPARATOR disableTask default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.disableTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the disableTaskV1 method.
    ///
    /// disableTaskV1
    func snippetForDisableTaskV1() async throws {
        // >SEPARATOR disableTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.disableTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the enableTask method.
    ///
    /// enableTask
    func snippetForEnableTask() async throws {
        // >SEPARATOR enableTask default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.enableTask(taskID: "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the enableTaskV1 method.
    ///
    /// enableTaskV1
    func snippetForEnableTaskV1() async throws {
        // >SEPARATOR enableTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.enableTaskV1(taskID: "76ab4c2a-ce17-496f-b7a6-506dc59ee498")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getAuthentication method.
    ///
    /// getAuthentication
    func snippetForGetAuthentication() async throws {
        // >SEPARATOR getAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getAuthentication(authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getDestination method.
    ///
    /// getDestination
    func snippetForGetDestination() async throws {
        // >SEPARATOR getDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getDestination(destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getEvent method.
    ///
    /// getEvent
    func snippetForGetEvent() async throws {
        // >SEPARATOR getEvent default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getEvent(
            runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            eventID: "6c02aeb1-775e-418e-870b-1faccd4b2c0c"
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getRun method.
    ///
    /// getRun
    func snippetForGetRun() async throws {
        // >SEPARATOR getRun default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getRun(runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getSource method.
    ///
    /// getSource
    func snippetForGetSource() async throws {
        // >SEPARATOR getSource default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getSource(sourceID: "75eeb306-51d3-4e5e-a279-3c92bd8893ac")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTask method.
    ///
    /// getTask
    func snippetForGetTask() async throws {
        // >SEPARATOR getTask default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTaskV1 method.
    ///
    /// getTaskV1
    func snippetForGetTaskV1() async throws {
        // >SEPARATOR getTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the getTransformation method.
    ///
    /// getTransformation
    func snippetForGetTransformation() async throws {
        // >SEPARATOR getTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.getTransformation(transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listAuthentications method.
    ///
    /// getAuthentications
    func snippetForListAuthentications() async throws {
        // >SEPARATOR listAuthentications getAuthentications
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listAuthentications()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listAuthentications method.
    ///
    /// getAuthentications with query params
    func snippetForListAuthentications1() async throws {
        // >SEPARATOR listAuthentications getAuthentications with query params
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listAuthentications(
            itemsPerPage: 2,
            page: 1,
            type: [AuthenticationType.basic, AuthenticationType.algolia],
            platform: [PlatformWithNone.platformNone(PlatformNone.`none`)],
            sort: AuthenticationSortKeys.createdAt,
            order: OrderKeys.asc
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listDestinations method.
    ///
    /// getDestinations
    func snippetForListDestinations() async throws {
        // >SEPARATOR listDestinations default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listDestinations()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listEvents method.
    ///
    /// getEvents
    func snippetForListEvents() async throws {
        // >SEPARATOR listEvents default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listEvents(runID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listRuns method.
    ///
    /// listRuns
    func snippetForListRuns() async throws {
        // >SEPARATOR listRuns default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listRuns()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listSources method.
    ///
    /// listSources
    func snippetForListSources() async throws {
        // >SEPARATOR listSources default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listSources()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listTasks method.
    ///
    /// listTasks
    func snippetForListTasks() async throws {
        // >SEPARATOR listTasks default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listTasks()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listTasksV1 method.
    ///
    /// listTasksV1
    func snippetForListTasksV1() async throws {
        // >SEPARATOR listTasksV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listTasksV1()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listTransformations method.
    ///
    /// listTransformations
    func snippetForListTransformations() async throws {
        // >SEPARATOR listTransformations default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.listTransformations()
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the push method.
    ///
    /// global push
    func snippetForPush() async throws {
        // >SEPARATOR push global push
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.push(
            indexName: "<YOUR_INDEX_NAME>",
            pushTaskPayload: PushTaskPayload(
                action: IngestionAction.addObject,
                records: [
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("o"),
                        "key": AnyCodable("bar"),
                        "foo": AnyCodable("1"),
                    ]),
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("k"),
                        "key": AnyCodable("baz"),
                        "foo": AnyCodable("2"),
                    ]),
                ]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the push method.
    ///
    /// global push with watch mode
    func snippetForPush1() async throws {
        // >SEPARATOR push global push with watch mode
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.push(
            indexName: "<YOUR_INDEX_NAME>",
            pushTaskPayload: PushTaskPayload(
                action: IngestionAction.addObject,
                records: [
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("o"),
                        "key": AnyCodable("bar"),
                        "foo": AnyCodable("1"),
                    ]),
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("k"),
                        "key": AnyCodable("baz"),
                        "foo": AnyCodable("2"),
                    ]),
                ]
            ),
            watch: true,
            referenceIndexName: "foo"
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the pushTask method.
    ///
    /// pushTask
    func snippetForPushTask() async throws {
        // >SEPARATOR pushTask pushTask
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.pushTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            pushTaskPayload: PushTaskPayload(
                action: IngestionAction.addObject,
                records: [
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("o"),
                        "key": AnyCodable("bar"),
                        "foo": AnyCodable("1"),
                    ]),
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("k"),
                        "key": AnyCodable("baz"),
                        "foo": AnyCodable("2"),
                    ]),
                ]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the pushTask method.
    ///
    /// allows for watch query parameter
    func snippetForPushTask1() async throws {
        // >SEPARATOR pushTask allows for watch query parameter
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.pushTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            pushTaskPayload: PushTaskPayload(
                action: IngestionAction.addObject,
                records: [
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("o"),
                        "key": AnyCodable("bar"),
                        "foo": AnyCodable("1"),
                    ]),
                    PushTaskRecords(from: [
                        "objectID": AnyCodable("k"),
                        "key": AnyCodable("baz"),
                        "foo": AnyCodable("2"),
                    ]),
                ]
            ),
            watch: true
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the replaceTask method.
    ///
    /// fully replace task without cron
    func snippetForReplaceTask() async throws {
        // >SEPARATOR replaceTask fully replace task without cron
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.replaceTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskReplace: TaskReplace(destinationID: "destinationID", action: ActionType.replace)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the replaceTask method.
    ///
    /// fully replace task with cron
    func snippetForReplaceTask1() async throws {
        // >SEPARATOR replaceTask fully replace task with cron
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.replaceTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskReplace: TaskReplace(
                destinationID: "destinationID",
                action: ActionType.replace,
                cron: "* * * * *",
                notifications: Notifications(email: EmailNotifications(enabled: true)),
                policies: Policies(criticalThreshold: 8)
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the replaceTask method.
    ///
    /// fully replace task shopify
    func snippetForReplaceTask2() async throws {
        // >SEPARATOR replaceTask fully replace task shopify
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.replaceTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskReplace: TaskReplace(
                destinationID: "destinationID",
                action: ActionType.replace,
                cron: "* * * * *",
                input: TaskInput.dockerStreamsInput(DockerStreamsInput(streams: [DockerStreams(
                    name: "foo",
                    syncMode: DockerStreamsSyncMode.incremental
                )]))
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the runSource method.
    ///
    /// runSource
    func snippetForRunSource() async throws {
        // >SEPARATOR runSource default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.runSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            runSourcePayload: RunSourcePayload(
                indexToInclude: ["products_us", "products eu"],
                entityIDs: ["1234", "5678"],
                entityType: EntityType.product
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the runTask method.
    ///
    /// runTask
    func snippetForRunTask() async throws {
        // >SEPARATOR runTask default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.runTask(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the runTaskV1 method.
    ///
    /// runTaskV1
    func snippetForRunTaskV1() async throws {
        // >SEPARATOR runTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.runTaskV1(taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchAuthentications method.
    ///
    /// searchAuthentications
    func snippetForSearchAuthentications() async throws {
        // >SEPARATOR searchAuthentications default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .searchAuthentications(authenticationSearch: AuthenticationSearch(authenticationIDs: [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchDestinations method.
    ///
    /// searchDestinations
    func snippetForSearchDestinations() async throws {
        // >SEPARATOR searchDestinations default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchDestinations(destinationSearch: DestinationSearch(destinationIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchSources method.
    ///
    /// searchSources
    func snippetForSearchSources() async throws {
        // >SEPARATOR searchSources default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchSources(sourceSearch: SourceSearch(sourceIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
        ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchTasks method.
    ///
    /// searchTasks
    func snippetForSearchTasks() async throws {
        // >SEPARATOR searchTasks default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchTasks(taskSearch: TaskSearch(taskIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchTasksV1 method.
    ///
    /// searchTasksV1
    func snippetForSearchTasksV1() async throws {
        // >SEPARATOR searchTasksV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.searchTasksV1(taskSearch: TaskSearch(taskIDs: [
            "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
            "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
        ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the searchTransformations method.
    ///
    /// searchTransformations
    func snippetForSearchTransformations() async throws {
        // >SEPARATOR searchTransformations default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client
            .searchTransformations(transformationSearch: TransformationSearch(transformationIDs: [
                "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
                "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
                "76ab4c2a-ce17-496f-b7a6-506dc59ee498",
            ]))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the triggerDockerSourceDiscover method.
    ///
    /// triggerDockerSourceDiscover
    func snippetForTriggerDockerSourceDiscover() async throws {
        // >SEPARATOR triggerDockerSourceDiscover default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.triggerDockerSourceDiscover(sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the tryTransformation method.
    ///
    /// tryTransformation
    func snippetForTryTransformation() async throws {
        // >SEPARATOR tryTransformation tryTransformation
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.tryTransformation(transformationTry: TransformationTry(
            type: TransformationType.code,
            input: TransformationInput.transformationCode(TransformationCode(code: "foo")),
            sampleRecord: ["bar": "baz"]
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the tryTransformation method.
    ///
    /// with authentications
    func snippetForTryTransformation1() async throws {
        // >SEPARATOR tryTransformation with authentications
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.tryTransformation(transformationTry: TransformationTry(
            type: TransformationType.code,
            input: TransformationInput.transformationCode(TransformationCode(code: "foo")),
            sampleRecord: ["bar": "baz"],
            authentications: [AuthenticationCreate(
                type: AuthenticationType.oauth,
                name: "authName",
                input: AuthInput.authOAuth(AuthOAuth(
                    url: "http://test.oauth",
                    clientId: "myID",
                    clientSecret: "mySecret"
                ))
            )]
        ))
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the tryTransformationBeforeUpdate method.
    ///
    /// tryTransformationBeforeUpdate
    func snippetForTryTransformationBeforeUpdate() async throws {
        // >SEPARATOR tryTransformationBeforeUpdate tryTransformationBeforeUpdate
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.tryTransformationBeforeUpdate(
            transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            transformationTry: TransformationTry(
                type: TransformationType.code,
                input: TransformationInput.transformationCode(TransformationCode(code: "foo")),
                sampleRecord: ["bar": "baz"]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the tryTransformationBeforeUpdate method.
    ///
    /// existing with authentications
    func snippetForTryTransformationBeforeUpdate1() async throws {
        // >SEPARATOR tryTransformationBeforeUpdate existing with authentications
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.tryTransformationBeforeUpdate(
            transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            transformationTry: TransformationTry(
                type: TransformationType.code,
                input: TransformationInput.transformationCode(TransformationCode(code: "foo")),
                sampleRecord: ["bar": "baz"],
                authentications: [AuthenticationCreate(
                    type: AuthenticationType.oauth,
                    name: "authName",
                    input: AuthInput.authOAuth(AuthOAuth(
                        url: "http://test.oauth",
                        clientId: "myID",
                        clientSecret: "mySecret"
                    ))
                )]
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateAuthentication method.
    ///
    /// updateAuthentication
    func snippetForUpdateAuthentication() async throws {
        // >SEPARATOR updateAuthentication default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateAuthentication(
            authenticationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            authenticationUpdate: AuthenticationUpdate(name: "newName")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateDestination method.
    ///
    /// updateDestination
    func snippetForUpdateDestination() async throws {
        // >SEPARATOR updateDestination default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateDestination(
            destinationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            destinationUpdate: DestinationUpdate(name: "newName")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateSource method.
    ///
    /// updateSource
    func snippetForUpdateSource() async throws {
        // >SEPARATOR updateSource default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateSource(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(name: "newName")
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateTask method.
    ///
    /// updateTask
    func snippetForUpdateTask() async throws {
        // >SEPARATOR updateTask default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateTask(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskUpdate: TaskUpdate(cron: "* * * * *", enabled: false)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateTaskV1 method.
    ///
    /// updateTaskV1
    func snippetForUpdateTaskV1() async throws {
        // >SEPARATOR updateTaskV1 default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateTaskV1(
            taskID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            taskUpdate: TaskUpdateV1(enabled: false)
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateTransformation method.
    ///
    /// updateTransformation
    func snippetForUpdateTransformation() async throws {
        // >SEPARATOR updateTransformation default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.updateTransformation(
            transformationID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            transformationCreate: TransformationCreate(
                name: "bar",
                type: TransformationType.code,
                input: TransformationInput.transformationCode(TransformationCode(code: "foo")),
                description: "baz"
            )
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the validateSource method.
    ///
    /// validateSource
    func snippetForValidateSource() async throws {
        // >SEPARATOR validateSource default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

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
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the validateSourceBeforeUpdate method.
    ///
    /// validateSourceBeforeUpdate
    func snippetForValidateSourceBeforeUpdate() async throws {
        // >SEPARATOR validateSourceBeforeUpdate default
        // Initialize the client
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // Call the API
        let response = try await client.validateSourceBeforeUpdate(
            sourceID: "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
            sourceUpdate: SourceUpdate(name: "newName")
        )
        // >LOG
        // SEPARATOR<
    }
}

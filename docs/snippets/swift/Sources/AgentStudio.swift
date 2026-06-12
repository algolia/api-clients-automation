#if canImport(AlgoliaCore)
    import AlgoliaCore
#endif
// >IMPORT
import AlgoliaAgentStudio

// IMPORT<

final class AgentStudioClientSnippet {
    /// Snippet for the bulkCreateAllowedDomains method.
    ///
    /// bulkCreateAllowedDomains
    func snippetForBulkCreateAllowedDomains() async throws {
        // >SEPARATOR bulkCreateAllowedDomains default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.bulkCreateAllowedDomains(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            allowedDomainBulkInsert: AllowedDomainBulkInsert(domains: ["https://app.example.com", "*.example.org"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the bulkDeleteAllowedDomains method.
    ///
    /// bulkDeleteAllowedDomains
    func snippetForBulkDeleteAllowedDomains() async throws {
        // >SEPARATOR bulkDeleteAllowedDomains default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.bulkDeleteAllowedDomains(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            allowedDomainBulkDelete: AllowedDomainBulkDelete(domainIds: [
                "a1b2c3d4-5678-90ab-cdef-123456789abc",
                "b2c3d4e5-6789-01ab-cdef-234567890abc",
            ])
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the createAgent method.
    ///
    /// createAgent with minimal parameters
    func snippetForCreateAgent() async throws {
        // >SEPARATOR createAgent createAgent with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createAgent(agentConfigCreate: AgentConfigCreate(
            name: "test-agent",
            instructions: "You are a helpful assistant."
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createAgent method.
    ///
    /// createAgent with all parameters
    func snippetForCreateAgent1() async throws {
        // >SEPARATOR createAgent createAgent with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createAgent(agentConfigCreate: AgentConfigCreate(
            name: "test-agent",
            description: "A test agent for CTS",
            providerId: "c2905529-b933-4b69-87ec-75f9829d5f59",
            model: "gpt-4",
            instructions: "You are a helpful assistant.",
            config: ["sendUsage": true, "sendReasoning": true, "temperature": 0.7, "max_tokens": 1500],
            tools: [ToolConfigInput.algoliaDisplayResultsToolConfig(AlgoliaDisplayResultsToolConfig(type: "start"))]
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createAgentAllowedDomain method.
    ///
    /// createAgentAllowedDomain
    func snippetForCreateAgentAllowedDomain() async throws {
        // >SEPARATOR createAgentAllowedDomain default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createAgentAllowedDomain(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            allowedDomainCreate: AllowedDomainCreate(domain: "https://app.example.com")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createAgentCompletion method.
    ///
    /// createAgentCompletion with v4 messages
    func snippetForCreateAgentCompletion() async throws {
        // >SEPARATOR createAgentCompletion createAgentCompletion with v4 messages
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createAgentCompletion(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            compatibilityMode: CompatibilityMode.aiSdk4,
            agentCompletionRequest: AgentCompletionRequest(messages: MessagesUnion
                .arrayOfMessageV4([MessageV4.userMessageV4(UserMessageV4(
                    role: "user",
                    content: "Hello, how are you?"
                ))]))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createFeedback method.
    ///
    /// createFeedback with required parameters
    func snippetForCreateFeedback() async throws {
        // >SEPARATOR createFeedback createFeedback with required parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createFeedback(feedbackCreationRequest: FeedbackCreationRequest(
            messageId: "msg-abc123",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            vote: VoteEnum(rawValue: 1)!
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createFeedback method.
    ///
    /// createFeedback with all parameters
    func snippetForCreateFeedback1() async throws {
        // >SEPARATOR createFeedback createFeedback with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createFeedback(feedbackCreationRequest: FeedbackCreationRequest(
            messageId: "msg-abc123",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            vote: VoteEnum(rawValue: 0)!,
            tags: ["unhelpful", "off-topic"],
            notes: "The response did not address my question."
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createProvider method.
    ///
    /// createProvider with OpenAI
    func snippetForCreateProvider() async throws {
        // >SEPARATOR createProvider createProvider with OpenAI
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createProvider(providerAuthenticationCreate: ProviderAuthenticationCreate(
            name: "My OpenAI Provider",
            providerName: ProviderName.openai,
            input: ProviderInput.openAIProviderInput(OpenAIProviderInput(apiKey: "sk-test-key-1234"))
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createProvider method.
    ///
    /// createProvider with Azure OpenAI
    func snippetForCreateProvider1() async throws {
        // >SEPARATOR createProvider createProvider with Azure OpenAI
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createProvider(providerAuthenticationCreate: ProviderAuthenticationCreate(
            name: "My Azure Provider",
            providerName: ProviderName.azureOpenai,
            input: ProviderInput.azureOpenAIProviderInput(AzureOpenAIProviderInput(
                apiKey: "az-test-key-5678",
                azureEndpoint: "https://my-resource.openai.azure.com",
                azureDeployment: "gpt-4o"
            ))
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createSecretKey method.
    ///
    /// createSecretKey with minimal parameters
    func snippetForCreateSecretKey() async throws {
        // >SEPARATOR createSecretKey createSecretKey with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createSecretKey(secretKeyCreate: SecretKeyCreate(name: "my-secret-key"))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the createSecretKey method.
    ///
    /// createSecretKey with agent IDs
    func snippetForCreateSecretKey1() async throws {
        // >SEPARATOR createSecretKey createSecretKey with agent IDs
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.createSecretKey(secretKeyCreate: SecretKeyCreate(
            name: "scoped-key",
            agentIds: ["76710f1b-8231-42e5-b0d1-f43aac618e15"]
        ))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with all parameters
    func snippetForCustomDelete1() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customDelete(path: "test/all", parameters: ["query": AnyCodable("parameters")])
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with minimal parameters
    func snippetForCustomGet() async throws {
        // >SEPARATOR customGet allow get method for a custom path with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// allow get method for a custom path with all parameters
    func snippetForCustomGet1() async throws {
        // >SEPARATOR customGet allow get method for a custom path with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customGet method.
    ///
    /// requestOptions should be escaped too
    func snippetForCustomGet2() async throws {
        // >SEPARATOR customGet requestOptions should be escaped too
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customGet(
            path: "test/all",
            parameters: ["query": AnyCodable("to be overridden")],
            requestOptions: RequestOptions(
                headers: ["x-header-1": "spaces are left alone"],

                queryParameters: ["query": "parameters with space", "and an array": ["array", "with spaces"]]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with minimal parameters
    func snippetForCustomPost() async throws {
        // >SEPARATOR customPost allow post method for a custom path with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// allow post method for a custom path with all parameters
    func snippetForCustomPost1() async throws {
        // >SEPARATOR customPost allow post method for a custom path with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPost(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default query parameters
    func snippetForCustomPost2() async throws {
        // >SEPARATOR customPost requestOptions can override default query parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges query parameters with default ones
    func snippetForCustomPost3() async throws {
        // >SEPARATOR customPost requestOptions merges query parameters with default ones
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions can override default headers
    func snippetForCustomPost4() async throws {
        // >SEPARATOR customPost requestOptions can override default headers
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions merges headers with default ones
    func snippetForCustomPost5() async throws {
        // >SEPARATOR customPost requestOptions merges headers with default ones
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts booleans
    func snippetForCustomPost6() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts booleans
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts integers
    func snippetForCustomPost7() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts integers
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of string
    func snippetForCustomPost8() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of string
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of booleans
    func snippetForCustomPost9() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPost method.
    ///
    /// requestOptions queryParameters accepts list of integers
    func snippetForCustomPost10() async throws {
        // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with minimal parameters
    func snippetForCustomPut() async throws {
        // >SEPARATOR customPut allow put method for a custom path with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(path: "test/minimal")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the customPut method.
    ///
    /// allow put method for a custom path with all parameters
    func snippetForCustomPut1() async throws {
        // >SEPARATOR customPut allow put method for a custom path with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.customPut(
            path: "test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the deleteAgent method.
    ///
    /// deleteAgent
    func snippetForDeleteAgent() async throws {
        // >SEPARATOR deleteAgent default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteAgent(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteAgentConversations method.
    ///
    /// deleteAgentConversations without filters
    func snippetForDeleteAgentConversations() async throws {
        // >SEPARATOR deleteAgentConversations deleteAgentConversations without filters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteAgentConversations(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteAgentConversations method.
    ///
    /// deleteAgentConversations with date filters
    func snippetForDeleteAgentConversations1() async throws {
        // >SEPARATOR deleteAgentConversations deleteAgentConversations with date filters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteAgentConversations(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            startDate: "2024-01-01",
            endDate: "2024-06-30"
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteAllowedDomain method.
    ///
    /// deleteAllowedDomain
    func snippetForDeleteAllowedDomain() async throws {
        // >SEPARATOR deleteAllowedDomain default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteAllowedDomain(
            domainId: "a1b2c3d4-5678-90ab-cdef-123456789abc",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15"
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteConversation method.
    ///
    /// deleteConversation
    func snippetForDeleteConversation() async throws {
        // >SEPARATOR deleteConversation default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteConversation(
            conversationId: "test-conversation-id",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15"
        )
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteProvider method.
    ///
    /// deleteProvider
    func snippetForDeleteProvider() async throws {
        // >SEPARATOR deleteProvider default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteProvider(providerId: "c2905529-b933-4b69-87ec-75f9829d5f59")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteSecretKey method.
    ///
    /// deleteSecretKey
    func snippetForDeleteSecretKey() async throws {
        // >SEPARATOR deleteSecretKey default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteSecretKey(secretKeyId: "a1b2c3d4-5678-90ab-cdef-123456789abc")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the deleteUserData method.
    ///
    /// deleteUserData
    func snippetForDeleteUserData() async throws {
        // >SEPARATOR deleteUserData default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.deleteUserData(userToken: "test-user-token")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the exportConversations method.
    ///
    /// exportConversations without filters
    func snippetForExportConversations() async throws {
        // >SEPARATOR exportConversations exportConversations without filters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.exportConversations(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the exportConversations method.
    ///
    /// exportConversations with date filters
    func snippetForExportConversations1() async throws {
        // >SEPARATOR exportConversations exportConversations with date filters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.exportConversations(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            startDate: "2024-01-01",
            endDate: "2024-12-31"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the exportConversations method.
    ///
    /// e2e export conversations
    func snippetForExportConversations2() async throws {
        // >SEPARATOR exportConversations e2e export conversations
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.exportConversations(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAgent method.
    ///
    /// getAgent
    func snippetForGetAgent() async throws {
        // >SEPARATOR getAgent getAgent
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getAgent(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAgent method.
    ///
    /// e2e get agent
    func snippetForGetAgent1() async throws {
        // >SEPARATOR getAgent e2e get agent
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getAgent(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAllowedDomain method.
    ///
    /// getAllowedDomain
    func snippetForGetAllowedDomain() async throws {
        // >SEPARATOR getAllowedDomain getAllowedDomain
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getAllowedDomain(
            domainId: "a1b2c3d4-5678-90ab-cdef-123456789abc",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getAllowedDomain method.
    ///
    /// e2e get allowed domain
    func snippetForGetAllowedDomain1() async throws {
        // >SEPARATOR getAllowedDomain e2e get allowed domain
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getAllowedDomain(
            domainId: "6e8a0441-9a41-477c-a1d6-679a461e0990",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getConfiguration method.
    ///
    /// getConfiguration
    func snippetForGetConfiguration() async throws {
        // >SEPARATOR getConfiguration getConfiguration
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getConfiguration()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getConfiguration method.
    ///
    /// e2e getConfiguration
    func snippetForGetConfiguration1() async throws {
        // >SEPARATOR getConfiguration e2e getConfiguration
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getConfiguration()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getConversation method.
    ///
    /// getConversation
    func snippetForGetConversation() async throws {
        // >SEPARATOR getConversation getConversation
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getConversation(
            conversationId: "test-conversation-id",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getConversation method.
    ///
    /// e2e get conversation
    func snippetForGetConversation1() async throws {
        // >SEPARATOR getConversation e2e get conversation
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getConversation(
            conversationId: "alg_cnv_miss_yqcZtaOSPTF8bJsJ",
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getProvider method.
    ///
    /// getProvider
    func snippetForGetProvider() async throws {
        // >SEPARATOR getProvider getProvider
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getProvider(providerId: "c2905529-b933-4b69-87ec-75f9829d5f59")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getProvider method.
    ///
    /// e2e get provider
    func snippetForGetProvider1() async throws {
        // >SEPARATOR getProvider e2e get provider
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getProvider(providerId: "c2905529-b933-4b69-87ec-75f9829d5f59")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSecretKey method.
    ///
    /// getSecretKey
    func snippetForGetSecretKey() async throws {
        // >SEPARATOR getSecretKey getSecretKey
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getSecretKey(secretKeyId: "a1b2c3d4-5678-90ab-cdef-123456789abc")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getSecretKey method.
    ///
    /// e2e get secret key
    func snippetForGetSecretKey1() async throws {
        // >SEPARATOR getSecretKey e2e get secret key
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getSecretKey(secretKeyId: "c110e615-7d5a-4103-865f-c5062c0d6f4d")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getUserData method.
    ///
    /// getUserData
    func snippetForGetUserData() async throws {
        // >SEPARATOR getUserData default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getUserData(userToken: "test-user-token")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the invalidateAgentCache method.
    ///
    /// invalidateAgentCache without before
    func snippetForInvalidateAgentCache() async throws {
        // >SEPARATOR invalidateAgentCache invalidateAgentCache without before
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.invalidateAgentCache(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the invalidateAgentCache method.
    ///
    /// invalidateAgentCache with before date
    func snippetForInvalidateAgentCache1() async throws {
        // >SEPARATOR invalidateAgentCache invalidateAgentCache with before date
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try await client.invalidateAgentCache(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15", before: "2024-12-01")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the listAgentAllowedDomains method.
    ///
    /// listAgentAllowed-Domains
    func snippetForListAgentAllowedDomains() async throws {
        // >SEPARATOR listAgentAllowedDomains listAgentAllowed-Domains
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgentAllowedDomains(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgentAllowedDomains method.
    ///
    /// e2e list agent allowed domains
    func snippetForListAgentAllowedDomains1() async throws {
        // >SEPARATOR listAgentAllowedDomains e2e list agent allowed domains
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgentAllowedDomains(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgentConversations method.
    ///
    /// listAgentConversations with minimal parameters
    func snippetForListAgentConversations() async throws {
        // >SEPARATOR listAgentConversations listAgentConversations with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgentConversations(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgentConversations method.
    ///
    /// listAgentConversations with all parameters
    func snippetForListAgentConversations1() async throws {
        // >SEPARATOR listAgentConversations listAgentConversations with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgentConversations(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            startDate: "2024-01-01",
            endDate: "2024-12-31",
            includeFeedback: true,
            feedbackVote: 1,
            page: 2,
            limit: 10,
            xAlgoliaSecureUserToken: nil
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgentConversations method.
    ///
    /// e2e list agent conversations
    func snippetForListAgentConversations2() async throws {
        // >SEPARATOR listAgentConversations e2e list agent conversations
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgentConversations(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgents method.
    ///
    /// list agents with no params
    func snippetForListAgents() async throws {
        // >SEPARATOR listAgents list agents with no params
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgents()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgents method.
    ///
    /// list agents with all parameters
    func snippetForListAgents1() async throws {
        // >SEPARATOR listAgents list agents with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgents(
            page: 2,
            limit: 5,
            providerId: "c2905529-b933-4b69-87ec-75f9829d5f59"
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listAgents method.
    ///
    /// e2e list agents
    func snippetForListAgents2() async throws {
        // >SEPARATOR listAgents e2e list agents
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listAgents(page: 1, limit: 2, providerId: nil)
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listModels method.
    ///
    /// listModels
    func snippetForListModels() async throws {
        // >SEPARATOR listModels listModels
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listModels()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listModels method.
    ///
    /// e2e list models
    func snippetForListModels1() async throws {
        // >SEPARATOR listModels e2e list models
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listModels()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listProviderModels method.
    ///
    /// listProviderModels
    func snippetForListProviderModels() async throws {
        // >SEPARATOR listProviderModels listProviderModels
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listProviderModels(providerId: "c2905529-b933-4b69-87ec-75f9829d5f59")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listProviderModels method.
    ///
    /// e2e list provider models
    func snippetForListProviderModels1() async throws {
        // >SEPARATOR listProviderModels e2e list provider models
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listProviderModels(providerId: "c2905529-b933-4b69-87ec-75f9829d5f59")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listProviders method.
    ///
    /// listProviders with no params
    func snippetForListProviders() async throws {
        // >SEPARATOR listProviders listProviders with no params
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listProviders()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listProviders method.
    ///
    /// listProviders with pagination
    func snippetForListProviders1() async throws {
        // >SEPARATOR listProviders listProviders with pagination
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listProviders(page: 2, limit: 5)
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listProviders method.
    ///
    /// e2e list providers
    func snippetForListProviders2() async throws {
        // >SEPARATOR listProviders e2e list providers
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listProviders(page: 1, limit: 2)
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listSecretKeys method.
    ///
    /// listSecretKeys with no params
    func snippetForListSecretKeys() async throws {
        // >SEPARATOR listSecretKeys listSecretKeys with no params
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listSecretKeys()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listSecretKeys method.
    ///
    /// listSecretKeys with pagination
    func snippetForListSecretKeys1() async throws {
        // >SEPARATOR listSecretKeys listSecretKeys with pagination
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listSecretKeys(page: 2, limit: 5)
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listSecretKeys method.
    ///
    /// e2e list secret keys
    func snippetForListSecretKeys2() async throws {
        // >SEPARATOR listSecretKeys e2e list secret keys
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listSecretKeys(page: 1, limit: 10)
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the publishAgent method.
    ///
    /// publishAgent
    func snippetForPublishAgent() async throws {
        // >SEPARATOR publishAgent default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.publishAgent(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the setClientApiKey method.
    ///
    /// switch API key
    func snippetForSetClientApiKey() async throws {
        // >SEPARATOR setClientApiKey default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the unpublishAgent method.
    ///
    /// unpublishAgent
    func snippetForUnpublishAgent() async throws {
        // >SEPARATOR unpublishAgent default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.unpublishAgent(agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the updateAgent method.
    ///
    /// updateAgent with minimal parameters
    func snippetForUpdateAgent() async throws {
        // >SEPARATOR updateAgent updateAgent with minimal parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateAgent(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            agentConfigUpdate: AgentConfigUpdate(name: "updated-agent-name")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the updateAgent method.
    ///
    /// updateAgent with all parameters
    func snippetForUpdateAgent1() async throws {
        // >SEPARATOR updateAgent updateAgent with all parameters
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateAgent(
            agentId: "76710f1b-8231-42e5-b0d1-f43aac618e15",
            agentConfigUpdate: AgentConfigUpdate(
                name: "updated-agent",
                description: "Updated description",
                providerId: "new-provider-id",
                model: "gpt-4o",
                instructions: "Updated instructions.",
                config: ["temperature": 0.5],
                tools: [ToolConfigInput.algoliaDisplayResultsToolConfig(AlgoliaDisplayResultsToolConfig(type: "start"))]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the updateConfiguration method.
    ///
    /// updateConfiguration
    func snippetForUpdateConfiguration() async throws {
        // >SEPARATOR updateConfiguration default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .updateConfiguration(applicationConfigPatch: ApplicationConfigPatch(maxRetentionDays: 30))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the updateProvider method.
    ///
    /// updateProvider
    func snippetForUpdateProvider() async throws {
        // >SEPARATOR updateProvider updateProvider
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateProvider(
            providerId: "c2905529-b933-4b69-87ec-75f9829d5f59",
            providerAuthenticationPatch: ProviderAuthenticationPatch(name: "Updated Provider Name")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the updateProvider method.
    ///
    /// updateProvider with input
    func snippetForUpdateProvider1() async throws {
        // >SEPARATOR updateProvider updateProvider with input
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateProvider(
            providerId: "c2905529-b933-4b69-87ec-75f9829d5f59",
            providerAuthenticationPatch: ProviderAuthenticationPatch(
                name: "Updated Provider",
                input: ProviderInputNullable.openAIProviderInput(OpenAIProviderInput(apiKey: "sk-new-key-5678"))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the updateSecretKey method.
    ///
    /// updateSecretKey
    func snippetForUpdateSecretKey() async throws {
        // >SEPARATOR updateSecretKey default
        // Initialize the client
        let client = try AgentStudioClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateSecretKey(
            secretKeyId: "a1b2c3d4-5678-90ab-cdef-123456789abc",
            secretKeyPatch: SecretKeyPatch(name: "renamed-key", agentIds: ["76710f1b-8231-42e5-b0d1-f43aac618e15"])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }
}

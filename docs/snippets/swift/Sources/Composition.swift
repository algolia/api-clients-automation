#if canImport(Core)
    import Core
#endif
// >IMPORT
import Composition

// IMPORT<

final class CompositionClientSnippet {
    /// Snippet for the customDelete method.
    ///
    /// allow del method for a custom path with minimal parameters
    func snippetForCustomDelete() async throws {
        // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

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

    /// Snippet for the deleteComposition method.
    ///
    /// deleteComposition
    func snippetForDeleteComposition() async throws {
        // >SEPARATOR deleteComposition default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteComposition(compositionID: "1234")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the deleteCompositionRule method.
    ///
    /// deleteCompositionRule
    func snippetForDeleteCompositionRule() async throws {
        // >SEPARATOR deleteCompositionRule default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.deleteCompositionRule(compositionID: "1234", objectID: "5678")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getComposition method.
    ///
    /// getComposition
    func snippetForGetComposition() async throws {
        // >SEPARATOR getComposition default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getComposition(compositionID: "foo")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getRule method.
    ///
    /// getRule
    func snippetForGetRule() async throws {
        // >SEPARATOR getRule default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getRule(compositionID: "foo", objectID: "123")
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the getTask method.
    ///
    /// getTask
    func snippetForGetTask() async throws {
        // >SEPARATOR getTask default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.getTask(compositionID: "foo", taskID: Int64(42))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listCompositions method.
    ///
    /// listCompositions
    func snippetForListCompositions() async throws {
        // >SEPARATOR listCompositions listCompositions
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listCompositions()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the listCompositions method.
    ///
    /// listCompositions
    func snippetForListCompositions1() async throws {
        // >SEPARATOR listCompositions listCompositions
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.listCompositions()
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch
    func snippetForMultipleBatch() async throws {
        // >SEPARATOR multipleBatch multipleBatch
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.multipleBatch(batchParams: CompositionBatchParams(requests: [
            CompositionMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: BatchCompositionAction.composition(Composition(
                    objectID: "foo",
                    name: "my first composition",
                    behavior: CompositionBehavior
                        .compositionInjectionBehavior(
                            CompositionInjectionBehavior(
                                injection: Injection(
                                    main: CompositionMain(
                                        source: CompositionSource(search: CompositionSourceSearch(index: "bar"))
                                    )
                                )
                            )
                        )
                ))
            ),
            CompositionMultipleBatchRequest(
                action: CompositionAction.delete,
                body: BatchCompositionAction.deleteCompositionAction(DeleteCompositionAction(objectID: "baz"))
            ),
        ]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch
    func snippetForMultipleBatch1() async throws {
        // >SEPARATOR multipleBatch multipleBatch
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .multipleBatch(batchParams: CompositionBatchParams(requests: [CompositionMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: BatchCompositionAction.composition(Composition(
                    objectID: "my-external-injection-compo",
                    name: "my first composition",
                    behavior: CompositionBehavior
                        .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(
                                source: CompositionSource(search: CompositionSourceSearch(index: "foo"))
                            ),
                            injectedItems: [InjectedItem(
                                key: "my-unique-external-group-key",
                                source: InjectedItemSource.externalSource(ExternalSource(external: External(
                                    index: "foo",
                                    params: BaseInjectionQueryParameters(filters: "brand:adidas"),
                                    ordering: ExternalOrdering.userDefined
                                ))),
                                position: 2,
                                length: 1
                            )]
                        )))
                ))
            )]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch
    func snippetForMultipleBatch2() async throws {
        // >SEPARATOR multipleBatch multipleBatch
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .multipleBatch(batchParams: CompositionBatchParams(requests: [CompositionMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: BatchCompositionAction.composition(Composition(
                    objectID: "my-metadata-compo",
                    name: "my composition",
                    behavior: CompositionBehavior
                        .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(
                                index: "foo",
                                params: MainInjectionQueryParameters(filters: "brand:adidas")
                            ))),
                            injectedItems: [
                                InjectedItem(
                                    key: "my-unique-group-key",
                                    source: InjectedItemSource
                                        .compositionSearchSource(CompositionSearchSource(search: Search(
                                            index: "foo",
                                            params: BaseInjectionQueryParameters(filters: "brand:adidas")
                                        ))),
                                    position: 2,
                                    length: 1,
                                    metadata: InjectedItemMetadata(hits: InjectedItemHitsMetadata(
                                        addItemKey: true,
                                        extra: [
                                            "my-string": AnyCodable("string"),
                                            "my-bool": true,
                                            "my-number": 42,
                                            "my-object": ["sub-key": "sub-value"],
                                        ]
                                    ))
                                ),
                                InjectedItem(
                                    key: "my-unique-group-key",
                                    source: InjectedItemSource
                                        .compositionSearchSource(CompositionSearchSource(search: Search(
                                            index: "foo",
                                            params: BaseInjectionQueryParameters(filters: "brand:puma")
                                        ))),
                                    position: 5,
                                    length: 5,
                                    metadata: InjectedItemMetadata(hits: InjectedItemHitsMetadata(
                                        addItemKey: true,
                                        extra: [
                                            "my-string": AnyCodable("string"),
                                            "my-bool": true,
                                            "my-number": 42,
                                            "my-object": ["sub-key": "sub-value"],
                                        ]
                                    ))
                                ),
                            ]
                        )))
                ))
            )]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the multipleBatch method.
    ///
    /// multipleBatch
    func snippetForMultipleBatch3() async throws {
        // >SEPARATOR multipleBatch multipleBatch
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client
            .multipleBatch(batchParams: CompositionBatchParams(requests: [CompositionMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: BatchCompositionAction.composition(Composition(
                    objectID: "my-compo",
                    name: "my composition",
                    behavior: CompositionBehavior
                        .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(
                                source: CompositionSource(search: CompositionSourceSearch(index: "foo"))
                            ),
                            injectedItems: [InjectedItem(
                                key: "my-unique-injected-item-key",
                                source: InjectedItemSource
                                    .compositionSearchSource(CompositionSearchSource(search: Search(index: "foo"))),
                                position: 2,
                                length: 1
                            )],
                            deduplication: Deduplication(positioning: DedupPositioning.highest)
                        )))
                ))
            )]))
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putComposition method.
    ///
    /// putComposition
    func snippetForPutComposition() async throws {
        // >SEPARATOR putComposition putComposition
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putComposition(
            compositionID: "1234",
            composition: Composition(
                objectID: "1234",
                name: "my first composition",
                behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(index: "foo"))),
                        injectedItems: [InjectedItem(
                            key: "my-unique-group-key",
                            source: InjectedItemSource
                                .compositionSearchSource(CompositionSearchSource(search: Search(index: "foo"))),
                            position: 2,
                            length: 1
                        )]
                    )))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putComposition method.
    ///
    /// putComposition
    func snippetForPutComposition1() async throws {
        // >SEPARATOR putComposition putComposition
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putComposition(
            compositionID: "my-external-injection-compo",
            composition: Composition(
                objectID: "my-external-injection-compo",
                name: "my first composition",
                behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(index: "foo"))),
                        injectedItems: [InjectedItem(
                            key: "my-unique-external-group-key",
                            source: InjectedItemSource.externalSource(ExternalSource(external: External(
                                index: "foo",
                                params: BaseInjectionQueryParameters(filters: "brand:adidas"),
                                ordering: ExternalOrdering.userDefined
                            ))),
                            position: 2,
                            length: 1
                        )]
                    )))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putComposition method.
    ///
    /// putComposition
    func snippetForPutComposition2() async throws {
        // >SEPARATOR putComposition putComposition
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putComposition(
            compositionID: "my-metadata-compo",
            composition: Composition(
                objectID: "my-metadata-compo",
                name: "my composition",
                behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(
                            index: "foo",
                            params: MainInjectionQueryParameters(filters: "brand:adidas")
                        ))),
                        injectedItems: [
                            InjectedItem(
                                key: "my-unique-group-key",
                                source: InjectedItemSource
                                    .compositionSearchSource(CompositionSearchSource(search: Search(
                                        index: "foo",
                                        params: BaseInjectionQueryParameters(filters: "brand:adidas")
                                    ))),
                                position: 2,
                                length: 1,
                                metadata: InjectedItemMetadata(hits: InjectedItemHitsMetadata(
                                    addItemKey: true,
                                    extra: [
                                        "my-string": AnyCodable("string"),
                                        "my-bool": true,
                                        "my-number": 42,
                                        "my-object": ["sub-key": "sub-value"],
                                    ]
                                ))
                            ),
                            InjectedItem(
                                key: "my-unique-group-key",
                                source: InjectedItemSource
                                    .compositionSearchSource(CompositionSearchSource(search: Search(
                                        index: "foo",
                                        params: BaseInjectionQueryParameters(filters: "brand:puma")
                                    ))),
                                position: 5,
                                length: 5,
                                metadata: InjectedItemMetadata(hits: InjectedItemHitsMetadata(
                                    addItemKey: true,
                                    extra: [
                                        "my-string": AnyCodable("string"),
                                        "my-bool": true,
                                        "my-number": 42,
                                        "my-object": ["sub-key": "sub-value"],
                                    ]
                                ))
                            ),
                        ]
                    )))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putComposition method.
    ///
    /// putComposition
    func snippetForPutComposition3() async throws {
        // >SEPARATOR putComposition putComposition
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putComposition(
            compositionID: "my-compo",
            composition: Composition(
                objectID: "my-compo",
                name: "my composition",
                behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(
                            index: "foo",
                            params: MainInjectionQueryParameters(filters: "brand:adidas")
                        ))),
                        injectedItems: [InjectedItem(
                            key: "my-unique-injected-item-key",
                            source: InjectedItemSource
                                .compositionSearchSource(CompositionSearchSource(search: Search(index: "foo"))),
                            position: 2,
                            length: 1
                        )],
                        deduplication: Deduplication(positioning: DedupPositioning.highest)
                    )))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putComposition method.
    ///
    /// putComposition
    func snippetForPutComposition4() async throws {
        // >SEPARATOR putComposition putComposition
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putComposition(
            compositionID: "my-compo",
            composition: Composition(
                objectID: "my-compo",
                name: "my composition",
                behavior: CompositionBehavior
                    .compositionInjectionBehavior(
                        CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(source: CompositionSource(
                                search: CompositionSourceSearch(index: "products")
                            ))
                        ))
                    ),
                sortingStrategy: ["Price-asc": "products-low-to-high", "Price-desc": "products-high-to-low"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putCompositionRule method.
    ///
    /// putCompositionRule
    func snippetForPutCompositionRule() async throws {
        // >SEPARATOR putCompositionRule putCompositionRule
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putCompositionRule(
            compositionID: "compositionID",
            objectID: "ruleID",
            compositionRule: CompositionRule(
                objectID: "ruleID",
                conditions: [CompositionCondition(pattern: "test", anchoring: CompositionAnchoring.`is`)],
                consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(index: "foo"))),
                        injectedItems: [InjectedItem(
                            key: "my-unique-group-from-rule-key",
                            source: InjectedItemSource
                                .compositionSearchSource(CompositionSearchSource(search: Search(index: "foo"))),
                            position: 2,
                            length: 1
                        )]
                    ))))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putCompositionRule method.
    ///
    /// putCompositionRule
    func snippetForPutCompositionRule1() async throws {
        // >SEPARATOR putCompositionRule putCompositionRule
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putCompositionRule(
            compositionID: "compositionID",
            objectID: "rule-with-metadata",
            compositionRule: CompositionRule(
                objectID: "rule-with-metadata",
                conditions: [CompositionCondition(pattern: "test", anchoring: CompositionAnchoring.`is`)],
                consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(index: "foo"))),
                        injectedItems: [InjectedItem(
                            key: "my-unique-group-from-rule-key",
                            source: InjectedItemSource.compositionSearchSource(CompositionSearchSource(search: Search(
                                index: "foo",
                                params: BaseInjectionQueryParameters(filters: "brand:adidas")
                            ))),
                            position: 2,
                            length: 1,
                            metadata: InjectedItemMetadata(hits: InjectedItemHitsMetadata(
                                addItemKey: true,
                                extra: [
                                    "my-string": AnyCodable("string"),
                                    "my-bool": true,
                                    "my-number": 42,
                                    "my-object": ["sub-key": "sub-value"],
                                ]
                            ))
                        )]
                    ))))
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putCompositionRule method.
    ///
    /// putCompositionRule
    func snippetForPutCompositionRule2() async throws {
        // >SEPARATOR putCompositionRule putCompositionRule
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putCompositionRule(
            compositionID: "compositionID",
            objectID: "rule-with-exernal-source",
            compositionRule: CompositionRule(
                objectID: "rule-with-exernal-source",
                conditions: [
                    CompositionCondition(pattern: "harry", anchoring: CompositionAnchoring.contains),
                    CompositionCondition(pattern: "potter", anchoring: CompositionAnchoring.contains),
                ],
                consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(
                            index: "my-index",
                            params: MainInjectionQueryParameters(filters: "brand:adidas")
                        ))),
                        injectedItems: [InjectedItem(
                            key: "my-unique-external-group-from-rule-key",
                            source: InjectedItemSource.externalSource(ExternalSource(external: External(
                                index: "my-index",
                                params: BaseInjectionQueryParameters(filters: "brand:adidas"),
                                ordering: ExternalOrdering.userDefined
                            ))),
                            position: 0,
                            length: 3
                        )]
                    )))),
                description: "my description",
                enabled: true,
                validity: [CompositionTimeRange(from: Int64(1_704_063_600), until: Int64(1_704_083_600))],
                tags: ["tag1", "tag2"]
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the putCompositionRule method.
    ///
    /// putCompositionRule
    func snippetForPutCompositionRule3() async throws {
        // >SEPARATOR putCompositionRule putCompositionRule
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.putCompositionRule(
            compositionID: "compositionID",
            objectID: "rule-with-deduplication",
            compositionRule: CompositionRule(
                objectID: "rule-with-deduplication",
                conditions: [CompositionCondition(pattern: "harry", anchoring: CompositionAnchoring.contains)],
                consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                    .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                        main: CompositionMain(
                            source: CompositionSource(search: CompositionSourceSearch(index: "my-index"))
                        ),
                        injectedItems: [InjectedItem(
                            key: "my-unique-injected-item-key",
                            source: InjectedItemSource
                                .compositionSearchSource(CompositionSearchSource(search: Search(index: "my-index"))),
                            position: 0,
                            length: 3
                        )],
                        deduplication: Deduplication(positioning: DedupPositioning.highestInjected)
                    )))),
                description: "my description",
                enabled: true
            )
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules
    func snippetForSaveRules() async throws {
        // >SEPARATOR saveRules saveRules
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            compositionID: "foo",
            rules: CompositionRulesBatchParams(requests: [RulesMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: RulesBatchCompositionAction.compositionRule(CompositionRule(
                    objectID: "123",
                    conditions: [CompositionCondition(pattern: "a")],
                    consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                        .compositionInjectionBehavior(
                            CompositionInjectionBehavior(injection: Injection(
                                main: CompositionMain(source: CompositionSource(
                                    search: CompositionSourceSearch(index: "<YOUR_INDEX_NAME>")
                                ))
                            ))
                        ))
                ))
            )])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules
    func snippetForSaveRules1() async throws {
        // >SEPARATOR saveRules saveRules
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            compositionID: "rule-with-metadata",
            rules: CompositionRulesBatchParams(requests: [RulesMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: RulesBatchCompositionAction.compositionRule(CompositionRule(
                    objectID: "rule-with-metadata",
                    conditions: [CompositionCondition(pattern: "test", anchoring: CompositionAnchoring.`is`)],
                    consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                        .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(
                                source: CompositionSource(search: CompositionSourceSearch(index: "foo"))
                            ),
                            injectedItems: [InjectedItem(
                                key: "my-unique-group-from-rule-key",
                                source: InjectedItemSource
                                    .compositionSearchSource(CompositionSearchSource(search: Search(
                                        index: "foo",
                                        params: BaseInjectionQueryParameters(filters: "brand:adidas")
                                    ))),
                                position: 2,
                                length: 1,
                                metadata: InjectedItemMetadata(hits: InjectedItemHitsMetadata(
                                    addItemKey: true,
                                    extra: [
                                        "my-string": AnyCodable("string"),
                                        "my-bool": true,
                                        "my-number": 42,
                                        "my-object": ["sub-key": "sub-value"],
                                    ]
                                ))
                            )]
                        ))))
                ))
            )])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules
    func snippetForSaveRules2() async throws {
        // >SEPARATOR saveRules saveRules
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            compositionID: "rule-with-exernal-source",
            rules: CompositionRulesBatchParams(requests: [RulesMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: RulesBatchCompositionAction.compositionRule(CompositionRule(
                    objectID: "rule-with-exernal-source",
                    conditions: [
                        CompositionCondition(pattern: "harry", anchoring: CompositionAnchoring.contains),
                        CompositionCondition(pattern: "potter", anchoring: CompositionAnchoring.contains),
                    ],
                    consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                        .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(source: CompositionSource(search: CompositionSourceSearch(
                                index: "my-index",
                                params: MainInjectionQueryParameters(filters: "brand:adidas")
                            ))),
                            injectedItems: [InjectedItem(
                                key: "my-unique-external-group-from-rule-key",
                                source: InjectedItemSource.externalSource(ExternalSource(external: External(
                                    index: "my-index",
                                    params: BaseInjectionQueryParameters(filters: "brand:adidas"),
                                    ordering: ExternalOrdering.userDefined
                                ))),
                                position: 0,
                                length: 3
                            )]
                        )))),
                    description: "my description",
                    enabled: true,
                    validity: [CompositionTimeRange(from: Int64(1_704_063_600), until: Int64(1_704_083_600))],
                    tags: ["tag1", "tag2"]
                ))
            )])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the saveRules method.
    ///
    /// saveRules
    func snippetForSaveRules3() async throws {
        // >SEPARATOR saveRules saveRules
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.saveRules(
            compositionID: "my-compo",
            rules: CompositionRulesBatchParams(requests: [RulesMultipleBatchRequest(
                action: CompositionAction.upsert,
                body: RulesBatchCompositionAction.compositionRule(CompositionRule(
                    objectID: "rule-with-deduplication",
                    conditions: [
                        CompositionCondition(pattern: "harry", anchoring: CompositionAnchoring.contains),
                        CompositionCondition(sortBy: "price-low-to-high"),
                    ],
                    consequence: CompositionRuleConsequence(behavior: CompositionBehavior
                        .compositionInjectionBehavior(CompositionInjectionBehavior(injection: Injection(
                            main: CompositionMain(
                                source: CompositionSource(search: CompositionSourceSearch(index: "my-index"))
                            ),
                            injectedItems: [InjectedItem(
                                key: "my-unique-injected-item-key",
                                source: InjectedItemSource
                                    .compositionSearchSource(
                                        CompositionSearchSource(search: Search(index: "my-index"))
                                    ),
                                position: 0,
                                length: 3
                            )],
                            deduplication: Deduplication(positioning: DedupPositioning.highestInjected)
                        )))),
                    description: "my description",
                    enabled: true
                ))
            )])
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search
    func snippetForSearch() async throws {
        // >SEPARATOR search search
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: CompositionSearchResponse<CompositionHit> = try await client.search(
            compositionID: "foo",
            requestBody: RequestBody(params: CompositionParams(query: "batman"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search
    func snippetForSearch1() async throws {
        // >SEPARATOR search search
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: CompositionSearchResponse<CompositionHit> = try await client.search(
            compositionID: "foo",
            requestBody: RequestBody(params: CompositionParams(
                injectedItems: ["my-unique-external-group-key": ExternalInjectedItem(items: [
                    ExternalInjection(objectID: "my-object-1"),
                    ExternalInjection(
                        objectID: "my-object-2",
                        metadata: [
                            "my-string": AnyCodable("string"),
                            "my-bool": true,
                            "my-number": 42,
                            "my-object": ["sub-key": "sub-value"],
                        ]
                    ),
                ])],
                query: "batman"
            ))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the search method.
    ///
    /// search
    func snippetForSearch2() async throws {
        // >SEPARATOR search search
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response: CompositionSearchResponse<CompositionHit> = try await client.search(
            compositionID: "foo",
            requestBody: RequestBody(params: CompositionParams(query: "batman", sortBy: "Price (asc)"))
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchCompositionRules method.
    ///
    /// searchCompositionRules
    func snippetForSearchCompositionRules() async throws {
        // >SEPARATOR searchCompositionRules default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchCompositionRules(
            compositionID: "foo",
            searchCompositionRulesParams: SearchCompositionRulesParams(query: "batman")
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }

    /// Snippet for the searchForFacetValues method.
    ///
    /// searchForFacetValues
    func snippetForSearchForFacetValues() async throws {
        // >SEPARATOR searchForFacetValues default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.searchForFacetValues(
            compositionID: "foo",
            facetName: "brand",
            searchForFacetValuesRequest: CompositionSearchForFacetValuesRequest(
                params: SearchForFacetValuesParams(maxFacetHits: 10)
            )
        )
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
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        try client.setClientApiKey(apiKey: "updated-api-key")
        // >LOG
        // SEPARATOR<
    }

    /// Snippet for the updateSortingStrategyComposition method.
    ///
    /// updateSortingStrategyComposition
    func snippetForUpdateSortingStrategyComposition() async throws {
        // >SEPARATOR updateSortingStrategyComposition default
        // Initialize the client
        let client = try CompositionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // Call the API
        let response = try await client.updateSortingStrategyComposition(
            compositionID: "my-compo",
            requestBody: ["Price-asc": "products-low-to-high", "Price-desc": "products-high-to-low"]
        )
        // >LOG
        // print the response
        print(response)
        // SEPARATOR<
    }
}

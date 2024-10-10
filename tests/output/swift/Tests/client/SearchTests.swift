// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import XCTest

import Utils

@testable import Core
@testable import Search

final class SearchClientClientTests: XCTestCase {
    let APPLICATION_ID = "my_application_id"
    let API_KEY = "my_api_key"

    /// calls api with correct read host
    func testApiTest0() async throws {
        let configuration = try SearchClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customGetWithHTTPInfo(path: "test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id-dsn.algolia.net", echoResponse.host)
    }

    /// read transporter with POST method
    func testApiTest1() async throws {
        let configuration = try SearchClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response: Response<SearchResponse<Hit>> = try await client
            .searchSingleIndexWithHTTPInfo(indexName: "indexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id-dsn.algolia.net", echoResponse.host)
    }

    /// calls api with correct write host
    func testApiTest2() async throws {
        let configuration = try SearchClientConfiguration(appID: "test-app-id", apiKey: "test-api-key")
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customPostWithHTTPInfo(path: "test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual("test-app-id.algolia.net", echoResponse.host)
    }

    /// tests the retry strategy
    func testApiTest3() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [
                RetryableHost(url: URL(
                    string: "http://" +
                        (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                        ":6676"
                )!),
                RetryableHost(url: URL(
                    string: "http://" +
                        (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                        ":6677"
                )!),
                RetryableHost(url: URL(
                    string: "http://" +
                        (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                        ":6678"
                )!),
            ]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customGetWithHTTPInfo(path: "1/test/retry/swift")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

        let comparableData = "{\"message\":\"ok test server response\"}".data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
        XCTAssertEqual(comparableJSON, responseBodyJSON)
    }

    /// tests the retry strategy error
    func testApiTest4() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6676"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.customGetWithHTTPInfo(path: "1/test/hang/swift")
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(
                error.localizedDescription,
                "All hosts are unreachable. You can use 'exposeIntermediateErrors: true' in the config to investigate."
            )
        }
    }

    /// test the compression strategy
    func testApiTest5() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6678"
            )!)],
            compression: .gzip
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        let response = try await client.customPostWithHTTPInfo(
            path: "1/test/gzip",
            parameters: [String: AnyCodable](),
            body: ["message": "this is a compressed body"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

        let comparableData =
            "{\"message\":\"ok compression test server response\",\"body\":{\"message\":\"this is a compressed body\"}}"
                .data(using: .utf8)
        let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
        XCTAssertEqual(comparableJSON, responseBodyJSON)
    }

    /// calls api with correct user agent
    func testCommonApiTest0() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let userAgent = try XCTUnwrap(echoResponse.headers?["User-Agent"])
        guard let userAgent else {
            XCTFail("Expected user-agent header")
            return
        }

        let pattern =
            "^Algolia for Swift \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+ (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$"
        XCTAssertNoThrow(
            try regexMatch(userAgent, against: pattern),
            "Expected " + userAgent + " to match the following regex: " + pattern
        )
    }

    /// the user agent contains the latest version
    func testCommonApiTest1() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let userAgent = try XCTUnwrap(echoResponse.headers?["User-Agent"])
        guard let userAgent else {
            XCTFail("Expected user-agent header")
            return
        }

        let pattern = "^Algolia for Swift \\(9.7.0\\).*"
        XCTAssertNoThrow(
            try regexMatch(userAgent, against: pattern),
            "Expected " + userAgent + " to match the following regex: " + pattern
        )
    }

    /// calls api with default read timeouts
    func testCommonApiTest2() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(5000 / 1000), echoResponse.timeout)
    }

    /// calls api with default write timeouts
    func testCommonApiTest3() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "1/test")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertEqual(TimeInterval(30000 / 1000), echoResponse.timeout)
    }

    /// call deleteObjects without error
    func testDeleteObjectsTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6680"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.deleteObjects(
                indexName: "cts_e2e_deleteObjects_swift",
                objectIDs: ["1", "2"]
            )

            let comparableData = try XCTUnwrap("[{\"taskID\":666,\"objectIDs\":[\"1\",\"2\"]}]".data(using: .utf8))
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// generate secured api key basic
    func testGenerateSecuredApiKeyTest0() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        do {
            let response = try client.generateSecuredApiKey(
                parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
                restrictions: SecuredApiKeyRestrictions(validUntil: Int64(2_524_604_400), restrictIndices: ["Movies"])
            )

            XCTAssertEqual(
                "NjFhZmE0OGEyMTI3OThiODc0OTlkOGM0YjcxYzljY2M2NmU2NDE5ZWY0NDZjMWJhNjA2NzBkMjAwOTI2YWQyZnJlc3RyaWN0SW5kaWNlcz1Nb3ZpZXMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw",
                response
            )
        }
    }

    /// generate secured api key with searchParams
    func testGenerateSecuredApiKeyTest1() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        do {
            let response = try client.generateSecuredApiKey(
                parentApiKey: "2640659426d5107b6e47d75db9cbaef8",
                restrictions: SecuredApiKeyRestrictions(
                    searchParams: SearchSearchParamsObject(
                        query: "batman",
                        aroundRadius: SearchAroundRadius.searchAroundRadiusAll(SearchAroundRadiusAll.all),
                        hitsPerPage: 10,
                        typoTolerance: SearchTypoTolerance.searchTypoToleranceEnum(SearchTypoToleranceEnum.strict),
                        mode: SearchMode.neuralSearch,
                        optionalWords: ["one", "two"]
                    ),
                    filters: "category:Book OR category:Ebook AND _tags:published",
                    validUntil: Int64(2_524_604_400),
                    restrictIndices: ["Movies", "cts_e2e_settings"],
                    restrictSources: "192.168.1.0/24",
                    userToken: "user123"
                )
            )

            XCTAssertEqual(
                "MzAxMDUwYjYyODMxODQ3ZWM1ZDYzNTkxZmNjNDg2OGZjMjAzYjQyOTZhMGQ1NDJhMDFiNGMzYTYzODRhNmMxZWFyb3VuZFJhZGl1cz1hbGwmZmlsdGVycz1jYXRlZ29yeSUzQUJvb2slMjBPUiUyMGNhdGVnb3J5JTNBRWJvb2slMjBBTkQlMjBfdGFncyUzQXB1Ymxpc2hlZCZoaXRzUGVyUGFnZT0xMCZtb2RlPW5ldXJhbFNlYXJjaCZvcHRpb25hbFdvcmRzPW9uZSUyQ3R3byZxdWVyeT1iYXRtYW4mcmVzdHJpY3RJbmRpY2VzPU1vdmllcyUyQ2N0c19lMmVfc2V0dGluZ3MmcmVzdHJpY3RTb3VyY2VzPTE5Mi4xNjguMS4wJTJGMjQmdHlwb1RvbGVyYW5jZT1zdHJpY3QmdXNlclRva2VuPXVzZXIxMjMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw",
                response
            )
        }
    }

    /// indexExists
    func testIndexExistsTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.indexExists(indexName: "indexExistsYES")

            XCTAssertEqual(true, response)
        }
    }

    /// indexNotExists
    func testIndexExistsTest1() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.indexExists(indexName: "indexExistsNO")

            XCTAssertEqual(false, response)
        }
    }

    /// indexExistsWithError
    func testIndexExistsTest2() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.indexExists(indexName: "indexExistsERROR")

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "HTTP error: Status code: 403 Message: Invalid API key")
        }
    }

    /// client throws with invalid parameters
    func testParametersTest0() async throws {
        do {
            let configuration = try SearchClientConfiguration(appID: "", apiKey: "")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = SearchClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`appId` is missing.")
        }
        do {
            let configuration = try SearchClientConfiguration(appID: "", apiKey: "my-api-key")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = SearchClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`appId` is missing.")
        }
        do {
            let configuration = try SearchClientConfiguration(appID: "my-app-id", apiKey: "")
            let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
            let client = SearchClient(configuration: configuration, transporter: transporter)

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(error.localizedDescription, "`apiKey` is missing.")
        }
    }

    /// `addApiKey` throws with invalid parameters
    func testParametersTest1() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
    }

    /// `addOrUpdateObject` throws with invalid parameters
    func testParametersTest2() async throws {
        let configuration = try SearchClientConfiguration(appID: APPLICATION_ID, apiKey: API_KEY)
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)
    }

    /// call partialUpdateObjects with createIfNotExists=true
    func testPartialUpdateObjectsTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6680"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.partialUpdateObjects(
                indexName: "cts_e2e_partialUpdateObjects_swift",
                objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]],
                createIfNotExists: true
            )

            let comparableData = try XCTUnwrap("[{\"taskID\":444,\"objectIDs\":[\"1\",\"2\"]}]".data(using: .utf8))
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// call partialUpdateObjects with createIfNotExists=false
    func testPartialUpdateObjectsTest1() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6680"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.partialUpdateObjects(
                indexName: "cts_e2e_partialUpdateObjects_swift",
                objects: [["objectID": "3", "name": "Cyril"], ["objectID": "4", "name": "David"]],
                createIfNotExists: false
            )

            let comparableData = try XCTUnwrap("[{\"taskID\":555,\"objectIDs\":[\"3\",\"4\"]}]".data(using: .utf8))
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// call replaceAllObjects without error
    func testReplaceAllObjectsTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6679"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.replaceAllObjects(
                indexName: "cts_e2e_replace_all_objects_swift",
                objects: [
                    ["objectID": "1", "name": "Adam"],
                    ["objectID": "2", "name": "Benoit"],
                    ["objectID": "3", "name": "Cyril"],
                    ["objectID": "4", "name": "David"],
                    ["objectID": "5", "name": "Eva"],
                    ["objectID": "6", "name": "Fiona"],
                    ["objectID": "7", "name": "Gael"],
                    ["objectID": "8", "name": "Hugo"],
                    ["objectID": "9", "name": "Igor"],
                    ["objectID": "10", "name": "Julia"],
                ],
                batchSize: 3
            )

            let comparableData =
                try XCTUnwrap(
                    "{\"copyOperationResponse\":{\"taskID\":125,\"updatedAt\":\"2021-01-01T00:00:00.000Z\"},\"batchResponses\":[{\"taskID\":127,\"objectIDs\":[\"1\",\"2\",\"3\"]},{\"taskID\":130,\"objectIDs\":[\"4\",\"5\",\"6\"]},{\"taskID\":133,\"objectIDs\":[\"7\",\"8\",\"9\"]},{\"taskID\":134,\"objectIDs\":[\"10\"]}],\"moveOperationResponse\":{\"taskID\":777,\"updatedAt\":\"2021-01-01T00:00:00.000Z\"}}"
                        .data(using: .utf8)
                )
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// call saveObjects without error
    func testSaveObjectsTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6680"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.saveObjects(
                indexName: "cts_e2e_saveObjects_swift",
                objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]]
            )

            let comparableData = try XCTUnwrap("[{\"taskID\":333,\"objectIDs\":[\"1\",\"2\"]}]".data(using: .utf8))
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// saveObjects should report errors
    func testSaveObjectsTest1() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "wrong-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6680"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.saveObjects(
                indexName: "cts_e2e_saveObjects_swift",
                objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]]
            )

            XCTFail("Expected an error to be thrown")
        } catch {
            XCTAssertEqual(
                error.localizedDescription,
                "HTTP error: Status code: 403 Message: Invalid Application-ID or API key"
            )
        }
    }

    /// switch API key
    func testSetClientApiKeyTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6683"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.customGetWithHTTPInfo(path: "check-api-key/1")
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            let comparableData = "{\"headerAPIKeyValue\":\"test-api-key\"}".data(using: .utf8)
            let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
            XCTAssertEqual(comparableJSON, responseBodyJSON)
        }
        do {
            try client.setClientApiKey(apiKey: "updated-api-key")
        }
        do {
            let response = try await client.customGetWithHTTPInfo(path: "check-api-key/2")
            let responseBodyData = try XCTUnwrap(response.bodyData)
            let responseBodyJSON = try XCTUnwrap(responseBodyData.jsonString)

            let comparableData = "{\"headerAPIKeyValue\":\"updated-api-key\"}".data(using: .utf8)
            let comparableJSON = try XCTUnwrap(comparableData?.jsonString)
            XCTAssertEqual(comparableJSON, responseBodyJSON)
        }
    }

    /// wait for api key helper - add
    func testWaitForApiKeyTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.waitForApiKey(
                key: "api-key-add-operation-test-swift",
                operation: ApiKeyOperation.add
            )

            let comparableData =
                try XCTUnwrap(
                    "{\"value\":\"api-key-add-operation-test-swift\",\"description\":\"my new api key\",\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20,\"createdAt\":1720094400}"
                        .data(using: .utf8)
                )
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// wait for api key - update
    func testWaitForApiKeyTest1() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.waitForApiKey(
                key: "api-key-update-operation-test-swift",
                operation: ApiKeyOperation.update,
                apiKey: ApiKey(
                    acl: [Acl.search, Acl.addObject, Acl.deleteObject],
                    description: "my updated api key",
                    indexes: ["Movies", "Books"],
                    maxHitsPerQuery: 20,
                    maxQueriesPerIPPerHour: 95,
                    referers: ["*google.com", "*algolia.com"],
                    validity: 305
                )
            )

            let comparableData =
                try XCTUnwrap(
                    "{\"value\":\"api-key-update-operation-test-swift\",\"description\":\"my updated api key\",\"acl\":[\"search\",\"addObject\",\"deleteObject\"],\"indexes\":[\"Movies\",\"Books\"],\"referers\":[\"*google.com\",\"*algolia.com\"],\"validity\":305,\"maxQueriesPerIPPerHour\":95,\"maxHitsPerQuery\":20,\"createdAt\":1720094400}"
                        .data(using: .utf8)
                )
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// wait for api key - delete
    func testWaitForApiKeyTest2() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.waitForApiKey(
                key: "api-key-delete-operation-test-swift",
                operation: ApiKeyOperation.delete
            )

            XCTAssertNil(response)
        }
    }

    /// wait for an application-level task
    func testWaitForAppTaskTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.waitForAppTask(taskID: Int64(123))

            let comparableData = try XCTUnwrap("{\"status\":\"published\"}".data(using: .utf8))
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }

    /// wait for task
    func testWaitForTaskTest0() async throws {
        let configuration = try SearchClientConfiguration(
            appID: "test-app-id",
            apiKey: "test-api-key",
            hosts: [RetryableHost(url: URL(
                string: "http://" +
                    (ProcessInfo.processInfo.environment["CI"] == "true" ? "localhost" : "host.docker.internal") +
                    ":6681"
            )!)]
        )
        let transporter = Transporter(configuration: configuration)
        let client = SearchClient(configuration: configuration, transporter: transporter)
        do {
            let response = try await client.waitForTask(indexName: "wait-task-swift", taskID: Int64(123))

            let comparableData = try XCTUnwrap("{\"status\":\"published\"}".data(using: .utf8))
            try XCTLenientAssertEqual(received: CodableHelper.jsonEncoder.encode(response), expected: comparableData)
        }
    }
}

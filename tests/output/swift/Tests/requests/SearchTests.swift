import XCTest

import AnyCodable
import DotEnv
import Utils

@testable import Core
@testable import Search

final class SearchClientRequestsTests: XCTestCase {
    static var APPLICATION_ID = "my_application_id"
    static var API_KEY = "my_api_key"
    static var e2eClient: SearchClient?

    override class func setUp() {
        if !(Bool(ProcessInfo.processInfo.environment["CI"] ?? "false") ?? false) {
            do {
                let currentFileURL = try XCTUnwrap(URL(string: #file))

                let packageDirectoryURL = currentFileURL
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()
                    .deletingLastPathComponent()

                let dotEnvURL = packageDirectoryURL
                    .appendingPathComponent(".env")
                dump(dotEnvURL.absoluteString)
                try DotEnv.load(path: dotEnvURL.absoluteString, encoding: .utf8, overwrite: true)
            } catch {
                XCTFail("Unable to load .env file")
            }
        }

        do {
            self.APPLICATION_ID = try XCTUnwrap(ProcessInfo.processInfo.environment["ALGOLIA_APPLICATION_ID"])
        } catch {
            XCTFail("Please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests")
        }

        do {
            self.API_KEY = try XCTUnwrap(ProcessInfo.processInfo.environment["ALGOLIA_ADMIN_KEY"])
        } catch {
            XCTFail("Please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests")
        }

        self.e2eClient = try? SearchClient(appID: self.APPLICATION_ID, apiKey: self.API_KEY)
    }

    /// addApiKey0
    func testAddApiKeyTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.addApiKeyWithHTTPInfo(apiKey: ApiKey(
            acl: [Acl.search, Acl.addObject],
            description: "my new api key",
            maxHitsPerQuery: 20,
            maxQueriesPerIPPerHour: 100,
            validity: 300
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/keys")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// addOrUpdateObject0
    func testAddOrUpdateObjectTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.addOrUpdateObjectWithHTTPInfo(
            indexName: "indexName",
            objectID: "uniqueID",
            body: ["key": "value"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"key\":\"value\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/uniqueID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// appendSource0
    func testAppendSourceTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.appendSourceWithHTTPInfo(source: Source(
            source: "theSource",
            description: "theDescription"
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"source\":\"theSource\",\"description\":\"theDescription\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/security/sources/append")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// assignUserId0
    func testAssignUserIdTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.assignUserIdWithHTTPInfo(
            xAlgoliaUserID: "userID",
            assignUserIdParams: AssignUserIdParams(cluster: "theCluster")
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"cluster\":\"theCluster\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-user-id\":\"userID\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// it should not encode the userID
    func testAssignUserIdTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.assignUserIdWithHTTPInfo(
            xAlgoliaUserID: "user id with spaces",
            assignUserIdParams: AssignUserIdParams(cluster: "cluster with spaces")
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"cluster\":\"cluster with spaces\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-user-id\":\"user id with spaces\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// allows batch method with &#x60;addObject&#x60; action
    func testBatchTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.addObject,
                body: ["key": "value"]
            )])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"}}]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allows batch method with &#x60;clear&#x60; action
    func testBatchTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(action: Action.clear, body: ["key": "value"])])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"action\":\"clear\",\"body\":{\"key\":\"value\"}}]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allows batch method with &#x60;delete&#x60; action
    func testBatchTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(action: Action.delete, body: ["key": "value"])])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"}}]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allows batch method with &#x60;deleteObject&#x60; action
    func testBatchTest3() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.deleteObject,
                body: ["key": "value"]
            )])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"action\":\"deleteObject\",\"body\":{\"key\":\"value\"}}]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allows batch method with &#x60;partialUpdateObject&#x60; action
    func testBatchTest4() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.partialUpdateObject,
                body: ["key": "value"]
            )])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"action\":\"partialUpdateObject\",\"body\":{\"key\":\"value\"}}]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allows batch method with &#x60;partialUpdateObjectNoCreate&#x60; action
    func testBatchTest5() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.partialUpdateObjectNoCreate,
                body: ["key": "value"]
            )])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"action\":\"partialUpdateObjectNoCreate\",\"body\":{\"key\":\"value\"}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allows batch method with &#x60;updateObject&#x60; action
    func testBatchTest6() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchWithHTTPInfo(
            indexName: "theIndexName",
            batchWriteParams: BatchWriteParams(requests: [BatchRequest(
                action: Action.updateObject,
                body: ["key": "value"]
            )])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"action\":\"updateObject\",\"body\":{\"key\":\"value\"}}]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// batchAssignUserIds0
    func testBatchAssignUserIdsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchAssignUserIdsWithHTTPInfo(
            xAlgoliaUserID: "userID",
            batchAssignUserIdsParams: BatchAssignUserIdsParams(cluster: "theCluster", users: ["user1", "user2"])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-user-id\":\"userID\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// get batchDictionaryEntries results with minimal parameters
    func testBatchDictionaryEntriesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchDictionaryEntriesWithHTTPInfo(
            dictionaryName: DictionaryType.compounds,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(requests: [
                BatchDictionaryEntriesRequest(action: DictionaryAction.addEntry, body: DictionaryEntry(
                    objectID: "1",
                    language: SupportedLanguage.en
                )),
                BatchDictionaryEntriesRequest(
                    action: DictionaryAction.deleteEntry,
                    body: DictionaryEntry(objectID: "2", language: SupportedLanguage.fr)
                ),
            ])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/compounds/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get batchDictionaryEntries results with all parameters
    func testBatchDictionaryEntriesTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchDictionaryEntriesWithHTTPInfo(
            dictionaryName: DictionaryType.compounds,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
                clearExistingDictionaryEntries: false,
                requests: [
                    BatchDictionaryEntriesRequest(action: DictionaryAction.addEntry, body: DictionaryEntry(
                        objectID: "1",
                        language: SupportedLanguage.en,
                        word: "fancy",
                        words: ["believe", "algolia"],
                        decomposition: ["trust", "algolia"],
                        state: DictionaryEntryState.enabled
                    )),
                    BatchDictionaryEntriesRequest(
                        action: DictionaryAction.deleteEntry,
                        body: DictionaryEntry(
                            objectID: "2",
                            language: SupportedLanguage.fr,
                            word: "humility",
                            words: ["candor", "algolia"],
                            decomposition: ["grit", "algolia"],
                            state: DictionaryEntryState.enabled
                        )
                    ),
                ]
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"fancy\",\"words\":[\"believe\",\"algolia\"],\"decomposition\":[\"trust\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"humility\",\"words\":[\"candor\",\"algolia\"],\"decomposition\":[\"grit\",\"algolia\"],\"state\":\"enabled\"}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/compounds/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get batchDictionaryEntries results additional properties
    func testBatchDictionaryEntriesTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.batchDictionaryEntriesWithHTTPInfo(
            dictionaryName: DictionaryType.compounds,
            batchDictionaryEntriesParams: BatchDictionaryEntriesParams(requests: [BatchDictionaryEntriesRequest(
                action: DictionaryAction.addEntry,
                body: DictionaryEntry(from: [
                    "objectID": AnyCodable("1"),
                    "language": AnyCodable(SupportedLanguage.en),
                    "additional": AnyCodable("try me"),
                ])
            )])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"additional\":\"try me\"}}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/compounds/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// browse with minimal parameters
    func testBrowseTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.browseWithHTTPInfo(indexName: "cts_e2e_browse")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/cts_e2e_browse/browse")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.browseWithHTTPInfo(indexName: "cts_e2e_browse")
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"page\":0,\"nbHits\":33191,\"nbPages\":34,\"hitsPerPage\":1000,\"query\":\"\",\"params\":\"\"}"
                    .data(using: .utf8)
            )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// browse with search parameters
    func testBrowseTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.browseWithHTTPInfo(
            indexName: "indexName",
            browseParams: BrowseParams.browseParamsObject(BrowseParamsObject(
                query: "myQuery",
                facetFilters: FacetFilters.arrayOfMixedSearchFilters([MixedSearchFilters.string("tags:algolia")])
            ))
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/browse")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// browse allow a cursor in parameters
    func testBrowseTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.browseWithHTTPInfo(
            indexName: "indexName",
            browseParams: BrowseParams.browseParamsObject(BrowseParamsObject(cursor: "test"))
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"cursor\":\"test\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/browse")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// clearObjects0
    func testClearObjectsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.clearObjectsWithHTTPInfo(indexName: "theIndexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/clear")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// clearRules0
    func testClearRulesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.clearRulesWithHTTPInfo(indexName: "indexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/clear")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// clearSynonyms0
    func testClearSynonymsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.clearSynonymsWithHTTPInfo(indexName: "indexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/clear")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow del method for a custom path with minimal parameters
    func testCustomDeleteTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(path: "/test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow del method for a custom path with all parameters
    func testCustomDeleteTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customDeleteWithHTTPInfo(
            path: "/test/all",
            parameters: ["query": AnyCodable("parameters")]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// allow get method for a custom path with minimal parameters
    func testCustomGetTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(path: "/test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow get method for a custom path with all parameters
    func testCustomGetTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customGetWithHTTPInfo(
            path: "/test/all",
            parameters: ["query": AnyCodable("parameters with space")]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters%20with%20space\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions should be escaped too
    func testCustomGetTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: ["x-header-1": "spaces are left alone"],

            queryParameters: ["query": "parameters with space", "and an array": ["array", "with spaces"]]
        )

        let response = try await client.customGetWithHTTPInfo(
            path: "/test/all",
            parameters: ["query": AnyCodable("to be overriden")],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"query\":\"parameters%20with%20space\",\"and%20an%20array\":\"array%2Cwith%20spaces\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        let expectedHeaders = try XCTUnwrap("{\"x-header-1\":\"spaces are left alone\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// allow post method for a custom path with minimal parameters
    func testCustomPostTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(path: "/test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow post method for a custom path with all parameters
    func testCustomPostTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions can override default query parameters
    func testCustomPostTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["query": "myQueryParameter"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"myQueryParameter\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions merges query parameters with default ones
    func testCustomPostTest3() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["query2": "myQueryParameter"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions can override default headers
    func testCustomPostTest4() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: ["x-algolia-api-key": "myApiKey"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-api-key\":\"myApiKey\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// requestOptions merges headers with default ones
    func testCustomPostTest5() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            headers: ["x-algolia-api-key": "myApiKey"]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        let expectedHeaders = try XCTUnwrap("{\"x-algolia-api-key\":\"myApiKey\"}".data(using: .utf8))
        let expectedHeadersMap = try CodableHelper.jsonDecoder.decode([String: String?].self, from: expectedHeaders)

        let echoResponseHeaders = try XCTUnwrap(echoResponse.headers)
        for header in expectedHeadersMap {
            XCTAssertEqual(echoResponseHeaders[header.key.capitalized], header.value)
        }
    }

    /// requestOptions queryParameters accepts booleans
    func testCustomPostTest6() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["isItWorking": true]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"isItWorking\":\"true\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts integers
    func testCustomPostTest7() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": 2]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"2\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts list of string
    func testCustomPostTest8() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": ["b and c", "d"]]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"b%20and%20c%2Cd\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts list of booleans
    func testCustomPostTest9() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": [true, true, false]]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// requestOptions queryParameters accepts list of integers
    func testCustomPostTest10() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let requestOptions = RequestOptions(
            queryParameters: ["myParam": [1, 2]]
        )

        let response = try await client.customPostWithHTTPInfo(
            path: "/test/requestOptions",
            parameters: ["query": AnyCodable("parameters")],
            body: ["facet": "filters"],
            requestOptions: requestOptions
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"facet\":\"filters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/requestOptions")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// allow put method for a custom path with minimal parameters
    func testCustomPutTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(path: "/test/minimal")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/minimal")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// allow put method for a custom path with all parameters
    func testCustomPutTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.customPutWithHTTPInfo(
            path: "/test/all",
            parameters: ["query": AnyCodable("parameters")],
            body: ["body": "parameters"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"body\":\"parameters\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/test/all")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"query\":\"parameters\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// deleteApiKey0
    func testDeleteApiKeyTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteApiKeyWithHTTPInfo(key: "myTestApiKey")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/keys/myTestApiKey")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteBy0
    func testDeleteByTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteByWithHTTPInfo(
            indexName: "theIndexName",
            deleteByParams: DeleteByParams(filters: "brand:brandName")
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"filters\":\"brand:brandName\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/deleteByQuery")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteIndex0
    func testDeleteIndexTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteIndexWithHTTPInfo(indexName: "theIndexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteObject0
    func testDeleteObjectTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteObjectWithHTTPInfo(indexName: "theIndexName", objectID: "uniqueID")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/uniqueID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// delete rule simple case
    func testDeleteRuleTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteRuleWithHTTPInfo(indexName: "indexName", objectID: "id1")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// delete rule with simple characters to encode in objectID
    func testDeleteRuleTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteRuleWithHTTPInfo(indexName: "indexName", objectID: "test/with/slash")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/test%2Fwith%2Fslash")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteSource0
    func testDeleteSourceTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteSourceWithHTTPInfo(source: "theSource")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/security/sources/theSource")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// deleteSynonym0
    func testDeleteSynonymTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.deleteSynonymWithHTTPInfo(indexName: "indexName", objectID: "id1")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getApiKey0
    func testGetApiKeyTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getApiKeyWithHTTPInfo(key: "myTestApiKey")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/keys/myTestApiKey")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get getDictionaryLanguages
    func testGetDictionaryLanguagesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getDictionaryLanguagesWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/*/languages")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get getDictionarySettings results
    func testGetDictionarySettingsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getDictionarySettingsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/*/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getLogs with minimal parameters
    func testGetLogsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getLogsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/logs")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getLogs with parameters
    func testGetLogsTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getLogsWithHTTPInfo(
            offset: 5,
            length: 10,
            indexName: "theIndexName",
            type: LogType.all
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/logs")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"offset\":\"5\",\"length\":\"10\",\"indexName\":\"theIndexName\",\"type\":\"all\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// getObject0
    func testGetObjectTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getObjectWithHTTPInfo(
            indexName: "theIndexName",
            objectID: "uniqueID",
            attributesToRetrieve: ["attr1", "attr2"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/uniqueID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap(
            "{\"attributesToRetrieve\":\"attr1%2Cattr2\"}"
                .data(using: .utf8)
        )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// getObjects0
    func testGetObjectsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .getObjectsWithHTTPInfo(getObjectsParams: GetObjectsParams(requests: [GetObjectsRequest(
                attributesToRetrieve: ["attr1", "attr2"],
                objectID: "uniqueID",
                indexName: "theIndexName"
            )]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/objects")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getRule0
    func testGetRuleTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getRuleWithHTTPInfo(indexName: "indexName", objectID: "id1")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getSettings0
    func testGetSettingsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSettingsWithHTTPInfo(indexName: "cts_e2e_settings")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/cts_e2e_settings/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.getSettingsWithHTTPInfo(indexName: "cts_e2e_settings")
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"minWordSizefor1Typo\":4,\"minWordSizefor2Typos\":8,\"hitsPerPage\":100,\"maxValuesPerFacet\":100,\"paginationLimitedTo\":10,\"exactOnSingleWordQuery\":\"attribute\",\"ranking\":[\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"],\"separatorsToIndex\":\"\",\"removeWordsIfNoResults\":\"none\",\"queryType\":\"prefixLast\",\"highlightPreTag\":\"<em>\",\"highlightPostTag\":\"</em>\",\"alternativesAsExact\":[\"ignorePlurals\",\"singleWordSynonym\"]}"
                    .data(using: .utf8)
            )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// getSources0
    func testGetSourcesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSourcesWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/security/sources")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getSynonym0
    func testGetSynonymTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getSynonymWithHTTPInfo(indexName: "indexName", objectID: "id1")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getTask0
    func testGetTaskTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTaskWithHTTPInfo(indexName: "theIndexName", taskID: Int64(123))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/task/123")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getTopUserIds0
    func testGetTopUserIdsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getTopUserIdsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/top")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// getUserId0
    func testGetUserIdTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.getUserIdWithHTTPInfo(userID: "uniqueID")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/uniqueID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// hasPendingMappings with minimal parameters
    func testHasPendingMappingsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.hasPendingMappingsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/pending")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// hasPendingMappings with parameters
    func testHasPendingMappingsTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.hasPendingMappingsWithHTTPInfo(getClusters: true)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/pending")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"getClusters\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// listApiKeys0
    func testListApiKeysTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.listApiKeysWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/keys")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// listClusters0
    func testListClustersTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.listClustersWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// listIndices with minimal parameters
    func testListIndicesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.listIndicesWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// listIndices with parameters
    func testListIndicesTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.listIndicesWithHTTPInfo(page: 8, hitsPerPage: 3)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/indexes")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"page\":\"8\",\"hitsPerPage\":\"3\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// listUserIds with minimal parameters
    func testListUserIdsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.listUserIdsWithHTTPInfo()
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// listUserIds with parameters
    func testListUserIdsTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.listUserIdsWithHTTPInfo(page: 8, hitsPerPage: 100)
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping")
        XCTAssertEqual(echoResponse.method, HTTPMethod.get)

        let expectedQueryParameters = try XCTUnwrap("{\"page\":\"8\",\"hitsPerPage\":\"100\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// multipleBatch0
    func testMultipleBatchTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .multipleBatchWithHTTPInfo(batchParams: BatchParams(requests: [MultipleBatchRequest(
                action: Action.addObject,
                body: ["key": "value"],
                indexName: "theIndexName"
            )]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// operationIndex0
    func testOperationIndexTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.operationIndexWithHTTPInfo(
            indexName: "theIndexName",
            operationIndexParams: OperationIndexParams(
                operation: OperationType.copy,
                destination: "dest",
                scope: [ScopeType.rules, ScopeType.settings]
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/operation")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// partialUpdateObject0
    func testPartialUpdateObjectTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.partialUpdateObjectWithHTTPInfo(
            indexName: "theIndexName",
            objectID: "uniqueID",
            attributesToUpdate: [
                "id1": AttributeToUpdate.string("test"),
                "id2": AttributeToUpdate
                    .builtInOperation(BuiltInOperation(operation: BuiltInOperationType.addUnique, value: "test2")),
            ],
            createIfNotExists: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/uniqueID/partial")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters = try XCTUnwrap("{\"createIfNotExists\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// removeUserId0
    func testRemoveUserIdTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.removeUserIdWithHTTPInfo(userID: "uniqueID")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        XCTAssertNil(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/uniqueID")
        XCTAssertEqual(echoResponse.method, HTTPMethod.delete)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// replaceSources0
    func testReplaceSourcesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.replaceSourcesWithHTTPInfo(source: [Source(
            source: "theSource",
            description: "theDescription"
        )])
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "[{\"source\":\"theSource\",\"description\":\"theDescription\"}]".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/security/sources")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// restoreApiKey0
    func testRestoreApiKeyTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.restoreApiKeyWithHTTPInfo(key: "myApiKey")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)

        XCTAssertEqual(echoResponseBodyData, "{}".data(using: .utf8))

        XCTAssertEqual(echoResponse.path, "/1/keys/myApiKey/restore")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// saveObject0
    func testSaveObjectTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveObjectWithHTTPInfo(
            indexName: "theIndexName",
            body: ["objectID": "id", "test": "val"]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"objectID\":\"id\",\"test\":\"val\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// saveRule with minimal parameters
    func testSaveRuleTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveRuleWithHTTPInfo(
            indexName: "indexName",
            objectID: "id1",
            rule: Rule(objectID: "id1", conditions: [Condition(pattern: "apple", anchoring: Anchoring.contains)])
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// saveRule with all parameters
    func testSaveRuleTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveRuleWithHTTPInfo(
            indexName: "indexName",
            objectID: "id1",
            rule: Rule(
                objectID: "id1",
                conditions: [Condition(
                    pattern: "apple",
                    anchoring: Anchoring.contains,
                    alternatives: false,
                    context: "search"
                )],
                consequence: Consequence(
                    params: ConsequenceParams(
                        filters: "brand:apple",
                        query: ConsequenceQuery
                            .consequenceQueryObject(ConsequenceQueryObject(
                                remove: ["algolia"],
                                edits: [
                                    Edit(type: EditType.remove, delete: "abc", insert: "cde"),
                                    Edit(type: EditType.replace, delete: "abc", insert: "cde"),
                                ]
                            ))
                    ),
                    promote: [
                        Promote.promoteObjectID(PromoteObjectID(objectID: "abc", position: 3)),
                        Promote.promoteObjectIDs(PromoteObjectIDs(objectIDs: ["abc", "def"], position: 1)),
                    ],
                    filterPromotes: false,
                    hide: [ConsequenceHide(objectID: "321")],
                    userData: ["algolia": "aloglia"]
                ),
                description: "test",
                enabled: true,
                validity: [TimeRange(from: 1_656_670_273, until: 1_656_670_277)]
            ),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\",\"alternatives\":false,\"context\":\"search\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\",\"query\":{\"remove\":[\"algolia\"],\"edits\":[{\"type\":\"remove\",\"delete\":\"abc\",\"insert\":\"cde\"},{\"type\":\"replace\",\"delete\":\"abc\",\"insert\":\"cde\"}]}},\"hide\":[{\"objectID\":\"321\"}],\"filterPromotes\":false,\"userData\":{\"algolia\":\"aloglia\"},\"promote\":[{\"objectID\":\"abc\",\"position\":3},{\"objectIDs\":[\"abc\",\"def\"],\"position\":1}]},\"description\":\"test\",\"enabled\":true,\"validity\":[{\"from\":1656670273,\"until\":1656670277}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// saveRules with minimal parameters
    func testSaveRulesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveRulesWithHTTPInfo(
            indexName: "indexName",
            rules: [
                Rule(
                    objectID: "a-rule-id",
                    conditions: [Condition(pattern: "smartphone", anchoring: Anchoring.contains)]
                ),
                Rule(
                    objectID: "a-second-rule-id",
                    conditions: [Condition(pattern: "apple", anchoring: Anchoring.contains)]
                ),
            ]
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}]},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}]"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// saveRules with all parameters
    func testSaveRulesTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveRulesWithHTTPInfo(
            indexName: "indexName",
            rules: [Rule(
                objectID: "id1",
                conditions: [Condition(
                    pattern: "apple",
                    anchoring: Anchoring.contains,
                    alternatives: false,
                    context: "search"
                )],
                consequence: Consequence(
                    params: ConsequenceParams(
                        filters: "brand:apple",
                        query: ConsequenceQuery
                            .consequenceQueryObject(ConsequenceQueryObject(
                                remove: ["algolia"],
                                edits: [
                                    Edit(type: EditType.remove, delete: "abc", insert: "cde"),
                                    Edit(type: EditType.replace, delete: "abc", insert: "cde"),
                                ]
                            ))
                    ),
                    promote: [
                        Promote.promoteObjectID(PromoteObjectID(objectID: "abc", position: 3)),
                        Promote.promoteObjectIDs(PromoteObjectIDs(objectIDs: ["abc", "def"], position: 1)),
                    ],
                    filterPromotes: false,
                    hide: [ConsequenceHide(objectID: "321")],
                    userData: ["algolia": "aloglia"]
                ),
                description: "test",
                enabled: true,
                validity: [TimeRange(from: 1_656_670_273, until: 1_656_670_277)]
            )],
            forwardToReplicas: true,
            clearExistingRules: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "[{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\",\"alternatives\":false,\"context\":\"search\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\",\"query\":{\"remove\":[\"algolia\"],\"edits\":[{\"type\":\"remove\",\"delete\":\"abc\",\"insert\":\"cde\"},{\"type\":\"replace\",\"delete\":\"abc\",\"insert\":\"cde\"}]}},\"hide\":[{\"objectID\":\"321\"}],\"filterPromotes\":false,\"userData\":{\"algolia\":\"aloglia\"},\"promote\":[{\"objectID\":\"abc\",\"position\":3},{\"objectIDs\":[\"abc\",\"def\"],\"position\":1}]},\"description\":\"test\",\"enabled\":true,\"validity\":[{\"from\":1656670273,\"until\":1656670277}]}]"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters =
            try XCTUnwrap("{\"forwardToReplicas\":\"true\",\"clearExistingRules\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// saveSynonym0
    func testSaveSynonymTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveSynonymWithHTTPInfo(
            indexName: "indexName",
            objectID: "id1",
            synonymHit: SynonymHit(objectID: "id1", type: SynonymType.synonym, synonyms: ["car", "vehicule", "auto"]),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/id1")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// saveSynonyms0
    func testSaveSynonymsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.saveSynonymsWithHTTPInfo(
            indexName: "indexName",
            synonymHit: [
                SynonymHit(objectID: "id1", type: SynonymType.synonym, synonyms: ["car", "vehicule", "auto"]),
                SynonymHit(
                    objectID: "id2",
                    type: SynonymType.onewaysynonym,
                    synonyms: ["ephone", "aphone", "yphone"],
                    input: "iphone"
                ),
            ],
            forwardToReplicas: true,
            replaceExistingSynonyms: false
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}]"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/batch")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        let expectedQueryParameters =
            try XCTUnwrap(
                "{\"forwardToReplicas\":\"true\",\"replaceExistingSynonyms\":\"false\"}"
                    .data(using: .utf8)
            )
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// search for a single hits request with minimal parameters
    func testSearchTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .searchWithHTTPInfo(searchMethodParams: SearchMethodParams(requests: [
                SearchQuery
                    .searchForHits(SearchForHits(indexName: "cts_e2e_search_empty_index")),
            ]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"requests\":[{\"indexName\":\"cts_e2e_search_empty_index\"}]}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient
            .searchWithHTTPInfo(searchMethodParams: SearchMethodParams(requests: [
                SearchQuery
                    .searchForHits(SearchForHits(indexName: "cts_e2e_search_empty_index")),
            ]))
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"results\":[{\"hits\":[],\"page\":0,\"nbHits\":0,\"nbPages\":0,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"\",\"params\":\"\",\"index\":\"cts_e2e_search_empty_index\",\"renderingContent\":{}}]}"
                    .data(using: .utf8)
            )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// search for a single facet request with minimal parameters
    func testSearchTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchWithHTTPInfo(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                facet: "editor",
                indexName: "cts_e2e_search_facet",
                type: SearchTypeFacet.facet
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"cts_e2e_search_facet\",\"type\":\"facet\",\"facet\":\"editor\"}],\"strategy\":\"stopIfEnoughMatches\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.searchWithHTTPInfo(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                facet: "editor",
                indexName: "cts_e2e_search_facet",
                type: SearchTypeFacet.facet
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"results\":[{\"exhaustiveFacetsCount\":true,\"facetHits\":[{\"count\":1,\"highlighted\":\"goland\",\"value\":\"goland\"},{\"count\":1,\"highlighted\":\"neovim\",\"value\":\"neovim\"},{\"count\":1,\"highlighted\":\"vscode\",\"value\":\"vscode\"}]}]}"
                    .data(using: .utf8)
            )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// search for a single hits request with all parameters
    func testSearchTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .searchWithHTTPInfo(searchMethodParams: SearchMethodParams(requests: [
                SearchQuery
                    .searchForHits(SearchForHits(
                        query: "myQuery",
                        hitsPerPage: 50,
                        indexName: "theIndexName",
                        type: SearchTypeDefault.`default`
                    )),
            ]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"myQuery\",\"hitsPerPage\":50,\"type\":\"default\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search for a single facet request with all parameters
    func testSearchTest3() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchWithHTTPInfo(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                query: "theQuery",
                maxFacetHits: 50,
                facet: "theFacet",
                indexName: "theIndexName",
                facetQuery: "theFacetQuery",
                type: SearchTypeFacet.facet
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"theIndexName\",\"type\":\"facet\",\"facet\":\"theFacet\",\"facetQuery\":\"theFacetQuery\",\"query\":\"theQuery\",\"maxFacetHits\":50}],\"strategy\":\"stopIfEnoughMatches\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search for multiple mixed requests in multiple indices with minimal parameters
    func testSearchTest4() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchWithHTTPInfo(searchMethodParams: SearchMethodParams(
            requests: [
                SearchQuery.searchForHits(SearchForHits(indexName: "theIndexName")),
                SearchQuery
                    .searchForFacets(SearchForFacets(
                        facet: "theFacet",
                        indexName: "theIndexName2",
                        type: SearchTypeFacet.facet
                    )),
                SearchQuery.searchForHits(SearchForHits(indexName: "theIndexName", type: SearchTypeDefault.`default`)),
            ],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"theIndexName\"},{\"indexName\":\"theIndexName2\",\"type\":\"facet\",\"facet\":\"theFacet\"},{\"indexName\":\"theIndexName\",\"type\":\"default\"}],\"strategy\":\"stopIfEnoughMatches\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search for multiple mixed requests in multiple indices with all parameters
    func testSearchTest5() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchWithHTTPInfo(searchMethodParams: SearchMethodParams(
            requests: [SearchQuery.searchForFacets(SearchForFacets(
                query: "theQuery",
                maxFacetHits: 50,
                facet: "theFacet",
                indexName: "theIndexName",
                facetQuery: "theFacetQuery",
                type: SearchTypeFacet.facet
            )), SearchQuery.searchForHits(SearchForHits(
                query: "myQuery",
                hitsPerPage: 50,
                indexName: "theIndexName",
                type: SearchTypeDefault.`default`
            ))],
            strategy: SearchStrategy.stopIfEnoughMatches
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"theIndexName\",\"type\":\"facet\",\"facet\":\"theFacet\",\"facetQuery\":\"theFacetQuery\",\"query\":\"theQuery\",\"maxFacetHits\":50},{\"indexName\":\"theIndexName\",\"query\":\"myQuery\",\"hitsPerPage\":50,\"type\":\"default\"}],\"strategy\":\"stopIfEnoughMatches\"}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search filters accept all of the possible shapes
    func testSearchTest6() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchWithHTTPInfo(searchMethodParams: SearchMethodParams(requests: [
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: FacetFilters.string("mySearch:filters"),
                optionalFilters: OptionalFilters.string("mySearch:filters"),
                numericFilters: NumericFilters.string("mySearch:filters"),
                tagFilters: TagFilters.string("mySearch:filters"),
                reRankingApplyFilter: ReRankingApplyFilter.string("mySearch:filters"),
                indexName: "theIndexName"
            )),
            SearchQuery.searchForHits(SearchForHits(
                facetFilters: FacetFilters.arrayOfMixedSearchFilters([
                    MixedSearchFilters.string("mySearch:filters"),
                    MixedSearchFilters.arrayOfString(["mySearch:filters"]),
                ]),
                optionalFilters: OptionalFilters.arrayOfMixedSearchFilters([
                    MixedSearchFilters.string("mySearch:filters"),
                    MixedSearchFilters.arrayOfString(["mySearch:filters"]),
                ]),
                numericFilters: NumericFilters.arrayOfMixedSearchFilters([
                    MixedSearchFilters.string("mySearch:filters"),
                    MixedSearchFilters.arrayOfString(["mySearch:filters"]),
                ]),
                tagFilters: TagFilters.arrayOfMixedSearchFilters([
                    MixedSearchFilters.string("mySearch:filters"),
                    MixedSearchFilters.arrayOfString(["mySearch:filters"]),
                ]),
                reRankingApplyFilter: ReRankingApplyFilter.arrayOfMixedSearchFilters([
                    MixedSearchFilters.string("mySearch:filters"),
                    MixedSearchFilters.arrayOfString(["mySearch:filters"]),
                ]),
                indexName: "theIndexName"
            )),
        ]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"indexName\":\"theIndexName\",\"facetFilters\":\"mySearch:filters\",\"reRankingApplyFilter\":\"mySearch:filters\",\"tagFilters\":\"mySearch:filters\",\"numericFilters\":\"mySearch:filters\",\"optionalFilters\":\"mySearch:filters\"},{\"indexName\":\"theIndexName\",\"facetFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"reRankingApplyFilter\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"tagFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"numericFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"optionalFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]]}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search with all search parameters
    func testSearchTest7() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .searchWithHTTPInfo(searchMethodParams: SearchMethodParams(requests: [
                SearchQuery
                    .searchForHits(SearchForHits(
                        query: "",
                        similarQuery: "",
                        filters: "",
                        facetFilters: FacetFilters.arrayOfMixedSearchFilters([MixedSearchFilters.string("")]),
                        optionalFilters: OptionalFilters.arrayOfMixedSearchFilters([MixedSearchFilters.string("")]),
                        numericFilters: NumericFilters.arrayOfMixedSearchFilters([MixedSearchFilters.string("")]),
                        tagFilters: TagFilters.arrayOfMixedSearchFilters([MixedSearchFilters.string("")]),
                        sumOrFiltersScores: true,
                        restrictSearchableAttributes: [""],
                        facets: [""],
                        facetingAfterDistinct: true,
                        page: 0,
                        offset: 0,
                        length: 1,
                        aroundLatLng: "",
                        aroundLatLngViaIP: true,
                        aroundRadius: AroundRadius.aroundRadiusAll(AroundRadiusAll.all),
                        aroundPrecision: AroundPrecision.int(0),
                        minimumAroundRadius: 1,
                        insideBoundingBox: [[47.3165, 4.9665, 47.3424, 5.0201], [40.9234, 2.1185, 38.643, 1.9916]],
                        insidePolygon: [
                            [47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9],
                            [40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104],
                        ],
                        naturalLanguages: [""],
                        ruleContexts: [""],
                        personalizationImpact: 0,
                        userToken: "",
                        getRankingInfo: true,
                        synonyms: true,
                        clickAnalytics: true,
                        analytics: true,
                        analyticsTags: [""],
                        percentileComputation: true,
                        enableABTest: true,
                        attributesToRetrieve: [""],
                        ranking: [""],
                        customRanking: [""],
                        relevancyStrictness: 0,
                        attributesToHighlight: [""],
                        attributesToSnippet: [""],
                        highlightPreTag: "",
                        highlightPostTag: "",
                        snippetEllipsisText: "",
                        restrictHighlightAndSnippetArrays: true,
                        hitsPerPage: 1,
                        minWordSizefor1Typo: 0,
                        minWordSizefor2Typos: 0,
                        typoTolerance: TypoTolerance.typoToleranceEnum(TypoToleranceEnum.min),
                        allowTyposOnNumericTokens: true,
                        disableTypoToleranceOnAttributes: [""],
                        ignorePlurals: IgnorePlurals.bool(false),
                        removeStopWords: RemoveStopWords.bool(true),
                        keepDiacriticsOnCharacters: "",
                        queryLanguages: [SupportedLanguage.fr],
                        decompoundQuery: true,
                        enableRules: true,
                        enablePersonalization: true,
                        queryType: QueryType.prefixAll,
                        removeWordsIfNoResults: RemoveWordsIfNoResults.allOptional,
                        advancedSyntax: true,
                        optionalWords: [""],
                        disableExactOnAttributes: [""],
                        exactOnSingleWordQuery: ExactOnSingleWordQuery.attribute,
                        alternativesAsExact: [AlternativesAsExact.multiWordsSynonym],
                        advancedSyntaxFeatures: [AdvancedSyntaxFeatures.exactPhrase],
                        distinct: Distinct.int(0),
                        replaceSynonymsInHighlight: true,
                        minProximity: 1,
                        responseFields: [""],
                        maxValuesPerFacet: 0,
                        sortFacetValuesBy: "",
                        attributeCriteriaComputedByMinProximity: true,
                        renderingContent: RenderingContent(facetOrdering: FacetOrdering(
                            facets: Facets(order: ["a", "b"]),
                            values: ["a": Value(order: ["b"], sortRemainingBy: SortRemainingBy.count)]
                        )),
                        enableReRanking: true,
                        reRankingApplyFilter: ReRankingApplyFilter
                            .arrayOfMixedSearchFilters([MixedSearchFilters.string("")]),
                        indexName: "theIndexName",
                        type: SearchTypeDefault.`default`
                    )),
            ]))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"requests\":[{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"multiWordsSynonym\"],\"analytics\":true,\"analyticsTags\":[\"\"],\"aroundLatLng\":\"\",\"aroundLatLngViaIP\":true,\"aroundPrecision\":0,\"aroundRadius\":\"all\",\"attributeCriteriaComputedByMinProximity\":true,\"attributesToHighlight\":[\"\"],\"attributesToRetrieve\":[\"\"],\"attributesToSnippet\":[\"\"],\"clickAnalytics\":true,\"customRanking\":[\"\"],\"decompoundQuery\":true,\"disableExactOnAttributes\":[\"\"],\"disableTypoToleranceOnAttributes\":[\"\"],\"distinct\":0,\"enableABTest\":true,\"enablePersonalization\":true,\"enableReRanking\":true,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"facetFilters\":[\"\"],\"facetingAfterDistinct\":true,\"facets\":[\"\"],\"filters\":\"\",\"getRankingInfo\":true,\"highlightPostTag\":\"\",\"highlightPreTag\":\"\",\"hitsPerPage\":1,\"ignorePlurals\":false,\"indexName\":\"theIndexName\",\"insideBoundingBox\":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],\"insidePolygon\":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],\"keepDiacriticsOnCharacters\":\"\",\"length\":1,\"maxValuesPerFacet\":0,\"minProximity\":1,\"minWordSizefor1Typo\":0,\"minWordSizefor2Typos\":0,\"minimumAroundRadius\":1,\"naturalLanguages\":[\"\"],\"numericFilters\":[\"\"],\"offset\":0,\"optionalFilters\":[\"\"],\"optionalWords\":[\"\"],\"page\":0,\"percentileComputation\":true,\"personalizationImpact\":0,\"query\":\"\",\"queryLanguages\":[\"fr\"],\"queryType\":\"prefixAll\",\"ranking\":[\"\"],\"reRankingApplyFilter\":[\"\"],\"relevancyStrictness\":0,\"removeStopWords\":true,\"removeWordsIfNoResults\":\"allOptional\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"responseFields\":[\"\"],\"restrictHighlightAndSnippetArrays\":true,\"restrictSearchableAttributes\":[\"\"],\"ruleContexts\":[\"\"],\"similarQuery\":\"\",\"snippetEllipsisText\":\"\",\"sortFacetValuesBy\":\"\",\"sumOrFiltersScores\":true,\"synonyms\":true,\"tagFilters\":[\"\"],\"type\":\"default\",\"typoTolerance\":\"min\",\"userToken\":\"\"}]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/*/queries")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get searchDictionaryEntries results with minimal parameters
    func testSearchDictionaryEntriesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchDictionaryEntriesWithHTTPInfo(
            dictionaryName: DictionaryType.stopwords,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(query: "about")
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"about\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/stopwords/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.searchDictionaryEntriesWithHTTPInfo(
            dictionaryName: DictionaryType.stopwords,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(query: "about")
        )
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"hits\":[{\"objectID\":\"86ef58032f47d976ca7130a896086783\",\"language\":\"en\",\"word\":\"about\"}],\"page\":0,\"nbHits\":1,\"nbPages\":1}"
                    .data(using: .utf8)
            )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// get searchDictionaryEntries results with all parameters
    func testSearchDictionaryEntriesTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchDictionaryEntriesWithHTTPInfo(
            dictionaryName: DictionaryType.compounds,
            searchDictionaryEntriesParams: SearchDictionaryEntriesParams(
                query: "foo",
                page: 4,
                hitsPerPage: 2,
                language: SupportedLanguage.fr
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/compounds/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get searchForFacetValues results with minimal parameters
    func testSearchForFacetValuesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchForFacetValuesWithHTTPInfo(indexName: "indexName", facetName: "facetName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/facets/facetName/query")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get searchForFacetValues results with all parameters
    func testSearchForFacetValuesTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchForFacetValuesWithHTTPInfo(
            indexName: "indexName",
            facetName: "facetName",
            searchForFacetValuesRequest: SearchForFacetValuesRequest(
                params: "query=foo&facetFilters=['bar']",
                facetQuery: "foo",
                maxFacetHits: 42
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/facets/facetName/query")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchRules0
    func testSearchRulesTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchRulesWithHTTPInfo(
            indexName: "indexName",
            searchRulesParams: SearchRulesParams(query: "something")
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"something\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/rules/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search with minimal parameters
    func testSearchSingleIndexTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSingleIndexWithHTTPInfo(indexName: "indexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/query")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// search with special characters in indexName
    func testSearchSingleIndexTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSingleIndexWithHTTPInfo(indexName: "cts_e2e_space in index")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/cts_e2e_space%20in%20index/query")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.searchSingleIndexWithHTTPInfo(indexName: "cts_e2e_space in index")

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// search with searchParams
    func testSearchSingleIndexTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSingleIndexWithHTTPInfo(
            indexName: "indexName",
            searchParams: SearchParams.searchParamsObject(SearchParamsObject(
                query: "myQuery",
                facetFilters: FacetFilters.arrayOfMixedSearchFilters([MixedSearchFilters.string("tags:algolia")])
            ))
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/query")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// single search retrieve snippets
    func testSearchSingleIndexTest3() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSingleIndexWithHTTPInfo(
            indexName: "cts_e2e_browse",
            searchParams: SearchParams.searchParamsObject(SearchParamsObject(
                query: "batman mask of the phantasm",
                attributesToRetrieve: ["*"],
                attributesToSnippet: ["*:20"]
            ))
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"query\":\"batman mask of the phantasm\",\"attributesToRetrieve\":[\"*\"],\"attributesToSnippet\":[\"*:20\"]}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/cts_e2e_browse/query")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.searchSingleIndexWithHTTPInfo(
            indexName: "cts_e2e_browse",
            searchParams: SearchParams.searchParamsObject(SearchParamsObject(
                query: "batman mask of the phantasm",
                attributesToRetrieve: ["*"],
                attributesToSnippet: ["*:20"]
            ))
        )
        let e2eResponseBody = try XCTUnwrap(e2eResponse.body)
        let e2eResponseBodyData = try CodableHelper.jsonEncoder.encode(e2eResponseBody)

        let e2eExpectedBodyData =
            try XCTUnwrap(
                "{\"nbHits\":1,\"hits\":[{\"_snippetResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\"},{\"value\":\"Superhero\",\"matchLevel\":\"none\"},{\"value\":\"Romance\",\"matchLevel\":\"none\"}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\"}},\"_highlightResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Superhero\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Romance\",\"matchLevel\":\"none\",\"matchedWords\":[]}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\",\"matchedWords\":[]}}}]}"
                    .data(using: .utf8)
            )

        XCTLenientAssertEqual(received: e2eResponseBodyData, expected: e2eExpectedBodyData)

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// searchSynonyms with minimal parameters
    func testSearchSynonymsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSynonymsWithHTTPInfo(indexName: "indexName")
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchSynonyms with all parameters
    func testSearchSynonymsTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchSynonymsWithHTTPInfo(
            indexName: "indexName",
            searchSynonymsParams: SearchSynonymsParams(
                query: "myQuery",
                type: SynonymType.altcorrection1,
                page: 10,
                hitsPerPage: 10
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"myQuery\",\"type\":\"altcorrection1\",\"page\":10,\"hitsPerPage\":10}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/indexName/synonyms/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// searchUserIds0
    func testSearchUserIdsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.searchUserIdsWithHTTPInfo(searchUserIdsParams: SearchUserIdsParams(
            query: "test",
            clusterName: "theClusterName",
            page: 5,
            hitsPerPage: 10
        ))
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/clusters/mapping/search")
        XCTAssertEqual(echoResponse.method, HTTPMethod.post)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get setDictionarySettings results with minimal parameters
    func testSetDictionarySettingsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .setDictionarySettingsWithHTTPInfo(
                dictionarySettingsParams: DictionarySettingsParams(disableStandardEntries: StandardEntries(plurals: [
                    "fr": false,
                    "en": false,
                    "ru": true,
                ]))
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}"
            .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/*/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// get setDictionarySettings results with all parameters
    func testSetDictionarySettingsTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client
            .setDictionarySettingsWithHTTPInfo(
                dictionarySettingsParams: DictionarySettingsParams(disableStandardEntries: StandardEntries(
                    plurals: ["fr": false, "en": false, "ru": true],
                    stopwords: ["fr": false],
                    compounds: ["ru": true]
                ))
            )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/dictionaries/*/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// setSettings with minimal parameters
    func testSetSettingsTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "cts_e2e_settings",
            indexSettings: IndexSettings(paginationLimitedTo: 10),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"paginationLimitedTo\":10}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/cts_e2e_settings/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)

        guard let e2eClient = SearchClientRequestsTests.e2eClient else {
            XCTFail("E2E client is not initialized")
            return
        }

        let e2eResponse = try await e2eClient.setSettingsWithHTTPInfo(
            indexName: "cts_e2e_settings",
            indexSettings: IndexSettings(paginationLimitedTo: 10),
            forwardToReplicas: true
        )

        XCTAssertEqual(e2eResponse.statusCode, 200)
    }

    /// setSettings allow boolean &#x60;typoTolerance&#x60;
    func testSetSettingsTest1() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(typoTolerance: TypoTolerance.bool(true)),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"typoTolerance\":true}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow enum &#x60;typoTolerance&#x60;
    func testSetSettingsTest2() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(typoTolerance: TypoTolerance.typoToleranceEnum(TypoToleranceEnum.min)),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"typoTolerance\":\"min\"}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow boolean &#x60;ignorePlurals&#x60;
    func testSetSettingsTest3() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(ignorePlurals: IgnorePlurals.bool(true)),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"ignorePlurals\":true}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow list of string &#x60;ignorePlurals&#x60;
    func testSetSettingsTest4() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(ignorePlurals: IgnorePlurals.arrayOfSupportedLanguage([SupportedLanguage.fr])),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"ignorePlurals\":[\"fr\"]}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow boolean &#x60;removeStopWords&#x60;
    func testSetSettingsTest5() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(removeStopWords: RemoveStopWords.bool(true)),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"removeStopWords\":true}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow list of string &#x60;removeStopWords&#x60;
    func testSetSettingsTest6() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(
                removeStopWords: RemoveStopWords
                    .arrayOfSupportedLanguage([SupportedLanguage.fr])
            ),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"removeStopWords\":[\"fr\"]}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow boolean &#x60;distinct&#x60;
    func testSetSettingsTest7() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(distinct: Distinct.bool(true)),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"distinct\":true}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow integers for &#x60;distinct&#x60;
    func testSetSettingsTest8() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(distinct: Distinct.int(1)),
            forwardToReplicas: true
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData = "{\"distinct\":1}".data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        let expectedQueryParameters = try XCTUnwrap("{\"forwardToReplicas\":\"true\"}".data(using: .utf8))
        let expectedQueryParametersMap = try CodableHelper.jsonDecoder.decode(
            [String: String?].self,
            from: expectedQueryParameters
        )

        XCTAssertEqual(echoResponse.queryParameters, expectedQueryParametersMap)
    }

    /// setSettings allow all &#x60;indexSettings&#x60;
    func testSetSettingsTest9() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.setSettingsWithHTTPInfo(
            indexName: "theIndexName",
            indexSettings: IndexSettings(
                attributesForFaceting: ["algolia"],
                replicas: [""],
                paginationLimitedTo: 0,
                unretrievableAttributes: ["foo"],
                disableTypoToleranceOnWords: ["algolia"],
                attributesToTransliterate: ["algolia"],
                camelCaseAttributes: ["algolia"],
                decompoundedAttributes: ["algolia": "aloglia"],
                indexLanguages: [SupportedLanguage.fr],
                disablePrefixOnAttributes: ["algolia"],
                allowCompressionOfIntegerArray: true,
                numericAttributesForFiltering: ["algolia"],
                separatorsToIndex: "bar",
                searchableAttributes: ["foo"],
                userData: ["user": "data"],
                customNormalization: ["algolia": ["aloglia": "aglolia"]],
                attributeForDistinct: "test",
                attributesToRetrieve: ["algolia"],
                ranking: ["geo"],
                customRanking: ["algolia"],
                relevancyStrictness: 10,
                attributesToHighlight: ["algolia"],
                attributesToSnippet: ["algolia"],
                highlightPreTag: "<span>",
                highlightPostTag: "</span>",
                snippetEllipsisText: "---",
                restrictHighlightAndSnippetArrays: true,
                hitsPerPage: 10,
                minWordSizefor1Typo: 5,
                minWordSizefor2Typos: 11,
                typoTolerance: TypoTolerance.bool(false),
                allowTyposOnNumericTokens: true,
                disableTypoToleranceOnAttributes: ["algolia"],
                ignorePlurals: IgnorePlurals.bool(false),
                removeStopWords: RemoveStopWords.bool(false),
                keepDiacriticsOnCharacters: "abc",
                queryLanguages: [SupportedLanguage.fr],
                decompoundQuery: false,
                enableRules: true,
                enablePersonalization: true,
                queryType: QueryType.prefixLast,
                removeWordsIfNoResults: RemoveWordsIfNoResults.lastWords,
                mode: Mode.neuralSearch,
                semanticSearch: SemanticSearch(eventSources: ["foo"]),
                advancedSyntax: true,
                optionalWords: ["myspace"],
                disableExactOnAttributes: ["algolia"],
                exactOnSingleWordQuery: ExactOnSingleWordQuery.attribute,
                alternativesAsExact: [AlternativesAsExact.singleWordSynonym],
                advancedSyntaxFeatures: [AdvancedSyntaxFeatures.exactPhrase],
                distinct: Distinct.int(3),
                replaceSynonymsInHighlight: true,
                minProximity: 6,
                responseFields: ["algolia"],
                maxFacetHits: 20,
                maxValuesPerFacet: 30,
                sortFacetValuesBy: "date",
                attributeCriteriaComputedByMinProximity: true,
                renderingContent: RenderingContent(facetOrdering: FacetOrdering(
                    facets: Facets(order: ["a", "b"]),
                    values: ["a": Value(order: ["b"], sortRemainingBy: SortRemainingBy.count)]
                )),
                enableReRanking: false,
                reRankingApplyFilter: ReRankingApplyFilter.string("mySearch:filters")
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowCompressionOfIntegerArray\":true,\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"singleWordSynonym\"],\"attributeCriteriaComputedByMinProximity\":true,\"attributeForDistinct\":\"test\",\"attributesForFaceting\":[\"algolia\"],\"attributesToHighlight\":[\"algolia\"],\"attributesToRetrieve\":[\"algolia\"],\"attributesToSnippet\":[\"algolia\"],\"attributesToTransliterate\":[\"algolia\"],\"camelCaseAttributes\":[\"algolia\"],\"customNormalization\":{\"algolia\":{\"aloglia\":\"aglolia\"}},\"customRanking\":[\"algolia\"],\"decompoundQuery\":false,\"decompoundedAttributes\":{\"algolia\":\"aloglia\"},\"disableExactOnAttributes\":[\"algolia\"],\"disablePrefixOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnWords\":[\"algolia\"],\"distinct\":3,\"enablePersonalization\":true,\"enableReRanking\":false,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"highlightPreTag\":\"<span>\",\"highlightPostTag\":\"</span>\",\"hitsPerPage\":10,\"ignorePlurals\":false,\"indexLanguages\":[\"fr\"],\"keepDiacriticsOnCharacters\":\"abc\",\"maxFacetHits\":20,\"maxValuesPerFacet\":30,\"minProximity\":6,\"minWordSizefor1Typo\":5,\"minWordSizefor2Typos\":11,\"mode\":\"neuralSearch\",\"numericAttributesForFiltering\":[\"algolia\"],\"optionalWords\":[\"myspace\"],\"paginationLimitedTo\":0,\"queryLanguages\":[\"fr\"],\"queryType\":\"prefixLast\",\"ranking\":[\"geo\"],\"reRankingApplyFilter\":\"mySearch:filters\",\"relevancyStrictness\":10,\"removeStopWords\":false,\"removeWordsIfNoResults\":\"lastWords\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"replicas\":[\"\"],\"responseFields\":[\"algolia\"],\"restrictHighlightAndSnippetArrays\":true,\"searchableAttributes\":[\"foo\"],\"semanticSearch\":{\"eventSources\":[\"foo\"]},\"separatorsToIndex\":\"bar\",\"snippetEllipsisText\":\"---\",\"sortFacetValuesBy\":\"date\",\"typoTolerance\":false,\"unretrievableAttributes\":[\"foo\"],\"userData\":{\"user\":\"data\"}}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/indexes/theIndexName/settings")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }

    /// updateApiKey0
    func testUpdateApiKeyTest0() async throws {
        let configuration: Search.Configuration = try Search.Configuration(
            appID: SearchClientRequestsTests.APPLICATION_ID,
            apiKey: SearchClientRequestsTests.API_KEY
        )
        let transporter = Transporter(configuration: configuration, requestBuilder: EchoRequestBuilder())
        let client = SearchClient(configuration: configuration, transporter: transporter)

        let response = try await client.updateApiKeyWithHTTPInfo(
            key: "myApiKey",
            apiKey: ApiKey(
                acl: [Acl.search, Acl.addObject],
                maxHitsPerQuery: 20,
                maxQueriesPerIPPerHour: 100,
                validity: 300
            )
        )
        let responseBodyData = try XCTUnwrap(response.bodyData)
        let echoResponse = try CodableHelper.jsonDecoder.decode(EchoResponse.self, from: responseBodyData)

        let echoResponseBodyData = try XCTUnwrap(echoResponse.originalBodyData)
        let echoResponseBodyJSON = try XCTUnwrap(echoResponseBodyData.jsonString)

        let expectedBodyData =
            "{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}"
                .data(using: .utf8)
        let expectedBodyJSON = try XCTUnwrap(expectedBodyData?.jsonString)

        XCTAssertEqual(echoResponseBodyJSON, expectedBodyJSON)

        XCTAssertEqual(echoResponse.path, "/1/keys/myApiKey")
        XCTAssertEqual(echoResponse.method, HTTPMethod.put)

        XCTAssertNil(echoResponse.queryParameters)
    }
}

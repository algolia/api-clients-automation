//
//  TransformationOptionsTests.swift
//  AlgoliaSearchClientTests
//
//  Created by Algolia on 26/05/2026.
//

import XCTest

@testable import AlgoliaCore
@testable import AlgoliaIngestion
@testable import AlgoliaSearch

final class TransformationOptionsTests: XCTestCase {
    private let appID = "APP_ID"
    private let apiKey = "API_KEY"

    func testInitStoresRegionAndConfiguration() throws {
        let configuration = try IngestionClientConfiguration(appID: self.appID, apiKey: self.apiKey, region: .us)
        let options = try TransformationOptions(region: .us, configuration: configuration)
        XCTAssertEqual(options.region.rawValue, "us")
        XCTAssertEqual(options.configuration?.appID, self.appID)
    }

    func testInitRejectsEmptyRegion() {
        XCTAssertThrowsError(try TransformationOptions(region: Region(rawValue: ""))) { error in
            guard case let AlgoliaError.runtimeError(message) = error else {
                XCTFail("expected AlgoliaError.runtimeError, got \(error)")
                return
            }
            XCTAssertTrue(message.contains("transformationOptions"), "error message should mention transformationOptions, got: \(message)")
        }
    }

    func testInitDefaultsConfigurationToNil() throws {
        let options = try TransformationOptions(region: .eu)
        XCTAssertNil(options.configuration)
    }

    func testWithTransformationFactorySetsIngestionTransporter() async throws {
        let options = try TransformationOptions(region: .us)
        let client = try SearchClient.withTransformation(
            appID: self.appID,
            apiKey: self.apiKey,
            transformationOptions: options
        )
        XCTAssertNotNil(client.ingestionTransporter)
    }

    func testSetTransformationOptionsOnUnconfiguredClient() async throws {
        let client = try SearchClient(appID: self.appID, apiKey: self.apiKey)
        XCTAssertNil(client.ingestionTransporter)
        try client.setTransformationOptions(TransformationOptions(region: .us))
        XCTAssertNotNil(client.ingestionTransporter)
    }

    func testSetTransformationOptionsReplacesPreviousTransporter() async throws {
        let client = try SearchClient(appID: self.appID, apiKey: self.apiKey)
        try client.setTransformationOptions(TransformationOptions(region: .us))
        let firstTransporter = client.ingestionTransporter
        try client.setTransformationOptions(TransformationOptions(region: .eu))
        let secondTransporter = client.ingestionTransporter
        XCTAssertNotNil(firstTransporter)
        XCTAssertNotNil(secondTransporter)
        XCTAssertFalse(firstTransporter === secondTransporter, "setTransformationOptions should replace the previous ingestion client")
    }

    func testSaveObjectsWithTransformationFailsWhenTransporterMissing() async throws {
        let client = try SearchClient(appID: self.appID, apiKey: self.apiKey)
        do {
            _ = try await client.saveObjectsWithTransformation(indexName: "idx", objects: [["objectID": "1"]])
            XCTFail("expected an error when ingestion transporter is missing")
        } catch let AlgoliaError.runtimeError(message) {
            XCTAssertTrue(message.contains("transformationOptions"), "error message should mention transformationOptions, got: \(message)")
        }
    }

    func testCustomConfigurationOverridesParentSearchClient() async throws {
        let searchConfiguration = try SearchClientConfiguration(
            appID: self.appID,
            apiKey: self.apiKey,
            writeTimeout: 99,
            readTimeout: 99,
            hosts: [RetryableHost(url: URL(string: "http://search.example.com")!)]
        )
        let client = SearchClient(configuration: searchConfiguration)

        let customHosts = [RetryableHost(url: URL(string: "http://ingestion.example.com")!)]
        let ingestionConfiguration = try IngestionClientConfiguration(
            appID: self.appID,
            apiKey: self.apiKey,
            region: .us,
            writeTimeout: 7,
            readTimeout: 11,
            hosts: customHosts
        )
        try client.setTransformationOptions(TransformationOptions(region: .us, configuration: ingestionConfiguration))

        let transporter = try XCTUnwrap(client.ingestionTransporter)
        XCTAssertEqual(transporter.configuration.readTimeout, 11)
        XCTAssertEqual(transporter.configuration.writeTimeout, 7)
        XCTAssertEqual(transporter.configuration.hosts.first?.url.host, "ingestion.example.com")
        // Parent search-client values must not leak through:
        XCTAssertNotEqual(transporter.configuration.readTimeout, client.configuration.readTimeout)
        XCTAssertNotEqual(transporter.configuration.writeTimeout, client.configuration.writeTimeout)
    }
}

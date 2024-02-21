//
//  Browsers.swift
//
//
//  Created by Algolia on 21/02/2024.
//

import Foundation
#if canImport(FoundationNetworking)
    import FoundationNetworking
#endif

import XCTest
@testable import Core
@testable import Search
@testable import Utils

class BrowserTests: XCTestCase {
    func testBrowseObjectsSuccess() async throws {
        let indexName = "yourIndexName"
        let hits: [Hit] = try [
            .init(from: [
                "objectID": "100001",
                "title": "Batman Begins",
                "description": "First movie of the Nolan trilogy"
            ]),
            .init(from: [
                "objectID": "100002",
                "title": "The Dark Knight",
                "description": "Second movie of the Nolan trilogy"
            ]),
            .init(from: [
                "objectID": "100003",
                "title": "The Dark Knight Rises",
                "description": "Third and final movie of the Nolan trilogy"
            ])
        ]
        
        let client = try MockSearchClient<BrowseResponse>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            BrowseResponse(
                hitsPerPage: 1,
                nbHits: 1,
                nbPages: 3,
                page: 0,
                processingTimeMS: 100,
                hits: [hits[0]],
                query: "batman",
                params: "query=batman",
                cursor: hits[1].objectID
            ),
            BrowseResponse(
                hitsPerPage: 1,
                nbHits: 1,
                nbPages: 3,
                page: 1,
                processingTimeMS: 76,
                hits: [hits[1]],
                query: "batman",
                params: "query=batman",
                cursor: hits[2].objectID
            ),
            BrowseResponse(
                hitsPerPage: 1,
                nbHits: 1,
                nbPages: 3,
                page: 2,
                processingTimeMS: 22,
                hits: [hits[2]],
                query: "batman",
                params: "query=batman",
                cursor: nil
            )
        ])
        
        var aggregatedResult: [Hit] = []

        try await client.browseObjects(
            indexName: indexName,
            browseParams: BrowseParamsObject(),
            aggregator: { response in
                aggregatedResult.append(contentsOf: response.hits)
            }
        )
        
        XCTAssertEqual(hits.count, aggregatedResult.count)
        for (index, element) in hits.enumerated() {
            let originalElementData = try CodableHelper.jsonEncoder.encode(element)
            let aggregatedElementData = try CodableHelper.jsonEncoder.encode(aggregatedResult[index])

            XCTAssertEqual(originalElementData.jsonString, aggregatedElementData.jsonString)
        }
    }
    
    func testBrowseRulesSuccess() async throws {
        let indexName = "yourIndexName"
        let hits: [Rule] = [
            .init(objectID: "1000001"),
            .init(objectID: "1000002"),
            .init(objectID: "1000003"),
            .init(objectID: "1000004"),
            .init(objectID: "1000005"),
            .init(objectID: "1000006"),
            .init(objectID: "1000007"),
        ]
        
        let client = try MockSearchClient<SearchRulesResponse>(appID: "test-app-id", apiKey: "test-api-key")
        
        client.setResponses([
            SearchRulesResponse(hits: Array(hits[0..<2]), nbHits: 2, page: 0, nbPages: 4),
            SearchRulesResponse(hits: Array(hits[2..<4]), nbHits: 2, page: 1, nbPages: 4),
            SearchRulesResponse(hits: Array(hits[4..<6]), nbHits: 2, page: 2, nbPages: 4),
            SearchRulesResponse(hits: Array(hits[6...]), nbHits: 1, page: 3, nbPages: 4)
        ])

        var aggregatedResult: [Rule] = []

        try await client.browseRules(
            indexName: indexName,
            searchRulesParams: SearchRulesParams(hitsPerPage: 2),
            aggregator: { response in
                aggregatedResult.append(contentsOf: response.hits)
            }
        )

        XCTAssertEqual(hits.count, aggregatedResult.count)
        for (index, element) in hits.enumerated() {
            let originalElementData = try CodableHelper.jsonEncoder.encode(element)
            let aggregatedElementData = try CodableHelper.jsonEncoder.encode(aggregatedResult[index])

            XCTAssertEqual(originalElementData.jsonString, aggregatedElementData.jsonString)
        }
    }
}

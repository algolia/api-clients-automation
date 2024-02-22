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
                "description": "First movie of the Nolan trilogy",
            ]),
            .init(from: [
                "objectID": "100002",
                "title": "The Dark Knight",
                "description": "Second movie of the Nolan trilogy",
            ]),
            .init(from: [
                "objectID": "100003",
                "title": "The Dark Knight Rises",
                "description": "Third and final movie of the Nolan trilogy",
            ]),
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
            ),
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
            SearchRulesResponse(hits: Array(hits[0 ..< 2]), nbHits: 2, page: 0, nbPages: 4),
            SearchRulesResponse(hits: Array(hits[2 ..< 4]), nbHits: 2, page: 1, nbPages: 4),
            SearchRulesResponse(hits: Array(hits[4 ..< 6]), nbHits: 2, page: 2, nbPages: 4),
            SearchRulesResponse(hits: Array(hits[6...]), nbHits: 1, page: 3, nbPages: 4),
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

    func testBrowseSynonymsSuccess() async throws {
        let indexName = "yourIndexName"
        let hits: [SynonymHit] = [
            .init(objectID: "1000001", type: .synonym),
            .init(objectID: "1000002", type: .altcorrection2),
            .init(objectID: "1000003", type: .onewaysynonym),
            .init(objectID: "1000004", type: .altcorrection1),
            .init(objectID: "1000005", type: .synonym),
        ]

        let client = try MockSearchClient<SearchSynonymsResponse>(appID: "test-app-id", apiKey: "test-api-key")

        client.setResponses([
            SearchSynonymsResponse(hits: Array(hits[0 ..< 2]), nbHits: 2),
            SearchSynonymsResponse(hits: Array(hits[2 ..< 4]), nbHits: 2),
            SearchSynonymsResponse(hits: Array(hits[4...]), nbHits: 1),
        ])

        var aggregatedResult: [SynonymHit] = []

        try await client.browseSynonyms(
            indexName: indexName,
            searchSynonymsParams: SearchSynonymsParams(hitsPerPage: 2),
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
    
    func testSearchForHitsSuccess() async throws {
        let indexName = "yourIndexName"
        let expected: [SearchResponse] = try [
            .init(
                hitsPerPage: 2,
                nbHits: 2,
                nbPages: 2,
                page: 0,
                processingTimeMS: 76,
                hits: [
                    .init(from: [
                        "objectID": "100001",
                        "title": "Batman Begins",
                        "description": "First movie of the Nolan trilogy",
                    ]),
                    .init(from: [
                        "objectID": "100002",
                        "title": "The Dark Knight",
                        "description": "Second movie of the Nolan trilogy",
                    ]),
                ],
                query: "batman",
                params: "query=batman"
            ),
            .init(
                hitsPerPage: 2,
                nbHits: 1,
                nbPages: 2,
                page: 1,
                processingTimeMS: 22,
                hits: [
                    .init(from: [
                        "objectID": "100003",
                        "title": "The Dark Knight Rises",
                        "description": "Third and final movie of the Nolan trilogy",
                    ])
                ],
                query: "batman",
                params: "query=batman"
            )
        ]
        
        let client = try MockSearchClient<SearchResponses>(appID: "test-app-id", apiKey: "test-api-key")
        
        client.setResponses([
            .init(results: [
                .searchResponse(expected[0]),
                .searchResponse(expected[1]),
            ])
        ])
        
        let responses = try await client.searchForHits(
            searchMethodParams: SearchMethodParams(requests: [
                .searchForHits(SearchForHits(
                    indexName: indexName
                ))
            ])
        )
        
        XCTAssertEqual(expected.count, responses.count)
        for (index, element) in expected.enumerated() {
            let originalElementData = try CodableHelper.jsonEncoder.encode(element)
            let responseElementData = try CodableHelper.jsonEncoder.encode(responses[index])

            XCTAssertEqual(originalElementData.jsonString, responseElementData.jsonString)
        }
    }
    
    func testSearchForFacetsSuccess() async throws {
        let indexName = "yourIndexName"
        let expected: [SearchForFacetValuesResponse] = [
            .init(
                facetHits: [
                    .init(value: "Action", highlighted: "Action", count: 17),
                    .init(value: "Action/Drama", highlighted: "Action", count: 13),
                    .init(value: "Action/Adventure", highlighted: "Action", count: 2),
                ],
                exhaustiveFacetsCount: false
            ),
            .init(
                facetHits: [
                    .init(value: "Action/Horror", highlighted: "Action", count: 1),
                    .init(value: "Action/Humour", highlighted: "Action", count: 1),
                ],
                exhaustiveFacetsCount: false
            ),
        ]
        
        let client = try MockSearchClient<SearchResponses>(appID: "test-app-id", apiKey: "test-api-key")
        
        client.setResponses([
            .init(results: [
                .searchForFacetValuesResponse(expected[0]),
                .searchForFacetValuesResponse(expected[1]),
            ])
        ])
        
        let responses = try await client.searchForFacets(
            searchMethodParams: SearchMethodParams(requests: [
                .searchForFacets(SearchForFacets(
                    query: "action",
                    facet: "genre",
                    indexName: indexName,
                    type: .facet
                ))
            ])
        )
        
        XCTAssertEqual(expected.count, responses.count)
        for (index, element) in expected.enumerated() {
            let originalElementData = try CodableHelper.jsonEncoder.encode(element)
            let responseElementData = try CodableHelper.jsonEncoder.encode(responses[index])

            XCTAssertEqual(originalElementData.jsonString, responseElementData.jsonString)
        }
    }
}

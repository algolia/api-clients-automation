//
//  SearchTests.swift
//  AlgoliaSearchClientTests
//
//  Created by Algolia on 18/09/2024.
//

import XCTest

import Utils

@testable import Core
@testable import Search

final class SearchClientManualTests: XCTestCase {
    func testBuildFilters() throws {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]

        let disjunctiveFacets: Set<String> = [
            "color",
        ]

        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )

        XCTAssertEqual(helper.buildFilters(excluding: .none), """
        ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" AND "size":"s")
        """)
        XCTAssertEqual(helper.buildFilters(excluding: "popularity"), """
        ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" AND "size":"s")
        """)
        XCTAssertEqual(helper.buildFilters(excluding: "brand"), """
        ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" AND "size":"s")
        """)
        XCTAssertEqual(helper.buildFilters(excluding: "color"), """
        ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("size":"m" AND "size":"s")
        """)
        XCTAssertEqual(helper.buildFilters(excluding: "size"), """
        ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red")
        """)
    }

    func testAppliedDisjunctiveFacetValues() {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]

        let disjunctiveFacets: Set<String> = [
            "color",
            "brand",
        ]

        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )

        XCTAssertTrue(helper.appliedDisjunctiveFacetValues(for: "popularity").isEmpty)
        XCTAssertTrue(helper.appliedDisjunctiveFacetValues(for: "size").isEmpty)
        XCTAssertEqual(helper.appliedDisjunctiveFacetValues(for: "color"), ["red", "green", "blue"])
        XCTAssertEqual(helper.appliedDisjunctiveFacetValues(for: "brand"), ["samsung", "sony", "apple"])
    }

    func testMakeQueriesNoDisjunctive() {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]

        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: []
        )
        let queries = helper.makeQueries()
        XCTAssertEqual(queries.count, 1)

        if case let .searchForHits(searchForHits) = queries.first {
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" AND "color":"green" AND "color":"red") AND ("size":"m" AND "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
    }

    func testMakeQueriesDisjunctiveSingle() {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]

        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: ["color"]
        )
        let queries = helper.makeQueries()
        XCTAssertEqual(queries.count, 2)
        if case let .searchForHits(searchForHits) = queries.first {
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" AND "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries.last {
            XCTAssertEqual(searchForHits.facets, ["color"])
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("size":"m" AND "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
    }

    func testMakeQueriesDisjunctiveDouble() {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]
        let disjunctiveFacets: Set<String> = [
            "color",
            "size",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )
        let queries = helper.makeQueries()
        XCTAssertEqual(queries.count, 3)
        if case let .searchForHits(searchForHits) = queries.first {
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" OR "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[1] {
            XCTAssertEqual(searchForHits.facets, ["color"])
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("size":"m" OR "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[2] {
            XCTAssertEqual(searchForHits.facets, ["size"])
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
    }

    func testMergeEmptyResponses() {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]
        let disjunctiveFacets: Set<String> = [
            "color",
            "size",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )

        do {
            let _: SearchDisjunctiveFacetingResponse<Hit> = try helper.mergeResponses([])
            XCTFail("This should have failed")
        } catch let error as DisjunctiveFacetingError {
            XCTAssertEqual(
                error.localizedDescription,
                "Unexpected empty search responses list. At least one search responses might be present."
            )
        } catch {
            XCTFail("Wrong error caught: \(error)")
        }
    }

    func testMergeDisjunctiveSingle() throws {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]
        let disjunctiveFacets: Set<String> = [
            "color",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )
        var mainResponse: SearchResponse<Hit> = SearchResponse(processingTimeMS: 100, hits: [], query: "", params: "")
        mainResponse.facets = [
            "size": [
                "s": 5,
                "m": 7,
            ],
            "color": [
                "red": 1,
                "green": 2,
                "blue": 3,
            ],
            "brand": [
                "samsung": 5,
                "sony": 10,
                "apple": 15,
            ],
        ]
        var disjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        disjunctiveResponse.facets = [
            "color": [
                "red": 10,
                "green": 20,
                "blue": 30,
            ],
        ]
        let result: SearchDisjunctiveFacetingResponse<Hit> = try helper.mergeResponses([
            mainResponse,
            disjunctiveResponse,
        ])
        XCTAssertEqual(result.response.facets, [
            "size": [
                "s": 5,
                "m": 7,
            ],
            "color": [
                "red": 1,
                "green": 2,
                "blue": 3,
            ],
            "brand": [
                "samsung": 5,
                "sony": 10,
                "apple": 15,
            ],
        ])
        XCTAssertEqual(result.disjunctiveFacets, ["color": [
            "red": 10,
            "green": 20,
            "blue": 30,
        ]])
    }

    func testMergeDisjunctiveDouble() throws {
        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]
        let disjunctiveFacets: Set<String> = [
            "color",
            "size",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )
        var mainResponse: SearchResponse<Hit> = SearchResponse(processingTimeMS: 100, hits: [], query: "", params: "")
        mainResponse.facets = [
            "size": [
                "s": 5,
                "m": 7,
            ],
            "color": [
                "red": 1,
                "green": 2,
                "blue": 3,
            ],
            "brand": [
                "samsung": 5,
                "sony": 10,
                "apple": 15,
            ],
        ]
        var firstDisjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        firstDisjunctiveResponse.facets = [
            "color": [
                "red": 10,
                "green": 20,
                "blue": 30,
            ],
        ]
        var secondDisjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        secondDisjunctiveResponse.facets = [
            "size": [
                "s": 3,
                "m": 4,
            ],
        ]
        let result: SearchDisjunctiveFacetingResponse<Hit> = try helper.mergeResponses([
            mainResponse,
            firstDisjunctiveResponse,
            secondDisjunctiveResponse,
        ])
        XCTAssertEqual(result.response.facets, [
            "size": [
                "s": 5,
                "m": 7,
            ],
            "color": [
                "red": 1,
                "green": 2,
                "blue": 3,
            ],
            "brand": [
                "samsung": 5,
                "sony": 10,
                "apple": 15,
            ],
        ])
        XCTAssertEqual(result.disjunctiveFacets, [
            "color": [
                "red": 10,
                "green": 20,
                "blue": 30,
            ],
            "size": [
                "s": 3,
                "m": 4,
            ],
        ])
    }

    func testMergeFacetStats() throws {
        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: [:],
            disjunctiveFacets: []
        )

        var mainResponse: SearchResponse<Hit> = SearchResponse(processingTimeMS: 100, hits: [], query: "", params: "")
        mainResponse.facetsStats = [
            "price": SearchFacetStats(min: 5, max: 100, avg: 52.5, sum: 2400),
            "target": SearchFacetStats(min: 1, max: 10, avg: 5.5, sum: 43),
        ]
        var firstDisjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        firstDisjunctiveResponse.facetsStats = [
            "price": SearchFacetStats(min: 7, max: 103, avg: 55, sum: 3000),
            "note": SearchFacetStats(min: 1, max: 5, avg: 3, sum: 37),
        ]
        var secondDisjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        secondDisjunctiveResponse.facetsStats = [
            "size": SearchFacetStats(min: 20, max: 56, avg: 38, sum: 242),
        ]
        let result: SearchDisjunctiveFacetingResponse<Hit> = try helper.mergeResponses([
            mainResponse,
            firstDisjunctiveResponse,
            secondDisjunctiveResponse,
        ])

        XCTAssertEqual(result.response.facetsStats?.count, 4)
        self.assertEqual(
            result.response.facetsStats?["price"],
            SearchFacetStats(min: 7, max: 103, avg: 55, sum: 3000),
            file: #filePath,
            line: #line
        )
        self.assertEqual(
            result.response.facetsStats?["target"],
            SearchFacetStats(min: 1, max: 10, avg: 5.5, sum: 43),
            file: #filePath,
            line: #line
        )
        self.assertEqual(
            result.response.facetsStats?["size"],
            SearchFacetStats(min: 20, max: 56, avg: 38, sum: 242),
            file: #filePath,
            line: #line
        )
        self.assertEqual(
            result.response.facetsStats?["note"],
            SearchFacetStats(min: 1, max: 5, avg: 3, sum: 37),
            file: #filePath,
            line: #line
        )
    }

    func assertEqual(
        _ lhs: SearchFacetStats?,
        _ rhs: SearchFacetStats?,
        file: StaticString = #filePath,
        line: UInt = #line
    ) {
        guard let lhs else {
            XCTAssertNil(rhs, file: file, line: line)
            return
        }
        guard let rhs else {
            XCTAssertNil(lhs, file: file, line: line)
            return
        }
        XCTAssertEqual(lhs.min!, rhs.min!, accuracy: 0.01, file: file, line: line)
        XCTAssertEqual(lhs.max!, rhs.max!, accuracy: 0.01, file: file, line: line)
        if let lAvg = lhs.avg, let rAvg = rhs.avg {
            XCTAssertEqual(lAvg, rAvg, accuracy: 0.01, file: file, line: line)
        } else {
            XCTAssertEqual(lhs.avg, rhs.avg, file: file, line: line)
        }
        if let lSum = lhs.sum, let rSum = rhs.sum {
            XCTAssertEqual(lSum, rSum, accuracy: 0.01, file: file, line: line)
        } else {
            XCTAssertEqual(lhs.sum, rhs.sum, file: file, line: line)
        }
    }

    func testMergeExhaustiveFacetsCount() throws {
        let helper = DisjunctiveFacetingHelper(
            query: SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name"),
            refinements: [:],
            disjunctiveFacets: []
        )

        var mainResponse: SearchResponse<Hit> = SearchResponse(processingTimeMS: 100, hits: [], query: "", params: "")
        mainResponse.exhaustive = SearchExhaustive(facetsCount: true)
        var firstDisjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        firstDisjunctiveResponse.exhaustive = SearchExhaustive(facetsCount: true)
        var secondDisjunctiveResponse: SearchResponse<Hit> = SearchResponse(
            processingTimeMS: 100,
            hits: [],
            query: "",
            params: ""
        )
        secondDisjunctiveResponse.exhaustive = SearchExhaustive(facetsCount: false)
        var result: SearchDisjunctiveFacetingResponse<Hit> = try helper.mergeResponses([
            mainResponse,
            firstDisjunctiveResponse,
            secondDisjunctiveResponse,
        ])
        XCTAssertNotNil(result.response.exhaustive?.facetsCount)
        XCTAssertFalse(result.response.exhaustive!.facetsCount!)
        secondDisjunctiveResponse.exhaustive?.facetsCount = true
        result = try helper.mergeResponses([
            mainResponse,
            firstDisjunctiveResponse,
            secondDisjunctiveResponse,
        ])
        XCTAssertNotNil(result.response.exhaustive?.facetsCount)
        XCTAssertTrue(result.response.exhaustive!.facetsCount!)
    }

    func testKeepExistingFilters() throws {
        var query = SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name")
        query.filters = "NOT color:blue"

        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]
        let disjunctiveFacets: Set<String> = [
            "color",
            "size",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: query,
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )
        let queries = helper.makeQueries()
        XCTAssertEqual(queries.count, 3)
        if case let .searchForHits(searchForHits) = queries.first {
            XCTAssertEqual(searchForHits.filters, """
            NOT color:blue AND ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" OR "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[1] {
            XCTAssertEqual(searchForHits.facets, ["color"])
            XCTAssertEqual(searchForHits.filters, """
            NOT color:blue AND ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("size":"m" OR "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[2] {
            XCTAssertEqual(searchForHits.facets, ["size"])
            XCTAssertEqual(searchForHits.filters, """
            NOT color:blue AND ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
    }

    func testKeepExistingFiltersEmpty() throws {
        var query = SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name")
        query.filters = ""

        let refinements: [String: [String]] = [
            "size": ["m", "s"],
            "color": ["blue", "green", "red"],
            "brand": ["apple", "samsung", "sony"],
        ]
        let disjunctiveFacets: Set<String> = [
            "color",
            "size",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: query,
            refinements: refinements,
            disjunctiveFacets: disjunctiveFacets
        )
        let queries = helper.makeQueries()
        XCTAssertEqual(queries.count, 3)
        if case let .searchForHits(searchForHits) = queries.first {
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red") AND ("size":"m" OR "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[1] {
            XCTAssertEqual(searchForHits.facets, ["color"])
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("size":"m" OR "size":"s")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[2] {
            XCTAssertEqual(searchForHits.facets, ["size"])
            XCTAssertEqual(searchForHits.filters, """
            ("brand":"apple" AND "brand":"samsung" AND "brand":"sony") AND ("color":"blue" OR "color":"green" OR "color":"red")
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
    }

    func testKeepExistingFiltersNoRefinement() throws {
        var query = SearchForHits(from: SearchSearchParamsObject(), indexName: "index_name")
        query.filters = "NOT color:blue"

        let disjunctiveFacets: Set<String> = [
            "color",
            "size",
        ]
        let helper = DisjunctiveFacetingHelper(
            query: query,
            refinements: [:],
            disjunctiveFacets: disjunctiveFacets
        )
        let queries = helper.makeQueries()
        XCTAssertEqual(queries.count, 3)
        if case let .searchForHits(searchForHits) = queries.first {
            XCTAssertEqual(searchForHits.filters, """
            NOT color:blue
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[1] {
            XCTAssertEqual(searchForHits.facets, ["color"])
            XCTAssertEqual(searchForHits.filters, """
            NOT color:blue
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
        if case let .searchForHits(searchForHits) = queries[2] {
            XCTAssertEqual(searchForHits.facets, ["size"])
            XCTAssertEqual(searchForHits.filters, """
            NOT color:blue
            """)
        } else {
            XCTFail("Query should have been a SearchForHits type")
        }
    }
}

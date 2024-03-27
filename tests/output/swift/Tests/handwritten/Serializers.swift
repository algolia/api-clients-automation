//
//  File.swift
//  
//
//  Created by Algolia on 27/03/2024.
//

import Foundation
import XCTest
@testable import Core
import Insights

class SerializersTests: XCTestCase {
    func testEventItemsClickedObjectIDsAfterSearch() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let positions = Array(repeating: 0, count: 5).map { _ in Int.random(in: 1 ... 9_999_999) }
        let queryID = try randomString()
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"click\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"positions\":[\(positions.map { "\($0)" }.joined(separator: ","))],\"queryID\":\"\(queryID)\",\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .clickedObjectIDsAfterSearch(
            ClickedObjectIDsAfterSearch(
                eventName: eventName,
                eventType: .click,
                index: indexName,
                objectIDs: objectIDs,
                positions: positions,
                queryID: queryID,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsAddedToCartObjectIDsAfterSearch() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let queryID = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data = "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"eventSubtype\":\"addToCart\",\"index\":\"\(indexName)\",\"queryID\":\"\(queryID)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .addedToCartObjectIDsAfterSearch(
            AddedToCartObjectIDsAfterSearch(
                eventName: eventName,
                eventType: .conversion,
                eventSubtype: .addToCart,
                index: indexName,
                queryID: queryID,
                objectIDs: objectIDs,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsPurchasedObjectIDsAfterSearch() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let objectData = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"eventSubtype\":\"purchase\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\",\"objectData\":[\(objectData.map { "{\"queryID\":\"\($0)\"}" }.joined(separator: ","))]}".data(using: .utf8)
        let expectedResult: EventsItems = .purchasedObjectIDsAfterSearch(
            PurchasedObjectIDsAfterSearch(
                eventName: eventName,
                eventType: .conversion,
                eventSubtype: .purchase,
                index: indexName,
                objectIDs: objectIDs,
                userToken: userToken,
                objectData: objectData.map { ObjectDataAfterSearch(queryID: $0) }
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsConvertedObjectIDsAfterSearch() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let queryID = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"queryID\":\"\(queryID)\",\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .convertedObjectIDsAfterSearch(
            ConvertedObjectIDsAfterSearch(
                eventName: eventName,
                eventType: .conversion,
                index: indexName,
                objectIDs: objectIDs,
                queryID: queryID,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsClickedObjectIDs() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"click\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .clickedObjectIDs(
            ClickedObjectIDs(
                eventName: eventName,
                eventType: .click,
                index: indexName,
                objectIDs: objectIDs,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsPurchasedObjectIDs() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"eventSubtype\":\"purchase\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .purchasedObjectIDs(
            PurchasedObjectIDs(
                eventName: eventName,
                eventType: .conversion,
                eventSubtype: .purchase,
                index: indexName,
                objectIDs: objectIDs,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsAddedToCartObjectIDs() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"eventSubtype\":\"addToCart\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .addedToCartObjectIDs(
            AddedToCartObjectIDs(
                eventName: eventName,
                eventType: .conversion,
                eventSubtype: .addToCart,
                index: indexName,
                objectIDs: objectIDs,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsConvertedObjectIDs() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .convertedObjectIDs(
            ConvertedObjectIDs(
                eventName: eventName,
                eventType: .conversion,
                index: indexName,
                objectIDs: objectIDs,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsClickedFilters() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let filters = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"click\",\"index\":\"\(indexName)\",\"filters\":[\(filters.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .clickedFilters(
            ClickedFilters(
                eventName: eventName,
                eventType: .click,
                index: indexName,
                filters: filters,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsConvertedFilters() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let filters = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"conversion\",\"index\":\"\(indexName)\",\"filters\":[\(filters.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .convertedFilters(
            ConvertedFilters(
                eventName: eventName,
                eventType: .conversion,
                index: indexName,
                filters: filters,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsViewedObjectIDs() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let objectIDs = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"view\",\"index\":\"\(indexName)\",\"objectIDs\":[\(objectIDs.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .viewedObjectIDs(
            ViewedObjectIDs(
                eventName: eventName,
                eventType: .view,
                index: indexName,
                objectIDs: objectIDs,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }

    func testEventItemsViewedFilters() async throws {
        let eventName = try randomString()
        let indexName = try randomString()
        let filters = try Array(repeating: "", count: 3).map { _ in try randomString() }
        let userToken = try randomString()
        let data =
            "{\"eventName\":\"\(eventName)\",\"eventType\":\"view\",\"index\":\"\(indexName)\",\"filters\":[\(filters.map { "\"\($0)\"" }.joined(separator: ","))],\"userToken\":\"\(userToken)\"}".data(using: .utf8)
        let expectedResult: EventsItems = .viewedFilters(
            ViewedFilters(
                eventName: eventName,
                eventType: .view,
                index: indexName,
                filters: filters,
                userToken: userToken
            )
        )
        
        let jsonData = try XCTUnwrap(data)
        let serializedObject: EventsItems = try CodableHelper.jsonDecoder.decode(EventsItems.self, from: jsonData) as EventsItems
        
        XCTAssertEqual(expectedResult, serializedObject)
    }
}

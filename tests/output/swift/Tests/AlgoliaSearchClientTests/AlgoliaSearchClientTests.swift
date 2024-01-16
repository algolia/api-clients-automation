import XCTest
@testable import Abtesting

let APPLICATION_ID = ""
let API_KEY = ""

final class AlgoliaSearchClientTests: XCTestCase {
    func testExample() throws {
        let client = AbtestingClient(applicationID: APPLICATION_ID, apiKey: API_KEY, region: nil)
        
        let response = client.listABTestsWithRequestBuilder()
        
        XCTAssertEqual(response.path, "/2/abtests")
    }
}

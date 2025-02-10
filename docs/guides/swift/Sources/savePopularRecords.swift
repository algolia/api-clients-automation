import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

struct Record: Codable {
    let twitterHandle: String
    let nbFollowers: Int
    var isPopular = false
}

func savePopularRecords() async throws {
    do {
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        var records: [Record] = []

        try await client.browseObjects(
            indexName: "YOUR_INDEX_NAME",
            browseParams: BrowseParamsObject(),
            aggregator: { (response: BrowseResponse<Record>) in
                records.append(contentsOf: response.hits.map {
                    $0.nbFollowers < 1_000_000 ? $0 : Record(
                        twitterHandle: $0.twitterHandle,
                        nbFollowers: $0.nbFollowers,
                        isPopular: true
                    )
                })
            }
        )

        try await client.saveObjects(indexName: "<YOUR_INDEX_NAME>", objects: records)
    } catch {
        print(error)
    }
}

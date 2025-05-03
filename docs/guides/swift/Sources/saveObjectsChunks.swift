import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func saveObjectsChunks() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let path = URL(string: #file)!.deletingLastPathComponent()
        .appendingPathComponent("actors.json")
    let data = try Data(contentsOf: URL(fileURLWithPath: path.absoluteString))
    let records = try JSONDecoder().decode([AnyCodable].self, from: data)

    let chunkSize = 10000

    for beginIndex in stride(from: 0, to: records.count, by: chunkSize) {
        let endIndex = min(beginIndex + chunkSize, records.count)
        let chunk = Array(records[beginIndex ..< endIndex])
        try await client.saveObjects(indexName: "<YOUR_INDEX_NAME>", objects: chunk)
    }
}

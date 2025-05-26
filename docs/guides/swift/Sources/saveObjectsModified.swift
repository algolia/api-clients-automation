import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func saveObjectsModified() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let path = URL(string: #file)!.deletingLastPathComponent()
        .appendingPathComponent("products.json")
    let data = try Data(contentsOf: URL(fileURLWithPath: path.absoluteString))
    let products = try JSONDecoder().decode([[String: AnyCodable]].self, from: data)

    let records = products.map { product -> [String: AnyCodable] in
        var reference = product["product_reference"]?.value as! String
        var suffixes: [String] = []

        while reference.count > 1 {
            reference = String(reference.dropFirst())
            suffixes.append(reference)
        }
        var record: [String: AnyCodable] = product
        record["product_reference_suffixes"] = AnyCodable(suffixes)
        return record
    }

    try await client.saveObjects(indexName: "<YOUR_INDEX_NAME>", objects: records)
}

import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func saveImageClassifications() async throws {
    struct Image: Codable {
        var objectID: String
        var imageURL: String
        var objects: [[String: AnyCodable]]
    }

    func getImageLabels(imageURL _: String, objectID _: String, scoreLimit _: Double) -> Image {
        // Implement your image classification logic here
        Image(objectID: "", imageURL: "", objects: [])
    }

    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    var records: [Image] = []

    try await client.browseObjects(
        indexName: "<YOUR_INDEX_NAME>",
        browseParams: BrowseParamsObject(),
        aggregator: { (response: BrowseResponse<Image>) in
            records.append(contentsOf: response.hits.map { hit in
                let imageURL = hit.imageURL
                return getImageLabels(imageURL: imageURL, objectID: hit.objectID, scoreLimit: 0.5)
            })
        }
    )

    try await client.partialUpdateObjects(indexName: "<YOUR_INDEX_NAME>", objects: records, createIfNotExists: true)
}

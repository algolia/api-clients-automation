import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func saveObjectsPublicUser() async throws {
    let playlists: [[String: AnyCodable]] = [] // Your records

    do {
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        try await client.saveObjects(
            indexName: "<YOUR_INDEX_NAME>",
            objects: playlists,
            waitForTasks: false,
            batchSize: 1000,
            requestOptions: RequestOptions(
                headers: ["X-Algolia-User-ID": "*"]
            )
        )
    } catch {
        print(error)
    }
}

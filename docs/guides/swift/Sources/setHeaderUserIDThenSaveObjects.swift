import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func setHeaderUserIDThenSaveObjects() async throws {
    let playlists: [[String: AnyCodable]] = [ /* Your records */ ]

    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    for playlist in playlists {
        do {
            let playlistUserID = playlist["userID"]?.value as! String
            try await client.saveObjects(
                indexName: "<YOUR_INDEX_NAME>",
                objects: playlists,
                waitForTasks: false,
                batchSize: 1000,
                requestOptions: RequestOptions(
                    headers: ["X-Algolia-User-ID": playlistUserID]
                )
            )
        } catch {
            print(error)
        }
    }
}

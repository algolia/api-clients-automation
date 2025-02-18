import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let getAllAppIDConfigurations: () -> [(String, String)] = {
    [ /* A list of your MCM AppID/ApiKey pairs */ ]
}

func saveObjectsMCM() async throws {
    let playlists: [[String: AnyCodable]] = [ /* Your records */ ]

    // Fetch from your own data storage and with your own code
    // the list of application IDs and API keys to target each cluster
    let configurations = getAllAppIDConfigurations()

    // Send the records to each cluster
    for (appID, apiKey) in configurations {
        do {
            let client = try SearchClient(appID: appID, apiKey: apiKey)

            try await client.saveObjects(indexName: "<YOUR_INDEX_NAME>", objects: playlists)
        } catch {
            print(error)
        }
    }
}

import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let playlists: [[String: AnyCodable]] = [ /* Your records */ ]

let getAppIDFor = { (_: String) in "" } // Implement your own logic here
let getIndexingApiKeyFor = { (_: String) in "" } // Implement your own logic here

func setSettingsThenSaveObjects() async throws {
    for playlist in playlists {
        // Fetch from your own data storage and with your own code
        // the associated application ID and API key for this user
        let appID = getAppIDFor(playlist["user"]?.value as! String)
        let apiKey = getIndexingApiKeyFor(playlist["user"]?.value as! String)

        do {
            let client = try SearchClient(appID: appID, apiKey: apiKey)
            let settings = IndexSettings(
                attributesForFaceting: ["filterOnly(user)"]
            )
            try await client.setSettings(indexName: "<YOUR_INDEX_NAME>", indexSettings: settings)

            try await client.saveObjects(indexName: "<YOUR_INDEX_NAME>", objects: playlists)
        } catch {
            print(error)
        }
    }
}

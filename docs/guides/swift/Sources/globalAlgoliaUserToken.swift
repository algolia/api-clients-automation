import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func globalAlgoliaUserToken() async throws {
    let configuration = try SearchClientConfiguration(
        appID: "ALGOLIA_APPLICATION_ID",
        apiKey: "ALGOLIA_API_KEY",
        defaultHeaders: ["X-Algolia-UserToken": "test-user-123"]
    )
    let client = SearchClient(configuration: configuration)
    print(client)
}

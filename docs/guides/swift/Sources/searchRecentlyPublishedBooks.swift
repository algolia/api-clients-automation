import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func searchRecentlyPublishedBooks() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let dateTimestamp = Int(Date().timeIntervalSince1970) - 365 * 24 * 60 * 60
    let searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(query: "<YOUR_SEARCH_QUERY>", filters: "date_timestamp > \(dateTimestamp)")
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )
    print(response)
}

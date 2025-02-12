import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func searchWithLogicalOr() async throws {
    do {
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")
        let query = "the query"
        let optionalWords = ["the", "query"]
        let searchParams = SearchSearchParams.searchSearchParamsObject(
            SearchSearchParamsObject(
                query: query,
                optionalWords: .arrayOfString(optionalWords)
            )
        )
        let _: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: searchParams
        )
    } catch {
        print(error)
    }
}

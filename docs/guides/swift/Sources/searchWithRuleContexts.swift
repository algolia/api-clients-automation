import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let getPlatformTag = { "" } // Implement your logic here

func searchWithRuleContexts() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let platformTag = getPlatformTag()
    let searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(query: "<YOUR_SEARCH_QUERY>", ruleContexts: [platformTag])
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )
    print(response)
}

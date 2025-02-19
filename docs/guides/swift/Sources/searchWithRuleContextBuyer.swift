import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let getBuyerAccountId = { "" } // Implement your logic here

func searchWithRuleContextBuyer() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    // get the buyer account information
    let buyer = getBuyerAccountId()
    let searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(query: "<YOUR_SEARCH_QUERY>", ruleContexts: [buyer])
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )
    print(response)
}

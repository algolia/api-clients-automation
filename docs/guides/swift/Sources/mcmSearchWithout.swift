import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func mcmSearchWithout() async throws {
    let getAppIDFor = { (_: String) in "" } // Implement your own logic here
    let getIndexingApiKeyFor = { (_: String) in "" } // Implement your own logic here

    // Fetch from your own data storage and with your own code
    // the associated application ID and API key for this user
    let appID = getAppIDFor("user42")
    let apiKey = getIndexingApiKeyFor("user42")

    let client = try SearchClient(appID: appID, apiKey: apiKey)
    let searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(
            query: "<YOUR_SEARCH_QUERY>",
            facetFilters: .arrayOfSearchFacetFilters([.string("user:user42"), .string("user:public")])
        )
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )
    print(response)
}

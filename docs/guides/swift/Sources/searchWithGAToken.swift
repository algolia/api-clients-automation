import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let getGoogleAnalyticsUserIdFromBrowserCookie = { (_: String) in
    "" // Implement your logic here
}

func searchWithGAToken() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let userToken = getGoogleAnalyticsUserIdFromBrowserCookie("_ga")
    var searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(query: "<YOUR_SEARCH_QUERY>", userToken: userToken)
    )

    let _: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )

    let loggedInUser: String? = "..."
    searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(query: "<YOUR_SEARCH_QUERY>", userToken: loggedInUser ?? userToken)
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )
    print(response)
}

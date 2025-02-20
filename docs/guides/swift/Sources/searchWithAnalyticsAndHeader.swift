import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func searchWithAnalyticsAndHeader() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    // '94.228.178.246' should be replaced with your user's IP address.
    // Depending on your stack there are multiple ways to get this information.
    let ip = "94.228.178.246"
    let query = "query"

    let searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(
            query: query,
            analytics: true
        )
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams,
        requestOptions: RequestOptions(
            headers: ["X-Forwarded-For": ip]
        )
    )
    print(response)
}

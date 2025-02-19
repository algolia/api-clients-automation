import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func searchInReplicaIndex() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    // 1. Change the sort dynamically based on the UI events
    let sortByPrice = false

    // 2. Get the index name based on sortByPrice
    let indexName = sortByPrice ? "products_price_desc" : "products"

    // 3. Search on dynamic index name (primary or replica)
    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: indexName,
        searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "query"))
    )
    print(response)
}

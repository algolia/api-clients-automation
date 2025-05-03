import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

let labels: [String] = [] // A list of labels

let reduceLabelsToFilters = { (_: [String]) in
    SearchOptionalFilters.arrayOfSearchOptionalFilters([]) // Implement your logic here
}

func searchWithOptionalFilters() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let optionalFilters = reduceLabelsToFilters(labels)
    let searchParams = SearchSearchParams.searchSearchParamsObject(
        SearchSearchParamsObject(query: "<YOUR_SEARCH_QUERY>", optionalFilters: optionalFilters)
    )

    let response: SearchResponse<Hit> = try await client.searchSingleIndex(
        indexName: "<YOUR_INDEX_NAME>",
        searchParams: searchParams
    )
    print(response)
}

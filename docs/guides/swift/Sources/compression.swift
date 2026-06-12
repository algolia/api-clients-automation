import AlgoliaCore
import AlgoliaSearch
import Foundation

func compression() async throws {
    // Initialize the client with gzip compression enabled
    // Compression reduces the size of request bodies sent to Algolia
    let configuration = try SearchClientConfiguration(
        appID: "ALGOLIA_APPLICATION_ID",
        apiKey: "ALGOLIA_API_KEY",
        compression: .gzip
    )
    let client = SearchClient(configuration: configuration)

    do {
        // Search with compressed request body
        let response: SearchResponse<Hit> = try await client.searchSingleIndex(
            indexName: "<YOUR_INDEX_NAME>",
            searchParams: SearchSearchParams.searchSearchParamsObject(SearchSearchParamsObject(query: "comedy"))
        )
        print(response)
    } catch {
        print(error.localizedDescription)
    }
}

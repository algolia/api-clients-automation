import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func saveObjectsMovies() async throws {
    let url = URL(string: "https://dashboard.algolia.com/sample_datasets/movie.json")!
    var data: Data?
    #if os(Linux) // For linux interop
        (data, _) = try await URLSession.shared.asyncData(for: URLRequest(url: url))
    #else
        (data, _) = try await URLSession.shared.data(from: url)
    #endif
    let movies = try JSONDecoder().decode([AnyCodable].self, from: data!)

    // Connect and authenticate with your Algolia app
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    do {
        // Save records in Algolia index
        try await client.saveObjects(indexName: "<YOUR_INDEX_NAME>", objects: movies)
    } catch {
        print(error.localizedDescription)
    }
}

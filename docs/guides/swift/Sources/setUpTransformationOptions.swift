import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import AlgoliaCore
import AlgoliaSearch

func setUpTransformationOptions() async throws {
    // Set transformationOptions with your transformation region to use the `WithTransformation` helper methods.
    // Replace `.us` with `.eu` if your Algolia application uses the Europe analytics region.
    let configuration = try SearchClientConfiguration(
        appID: "ALGOLIA_APPLICATION_ID",
        apiKey: "ALGOLIA_API_KEY",
        transformationOptions: TransformationOptions(region: .us)
    )
    let client = SearchClient(configuration: configuration)

    do {
        // Save records, transforming them through the Push connector
        try await client.saveObjectsWithTransformation(
            indexName: "<YOUR_INDEX_NAME>",
            objects: [["objectID": "1", "name": "Adam"], ["objectID": "2", "name": "Benoit"]],
            waitForTasks: true
        )
    } catch {
        print(error.localizedDescription)
    }
}

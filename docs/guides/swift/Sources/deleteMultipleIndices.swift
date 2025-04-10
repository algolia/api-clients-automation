import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func deleteMultipleIndices() async throws {
    do {
        // You need an API key with `deleteIndex`
        let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

        // List all indices
        let indices = try await client.listIndices()

        // Primary indices don't have a `primary` key
        let primaryIndices = indices.items.filter { $0.primary == nil }
        let replicaIndices = indices.items.filter { $0.primary != nil }

        // Delete primary indices first
        if primaryIndices.isEmpty == false {
            let requests = primaryIndices.map { MultipleBatchRequest(
                action: .delete,
                indexName: $0.name
            ) }
            try await client.multipleBatch(batchParams: BatchParams(requests: requests))
            print("Deleted primary indices.")
        }

        // Now, delete replica indices
        if replicaIndices.isEmpty == false {
            let requests = replicaIndices.map { MultipleBatchRequest(
                action: .delete,
                indexName: $0.name
            ) }
            try await client.multipleBatch(batchParams: BatchParams(requests: requests))
            print("Deleted replica indices.")
        }
    } catch {
        print(error)
    }
}

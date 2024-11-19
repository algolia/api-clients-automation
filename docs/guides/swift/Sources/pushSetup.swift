import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Ingestion

func pushSetup() async throws {
    do {
        let path = URL(string: #file)!.deletingLastPathComponent()
            .appendingPathComponent("/my-raw-records.json")
        let data = try Data(contentsOf: URL(fileURLWithPath: path.absoluteString))
        let records = try JSONDecoder().decode([PushTaskRecords].self, from: data)

        // use the region matching your applicationID
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        let run = try await client.pushTaskWithHTTPInfo(
            taskID: "YOUR_TASK_ID",
            pushTaskPayload: PushTaskPayload(action: IngestionAction.addObject, records: records)
        )

        // use runID in the Observability debugger
        dump(run)
    } catch {
        print(error)
    }
}

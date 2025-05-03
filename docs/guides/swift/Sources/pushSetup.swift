import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Ingestion

func pushSetup() async throws {
    do {
        let path = URL(string: #file)!.deletingLastPathComponent()
            .appendingPathComponent("records.json")
        let data = try Data(contentsOf: URL(fileURLWithPath: path.absoluteString))
        let records = try JSONDecoder().decode([PushTaskRecords].self, from: data)

        // use the region matching your applicationID
        let client = try IngestionClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY", region: .us)

        // setting `watch` to `true` will make the call synchronous
        let resp = try await client.pushTask(
            taskID: "YOUR_TASK_ID",
            pushTaskPayload: PushTaskPayload(action: IngestionAction.addObject, records: records),
            watch: true
        )

        dump(resp)
    } catch {
        print(error)
    }
}

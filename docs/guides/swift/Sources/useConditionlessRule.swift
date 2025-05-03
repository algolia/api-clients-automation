import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func useConditionlessRule() async throws {
    let client = try SearchClient(appID: "ALGOLIA_APPLICATION_ID", apiKey: "ALGOLIA_API_KEY")

    let objectID = "a-rule-id"

    let rule = Rule(
        objectID: objectID,
        consequence: SearchConsequence(
            // Set relevant consequence
        ),
        // Set validity (optional)
        validity: [
            SearchTimeRange(
                from: 1_688_774_400,
                until: 1_738_972_800
            ),
        ]
    )

    try await client.saveRule(indexName: "<YOUR_INDEX_NAME>", objectID: objectID, rule: rule)
}

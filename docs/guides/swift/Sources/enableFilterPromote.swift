import Foundation
#if os(Linux) // For linux interop
    import FoundationNetworking
#endif

import Core
import Search

func enableFilterPromote() async throws {
    let condition = SearchCondition(
        pattern: "{facet:brand}",
        anchoring: .is
    )

    let consequence = SearchConsequence(
        filterPromotes: true
    )

    let rule = Rule(objectID: "rule_with_filterPromotes", conditions: [condition], consequence: consequence)
    print(rule)
}

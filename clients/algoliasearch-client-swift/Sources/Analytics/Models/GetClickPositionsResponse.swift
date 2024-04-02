// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct GetClickPositionsResponse: Codable, JSONEncodable {
    /// List of positions in the search results and clicks associated with this search.
    public var positions: [ClickPositionsInner]

    public init(positions: [ClickPositionsInner]) {
        self.positions = positions
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case positions
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.positions, forKey: .positions)
    }
}

extension GetClickPositionsResponse: Equatable {
    public static func ==(lhs: GetClickPositionsResponse, rhs: GetClickPositionsResponse) -> Bool {
        lhs.positions == rhs.positions
    }
}

extension GetClickPositionsResponse: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.positions.hashValue)
    }
}

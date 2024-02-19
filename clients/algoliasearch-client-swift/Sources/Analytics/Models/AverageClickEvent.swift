// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

#if canImport(AnyCodable)
    import AnyCodable
#endif
import Core
import Foundation

public struct AverageClickEvent: Codable, JSONEncodable, Hashable {
    /// Average count of all click events.
    public var average: Double
    /// Number of click events.
    public var clickCount: Int
    /// Date of the event in the format YYYY-MM-DD.
    public var date: String

    public init(average: Double, clickCount: Int, date: String) {
        self.average = average
        self.clickCount = clickCount
        self.date = date
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case average
        case clickCount
        case date
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.average, forKey: .average)
        try container.encode(self.clickCount, forKey: .clickCount)
        try container.encode(self.date, forKey: .date)
    }
}

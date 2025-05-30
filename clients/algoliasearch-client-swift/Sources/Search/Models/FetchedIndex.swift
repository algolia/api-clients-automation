// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
// https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Foundation
#if canImport(Core)
    import Core
#endif

public struct FetchedIndex: Codable, JSONEncodable {
    /// Index name.
    public var name: String
    /// Index creation date. An empty string means that the index has no records.
    public var createdAt: String
    /// Date and time when the object was updated, in RFC 3339 format.
    public var updatedAt: String
    /// Number of records contained in the index.
    public var entries: Int
    /// Number of bytes of the index in minified format.
    public var dataSize: Int64
    /// Number of bytes of the index binary file.
    public var fileSize: Int64
    /// Last build time.
    public var lastBuildTimeS: Int
    /// Number of pending indexing operations. This value is deprecated and should not be used.
    public var numberOfPendingTasks: Int
    /// A boolean which says whether the index has pending tasks. This value is deprecated and should not be used.
    public var pendingTask: Bool
    /// Only present if the index is a replica. Contains the name of the related primary index.
    public var primary: String?
    /// Only present if the index is a primary index with replicas. Contains the names of all linked replicas.
    public var replicas: [String]?
    /// Only present if the index is a [virtual replica](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-an-index-alphabetically/#virtual-replicas).
    public var virtual: Bool?

    public init(
        name: String,
        createdAt: String,
        updatedAt: String,
        entries: Int,
        dataSize: Int64,
        fileSize: Int64,
        lastBuildTimeS: Int,
        numberOfPendingTasks: Int,
        pendingTask: Bool,
        primary: String? = nil,
        replicas: [String]? = nil,
        virtual: Bool? = nil
    ) {
        self.name = name
        self.createdAt = createdAt
        self.updatedAt = updatedAt
        self.entries = entries
        self.dataSize = dataSize
        self.fileSize = fileSize
        self.lastBuildTimeS = lastBuildTimeS
        self.numberOfPendingTasks = numberOfPendingTasks
        self.pendingTask = pendingTask
        self.primary = primary
        self.replicas = replicas
        self.virtual = virtual
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case name
        case createdAt
        case updatedAt
        case entries
        case dataSize
        case fileSize
        case lastBuildTimeS
        case numberOfPendingTasks
        case pendingTask
        case primary
        case replicas
        case virtual
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encode(self.name, forKey: .name)
        try container.encode(self.createdAt, forKey: .createdAt)
        try container.encode(self.updatedAt, forKey: .updatedAt)
        try container.encode(self.entries, forKey: .entries)
        try container.encode(self.dataSize, forKey: .dataSize)
        try container.encode(self.fileSize, forKey: .fileSize)
        try container.encode(self.lastBuildTimeS, forKey: .lastBuildTimeS)
        try container.encode(self.numberOfPendingTasks, forKey: .numberOfPendingTasks)
        try container.encode(self.pendingTask, forKey: .pendingTask)
        try container.encodeIfPresent(self.primary, forKey: .primary)
        try container.encodeIfPresent(self.replicas, forKey: .replicas)
        try container.encodeIfPresent(self.virtual, forKey: .virtual)
    }
}

extension FetchedIndex: Equatable {
    public static func ==(lhs: FetchedIndex, rhs: FetchedIndex) -> Bool {
        lhs.name == rhs.name &&
            lhs.createdAt == rhs.createdAt &&
            lhs.updatedAt == rhs.updatedAt &&
            lhs.entries == rhs.entries &&
            lhs.dataSize == rhs.dataSize &&
            lhs.fileSize == rhs.fileSize &&
            lhs.lastBuildTimeS == rhs.lastBuildTimeS &&
            lhs.numberOfPendingTasks == rhs.numberOfPendingTasks &&
            lhs.pendingTask == rhs.pendingTask &&
            lhs.primary == rhs.primary &&
            lhs.replicas == rhs.replicas &&
            lhs.virtual == rhs.virtual
    }
}

extension FetchedIndex: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(self.name.hashValue)
        hasher.combine(self.createdAt.hashValue)
        hasher.combine(self.updatedAt.hashValue)
        hasher.combine(self.entries.hashValue)
        hasher.combine(self.dataSize.hashValue)
        hasher.combine(self.fileSize.hashValue)
        hasher.combine(self.lastBuildTimeS.hashValue)
        hasher.combine(self.numberOfPendingTasks.hashValue)
        hasher.combine(self.pendingTask.hashValue)
        hasher.combine(self.primary?.hashValue)
        hasher.combine(self.replicas?.hashValue)
        hasher.combine(self.virtual?.hashValue)
    }
}

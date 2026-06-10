//
//  IngestionClientOptions.swift
//
//  Optional overrides for the ingestion transporter used by the `*WithTransformation` helpers.
//  Every field is optional; an unset field keeps the ingestion transporter default
//  (25 s timeouts, region-derived hosts, no compression). Consumed only by `TransformationOptions`.
//
//  KEEP IN SYNC: the overridable fields below mirror the resolved fields on
//  `<Client>ClientConfiguration` (readTimeout, writeTimeout, hosts, compression, defaultHeaders).
//  If you add, remove, or rename one here, mirror the change on the configuration, and vice versa.
//
//  See https://www.algolia.com/doc/libraries/sdk/methods/ingestion

import Foundation

public struct IngestionClientOptions {
    /// Override the read timeout.
    public var readTimeout: TimeInterval?

    /// Override the write timeout.
    public var writeTimeout: TimeInterval?

    /// Override the hosts.
    public var hosts: [RetryableHost]?

    /// Override the compression.
    public var compression: CompressionAlgorithm?

    /// Additional headers merged into every request.
    public var defaultHeaders: [String: String]?

    /// - parameter readTimeout: Override the read timeout.
    /// - parameter writeTimeout: Override the write timeout.
    /// - parameter hosts: Override the hosts.
    /// - parameter compression: Override the compression.
    /// - parameter defaultHeaders: Additional headers merged into every request.
    public init(
        readTimeout: TimeInterval? = nil,
        writeTimeout: TimeInterval? = nil,
        hosts: [RetryableHost]? = nil,
        compression: CompressionAlgorithm? = nil,
        defaultHeaders: [String: String]? = nil
    ) {
        self.readTimeout = readTimeout
        self.writeTimeout = writeTimeout
        self.hosts = hosts
        self.compression = compression
        self.defaultHeaders = defaultHeaders
    }
}

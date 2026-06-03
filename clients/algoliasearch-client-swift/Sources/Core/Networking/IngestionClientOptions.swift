//
//  IngestionClientOptions.swift
//
//  Shared, overridable base options for the ingestion transporter. Used both to build an
//  `IngestionClientConfiguration` (see its `init(appID:apiKey:region:options:)`) and as the
//  override model carried by `TransformationOptions`. Every field is optional and falls back
//  to the Ingestion API defaults (25 s timeouts, region-derived hosts, no compression) when unset.
//
//  See https://www.algolia.com/doc/libraries/sdk/methods/ingestion

import Foundation

public struct IngestionClientOptions {
    /// Override the read timeout. Defaults to 25 s.
    public var readTimeout: TimeInterval?

    /// Override the write timeout. Defaults to 25 s.
    public var writeTimeout: TimeInterval?

    /// Override the hosts derived from the region.
    public var hosts: [RetryableHost]?

    /// Override the compression. Defaults to `.none`.
    public var compression: CompressionAlgorithm?

    /// Additional headers merged into every ingestion request.
    public var defaultHeaders: [String: String]?

    /// - parameter readTimeout: Override the ingestion read timeout. Defaults to 25 s.
    /// - parameter writeTimeout: Override the ingestion write timeout. Defaults to 25 s.
    /// - parameter hosts: Override the ingestion hosts derived from the region.
    /// - parameter compression: Override the ingestion compression. Defaults to `.none`.
    /// - parameter defaultHeaders: Additional headers merged into every ingestion request.
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

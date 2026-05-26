//
//  TransformationOptions.swift
//
//  Configuration options for the ingestion transporter used by `*WithTransformation` helpers
//  on SearchClient.
//
//  When passed to SearchClient, an ingestion transporter is eagerly created using Ingestion API
//  defaults (25 s timeouts, region-derived hosts, no compression). Only fields explicitly set
//  here override those defaults. Credentials are always taken from the parent SearchClient.
//
//  See https://www.algolia.com/doc/libraries/sdk/methods/ingestion

#if canImport(AlgoliaCore)
    import AlgoliaCore
#endif
import Foundation

public struct TransformationOptions {
    /// The Algolia region for the Ingestion API. Required.
    public let region: Region

    /// Override the default read timeout (25 s).
    public var readTimeout: TimeInterval?

    /// Override the default write timeout (25 s).
    public var writeTimeout: TimeInterval?

    /// Override the default ingestion hosts.
    public var hosts: [RetryableHost]?

    /// Override the default compression (none).
    public var compression: CompressionAlgorithm?

    /// Override the default headers.
    public var defaultHeaders: [String: String]?

    /// - parameter region: The Algolia region for the Ingestion API (`Region.us` or `Region.eu`). Required.
    /// - parameter readTimeout: Override the ingestion read timeout. Defaults to 25 s.
    /// - parameter writeTimeout: Override the ingestion write timeout. Defaults to 25 s.
    /// - parameter hosts: Override the ingestion hosts derived from `region`.
    /// - parameter compression: Override the ingestion compression. Defaults to `.none`.
    /// - parameter defaultHeaders: Additional headers merged into every ingestion request.
    public init(
        region: Region,
        readTimeout: TimeInterval? = nil,
        writeTimeout: TimeInterval? = nil,
        hosts: [RetryableHost]? = nil,
        compression: CompressionAlgorithm? = nil,
        defaultHeaders: [String: String]? = nil
    ) {
        self.region = region
        self.readTimeout = readTimeout
        self.writeTimeout = writeTimeout
        self.hosts = hosts
        self.compression = compression
        self.defaultHeaders = defaultHeaders
    }
}

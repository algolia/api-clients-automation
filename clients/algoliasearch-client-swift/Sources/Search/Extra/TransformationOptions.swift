//
//  TransformationOptions.swift
//
//  Configuration options for the ingestion transporter used by `*WithTransformation` helpers
//  on SearchClient.
//
//  When passed to SearchClient, an ingestion transporter is created using Ingestion API
//  defaults (25 s timeouts, region-derived hosts, no compression). Pass `clientOptions` to
//  override specific defaults; any field left unset keeps the Ingestion API default.
//  Credentials are always taken from the parent SearchClient.
//
//  See https://www.algolia.com/doc/libraries/sdk/methods/ingestion

#if canImport(AlgoliaCore)
    import AlgoliaCore
#endif
import Foundation

public struct TransformationOptions {
    /// The Algolia region for the Ingestion API. Required.
    public let region: Region

    /// Optional overrides forwarded to the ingestion transporter. Fields left unset keep the
    /// Ingestion API defaults (25 s timeouts, region-derived hosts, no compression).
    public var clientOptions: ClientOptions?

    /// - parameter region: The Algolia region for the Ingestion API (`Region.us` or `Region.eu`). Required.
    /// - parameter clientOptions: Optional overrides forwarded to the ingestion transporter.
    public init(region: Region, clientOptions: ClientOptions? = nil) {
        self.region = region
        self.clientOptions = clientOptions
    }
}

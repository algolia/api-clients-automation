//
//  TransformationOptions.swift
//
//
//  Created by Algolia on 26/05/2026.
//

#if canImport(AlgoliaCore)
    import AlgoliaCore
#endif
import AlgoliaIngestion
import Foundation

/// Options used to configure the ingestion transporter that powers the
/// `*WithTransformation` helpers on ``SearchClient``.
///
/// Pass an instance to ``SearchClient/withTransformation(appID:apiKey:transformationOptions:)``
/// at construction time, or to ``SearchClient/setTransformationOptions(_:)`` to (re)configure
/// an existing client. The ingestion transporter is built eagerly from the Ingestion API defaults
/// (region-derived hosts, 25s read/write timeouts, no default compression); only fields explicitly
/// set on ``configuration`` override those defaults. The parent ``SearchClientConfiguration`` is
/// never forwarded to the ingestion transporter.
///
/// - SeeAlso: https://www.algolia.com/doc/libraries/sdk/methods/ingestion/
public struct TransformationOptions {
    /// Algolia region for the Ingestion API. Required.
    public let region: Region

    /// Optional pre-built ingestion configuration. When `nil`, a default
    /// ``IngestionClientConfiguration`` is created using the parent client's credentials and the
    /// region supplied above.
    public let configuration: IngestionClientConfiguration?

    /// - parameter region: Algolia region for the Ingestion API (`.us` or `.eu`). Required.
    /// - parameter configuration: Optional pre-built ``IngestionClientConfiguration``. Fields on
    ///   the configuration override the Ingestion API defaults; the parent search client's
    ///   configuration is never copied across.
    public init(region: Region, configuration: IngestionClientConfiguration? = nil) throws {
        if region.rawValue.isEmpty {
            throw AlgoliaError.runtimeError(
                "`region` is required in `transformationOptions`. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion/"
            )
        }

        self.region = region
        self.configuration = configuration
    }
}

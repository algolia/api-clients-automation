using System;

namespace Algolia.Search.Clients;

/// <summary>
/// Configuration options for the ingestion transporter used by <c>*WithTransformation</c> helpers.
/// An ingestion transporter is eagerly created using Ingestion API defaults (25 s timeouts,
/// region-derived hosts, no compression). Pass an <see cref="IngestionConfig"/> to override specific
/// defaults; only the fields set there replace the Ingestion API defaults.
/// See https://www.algolia.com/doc/libraries/sdk/methods/ingestion
/// </summary>
public class TransformationOptions
{
  /// <summary>The ingestion region ("eu" or "us"). Required.</summary>
  public string Region { get; }

  /// <summary>
  /// Optional ingestion config forwarded to the ingestion transporter.
  /// Only fields explicitly set here replace the Ingestion API defaults.
  /// </summary>
  public IngestionConfig IngestionConfig { get; }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <exception cref="ArgumentException">Thrown when region is null or empty.</exception>
  public TransformationOptions(string region)
    : this(region, null) { }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <param name="ingestionConfig">
  /// Optional <see cref="IngestionConfig"/> forwarded to the ingestion transporter.
  /// Only fields explicitly set here override the Ingestion API defaults.
  /// </param>
  /// <exception cref="ArgumentException">Thrown when region is null or empty.</exception>
  public TransformationOptions(string region, IngestionConfig ingestionConfig)
  {
    if (string.IsNullOrWhiteSpace(region))
    {
      throw new ArgumentException(
        "region is required in TransformationOptions. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion"
      );
    }
    Region = region;
    IngestionConfig = ingestionConfig;
  }
}

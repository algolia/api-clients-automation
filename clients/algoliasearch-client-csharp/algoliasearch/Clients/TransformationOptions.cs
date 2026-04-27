using System;

namespace Algolia.Search.Clients;

/// <summary>
/// Configuration options for the ingestion transporter used by <c>*WithTransformation</c> helpers.
/// An ingestion transporter is eagerly created using the provided region and Ingestion API defaults
/// (25 s timeouts, region-derived hosts, no compression). Pass an <see cref="ClientOptions"/>
/// to override specific defaults; only the fields set there replace the Ingestion API defaults.
/// Credentials are always taken from the parent <see cref="SearchClient"/>.
/// See https://www.algolia.com/doc/libraries/sdk/methods/ingestion
/// </summary>
public class TransformationOptions
{
  /// <summary>The ingestion region ("eu" or "us"). Required.</summary>
  public string Region { get; }

  /// <summary>
  /// Optional overrides for the ingestion transporter.
  /// Only fields explicitly set here replace the Ingestion API defaults.
  /// Credentials and region are always taken from the parent <see cref="TransformationOptions"/>.
  /// </summary>
  public ClientOptions ClientOptions { get; }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <exception cref="ArgumentException">Thrown when region is null or whitespace.</exception>
  public TransformationOptions(string region)
    : this(region, null) { }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <param name="clientOptions">
  /// Optional <see cref="ClientOptions"/> overrides for the ingestion transporter.
  /// Only fields explicitly set here override the Ingestion API defaults.
  /// </param>
  /// <exception cref="ArgumentException">Thrown when region is null or whitespace.</exception>
  public TransformationOptions(string region, ClientOptions clientOptions)
  {
    if (string.IsNullOrWhiteSpace(region))
    {
      throw new ArgumentException(
        "region is required in TransformationOptions. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion"
      );
    }
    Region = region;
    ClientOptions = clientOptions;
  }
}

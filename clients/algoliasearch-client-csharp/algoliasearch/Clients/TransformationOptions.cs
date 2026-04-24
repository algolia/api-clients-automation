using System;

namespace Algolia.Search.Clients;

/// <summary>
/// Configuration options for the ingestion transporter used by <c>*WithTransformation</c> helpers.
/// An ingestion transporter is eagerly created using Ingestion API defaults (25 s timeouts,
/// region-derived hosts, no compression). Pass a <see cref="ClientOptions"/> to override specific
/// defaults; only the fields set there replace the Ingestion API defaults.
/// See https://www.algolia.com/doc/libraries/sdk/methods/ingestion
/// </summary>
public class TransformationOptions
{
  /// <summary>The ingestion region ("eu" or "us"). Required.</summary>
  public string Region { get; }

  /// <summary>
  /// Optional overrides forwarded to the ingestion transporter.
  /// Only fields explicitly set here replace the Ingestion API defaults.
  /// </summary>
  public ClientOptions ClientOptions { get; }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <exception cref="ArgumentException">Thrown when region is null or empty.</exception>
  public TransformationOptions(string region)
    : this(region, null) { }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <param name="clientOptions">
  /// Optional <see cref="ClientOptions"/> forwarded to the ingestion transporter.
  /// Only fields explicitly set here override the Ingestion API defaults.
  /// </param>
  /// <exception cref="ArgumentException">Thrown when region is null or empty.</exception>
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

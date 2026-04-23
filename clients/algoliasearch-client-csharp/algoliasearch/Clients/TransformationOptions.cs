using System;
using System.Collections.Generic;
using Algolia.Search.Models.Common;
using Algolia.Search.Transport;

namespace Algolia.Search.Clients;

/// <summary>
/// Options for the ingestion transporter used by the transformation pipeline.
/// When set in <see cref="SearchConfig"/>, the ingestion transporter is eagerly
/// created using Ingestion API defaults. Only fields explicitly provided here
/// override those defaults.
/// See https://www.algolia.com/doc/libraries/sdk/methods/ingestion
/// </summary>
public class TransformationOptions
{
  /// <summary>The ingestion region ("eu" or "us"). Required.</summary>
  public string Region { get; }

  /// <summary>Overrides the ingestion transporter read timeout (default: 25s).</summary>
  public TimeSpan? ReadTimeout { get; set; }

  /// <summary>Overrides the ingestion transporter write timeout (default: 25s).</summary>
  public TimeSpan? WriteTimeout { get; set; }

  /// <summary>Overrides the ingestion transporter connect timeout (default: 25s).</summary>
  public TimeSpan? ConnectTimeout { get; set; }

  /// <summary>Overrides the ingestion transporter compression type (default: none).</summary>
  public CompressionType? Compression { get; set; }

  /// <summary>Overrides the ingestion transporter hosts.</summary>
  public List<StatefulHost> CustomHosts { get; set; }

  /// <summary>Overrides the ingestion transporter default headers.</summary>
  public Dictionary<string, string> DefaultHeaders { get; set; }

  /// <param name="region">The ingestion region ("eu" or "us"). Required.</param>
  /// <exception cref="ArgumentException">Thrown when region is null or empty.</exception>
  public TransformationOptions(string region)
  {
    if (string.IsNullOrWhiteSpace(region))
    {
      throw new ArgumentException(
        "region is required in TransformationOptions. See https://www.algolia.com/doc/libraries/sdk/methods/ingestion"
      );
    }
    Region = region;
  }
}

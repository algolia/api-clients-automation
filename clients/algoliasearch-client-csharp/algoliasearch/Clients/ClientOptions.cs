using System;
using System.Collections.Generic;
using Algolia.Search.Models.Common;
using Algolia.Search.Transport;

namespace Algolia.Search.Clients;

/// <summary>
/// Optional overrides for the ingestion transporter created by <c>*WithTransformation</c> helpers.
/// Only fields explicitly set here replace the Ingestion API defaults (25 s timeouts, region-derived hosts, no compression).
/// Credentials and region are always taken from the parent <see cref="TransformationOptions"/>.
/// See https://www.algolia.com/doc/libraries/sdk/methods/ingestion
/// </summary>
public class ClientOptions
{
  /// <summary>Override the default ingestion hosts.</summary>
  public List<StatefulHost> CustomHosts { get; set; }

  /// <summary>Override the default connect timeout (25 s).</summary>
  public TimeSpan? ConnectTimeout { get; set; }

  /// <summary>Override the default read timeout (25 s).</summary>
  public TimeSpan? ReadTimeout { get; set; }

  /// <summary>Override the default write timeout (25 s).</summary>
  public TimeSpan? WriteTimeout { get; set; }

  /// <summary>Override the default compression (none).</summary>
  public CompressionType? Compression { get; set; }

  /// <summary>Override the default headers.</summary>
  public Dictionary<string, string> DefaultHeaders { get; set; }
}

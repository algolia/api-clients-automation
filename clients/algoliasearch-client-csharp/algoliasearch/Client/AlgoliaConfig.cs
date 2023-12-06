using System.Collections.Generic;
using System.Reflection;
using Algolia.Search.Transport;

namespace Algolia.Search.Client
{
  /// <summary>
  /// Algolia's client configuration
  /// </summary>
  public abstract class AlgoliaConfig
  {
    private static readonly string ClientVersion =
      typeof(AlgoliaConfig).GetTypeInfo().Assembly.GetName().Version.ToString();

    /// <summary>
    /// Create a new Algolia's configuration for the given credentials
    /// </summary>
    /// <param name="applicationId">Your application ID</param>
    /// <param name="apiKey">Your API Key</param>
    public AlgoliaConfig(string applicationId, string apiKey)
    {
      AppId = applicationId;
      ApiKey = apiKey;

      DefaultHeaders = new Dictionary<string, string>
      {
        { Defaults.AlgoliaApplicationHeader, AppId },
        { Defaults.AlgoliaApiKeyHeader, ApiKey },
        { Defaults.UserAgentHeader, $"Algolia For Csharp {ClientVersion}" },
        { Defaults.Connection, Defaults.KeepAlive },
      };
    }

    /// <summary>
    /// The application ID
    /// </summary>
    /// <returns></returns>
    public string AppId { get; }

    /// <summary>
    /// The admin API Key
    /// </summary>
    /// <returns></returns>
    public string ApiKey { get; }

    /// <summary>
    /// Configurations hosts
    /// </summary>
    public List<StatefulHost> CustomHosts { get; set; }

    /// <summary>
    /// Algolia's default headers.
    /// Will be sent for every request
    /// </summary>
    public Dictionary<string, string> DefaultHeaders { get; set; }

    /// <summary>
    /// Save methods batch size
    /// </summary>
    public int BatchSize { get; set; } = 1000;

    /// <summary>
    /// Set the read timeout in seconds for all requests
    /// </summary>
    public int? ReadTimeout { get; set; }

    /// <summary>
    /// Set the read timeout in seconds for all requests
    /// </summary>
    public int? WriteTimeout { get; set; }

    /// <summary>
    /// Compression for outgoing http requests  <see cref="CompressionType"/>
    /// </summary>
    public virtual CompressionType Compression { get; protected set; }

    /// <summary>
    /// Configurations hosts
    /// </summary>
    protected internal List<StatefulHost> DefaultHosts { get; set; }
  }
}
